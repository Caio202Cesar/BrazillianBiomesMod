package com.brbiomesmod.world.biomes.Util;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.LayerUtil;

public enum RelationshipType {
    EDGE {
        @Override
        public Integer apply(BiomeRelationship relationship,
                             INoiseRandom random,
                             int north,
                             int west,
                             int south,
                             int east,
                             int center) {

            ResourceLocation centerFamily = family(center);

            System.out.println(
                    "CENTER=" + biomeName(center) +
                            " CF=" + centerFamily +
                            " NF=" + family(north) +
                            " SF=" + family(south) +
                            " EF=" + family(east) +
                            " WF=" + family(west)
            );

            if (centerFamily == null)
                return center;

            if (!(centerFamily.equals(family(north))
                    && centerFamily.equals(family(south))
                    && centerFamily.equals(family(east))
                    && centerFamily.equals(family(west)))) {

                return WorldGenRegistries.BIOME
                        .getOptional(relationship.getChild())
                        .map(WorldGenRegistries.BIOME::getId)
                        .orElse(center);
            }

            return null;
        }
    },

    SUB_BIOME {
        @Override
        public Integer apply(BiomeRelationship relationship,
                             INoiseRandom random,
                             int north,
                             int west,
                             int south,
                             int east,
                             int center) {

            if (random.random(relationship.getChance()) == 0) {

                return WorldGenRegistries.BIOME
                        .getOptional(relationship.getChild())
                        .map(WorldGenRegistries.BIOME::getId)
                        .orElse(center);
            }

            return null;
        }
    },

    BEACH {
        @Override
        public Integer apply(
                BiomeRelationship relationship,
                INoiseRandom random,
                int north,
                int west,
                int south,
                int east,
                int center) {

            return WorldGenRegistries.BIOME
                    .getOptional(relationship.getChild())
                    .map(WorldGenRegistries.BIOME::getId)
                    .orElse(center);
        }
    };

    private static String biomeName(int id) {
        Biome biome = WorldGenRegistries.BIOME.getByValue(id);

        if (biome == null) {
            return "null(" + id + ")";
        }

        ResourceLocation key = WorldGenRegistries.BIOME.getKey(biome);

        return key == null ? "unknown(" + id + ")" : key.toString();
    }

    private static ResourceLocation family(int biomeId) {

        Biome biome = WorldGenRegistries.BIOME.getByValue(biomeId);

        if (biome == null)
            return new ResourceLocation("minecraft", "unknown");

        ResourceLocation id = WorldGenRegistries.BIOME.getKey(biome);

        if (id == null)
            return new ResourceLocation("minecraft", "unknown");

        return BiomeFamilyRegistry.getFamily(id);
    }

    private static int id(RegistryKey<Biome> key) {
        return WorldGenRegistries.BIOME.getId(
                WorldGenRegistries.BIOME.getOrThrow(key));
    }

    public static class RelationshipUtil {

        public static boolean isOcean(int biomeId) {
            return LayerUtil.areBiomesSimilar(biomeId, id(Biomes.OCEAN))
                    || LayerUtil.areBiomesSimilar(biomeId, id(Biomes.DEEP_OCEAN))
                    || LayerUtil.areBiomesSimilar(biomeId, id(Biomes.COLD_OCEAN))
                    || LayerUtil.areBiomesSimilar(biomeId, id(Biomes.DEEP_COLD_OCEAN))
                    || LayerUtil.areBiomesSimilar(biomeId, id(Biomes.FROZEN_OCEAN))
                    || LayerUtil.areBiomesSimilar(biomeId, id(Biomes.DEEP_FROZEN_OCEAN))
                    || LayerUtil.areBiomesSimilar(biomeId, id(Biomes.LUKEWARM_OCEAN))
                    || LayerUtil.areBiomesSimilar(biomeId, id(Biomes.DEEP_LUKEWARM_OCEAN))
                    || LayerUtil.areBiomesSimilar(biomeId, id(Biomes.WARM_OCEAN))
                    || LayerUtil.areBiomesSimilar(biomeId, id(Biomes.DEEP_WARM_OCEAN));
        }
    }

    public abstract Integer apply(
            BiomeRelationship relationship,
            INoiseRandom random,
            int north,
            int west,
            int south,
            int east,
            int center);
}

