package com.brbiomesmod.block.Custom.Vines;

import com.brbiomesmod.block.PlantsGroup;
import com.brbiomesmod.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.VineBlock;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class PassionfruitFruitingVine extends VineBlock {
    public PassionfruitFruitingVine() {
        super(Properties.from(Blocks.VINE).tickRandomly().zeroHardnessAndResistance()
                .sound(SoundType.PLANT).doesNotBlockMovement().notSolid().harvestTool(ToolType.HOE));
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote) {

            ItemStack itemStack = new ItemStack(ModItems.PASSIONFRUIT.get());
            ItemEntity itemEntity = new ItemEntity(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, itemStack);

            worldIn.addEntity(itemEntity);

            BlockState currentState = state;
            BlockState newState = PlantsGroup.PASSION_FRUIT_VINE.get().getDefaultState();

            newState = newState.with(VineBlock.NORTH, currentState.get(VineBlock.NORTH)).with(VineBlock.EAST, currentState.get(VineBlock.EAST))
                    .with(VineBlock.SOUTH, currentState.get(VineBlock.SOUTH)).with(VineBlock.WEST, currentState.get(VineBlock.WEST));

            worldIn.setBlockState(pos, newState, 3);

            worldIn.playSound(null, pos, SoundEvents.BLOCK_GRASS_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);

        }
        return ActionResultType.SUCCESS;
    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 90;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 85;
    }

    public PlantType getPlantType(IBlockReader world, BlockPos pos) {
        return PlantType.CROP;
    }
}
