package com.brbiomesmod;

import com.brbiomesmod.block.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(
        bus = Mod.EventBusSubscriber.Bus.MOD,
        value = {Dist.CLIENT}
)

public class BrbiomesAtlanticForestBlocks$BlocksClientSideHandler {
    public BrbiomesAtlanticForestBlocks$BlocksClientSideHandler() {
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        PassionFruitVine.registerRenderLayer();
        AristolochiaVine.registerRenderLayer();
        EpiphytePlant.registerRenderLayer();
        OrchidPlant.registerRenderLayer();
    }
}
