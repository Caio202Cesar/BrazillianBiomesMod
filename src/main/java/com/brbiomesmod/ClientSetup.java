package com.brbiomesmod;

import com.brbiomesmod.Client.render.SandboxSeedRenderer;
import com.brbiomesmod.events.LatexDripParticle;
import com.brbiomesmod.events.ModEntities;
import com.brbiomesmod.events.ModParticles;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = BrazillianBiomesMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {

    @SubscribeEvent
    public static void registerParticles(ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particles.registerFactory(
                ModParticles.LATEX_DRIP.get(),
                LatexDripParticle.Factory::new
        );
    }

    @SubscribeEvent
    public static void registerRenderers(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(
                ModEntities.SANDBOX_SEED.get(),
                manager -> new SandboxSeedRenderer(manager, Minecraft.getInstance().getItemRenderer())
        );
    }
}
