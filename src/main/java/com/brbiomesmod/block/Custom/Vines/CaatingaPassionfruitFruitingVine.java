package com.brbiomesmod.block.Custom.Vines;

import com.brbiomesmod.block.PlantsGroup;
import com.brbiomesmod.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.VineBlock;
import net.minecraft.block.material.Material;
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

public class CaatingaPassionfruitFruitingVine extends VineBlock {
    public CaatingaPassionfruitFruitingVine() {
        super(Properties.from(Blocks.VINE).tickRandomly().zeroHardnessAndResistance()
                .sound(SoundType.PLANT).doesNotBlockMovement().notSolid().harvestTool(ToolType.HOE));
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
    //Hardiness Zone 9 to 13
    public static final float MIN_TEMP = 0.8F;
    public static final float MAX_TEMP = 2F;

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        super.randomTick(state, worldIn, pos, random);

        //Growth Logic
        float temp = worldIn.getBiome(pos).getTemperature();
        boolean underGlass = isUnderGlass(worldIn, pos);

        if (temp < MIN_TEMP && !underGlass || temp > MAX_TEMP) {
            if (random.nextFloat() < 0.25F) {
                worldIn.destroyBlock(pos, false); // no drop
            }

            return;
        }

        super.randomTick(state, worldIn, pos, random);

        double chance = 0.001;

        if (random.nextDouble() < chance) {

            BlockState currentState = state;
            BlockState newState = PlantsGroup.CAATINGA_PASSION_FRUIT_VINE.get().getDefaultState();

            worldIn.setBlockState(pos, PlantsGroup.CAATINGA_PASSION_FRUIT_VINE.get().getDefaultState());

            newState = newState.with(VineBlock.NORTH, currentState.get(VineBlock.NORTH)).with(VineBlock.EAST, currentState.get(VineBlock.EAST))
                    .with(VineBlock.SOUTH, currentState.get(VineBlock.SOUTH)).with(VineBlock.WEST, currentState.get(VineBlock.WEST));

            worldIn.setBlockState(pos, newState, 3);
        }
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote) {

            ItemStack itemStack = new ItemStack(ModItems.CAATINGA_PASSIONFRUIT.get());
            ItemEntity itemEntity = new ItemEntity(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, itemStack);

            worldIn.addEntity(itemEntity);

            BlockState currentState = state;
            BlockState newState = PlantsGroup.CAATINGA_PASSION_FRUIT_VINE.get().getDefaultState();

            newState = newState.with(VineBlock.NORTH, currentState.get(VineBlock.NORTH)).with(VineBlock.EAST, currentState.get(VineBlock.EAST))
                    .with(VineBlock.SOUTH, currentState.get(VineBlock.SOUTH)).with(VineBlock.WEST, currentState.get(VineBlock.WEST));

            worldIn.setBlockState(pos, newState, 3);

            worldIn.playSound(null, pos, SoundEvents.BLOCK_GRASS_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);

        }
        return ActionResultType.SUCCESS;
    }

    private boolean isUnderGlass(ServerWorld world, BlockPos pos) {

        BlockPos.Mutable checkPos = new BlockPos.Mutable(pos.getX(), pos.getY() + 1, pos.getZ());

        while (checkPos.getY() < world.getHeight()) {

            BlockState stateAbove = world.getBlockState(checkPos);

            if (stateAbove.isAir() || stateAbove.getBlock() instanceof VineBlock) {
                checkPos.move(Direction.UP);
                continue;
            }

            // If this block is glass → protected
            if (stateAbove.getMaterial() == Material.GLASS) {
                return true;
            }

            // Any other solid block blocks protection
            return false;
        }

        return false;
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
