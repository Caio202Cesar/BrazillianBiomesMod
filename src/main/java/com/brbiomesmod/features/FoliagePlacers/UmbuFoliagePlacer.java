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
                radius,
                radius + 2,
                radius + 4,
                radius + 3,
                radius + 1
        };

        int variation = rand.nextInt(3) - 1;

        for (int y = -2; y <= 2; y++) {

            int localRadius = radii[y + 2] + variation;

            for (int x = -localRadius; x <= localRadius; x++) {
                for (int z = -localRadius; z <= localRadius; z++) {

                    double dist = Math.sqrt(x * x + z * z);

                    double noise = rand.nextFloat() * 0.4F;

                    boolean shell =
                            dist >= localRadius - 1.3 &&
                                    dist <= localRadius + noise;

                    boolean interior =
                            dist < localRadius - 1.3 &&
                                    rand.nextFloat() < 0.15F;

                    if (shell || interior) {

                        if (dist > localRadius - 1 && rand.nextFloat() < 0.35F)
                            continue;

                        if (dist < localRadius - 2 && rand.nextFloat() < 0.06F)
                            continue;

                        func_236753_a_(
                                world,
                                rand,
                                config,
                                center.add(x, y, z),
                                0,
                                leaves,
                                offset,
                                foliage.func_236765_c_(),
                                box);
                    }
                }
            }
        }
    }

    @Override
    public int func_230374_a_(Random rand,
                              int trunkHeight,
                              BaseTreeFeatureConfig config) {

        return 3;
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
