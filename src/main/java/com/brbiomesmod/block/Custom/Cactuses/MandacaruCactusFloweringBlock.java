package com.brbiomesmod.block.Custom.Cactuses;

import com.brbiomesmod.block.TreesGroup;
import net.minecraft.block.*;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

public class MandacaruCactusFloweringBlock extends Block {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_2;
    public static final BooleanProperty FRUITED = BooleanProperty.create("fruited");
    private final MandacaruCactusBlock plantBlock;

    public MandacaruCactusFloweringBlock(MandacaruCactusBlock plantBlock, AbstractBlock.Properties builder) {
        super(builder);
        this.plantBlock = plantBlock;
        this.setDefaultState(this.stateContainer.getBaseState()
                .with(AGE, 0)
                .with(FRUITED, Boolean.FALSE));
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(AGE, FRUITED);
    }

    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (!state.isValidPosition(worldIn, pos)) {
            worldIn.destroyBlock(pos, true);
        }
    }

    public boolean ticksRandomly(BlockState state) {
        return true;
    }

    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        BlockPos blockpos = pos.up();

        if (worldIn.isAirBlock(blockpos) && blockpos.getY() < 256) {
            int i = state.get(AGE);

            if (i < 2 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, blockpos, state, true)) {
                boolean flag = false;
                boolean flag1 = false;
                BlockState blockstate = worldIn.getBlockState(pos.down());
                Block block = blockstate.getBlock();
                if (block == Blocks.COARSE_DIRT) {
                    flag = true;
                } else if (block == this.plantBlock) {
                    int j = 1;

                    for(int k = 0; k < 4; ++k) {
                        Block block1 = worldIn.getBlockState(pos.down(j + 1)).getBlock();
                        if (block1 != this.plantBlock) {
                            if (block1 == Blocks.COARSE_DIRT) {
                                flag1 = true;
                            }
                            break;
                        }

                        ++j;
                    }

                    if (j < 2 || j <= random.nextInt(flag1 ? 5 : 4)) {
                        flag = true;
                    }
                } else if (blockstate.isAir(worldIn, pos.down())) {
                    flag = true;
                }

                if (flag && areAllNeighborsEmpty(worldIn, blockpos, (Direction)null) && worldIn.isAirBlock(pos.up(2))) {
                    worldIn.setBlockState(pos, this.plantBlock.makeConnections(worldIn, pos), 2);
                    this.placeBudFlower(worldIn, blockpos, i);
                } else if (i < 4) {
                    int l = random.nextInt(4);
                    if (flag1) {
                        ++l;
                    }

                    boolean flag2 = false;

                    for(int i1 = 0; i1 < l; ++i1) {
                        Direction direction = Direction.Plane.HORIZONTAL.random(random);
                        BlockPos blockpos1 = pos.offset(direction);
                        if (worldIn.isAirBlock(blockpos1) && worldIn.isAirBlock(blockpos1.down()) && areAllNeighborsEmpty(worldIn, blockpos1, direction.getOpposite())) {
                            this.placeBudFlower(worldIn, blockpos1, i + 1);
                            flag2 = true;
                        }
                    }

                    if (flag2) {
                        worldIn.setBlockState(pos, this.plantBlock.makeConnections(worldIn, pos), 2);
                    } else {
                        this.placeOpenFlower(worldIn, pos);
                    }
                } else {
                    this.placeOpenFlower(worldIn, pos);
                }
                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
            }
        }

        if (state.get(AGE) == 2 && !state.get(FRUITED)) {

            // Attempt to place fruit on all available horizontal sides.
            // This helper will return after checking all four directions.

            this.placeFruitOnAvailableSides(worldIn, pos);

            // Mark this flower as having completed its fruiting attempt.
            worldIn.setBlockState(
                    pos,
                    state.with(FRUITED, Boolean.valueOf(true)),
                    2
            );

            return;
        }
    }

    private void placeBudFlower(World worldIn, BlockPos pos, int age) {
        worldIn.setBlockState(pos, this.getDefaultState().with(AGE, Integer.valueOf(age)), 2);
        worldIn.playEvent(1033, pos, 0);
    }

    private void placeOpenFlower(World worldIn, BlockPos pos) {
        worldIn.setBlockState(pos, this.getDefaultState().with(AGE, Integer.valueOf(1)), 2);
        worldIn.playEvent(1034, pos, 0);
    }

    private void placeFruitingBlock(World worldIn, BlockPos pos) {
        worldIn.setBlockState(pos, this.getDefaultState().with(AGE, Integer.valueOf(2)), 2);
        worldIn.playEvent(1035, pos, 0);
    }

    private void placeFruitOnAvailableSides(World worldIn, BlockPos pos) {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockPos fruitPos = pos.offset(direction);

            if (worldIn.isAirBlock(fruitPos)) {
                worldIn.setBlockState(
                        fruitPos,
                        TreesGroup.MANDACARU_FRUIT.get().getDefaultState(),
                        3
                );
            }
        }
    }

    private static boolean areAllNeighborsEmpty(IWorldReader worldIn, BlockPos pos, @Nullable Direction excludingSide) {
        for(Direction direction : Direction.Plane.HORIZONTAL) {
            if (direction != excludingSide && !worldIn.isAirBlock(pos.offset(direction))) {
                return false;
            }
        }

        return true;
    }

    /**
     * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
     * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
     * returns its solidified counterpart.
     * Note that this method should ideally consider only the specific face passed in.
     */
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (facing != Direction.UP && !stateIn.isValidPosition(worldIn, currentPos)) {
            worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 1);
        }

        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockState blockstate = worldIn.getBlockState(pos.down());
        if (blockstate.getBlock() != this.plantBlock && !blockstate.matchesBlock(Blocks.COARSE_DIRT)) {
            if (!blockstate.isAir(worldIn, pos.down())) {
                return false;
            } else {
                boolean flag = false;

                for(Direction direction : Direction.Plane.HORIZONTAL) {
                    BlockState blockstate1 = worldIn.getBlockState(pos.offset(direction));
                    if (blockstate1.matchesBlock(this.plantBlock)) {
                        if (flag) {
                            return false;
                        }

                        flag = true;
                    } else if (!blockstate1.isAir(worldIn, pos.offset(direction))) {
                        return false;
                    }
                }

                return flag;
            }
        } else {
            return true;
        }
    }

    public static void generatePlant(IWorld worldIn, BlockPos pos, Random rand, int maxHorizontalDistance) {
        worldIn.setBlockState(pos, ((MandacaruCactusBlock)TreesGroup.MANDACARU_CACTUS.get()).makeConnections(worldIn, pos), 2);
        growTreeRecursive(worldIn, pos, rand, pos, maxHorizontalDistance, 0);
    }

    private static void growTreeRecursive(IWorld worldIn, BlockPos branchPos, Random rand, BlockPos originalBranchPos, int maxHorizontalDistance, int iterations) {
        MandacaruCactusBlock mandacaruCactusBlock = (MandacaruCactusBlock)TreesGroup.MANDACARU_CACTUS.get();
        int i = rand.nextInt(4) + 1;
        if (iterations == 0) {
            ++i;
        }

        for(int j = 0; j < i; ++j) {
            BlockPos blockpos = branchPos.up(j + 1);
            if (!areAllNeighborsEmpty(worldIn, blockpos, (Direction)null)) {
                return;
            }

            worldIn.setBlockState(blockpos, mandacaruCactusBlock.makeConnections(worldIn, blockpos), 2);
            worldIn.setBlockState(blockpos.down(), mandacaruCactusBlock.makeConnections(worldIn, blockpos.down()), 2);
        }

        boolean flag = false;
        if (iterations < 4) {
            int l = rand.nextInt(4);
            if (iterations == 0) {
                ++l;
            }

            for(int k = 0; k < l; ++k) {
                Direction direction = Direction.Plane.HORIZONTAL.random(rand);
                BlockPos blockpos1 = branchPos.up(i).offset(direction);
                if (Math.abs(blockpos1.getX() - originalBranchPos.getX()) < maxHorizontalDistance && Math.abs(blockpos1.getZ() - originalBranchPos.getZ()) < maxHorizontalDistance && worldIn.isAirBlock(blockpos1) && worldIn.isAirBlock(blockpos1.down()) && areAllNeighborsEmpty(worldIn, blockpos1, direction.getOpposite())) {
                    flag = true;
                    worldIn.setBlockState(blockpos1, mandacaruCactusBlock.makeConnections(worldIn, blockpos1), 2);
                    worldIn.setBlockState(blockpos1.offset(direction.getOpposite()), mandacaruCactusBlock.makeConnections(worldIn, blockpos1.offset(direction.getOpposite())), 2);
                    growTreeRecursive(worldIn, blockpos1, rand, originalBranchPos, maxHorizontalDistance, iterations + 1);
                }
            }
        }

        if (!flag) {
            worldIn.setBlockState(branchPos.up(i), TreesGroup.MANDACARU_CACTUS_FLOWERING.get().getDefaultState().with(AGE, Integer.valueOf(1)), 2);
        }

    }

    public void onProjectileCollision(World worldIn, BlockState state, BlockRayTraceResult hit, ProjectileEntity projectile) {
        if (projectile.getType().isContained(EntityTypeTags.IMPACT_PROJECTILES)) {
            BlockPos blockpos = hit.getPos();
            worldIn.destroyBlock(blockpos, true, projectile);
        }

    }
}
