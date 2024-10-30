package com.brbiomesmod.world.biomes.Util;

import com.brbiomesmod.world.biomes.AmazonRainforestBiome;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

import static net.minecraftforge.common.BiomeDictionary.Type.*;
import static net.minecraftforge.common.BiomeDictionary.Type.CONIFEROUS;

public class ModBiomeGeneration {
    public static void generateBiomes() {
        addBiome(AmazonRainforestBiome.AMAZON_RAINFOREST.get(), BiomeManager.BiomeType.WARM, 26, DENSE, FOREST,
                HOT, JUNGLE, LUSH, WET);
    }

    private static void addBiome(Biome biome, BiomeManager.BiomeType type, int weight, BiomeDictionary.Type... types) {
        RegistryKey<Biome> key = RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES,
                Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome)));

        BiomeDictionary.addTypes(key, types);
        BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(key, weight));
    }
}

