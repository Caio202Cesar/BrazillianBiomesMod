package com.brbiomesmod.features.FoliagePlacers;

import com.brbiomesmod.block.TreesGroup;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;

import java.util.Random;
import java.util.Set;

public class ParanaPineFoliagePlacer extends FoliagePlacer {
    public ParanaPineFoliagePlacer(FeatureSpread radius, FeatureSpread offset) {
        super(radius, offset);
    }

    public static final Codec<ParanaPineFoliagePlacer> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    FeatureSpread.CODEC.fieldOf("radius").forGetter(p -> p.radius),
                    FeatureSpread.CODEC.fieldOf("offset").forGetter(p -> p.offset)
            ).apply(instance, ParanaPineFoliagePlacer::new)
    );

    @Override
    protected FoliagePlacerType<?> getPlacerType() {
        return ModFoliagePlacer.PARANA_PINE_FOLIAGE_PLACER.get(); // Register your foliage placer type
    }

    @Override
    protected void func_230372_a_(IWorldGenerationReader world, Random random, BaseTreeFeatureConfig config, int trunkHeight, Foliage foliage, int radius, int offset, Set<BlockPos> leaves, int height, MutableBoundingBox boundingBox) {
        BlockPos center = foliage.func_236763_a_();

        // Offset for 2x2 trunk
        BlockPos[] trunkPositions = {
                center,
                center.east(),
                center.south(),
                center.east().south()
        };

        // First layer (upper fronds) - UPWARDS & SMALLER
        int upperFrondCount = 6 + random.nextInt(3);
        for (BlockPos trunkPos : trunkPositions) {
            for (int i = 0; i < upperFrondCount; i++) {
                double angle = 2 * Math.PI * i / upperFrondCount;
                int length = 3 + random.nextInt(2); // Smaller fronds
                generateFrond(world, random, config, trunkPos, angle, length, leaves, boundingBox, 1); // 1 = upwards
            }
        }

        // Second layer (middle fronds) - FLAT
        BlockPos lowerCenter = center.down(2);
        for (BlockPos trunkPos : trunkPositions) {
            for (int i = 0; i < upperFrondCount; i++) {
                double angle = 2 * Math.PI * i / upperFrondCount;
                int length = 4 + random.nextInt(2);
                generateFrond(world, random, config, trunkPos.down(2), angle, length, leaves, boundingBox, 0); // 0 = flat
            }
        }

        // Third layer (lower fronds) - DOWNWARDS & SMALLER
        BlockPos thirdLayerCenter = center.down(3);
        int denserFrondCount = upperFrondCount + 2;
        for (BlockPos trunkPos : trunkPositions) {
            for (int i = 0; i < denserFrondCount; i++) {
                double angle = 2 * Math.PI * i / denserFrondCount;
                int length = 2 + random.nextInt(2); // Same size as upper fronds
                generateFrond(world, random, config, trunkPos.down(3), angle, length, leaves, boundingBox, -1); // -1 = downwards
            }
        }
    }

    private void generateFrond(IWorldGenerationReader world, Random random, BaseTreeFeatureConfig config, BlockPos center, double angle, int length, Set<BlockPos> leaves, MutableBoundingBox boundingBox, int direction) {
        for (int i = 1; i <= length; i++) {
            int x = (int) (center.getX() + (i * Math.cos(angle)));
            int z = (int) (center.getZ() + (i * Math.sin(angle)));
            int y = center.getY() + (direction == 1 ? i / 3 : direction == -1 ? -i / 3 : 0); // Upwards (1), Downwards (-1), or Flat (0)

            BlockPos leafPos = new BlockPos(x, y, z);
            placeLeafAt(world, leafPos, leaves, boundingBox);
        }
    }

    private void placeLeafAt(IWorldGenerationReader world, BlockPos pos, Set<BlockPos> leaves, MutableBoundingBox boundingBox) {
        if (world.hasBlockState(pos, s -> s.isAir())) {
            world.setBlockState(pos, TreesGroup.PARANA_PINE_LEAVES.get().getDefaultState()
                    .with(LeavesBlock.PERSISTENT, true).with(LeavesBlock.DISTANCE, 1), 19);
            leaves.add(pos);
            boundingBox.expandTo(new MutableBoundingBox(pos, pos));
        }
    }

    @Override
    public int func_230374_a_(Random random, int trunkHeight, BaseTreeFeatureConfig config) {
        return 2;
    }

    @Override
    protected boolean func_230373_a_(Random random, int dx, int dy, int dz, int radius, boolean large) {
        return dx * dx + dz * dz <= radius * radius;
    }
}




