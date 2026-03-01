package com.brbiomesmod.block.Custom.Saplings;

import com.brbiomesmod.block.TreesGroup;
import com.brbiomesmod.features.TreeFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SoundType;
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

public class CavenThornSapling extends SaplingBlock {
    public CavenThornSapling() {
        super(new CavenThornSapling.CavenThornTree(), Properties.from(Blocks.OAK_SAPLING).hardnessAndResistance(0.0f)
                .sound(SoundType.PLANT));
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderLayer() {
        RenderTypeLookup.setRenderLayer(TreesGroup.CAVEN_THORN_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(TreesGroup.POTTED_CAVEN_THORN_SAPLING.get(), RenderType.getCutout());

    }

    //Hardy from zone 8 to 11
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        Biome biome = world.getBiome(pos);
        float temp = biome.getTemperature(pos);

        float minTemp = 0.75f;
        float maxTemp = 0.94f;

        float downfall = biome.getDownfall();
        float maxDownfall = 0.55f;

        boolean validTemp = temp >= minTemp && temp <= maxTemp;
        boolean suitableHumidity = downfall < maxDownfall;

        if (validTemp && suitableHumidity) {
            super.randomTick(state, world, pos, random);
        }
        // If biome temperature is too low/high, do nothing (block natural growth)
    }

    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        if (!(worldIn instanceof World)) {
            return false;
        }

        World world = (World) worldIn;
        Biome biome = world.getBiome(pos);

        float temp = biome.getTemperature(pos);
        float downfall = biome.getDownfall();

        // ---- YOUR TEMPERATURE RESTRICTION LOGIC ----
        boolean tooHot = temp > 0.94f;
        boolean tooCold = temp < 0.75F;
        boolean tooHumid = downfall > 0.55F;

        if (tooHot || tooCold || tooHumid) {
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
            float downfall = biome.getDownfall();
            float minTemp = 0.75f, maxTemp = 0.94f, maxDownfall = 0.55F;

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

            if (downfall > maxDownfall) {
                player.sendMessage(
                        new StringTextComponent("This biome is too wet for this sapling."),
                        player.getUniqueID()
                );
                return ActionResultType.SUCCESS; // Prevent further processing if needed
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

    private static class CavenThornTree extends Tree {
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random random, boolean p_225546_2_) {
            return TreeFeatures.CAVEN_THORN_TREE;
        }
    }
}
