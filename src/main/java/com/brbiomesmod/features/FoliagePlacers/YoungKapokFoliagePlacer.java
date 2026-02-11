package com.brbiomesmod.features.FoliagePlacers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;

import java.util.Random;
import java.util.Set;

public class YoungKapokFoliagePlacer extends FoliagePlacer {
    public YoungKapokFoliagePlacer(FeatureSpread radius, FeatureSpread offset) {super(radius, offset);}

    public static final Codec<YoungKapokFoliagePlacer> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    FeatureSpread.CODEC.fieldOf("radius")
                            .forGetter(fp -> fp.radius),
                    FeatureSpread.CODEC.fieldOf("offset")
                            .forGetter(fp -> fp.offset)
            ).apply(instance, YoungKapokFoliagePlacer::new)
    );

    @Override
    protected FoliagePlacerType<?> getPlacerType() {
        return ModFoliagePlacer.YOUNG_KAPOK_FOLIAGE_PLACER.get();
    }

    @Override
    protected void func_230372_a_(IWorldGenerationReader world,
                                  Random rand,
                                  BaseTreeFeatureConfig config,
                                  int trunkHeight,
                                  Foliage foliage,
                                  int foliageHeight,
                                  int radius,
                                  Set<BlockPos> leaves,
                                  int offset,
                                  MutableBoundingBox box) {

        BlockPos tip = foliage.func_236763_a_();
        boolean giant = foliage.func_236765_c_();

        int canopyRadius = radius + rand.nextInt(2);

        // 🌿 Small canopy around branch tip
        for (int y = 0; y >= -1; y--) {
            for (int x = -canopyRadius; x <= canopyRadius; x++) {
                for (int z = -canopyRadius; z <= canopyRadius; z++) {

                    if (Math.abs(x) + Math.abs(z) <= canopyRadius + 1) {

                        BlockPos pos = tip.add(x, y, z);

                        this.func_236753_a_(
                                world,
                                rand,
                                config,
                                pos,
                                0,          // radius 0 = single leaf
                                leaves,
                                y,
                                giant,
                                box
                        );
                    }
                }
            }
        }

        // 🌿 Hanging willow strands from canopy edge
        for (int x = -canopyRadius; x <= canopyRadius; x++) {
            for (int z = -canopyRadius; z <= canopyRadius; z++) {

                int dist = Math.abs(x) + Math.abs(z);

                if (dist >= canopyRadius - 1 && rand.nextFloat() < 0.45F) {

                    int length = 3 + rand.nextInt(4);

                    int dx = Integer.signum(x);
                    int dz = Integer.signum(z);

                    for (int y = -2; y > -2 - length; y--) {

                        BlockPos hanging = tip.add(x + dx, y, z + dz);

                        this.func_236753_a_(
                                world,
                                rand,
                                config,
                                hanging,
                                0,
                                leaves,
                                y,
                                giant,
                                box
                        );
                    }
                }
            }
        }
    }

    @Override
    public int func_230374_a_(Random rand, int trunkHeight, BaseTreeFeatureConfig config) {
        return 2;
    }

    @Override
    protected boolean func_230373_a_(Random rand,
                                     int x,
                                     int y,
                                     int z,
                                     int radius,
                                     boolean giantTrunk) {
        return false;
    }
}
