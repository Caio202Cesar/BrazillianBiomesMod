package com.brbiomesmod.features;

import com.brbiomesmod.block.BlockClasses.AmazonRainforestBlocks;
import com.brbiomesmod.block.BlockClasses.AraucariaPlateauBlocks;
import com.brbiomesmod.block.BlockClasses.CaatingaBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.ColumnBlockPlacer;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;

public class ModFeatures extends Features implements IFeatureConfig {

    public static final ConfiguredFeature<?, ?> PATCH_XAXIM_PLANT = register("patch_xaxim_plant",
            Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModFeatures.States.XAXIM),
                    new DoublePlantBlockPlacer())).tries(64).preventProjection().build()).withPlacement(Features.Placements.VEGETATION_PLACEMENT)
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(7));
    public static final ConfiguredFeature<?, ?> PATCH_CASSAVA_PLANT = register("patch_cassava_plant",
            Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(States.CASSAVA),
                            new DoublePlantBlockPlacer())).tries(64).preventProjection().build()).withPlacement(Features.Placements.VEGETATION_PLACEMENT)
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(7));
    public static final ConfiguredFeature<?, ?> BULL_NETTLES = register("bull_nettles",
            Feature.FLOWER.withConfiguration(ModFeatures.Configs.BULL_NETTLE_CONFIG).withPlacement(Features.Placements.VEGETATION_PLACEMENT)
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(4));
    public static final ConfiguredFeature<?, ?> CAATINGA_CACTUS_PATCH = register("caatinga_cactus_patch", Feature.RANDOM_PATCH
            .withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(States.CACTUS),
            new ColumnBlockPlacer(1, 2))).tries(10).preventProjection().build()));


    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }

    public static final class Configs {
        public static final BlockClusterFeatureConfig BULL_NETTLE_CONFIG =
                (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider())
                        .addWeightedBlockstate(States.BULL_NETTLE, 1)
                        .addWeightedBlockstate(States.BULL_NETTLE_FRUITS, 1),
                        SimpleBlockPlacer.PLACER)).tries(64).build();
    }

    public static final class States {
        protected static final BlockState XAXIM = AraucariaPlateauBlocks.XAXIM_PLANT.get().getDefaultState();
        protected static final BlockState CASSAVA = AmazonRainforestBlocks.CASSAVA_PLANT.get().getDefaultState();
        protected static final BlockState BULL_NETTLE = CaatingaBlocks.CNIDOSCOLUS_URENS.get().getDefaultState();
        protected static final BlockState BULL_NETTLE_FRUITS = CaatingaBlocks.CNIDOSCOLUS_URENS_FRUITING.get().getDefaultState();
        protected static final BlockState CACTUS = Blocks.CACTUS.getDefaultState();
    }
}
