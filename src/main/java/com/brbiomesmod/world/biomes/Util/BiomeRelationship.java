package com.brbiomesmod.world.biomes.Util;

import net.minecraft.util.ResourceLocation;

public class BiomeRelationship {
    private final ResourceLocation parent;
    private final ResourceLocation child;
    private final RelationshipType type;
    private final int chance;
    private final int edgeSize;     // optional
    private final int priority;     // optional
    private final boolean beach;
    private final boolean river;

    public BiomeRelationship(ResourceLocation parent,
                             ResourceLocation child,
                             RelationshipType type,
                             int chance,
                             int edgeSize,
                             int priority,
                             boolean beach,
                             boolean river) {

        this.parent = parent;
        this.child = child;
        this.type = type;
        this.chance = chance;
        this.edgeSize = edgeSize;
        this.priority = priority;
        this.beach = beach;
        this.river = river;
    }

    public ResourceLocation getParent() {
        return parent;
    }

    public ResourceLocation getChild() {
        return child;
    }

    public RelationshipType getType() {
        return type;
    }

    public int getChance() {
        return chance;
    }

    public boolean isBeach() {
        return beach;
    }

    public boolean isRiver() {
        return river;
    }
}
