package com.brbiomesmod.block.Saplings;

import com.brbiomesmod.block.BlockClasses.CaatingaBlocks;
import com.brbiomesmod.block.CaatingaSand;
import com.brbiomesmod.features.TreeFeatures;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
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
import net.minecraftforge.fml.RegistryObject;

import java.util.Random;

public class BlackJuremaSapling extends SaplingBlock {
    public BlackJuremaSapling() {
        super(new BlackJuremaTree(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING).hardnessAndResistance(0.0f)
                .sound(SoundType.PLANT));
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderLayer() {
        RenderTypeLookup.setRenderLayer(CaatingaBlocks.BLACK_JUREMA_SAPLING.get(), RenderType.getCutout());
    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 80;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 60;
    }

    private static class BlackJuremaTree extends Tree {
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random random, boolean p_225546_2_) {
            return TreeFeatures.BLACK_JUREMA_TREE;
        }
    }
        protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
            return state.matchesBlock(Blocks.GRASS_BLOCK) || state.matchesBlock(Blocks.DIRT)
                    || state.matchesBlock(Blocks.COARSE_DIRT) || state.matchesBlock(Blocks.SAND)
                    || state.matchesBlock(Blocks.FARMLAND) || state.matchesBlock(Blocks.RED_SAND);
        }


}


