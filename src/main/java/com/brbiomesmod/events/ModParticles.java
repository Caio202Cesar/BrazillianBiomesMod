package com.brbiomesmod.events;

import com.brbiomesmod.BrazillianBiomesMod;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, BrazillianBiomesMod.MOD_ID);

    public static final RegistryObject<BasicParticleType> LATEX_DRIP =
            PARTICLES.register("latex_drip", () -> new BasicParticleType(false));
}
