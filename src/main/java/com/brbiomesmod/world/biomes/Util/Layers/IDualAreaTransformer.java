package com.brbiomesmod.world.biomes.Util.Layers;

import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;

public interface IDualAreaTransformer {

    int apply(int previous, int current);

    default <R extends IArea> IAreaFactory<R> apply(
            IExtendedNoiseRandom<R> context,
            IAreaFactory<R> previousFactory,
            IAreaFactory<R> currentFactory) {

        return () -> {

            R previous = previousFactory.make();
            R current = currentFactory.make();

            return context.makeArea((x, z) -> {

                context.setPosition((long)x, (long)z);

                return apply(
                        previous.getValue(x, z),
                        current.getValue(x, z)
                );

            }, previous);
        };
    }
}