package com.brbiomesmod.block.Custom.Leaves;

import com.brbiomesmod.Seasons.Season;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.LlamaSpitEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IForgeShearable;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class SandboxTreeLeaves extends LeavesBlock implements IForgeShearable {
    private final Supplier<Block> nextStage;
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    public SandboxTreeLeaves(Properties properties, Supplier<Block> nextStage) {
        super(properties);
        this.nextStage = nextStage;
        this.setDefaultState(this.stateContainer.getBaseState()
                .with(FACING, Direction.NORTH));
    }

    //Attacking behavior
    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos,
                             BlockState oldState, boolean isMoving) {
        if (!world.isRemote) {
            world.getPendingBlockTicks().scheduleTick(pos, this, 20);
        }
    }

    @Override
    public void tick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {

        // Tick again in 20 ticks (1 second)
        world.getPendingBlockTicks().scheduleTick(pos, this, 20);

        // Look for players near the block (4 block radius)
        List<PlayerEntity> players = world.getEntitiesWithinAABB(
                PlayerEntity.class,
                new AxisAlignedBB(pos).grow(4.0D)
        );

        if (players.isEmpty()) return;

        // 25% chance to shoot per tick cycle
        if (rand.nextFloat() > 0.25f) return;

        shootLlamaSpit(world, pos, state);
    }

    private void shootLlamaSpit(ServerWorld world, BlockPos pos, BlockState state) {
        Direction dir = state.get(FACING);

        // Spit position
        double x = pos.getX() + 0.5 + dir.getXOffset() * 0.6;
        double y = pos.getY() + 0.6;
        double z = pos.getZ() + 0.5 + dir.getZOffset() * 0.6;

        // Create llama spit
        LlamaSpitEntity spit = new LlamaSpitEntity(EntityType.LLAMA_SPIT, world);

        // Set position
        spit.setLocationAndAngles(x, y, z, dir.getHorizontalAngle(), 0f);

        // Set motion
        spit.setMotion(
                dir.getXOffset() * 0.6,
                0.1,
                dir.getZOffset() * 0.6
        );

        world.addEntity(spit);

        // Sound event 1000 = dispenser "click"
        world.playEvent(1000, pos, 0);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext ctx) {
        return this.getDefaultState()
                .with(FACING, ctx.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    //Seasonal behavior
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
        String currentSeason = Season.getSeason(worldIn.getDayTime());

        //Dry season
        if ("SUMMER".equals(currentSeason) && nextStage != null && random.nextInt(15) == 0) {

        int distance = state.get(LeavesBlock.DISTANCE);
        boolean persistent = state.get(LeavesBlock.PERSISTENT);

        BlockState newState = nextStage.get().getDefaultState().with(LeavesBlock.DISTANCE, distance).with(LeavesBlock.PERSISTENT, persistent);

            worldIn.setBlockState(pos, newState, 2);

        }

        if ("FALL".equals(currentSeason) && nextStage != null && random.nextInt(5) == 0) {

            int distance = state.get(LeavesBlock.DISTANCE);
            boolean persistent = state.get(LeavesBlock.PERSISTENT);

            BlockState newState = nextStage.get().getDefaultState().with(LeavesBlock.DISTANCE, distance).with(LeavesBlock.PERSISTENT, persistent);

            worldIn.setBlockState(pos, newState, 2);

        }
    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 90;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 100;
    }
}
