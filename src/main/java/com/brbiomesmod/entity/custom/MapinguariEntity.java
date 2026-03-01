package com.brbiomesmod.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.List;

import static net.minecraft.entity.ai.attributes.AttributeModifierMap.createMutableAttribute;

public class MapinguariEntity extends MonsterEntity {
    public MapinguariEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MonsterEntity.func_234295_eP_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 200.0D)      // 100 hearts
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.20D)   // slow but steady
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 18.0D)    // strong but not 1-hit kill
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 40.0D)     // forest predator range
                .createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 1.0D) // immovable
                .createMutableAttribute(Attributes.ARMOR, 10.0D);           // thick hide

    }

    @Override
    protected void registerGoals() {
        super.registerGoals();

        // ===== CORE =====
        this.goalSelector.addGoal(0, new SwimGoal(this));

        // ===== COMBAT =====
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0.9D, true));

        // ===== TARGETING =====
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2,
                new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false,
                        player -> this.getDistance(player) < 12.0D));
        // ===== BEHAVIOR =====
        this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 0.6D));
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.world.isRemote) {

            double maxRadius = 8.0D;

            List<PlayerEntity> players = this.world.getEntitiesWithinAABB(
                    PlayerEntity.class,
                    this.getBoundingBox().grow(maxRadius)
            );

            for (PlayerEntity player : players) {

                if (player.isCreative() || player.isSpectator()) continue;

                double distance = this.getDistance(player);

                // 🔥 Strong stench scaling by distance
                if (distance <= 3.0D) {
                    player.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 60, 1));
                    player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 100, 2));
                    player.addPotionEffect(new EffectInstance(Effects.NAUSEA, 100, 1));
                }
                else if (distance <= 5.0D) {
                    player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 100, 1));
                    player.addPotionEffect(new EffectInstance(Effects.NAUSEA, 100, 0));
                }
                else {
                    player.addPotionEffect(new EffectInstance(Effects.NAUSEA, 60, 0));
                }
            }

            // 🫁 Heavy breathing every 2 seconds
            if (this.ticksExisted % 40 == 0) {
                this.playSound(SoundEvents.ENTITY_RAVAGER_AMBIENT, 2.0F, 0.45F + this.rand.nextFloat() * 0.1F
                );
            }
        }
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player)
    {
        return 40 + this.world.rand.nextInt(10);
    }

    @Override
    public SoundEvent getAmbientSound() {
        this.playSound(SoundEvents.ENTITY_RAVAGER_AMBIENT, 2.0F, 1.0F);
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        this.playSound(SoundEvents.ENTITY_RAVAGER_HURT, 1.0F, 1.7F);
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        this.playSound(SoundEvents.ENTITY_RAVAGER_DEATH, 0.7F, 2.0F);
        return null;
    }

    @Override
    public Vector3d getLeashStartPosition() {
        return new Vector3d(5.0D, (5.5F * this.getEyeHeight()), (this.getWidth() * 5.4F));
    }
}
