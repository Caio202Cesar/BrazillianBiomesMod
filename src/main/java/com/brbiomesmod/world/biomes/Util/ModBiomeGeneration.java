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
        addBiome(AmazonRainforestBiome.AMAZON_RAINFOREST.get(), BiomeManager.BiomeType.DESERT, 25, OVERWORLD, HOT, JUNGLE, DENSE, SPOOKY);

        addBiome(AraucariaPlateauBiome.ARAUCARIA_PLATEAU.get(), BiomeManager.BiomeType.WARM, 25, OVERWORLD);

        addBiome(PantanalBiome.PANTANAL.get(), BiomeManager.BiomeType.DESERT, 25, OVERWORLD, HOT, SPARSE, SAVANNA);

        addBiome(CaatingaBiome.CAATINGA.get(), BiomeManager.BiomeType.DESERT, 25, OVERWORLD, HOT, SPARSE, SAVANNA, DRY, SANDY);

        addBiome(DunasRestingaBiome.DUNAS_RESTINGA.get(), BiomeManager.BiomeType.DESERT, 25, OVERWORLD, HOT, SANDY);

        addBiome(PampasBiome.PAMPAS.get(), BiomeManager.BiomeType.WARM, 25, OVERWORLD, SPARSE, PLAINS);

        //More a variant than a sub-biome
        addBiome(PampasCoastalFields.PAMPAS_COASTAL_FIELDS.get(), BiomeManager.BiomeType.WARM, 25, OVERWORLD, SPARSE, PLAINS); //It is a major biome instead just a sub-biome.

        addBiome(CerradoBiome.CERRADO.get(), BiomeManager.BiomeType.DESERT, 25, HOT, OVERWORLD, SPARSE, SAVANNA);

        addBiome(AtlanticForestBiome.ATLANTIC_FOREST.get(), BiomeManager.BiomeType.DESERT_LEGACY, 25, OVERWORLD, HOT, DENSE, LUSH, JUNGLE);
    }

    private static void addBiome(Biome biome, BiomeManager.BiomeType type, int weight, BiomeDictionary.Type... types) {
        RegistryKey<Biome> key = RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES,
                Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome)));

        BiomeDictionary.addTypes(key, types);
        BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(key, weight));
    }
}

