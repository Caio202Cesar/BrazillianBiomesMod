package com.brbiomesmod.biome;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;

import java.util.*;

public class BrazillianBiome {
    public static final List<BrazillianBiome> BRAZILLIAN_BIOME_LIST = new ArrayList<>();
    private final Biome biome;

    public static final Map<ResourceLocation, WeightedList<ResourceLocation>> BIOME_TO_HILLS_LIST = new HashMap<>();
    public static final Map<ResourceLocation, ResourceLocation> BIOME_TO_BEACH_LIST = new HashMap<>();
    public static final Map<ResourceLocation, ResourceLocation> BIOME_TO_EDGE_LIST = new HashMap<>();
    public static final Map<ResourceLocation, ResourceLocation> BIOME_TO_RIVER_LIST = new HashMap<>();

    public BrazillianBiome(Biome.Climate climate, Biome.Category category, float depth, float scale,
                           BiomeAmbience effects, BiomeGenerationSettings biomeGenerationSettings, MobSpawnInfo mobSpawnInfo, Biome biome) {
        this.biome = biome;
        BRAZILLIAN_BIOME_LIST.add(this);
    }

    public BrazillianBiome(Biome.Builder builder) {
        this.biome = builder.build();
        BRAZILLIAN_BIOME_LIST.add(this);
    }

    public BrazillianBiome(Biome biome) {
        this.biome = biome;
        BRAZILLIAN_BIOME_LIST.add(this);
    }

    public Biome getBiome() {
        return this.biome;
    }

    public String[] getBiomeDictionary() {
        return new String[]{"OVERWORLD"};
    }

    public int getWeight() {
        return 5;
    }

    public RegistryKey<Biome> getKey() {
        return RegistryKey.create(Registry.BIOME_REGISTRY, Objects.requireNonNull(WorldGenRegistries.BIOME.getKey(this.biome)));
    }
}
