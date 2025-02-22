package com.brbiomesmod.features;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.VineBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;
import java.util.function.Supplier;

public class PassionFruitVineFeature extends Feature<NoFeatureConfig> {
    private final Supplier<BlockState> vineStateSupplier;

    public PassionFruitVineFeature(Codec<NoFeatureConfig> codec, Supplier<BlockState> vineStateSupplier) {
        super(codec);
        this.vineStateSupplier = vineStateSupplier;
    }

    @Override
    public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        if (reader.isAirBlock(pos)) {
            Direction direction = Direction.Plane.HORIZONTAL.random(rand);
            BlockPos offsetPos = pos.offset(direction.getOpposite());

            if (reader.getBlockState(offsetPos).isSolidSide(reader, offsetPos, direction)) {
                // Retrieve the vine state at generation time
                BlockState vineState = vineStateSupplier.get();
                reader.setBlockState(pos, vineState.with(VineBlock.getPropertyFor(direction), true), 2);
                return true;
            }
        }
        return false;
    }
}