package com.brbiomesmod.block.Custom.Leaves;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.IForgeShearable;
import net.minecraftforge.common.ToolType;

public class ModLeaves extends LeavesBlock implements IForgeShearable {
    public ModLeaves() {
        super(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE));
    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 90;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 100;
    }
}
