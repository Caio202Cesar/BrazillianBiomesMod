package com.brbiomesmod.block;

import net.minecraft.block.*;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class ModPlanks extends Block {
    public ModPlanks() {
        super(AbstractBlock.Properties.from(Blocks.OAK_PLANKS).hardnessAndResistance(2.0f, 3.0f)
                .sound(SoundType.WOOD).harvestTool(ToolType.AXE));
    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 20;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 10;
    }
}
