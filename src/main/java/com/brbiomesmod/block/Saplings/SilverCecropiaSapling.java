package com.brbiomesmod.block.Saplings;

import com.brbiomesmod.block.BlockClasses.AmazonRainforestBlocks;
import com.brbiomesmod.block.BlockClasses.AtlanticForestBlocks;
import com.brbiomesmod.features.TreeFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SoundType;
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

public class SilverCecropiaSapling extends SaplingBlock {
    public SilverCecropiaSapling() {
        super(new SilverCecropiaSapling.SilverCecropiaTree(), Properties.from(Blocks.OAK_SAPLING).hardnessAndResistance(0.0f)
                .sound(SoundType.PLANT));
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderLayer() {
        RenderTypeLookup.setRenderLayer(AtlanticForestBlocks.CECROPIA_SILVER_SAPLING.get(), RenderType.getCutout());
    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 80;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 60;
    }


    private static class SilverCecropiaTree extends Tree {
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random random, boolean p_225546_2_) {
            return TreeFeatures.SILVER_CECROPIA_TREE;
        }
    }
}
