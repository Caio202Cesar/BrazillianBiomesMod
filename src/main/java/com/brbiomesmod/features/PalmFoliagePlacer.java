package com.brbiomesmod.features;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.block.BlockClasses.AtlanticForestBlocks;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;

import java.util.Random;
import java.util.Set;

/*public class PalmFoliagePlacer extends FoliagePlacer {
    public static final Codec<PalmFoliagePlacer> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    FeatureSpread.CODEC.fieldOf("radius").forGetter(placer -> placer.radius),
                    FeatureSpread.CODEC.fieldOf("offset").forGetter(placer -> placer.offset)
            ).apply(instance, PalmFoliagePlacer::new));

    public PalmFoliagePlacer(FeatureSpread radius, FeatureSpread offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> getPlacerType() {
        return ModFoliagePlacer.PALM_FOLIAGE_PLACER.get(); // Replace with your actual registry reference
    }

    @Override
    public void func_236752_a_(IWorldGenerationReader p_236752_1_, Random p_236752_2_, BaseTreeFeatureConfig p_236752_3_, int p_236752_4_, Foliage p_236752_5_, int p_236752_6_, int p_236752_7_, Set<BlockPos> p_236752_8_, MutableBoundingBox p_236752_9_) {

        BlockPos startingPos = foliage.func_236763_a_();

        this.func_230372_a_(p_236752_1_, p_236752_2_, p_236752_3_, p_236752_4_, p_236752_5_, p_236752_6_, p_236752_7_, p_236752_8_, p_236752_9_);

        createQuadrant(Direction.NORTH, startingPos, pLevel, foliageSetter, pRandom, pConfig);
        createQuadrant(Direction.EAST, startingPos, pLevel, foliageSetter, pRandom, pConfig);
        createQuadrant(Direction.SOUTH, startingPos, pLevel, foliageSetter, pRandom, pConfig);
        createQuadrant(Direction.WEST, startingPos, pLevel, foliageSetter, pRandom, pConfig);

    }

    @Override
    protected void func_230372_a_(IWorldGenerationReader p_230372_1_, Random p_230372_2_, BaseTreeFeatureConfig p_230372_3_, int p_230372_4_, Foliage p_230372_5_, int p_230372_6_, int p_230372_7_, Set<BlockPos> p_230372_8_, int p_230372_9_, MutableBoundingBox p_230372_10_) {

    }

    @Override
    public int func_230374_a_(Random random, int trunkHeight, BaseTreeFeatureConfig config) {
        return 0; // Defines foliage height
    }

    @Override
    protected boolean func_230373_a_(Random random, int x, int y, int z, int radius, boolean giantTrunk) {
        return false; // Ensures leaves are properly placed
    }

    private static void createQuadrant(Direction direction, BlockPos startingPos, IWorldGenerationReader world, FoliagePlacer foliageSetter, Random random, BaseTreeFeatureConfig config) {
        BlockPos.Mutable pos = startingPos.toMutable();

        pos.move(direction);
        placeLeafAt(world, random, config, trunkHeight, foliage, foliageHeight, radius, leaves, offset, boundingBox);

        /*if (random.nextInt(2) == 0) {
            if (world.hasBlockState(pos.down(), state -> state.isAir())) {
                foliageSetter.set(pos.below(), ObjectRegistry.HANGING_COCONUT.get().defaultBlockState().setValue(HangingCoconutBlock.AGE, pRandom.nextInt(3)));
            }
        }
        if (pRandom.nextInt(2) == 0) {
            if (pLevel.isStateAtPosition(pos.below().relative(direction.getCounterClockWise()), BlockBehaviour.BlockStateBase::isAir)) {
                foliageSetter.set(pos.below().relative(direction.getCounterClockWise()), ObjectRegistry.HANGING_COCONUT.get().defaultBlockState().setValue(HangingCoconutBlock.AGE, pRandom.nextInt(3)));
            }
        }

        for (int i = 0; i < 2; i++) {
            pos.move(direction);
            placeLeafAt(direction, startingPos, world, foliageSetter, random, config);
            pos.move(Direction.DOWN);
            placeLeafAt(direction, startingPos, world, foliageSetter, random, config);
        }

        pos.add(startingPos);
        pos.move(direction).move(direction.getOpposite());
        placeLeafAt(direction, startingPos, world, foliageSetter, random, config);
        pos.move(Direction.DOWN).move(direction.rotateYCCW());
        placeLeafAt(direction, startingPos, world, foliageSetter, random, config);
        pos.move(direction);
        placeLeafAt(direction, pos.rotate(Rotation.randomRotation(random)), world, foliageSetter, random, config);
        for (int i = 0; i < 3; i++) {
            placeLeafAt(direction, startingPos, world, foliageSetter, random, config);
            pos.move(Direction.DOWN);
        }
    }
}*/


