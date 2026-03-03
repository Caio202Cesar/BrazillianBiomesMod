package com.brbiomesmod.world.gen;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.entity.ModEntityTypes;
import com.brbiomesmod.world.biomes.*;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BrazillianBiomesMod.MOD_ID)
public class ModEntityGeneration {

    @SubscribeEvent
    public static void onEntitySpawn(final BiomeLoadingEvent event) {

        // Safety check
        if (event.getName() == null) return;

        // Compare registry names properly
        if (event.getName().equals(AmazonRainforestBiome.AMAZON_RAINFOREST.get().getRegistryName())) {

            event.getSpawns().getSpawner(
                    ModEntityTypes.MAPINGUARI_ENTITY.get().getClassification()
            ).add(new MobSpawnInfo.Spawners(
                    ModEntityTypes.MAPINGUARI_ENTITY.get(),
                    12, // weight
                    1,  // min
                    2   // max
            ));
        }

        if (event.getName().equals(CerradoBiome.CERRADO.get().getRegistryName())) {

            event.getSpawns().getSpawner(
                    ModEntityTypes.TOCO_TOUCAN_ENTITY.get().getClassification()
            ).add(new MobSpawnInfo.Spawners(
                    ModEntityTypes.TOCO_TOUCAN_ENTITY.get(),
                    50, // weight
                    3,  // min
                    10   // max
            ));
        }

        if (event.getName().equals(PantanalBiome.PANTANAL.get().getRegistryName())) {

            event.getSpawns().getSpawner(
                    ModEntityTypes.TOCO_TOUCAN_ENTITY.get().getClassification()
            ).add(new MobSpawnInfo.Spawners(
                    ModEntityTypes.TOCO_TOUCAN_ENTITY.get(),
                    50, // weight
                    3,  // min
                    10   // max
            ));
        }

        if (event.getName().equals(PantanalBiome.PANTANAL.get().getRegistryName())) {

            event.getSpawns().getSpawner(
                    ModEntityTypes.TOCO_TOUCAN_ENTITY.get().getClassification()
            ).add(new MobSpawnInfo.Spawners(
                    ModEntityTypes.TOCO_TOUCAN_ENTITY.get(),
                    50, // weight
                    3,  // min
                    10   // max
            ));
        }

        if (event.getName().equals(AtlanticForestBiome.ATLANTIC_FOREST.get().getRegistryName())) {

            event.getSpawns().getSpawner(
                    ModEntityTypes.TOCO_TOUCAN_ENTITY.get().getClassification()
            ).add(new MobSpawnInfo.Spawners(
                    ModEntityTypes.TOCO_TOUCAN_ENTITY.get(),
                    50, // weight
                    3,  // min
                    10   // max
            ));
        }

        if (event.getName().equals(AtlanticForestHillsBiome.ATLANTIC_FOREST_HILLS.get().getRegistryName())) {

            event.getSpawns().getSpawner(
                    ModEntityTypes.TOCO_TOUCAN_ENTITY.get().getClassification()
            ).add(new MobSpawnInfo.Spawners(
                    ModEntityTypes.TOCO_TOUCAN_ENTITY.get(),
                    50, // weight
                    3,  // min
                    10   // max
            ));
        }

        if (event.getName().equals(AtlanticForestHillsBiome.ATLANTIC_FOREST_HILLS.get().getRegistryName())) {

            event.getSpawns().getSpawner(
                    ModEntityTypes.TOCO_TOUCAN_ENTITY.get().getClassification()
            ).add(new MobSpawnInfo.Spawners(
                    ModEntityTypes.TOCO_TOUCAN_ENTITY.get(),
                    50, // weight
                    3,  // min
                    10   // max
            ));
        }
    }
}
