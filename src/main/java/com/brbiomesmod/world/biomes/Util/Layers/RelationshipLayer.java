package com.brbiomesmod.world.biomes.Util.Layers;

import com.brbiomesmod.world.biomes.Util.BiomeRelationship;
import com.brbiomesmod.world.biomes.Util.BiomeRelationshipRegistry;
import com.brbiomesmod.world.biomes.Util.RelationshipType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

import java.util.Optional;

public enum RelationshipLayer implements ICastleTransformer {

    INSTANCE;

    @Override
    public int apply(INoiseRandom random,
                     int north,
                     int west,
                     int south,
                     int east,
                     int center) {

        Biome biome = WorldGenRegistries.BIOME.getByValue(center);

        System.out.println(
                "[RelationshipLayer] center id=" + center +
                        " biome=" + WorldGenRegistries.BIOME.getKey(biome)
        );

        if (biome == null)
            return center;

        ResourceLocation id = WorldGenRegistries.BIOME.getKey(biome);

        if (id == null)
            return center;

        if (id.equals(new ResourceLocation("caiocesarbiomes", "mediterranean_sparse_oak_woodland"))) {
            System.out.println("[RelationshipLayer] Existing sparse woodland!");
        }

        // SUB BIOME
        Integer subBiome = applyRelationship(
                RelationshipType.SUB_BIOME,
                id,
                random,
                north,
                west,
                south,
                east,
                center);

        if (subBiome != null) {
            System.out.println("[RelationshipLayer] SUB -> " + subBiome);
            return subBiome;
        }

        // EDGE
        Integer edge = applyRelationship(
                RelationshipType.EDGE,
                id,
                random,
                north,
                west,
                south,
                east,
                center);

        if (edge != null) {
            System.out.println("[RelationshipLayer] EDGE -> " + edge);
            return edge;
        }

        return center;
    }

    private Integer applyRelationship(
            RelationshipType type,
            ResourceLocation biome,
            INoiseRandom random,
            int north,
            int west,
            int south,
            int east,
            int center) {

        Optional<BiomeRelationship> relationship =
                BiomeRelationshipRegistry.getRelationship(biome, type);

        if (!relationship.isPresent())
            return null;

        return type.apply(
                relationship.get(),
                random,
                north,
                west,
                south,
                east,
                center);
    }
}