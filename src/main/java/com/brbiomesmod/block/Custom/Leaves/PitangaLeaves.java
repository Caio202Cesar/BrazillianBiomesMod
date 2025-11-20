package com.brbiomesmod.block.Custom.Leaves;

import com.brbiomesmod.Seasons.Season;
import com.brbiomesmod.block.TreesGroup;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IForgeShearable;

import java.util.Random;
import java.util.function.Supplier;

public class PitangaLeaves extends LeavesBlock implements IForgeShearable {
     public PitangaLeaves(Properties properties) {
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

        Biome biome = worldIn.getBiome(pos);
        float temp = biome.getTemperature(pos);

        // === 4. If biome is coller (< 0.9 MC temp) AND it's WINTER, change to winter leaves ===
        if (temp < 0.9F && "WINTER".equals(currentSeason) && random.nextInt(5) == 0) {
            int distance = state.get(LeavesBlock.DISTANCE);
            boolean persistent = state.get(LeavesBlock.PERSISTENT);

            worldIn.setBlockState(pos, TreesGroup.PITANGA_WINTER_LEAVES.get()
                    .getDefaultState().with(LeavesBlock.DISTANCE, distance).with(LeavesBlock.PERSISTENT, persistent), 3);
        }

        if (temp > 0.89F && "SPRING".equals(currentSeason) && random.nextInt(5) == 0) {
            int distance = state.get(LeavesBlock.DISTANCE);
            boolean persistent = state.get(LeavesBlock.PERSISTENT);

            worldIn.setBlockState(pos, TreesGroup.PITANGA_FLOWERING_LEAVES.get()
                    .getDefaultState().with(LeavesBlock.DISTANCE, distance).with(LeavesBlock.PERSISTENT, persistent), 3);
        }
    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 90;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 100;
    }
}
