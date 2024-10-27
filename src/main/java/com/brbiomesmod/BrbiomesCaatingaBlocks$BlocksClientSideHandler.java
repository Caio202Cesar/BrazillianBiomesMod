package com.brbiomesmod;

import com.brbiomesmod.block.BullNettlePlant;
import com.brbiomesmod.block.CassavaPlant;
import com.brbiomesmod.block.XananaFlower;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(
        bus = Mod.EventBusSubscriber.Bus.MOD,
        value = {Dist.CLIENT}
)

public class BrbiomesCaatingaBlocks$BlocksClientSideHandler {
    public BrbiomesCaatingaBlocks$BlocksClientSideHandler() {
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {

        XananaFlower.registerRenderLayer();
        BullNettlePlant.registerRenderLayer();
    }
}
