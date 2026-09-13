package com.brbiomesmod.block.Custom.Log;

import net.minecraft.block.*;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class CocoaLog extends RotatedPillarBlock {
    public CocoaLog() {
        super(Properties.from(Blocks.OAK_LOG).sound(SoundType.WOOD).hardnessAndResistance(2.0f).tickRandomly()
                .harvestTool(ToolType.AXE));
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

        for (Direction direction : Direction.Plane.HORIZONTAL) {

            if (random.nextFloat() <= 0.25F) {

                Direction opposite = direction.getOpposite();

                BlockPos cocoaPos = pos.offset(opposite);

                if (worldIn.getBlockState(cocoaPos).isAir()) {

                    BlockState cocoaState = Blocks.COCOA.getDefaultState()
                            .with(CocoaBlock.AGE, random.nextInt(3))
                            .with(CocoaBlock.HORIZONTAL_FACING, direction);

                    worldIn.setBlockState(cocoaPos, cocoaState, 3);
                }
            }
        }
    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 5;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 10;
    }

    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction direction, IPlantable plantable) {
        return true;
    }
}
