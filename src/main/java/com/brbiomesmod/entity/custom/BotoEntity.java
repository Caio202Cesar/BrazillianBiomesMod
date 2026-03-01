package com.brbiomesmod.entity.custom;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.DolphinLookController;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.GuardianEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.DolphinEntity;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Predicate;

public class BotoEntity extends DolphinEntity {

    public BotoEntity(EntityType<? extends DolphinEntity> type, World worldIn) {
        super(type, worldIn);
        this.moveController = new MoveHelperController(this);
        this.navigator = new SwimmerPathNavigator(this, world);
        this.setCanPickUpLoot(true);
    }

    private static final EntityPredicate field_213810_bA = (new EntityPredicate()).setDistance(10.0D).allowFriendlyFire().allowInvulnerable().setIgnoresLineOfSight();
    private static final DataParameter<Boolean> GOT_FISH = EntityDataManager.createKey(BotoEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> MOISTNESS = EntityDataManager.createKey(BotoEntity.class, DataSerializers.VARINT);

    protected void registerData() {
        super.registerData();
        this.dataManager.register(GOT_FISH, false);
        this.dataManager.register(MOISTNESS, 2400);
    }


    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 10.0D).
                createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.25F).
                createMutableAttribute(Attributes.ATTACK_DAMAGE, 3.0D);

    }

    protected PathNavigator createNavigator(World worldIn) {
        return new SwimmerPathNavigator(this, worldIn);
    }


    public boolean attackEntityAsMob(Entity entityIn) {
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
        if (flag) {
            this.applyEnchantments(this, entityIn);
            this.playSound(SoundEvents.ENTITY_DOLPHIN_ATTACK, 1.0F, 1.0F);
        }

        return flag;
    }

    public int getMaxAir() {
        return 4800;
    }

    protected int determineNextAir(int currentAir) {
        return this.getMaxAir();
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.3F;
    }

    /**
     * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
     * use in wolves.
     */
    public int getVerticalFaceSpeed() {
        return 1;
    }

    public int getHorizontalFaceSpeed() {
        return 1;
    }

    protected boolean canBeRidden(Entity entityIn) {
        return true;
    }

    public boolean canPickUpItem(ItemStack itemstackIn) {
        EquipmentSlotType equipmentslottype = MobEntity.getSlotForItemStack(itemstackIn);
        if (!this.getItemStackFromSlot(equipmentslottype).isEmpty()) {
            return false;
        } else {
            return equipmentslottype == EquipmentSlotType.MAINHAND && super.canPickUpItem(itemstackIn);
        }
    }

    protected void updateEquipmentIfNeeded(ItemEntity itemEntity) {
        if (this.getItemStackFromSlot(EquipmentSlotType.MAINHAND).isEmpty()) {
            ItemStack itemstack = itemEntity.getItem();
            if (this.canEquipItem(itemstack)) {
                this.triggerItemPickupTrigger(itemEntity);
                this.setItemStackToSlot(EquipmentSlotType.MAINHAND, itemstack);
                this.inventoryHandsDropChances[EquipmentSlotType.MAINHAND.getIndex()] = 2.0F;
                this.onItemPickup(itemEntity, itemstack.getCount());
                itemEntity.remove();
            }
        }
    }

    @Override
    public boolean canTriggerWalking() {
        return false;
    }

    @Override
    public boolean func_230285_a_(Fluid fluidIn) {
        return fluidIn == Fluids.WATER;
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new BreatheAirGoal(this));
        this.goalSelector.addGoal(0, new FindWaterGoal(this));
        this.goalSelector.addGoal(2, new BotoEntity.SwimWithPlayerGoal(this, 4.0D));
        this.goalSelector.addGoal(4, new RandomSwimmingGoal(this, 1.0D, 10));
        this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(5, new DolphinJumpGoal(this, 10));
        this.goalSelector.addGoal(6, new MeleeAttackGoal(this, (double)1.2F, true));
        this.goalSelector.addGoal(8, new BotoEntity.PlayWithItemsGoal());
        this.goalSelector.addGoal(8, new FollowBoatGoal(this));
        this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, GuardianEntity.class, 8.0F, 1.0D, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, GuardianEntity.class)).setCallsForHelp());
    }

    public boolean canBeLeashedTo(PlayerEntity player) {
        return true;
    }

    static class MoveHelperController extends MovementController {
        private final BotoEntity botoEntity;

        public MoveHelperController(BotoEntity botoIn) {
            super(botoIn);
            this.botoEntity = botoIn;
        }

        public void tick() {
            if (this.botoEntity.isInWater()) {
                this.botoEntity.setMotion(this.botoEntity.getMotion().add(0.0D, 0.005D, 0.0D));
            }

            if (this.action == MovementController.Action.MOVE_TO && !this.botoEntity.getNavigator().noPath()) {
                double d0 = this.posX - this.botoEntity.getPosX();
                double d1 = this.posY - this.botoEntity.getPosY();
                double d2 = this.posZ - this.botoEntity.getPosZ();
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                if (d3 < (double)2.5000003E-7F) {
                    this.mob.setMoveForward(0.0F);
                } else {
                    float f = (float)(MathHelper.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
                    this.botoEntity.rotationYaw = this.limitAngle(this.botoEntity.rotationYaw, f, 10.0F);
                    this.botoEntity.renderYawOffset = this.botoEntity.rotationYaw;
                    this.botoEntity.rotationYawHead = this.botoEntity.rotationYaw;
                    float f1 = (float)(this.speed * this.botoEntity.getAttributeValue(Attributes.MOVEMENT_SPEED));
                    if (this.botoEntity.isInWater()) {
                        this.botoEntity.setAIMoveSpeed(f1 * 0.02F);
                        float f2 = -((float)(MathHelper.atan2(d1, (double)MathHelper.sqrt(d0 * d0 + d2 * d2)) * (double)(180F / (float)Math.PI)));
                        f2 = MathHelper.clamp(MathHelper.wrapDegrees(f2), -85.0F, 85.0F);
                        this.botoEntity.rotationPitch = this.limitAngle(this.botoEntity.rotationPitch, f2, 5.0F);
                        float f3 = MathHelper.cos(this.botoEntity.rotationPitch * ((float)Math.PI / 180F));
                        float f4 = MathHelper.sin(this.botoEntity.rotationPitch * ((float)Math.PI / 180F));
                        this.botoEntity.moveForward = f3 * f1;
                        this.botoEntity.moveVertical = -f4 * f1;
                    } else {
                        this.botoEntity.setAIMoveSpeed(f1 * 0.1F);
                    }
                }

            } else {
                this.botoEntity.setAIMoveSpeed(0.0F);
                this.botoEntity.setMoveStrafing(0.0F);
                this.botoEntity.setMoveVertical(0.0F);
                this.botoEntity.setMoveForward(0.0F);
            }
        }
    }

    public void tick() {
        super.tick();
        if (this.isAIDisabled()) {
            this.setAir(this.getMaxAir());
        } else {
            if (this.isInWaterRainOrBubbleColumn()) {
                this.setMoistness(2400);
            } else {
                this.setMoistness(this.getMoistness() - 1);
                if (this.getMoistness() <= 0) {
                    this.attackEntityFrom(DamageSource.DRYOUT, 1.0F);
                }

                if (this.onGround) {
                    this.setMotion(this.getMotion().add((double)((this.rand.nextFloat() * 2.0F - 1.0F) * 0.2F), 0.5D, (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 0.2F)));
                    this.rotationYaw = this.rand.nextFloat() * 360.0F;
                    this.onGround = false;
                    this.isAirBorne = true;
                }
            }

            if (this.world.isRemote && this.isInWater() && this.getMotion().lengthSquared() > 0.03D) {
                Vector3d vector3d = this.getLook(0.0F);
                float f = MathHelper.cos(this.rotationYaw * ((float)Math.PI / 180F)) * 0.3F;
                float f1 = MathHelper.sin(this.rotationYaw * ((float)Math.PI / 180F)) * 0.3F;
                float f2 = 1.2F - this.rand.nextFloat() * 0.7F;

                for(int i = 0; i < 2; ++i) {
                    this.world.addParticle(ParticleTypes.DOLPHIN, this.getPosX() - vector3d.x * (double)f2 + (double)f, this.getPosY() - vector3d.y, this.getPosZ() - vector3d.z * (double)f2 + (double)f1, 0.0D, 0.0D, 0.0D);
                    this.world.addParticle(ParticleTypes.DOLPHIN, this.getPosX() - vector3d.x * (double)f2 - (double)f, this.getPosY() - vector3d.y, this.getPosZ() - vector3d.z * (double)f2 - (double)f1, 0.0D, 0.0D, 0.0D);
                }
            }

        }
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 38) {
            this.func_208401_a(ParticleTypes.HAPPY_VILLAGER);
        } else {
            super.handleStatusUpdate(id);
        }

    }

    @OnlyIn(Dist.CLIENT)
    private void func_208401_a(IParticleData p_208401_1_) {
        for(int i = 0; i < 7; ++i) {
            double d0 = this.rand.nextGaussian() * 0.01D;
            double d1 = this.rand.nextGaussian() * 0.01D;
            double d2 = this.rand.nextGaussian() * 0.01D;
            this.world.addParticle(p_208401_1_, this.getPosXRandom(1.0D), this.getPosYRandom() + 0.2D, this.getPosZRandom(1.0D), d0, d1, d2);
        }

    }

    protected ActionResultType getEntityInteractionResult(PlayerEntity playerIn, Hand hand) {
        ItemStack itemstack = playerIn.getHeldItem(hand);
        if (!itemstack.isEmpty() && itemstack.getItem().isIn(ItemTags.FISHES)) {
            if (!this.world.isRemote) {
                this.playSound(SoundEvents.ENTITY_DOLPHIN_EAT, 1.0F, 1.0F);
            }

            this.setGotFish(true);
            if (!playerIn.abilities.isCreativeMode) {
                itemstack.shrink(1);
            }

            return ActionResultType.func_233537_a_(this.world.isRemote);
        } else {
            return super.getEntityInteractionResult(playerIn, hand);
        }
    }

    static class SwimWithPlayerGoal extends Goal {
        private final DolphinEntity dolphin;
        private final double speed;
        private PlayerEntity targetPlayer;

        SwimWithPlayerGoal(DolphinEntity dolphinIn, double speedIn) {
            this.dolphin = dolphinIn;
            this.speed = speedIn;
            this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            this.targetPlayer = this.dolphin.world.getClosestPlayer(BotoEntity.field_213810_bA, this.dolphin);
            if (this.targetPlayer == null) {
                return false;
            } else {
                return this.targetPlayer.isSwimming() && this.dolphin.getAttackTarget() != this.targetPlayer;
            }
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting() {
            return this.targetPlayer != null && this.targetPlayer.isSwimming() && this.dolphin.getDistanceSq(this.targetPlayer) < 256.0D;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            this.targetPlayer.addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 100));
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask() {
            this.targetPlayer = null;
            this.dolphin.getNavigator().clearPath();
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            this.dolphin.getLookController().setLookPositionWithEntity(this.targetPlayer, (float)(this.dolphin.getHorizontalFaceSpeed() + 20), (float)this.dolphin.getVerticalFaceSpeed());
            if (this.dolphin.getDistanceSq(this.targetPlayer) < 6.25D) {
                this.dolphin.getNavigator().clearPath();
            } else {
                this.dolphin.getNavigator().tryMoveToEntityLiving(this.targetPlayer, this.speed);
            }

            if (this.targetPlayer.isSwimming() && this.targetPlayer.world.rand.nextInt(6) == 0) {
                this.targetPlayer.addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 100));
            }

        }
    }

    class PlayWithItemsGoal extends Goal {
        private int field_205154_b;

        private PlayWithItemsGoal() {
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            if (this.field_205154_b > BotoEntity.this.ticksExisted) {
                return false;
            } else {
                List<ItemEntity> list = BotoEntity.this.world.getEntitiesWithinAABB(ItemEntity.class, BotoEntity.this.getBoundingBox().grow(8.0D, 8.0D, 8.0D), DolphinEntity.ITEM_SELECTOR);
                return !list.isEmpty() || !BotoEntity.this.getItemStackFromSlot(EquipmentSlotType.MAINHAND).isEmpty();
            }
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            List<ItemEntity> list = BotoEntity.this.world.getEntitiesWithinAABB(ItemEntity.class, BotoEntity.this.getBoundingBox().grow(8.0D, 8.0D, 8.0D), DolphinEntity.ITEM_SELECTOR);
            if (!list.isEmpty()) {
                BotoEntity.this.getNavigator().tryMoveToEntityLiving(list.get(0), (double)1.2F);
                BotoEntity.this.playSound(SoundEvents.ENTITY_DOLPHIN_PLAY, 1.0F, 1.0F);
            }

            this.field_205154_b = 0;
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask() {
            ItemStack itemstack = BotoEntity.this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
            if (!itemstack.isEmpty()) {
                this.func_220810_a(itemstack);
                BotoEntity.this.setItemStackToSlot(EquipmentSlotType.MAINHAND, ItemStack.EMPTY);
                this.field_205154_b = BotoEntity.this.ticksExisted + BotoEntity.this.rand.nextInt(100);
            }

        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            List<ItemEntity> list = BotoEntity.this.world.getEntitiesWithinAABB(ItemEntity.class, BotoEntity.this.getBoundingBox().grow(8.0D, 8.0D, 8.0D), DolphinEntity.ITEM_SELECTOR);
            ItemStack itemstack = BotoEntity.this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
            if (!itemstack.isEmpty()) {
                this.func_220810_a(itemstack);
                BotoEntity.this.setItemStackToSlot(EquipmentSlotType.MAINHAND, ItemStack.EMPTY);
            } else if (!list.isEmpty()) {
                BotoEntity.this.getNavigator().tryMoveToEntityLiving(list.get(0), (double)1.2F);
            }

        }

        private void func_220810_a(ItemStack p_220810_1_) {
            if (!p_220810_1_.isEmpty()) {
                double d0 = BotoEntity.this.getPosYEye() - (double)0.3F;
                ItemEntity itementity = new ItemEntity(BotoEntity.this.world, BotoEntity.this.getPosX(), d0, BotoEntity.this.getPosZ(), p_220810_1_);
                itementity.setPickupDelay(40);
                itementity.setThrowerId(BotoEntity.this.getUniqueID());
                float f = 0.3F;
                float f1 = BotoEntity.this.rand.nextFloat() * ((float)Math.PI * 2F);
                float f2 = 0.02F * BotoEntity.this.rand.nextFloat();
                itementity.setMotion((double)(0.3F * -MathHelper.sin(BotoEntity.this.rotationYaw * ((float)Math.PI / 180F)) *
                        MathHelper.cos(BotoEntity.this.rotationPitch * ((float)Math.PI / 180F)) + MathHelper.cos(f1) * f2),
                        (double)(0.3F * MathHelper.sin(BotoEntity.this.rotationPitch * ((float)Math.PI / 180F)) * 1.5F), (double)(0.3F *
                                MathHelper.cos(BotoEntity.this.rotationYaw * ((float)Math.PI / 180F)) *
                                MathHelper.cos(BotoEntity.this.rotationPitch * ((float)Math.PI / 180F)) + MathHelper.sin(f1) * f2));
                BotoEntity.this.world.addEntity(itementity);
            }
        }
    }

    @Nullable
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        this.setAir(this.getMaxAir());
        this.rotationPitch = 0.0F;
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_DOLPHIN_HURT;
    }

    @Nullable
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_DOLPHIN_DEATH;
    }

    @Nullable
    protected SoundEvent getAmbientSound() {
        return this.isInWater() ? SoundEvents.ENTITY_DOLPHIN_AMBIENT_WATER : SoundEvents.ENTITY_DOLPHIN_AMBIENT;
    }

    protected SoundEvent getSplashSound() {
        return SoundEvents.ENTITY_DOLPHIN_SPLASH;
    }

    protected SoundEvent getSwimSound() {
        return SoundEvents.ENTITY_DOLPHIN_SWIM;
    }

    protected boolean closeToTarget() {
        BlockPos blockpos = this.getNavigator().getTargetPos();
        return blockpos != null ? blockpos.withinDistance(this.getPositionVec(), 12.0D) : false;
    }

}
