package com.brbiomesmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;
import java.util.logging.Level;

import static net.minecraft.state.properties.DoubleBlockHalf.LOWER;
import static net.minecraft.state.properties.DoubleBlockHalf.UPPER;

public class DoubleCropBlock extends CropsBlock {
    public static final EnumProperty<DoubleBlockHalf> SECTION = BlockStateProperties.DOUBLE_BLOCK_HALF;
    private static final VoxelShape[] LOWER_SHAPE_BY_AGE = new VoxelShape[]{
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};
    private static final VoxelShape[] UPPER_SHAPE_BY_AGE = new VoxelShape[]{
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    public DoubleCropBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(this.getAgeProperty(), Integer.valueOf(0)));
    }

    public BlockState withAge(int age) {
        return this.getDefaultState().with(this.getAgeProperty(), Integer.valueOf(age));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(SECTION)) {
            case LOWER:
                return LOWER_SHAPE_BY_AGE[state.get(this.getAgeProperty())];
            case UPPER:
                return UPPER_SHAPE_BY_AGE[state.get(this.getAgeProperty())];
        }
        return super.getShape(state, worldIn, pos, context);
    }

    protected DoubleBlockHalf getSection(BlockState state) {
        return state.get(SECTION);
    }

    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.matchesBlock(Blocks.FARMLAND);
    }
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
        DoubleBlockHalf doubleblockhalf = stateIn.getValue(SECTION);
        if (facing.getAxis() != Direction.Axis.Y || doubleblockhalf == LOWER != (facing == Direction.UP) || facingState.is(this) && facingState.getValue(SECTION) != doubleblockhalf) {
            return doubleblockhalf == LOWER && facing == Direction.DOWN && !stateIn.canSurvive(worldIn, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        } else {
            return Blocks.AIR.defaultBlockState();
        }
    }

    public boolean ticksRandomly(BlockState state) {
    return !this.isMaxAge(state);
}

public boolean ticksRandomly(BlockState state) {
    return !this.isMaxAge(state) && getSection(state).equals(LOWER);
    }

public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
    if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
    if (worldIn.getLightSubtracted(pos, 0) >= 9) {
        int i = this.getAge(state);
        if (i < this.getMaxAge()) {
            float f = getGrowthChance(this, worldIn, pos);
            if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt((int)(25.0F / f) + 1) == 0)) {
                worldIn.setBlockState(pos, this.withAge(i + 1), 2);
                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
            }
        }
    }

}

    @Override
    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource random) {
        if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (worldIn.getRawBrightness(pos, 0) >= 9) {
            if (worldIn.getBlockState(pos.above()).is(Blocks.AIR) || worldIn.getBlockState(pos.above()).is(this)) {
                int i = this.getAge(state);
                if (i < this.getMaxAge()) {
                    float f = getGrowthSpeed(this, worldIn, pos);
                    if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt((int) (25.0F / f) + 1) == 0)) {
                        worldIn.setBlock(pos, this.getStateForAge(i + 1).setValue(SECTION, LOWER), 2);
                        worldIn.setBlock(pos.above(), this.getStateForAge(i + 1).setValue(SECTION, UPPER), 2);
                        net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
                    }
                }
            }
        }
    }

    @Override
    public void growCrops(Level worldIn, BlockPos pos, BlockState state) {
        int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
        int j = this.getMaxAge();
        if (i > j) {
            i = j;
        }
        switch (state.getValue(SECTION)) {
            case LOWER:
                worldIn.setBlock(pos, this.getStateForAge(i).setValue(SECTION, LOWER), 2);
                worldIn.setBlock(pos.above(), this.getStateForAge(i).setValue(SECTION, UPPER), 2);
                break;
            case UPPER:
                worldIn.setBlock(pos.below(), this.getStateForAge(i).setValue(SECTION, LOWER), 2);
                worldIn.setBlock(pos, this.getStateForAge(i).setValue(SECTION, UPPER), 2);
                break;
        }
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelIn, BlockPos pos, BlockState state, boolean isClient) {
        switch (state.getValue(SECTION)) {
            case LOWER:
                return !this.isMaxAge(state) && (levelIn.getBlockState(pos.above()).is(Blocks.AIR) || levelIn.getBlockState(pos.above()).is(this));
            case UPPER:
                return !this.isMaxAge(state);
        }
        return !this.isMaxAge(state);
    }

    @Override
    public void playerWillDestroy(Level worldIn, BlockPos pos, BlockState state, Player player) {
        if (!worldIn.isClientSide) {
            if (player.isCreative()) {
                removeLowerSections(worldIn, pos, state, player);
            }
        }
        super.playerWillDestroy(worldIn, pos, state, player);
    }

    protected static void removeLowerSections(Level world, BlockPos pos, BlockState state, Player player) {
        if (state.getValue(SECTION).equals(UPPER)) {
            BlockPos blockpos = pos.below(1);
            BlockState blockstate = world.getBlockState(blockpos);
            if (blockstate.getBlock() == state.getBlock() && blockstate.getValue(SECTION) == LOWER) {
                world.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 35);
                world.levelEvent(player, 2001, blockpos, Block.getId(blockstate));
            }
        }
    }

    public void placeAt(LevelAccessor worldIn, BlockPos pos, int flags) {
        worldIn.setBlock(pos, this.defaultBlockState().setValue(AGE, 7).setValue(SECTION, LOWER), flags);
        worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(AGE, 7).setValue(SECTION, UPPER), flags);
    }

}
