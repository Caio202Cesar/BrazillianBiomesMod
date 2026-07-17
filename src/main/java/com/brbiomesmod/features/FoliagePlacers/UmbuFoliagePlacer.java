package com.brbiomesmod.features.FoliagePlacers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;

import java.util.Random;
import java.util.Set;

public class UmbuFoliagePlacer extends FoliagePlacer {
    public static final Codec<UmbuFoliagePlacer> CODEC =
            RecordCodecBuilder.create(instance ->
                    func_242830_b(instance).apply(instance, UmbuFoliagePlacer::new));

    public UmbuFoliagePlacer(FeatureSpread radius, FeatureSpread offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> getPlacerType() {
        return ModFoliagePlacer.UMBU_FOLIAGE_PLACER.get();
    }

    @Override
    protected void func_230372_a_(IWorldGenerationReader world,
                                  Random rand,
                                  BaseTreeFeatureConfig config,
                                  int trunkHeight,
                                  Foliage foliage,
                                  int foliageHeight,
                                  int radius,
                                  Set<BlockPos> leaves,
                                  int offset,
                                  MutableBoundingBox box) {

        BlockPos center = foliage.func_236763_a_();

        int[] radii = {
                radius + 2,
                radius + 3,
                radius + 4,
                radius + 3,
                radius + 2
        };

        for (int y = -2; y <= 2; y++) {

            int r = radii[y + 2];

            for (int x = -r; x <= r; x++) {
                for (int z = -r; z <= r; z++) {

                    double dist = Math.sqrt(x * x + z * z);

                    if (dist <= r + rand.nextFloat() * 0.5F) {

                        if (dist > r - 1 && rand.nextFloat() < 0.25F)
                            continue;

                        func_236753_a_(
                                world,
                                rand,
                                config,
                                foliage,
                                center.add(x, y, z),
                                radius,
                                leaves,
                                offset,
                                box);
                    }
                }
            }
        }

        // Hanging fringe

        int fringe = radius + 3;

        for (int i = 0; i < fringe * 10; i++) {

            double angle = rand.nextDouble() * Math.PI * 2;

            int x = (int)Math.round(Math.cos(angle) * fringe);
            int z = (int)Math.round(Math.sin(angle) * fringe);

            int length = 1 + rand.nextInt(3);

            for (int d = 0; d < length; d++) {

                func_236753_a_(
                        world,
                        rand,
                        config,
                        center.add(x, -2 - d, z),
                        leaves,
                        box);
            }
        }
    }

    @Override
    public int func_230374_a_(Random rand,
                              int trunkHeight,
                              BaseTreeFeatureConfig config) {

        return 5;
    }

    @Override
    protected boolean func_230373_a_(Random rand,
                                     int dx,
                                     int y,
                                     int dz,
                                     int radius,
                                     boolean giantTrunk) {

        return false;
    }
}
