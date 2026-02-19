package com.brbiomesmod.block.Custom.Saplings;

import com.brbiomesmod.Seasons.Season;
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

public class ImbuiaSapling extends SaplingBlock {
    public ImbuiaSapling() {
        super(new ImbuiaSapling.ImbuiaTree(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING).hardnessAndResistance(0.0f)
                .sound(SoundType.PLANT));
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderLayer() {
        RenderTypeLookup.setRenderLayer(TreesGroup.IMBUIA_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(TreesGroup.POTTED_IMBUIA_SAPLING.get(), RenderType.getCutout());

    }

    public boolean ticksRandomly(BlockState state) {
        return true;
    }

    /**
     * Performs a random tick on a block.
     *
     * @param state
     * @param world
     * @param pos
     * @param random
     */
    //Hardy from zone 9 to 10
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {

        String currentSeason = Season.getSeason(world.getDayTime());
        Biome biome = world.getBiome(pos);
        float temp = biome.getTemperature(pos);

        float minTemp = 0.8f;
        float maxTemp = 0.89f;

        boolean validTemp = temp >= minTemp && temp <= maxTemp;
        boolean hasRain = biome.getPrecipitation() != Biome.RainType.NONE;

        // ❄ Winter kill logic (Zone 9 vulnerability)
        if ("WINTER".equals(currentSeason) && temp <= 0.84F) {
            if (random.nextInt(5) == 0) { // 20% chance
                world.setBlockState(pos, Blocks.DEAD_BUSH.getDefaultState(), 3);
                return; // Stop further processing
            }
        }

        // 🌱 Growth logic
        if (validTemp && hasRain) {
            super.randomTick(state, world, pos, random);
        }
    }

    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {

        if (!(worldIn instanceof World)) {
            return false;
        }

        World world = (World) worldIn;
        Biome biome = world.getBiome(pos);

        float temp = biome.getTemperature(pos);

        boolean tooHot = temp > 0.89F;
        boolean tooCold = temp < 0.8F;
        boolean noRain = biome.getPrecipitation() == Biome.RainType.NONE;

        if (tooHot || tooCold || noRain) {
            return false;
        }

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
            Biome biome = worldIn.getBiome(pos);
            float temp = biome.getTemperature(pos);

            float minTemp = 0.8f, maxTemp = 0.89f;

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

            if (biome.getPrecipitation() == Biome.RainType.NONE) {
                player.sendMessage(
                        new StringTextComponent("This biome is too dry to this sapling."),
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

    private static class ImbuiaTree extends Tree {
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random random, boolean p_225546_2_) {
            if (random.nextInt(10) == 0) {
                return TreeFeatures.IMBUIA_FANCY_TREE;
            } else {
                return TreeFeatures.IMBUIA_TREE;
            }
        }
    }
}
