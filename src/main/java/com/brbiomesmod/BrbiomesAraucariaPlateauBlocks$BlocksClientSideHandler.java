package com.brbiomesmod;

import com.brbiomesmod.block.XaximPlant;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(
        bus = Mod.EventBusSubscriber.Bus.MOD,
        value = {Dist.CLIENT}
)

public class BrbiomesAraucariaPlateauBlocks$BlocksClientSideHandler {
    public BrbiomesAraucariaPlateauBlocks$BlocksClientSideHandler() {
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        XaximPlant.registerRenderLayer();
    }
}
