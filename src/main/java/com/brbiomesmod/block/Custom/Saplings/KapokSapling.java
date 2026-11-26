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

public class KapokSapling extends ClimaticSapling {
    public KapokSapling() {
        super(new KapokTree(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING).hardnessAndResistance(0.0f)
                .sound(SoundType.PLANT));
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderLayer() {
        RenderTypeLookup.setRenderLayer(TreesGroup.KAPOK_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(TreesGroup.POTTED_KAPOK_SAPLING.get(), RenderType.getCutout());

    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 80;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 60;
    }

    private static class KapokTree extends ClimaticBigTree {
        @Nullable
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getHugeClimaticTreeFeature(Random random, World world, BlockPos pos) {

            Biome biome = world.getBiome(pos);
            float temp = biome.getTemperature(pos);

            if (temp > 0.9F) {
                if (random.nextInt(10) == 0) {
                    return TreeFeatures.YOUNG_KAPOK;
                } else {
                    return TreeFeatures.KAPOK_TREE;
                }
            }

            //Zone 10 growth
            return TreeFeatures.YOUNG_KAPOK;
        }

        @Nullable
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getClimaticTreeFeature(Random random, boolean b, World world, BlockPos blockPos) {
            return null;
        }
    }
}

