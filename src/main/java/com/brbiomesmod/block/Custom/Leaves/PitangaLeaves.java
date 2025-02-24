package com.brbiomesmod.block.Custom.Leaves;

import com.brbiomesmod.block.BlockClasses.AtlanticForestBlocks;
import com.brbiomesmod.block.BlockClasses.CaatingaBlocks;
import com.brbiomesmod.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IForgeShearable;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class PitangaLeaves extends LeavesBlock implements IForgeShearable {
    public PitangaLeaves() {
        super(Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE));
    }

    public boolean ticksRandomly(BlockState state) {
        return true;
    }

    /**
     * Performs a random tick on a block.
     *
     * @param state
     * @param worldIn
     * @param pos
     * @param random
     */
    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        super.randomTick(state, worldIn, pos, random);

        double chance = 0.6;

        if (random.nextDouble() < chance) {
            worldIn.setBlockState(pos, AtlanticForestBlocks.PITANGA_FLOWERING_LEAVES.get().getDefaultState());

        }
    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 90;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 100;
    }
}
