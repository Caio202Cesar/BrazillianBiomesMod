package com.brbiomesmod.block.Saplings;

import com.brbiomesmod.block.BlockClasses.AtlanticForestBlocks;
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

public class YellowIpeSapling extends SaplingBlock {
    public YellowIpeSapling() {
        super(new YellowIpeTree(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING).hardnessAndResistance(0.0f)
                .sound(SoundType.PLANT));
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderLayer() {
        RenderTypeLookup.setRenderLayer(AtlanticForestBlocks.YELLOW_IPE_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AtlanticForestBlocks.POTTED_YELLOW_IPE_SAPLING.get(), RenderType.getCutout());

    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 80;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 60;
    }

    private static class YellowIpeTree extends Tree {
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random random, boolean p_225546_2_) {
            if (random.nextInt(10) == 8) {
                return TreeFeatures.YELLOW_IPE_TREE;
            } else {
                return TreeFeatures.YELLOW_IPE_FANCY_TREE;
            }
        }
    }
}
