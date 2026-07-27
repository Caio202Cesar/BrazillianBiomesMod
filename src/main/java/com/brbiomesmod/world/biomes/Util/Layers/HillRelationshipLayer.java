package com.brbiomesmod.world.biomes.Util.Layers;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

public enum HillRelationshipLayer implements ICastleTransformer {

    INSTANCE;

    @Override
    public int apply(INoiseRandom random,
                     int north,
                     int west,
                     int south,
                     int east,
                     int center) {

        // Only process HILLS

        return center;
    }
}
