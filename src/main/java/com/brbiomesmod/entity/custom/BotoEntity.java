package com.brbiomesmod.entity.custom;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.DolphinEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class BotoEntity extends DolphinEntity {

    public BotoEntity(EntityType<? extends DolphinEntity> type, World worldIn) {
        super(type, worldIn);
    }

    // =========================
    // ATTRIBUTES
    // =========================
    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return DolphinEntity.func_234190_eK_() // vanilla dolphin base
                .createMutableAttribute(Attributes.MAX_HEALTH, 10.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 3.0D);
    }

    // =========================
    // GOALS
    // =========================
    @Override
    protected void registerGoals() {
        super.registerGoals();

        // If you want to ADD goals, do it carefully:
        this.goalSelector.addGoal(6, new MeleeAttackGoal(this, 1.2D, true));
    }

    // =========================
    // INTERACTION
    // =========================
    @Override
    public ActionResultType getEntityInteractionResult(PlayerEntity player, Hand hand) {
        return super.getEntityInteractionResult(player, hand);
    }

    // =========================
    // SOUNDS
    // =========================
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_DOLPHIN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_DOLPHIN_DEATH;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.isInWater()
                ? SoundEvents.ENTITY_DOLPHIN_AMBIENT_WATER
                : SoundEvents.ENTITY_DOLPHIN_AMBIENT;
    }

    @Override
    protected SoundEvent getSplashSound() {
        return SoundEvents.ENTITY_DOLPHIN_SPLASH;
    }

    @Override
    protected SoundEvent getSwimSound() {
        return SoundEvents.ENTITY_DOLPHIN_SWIM;
    }
}