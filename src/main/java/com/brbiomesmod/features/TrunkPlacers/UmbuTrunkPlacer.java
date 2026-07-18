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
                            .and(Codec.intRange(4, 6)
                                    .fieldOf("branches")
                                    .forGetter(tp -> tp.branchCount))
                            .and(Codec.intRange(5, 8)
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

        if (!config.forcePlacement) {
            func_236909_a_(reader, startPos.down());
        }

        //--------------------------------------------------
        // Main trunk
        //--------------------------------------------------

        int trunkHeight = Math.max(3, treeHeight - 2);

        BlockPos.Mutable trunkPos = new BlockPos.Mutable();

        for (int y = 0; y < trunkHeight; y++) {

            trunkPos.setPos(startPos).move(Direction.UP, y);

            func_236911_a_(
                    reader,
                    rand,
                    trunkPos,
                    logs,
                    box,
                    config);
        }

        BlockPos crownCenter = startPos.up(trunkHeight - 1);
        //--------------------------------------------------
        // Scaffold branches
        //--------------------------------------------------

        double startAngle = rand.nextDouble() * Math.PI * 2.0D;

        for (int i = 0; i < branchCount; i++) {

            BlockPos branchStart = crownCenter.up(rand.nextBoolean() ? 0 : 1);

            double angle =
                    startAngle +
                            (Math.PI * 2.0D * i) / branchCount +
                            (rand.nextDouble() - 0.5D) * 0.35D;

            growPrimaryBranch(
                    reader,
                    rand,
                    branchStart,
                    angle,
                    branchLength + rand.nextInt(3) - 1,
                    logs,
                    box,
                    config,
                    foliages);
        }

        return foliages;
    }

    private void growPrimaryBranch(
            IWorldGenerationReader reader,
            Random rand,
            BlockPos start,
            double angle,
            int length,
            Set<BlockPos> logs,
            MutableBoundingBox box,
            BaseTreeFeatureConfig config,
            List<FoliagePlacer.Foliage> foliages) {

        double x = start.getX() + 0.5D;
        double y = start.getY() + 0.2D;
        double z = start.getZ() + 0.5D;

        double dx = Math.cos(angle);
        double dz = Math.sin(angle);

        double verticalSpeed = -0.015D + rand.nextDouble() * 0.03D;

        BlockPos previous = start;

        for (int step = 0; step < length; step++) {

            x += dx;
            z += dz;

            y += verticalSpeed;

            verticalSpeed += (rand.nextDouble() - 0.5D) * 0.01D;

            verticalSpeed = MathHelper.clamp(verticalSpeed,
                    -0.05D,
                    0.05D);

            if (verticalSpeed > 0.15D)
                verticalSpeed = 0.15D;

            if (verticalSpeed < -0.15D)
                verticalSpeed = -0.15D;

            angle += (rand.nextDouble() - 0.5D) * 0.03D;

            dx = Math.cos(angle);
            dz = Math.sin(angle);

            BlockPos current = new BlockPos(
                    MathHelper.floor(x),
                    MathHelper.floor(y),
                    MathHelper.floor(z));

            //----------------------------------------------------
            // Heavy branch base
            //----------------------------------------------------

            placeLogLine(
                        reader,
                        rand,
                        previous,
                        current,
                        logs,
                        box,
                        config);


            //----------------------------------------------------
            // Secondary branch
            //----------------------------------------------------

            if (step == (length * 3) / 4) {

                double fork =
                        angle +
                                (rand.nextBoolean() ? 0.8D : -0.8D);

                growSecondaryBranch(
                        reader,
                        rand,
                        current,
                        fork,
                        2 + rand.nextInt(3),
                        logs,
                        box,
                        config,
                        foliages);
            }

            //----------------------------------------------------
            // Foliage attachment
            //----------------------------------------------------
            previous = current;
        }

        foliages.add(
                new FoliagePlacer.Foliage(
                        previous,
                        0,
                        false));
    }

    private void growSecondaryBranch(
            IWorldGenerationReader reader,
            Random rand,
            BlockPos start,
            double angle,
            int length,
            Set<BlockPos> logs,
            MutableBoundingBox box,
            BaseTreeFeatureConfig config,
            List<FoliagePlacer.Foliage> foliages) {

        double x = start.getX() + 0.5D;
        double y = start.getY() + 0.5D;
        double z = start.getZ() + 0.5D;

        double dx = Math.cos(angle);
        double dz = Math.sin(angle);

        double verticalSpeed = -0.03D + rand.nextDouble() * 0.02D;

        verticalSpeed += (rand.nextDouble() - 0.5D) * 0.18D;

        if (verticalSpeed > 0.12D)
            verticalSpeed = 0.12D;

        if (verticalSpeed < -0.12D)
            verticalSpeed = -0.12D;

        BlockPos last = start;

        for (int step = 0; step < length; step++) {

            x += dx;
            z += dz;
            y += verticalSpeed;

            angle += (rand.nextDouble() - 0.5D) * 0.05D;

            dx = Math.cos(angle);
            dz = Math.sin(angle);

            BlockPos current = new BlockPos(
                    MathHelper.floor(x),
                    MathHelper.floor(y),
                    MathHelper.floor(z));

            placeLogLine(
                    reader,
                    rand,
                    last,
                    current,
                    logs,
                    box,
                    config);

            if (step > 0) {
                foliages.add(new FoliagePlacer.Foliage(
                        current,
                        0,
                        false));
            }

            last = current;
        }

        foliages.add(new FoliagePlacer.Foliage(
                last,
                0,
                false));
    }

    private void placeLog(
            IWorldGenerationReader reader,
            Random rand,
            BlockPos pos,
            Set<BlockPos> logs,
            MutableBoundingBox box,
            BaseTreeFeatureConfig config) {

        if (logs.contains(pos)) {
            return;
        }

        func_236911_a_(
                reader,
                rand,
                pos,
                logs,
                box,
                config);
    }

    private void placeLogLine(
            IWorldGenerationReader reader,
            Random rand,
            BlockPos from,
            BlockPos to,
            Set<BlockPos> logs,
            MutableBoundingBox box,
            BaseTreeFeatureConfig config) {

        BlockPos delta = to.subtract(from);

        int steps = Math.max(
                Math.abs(delta.getX()),
                Math.max(
                        Math.abs(delta.getY()),
                        Math.abs(delta.getZ())));

        if (steps == 0) {
            placeLog(reader, rand, from, logs, box, config);
            return;
        }

        double dx = delta.getX() / (double) steps;
        double dy = delta.getY() / (double) steps;
        double dz = delta.getZ() / (double) steps;

        double x = from.getX();
        double y = from.getY();
        double z = from.getZ();

        for (int i = 0; i <= steps; i++) {

            placeLog(
                    reader,
                    rand,
                    new BlockPos(
                            MathHelper.floor(x + 0.5D),
                            MathHelper.floor(y + 0.5D),
                            MathHelper.floor(z + 0.5D)),
                    logs,
                    box,
                    config);

            x += dx;
            y += dy;
            z += dz;
        }
    }
}
