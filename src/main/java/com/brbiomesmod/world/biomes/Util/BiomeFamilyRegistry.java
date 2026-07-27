package com.brbiomesmod.world.biomes.Util;

import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class BiomeFamilyRegistry {
    private static final Map<ResourceLocation, ResourceLocation> BIOME_TO_FAMILY = new HashMap<>();

    private BiomeFamilyRegistry() {}

    public static void register(ResourceLocation biome, ResourceLocation family) {
        BIOME_TO_FAMILY.put(biome, family);
    }

    public static ResourceLocation getFamily(ResourceLocation biome) {
        return BIOME_TO_FAMILY.getOrDefault(biome, biome);
    }
}
