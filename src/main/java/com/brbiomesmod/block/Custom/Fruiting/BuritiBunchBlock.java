package com.brbiomesmod.block.Custom.Fruiting;


import com.brbiomesmod.block.TreesGroup;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.PushReaction;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class BuritiBunchBlock extends Block {
    public static final IntegerProperty LENGTH = IntegerProperty.create("length", 1, 3);

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(LENGTH);
    }

    public BuritiBunchBlock() {
        super(Properties.from(Blocks.BEEHIVE)
                .zeroHardnessAndResistance()
                .tickRandomly()
                .sound(SoundType.WET_GRASS)
                .notSolid()
                .doesNotBlockMovement()
                .harvestTool(ToolType.HOE));

        this.setDefaultState(this.stateContainer.getBaseState().with(LENGTH, 1));
    }

    public boolean ticksRandomly(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        super.randomTick(state, world, pos, random);

        if (random.nextFloat() < 0.0022f) {
            BlockPos belowPos = pos.down();
            BlockState belowState = world.getBlockState(belowPos);

            // Check if the space below is air
            if (belowState.isAir()) {
                int length = state.get(LENGTH);

                if (length < 3 && world.isAirBlock(pos.down())) {
                    world.setBlockState(
                            pos.down(),
                            this.getDefaultState().with(LENGTH, length + 1),
                            2
                    );
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderLayer() {
        RenderTypeLookup.setRenderLayer(TreesGroup.BURITI_BUNCH.get(), RenderType.getCutout());

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
