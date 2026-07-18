package com.brbiomesmod.features.TrunkPlacers;

import com.mojang.serialization.Codec;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.trunkplacer.AbstractTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.TrunkPlacerType;

import java.lang.reflect.Method;

public class ModTrunkPlacers {

    static {
        System.out.println("REGISTERING CUSTOM TRUNK PLACERS");
    }

    private static <P extends AbstractTrunkPlacer> TrunkPlacerType<P> register(
            String name,
            Codec<P> codec) {
        try {
            Method m = TrunkPlacerType.class.getDeclaredMethod(
                    "register",
                    String.class,
                    Codec.class
            );
            m.setAccessible(true);

            return (TrunkPlacerType<P>) m.invoke(null, name, codec);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

