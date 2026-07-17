package com.brbiomesmod.features.TrunkPlacers;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.trunkplacer.AbstractTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.TrunkPlacerType;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class UmbuTrunkPlacer extends AbstractTrunkPlacer {
    public static final Codec<UmbuTrunkPlacer> CODEC =
            RecordCodecBuilder.create(instance ->
                    getAbstractTrunkCodec(instance)
                            .and(Codec.intRange(4, 8)
                                    .fieldOf("branches")
                                    .forGetter(tp -> tp.branchCount))
                            .and(Codec.intRange(4, 16)
                                    .fieldOf("branch_length")
                                    .forGetter(tp -> tp.branchLength))
                            .apply(instance, UmbuTrunkPlacer::new));

    private final int branchCount;
    private final int branchLength;

    public UmbuTrunkPlacer(int baseHeight,
                               int heightRandA,
                               int heightRandB,
                               int branchCount,
                               int branchLength) {

        super(baseHeight, heightRandA, heightRandB);

        this.branchCount = branchCount;
        this.branchLength = branchLength;
    }

    @Override
    protected TrunkPlacerType<?> getPlacerType() {
        return ModTrunkPlacers.UMBU_TRUNK;
    }

    @Override
    public List<FoliagePlacer.Foliage> getFoliages(
            IWorldGenerationReader reader,
            Random rand,
            int treeHeight,
            BlockPos startPos,
            Set<BlockPos> logs,
            MutableBoundingBox box,
            BaseTreeFeatureConfig config) {

        List<FoliagePlacer.Foliage> foliages = Lists.newArrayList();

        // Vanilla dirt placement
        func_236909_a_(reader, startPos.down());

        // --------------------------
        // Main trunk
        // --------------------------

        BlockPos.Mutable pos = new BlockPos.Mutable();

        for (int y = 0; y < treeHeight; y++) {

            pos.setPos(startPos).move(Direction.UP, y);

            func_236911_a_(
                    reader,
                    rand,
                    pos,
                    logs,
                    box,
                    config);
        }

        BlockPos trunkTop = startPos.up(treeHeight - 1);

        // --------------------------
        // Scaffold branches
        // --------------------------

        double startAngle = rand.nextDouble() * Math.PI * 2.0;

        for (int i = 0; i < branchCount; i++) {

            double angle =
                    startAngle +
                            (Math.PI * 2.0 * i) / branchCount;

            double x = trunkTop.getX() + 0.5;
            double y = trunkTop.getY();
            double z = trunkTop.getZ() + 0.5;

            double dx = Math.cos(angle);
            double dz = Math.sin(angle);

            BlockPos lastPos = trunkTop;

            for (int step = 0; step < branchLength; step++) {

                x += dx;
                z += dz;

                // Almost horizontal branches
                if (rand.nextFloat() < 0.12F)
                    y++;

                // Small curvature
                angle += (rand.nextFloat() - 0.5F) * 0.08F;

                dx = Math.cos(angle);
                dz = Math.sin(angle);

                lastPos = new BlockPos(
                        MathHelper.floor(x),
                        MathHelper.floor(y),
                        MathHelper.floor(z));

                placeLog(
                        reader,
                        rand,
                        lastPos,
                        logs,
                        box,
                        config);
            }

            foliages.add(
                    new FoliagePlacer.Foliage(
                            lastPos,
                            0,
                            false));
        }

        return foliages;
    }

    private void placeLog(IWorldGenerationReader reader,
                          Random rand,
                          BlockPos pos,
                          Set<BlockPos> logs,
                          MutableBoundingBox box,
                          BaseTreeFeatureConfig config) {

        func_236911_a_(
                reader,
                rand,
                pos,
                logs,
                box,
                config);
    }
}
