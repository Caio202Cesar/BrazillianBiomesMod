package com.brbiomesmod.effect;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.world.server.ServerWorld;

public class DiarrheaEffect extends Effect {
    public DiarrheaEffect(EffectType typeIn, int liquidColorIn) {
        super(EffectType.HARMFUL, 0x964b00);
    }

    @Override
    public void performEffect(LivingEntity entity, int amplifier) {
        if (!(entity instanceof PlayerEntity) || entity.world.isRemote) {
            return;
        }

        PlayerEntity player = (PlayerEntity) entity;

        player.addPotionEffect(new EffectInstance(
                Effects.SLOWNESS,
                60,
                0
        ));

        player.addPotionEffect(new EffectInstance(
                Effects.HUNGER,
                60,
                1
        ));

        player.getFoodStats().addExhaustion(
                2.0F + amplifier
        );

        ((ServerWorld) player.world).spawnParticle(
                new BlockParticleData(
                        ParticleTypes.BLOCK,
                        Blocks.BROWN_TERRACOTTA.getDefaultState()
                ),
                player.getPosX(),
                player.getPosY() + 0.35,
                player.getPosZ(),
                12,
                0.2,
                0.1,
                0.2,
                0.02
        );
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return duration % 20 == 0;
    }
}
