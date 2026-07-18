package com.brbiomesmod.features.TrunkPlacers;

import com.mojang.serialization.Codec;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.trunkplacer.AbstractTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.TrunkPlacerType;

import java.lang.reflect.Method;

public class ModTrunkPlacers {

    /*public static final TrunkPlacerType<UmbuTrunkPlacer> UMBU_TRUNK =
            Registry.register(
                    Registry.TRUNK_REPLACER,
                    "brbiomesmod:umbu_trunk",
                    new TrunkPlacerType<>(UmbuTrunkPlacer.CODEC)
            );*/

    public static void register() {
        System.out.println("REGISTERING CUSTOM TRUNK PLACERS");
    }
}

