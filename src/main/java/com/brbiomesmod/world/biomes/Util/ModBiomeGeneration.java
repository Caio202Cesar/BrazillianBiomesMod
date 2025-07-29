package com.brbiomesmod.world.biomes.Util;

import com.brbiomesmod.world.biomes.*;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

import static net.minecraftforge.common.BiomeDictionary.Type.*;

public class ModBiomeGeneration {
    public static void generateBiomes() {
        addBiome(AmazonRainforestBiome.AMAZON_RAINFOREST.get(), BiomeManager.BiomeType.DESERT, 27, OVERWORLD, HOT, DENSE, FOREST,
                JUNGLE, LUSH, WET, SPOOKY);
        addBiome(AraucariaPlateauBiome.ARAUCARIA_PLATEAU.get(), BiomeManager.BiomeType.WARM, 18, OVERWORLD, DENSE, FOREST, PLATEAU,
                RARE, CONIFEROUS, LUSH, WET, MOUNTAIN);
        addBiome(PantanalBiome.PANTANAL.get(), BiomeManager.BiomeType.DESERT, 18, OVERWORLD, HOT, SPARSE, SAVANNA, RARE, WET, SWAMP,
                PLAINS, LUSH);
        addBiome(CaatingaBiome.CAATINGA.get(), BiomeManager.BiomeType.DESERT, 25, OVERWORLD, HOT, SPARSE, SAVANNA, DRY, SANDY);
        addBiome(DunasRestingaBiome.DUNAS_RESTINGA.get(), BiomeManager.BiomeType.DESERT, 25, OVERWORLD, HOT, DENSE, SANDY);
        addBiome(PampasBiome.PAMPAS.get(), BiomeManager.BiomeType.WARM, 25, OVERWORLD, SPARSE, PLAINS);
        addBiome(ButiaPampasBiome.BUTIA_PAMPAS.get(), BiomeManager.BiomeType.WARM, 25, OVERWORLD, SPARSE, PLAINS);
        addBiome(PampasCoastalFields.PAMPAS_COASTAL_FIELDS.get(), BiomeManager.BiomeType.WARM, 25, OVERWORLD, SPARSE, PLAINS, BEACH, SANDY);
        addBiome(CerradoBiome.CERRADO.get(), BiomeManager.BiomeType.DESERT, 25, HOT, OVERWORLD, SPARSE, SAVANNA);
        addBiome(RestingaBeachBiome.RESTINGA_BEACH.get(), BiomeManager.BiomeType.DESERT, 25, OVERWORLD, HOT, BEACH, SANDY);
        addBiome(AtlanticForestBiome.ATLANTIC_FOREST.get(), BiomeManager.BiomeType.DESERT, 25, OVERWORLD, HOT, DENSE, FOREST, LUSH);
        addBiome(AtlanticForestHillsBiome.ATLANTIC_FOREST_HILLS.get(), BiomeManager.BiomeType.DESERT, 18, OVERWORLD, HOT, DENSE, WET, HILLS,
                MAGICAL, FOREST, LUSH);
        addBiome(AmazonVarzeaForestBiome.AMAZON_VARZEA_FOREST.get(), BiomeManager.BiomeType.DESERT, 23, OVERWORLD, HOT, DENSE, FOREST,
                JUNGLE, LUSH, WET, SWAMP);


    }

    private static void addBiome(Biome biome, BiomeManager.BiomeType type, int weight, BiomeDictionary.Type... types) {
        RegistryKey<Biome> key = RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES,
                Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome)));

        BiomeDictionary.addTypes(key, types);
        BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(key, weight));
    }
}

