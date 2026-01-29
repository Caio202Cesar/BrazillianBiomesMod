package com.brbiomesmod;

import com.brbiomesmod.Util.CompostingHelper;
import com.brbiomesmod.block.TreesGroup;
import com.brbiomesmod.item.ModItems;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = "brbiomesmod", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ComposterHandler {
    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            CompostingHelper.registerCompostable(ModItems.CASHEW_FRUIT.get(), 0.65F);
            CompostingHelper.registerCompostable(ModItems.CASHEW_APPLE.get(), 0.65F);
            CompostingHelper.registerCompostable(ModItems.CASHEWNUT.get(), 0.65F);
            CompostingHelper.registerCompostable(ModItems.JUA_BERRIES.get(), 0.3F);
            CompostingHelper.registerCompostable(ModItems.CAMBUCI.get(), 0.65F);
            CompostingHelper.registerCompostable(ModItems.PITANGA.get(), 0.3F);
            CompostingHelper.registerCompostable(ModItems.BLACK_PITANGA.get(), 0.3F);
            CompostingHelper.registerCompostable(ModItems.RIO_GRANDE_CHERRY.get(), 0.3F);
            CompostingHelper.registerCompostable(ModItems.UMBU.get(), 0.65F);
            CompostingHelper.registerCompostable(ModItems.MANGABA_FRUITS.get(), 0.65F);
            CompostingHelper.registerCompostable(ModItems.WOLF_APPLE.get(), 0.65F);
            CompostingHelper.registerCompostable(ModItems.PARANA_PINE_CONE.get(), 0.85F);
            CompostingHelper.registerCompostable(ModItems.GUARANA_FRUIT.get(), 0.65F);
            CompostingHelper.registerCompostable(ModItems.GUARANA_SEEDS.get(), 0.3F);
            CompostingHelper.registerCompostable(ModItems.BRAZILNUT_FRUIT.get(), 0.85F);
            CompostingHelper.registerCompostable(ModItems.BRAZILNUT_WITH_PELL.get(), 0.65F);
            CompostingHelper.registerCompostable(ModItems.PELLED_BRAZILNUT.get(), 0.65F);
            CompostingHelper.registerCompostable(ModItems.SAPUCAIA_FRUIT.get(), 0.85F);
            CompostingHelper.registerCompostable(ModItems.SAPUCAIA_NUTS.get(), 0.65F);
            CompostingHelper.registerCompostable(ModItems.SAPUCAIA_NUTS.get(), 0.65F);
            CompostingHelper.registerCompostable(ModItems.CASSAVA.get(), 0.65F);
            CompostingHelper.registerCompostable(ModItems.ACAI_BERRIES.get(), 0.3F);
            CompostingHelper.registerCompostable(ModItems.CUPUACU.get(), 0.65F);
            CompostingHelper.registerCompostable(ModItems.BURITI.get(), 0.65F);
            CompostingHelper.registerCompostable(ModItems.PINK_PEEPER.get(), 0.3F);
            CompostingHelper.registerCompostable(ModItems.PINEAPPLE_GUAVA.get(), 0.65F);
            CompostingHelper.registerCompostable(ModItems.JABUTICABA.get(), 0.3F);
            CompostingHelper.registerCompostable(ModItems.PASSIONFRUIT.get(), 0.65F);
            CompostingHelper.registerCompostable(ModItems.TURK_TURBAN_BERRIES.get(), 0.3F);
            CompostingHelper.registerCompostable(ModItems.CAGAITA.get(), 0.65F);
            CompostingHelper.registerCompostable(ModItems.CECROPIA_FRUITS.get(), 0.65F);
            CompostingHelper.registerCompostable(ModItems.BACURI.get(), 0.65F);
            CompostingHelper.registerCompostable(ModItems.MONKEY_CAJARANA.get(), 0.65F);
            CompostingHelper.registerCompostable(ModItems.MATE_LEAF.get(), 0.3F);
            CompostingHelper.registerCompostable(ModItems.CAMU_CAMU_FRUITS.get(), 0.3F);
            CompostingHelper.registerCompostable(ModItems.YELLOW_IPE_FALL_LEAVES.get(), 0.3F);
            CompostingHelper.registerCompostable(ModItems.YELLOW_IPE_SAPLING.get(), 0.3F);
            CompostingHelper.registerCompostable(ModItems.APRICOT_IPE_BLOSSOM.get(), 0.3F);
            CompostingHelper.registerCompostable(ModItems.APRICOT_IPE_LEAVES.get(), 0.3F);
            CompostingHelper.registerCompostable(ModItems.APRICOT_IPE_FALL_LEAVES.get(), 0.3F);
            CompostingHelper.registerCompostable(ModItems.APRICOT_IPE_SAPLING.get(), 0.3F);
            CompostingHelper.registerCompostable(ModItems.WHITE_IPE_BLOSSOM.get(), 0.3F);
            CompostingHelper.registerCompostable(ModItems.WHITE_IPE_LEAVES.get(), 0.3F);
            CompostingHelper.registerCompostable(ModItems.WHITE_IPE_FALL_LEAVES.get(), 0.3F);
            CompostingHelper.registerCompostable(ModItems.WHITE_IPE_SAPLING.get(), 0.3F);
            CompostingHelper.registerCompostable(ModItems.JELLY_PALM_SAPLING.get(), 0.3F);


        });
    }
}
