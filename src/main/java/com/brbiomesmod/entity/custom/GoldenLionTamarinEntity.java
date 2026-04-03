package com.brbiomesmod.entity.custom;

import com.brbiomesmod.entity.ModEntityTypes;
import com.brbiomesmod.item.ModItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ShoulderRidingEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.List;

public class GoldenLionTamarinEntity extends ShoulderRidingEntity {

    public GoldenLionTamarinEntity(EntityType<? extends ShoulderRidingEntity> type, World worldIn) {
        super(type, worldIn);
        this.setTamed(false);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 8.0D)   // Small animal
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.32D) // Fast
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 16.0D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 2.0D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));

        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.3D, true));
        this.targetSelector.addGoal(1,
                (new HurtByTargetGoal(this))
                        .setCallsForHelp(GoldenLionTamarinEntity.class));

        this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 1.0D, 5.0F, 1.0F, true));
        this.goalSelector.addGoal(3, new LandOnOwnersShoulderGoal(this));

        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.2D, Ingredient.fromItems(ModItems.JABUTICABA.get()), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));

        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(8, new FollowMobGoal(this, 1.0D, 5.0F, 2.0F));

    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {

        boolean result = super.attackEntityFrom(source, amount);

        if (!this.world.isRemote && this.isChild()) {

            Entity attacker = source.getTrueSource();

            if (attacker instanceof LivingEntity) {

                List<GoldenLionTamarinEntity> adults =
                        this.world.getEntitiesWithinAABB(
                                GoldenLionTamarinEntity.class,
                                this.getBoundingBox().grow(8.0D),
                                entity -> !entity.isChild()
                        );

                for (GoldenLionTamarinEntity adult : adults) {
                    adult.setAttackTarget((LivingEntity) attacker);
                }
            }
        }

        return result;
    }

    public void setTamed(boolean tamed) {
        super.setTamed(tamed);
        if (tamed) {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(12.0D);
            this.setHealth(12.0F);
        } else {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(8.0D);
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.isChild() && !this.isPassenger()) {

            List<GoldenLionTamarinEntity> adults =
                    this.world.getEntitiesWithinAABB(
                            GoldenLionTamarinEntity.class,
                            this.getBoundingBox().grow(4.0D),
                            entity -> !entity.isChild()
                    );

            if (!adults.isEmpty()) {
                GoldenLionTamarinEntity parent = adults.get(0);

                if (this.getDistance(parent) < 2.0F) {
                    this.startRiding(parent, true);
                }
            }
        }
    }

    @Override
    public ActionResultType getEntityInteractionResult(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);

        if (stack.getItem() == ModItems.JABUTICABA.get()) {

            if (!this.world.isRemote) {
                if (this.rand.nextInt(3) == 0) {
                    this.setTamedBy(player);
                    this.world.setEntityState(this, (byte)7);
                } else {
                    this.world.setEntityState(this, (byte)6);
                }
            }

            if (!player.abilities.isCreativeMode) {
                stack.shrink(1);
            }

            return ActionResultType.SUCCESS;
        }

        return super.getEntityInteractionResult(player, hand);
    }

    @Override
    public void updatePassenger(Entity passenger) {
        super.updatePassenger(passenger);

        if (passenger instanceof GoldenLionTamarinEntity) {

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
        return ModEntityTypes.GOLDEN_LION_TAMARIN_ENTITY.get().create(world);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() == ModItems.JABUTICABA.get();
    }

    @Override
    public boolean canBreed() {
        return super.canBreed() && !this.isChild() && !this.isPassenger();
    }

    @Override
    public boolean isOnLadder() {
        return this.collidedHorizontally;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_FOX_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_FOX_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_FOX_DEATH;
    }
}
