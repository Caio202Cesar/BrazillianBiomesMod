package com.brbiomesmod.block.Custom.Leaves;

import com.brbiomesmod.Climate.SummerHeat;
import com.brbiomesmod.Climate.SummerHeatRegistry;
import com.brbiomesmod.Seasons.Season;
import com.brbiomesmod.block.TreesGroup;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IForgeShearable;

import java.util.Random;
import java.util.function.Supplier;

public class FeijoaFloweringLeaves extends LeavesBlock implements IForgeShearable {
    public FeijoaFloweringLeaves(Properties properties) {
        super(properties);
    }

    private static boolean isSummerAllowed(World world, BlockPos pos) {
        SummerHeat heat = SummerHeatRegistry.get(world, pos);
        return heat == SummerHeat.WARM;
    }

    private void setNormal(ServerWorld world, BlockPos pos, int distance, boolean persistent) {
        world.setBlockState(
                pos,
                TreesGroup.FEIJOA_LEAVES.get()
                        .getDefaultState()
                        .with(LeavesBlock.DISTANCE, distance)
                        .with(LeavesBlock.PERSISTENT, persistent),
                3
        );
    }

    private void setFruiting(ServerWorld world, BlockPos pos, int distance, boolean persistent) {
        world.setBlockState(
                pos,
                TreesGroup.FEIJOA_FRUITING_LEAVES.get()
                        .getDefaultState()
                        .with(LeavesBlock.DISTANCE, distance)
                        .with(LeavesBlock.PERSISTENT, persistent),
                3
        );
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

        boolean warmSummer = isSummerAllowed(worldIn, pos);

        int distance = state.get(LeavesBlock.DISTANCE);
        boolean persistent = state.get(LeavesBlock.PERSISTENT);

        if ("SUMMER".equals(currentSeason) && random.nextInt(25) == 0) {
            if (warmSummer) {
                    setFruiting(worldIn, pos, distance, persistent);
                } else {
                    setNormal(worldIn, pos, distance, persistent);
                }
        }

        if ("FALL".equals(currentSeason) && random.nextInt(2) == 0) {
            if (warmSummer) {
                setFruiting(worldIn, pos, distance, persistent);
            } else {
                setNormal(worldIn, pos, distance, persistent);
            }
        }

        if ("WINTER".equals(currentSeason) && random.nextInt(2) == 0) {

                setNormal(worldIn, pos, distance, persistent);

        }
    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 90;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 100;
    }
}
