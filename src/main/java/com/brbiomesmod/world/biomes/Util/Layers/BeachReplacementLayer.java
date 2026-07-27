package com.brbiomesmod.world.biomes.Util.Layers;

import com.brbiomesmod.world.biomes.Util.BiomeRelationship;
import com.brbiomesmod.world.biomes.Util.BiomeRelationshipRegistry;
import com.brbiomesmod.world.biomes.Util.RelationshipType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.traits.IAreaTransformer2;
import net.minecraft.world.gen.layer.traits.IDimOffset0Transformer;

import java.util.Optional;

public enum BeachReplacementLayer implements IAreaTransformer2, IDimOffset0Transformer {

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

        // Vanilla did not generate a beach
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
                BiomeRelationshipRegistry.getRelationship(
                        id,
                        RelationshipType.BEACH);

        System.out.println(
                "[Beach] before=" + id +
                        " after=" + WorldGenRegistries.BIOME.getKey(
                        WorldGenRegistries.BIOME.getByValue(after)));

        if (!relationship.isPresent())
            return after;

        Integer replacement =
                RelationshipType.BEACH.apply(
                        relationship.get(),
                        random,
                        before,
                        before,
                        before,
                        before,
                        after);

        System.out.println(
                "[Beach] Replacing with " +
                        relationship.get().getChild());

        return replacement == null ? after : replacement;
    }
}
