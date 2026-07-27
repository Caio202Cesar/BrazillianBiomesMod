package com.brbiomesmod.world.biomes.Util;

import net.minecraft.util.ResourceLocation;

import java.util.*;

public class BiomeRelationshipRegistry {
    private static final Map<ResourceLocation, List<BiomeRelationship>> RELATIONSHIPS = new HashMap<>();

    public static void register(BiomeRelationship relationship) {
        RELATIONSHIPS
                .computeIfAbsent(
                        relationship.getParent(),
                        k -> new ArrayList<>())
                .add(relationship);
    }

    public static void register(
            ResourceLocation parent,
            ResourceLocation child,
            RelationshipType type,
            int chance,
            int edgeSize,
            int priority,
            boolean beach,
            boolean river) {

        register(new BiomeRelationship(parent, child, type, chance, edgeSize, priority, beach, river));
    }

    public static List<BiomeRelationship> getRelationships(ResourceLocation biome) {

        return RELATIONSHIPS.getOrDefault(
                biome,
                Collections.emptyList());
    }

    public static Optional<BiomeRelationship> getRelationship(
            ResourceLocation biome,
            RelationshipType type) {

        return getRelationships(biome)
                .stream()
                .filter(r -> r.getType() == type)
                .findFirst();
    }

    public static Optional<BiomeRelationship> getRiverRelationship(ResourceLocation biome) {

        return getRelationships(biome)
                .stream()
                .filter(BiomeRelationship::isRiver)
                .findFirst();
    }

    public static void registerRiver(
            ResourceLocation parent,
            ResourceLocation child) {

        register(new BiomeRelationship(
                parent,
                child,
                null,
                0,
                0,
                0,
                false,   // beach
                true));  // river
    }

    public static void clear() {
        RELATIONSHIPS.clear();
    }
}
