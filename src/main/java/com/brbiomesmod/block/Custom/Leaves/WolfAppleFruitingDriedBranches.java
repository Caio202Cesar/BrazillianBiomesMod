package com.brbiomesmod.block.Custom.Leaves;

import com.brbiomesmod.Seasons.Season;
import com.brbiomesmod.block.TreesGroup;
import com.brbiomesmod.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
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

import java.util.Random;

public class WolfAppleFruitingDriedBranches extends LeavesBlock implements IForgeShearable {
     public WolfAppleFruitingDriedBranches(Properties properties) {
         super(properties);

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
        String currentSeason = Season.getSeason(worldIn.getDayTime());

        if ("WINTER".equals(currentSeason) && random.nextInt(15) == 0) {
            int distance = state.get(LeavesBlock.DISTANCE);
            boolean persistent = state.get(LeavesBlock.PERSISTENT);

            worldIn.setBlockState(pos, TreesGroup.WOLF_APPLE_FRUITING_LEAVES.get()
                    .getDefaultState().with(LeavesBlock.DISTANCE, distance).with(LeavesBlock.PERSISTENT, persistent), 3);
        }

        if ("SPRING".equals(currentSeason) && random.nextInt(2) == 0) {
            int distance = state.get(LeavesBlock.DISTANCE);
            boolean persistent = state.get(LeavesBlock.PERSISTENT);

            worldIn.setBlockState(pos, TreesGroup.WOLF_APPLE_FRUITING_LEAVES.get()
                    .getDefaultState().with(LeavesBlock.DISTANCE, distance).with(LeavesBlock.PERSISTENT, persistent), 3);
        }

        if (random.nextInt(45) == 0) {

            int dropCount = 1 + random.nextInt(2);

            ItemStack itemStack = new ItemStack(ModItems.WOLF_APPLE.get(), dropCount);
            ItemEntity itemEntity = new ItemEntity(worldIn, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, itemStack);

            worldIn.addEntity(itemEntity);

            int distance = state.get(LeavesBlock.DISTANCE);
            boolean persistent = state.get(LeavesBlock.PERSISTENT);

            worldIn.setBlockState(pos, TreesGroup.WOLF_APPLE_DRIED_BRANCHES.get()
                    .getDefaultState().with(LeavesBlock.DISTANCE, distance).with(LeavesBlock.PERSISTENT, persistent), 3);
        }
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote) {

            int dropCount = 1;

            ItemStack itemStack = new ItemStack(ModItems.WOLF_APPLE.get(), dropCount);
            ItemEntity itemEntity = new ItemEntity(worldIn, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, itemStack);

            worldIn.addEntity(itemEntity);

            worldIn.setBlockState(pos, TreesGroup.WOLF_APPLE_LEAVES.get().getDefaultState());

            worldIn.playSound(null, pos, SoundEvents.BLOCK_GRASS_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);

        }
        return ActionResultType.SUCCESS;
    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 90;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 100;
    }
}
