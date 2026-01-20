package com.brbiomesmod.block.Custom.Leaves;

import com.brbiomesmod.Seasons.Season;
import com.brbiomesmod.block.TreesGroup;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class ButiaLeaves extends LeavesBlock {
    public ButiaLeaves(Properties properties) {
        super(properties);
    }

    public boolean ticksRandomly(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        super.randomTick(state, worldIn, pos, random);
        String currentSeason = Season.getSeason(worldIn.getDayTime());

        if ("SUMMER".equals(currentSeason) && random.nextFloat() < 0.00425f) {
            BlockPos belowPos = pos.down();
            BlockState belowState = worldIn.getBlockState(belowPos);

            // Check if the space below is air
            if (belowState.isAir()) {
                worldIn.setBlockState(belowPos, TreesGroup.PINDO_BUNCH.get().getDefaultState(), 2);
            }
        }
    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 90;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 100;
    }
}

