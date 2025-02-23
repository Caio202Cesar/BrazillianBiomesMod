package com.brbiomesmod.features;

import com.brbiomesmod.block.PassionfruitVine;
import com.mojang.serialization.Codec;
import net.minecraft.block.VineBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class PassionFruitVineTrunkDecorator extends TreeDecorator {
    public static final Codec<PassionFruitVineTrunkDecorator> CODEC = Codec.unit(PassionFruitVineTrunkDecorator::new);
    public static final PassionFruitVineTrunkDecorator INSTANCE = new PassionFruitVineTrunkDecorator();

    @Override
    protected TreeDecoratorType<?> getDecoratorType() {
        // Return your registered type. Replace with your custom type if desired.
        return ModTreeDecorators.PASSIONVINE_DECORATOR.get();
    }

    @Override
    public void func_225576_a_(ISeedReader world, Random rand, List<BlockPos> trunkPositions, List<BlockPos> leavesPositions, Set<BlockPos> placed, MutableBoundingBox boundingBox) {
        trunkPositions.forEach((pos) -> {
            if (rand.nextInt(3) > 0) {
                BlockPos blockpos = pos.west();
                if (Feature.isAirAt(world, blockpos)) {
                    this.func_227424_a_(world, blockpos, PassionfruitVine.EAST, placed, boundingBox);
                }
            }
            if (rand.nextInt(3) > 0) {
                BlockPos blockpos1 = pos.east();
                if (Feature.isAirAt(world, blockpos1)) {
                    this.func_227424_a_(world, blockpos1, PassionfruitVine.WEST, placed, boundingBox);
                }
            }
            if (rand.nextInt(3) > 0) {
                BlockPos blockpos2 = pos.north();
                if (Feature.isAirAt(world, blockpos2)) {
                    this.func_227424_a_(world, blockpos2, PassionfruitVine.SOUTH, placed, boundingBox);
                }
            }
            if (rand.nextInt(3) > 0) {
                BlockPos blockpos3 = pos.south();
                if (Feature.isAirAt(world, blockpos3)) {
                    this.func_227424_a_(world, blockpos3, PassionfruitVine.NORTH, placed, boundingBox);
                }
            }
        });
    }
}
