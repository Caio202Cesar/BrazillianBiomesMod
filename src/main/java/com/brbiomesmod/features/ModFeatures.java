package com.brbiomesmod.features;

import com.brbiomesmod.block.BlockClasses.*;
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

import static net.minecraftforge.registries.ForgeRegistries.FEATURES;

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

    public static final ConfiguredFeature<?, ?> TURK_TURBAN_CACTUS = register("turk_turban_cactus",
            Feature.FLOWER.withConfiguration(ModFeatures.Configs.TURK_TURBAN_CACTUS_CONFIG).withPlacement(Features.Placements.VEGETATION_PLACEMENT)
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(4));

    public static final ConfiguredFeature<?, ?> IPOMAEA_PES_CAPRAE_PATCH = register("ipomaea_pes_caprae_patch",
            Feature.FLOWER.withConfiguration(ModFeatures.Configs.IPOMAEA_PES_CAPRAE_CONFIG).withPlacement(Features.Placements.VEGETATION_PLACEMENT)
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(7));

    public static final ConfiguredFeature<?, ?> CAATINGA_CACTUS_PATCH = register("caatinga_cactus_patch", Feature.RANDOM_PATCH
            .withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(States.CACTUS),
            new ColumnBlockPlacer(1, 2))).tries(10).preventProjection().build()));

    public static final ConfiguredFeature<?, ?> ATLANTIC_FOREST_ORCHIDS = register("atlantic_forest_orchids",
            Feature.FLOWER.withConfiguration(ModFeatures.Configs.ATLANTIC_ORCHIDS_CONFIG).withPlacement(Features.Placements.VEGETATION_PLACEMENT)
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(4));

    public static final ConfiguredFeature<?, ?> XANANA_PATCH = register("xanana_patch",
            Feature.FLOWER.withConfiguration(ModFeatures.Configs.XANANA_FLOWER_CONFIG).withPlacement(Features.Placements.VEGETATION_PLACEMENT)
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(7));

    public static final ConfiguredFeature<?, ?> PAMPAS_PLAINS_FLOWER_PATCH = register("pampas_plains_flower_patch",
            Feature.FLOWER.withConfiguration(ModFeatures.Configs.PAMPAS_FLOWER_CONFIG).withPlacement(Features.Placements.VEGETATION_PLACEMENT)
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(7));

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }

    public static final class Configs {
        public static final BlockClusterFeatureConfig BULL_NETTLE_CONFIG =
                (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider())
                        .addWeightedBlockstate(States.BULL_NETTLE, 1)
                        .addWeightedBlockstate(States.BULL_NETTLE_FRUITS, 1),
                        SimpleBlockPlacer.PLACER)).tries(64).build();

        public static final BlockClusterFeatureConfig TURK_TURBAN_CACTUS_CONFIG =
                (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider())
                        .addWeightedBlockstate(States.TURK_TURBAN, 1)
                        .addWeightedBlockstate(States.TURK_TURBAN_FRUITING, 1),
                        SimpleBlockPlacer.PLACER)).tries(64).build();

        public static final BlockClusterFeatureConfig ATLANTIC_ORCHIDS_CONFIG =
                (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider())
                        .addWeightedBlockstate(States.CATTLEYA_PURPURATA, 1),
                        SimpleBlockPlacer.PLACER)).tries(64).build();

        public static final BlockClusterFeatureConfig IPOMAEA_PES_CAPRAE_CONFIG =
                (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider())
                        .addWeightedBlockstate(States.IPOMAEA_PES_CAPRAE, 3),
                        SimpleBlockPlacer.PLACER)).tries(64).build();

        public static final BlockClusterFeatureConfig XANANA_FLOWER_CONFIG =
                (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider())
                        .addWeightedBlockstate(States.XANANA1, 5)
                        .addWeightedBlockstate(States.XANANA2, 2),
                        SimpleBlockPlacer.PLACER)).tries(64).build();

        public static final BlockClusterFeatureConfig PAMPAS_FLOWER_CONFIG =
                (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider())
                        .addWeightedBlockstate(States.MACELA, 1),
                        SimpleBlockPlacer.PLACER)).tries(64).build();
    }

    public static final class States {
        protected static final BlockState XAXIM = AraucariaPlateauBlocks.XAXIM_PLANT.get().getDefaultState();
        protected static final BlockState CASSAVA = AmazonRainforestBlocks.CASSAVA_PLANT.get().getDefaultState();
        protected static final BlockState BULL_NETTLE = CaatingaBlocks.CNIDOSCOLUS_URENS.get().getDefaultState();
        protected static final BlockState BULL_NETTLE_FRUITS = CaatingaBlocks.CNIDOSCOLUS_URENS_FRUITING.get().getDefaultState();
        protected static final BlockState TURK_TURBAN = CaatingaBlocks.TURK_TURBAN_CACTUS.get().getDefaultState();
        protected static final BlockState TURK_TURBAN_FRUITING = CaatingaBlocks.TURK_TURBAN_FRUITING_CACTUS.get().getDefaultState();
        protected static final BlockState CACTUS = Blocks.CACTUS.getDefaultState();
        protected static final BlockState CATTLEYA_PURPURATA = AtlanticForestBlocks.CATTLEYA_PURPURATA.get().getDefaultState();
        protected static final BlockState IPOMAEA_PES_CAPRAE = RestingaBlocks.IPOMAEA_PES_CAPRAE.get().getDefaultState();
        protected static final BlockState XANANA1 = RestingaBlocks.XANANA.get().getDefaultState();
        protected static final BlockState XANANA2 = RestingaBlocks.XANANA_BIG.get().getDefaultState();
        protected static final BlockState MACELA = PampasPlainsBlocks.MACELA.get().getDefaultState();
        protected static final BlockState TOURMALINE_ORE = CaatingaBlocks.TOURMALINE_PARAIBA_ORE.get().getDefaultState();
        protected static final BlockState STONE = Blocks.STONE.getDefaultState();

    }
}
