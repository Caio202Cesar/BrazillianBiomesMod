package com.brbiomesmod.block;


import net.minecraft.block.*;
import net.minecraft.block.material.PushReaction;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class AcaiBunchBlock extends Block {
    public AcaiBunchBlock() {
        super(AbstractBlock.Properties.from(Blocks.BEEHIVE).zeroHardnessAndResistance().tickRandomly()
                .sound(SoundType.WET_GRASS).notSolid().doesNotBlockMovement().harvestTool(ToolType.HOE));
    }


    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 50;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 10;
    }

    public PushReaction getPushReaction(BlockState state) {
        return PushReaction.DESTROY;
    }
}
