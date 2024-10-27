package com.brbiomesmod;

import com.brbiomesmod.block.AcaiBunchBlock;
import com.brbiomesmod.block.CassavaPlant;
import com.brbiomesmod.block.Saplings.CashewSapling;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(
        bus = Mod.EventBusSubscriber.Bus.MOD,
        value = {Dist.CLIENT}
)

public class BrbiomesAmazonRainforestBlocks$BlocksClientSideHandler {
    public BrbiomesAmazonRainforestBlocks$BlocksClientSideHandler() {
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        CassavaPlant.registerRenderLayer();
        AcaiBunchBlock.registerRenderLayer();

        CashewSapling.registerRenderLayer();
    }
}
