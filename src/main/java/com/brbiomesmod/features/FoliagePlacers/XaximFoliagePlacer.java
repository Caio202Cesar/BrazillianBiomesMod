package com.brbiomesmod.features.FoliagePlacers;

import com.brbiomesmod.block.TreesGroup;
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

public class XaximFoliagePlacer extends FoliagePlacer {
    public XaximFoliagePlacer(FeatureSpread radius, FeatureSpread offset) {
        super(radius, offset);
    }

    public static final Codec<XaximFoliagePlacer> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    FeatureSpread.CODEC.fieldOf("radius").forGetter(p -> p.radius),
                    FeatureSpread.CODEC.fieldOf("offset").forGetter(p -> p.offset)
            ).apply(instance, XaximFoliagePlacer::new)
    );

    @Override
    protected FoliagePlacerType<?> getPlacerType() {
        return ModFoliagePlacer.XAXIM_FOLIAGE_PLACER.get();
    }

    @Override
    protected void func_230372_a_(IWorldGenerationReader world, Random random, BaseTreeFeatureConfig config, int trunkHeight, FoliagePlacer.Foliage foliage, int radius, int offset, Set<BlockPos> leaves, int height, MutableBoundingBox boundingBox) {
        BlockPos center = foliage.func_236763_a_();

        // First two layers (original canopy structure)
        int frondCount = 6 + random.nextInt(3);
        for (int i = 0; i < frondCount; i++) {
            double angle = 2 * Math.PI * i / frondCount;
            int length = 3 + random.nextInt(2);
            generateFrond(world, random, config, center, angle, length, leaves, boundingBox);
        }
    }

    private void generateFrond(IWorldGenerationReader world, Random random, BaseTreeFeatureConfig config, BlockPos center, double angle, int length, Set<BlockPos> leaves, MutableBoundingBox boundingBox) {
        for (int i = 1; i <= length; i++) {
            int x = (int) (center.getX() + i * Math.cos(angle));
            int z = (int) (center.getZ() + i * Math.sin(angle));
            int y = center.getY() - (i / 2);
            BlockPos leafPos = new BlockPos(x, y, z);
            placeLeafAt(world, leafPos, leaves, boundingBox);
        }
    }

    private void placeLeafAt(IWorldGenerationReader world, BlockPos pos, Set<BlockPos> leaves, MutableBoundingBox boundingBox) {
        if (world.hasBlockState(pos, s -> s.isAir())) {
            world.setBlockState(pos, TreesGroup.XAXIM_LEAVES.get().getDefaultState()
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

