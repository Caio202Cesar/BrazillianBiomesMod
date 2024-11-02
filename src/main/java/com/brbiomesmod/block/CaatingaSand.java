package com.brbiomesmod.block;

import net.minecraft.block.*;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.ToolType;

public class CaatingaSand extends Block {
    public CaatingaSand() {
        super(AbstractBlock.Properties.from(Blocks.SAND).harvestLevel(1).harvestTool(ToolType.SHOVEL)
                .hardnessAndResistance(0.5f).sound(SoundType.SAND));
    }

    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction direction, IPlantable plantable) {
        return true;
    }

    public boolean matchesBlock(Block block) {
        return this == block;
    }
}
