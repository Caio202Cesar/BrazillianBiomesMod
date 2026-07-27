package com.brbiomesmod.world.biomes.Util.Layers;

import com.brbiomesmod.world.biomes.Util.BiomeRelationship;
import com.brbiomesmod.world.biomes.Util.BiomeRelationshipRegistry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.traits.IAreaTransformer2;
import net.minecraft.world.gen.layer.traits.IDimOffset0Transformer;

import java.util.Optional;

public enum RiverRelationshipLayer implements IAreaTransformer2, IDimOffset0Transformer {

    INSTANCE;

    @Override
    public int apply(
            INoiseRandom random,
            IArea previous,
            IArea current,
            int x,
            int z) {

        int before = previous.getValue(
                getOffsetX(x),
                getOffsetZ(z));

        int after = current.getValue(
                getOffsetX(x),
                getOffsetZ(z));

        // Vanilla didn't generate a river.
        if (before == after)
            return after;

        Biome beforeBiome =
                WorldGenRegistries.BIOME.getByValue(before);

        if (beforeBiome == null)
            return after;

        ResourceLocation id =
                WorldGenRegistries.BIOME.getKey(beforeBiome);

        if (id == null)
            return after;

        Optional<BiomeRelationship> relationship =
                BiomeRelationshipRegistry.getRiverRelationship(id);

        System.out.println(
                "[River] before=" + id +
                        " after=" +
                        WorldGenRegistries.BIOME.getKey(
                                WorldGenRegistries.BIOME.getByValue(after)));

        if (!relationship.isPresent())
            return after;

        System.out.println(
                "[River] Replacing with " +
                        relationship.get().getChild());

        return WorldGenRegistries.BIOME
                .getOptional(relationship.get().getChild())
                .map(WorldGenRegistries.BIOME::getId)
                .orElse(after);
    }
}
