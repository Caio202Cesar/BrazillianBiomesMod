package com.brbiomesmod.block;

import com.brbiomesmod.Seasons.Season;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class PindoBunchBlock extends Block {
    public PindoBunchBlock() {
        super(Properties.create(Material.PLANTS).hardnessAndResistance(0.2F).tickRandomly()
                .sound(SoundType.WET_GRASS).harvestTool(ToolType.HOE));
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

        if ("FALL".equals(currentSeason) && random.nextFloat() < 0.0925F) {

            worldIn.destroyBlock(pos, true);

        }
    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 1;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 1;
    }

}
