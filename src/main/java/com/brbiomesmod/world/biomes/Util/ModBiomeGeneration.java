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
        addBiome(AmazonRainforestBiome.AMAZON_RAINFOREST.get(), BiomeManager.BiomeType.WARM, 27, OVERWORLD, HOT, DENSE, FOREST,
                JUNGLE, LUSH, WET, SPOOKY);
        addBiome(AraucariaPlateauBiome.ARAUCARIA_PLATEAU.get(), BiomeManager.BiomeType.WARM, 7, OVERWORLD, DENSE, FOREST, PLATEAU,
                RARE, CONIFEROUS, LUSH, WET, MOUNTAIN);
        addBiome(PantanalBiome.PANTANAL.get(), BiomeManager.BiomeType.WARM, 14, OVERWORLD, HOT, SPARSE, SAVANNA, RARE, WET, SWAMP,
                PLAINS, LUSH);
        addBiome(CaatingaBiome.CAATINGA.get(), BiomeManager.BiomeType.DESERT, 25, OVERWORLD, HOT, SPARSE, SAVANNA, DRY, SANDY);
        addBiome(DunasRestingaBiome.DUNAS_RESTINGA.get(), BiomeManager.BiomeType.WARM, 25, OVERWORLD, HOT, DENSE, DRY, SANDY);
    }

    private static void addBiome(Biome biome, BiomeManager.BiomeType type, int weight, BiomeDictionary.Type... types) {
        RegistryKey<Biome> key = RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES,
                Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome)));

        BiomeDictionary.addTypes(key, types);
        BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(key, weight));
    }
}

