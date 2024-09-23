package com.brbiomesmod.world.gen;

import com.brbiomesmod.world.biomes.ModBiomes;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

import static com.brbiomesmod.world.biomes.ModBiomes.*;
import static net.minecraftforge.common.BiomeDictionary.Type.*;
import static net.minecraftforge.common.BiomeManager.addBiome;

public class BrazillianBiomeGeneration {
    public static void generateBiomes() {
        addBiome(CAATINGA_BIOME.get(), BiomeManager.BiomeType.DESERT, 20, HOT, DRY, SPARSE, SAVANNA, SANDY);

    }

    private static void addBiome(Biome biome, BiomeManager.BiomeType type, int weight, BiomeDictionary.Type... types) {
        RegistryKey<Biome> key = RegistryKey.create(ForgeRegistries.Keys.BIOMES,
                Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome)));

        BiomeDictionary.addTypes(key, types);
        BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(key, weight));
    }
}
