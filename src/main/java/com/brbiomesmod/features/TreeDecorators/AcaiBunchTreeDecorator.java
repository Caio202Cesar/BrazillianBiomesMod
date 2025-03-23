package com.brbiomesmod.features.TreeDecorators;

import com.brbiomesmod.block.BlockClasses.AmazonRainforestBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.List;
import java.util.Random;
import java.util.Set;

import static net.minecraft.command.arguments.BlockStateArgument.getBlockState;

public class AcaiBunchTreeDecorator extends TreeDecorator {
    public static final Codec<AcaiBunchTreeDecorator> CODEC = Codec.unit(AcaiBunchTreeDecorator::new);
    public static final AcaiBunchTreeDecorator INSTANCE = new AcaiBunchTreeDecorator();

    @Override
    protected TreeDecoratorType<?> getDecoratorType() {
        return ModTreeDecorators.ACAI_BUNCH_DECORATOR.get();
    }

    @Override
    public void func_225576_a_(ISeedReader world, Random rand, List<BlockPos> p_225576_3_, List<BlockPos> p_225576_4_, Set<BlockPos> p_225576_5_, MutableBoundingBox p_225576_6_) {
        if (p_225576_3_.isEmpty()) return; // Safety check

        for (BlockPos logPos : p_225576_3_) {
            if (logPos.getY() >= 5) { // Only generate at Y >= 5
                if (rand.nextFloat() < 0.25F) { // 25% chance per log
                    Direction direction = Direction.Plane.HORIZONTAL.random(rand);
                    BlockPos targetPos = logPos.offset(direction);

                    if (world.hasBlockState(targetPos, BlockState::isAir)) { // Check if air
                        BlockState bunchState = AmazonRainforestBlocks.ACAI_BUNCH.get().getDefaultState()
                                .with(HorizontalBlock.HORIZONTAL_FACING, direction);

                        // Place the block in the world
                        func_227423_a_(world, targetPos, bunchState, p_225576_5_, p_225576_6_);
                    }
                }
            }
        }
    }
}
