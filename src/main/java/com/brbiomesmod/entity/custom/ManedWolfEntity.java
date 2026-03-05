package com.brbiomesmod.entity.custom;

import com.brbiomesmod.entity.ModEntityTypes;
import com.brbiomesmod.item.ModItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.List;

public class ManedWolfEntity extends AnimalEntity {

    public ManedWolfEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 16.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.30D)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 24.0D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 3.0D);
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
            this.goalSelector.addGoal(8, new MeleeAttackGoal(this, 1.25D, true));


            // TARGETS
            this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
            this.targetSelector.addGoal(2,
                    new NearestAttackableTargetGoal<>(this, ChickenEntity.class, true));
            this.targetSelector.addGoal(3,
                    new NearestAttackableTargetGoal<>(this, RabbitEntity.class, true));
            this.targetSelector.addGoal(4,
                    new NearestAttackableTargetGoal<>(this, FoxEntity.class, false));
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
}
