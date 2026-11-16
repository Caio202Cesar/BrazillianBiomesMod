package com.brbiomesmod.features.FoliagePlacers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;

import java.util.Random;
import java.util.Set;

public class MegaBlobFoliagePlacer extends FoliagePlacer {
    public MegaBlobFoliagePlacer(FeatureSpread radius, FeatureSpread offset) {super(radius, offset);}

    public static final Codec<MegaBlobFoliagePlacer> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    FeatureSpread.CODEC.fieldOf("radius")
                            .forGetter(fp -> fp.radius),
                    FeatureSpread.CODEC.fieldOf("offset")
                            .forGetter(fp -> fp.offset)
            ).apply(instance, MegaBlobFoliagePlacer::new)
    );

    @Override
    protected FoliagePlacerType<?> getPlacerType() {
        return ModFoliagePlacer.MEGA_BLOB_FOLIAGE_PLACER.get();
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

        BlockPos tip = foliage.func_236763_a_();

        // Overall canopy size
        int height = Math.max(foliageHeight, radius + 2);

        int topHeight = 2;

        for (int y = topHeight; y >= -height; y--) {

            // Position within the canopy (0 = top, 1 = bottom)
            int totalHeight = height + topHeight;
            float progress = (float)(topHeight - y) / (float)totalHeight;

            // Ellipsoid equation
            float sphere = 1.0F - (float)Math.pow(progress - 0.5F, 2) * 4.0F;
            sphere = Math.max(0.0F, sphere);

            int layerRadius = Math.max(1,
                    Math.round(radius * (float)Math.sqrt(sphere)));

            // Slightly flatten the bottom
            if (progress > 0.75F) {
                layerRadius += 1;
            }

            for (int x = -layerRadius; x <= layerRadius; x++) {
                for (int z = -layerRadius; z <= layerRadius; z++) {

                    double distance = x * x + z * z;
                    double maxDistance = layerRadius * layerRadius;

                    if (distance > maxDistance)
                        continue;

                    // Edge irregularity
                    if (distance > (layerRadius - 1) * (layerRadius - 1)) {
                        if (rand.nextFloat() < 0.25F)
                            continue;
                    }

                    BlockPos pos = tip.add(x, y - offset, z);

                    placeLeaf(
                            world,
                            rand,
                            config,
                            pos,
                            leaves,
                            box
                    );;

                    // Occasional hanging leaves
                    if (progress > 0.70F &&
                            distance > (layerRadius - 2) * (layerRadius - 2) &&
                            rand.nextFloat() < 0.12F) {

                        placeLeaf(
                                world,
                                rand,
                                config,
                                pos,
                                leaves,
                                box
                        );
                    }
                }
            }
        }
    }

    @Override
    public int func_230374_a_(Random rand, int trunkHeight, BaseTreeFeatureConfig config) {
        return 6;
    }

    @Override
    protected boolean func_230373_a_(Random rand, int x, int y, int z, int radius, boolean giantTrunk) {
        return false;
    }

    private void placeLeaf(
            IWorldGenerationReader world,
            Random random,
            BaseTreeFeatureConfig config,
            BlockPos pos,
            Set<BlockPos> leaves,
            MutableBoundingBox box) {

        if (TreeFeature.isReplaceableAt(world, pos)) {

            BlockState state = config.leavesProvider
                    .getBlockState(random, pos);

            if (state.hasProperty(LeavesBlock.PERSISTENT)) {
                state = state.with(LeavesBlock.PERSISTENT, true);
            }

            if (state.hasProperty(LeavesBlock.DISTANCE)) {
                state = state.with(LeavesBlock.DISTANCE, 1);
            }

            world.setBlockState(pos, state, 19);

            leaves.add(pos);
            box.expandTo(new MutableBoundingBox(pos, pos));
        }
    }
}
