package com.brbiomesmod.block.Saplings;

import com.brbiomesmod.block.BlockClasses.AraucariaPlateauBlocks;
import com.brbiomesmod.features.TreeFeatures;
import net.minecraft.block.*;
import net.minecraft.block.trees.Tree;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class RioGrandeCherrySapling extends SaplingBlock {
    public RioGrandeCherrySapling() {
        super(new RioGrandeCherrySapling.RioGrandeCherryTree(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING).hardnessAndResistance(0.0f)
                .sound(SoundType.PLANT));
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderLayer() {
        RenderTypeLookup.setRenderLayer(AraucariaPlateauBlocks.RIO_GRANDE_CHERRY_SAPLING.get(), RenderType.getCutout());
    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 80;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 60;
    }

    private static class RioGrandeCherryTree extends Tree {
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random random, boolean p_225546_2_) {
            if (random.nextInt(10) == 0) {
                return TreeFeatures.RIO_GRANDE_CHERRY_FANCY_TREE;
            } else {
                return TreeFeatures.RIO_GRANDE_CHERRY_TREE;
            }
        }
    }
}
