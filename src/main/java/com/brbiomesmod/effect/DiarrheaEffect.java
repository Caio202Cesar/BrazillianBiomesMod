package com.brbiomesmod.effect;

import com.brbiomesmod.Util.ModSoundEvents;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundCategory;
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

        // Diarrhea sounds
        player.world.playSound(
                null,
                player.getPosX(),
                player.getPosY(),
                player.getPosZ(),
                ModSoundEvents.FART1.get(),
                SoundCategory.PLAYERS,
                1.0F,
                0.9F + player.world.rand.nextFloat() * 0.2F
        );

        player.world.playSound(
                null,
                player.getPosX(),
                player.getPosY(),
                player.getPosZ(),
                ModSoundEvents.FART2.get(),
                SoundCategory.PLAYERS,
                1.0F,
                0.9F + player.world.rand.nextFloat() * 0.2F
        );

        player.world.playSound(
                null,
                player.getPosX(),
                player.getPosY(),
                player.getPosZ(),
                ModSoundEvents.LITTLE_FART.get(),
                SoundCategory.PLAYERS,
                1.0F,
                0.9F + player.world.rand.nextFloat() * 0.2F
        );

        player.world.playSound(
                null,
                player.getPosX(),
                player.getPosY(),
                player.getPosZ(),
                ModSoundEvents.WET_FART.get(),
                SoundCategory.PLAYERS,
                1.0F,
                0.9F + player.world.rand.nextFloat() * 0.2F
        );
    }

    @Override
    public boolean isReady(int duration, int amplifier) {

        int interval;

        switch (amplifier) {
            case 0:
                interval = 1000; // 50 seconds
                break;

            case 1:
                interval = 500;  // 25 seconds
                break;

            default:
                interval = 200;  // 10 seconds
                break;
        }

        return duration % interval == 0;
    }
}
