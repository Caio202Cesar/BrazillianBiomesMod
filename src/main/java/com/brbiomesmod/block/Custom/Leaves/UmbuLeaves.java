package com.brbiomesmod.block.Custom.Leaves;

import com.caiocesarmods.caioclimates.Climate.Drought.DroughtPattern;
import com.caiocesarmods.caioclimates.Climate.Drought.DroughtPatternRegistry;
import com.caiocesarmods.caioclimates.Seasons.Season;import com.brbiomesmod.block.TreesGroup;
import com.caiocesarmods.caioclimates.Seasons.SeasonalPhase;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IForgeShearable;

import java.util.Random;

public class UmbuLeaves extends LeavesBlock implements IForgeShearable {
    public UmbuLeaves(Properties properties) {
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
        String phase = SeasonalPhase.getPhase(worldIn.getDayTime());

        Biome biome = worldIn.getBiome(pos);
        float temp = biome.getTemperature(pos);

        DroughtPattern pattern = DroughtPatternRegistry.get(biome);

        if (pattern == null) {
            return;
        }

        float rainChance = pattern.getRainChance(SeasonalPhase.valueOf(phase));
        float dryness = 1.0F - rainChance;

        //Pattern for tropical climates (dry season)
        if (temp > 0.9F) {
            if (dryness > 0.70F && random.nextFloat() < dryness) {

                int distance = state.get(LeavesBlock.DISTANCE);
                boolean persistent = state.get(LeavesBlock.PERSISTENT);

                worldIn.setBlockState(pos, TreesGroup.UMBU_DRIED_BRANCHES.get()
                        .getDefaultState().with(LeavesBlock.DISTANCE, distance).with(LeavesBlock.PERSISTENT, persistent), 3);
            }
        }

        //Fruiting season
        if (temp >= 0.9F && "WINTER".equals(currentSeason) && random.nextInt(55) == 0) {
            int distance = state.get(LeavesBlock.DISTANCE);
            boolean persistent = state.get(LeavesBlock.PERSISTENT);

            worldIn.setBlockState(pos, TreesGroup.UMBU_FRUITING_LEAVES.get()
                    .getDefaultState().with(LeavesBlock.DISTANCE, distance).with(LeavesBlock.PERSISTENT, persistent), 3);
        }

        //Pattern for subtropical biomes = cold season
        if (temp <= 0.89F && "FALL".equals(currentSeason) && random.nextInt(10) == 0) {
            int distance = state.get(LeavesBlock.DISTANCE);
            boolean persistent = state.get(LeavesBlock.PERSISTENT);

            worldIn.setBlockState(pos, TreesGroup.UMBU_DRIED_BRANCHES.get()
                    .getDefaultState().with(LeavesBlock.DISTANCE, distance).with(LeavesBlock.PERSISTENT, persistent), 3);
        }

        if (temp <= 0.89F && "WINTER".equals(currentSeason) && random.nextInt(2) == 0) {
            int distance = state.get(LeavesBlock.DISTANCE);
            boolean persistent = state.get(LeavesBlock.PERSISTENT);

            worldIn.setBlockState(pos, TreesGroup.UMBU_DRIED_BRANCHES.get()
                    .getDefaultState().with(LeavesBlock.DISTANCE, distance).with(LeavesBlock.PERSISTENT, persistent), 3);
        }

        //Fruiting season
        if (temp <= 0.89F && "SUMMER".equals(currentSeason) && random.nextInt(25) == 0) {
            int distance = state.get(LeavesBlock.DISTANCE);
            boolean persistent = state.get(LeavesBlock.PERSISTENT);

            worldIn.setBlockState(pos, TreesGroup.UMBU_FRUITING_LEAVES.get()
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
