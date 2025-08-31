package com.brbiomesmod.features;

import com.brbiomesmod.block.PlantsGroup;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;

import java.util.function.Supplier;

public class ModFeatures extends Features implements IFeatureConfig {

    public static final ConfiguredFeature<?, ?> PATCH_XAXIM_PLANT = register("patch_xaxim_plant",
            Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModFeatures.States.XAXIM),
                    new DoublePlantBlockPlacer())).tries(64).preventProjection().build()).withPlacement(Features.Placements.VEGETATION_PLACEMENT)
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(7));

    public static final ConfiguredFeature<?, ?> PATCH_VELOZIA_PLANT = register("patch_velozia_plant",
            Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(States.VELOZIA),
                            new DoublePlantBlockPlacer())).tries(64).preventProjection().build()).withPlacement(Features.Placements.VEGETATION_PLACEMENT)
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(7));

    public static final ConfiguredFeature<?, ?> PATCH_CASSAVA_PLANT = register("patch_cassava_plant",
            Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(States.CASSAVA),
                            new DoublePlantBlockPlacer())).tries(64).preventProjection().build()).withPlacement(Features.Placements.VEGETATION_PLACEMENT)
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(7));

    public static final ConfiguredFeature<?, ?> PATCH_PAMPAS_GRASS = register("patch_pampas_grass",
            Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(States.PAMPAS_GRASS),
                            new DoublePlantBlockPlacer())).tries(64).preventProjection().build()).withPlacement(Features.Placements.VEGETATION_PLACEMENT)
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(7));

    public static final ConfiguredFeature<?, ?> BULL_NETTLES = register("bull_nettles",
            Feature.FLOWER.withConfiguration(ModFeatures.Configs.BULL_NETTLE_CONFIG).withPlacement(Features.Placements.VEGETATION_PLACEMENT)
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(4));

    public static final ConfiguredFeature<?, ?> AMAZONIAN_PLANTS = register("amazonian_plants",
            Feature.FLOWER.withConfiguration(Configs.AMAZONIAN_PLANTS_CONFIG).withPlacement(Features.Placements.VEGETATION_PLACEMENT)
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(4));

    public static final ConfiguredFeature<?, ?> TURK_TURBAN_CACTUS = register("turk_turban_cactus",
            Feature.FLOWER.withConfiguration(ModFeatures.Configs.TURK_TURBAN_CACTUS_CONFIG).withPlacement(Features.Placements.VEGETATION_PLACEMENT)
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(4));

    public static final ConfiguredFeature<?, ?> IPOMAEA_PES_CAPRAE_PATCH = register("ipomaea_pes_caprae_patch",
            Feature.FLOWER.withConfiguration(ModFeatures.Configs.IPOMAEA_PES_CAPRAE_CONFIG).withPlacement(Features.Placements.VEGETATION_PLACEMENT)
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(7));

    public static final ConfiguredFeature<?, ?> ATLANTIC_FOREST_FLOWERS = register("atlantic_forest_flowers",
            Feature.FLOWER.withConfiguration(ModFeatures.Configs.ATLANTIC_FOREST_FLOWERS_CONFIG).withPlacement(Features.Placements.VEGETATION_PLACEMENT)
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(20));

    public static final ConfiguredFeature<?, ?> ARAUCARIA_FOREST_FLOWERS = register("araucaria_forest_orchids",
            Feature.FLOWER.withConfiguration(ModFeatures.Configs.ARAUCARIA_FLOWERS_CONFIG).withPlacement(Features.Placements.VEGETATION_PLACEMENT)
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(4));

    public static final ConfiguredFeature<?, ?> XANANA_PATCH = register("xanana_patch",
            Feature.FLOWER.withConfiguration(ModFeatures.Configs.XANANA_FLOWER_CONFIG).withPlacement(Features.Placements.VEGETATION_PLACEMENT)
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(12));

    public static final ConfiguredFeature<?, ?> PAMPAS_PLAINS_FLOWER_PATCH = register("pampas_plains_flower_patch",
            Feature.FLOWER.withConfiguration(ModFeatures.Configs.PAMPAS_FLOWER_CONFIG).withPlacement(Features.Placements.VEGETATION_PLACEMENT)
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(7));

    public static final ConfiguredFeature<?, ?> ANGEL_TRUMPET_BUSHES = register("angel_trumpet_bushes",
            Feature.SIMPLE_RANDOM_SELECTOR.withConfiguration(new SingleRandomFeature(Configs.ANGEL_TRUMPET_LIST))
                    .countSpread(FeatureSpread.create(-3, 4))
                    .withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(5));


    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }

    public static final class Configs {
        public static final BlockClusterFeatureConfig BULL_NETTLE_CONFIG =
                (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider())
                        .addWeightedBlockstate(States.BULL_NETTLE, 1)
                        .addWeightedBlockstate(States.BULL_NETTLE_FRUITS, 1),
                        SimpleBlockPlacer.PLACER)).tries(64).build();

        public static final BlockClusterFeatureConfig AMAZONIAN_PLANTS_CONFIG =
                (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider())
                        .addWeightedBlockstate(States.ZEBRA_PLANT, 1),
                        SimpleBlockPlacer.PLACER)).tries(64).build();

        public static final BlockClusterFeatureConfig TURK_TURBAN_CACTUS_CONFIG =
                (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider())
                        .addWeightedBlockstate(States.TURK_TURBAN, 1)
                        .addWeightedBlockstate(States.TURK_TURBAN_FRUITING, 1),
                        SimpleBlockPlacer.PLACER)).tries(64).build();

        public static final BlockClusterFeatureConfig ATLANTIC_FOREST_FLOWERS_CONFIG =
                (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider())
                        .addWeightedBlockstate(States.CATTLEYA_PURPURATA, 1)
                        .addWeightedBlockstate(States.CATTLEYA_LADY_ACKLAND, 1)
                        .addWeightedBlockstate(States.SILVER_VASE_BROMELIAD, 1)
                        .addWeightedBlockstate(States.GUZMANIA_RED, 1)
                        .addWeightedBlockstate(States.GUZMANIA_ORANGE, 1)
                        .addWeightedBlockstate(States.GUZMANIA_PINK, 1)
                        .addWeightedBlockstate(States.GUZMANIA_YELLOW, 1)
                        .addWeightedBlockstate(States.AECHMEA_ALBA, 1)
                        .addWeightedBlockstate(States.FIREBALL_NEOREGELIA, 1)
                        .addWeightedBlockstate(States.NEOREGELIA_MARMORATA, 1)
                        .addWeightedBlockstate(States.BLACK_ORCHID, 1),
                        SimpleBlockPlacer.PLACER)).tries(64).build();

        public static final BlockClusterFeatureConfig ARAUCARIA_FLOWERS_CONFIG =
                (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider())
                        .addWeightedBlockstate(States.CATTLEYA_COCCINEA, 1)
                        .addWeightedBlockstate(States.SMALL_XAXIM, 2),
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
                        .addWeightedBlockstate(States.MACELA, 2)
                        .addWeightedBlockstate(States.VELAME_OF_RIO_GRANDE, 1)
                        .addWeightedBlockstate(States.MANDEVILLA_COCCINEA, 1)
                        .addWeightedBlockstate(States.ASPILIA_MONTEVIDENSIS, 2),
                        SimpleBlockPlacer.PLACER)).tries(64).build();

        private static final ImmutableList<Supplier<ConfiguredFeature<?, ?>>> ANGEL_TRUMPET_LIST = ImmutableList.of(() -> {
            return Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(States.ANGEL_TRUMPET_WHITE),
                    new DoublePlantBlockPlacer())).tries(64).preventProjection().build());
        }, () -> {return Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(States.ANGEL_TRUMPET_PINK),
                new DoublePlantBlockPlacer())).tries(64).preventProjection().build());
        }, () -> {return Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(States.ANGEL_TRUMPET_YELLOW),
                new DoublePlantBlockPlacer())).tries(64).preventProjection().build());
        }, () -> {return Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(States.ANGEL_TRUMPET_SALMON),
                new DoublePlantBlockPlacer())).tries(64).preventProjection().build());
        }, () -> {return Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(States.ANGEL_TRUMPET_ORANGE),
                new DoublePlantBlockPlacer())).tries(64).preventProjection().build());
        });
    }

    public static final class States {
        protected static final BlockState XAXIM = PlantsGroup.XAXIM_PLANT.get().getDefaultState();
        protected static final BlockState SMALL_XAXIM = PlantsGroup.SMALL_XAXIM_PLANT.get().getDefaultState();
        protected static final BlockState CATTLEYA_COCCINEA = PlantsGroup.CATTLEYA_COCCINEA.get().getDefaultState();
        protected static final BlockState CASSAVA = PlantsGroup.CASSAVA_PLANT.get().getDefaultState();
        protected static final BlockState BULL_NETTLE = PlantsGroup.CNIDOSCOLUS_URENS.get().getDefaultState();
        protected static final BlockState BULL_NETTLE_FRUITS = PlantsGroup.CNIDOSCOLUS_URENS_FRUITING.get().getDefaultState();
        protected static final BlockState TURK_TURBAN = PlantsGroup.TURK_TURBAN_CACTUS.get().getDefaultState();
        protected static final BlockState TURK_TURBAN_FRUITING = PlantsGroup.TURK_TURBAN_FRUITING_CACTUS.get().getDefaultState();
        protected static final BlockState CATTLEYA_PURPURATA = PlantsGroup.CATTLEYA_PURPURATA.get().getDefaultState();
        protected static final BlockState CATTLEYA_LADY_ACKLAND = PlantsGroup.CATTLEYA_LADY_ACKLAND.get().getDefaultState();
        protected static final BlockState IPOMAEA_PES_CAPRAE = PlantsGroup.IPOMAEA_PES_CAPRAE.get().getDefaultState();
        protected static final BlockState XANANA1 = PlantsGroup.XANANA.get().getDefaultState();
        protected static final BlockState XANANA2 = PlantsGroup.XANANA_BIG.get().getDefaultState();
        protected static final BlockState MACELA = PlantsGroup.MACELA.get().getDefaultState();
        protected static final BlockState VELAME_OF_RIO_GRANDE = PlantsGroup.VELAME_OF_RIO_GRANDE.get().getDefaultState();
        protected static final BlockState MANDEVILLA_COCCINEA = PlantsGroup.MANDEVILLA_COCCINEA.get().getDefaultState();
        protected static final BlockState ASPILIA_MONTEVIDENSIS = PlantsGroup.ASPILIA_MONTEVIDENSIS.get().getDefaultState();
        protected static final BlockState ANGEL_TRUMPET_WHITE = PlantsGroup.WHITE_ANGEL_TRUMPET.get().getDefaultState();
        protected static final BlockState ANGEL_TRUMPET_ORANGE = PlantsGroup.ORANGE_ANGEL_TRUMPET.get().getDefaultState();
        protected static final BlockState ANGEL_TRUMPET_PINK = PlantsGroup.PINK_ANGEL_TRUMPET.get().getDefaultState();
        protected static final BlockState ANGEL_TRUMPET_SALMON = PlantsGroup.SALMON_ANGEL_TRUMPET.get().getDefaultState();
        protected static final BlockState ANGEL_TRUMPET_YELLOW = PlantsGroup.YELLOW_ANGEL_TRUMPET.get().getDefaultState();
        protected static final BlockState GUZMANIA_RED = PlantsGroup.RED_GUZMANIA.get().getDefaultState();
        protected static final BlockState GUZMANIA_YELLOW = PlantsGroup.YELLOW_GUZMANIA.get().getDefaultState();
        protected static final BlockState GUZMANIA_PINK = PlantsGroup.PINK_GUZMANIA.get().getDefaultState();
        protected static final BlockState GUZMANIA_ORANGE = PlantsGroup.ORANGE_GUZMANIA.get().getDefaultState();
        protected static final BlockState FIREBALL_NEOREGELIA = PlantsGroup.FIREBALL_NEOREGELIA.get().getDefaultState();
        protected static final BlockState NEOREGELIA_MARMORATA = PlantsGroup.NEOREGELIA_MARMORATA.get().getDefaultState();
        protected static final BlockState AECHMEA_ALBA = PlantsGroup.AECHMEA_ALBA.get().getDefaultState();
        protected static final BlockState SILVER_VASE_BROMELIAD = PlantsGroup.SILVER_VASE_BROMELIAD.get().getDefaultState();
        protected static final BlockState VELOZIA = PlantsGroup.VELOZIA.get().getDefaultState();
        protected static final BlockState ZEBRA_PLANT = PlantsGroup.AMAZONIAN_ZEBRA_PLANT.get().getDefaultState();
        protected static final BlockState BLACK_ORCHID = PlantsGroup.BLACK_ORCHID.get().getDefaultState();
        protected static final BlockState PAMPAS_GRASS = PlantsGroup.PAMPAS_GRASS.get().getDefaultState();

    }
}
