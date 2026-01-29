package com.brbiomesmod;

import com.brbiomesmod.Util.CompostingHelper;
import com.brbiomesmod.item.ModItems;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = "brbiomesmod", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ComposterHandler {
    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            CompostingHelper.registerCompostable(ModItems.ACAI_BERRIES.get(), 0.3F);
            CompostingHelper.registerCompostable(ModItems.WOLF_APPLE.get(), 0.65F);
        });
    }
}
