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
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
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

public class AcaiSapling extends SaplingBlock {
    public AcaiSapling() {
        super(new AcaiTree(), Properties.from(Blocks.OAK_SAPLING).hardnessAndResistance(0.0f)
                .sound(SoundType.PLANT));
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
        boolean tooHot = temp > 1.5F;
        boolean tooCold = temp < 0.89F;

        if (tooHot || tooCold) {
            return false;
        }

        return super.canGrow(worldIn, pos, state, isClient);
    }

    public ActionResultType use(BlockState state, World world, BlockPos pos,
                                PlayerEntity player, Hand hand, BlockRayTraceResult hit) {

        ItemStack stack = player.getHeldItem(hand);

        // Make sure we have an item and it's bone meal
        if (stack != null && stack.getItem() == Items.BONE_MEAL) {

            Biome biome = world.getBiome(pos);
            float temp = biome.getTemperature(pos);

            boolean tooHot  = temp > 1.5F;
            boolean tooCold = temp < 0.88F;

            if (tooHot || tooCold) {
                // Only send server->client message from server side
                if (!world.isRemote) {
                    ITextComponent msg = tooHot
                            ? new StringTextComponent("§cThe climate is too hot for this sapling!")
                            : new StringTextComponent("§bThe climate is too cold for this sapling!");

                    // Use Util.NIL_UUID to avoid needing the player's UUID method variant
                    player.sendMessage(msg, player.getUniqueID());
                }

                // Return sidedSuccess so client and server behave correctly and we prevent bonemeal effect
                return ActionResultType.SUCCESS;
            }
        }

        // Otherwise keep normal behavior
        return super.onBlockActivated(state, world, pos, player, hand, hit);
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderLayer() {
        RenderTypeLookup.setRenderLayer(TreesGroup.ACAI_SAPLING.get(), RenderType.getCutout());
    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 80;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 60;
    }

    private static class AcaiTree extends Tree {
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random random, boolean p_225546_2_) {
            return TreeFeatures.ACAI_PALM;
        }
    }
}

