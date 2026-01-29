package com.brbiomesmod.block.Custom.Saplings;

import com.brbiomesmod.Climate.SummerHeat;
import com.brbiomesmod.Climate.SummerHeatRegistry;
import com.brbiomesmod.block.TreesGroup;
import com.brbiomesmod.features.TreeFeatures;
import net.minecraft.block.*;
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

import java.util.Random;

public class FeijoaSapling extends SaplingBlock {
    public FeijoaSapling() {
        super(new FeijoaShrub(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING).hardnessAndResistance(0.0f)
                .sound(SoundType.PLANT));
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderLayer() {
        RenderTypeLookup.setRenderLayer(TreesGroup.FEIJOA_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(TreesGroup.POTTED_FEIJOA_SAPLING.get(), RenderType.getCutout());

    }

    private static boolean isSummerAllowed(World world, BlockPos pos) {
        SummerHeat heat = SummerHeatRegistry.get(world, pos);
        return heat == SummerHeat.WARM;
    }

    //Hardy to zone 8 to 11
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        float biomeTemp = world.getBiome(pos).getTemperature(pos);
        float minTemp = 0.75f;
        float maxTemp = 0.94f;

        if (biomeTemp >= minTemp && biomeTemp <= maxTemp) return;

        // Summer heat check (NEW)
        if (!isSummerAllowed(world, pos)) return;

        super.randomTick(state, world, pos, random);
    }

    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        if (!(worldIn instanceof World)) {
            return false;
        }

        World world = (World) worldIn;
        Biome biome = world.getBiome(pos);

        float temp = biome.getTemperature(pos);

        // ---- YOUR TEMPERATURE RESTRICTION LOGIC ----
        boolean tooHot = temp > 0.94F;
        boolean tooCold = temp < 0.75F;

        if (tooHot || tooCold) {
            return false;
        }

        if (!isSummerAllowed(world, pos)) return false;

        return super.canGrow(worldIn, pos, state, isClient);
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random random, BlockPos pos, BlockState state) {
        // Always allow for the check, we'll block in grow()
        return true;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote) {
            float temp = worldIn.getBiome(pos).getTemperature(pos);
            float minTemp = 0.75f, maxTemp = 0.94f;

            if (temp < minTemp) {
                player.sendMessage(
                        new StringTextComponent("This biome is too cold for this sapling."),
                        player.getUniqueID()
                );
                return ActionResultType.SUCCESS; // Prevent further processing if needed
            }

            if (temp > maxTemp) {
                player.sendMessage(
                        new StringTextComponent("This biome is too hot for this sapling."),
                        player.getUniqueID()
                );
                return ActionResultType.SUCCESS; // Prevent further processing if needed
            }

            if (!isSummerAllowed(worldIn, pos)) {
                player.sendMessage(
                        new StringTextComponent("Summers are too hot for this sapling."),
                        player.getUniqueID()
                );
                return ActionResultType.SUCCESS;
            }

            // If temp is in range, optionally allow normal processing:
            // return super.onBlockActivated(...);
            return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
        }
        return ActionResultType.SUCCESS;
    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 80;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 60;
    }

    private static class FeijoaShrub extends Tree {
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random random, boolean p_225546_2_) {
            return TreeFeatures.FEIJOA_SHRUB;
        }
    }
}

