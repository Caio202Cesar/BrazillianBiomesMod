package com.brbiomesmod.Climate;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClimateSetup {

    @SubscribeEvent
    public static void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SummerHeatRegistry.register("minecraft:ocean", SummerHeat.WARM);
            SummerHeatRegistry.register("minecraft:plains", SummerHeat.HOT);
            SummerHeatRegistry.register("minecraft:desert", SummerHeat.SCHORCHING);
            SummerHeatRegistry.register("minecraft:mountains", SummerHeat.COOLER);
            SummerHeatRegistry.register("minecraft:forest", SummerHeat.HOT);
            SummerHeatRegistry.register("minecraft:taiga", SummerHeat.COOLER);
            SummerHeatRegistry.register("minecraft:swamp", SummerHeat.HOT);
            SummerHeatRegistry.register("minecraft:frozen_ocean", SummerHeat.ICY);
            SummerHeatRegistry.register("minecraft:frozen_river", SummerHeat.ICY);
            SummerHeatRegistry.register("minecraft:snowy_tundra", SummerHeat.ICY);
            SummerHeatRegistry.register("minecraft:snowy_mountains", SummerHeat.ICY);
            SummerHeatRegistry.register("minecraft:mushroom_fields", SummerHeat.HOT);
            SummerHeatRegistry.register("minecraft:mushroom_fields_shore", SummerHeat.HOT);
            SummerHeatRegistry.register("minecraft:beach", SummerHeat.HOT);
            SummerHeatRegistry.register("minecraft:desert_hills", SummerHeat.HOT);
            SummerHeatRegistry.register("minecraft:wooded_hills", SummerHeat.WARM);
            SummerHeatRegistry.register("minecraft:taiga_hills", SummerHeat.COOLER);
            SummerHeatRegistry.register("minecraft:mountain_edge", SummerHeat.COOLER);
            SummerHeatRegistry.register("minecraft:jungle", SummerHeat.HOT);
            SummerHeatRegistry.register("minecraft:jungle_hills", SummerHeat.HOT);
            SummerHeatRegistry.register("minecraft:jungle_edge", SummerHeat.HOT);
            SummerHeatRegistry.register("minecraft:deep_ocean", SummerHeat.WARM);
            SummerHeatRegistry.register("minecraft:stone_shore", SummerHeat.COOLER);
            SummerHeatRegistry.register("minecraft:snowy_beach", SummerHeat.ICY);
            SummerHeatRegistry.register("minecraft:birch_forest", SummerHeat.WARM);
            SummerHeatRegistry.register("minecraft:birch_forest_hills", SummerHeat.WARM);
            SummerHeatRegistry.register("minecraft:dark_forest", SummerHeat.WARM);
            SummerHeatRegistry.register("minecraft:snowy_taiga", SummerHeat.ICY);
            SummerHeatRegistry.register("minecraft:snowy_taiga_hills", SummerHeat.ICY);
            SummerHeatRegistry.register("minecraft:giant_tree_taiga", SummerHeat.COOLER);
            SummerHeatRegistry.register("minecraft:giant_tree_taiga_hills", SummerHeat.COOLER);
            SummerHeatRegistry.register("minecraft:wooded_mountains", SummerHeat.COOLER);
            SummerHeatRegistry.register("minecraft:savanna", SummerHeat.HOT);
            SummerHeatRegistry.register("minecraft:savanna_plateau", SummerHeat.HOT);
            SummerHeatRegistry.register("minecraft:badlands", SummerHeat.SCHORCHING);
            SummerHeatRegistry.register("minecraft:wooded_badlands_plateau", SummerHeat.WARM);
            SummerHeatRegistry.register("minecraft:badlands_plateau", SummerHeat.WARM);
            SummerHeatRegistry.register("minecraft:warm_ocean", SummerHeat.HOT);
            SummerHeatRegistry.register("minecraft:lukewarm_ocean", SummerHeat.WARM);
            SummerHeatRegistry.register("minecraft:cold_ocean", SummerHeat.COOLER);
            SummerHeatRegistry.register("minecraft:deep_warm_ocean", SummerHeat.HOT);
            SummerHeatRegistry.register("minecraft:deep_lukewarm_ocean", SummerHeat.WARM);
            SummerHeatRegistry.register("minecraft:deep_cold_ocean", SummerHeat.COOLER);
            SummerHeatRegistry.register("minecraft:deep_frozen_ocean", SummerHeat.TUNDRA_COLD);

            SummerHeatRegistry.register("caiocesarbiomes:bamboo_subtropical_laurel_jungle", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:bunya_subtropical_laurel_forest", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:bunya_subtropical_laurel_jungle", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:bunya_subtropical_seasonal_forest", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:coastal_subtropical_desert", SummerHeat.WARM);
            SummerHeatRegistry.register("caiocesarbiomes:coastal_subtropical_desert_lomas", SummerHeat.WARM);
            SummerHeatRegistry.register("caiocesarbiomes:tropical_pine_island", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:cork_oak_savanna", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:dry_tropical_beach", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:eucalyptus_plains", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:eucalyptus_sahel", SummerHeat.SCHORCHING);
            SummerHeatRegistry.register("caiocesarbiomes:eucalyptus_savanna", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:ginkgo_forest", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:gravel_tundra", SummerHeat.TUNDRA_COLD);
            SummerHeatRegistry.register("caiocesarbiomes:hemiboreal_forest", SummerHeat.WARM);
            SummerHeatRegistry.register("caiocesarbiomes:hemiboreal_steppe", SummerHeat.WARM);
            SummerHeatRegistry.register("caiocesarbiomes:hot_mediterranean_beach", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:humid_subtropical_beach", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:humid_subtropical_pine_forest", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:inactive_volcanic_site", SummerHeat.WARM);
            SummerHeatRegistry.register("caiocesarbiomes:japanese_maple_grove", SummerHeat.WARM); //Japanese maples wouldn't thrive well in such way (without the forest's protection) in a hot summer climate
            SummerHeatRegistry.register("caiocesarbiomes:lush_southern_tundra", SummerHeat.TUNDRA_COLD);
            SummerHeatRegistry.register("caiocesarbiomes:mediterranean_conifer_savanna", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:mediterranean_conifer_savanna_beach", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:mediterranean_oak_woodland", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:mediterranean_scrubland", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:monsoon_ficus_tropical_forest", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:oleander_gardens", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:montane_laurel_grove", SummerHeat.WARM);
            SummerHeatRegistry.register("caiocesarbiomes:olive_grove", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:pewen_coniferous_grove", SummerHeat.WARM);
            SummerHeatRegistry.register("caiocesarbiomes:sahel", SummerHeat.SCHORCHING);
            SummerHeatRegistry.register("caiocesarbiomes:salt_desert", SummerHeat.SCHORCHING);
            SummerHeatRegistry.register("caiocesarbiomes:socotra_dryland", SummerHeat.SCHORCHING);
            SummerHeatRegistry.register("caiocesarbiomes:southern_beech_forest", SummerHeat.COOLER);
            SummerHeatRegistry.register("caiocesarbiomes:stony_mediterranean_shore", SummerHeat.SCHORCHING);
            SummerHeatRegistry.register("caiocesarbiomes:subtropical_eucalyptus_dry_forest", SummerHeat.WARM);
            SummerHeatRegistry.register("caiocesarbiomes:subtropical_extreme_hills", SummerHeat.WARM);
            SummerHeatRegistry.register("caiocesarbiomes:subtropical_laurel_forest", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:subtropical_laurel_jungle", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:subtropical_pine_dry_forest", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:subtropical_seasonal_forest", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:temperate_desert", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:temperate_rainforest", SummerHeat.WARM);
            SummerHeatRegistry.register("caiocesarbiomes:tropical_bamboo_marsh", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:tropical_beach", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:tropical_desert", SummerHeat.SCHORCHING);
            SummerHeatRegistry.register("caiocesarbiomes:tropical_eucalyptus_dry_forest", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:tropical_seasonal_forest", SummerHeat.HOT);
            SummerHeatRegistry.register("caiocesarbiomes:tussock_tundra", SummerHeat.TUNDRA_COLD);
            SummerHeatRegistry.register("caiocesarbiomes:volcanic_site", SummerHeat.SCHORCHING);

            SummerHeatRegistry.register("brbiomesmod:amazon_rainforest", SummerHeat.HOT);
            SummerHeatRegistry.register("brbiomesmod:amazon_varzea_forest", SummerHeat.HOT);
            SummerHeatRegistry.register("brbiomesmod:araucaria_plateau", SummerHeat.WARM);
            SummerHeatRegistry.register("brbiomesmod:atlantic_forest", SummerHeat.HOT);
            SummerHeatRegistry.register("brbiomesmod:atlantic_forest_hills", SummerHeat.WARM);
            SummerHeatRegistry.register("brbiomesmod:butia_pampas", SummerHeat.HOT);
            SummerHeatRegistry.register("brbiomesmod:caatinga_shrubland", SummerHeat.SCHORCHING);
            SummerHeatRegistry.register("brbiomesmod:cerrado", SummerHeat.HOT);
            SummerHeatRegistry.register("brbiomesmod:pampas_hills", SummerHeat.WARM);
            SummerHeatRegistry.register("brbiomesmod:dunas_restinga", SummerHeat.HOT);
            SummerHeatRegistry.register("brbiomesmod:pampas", SummerHeat.HOT);
            SummerHeatRegistry.register("brbiomesmod:pampas_coastal_fields", SummerHeat.HOT);
            SummerHeatRegistry.register("brbiomesmod:pantanal", SummerHeat.HOT);
            SummerHeatRegistry.register("brbiomesmod:restinga_beach", SummerHeat.HOT);

        });
    }
}
