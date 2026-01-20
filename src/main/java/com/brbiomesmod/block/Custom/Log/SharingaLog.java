package com.brbiomesmod.block.Custom.Log;

import com.brbiomesmod.block.TreesGroup;
import com.brbiomesmod.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class SharingaLog extends RotatedPillarBlock {
    public SharingaLog() {
        super(Properties.from(Blocks.OAK_LOG).sound(SoundType.WOOD).hardnessAndResistance(2.0f)
                .harvestTool(ToolType.AXE));
    }

    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        super.onBlockClicked(state, worldIn, pos, player);

        if (worldIn.isRemote) return;

        ItemStack stack = player.getHeldItemMainhand();

        // 🔪 Require tapping knife
        if (stack.getItem() != ModItems.TAPPING_KNIFE.get())
            return;

        // Prevent re-stripping
        if (state.getBlock() == TreesGroup.SHARINGA_STRIPPED_LOG.get())
            return;

        Direction.Axis axis = state.get(RotatedPillarBlock.AXIS);

        worldIn.setBlockState(
                pos,
                TreesGroup.SHARINGA_STRIPPED_LOG.get()
                        .getDefaultState()
                        .with(RotatedPillarBlock.AXIS, axis),
                3
        );

        // Damage knife
        stack.damageItem(1, player,
                p -> p.sendBreakAnimation(Hand.MAIN_HAND));
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
