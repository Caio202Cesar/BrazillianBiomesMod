package com.brbiomesmod.block.Custom.Saplings;

import com.brbiomesmod.block.TreesGroup;
import com.brbiomesmod.features.TreeFeatures;
import com.caiocesarmods.caioclimates.block.ClimaticBigTree;
import com.caiocesarmods.caioclimates.block.Saplings.ClimaticSapling;
import net.minecraft.block.*;
import net.minecraft.block.trees.BigTree;
import net.minecraft.block.trees.Tree;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;

public class BacuriSapling extends ClimaticSapling {
    public BacuriSapling() {
        super(new BacuriSapling.BacuriTree(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING).hardnessAndResistance(0.0f)
                .sound(SoundType.PLANT));
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderLayer() {
        RenderTypeLookup.setRenderLayer(TreesGroup.BACURI_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(TreesGroup.POTTED_BACURI_SAPLING.get(), RenderType.getCutout());

    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 80;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 60;
    }


    private static class BacuriTree extends ClimaticBigTree {
        @Nullable
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getHugeClimaticTreeFeature(Random random, World world, BlockPos blockPos) {
            Biome biome = world.getBiome(blockPos);
            float temp = biome.getTemperature(blockPos);

            if (temp > 0.95F) {
                return TreeFeatures.MEGA_BACURI_TREE;
            }

            return null;
        }

        @Nullable
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getClimaticTreeFeature(Random random, boolean b, World world, BlockPos blockPos) {
            Biome biome = world.getBiome(blockPos);
            float temp = biome.getTemperature(blockPos);

            if (temp > 0.95F) {
                return TreeFeatures.FANCY_BACURI_TREE;
            }

            //Zone 11 growth
            return TreeFeatures.BACURI_TREE;
        }
    }
}
