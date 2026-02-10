package com.brbiomesmod.block.Custom.Leaves;

import com.brbiomesmod.Seasons.Season;
import com.brbiomesmod.block.TreesGroup;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IForgeShearable;

import java.util.Random;

public class MangabaLeaves extends LeavesBlock implements IForgeShearable {
     public MangabaLeaves(Properties properties) {
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

        //Dry season in Dry Biomes
        if ("SUMMER".equals(currentSeason)
                && biome.getPrecipitation() == Biome.RainType.NONE
                && random.nextInt(25) == 0) {

            int distance = state.get(LeavesBlock.DISTANCE);
            boolean persistent = state.get(LeavesBlock.PERSISTENT);

            worldIn.setBlockState(
                    pos,
                    TreesGroup.MANGABA_DRIED_BRANCHES.get()
                            .getDefaultState()
                            .with(LeavesBlock.DISTANCE, distance)
                            .with(LeavesBlock.PERSISTENT, persistent),
                    3
            );
        }

        if ("FALL".equals(currentSeason)
                && biome.getPrecipitation() == Biome.RainType.NONE
                && random.nextInt(5) == 0) {

            int distance = state.get(LeavesBlock.DISTANCE);
            boolean persistent = state.get(LeavesBlock.PERSISTENT);

            worldIn.setBlockState(
                    pos,
                    TreesGroup.MANGABA_DRIED_BRANCHES.get()
                            .getDefaultState()
                            .with(LeavesBlock.DISTANCE, distance)
                            .with(LeavesBlock.PERSISTENT, persistent),
                    3
            );
        }

        if ("WINTER".equals(currentSeason) && random.nextInt(45) == 0) {
            int distance = state.get(LeavesBlock.DISTANCE);
            boolean persistent = state.get(LeavesBlock.PERSISTENT);

            worldIn.setBlockState(pos, TreesGroup.MANGABA_FLOWERING_LEAVES.get()
                    .getDefaultState().with(LeavesBlock.DISTANCE, distance).with(LeavesBlock.PERSISTENT, persistent), 3);
        }

        if ("SPRING".equals(currentSeason) && random.nextInt(15) == 0) {
            int distance = state.get(LeavesBlock.DISTANCE);
            boolean persistent = state.get(LeavesBlock.PERSISTENT);

            worldIn.setBlockState(pos, TreesGroup.MANGABA_FLOWERING_LEAVES.get()
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
