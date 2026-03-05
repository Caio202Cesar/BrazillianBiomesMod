package com.brbiomesmod.entity.custom;

import com.brbiomesmod.entity.ModEntityTypes;
import com.brbiomesmod.item.ModItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.List;

import static net.minecraft.entity.ai.attributes.AttributeModifierMap.createMutableAttribute;

public class ManedWolfEntity extends AnimalEntity {

    public ManedWolfEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 20.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.35D)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 24.0D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 3.0D)
                .createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 0.5D);

    }

    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.4D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D,
                Ingredient.fromItems(ModItems.WOLF_APPLE.get()), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(2,
                new AvoidEntityGoal<>(this,
                        PlayerEntity.class,
                        10.0F,
                        1.3D,
                        1.5D,
                        (player) -> !this.isStarving())); //It will not attack player unless its starving or is attacked.
        this.goalSelector.addGoal(4, new ManedWolfStalkGoal(this));
        this.goalSelector.addGoal(4, new PounceAttackGoal(this, 1.3D, true));
        this.goalSelector.addGoal(8, new MeleeAttackGoal(this, 1.25D, true));

        this.goalSelector.addGoal(5, new EatWolfAppleGoal(this));

        this.targetSelector.addGoal(1,
                (new HurtByTargetGoal(this))
                        .setCallsForHelp(ManedWolfEntity.class));

        // TARGETS
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2,
                new NearestAttackableTargetGoal<>(this, ChickenEntity.class, true));
        this.targetSelector.addGoal(3,
                new NearestAttackableTargetGoal<>(this, RabbitEntity.class, true));
    }

    private int hunger = 0;
    private static final int STARVING_TIME = 24000; // 1 Minecraft day

    @Override
    public void livingTick() {
        super.livingTick();

        hunger++;

        if(hunger > STARVING_TIME) {
            hunger = STARVING_TIME;
        }
    }

    public boolean isStarving() {
        return hunger >= STARVING_TIME;
    }

    public void eatFood() {
        hunger = 0;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {

        boolean result = super.attackEntityFrom(source, amount);

        if (!this.world.isRemote && this.isChild()) {

            Entity attacker = source.getTrueSource();

            if (attacker instanceof LivingEntity) {

                List<ManedWolfEntity> adults =
                        this.world.getEntitiesWithinAABB(
                                ManedWolfEntity.class,
                                this.getBoundingBox().grow(8.0D),
                                entity -> !entity.isChild()
                        );

                for (ManedWolfEntity adult : adults) {
                    adult.setAttackTarget((LivingEntity) attacker);
                }
            }
        }

        return result;
    }

    @Override
    public void tick() {
        super.tick();

        if (this.isChild() && !this.isPassenger()) {

            List<ManedWolfEntity> adults =
                    this.world.getEntitiesWithinAABB(
                            ManedWolfEntity.class,
                            this.getBoundingBox().grow(4.0D),
                            entity -> !entity.isChild()
                    );

            if (!adults.isEmpty()) {
                ManedWolfEntity parent = adults.get(0);

                if (this.getDistance(parent) < 2.0F) {
                    this.startRiding(parent, true);
                }
            }
        }

        LivingEntity target = this.getAttackTarget();

        if(target != null && this.getDistance(target) < 2.0F) {
            this.attackEntityAsMob(target);
        }
    }

    @Override
    public void updatePassenger(Entity passenger) {
        super.updatePassenger(passenger);

        if (passenger instanceof ManedWolfEntity) {

            float yOffset = this.isChild() ? 0.3F : 0.6F;

            passenger.setPosition(
                    this.getPosX(),
                    this.getPosY() + yOffset,
                    this.getPosZ()
            );
        }
    }

    @Nullable
    @Override
    public AgeableEntity createChild(ServerWorld world, AgeableEntity mate) {
        return ModEntityTypes.MANED_WOLF_ENTITY.get().create(world);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() == ModItems.WOLF_APPLE.get();
    }

    @Override
    public boolean canBreed() {
        return super.canBreed() && !this.isChild() && !this.isPassenger();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_WOLF_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_WOLF_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_WOLF_DEATH;
    }

    public class ManedWolfStalkGoal extends Goal {

        private final ManedWolfEntity wolf;
        private LivingEntity target;
        private int stalkTime;

        public ManedWolfStalkGoal(ManedWolfEntity wolf) {
            this.wolf = wolf;
        }

        @Override
        public boolean shouldExecute() {
            target = wolf.getAttackTarget();

            if(target == null) return false;
            if(!target.isAlive()) return false;

            return wolf.getDistance(target) < 12;
        }

        @Override
        public void startExecuting() {
            stalkTime = 0;
        }

        @Override
        public void tick() {

            wolf.getNavigator().tryMoveToEntityLiving(target, 0.6D);

            stalkTime++;

            // After stalking for a while → jump attack
            if(stalkTime > 40) {
                wolf.jumpAttack(target);
            }
        }
    }

    public void jumpAttack(LivingEntity target) {

        double dx = target.getPosX() - this.getPosX();
        double dz = target.getPosZ() - this.getPosZ();

        double distance = MathHelper.sqrt(dx * dx + dz * dz);

        this.setMotion(
                dx / distance * 0.6D,
                0.6D,
                dz / distance * 0.6D
        );

        this.velocityChanged = true;
    }

    public class PounceAttackGoal extends MeleeAttackGoal {

        public PounceAttackGoal(CreatureEntity entity, double speed, boolean memory) {
            super(entity, speed, memory);
        }

        @Override
        protected void checkAndPerformAttack(LivingEntity mob, double distSq) {

            if (distSq < 6.0D && mob.isOnGround()) {

                mob.setMotion(
                        mob.getMotion().add(0, 0.6D, 0)
                );

                mob.attackEntityAsMob(mob);
            }
        }
    }

    public class EatWolfAppleGoal extends Goal {

        private final ManedWolfEntity wolf;

        public EatWolfAppleGoal(ManedWolfEntity wolf) {
            this.wolf = wolf;
        }

        public boolean shouldExecute() {

            List<ItemEntity> items = wolf.world.getEntitiesWithinAABB(
                    ItemEntity.class,
                    wolf.getBoundingBox().grow(6),
                    item -> item.getItem().getItem() == ModItems.WOLF_APPLE.get()
            );

            return !items.isEmpty();
        }

        public void tick() {

            List<ItemEntity> items = wolf.world.getEntitiesWithinAABB(
                    ItemEntity.class,
                    wolf.getBoundingBox().grow(6)
            );

            for (ItemEntity item : items) {

                if (item.getItem().getItem() == ModItems.WOLF_APPLE.get()) {

                    wolf.getNavigator().tryMoveToEntityLiving(item, 1.0D);

                    if (wolf.getDistance(item) < 2) {
                        wolf.eatFood();
                        item.remove();
                    }
                }
            }
        }
    }
}
