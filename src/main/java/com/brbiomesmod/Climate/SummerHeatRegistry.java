package com.brbiomesmod.Climate;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import java.util.HashMap;
import java.util.Map;

public class SummerHeatRegistry {
    private static final Map<ResourceLocation, SummerHeat> MAP = new HashMap<>();

    private SummerHeatRegistry() {}

    // ---- REGISTER USING STRING ----
    public static void register(String biomeId, SummerHeat heat) {
        MAP.put(new ResourceLocation(biomeId), heat);
    }

    // ---- REGISTER USING RESOURCELOCATION (OPTIONAL) ----
    public static void register(ResourceLocation biomeId, SummerHeat heat) {
        MAP.put(biomeId, heat);
    }

    // ---- QUERY FROM WORLD ----
    public static SummerHeat get(World world, BlockPos pos) {
        Biome biome = world.getBiome(pos);

        ResourceLocation id = world.func_241828_r()
                .getRegistry(Registry.BIOME_KEY)
                .getKey(biome);

        if (id == null) return SummerHeat.HOT; // safe fallback

        return MAP.getOrDefault(id, SummerHeat.HOT);
    }
}
