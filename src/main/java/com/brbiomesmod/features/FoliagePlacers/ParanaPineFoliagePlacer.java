package com.brbiomesmod.features.FoliagePlacers;

import com.brbiomesmod.block.BlockClasses.AraucariaPlateauBlocks;
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

public class ParanaPineFoliagePlacer extends FoliagePlacer {
    public ParanaPineFoliagePlacer(FeatureSpread radius, FeatureSpread offset) {
        super(radius, offset);
    }

    public static final Codec<ParanaPineFoliagePlacer> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    FeatureSpread.CODEC.fieldOf("radius").forGetter(p -> p.radius),
                    FeatureSpread.CODEC.fieldOf("offset").forGetter(p -> p.offset)
            ).apply(instance, ParanaPineFoliagePlacer::new)
    );

    @Override
    protected FoliagePlacerType<?> getPlacerType() {
        return ModFoliagePlacer.PARANA_PINE_FOLIAGE_PLACER.get(); // Register your foliage placer type
    }

    @Override
    protected void func_230372_a_(IWorldGenerationReader world, Random random, BaseTreeFeatureConfig config, int trunkHeight, Foliage foliage, int radius, int offset, Set<BlockPos> leaves, int height, MutableBoundingBox boundingBox) {
        BlockPos center = foliage.func_236763_a_();

        // First layers (original canopy structure)
        int frondCount = 4 + random.nextInt(3);
        for (int i = 0; i < frondCount; i++) {
            double angle = 2 * Math.PI * i / frondCount;
            int length = 7 + random.nextInt(2); //Shorter
            generateFrond(world, random, config, center, angle, length, leaves, boundingBox);
        }

        // Second layer (flipped upside-down)
        BlockPos lowerCenter = center.down(2);
        for (int i = 0; i < frondCount; i++) {
            double angle = 2 * Math.PI * i / frondCount;
            int length = 7 + random.nextInt(2);
            generateFrond(world, random, config, lowerCenter, angle, length, leaves, boundingBox);
        }

        // Third layer (shorter and denser)
        BlockPos thirdLayerCenter = center.down(3);
        int denserFrondCount = frondCount + 2; // More fronds for density
        for (int i = 0; i < denserFrondCount; i++) {
            double angle = 2 * Math.PI * i / denserFrondCount;
            int length = 7 + random.nextInt(1); // Larger fronds
            generateFrond(world, random, config, thirdLayerCenter, angle, length, leaves, boundingBox);
        }
    }

    private void generateFrond(IWorldGenerationReader world, Random random, BaseTreeFeatureConfig config, BlockPos trunkBase, double angle, int length, Set<BlockPos> leaves, MutableBoundingBox boundingBox) {
        double trunkCenterX = trunkBase.getX() + 0.5;
        double trunkCenterZ = trunkBase.getZ() + 0.5;

        for (int i = 1; i <= length; i++) {
            int x = (int) Math.round(trunkCenterX + i * Math.cos(angle));
            int z = (int) Math.round(trunkCenterZ + i * Math.sin(angle));
            int y = trunkBase.getY() - (i / 2);
            BlockPos leafPos = new BlockPos(x, y, z);
            placeLeafAt(world, leafPos, leaves, boundingBox);
        }
    }

    private void placeLeafAt(IWorldGenerationReader world, BlockPos pos, Set<BlockPos> leaves, MutableBoundingBox boundingBox) {
        if (world.hasBlockState(pos, s -> s.isAir())) {
            world.setBlockState(pos, AraucariaPlateauBlocks.PARANA_PINE_LEAVES.get().getDefaultState()
                    .with(LeavesBlock.PERSISTENT, true).with(LeavesBlock.DISTANCE, 1), 19);
            leaves.add(pos);
            boundingBox.expandTo(new MutableBoundingBox(pos, pos));
        }
    }

    @Override
    public int func_230374_a_(Random random, int trunkHeight, BaseTreeFeatureConfig config) {
        return 2;
    }

    @Override
    protected boolean func_230373_a_(Random random, int dx, int dy, int dz, int radius, boolean large) {
        return dx * dx + dz * dz <= radius * radius;
    }
}




