package com.brbiomesmod.features.FoliagePlacers;

import com.brbiomesmod.block.BlockClasses.AmazonRainforestBlocks;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;

import java.util.Random;
import java.util.Set;

public class AcaiFoliagePlacer extends FoliagePlacer {
    public AcaiFoliagePlacer(FeatureSpread radius, FeatureSpread offset) {
        super(radius, offset);
    }

    public static final Codec<AcaiFoliagePlacer> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    FeatureSpread.CODEC.fieldOf("radius").forGetter(p -> p.radius),
                    FeatureSpread.CODEC.fieldOf("offset").forGetter(p -> p.offset)
            ).apply(instance, AcaiFoliagePlacer::new)
    );

    @Override
    protected FoliagePlacerType<?> getPlacerType() {
        return ModFoliagePlacer.ACAI_FOLIAGE_PLACER.get(); // Register your foliage placer type
    }

    @Override
    protected void func_230372_a_(IWorldGenerationReader world, Random random, BaseTreeFeatureConfig config, int trunkHeight,
                                  Foliage foliage, int radius, int offset, Set<BlockPos> leaves, int height, MutableBoundingBox boundingBox) {
        BlockPos center = foliage.func_236763_a_(); // Position of the top foliage

        // Place a central leaf block at the top to connect fronds
        placeLeafAt(world, center, leaves, boundingBox, random);

        // Generate 4-6 fronds extending outward from the top
        int frondCount = 4 + random.nextInt(3);
        for (int i = 0; i < frondCount; i++) {
            double angle = 2 * Math.PI * i / frondCount;
            int length = 3 + random.nextInt(2); // Fronds extend 3-5 blocks

            // 1st Layer - Normal fronds (outward and slightly downward)
            generateFrond(world, random, config, center, angle, length, false, leaves, boundingBox);

            // 2nd Layer - Mirrored fronds (upward)
            generateFrond(world, random, config, center.down(length / 2), angle, length, true, leaves, boundingBox);

            // 3rd Layer - Extra downward fronds (even lower, for more foliage)
            generateFrond(world, random, config, center.down(length), angle, length, false, leaves, boundingBox);

        }

    }

    private void generateFrond(IWorldGenerationReader world, Random random, BaseTreeFeatureConfig config, BlockPos center,
                               double angle, int length, boolean inverted, Set<BlockPos> leaves, MutableBoundingBox boundingBox) {
        for (int i = 1; i <= length; i++) {
            int x = (int) (center.getX() + i * Math.cos(angle));
            int z = (int) (center.getZ() + i * Math.sin(angle));

            int y;
            if (inverted) {
                y = center.getY() + (i / 2); // Mirrored fronds curve slightly upward
            } else {
                y = center.getY() - (i / 2); // Normal fronds curve slightly downward
            }

            BlockPos leafPos = new BlockPos(x, y, z);
            placeLeafAt(world, leafPos, leaves, boundingBox, random);
        }
    }

    private void placeLeafAt(IWorldGenerationReader world, BlockPos pos, Set<BlockPos> leaves, MutableBoundingBox boundingBox, Random random) {
        if (world.hasBlockState(pos, s -> s.isAir())) {
            world.setBlockState(pos, AmazonRainforestBlocks.ACAI_LEAVES.get().getDefaultState()
                    .with(LeavesBlock.PERSISTENT, true).with(LeavesBlock.DISTANCE, 1), 19);
            leaves.add(pos);
            boundingBox.expandTo(new MutableBoundingBox(pos, pos));
        }
    }

    private void placeAcaiOnTrunk(IWorldGenerationReader world, BlockPos trunkPos, Random random) {
        BlockPos[] sidePositions = {
                trunkPos.north(), trunkPos.south(), trunkPos.east(), trunkPos.west()
        };

        for (BlockPos acaiPos : sidePositions) {
            BlockPos trunkBlock = trunkPos; // The original trunk position

            // Check if the açaí should generate (30% chance)
            if (random.nextFloat() < 0.3f
                    && world.hasBlockState(acaiPos, s -> s.isAir()) // Ensure space is air
                    && world.hasBlockState(trunkBlock, s -> s.getBlock() == AmazonRainforestBlocks.PALMITO_LOG.get())) { // Ensure it's attached to a PALMITO_LOG

                world.setBlockState(acaiPos, AmazonRainforestBlocks.ACAI_BUNCH.get().getDefaultState(), 19);
            }
        }
    }

    private void generateTrunk(IWorldGenerationReader world, BlockPos startPos, int height, Set<BlockPos> trunk, MutableBoundingBox boundingBox, Random random) {
        for (int y = 0; y < height; y++) {
            BlockPos trunkPos = startPos.up(y);
            world.setBlockState(trunkPos, AmazonRainforestBlocks.PALMITO_LOG.get().getDefaultState(), 19);
            trunk.add(trunkPos);
            boundingBox.expandTo(new MutableBoundingBox(trunkPos, trunkPos));

            // Try to generate acai on this trunk block
            placeAcaiOnTrunk(world, trunkPos, random);
        }
    }

    @Override
    public int func_230374_a_(Random random, int trunkHeight, BaseTreeFeatureConfig config) {
        return 2; // Palm trees typically have leaves only at the top
    }

    @Override
    protected boolean func_230373_a_(Random random, int dx, int dy, int dz, int radius, boolean large) {
        return dx * dx + dz * dz <= radius * radius;
    }
}



