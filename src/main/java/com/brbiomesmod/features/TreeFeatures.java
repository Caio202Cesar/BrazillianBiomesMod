package com.brbiomesmod.features;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.block.BlockClasses.*;
import com.brbiomesmod.features.FoliagePlacers.*;
import com.brbiomesmod.features.TreeDecorators.PassionFruitVineLeavesDecorator;
import com.brbiomesmod.features.TreeDecorators.PassionFruitVineTrunkDecorator;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.*;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.treedecorator.*;
import net.minecraft.world.gen.trunkplacer.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.OptionalInt;

public abstract class TreeFeatures implements IFeatureConfig {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, BrazillianBiomesMod.MOD_ID);

    //Cashew Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CASHEW_SHRUB = register("cashew_shrub",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.CASHEW_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.CASHEW_LEAVES),
                    new BushFoliagePlacer(FeatureSpread.create(1), FeatureSpread.create(0), 3),
                    new MegaJungleTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));

    //Acai Palm
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ACAI_PALM = register("acai_palm",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.PALMITO_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.ACAI_LEAVES),
                    new AcaiFoliagePlacer(FeatureSpread.create(1), FeatureSpread.create(0)),
                    new StraightTrunkPlacer(10, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> JUSSARA_PALM = register("jussara_palm",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.PALMITO_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.JUSSARA_LEAVES),
                    new JussaraFoliagePlacer(FeatureSpread.create(1), FeatureSpread.create(0)),
                    new StraightTrunkPlacer(16, 18, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));

    //Queen Palm
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> QUEEN_PALM = register("queen_palm",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.QUEEN_PALM_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.QUEEN_PALM_LEAVES),
                    new QueenPalmFoliagePlacer(FeatureSpread.create(1), FeatureSpread.create(0)),
                    new StraightTrunkPlacer(10, 4, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));

    //Banana Palm
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BANANA_TREE = register("banana_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.BANANA_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.BANANA_LEAVES),
                    new BananaFoliagePlacer(FeatureSpread.create(1), FeatureSpread.create(0)),
                    new StraightTrunkPlacer(7, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));

    //Jelly Palm
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> JELLY_PALM = register("jelly_palm",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.JELLY_PALM_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.JELLY_PALM_LEAVES),
                    new JellyPalmFoliagePlacer(FeatureSpread.create(1), FeatureSpread.create(0)),
                    new StraightTrunkPlacer(10, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));

    //Carnauba Palm
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CARNAUBA_PALM = register("carnauba_palm",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.CARNAUBA_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.CARNAUBA_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(15, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));

    //Kapok Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> KAPOK_TREE = register("kapok_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.KAPOK_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.KAPOK_LEAVES),
                    new JungleFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new MegaJungleTrunkPlacer(10, 20, 4),
                    new TwoLayerFeature(1, 0, 1))).setDecorators(ImmutableList.of(
                    TrunkVineTreeDecorator.INSTANCE, LeaveVineTreeDecorator.field_236871_b_)).setIgnoreVines().build()));

    //Black Jurema Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BLACK_JUREMA_TREE = register("black_jurema_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.BLACK_JUREMA_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.BLACK_JUREMA_LEAVES),
                    new AcaciaFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0)),
                    new ForkyTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));

    //Ipe Trees
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> YELLOW_IPE_TREE = register("yellow_ipe_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.IPE_LOG),
                    new SimpleBlockStateProvider(States.YELLOW_IPE_BLOSSOM),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING)
                    .setDecorators(ImmutableList.of(Features.Placements.BEES_002_PLACEMENT)).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PURPLE_IPE_TREE = register("purple_ipe_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.IPE_LOG),
                    new SimpleBlockStateProvider(States.PURPLE_IPE_BLOSSOM),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING)
                    .setDecorators(ImmutableList.of(Features.Placements.BEES_002_PLACEMENT)).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PINK_IPE_TREE = register("pink_ipe_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.IPE_LOG),
                    new SimpleBlockStateProvider(States.PINK_IPE_BLOSSOM),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> WHITE_IPE_TREE = register("white_ipe_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.IPE_LOG),
                    new SimpleBlockStateProvider(States.WHITE_IPE_BLOSSOM),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> APRICOT_IPE_TREE = register("apricot_ipe_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.IPE_LOG),
                    new SimpleBlockStateProvider(States.APRICOT_IPE_BLOSSOM),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));

    //Yerba maté Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> YERBA_MATE_TREE = register("yerba_mate_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.YERBA_MATE_LOG),
                    new SimpleBlockStateProvider(States.YERBA_MATE_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> YERBA_MATE_FANCY_TREE = register("yerba_mate_fancy_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.YERBA_MATE_LOG),
                    new SimpleBlockStateProvider(States.YERBA_MATE_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));

    //Feijoa Shrub
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FEIJOA_SHRUB = register("feijoa_shrub",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.FEIJOA_LOG),
                    new SimpleBlockStateProvider(States.FEIJOA_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 2),
                    new StraightTrunkPlacer(2, 1, 0),
                    new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));

    //Cambuci Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CAMBUCI_TREE = register("cambuci_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.CAMBUCI_LOG),
                    new SimpleBlockStateProvider(States.CAMBUCI_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CAMBUCI_TREE_WITH_PASSIONVINE = register("cambuci_tree_with_passionvine",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.CAMBUCI_LOG),
                    new SimpleBlockStateProvider(States.CAMBUCI_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0,
                            OptionalInt.of(4)))).setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING)
                    .setDecorators(ImmutableList.of(PassionFruitVineLeavesDecorator.INSTANCE, PassionFruitVineTrunkDecorator.INSTANCE)).build()));

    //Peruvian Pepper Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PERUVIAN_PEPPER_TREE = register("peruvian_pepper_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.SCHINUS_LOG),
                    new SimpleBlockStateProvider(States.PERUVIAN_PEPPER_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PERUVIAN_PEPPER_FANCY_TREE = register("peruvian_pepper_fancy_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.SCHINUS_LOG),
                    new SimpleBlockStateProvider(States.PERUVIAN_PEPPER_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(3), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));

    //Brazillian Pepper Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BRAZILLIAN_PEPPER_TREE = register("brazillian_pepper_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.SCHINUS_LOG),
                    new SimpleBlockStateProvider(States.BRAZILLIAN_PEPPER_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BRAZILLIAN_PEPPER_STOUT_TREE = register("brazillian_pepper_stout_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.SCHINUS_LOG),
                    new SimpleBlockStateProvider(States.BRAZILLIAN_PEPPER_LEAVES),
                    new DarkOakFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0)),
                    new DarkOakTrunkPlacer(3, 1, 1),
                    new ThreeLayerFeature(1, 1, 0, 1, 2, OptionalInt.empty())))
                    .setMaxWaterDepth(Integer.MAX_VALUE).setHeightmap(Heightmap.Type.MOTION_BLOCKING).setIgnoreVines().build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BRAZILLIAN_PEPPER_BIG_TREE = register("brazillian_pepper_big_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.SCHINUS_LOG),
                    new SimpleBlockStateProvider(States.BRAZILLIAN_PEPPER_LEAVES),
                    new DarkOakFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0)),
                    new DarkOakTrunkPlacer(6, 2, 1),
                    new ThreeLayerFeature(1, 1, 0, 1, 2, OptionalInt.empty())))
                    .setMaxWaterDepth(Integer.MAX_VALUE).setHeightmap(Heightmap.Type.MOTION_BLOCKING).setIgnoreVines().build()));

    //Mangaba Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MANGABA_TREE = register("mangaba_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.MANGABA_LOG),
                    new SimpleBlockStateProvider(States.MANGABA_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new ForkyTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));

    //Wolf Apple Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> WOLF_APPLE_TREE = register("wolf_apple_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.WOLF_APPLE_LOG),
                    new SimpleBlockStateProvider(States.WOLF_APPLE_LEAVES),
                    new AcaciaFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0)),
                    new ForkyTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));

    //Brazilnut Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BRAZILNUT_TREE = register("brazilnut_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.BRAZILNUT_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.BRAZILNUT_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(10, 20, 4),
                    new TwoLayerFeature(1, 0, 1))).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BRAZILNUT_FANCY_TREE = register("brazilnut_fancy_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.BRAZILNUT_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.BRAZILNUT_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(10, 20, 4),
                    new TwoLayerFeature(1, 0, 1))).build()));

    //Cupuacu Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CUPUACU_TREE = register("cupuacu_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.JUNGLE_LOG),
                    new SimpleBlockStateProvider(States.CUPUACU_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));

    //Guarana Shrub
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> GUARANA_SHRUB = register("guarana_shrub",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.JUNGLE_LOG),
                    new SimpleBlockStateProvider(States.GUARANA_LEAVES),
                    new BushFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(1), 2),
                    new StraightTrunkPlacer(1, 0, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));

    //Brazilwood Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BRAZILWOOD_TREE = register("brazilwood_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.BRAZILWOOD_LOG),
                    new SimpleBlockStateProvider(States.BRAZILWOOD_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BRAZILWOOD_FANCY_TREE = register("brazilwood_fancy_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.BRAZILWOOD_LOG),
                    new SimpleBlockStateProvider(States.BRAZILWOOD_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BRAZILWOOD_TREE_WITH_PASSIONVINE = register("brazilwood_tree_with_passionvine",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.BRAZILWOOD_LOG),
                    new SimpleBlockStateProvider(States.BRAZILWOOD_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING)
                    .setDecorators(ImmutableList.of(PassionFruitVineLeavesDecorator.INSTANCE, PassionFruitVineTrunkDecorator.INSTANCE)).setIgnoreVines().build()));

    //Jua Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> JUA_TREE = register("jua_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.JUA_LOG),
                    new SimpleBlockStateProvider(States.JUA_LEAVES),
                    new DarkOakFoliagePlacer(FeatureSpread.create(1), FeatureSpread.create(0)),
                    new DarkOakTrunkPlacer(3, 4, 1),
                    new TwoLayerFeature(1, 0, 1))).setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));

    //Brazillian Sassafras Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BRAZILLIAN_SASSAFRAS_TREE = register("brazillian_sassafras_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.BRAZILLIAN_SASSAFRAS_LOG),
                    new SimpleBlockStateProvider(States.BRAZILLIAN_SASSAFRAS_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 6, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?>  BRAZILLIAN_SASSAFRAS_FANCY_TREE = register("brazillian_sassafras_fancy_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.BRAZILLIAN_SASSAFRAS_LOG),
                    new SimpleBlockStateProvider(States.BRAZILLIAN_SASSAFRAS_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?>  BRAZILLIAN_SASSAFRAS_TREE_WITH_PASSIONVINE =
            register("brazillian_sassafras_fancy_tree_with_passionvine",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.BRAZILLIAN_SASSAFRAS_LOG),
                    new SimpleBlockStateProvider(States.BRAZILLIAN_SASSAFRAS_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING)
                    .setDecorators(ImmutableList.of(PassionFruitVineLeavesDecorator.INSTANCE, PassionFruitVineTrunkDecorator.INSTANCE)).build()));

    //Umbu Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> UMBU_TREE = register("umbu_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.UMBU_LOG),
                    new SimpleBlockStateProvider(States.UMBU_LEAVES),
                    new BushFoliagePlacer(FeatureSpread.create(1), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));

    //Lophantera Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> LOPHANTERA_TREE = register("lophantera_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.LOPHANTERA_LOG),
                    new SimpleBlockStateProvider(States.LOPHANTERA_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 2, 1))).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> LOPHANTERA_TREE2 = register("lophantera_tree2",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.LOPHANTERA_LOG),
                    new SimpleBlockStateProvider(States.LOPHANTERA_LEAVES),
                    new SpruceFoliagePlacer(FeatureSpread.create(4), FeatureSpread.create(3), FeatureSpread.create(6)),
                    new StraightTrunkPlacer(3, 5, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));

    //Manaca da Serra Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MANACA_TREE = register("manaca_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.MANACA_DA_SERRA_LOG),
                    new SimpleBlockStateProvider(States.MANACA_DA_SERRA_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MANACA_FANCY_TREE = register("manaca_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.MANACA_DA_SERRA_LOG),
                    new SimpleBlockStateProvider(States.MANACA_DA_SERRA_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MANACA_WITH_PASSIONVINE = register("manaca_tree_with_passionvine",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.MANACA_DA_SERRA_LOG),
                    new SimpleBlockStateProvider(States.MANACA_DA_SERRA_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING)
                    .setDecorators(ImmutableList.of(PassionFruitVineLeavesDecorator.INSTANCE, PassionFruitVineTrunkDecorator.INSTANCE)).build()));

    //Pitanga Trees
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PITANGA_TREE = register("pitanga_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.EUGENIA_LOG),
                    new SimpleBlockStateProvider(States.PITANGA_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BLACK_PITANGA_TREE = register("black_pitanga_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.EUGENIA_LOG),
                    new SimpleBlockStateProvider(States.BLACK_PITANGA_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));

    //Sharinga Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> SHARINGA_TREE = register("sharinga_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.SHARINGA_LOG),
                    new SimpleBlockStateProvider(States.SHARINGA_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));

    //Araucaria Trees
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PARANA_PINE_TREE = register("parana_pine_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.PARANA_PINE_LOG),
                    new SimpleBlockStateProvider(States.PARANA_PINE_LEAVES),
                    new ParanaPineFoliagePlacer(FeatureSpread.create(1), FeatureSpread.create(0)),
                    new GiantTrunkPlacer(13, 2, 14),
                    new TwoLayerFeature(1, 1, 2)))
                    .setDecorators(ImmutableList.of(new AlterGroundTreeDecorator(new SimpleBlockStateProvider(States.PODZOL)))).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PARANA_PINE_TREE_YOUNG = register("young_parana_pine_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.PARANA_PINE_LOG),
                    new SimpleBlockStateProvider(States.PARANA_PINE_LEAVES),
                    new MegaPineFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), FeatureSpread.create(13, 4)),
                    new StraightTrunkPlacer(6, 2, 14),
                    new TwoLayerFeature(1, 1, 2)))
                    .setDecorators(ImmutableList.of(new AlterGroundTreeDecorator(new SimpleBlockStateProvider(States.PODZOL)))).build()));

    //Imbuia Trees
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> IMBUIA_TREE = register("imbuia_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.IMBUIA_LOG),
                    new SimpleBlockStateProvider(States.IMBUIA_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> IMBUIA_FANCY_TREE = register("imbuia_fancy_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.IMBUIA_LOG),
                    new SimpleBlockStateProvider(States.IMBUIA_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));

    //Cecropia Trees
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> SILVER_CECROPIA_TREE = register("silver_cecropia_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.CECROPIA_LOG),
                    new SimpleBlockStateProvider(States.SILVER_CECROPIA_LEAVES),
                    new JungleFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(15, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CECROPIA_TREE = register("cecropia_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.CECROPIA_LOG),
                    new SimpleBlockStateProvider(States.CECROPIA_LEAVES),
                    new JungleFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(7, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> LARGE_CECROPIA_TREE = register("large_cecropia_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.CECROPIA_LOG),
                    new SimpleBlockStateProvider(States.CECROPIA_LEAVES),
                    new JungleFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(15, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CECROPIA_WITH_PASSIONVINE = register("passionvine_cecropia_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.CECROPIA_LOG),
                    new SimpleBlockStateProvider(States.CECROPIA_LEAVES),
                    new JungleFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(7, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .setDecorators(ImmutableList.of(PassionFruitVineLeavesDecorator.INSTANCE, PassionFruitVineTrunkDecorator.INSTANCE)).setIgnoreVines().build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> SILVER_CECROPIA_WITH_PASSIONVINE = register("passionvine_silver_cecropia_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.CECROPIA_LOG),
                    new SimpleBlockStateProvider(States.SILVER_CECROPIA_LEAVES),
                    new JungleFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(15, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .setDecorators(ImmutableList.of(PassionFruitVineLeavesDecorator.INSTANCE, PassionFruitVineTrunkDecorator.INSTANCE)).setIgnoreVines().build()));

    //Pink Peroba Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PINK_PEROBA_TREE = register("pink_peroba_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.PINK_PEROBA_LOG),
                    new SimpleBlockStateProvider(States.PINK_PEROBA_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(4, 17, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PINK_PEROBA_TREE_WITH_PASSIONFRUIT = register("pink_peroba_with_passionfruit",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.PINK_PEROBA_LOG),
                    new SimpleBlockStateProvider(States.PINK_PEROBA_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(4, 17, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING)
                    .setDecorators(ImmutableList.of(PassionFruitVineLeavesDecorator.INSTANCE, PassionFruitVineTrunkDecorator.INSTANCE)).build()));

    //Jequitiba Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> JEQUITIBA_TREE = register("jequitiba_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.JEQUITIBA_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.JEQUITIBA_LEAVES),
                    new JungleFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new MegaJungleTrunkPlacer(13, 20, 4),
                    new TwoLayerFeature(1, 0, 1))).build()));

    //Brazillian Rosewood Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BRAZILLIAN_ROSEWOOD_TREE = register("brazillian_rosewood_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.BRAZILLIAN_ROSEWOOD_LOG),
                    new SimpleBlockStateProvider(States.BRAZILLIAN_ROSEWOOD_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BRAZILLIAN_ROSEWOOD_WITH_PASSIONVINE = register("brazillian_rosewood_with_passionvine",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.BRAZILLIAN_ROSEWOOD_LOG),
                    new SimpleBlockStateProvider(States.BRAZILLIAN_ROSEWOOD_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING).setDecorators(ImmutableList.of(PassionFruitVineLeavesDecorator.INSTANCE, PassionFruitVineTrunkDecorator.INSTANCE)).build()));

    //Jabuticaba Trees
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> JABUTICABA_TREE = register("jabuticaba_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.JABUTICABA_LOG),
                    new SimpleBlockStateProvider(States.JABUTICABA_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new DarkOakTrunkPlacer(6, 2, 1),
                    new ThreeLayerFeature(1, 1, 0, 1, 2, OptionalInt.empty())))
                    .setMaxWaterDepth(Integer.MAX_VALUE).setHeightmap(Heightmap.Type.MOTION_BLOCKING).setIgnoreVines().build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> JABUTICABA_TREE_WITH_PASSIONVINE = register("passionvine_jabuticaba_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.JABUTICABA_LOG),
                    new SimpleBlockStateProvider(States.JABUTICABA_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new DarkOakTrunkPlacer(6, 2, 1),
                    new ThreeLayerFeature(1, 1, 0, 1, 2, OptionalInt.empty())))
                    .setMaxWaterDepth(Integer.MAX_VALUE).setHeightmap(Heightmap.Type.MOTION_BLOCKING)
                    .setDecorators(ImmutableList.of(PassionFruitVineLeavesDecorator.INSTANCE)).setIgnoreVines().build()));

    //Algarrobillo Tree (Pampas)
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ALGARROBILLO_TREE = register("algarrobillo_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.ALGARROBILLO_LOG),
                    new SimpleBlockStateProvider(States.ALGARROBILLO_LEAVES),
                    new AcaciaFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0)),
                    new ForkyTrunkPlacer(5, 2, 2),
                    new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));

    //Caven Thorn Tree (Pampas)
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CAVEN_THORN_TREE = register("caven_thorn_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.CAVEN_THORN_LOG),
                    new SimpleBlockStateProvider(States.CAVEN_THORN_LEAVES),
                    new AcaciaFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0)),
                    new ForkyTrunkPlacer(5, 2, 2),
                    new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));

    //Cagaita Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CAGAITA_TREE = register("cagaita_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.EUGENIA_LOG),
                    new SimpleBlockStateProvider(States.CAGAITA_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0,
                            OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));

    //Black Sucupira Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BLACK_SUCUPIRA_TREE = register("black_sucupira_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.BLACK_SUCUPIRA_LOG),
                    new SimpleBlockStateProvider(States.BLACK_SUCUPIRA_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0,
                            OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));

    //Bacuri Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MEGA_BACURI_TREE = register("mega_bacuri_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.BACURI_LOG),
                    new SimpleBlockStateProvider(States.BACURI_LEAVES),
                    new JungleFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 2),
                    new MegaJungleTrunkPlacer(10, 2, 19),
                    new TwoLayerFeature(1, 1, 2))).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BACURI_TREE = register("bacuri_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.BACURI_LOG),
                    new SimpleBlockStateProvider(States.BACURI_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 8, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));

    //Camu-camu Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CAMU_CAMU_TREE = register("camu_camu_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.CAMU_CAMU_LOG),
                    new SimpleBlockStateProvider(States.CAMU_CAMU_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));

    //Silver Pepper Shrub (Schinus lentiscifolius) - a shrub in Pampas Biome
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> SILVER_PEPPER_BUSH = register("silver_pepper_bush",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.SCHINUS_LOG),
                    new SimpleBlockStateProvider(States.SILVER_PEPPER_LEAVES),
                    new BushFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(1), 2),
                    new StraightTrunkPlacer(1, 0, 0),
                    new TwoLayerFeature(0, 0, 0))).setHeightmap(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES).build()));

    //Uruguayan Pepper Shrub (Schinus weinmanniifolia) - a shrub in Pampas Biome
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> URUGUAYAN_PEPPER_BUSH = register("uruguayan_pepper_bush",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.SCHINUS_LOG),
                    new SimpleBlockStateProvider(States.URUGUAYAN_PEPPER_LEAVES),
                    new BushFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(1), 2),
                    new StraightTrunkPlacer(1, 0, 0),
                    new TwoLayerFeature(0, 0, 0))).setHeightmap(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES).build()));

    //Sapucaia Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> SAPUCAIA_TREE = register("sapucaia_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.SAPUCAIA_LOG),
                    new SimpleBlockStateProvider(States.SAPUCAIA_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0,
                            OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> SAPUCAIA_TREE_WITH_PASSIONVINE = register("sapucaia_tree_with_passionvine",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.SAPUCAIA_LOG),
                    new SimpleBlockStateProvider(States.SAPUCAIA_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0,
                            OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING)
                    .setDecorators(ImmutableList.of(PassionFruitVineLeavesDecorator.INSTANCE, PassionFruitVineTrunkDecorator.INSTANCE)).build()));


    //Silk Floss Trees
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> WHITE_SILK_FLOSS_TREE = register("white_silk_floss_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.SILK_FLOSS_LOG),
                    new SimpleBlockStateProvider(States.WHITE_SILK_FLOSS_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0,
                            OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> WHITE_SILK_FLOSS_BIG_TREE = register("white_silk_floss_big_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.SILK_FLOSS_LOG),
                    new SimpleBlockStateProvider(States.WHITE_SILK_FLOSS_LEAVES),
                    new JungleFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new MegaJungleTrunkPlacer(3, 7, 0),
                    new TwoLayerFeature(0, 0, 0,
                            OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PINK_SILK_FLOSS_TREE = register("pink_silk_floss_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.SILK_FLOSS_LOG),
                    new SimpleBlockStateProvider(States.PINK_SILK_FLOSS_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0,
                            OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));

    //Balsa Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BALSA_TREE = register("balsa_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.BALSA_LOG),
                    new SimpleBlockStateProvider(States.BALSA_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(10, 12, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MEGA_BALSA_TREE = register("mega_balsa_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.BALSA_LOG),
                    new SimpleBlockStateProvider(States.BALSA_LEAVES),
                    new JungleFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 2),
                    new MegaJungleTrunkPlacer(10, 2, 19),
                    new TwoLayerFeature(1, 1, 2))).build()));

    //Cockspur Coral Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> COCKSPUR_CORAL_TREE1 = register("cockspur_coral_tree1",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.COCKSPUR_CORAL_LOG),
                    new SimpleBlockStateProvider(States.COCKSPUR_CORAL_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> COCKSPUR_CORAL_TREE2 = register("cockspur_coral_tree2",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.COCKSPUR_CORAL_LOG),
                    new SimpleBlockStateProvider(States.COCKSPUR_CORAL_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(3), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(5, 3, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));

    //Rio Grande Cherry
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> RIO_GRANDE_CHERRY_FANCY_TREE = register("rio_grande_cherry_fancy_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.EUGENIA_LOG),
                    new SimpleBlockStateProvider(States.RIO_GRANDE_CHERRY_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0,
                            OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> RIO_GRANDE_CHERRY_TREE = register("rio_grande_cherry_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.EUGENIA_LOG),
                    new SimpleBlockStateProvider(States.RIO_GRANDE_CHERRY_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(5, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));

    //Monkey Cajarana
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MONKEY_CAJARANA_TREE1 = register("monkey_cajarana1",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.MONKEY_CAJARANA_LOG),
                    new SimpleBlockStateProvider(States.MONKEY_CAJARANA_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(3), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MONKEY_CAJARANA_TREE2 = register("monkey_cajarana2",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.MONKEY_CAJARANA_LOG),
                    new SimpleBlockStateProvider(States.MONKEY_CAJARANA_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));

    //Sombreiro
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> SOMBREIRO_TREE = register("sombreiro_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.SOMBREIRO_LOG),
                    new SimpleBlockStateProvider(States.SOMBREIRO_LEAVES),
                    new DarkOakFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0)),
                    new DarkOakTrunkPlacer(6, 2, 1),
                    new ThreeLayerFeature(1, 1, 0, 1, 2, OptionalInt.empty())))
                    .setMaxWaterDepth(Integer.MAX_VALUE).setHeightmap(Heightmap.Type.MOTION_BLOCKING).setIgnoreVines().build()));

    //Cocoa Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> COCOA_TREE = register("cocoa_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.JUNGLE_LOG),
                    new SimpleBlockStateProvider(States.JUNGLE_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .setDecorators(ImmutableList.of(new CocoaTreeDecorator(0.98F))).setIgnoreVines().build()));

    //Buriti Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BURITI_PALM = register("buriti_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.BURITI_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.BURITI_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(15, 2, 4),
                    new TwoLayerFeature(1, 0, 1))).build()));

    public static final class States {

        protected static final BlockState KAPOK_LOG = AmazonRainforestBlocks.KAPOK_LOG.get().getDefaultState();
        protected static final BlockState KAPOK_LEAVES = AmazonRainforestBlocks.KAPOK_LEAVES.get().getDefaultState();

        protected static final BlockState BURITI_LEAVES = CerradoBlocks.BURITI_LEAVES.get().getDefaultState();
        protected static final BlockState BURITI_LOG = CerradoBlocks.BURITI_LOG.get().getDefaultState();

        protected static final BlockState PALMITO_LOG = AmazonRainforestBlocks.PALMITO_LOG.get().getDefaultState();
        protected static final BlockState ACAI_LEAVES = AmazonRainforestBlocks.ACAI_LEAVES.get().getDefaultState();
        protected static final BlockState JUSSARA_LEAVES = AtlanticForestBlocks.JUSSARA_LEAVES.get().getDefaultState();

        protected static final BlockState QUEEN_PALM_LOG = AtlanticForestBlocks.QUEEN_PALM_LOG.get().getDefaultState();
        protected static final BlockState QUEEN_PALM_LEAVES = AtlanticForestBlocks.QUEEN_PALM_LEAVES.get().getDefaultState();

        protected static final BlockState BANANA_LOG = AmazonRainforestBlocks.BANANA_LOG.get().getDefaultState();
        protected static final BlockState BANANA_LEAVES = AmazonRainforestBlocks.BANANA_LEAVES.get().getDefaultState();

        protected static final BlockState CARNAUBA_LOG = CaatingaBlocks.CARNAUBA_LOG.get().getDefaultState();
        protected static final BlockState CARNAUBA_LEAVES = CaatingaBlocks.CARNAUBA_LEAVES.get().getDefaultState();

        protected static final BlockState JELLY_PALM_LOG = PampasBlocks.JELLY_PALM_LOG.get().getDefaultState();
        protected static final BlockState JELLY_PALM_LEAVES = PampasBlocks.JELLY_PALM_LEAVES.get().getDefaultState();

        protected static final BlockState SOMBREIRO_LOG = AmazonRainforestBlocks.SOMBREIRO_LOG.get().getDefaultState();
        protected static final BlockState SOMBREIRO_LEAVES = AmazonRainforestBlocks.SOMBREIRO_LEAVES.get().getDefaultState();

        protected static final BlockState CASHEW_LOG = RestingaBlocks.CASHEW_LOG.get().getDefaultState();
        protected static final BlockState CASHEW_LEAVES = RestingaBlocks.CASHEW_LEAVES.get().getDefaultState();

        protected static final BlockState YERBA_MATE_LOG = AraucariaPlateauBlocks.YERBA_MATE_LOG.get().getDefaultState();
        protected static final BlockState YERBA_MATE_LEAVES = AraucariaPlateauBlocks.YERBA_MATE_LEAVES.get().getDefaultState();

        protected static final BlockState FEIJOA_LOG = AraucariaPlateauBlocks.FEIJOA_LOG.get().getDefaultState();
        protected static final BlockState FEIJOA_LEAVES = AraucariaPlateauBlocks.FEIJOA_LEAVES.get().getDefaultState();

        protected static final BlockState BLACK_JUREMA_LOG = CaatingaBlocks.BLACK_JUREMA_LOG.get().getDefaultState();
        protected static final BlockState BLACK_JUREMA_LEAVES = CaatingaBlocks.BLACK_JUREMA_LEAVES.get().getDefaultState();

        protected static final BlockState SILK_FLOSS_LOG = CerradoBlocks.SILK_FLOSS_LOG.get().getDefaultState();
        protected static final BlockState WHITE_SILK_FLOSS_LEAVES = CaatingaBlocks.WHITE_SILK_FLOSS_LEAVES.get().getDefaultState();
        protected static final BlockState PINK_SILK_FLOSS_LEAVES = CerradoBlocks.PINK_SILK_FLOSS_LEAVES.get().getDefaultState();

        protected static final BlockState BACURI_LOG = AmazonRainforestBlocks.BACURI_LOG.get().getDefaultState();
        protected static final BlockState BACURI_LEAVES = AmazonRainforestBlocks.BACURI_LEAVES.get().getDefaultState();

        protected static final BlockState CAMU_CAMU_LOG = AmazonRainforestBlocks.CAMU_CAMU_LOG.get().getDefaultState();
        protected static final BlockState CAMU_CAMU_LEAVES = AmazonRainforestBlocks.CAMU_CAMU_LEAVES.get().getDefaultState();

        protected static final BlockState IPE_LOG = AtlanticForestBlocks.IPE_LOG.get().getDefaultState();
        protected static final BlockState YELLOW_IPE_BLOSSOM = AtlanticForestBlocks.YELLOW_IPE_BLOSSOM.get().getDefaultState();
        protected static final BlockState PURPLE_IPE_BLOSSOM = AtlanticForestBlocks.PURPLE_IPE_BLOSSOM.get().getDefaultState();
        protected static final BlockState PINK_IPE_BLOSSOM = AtlanticForestBlocks.PINK_IPE_BLOSSOM.get().getDefaultState();
        protected static final BlockState WHITE_IPE_BLOSSOM = AtlanticForestBlocks.WHITE_IPE_BLOSSOM.get().getDefaultState();
        protected static final BlockState APRICOT_IPE_BLOSSOM = AtlanticForestBlocks.APRICOT_IPE_BLOSSOM.get().getDefaultState();

        protected static final BlockState CAMBUCI_LOG = AtlanticForestBlocks.CAMBUCI_LOG.get().getDefaultState();
        protected static final BlockState CAMBUCI_LEAVES = AtlanticForestBlocks.CAMBUCI_LEAVES.get().getDefaultState();

        protected static final BlockState SCHINUS_LOG = PampasBlocks.SCHINUS_LOG.get().getDefaultState();
        protected static final BlockState BRAZILLIAN_PEPPER_LEAVES = PampasBlocks.BRAZILLIAN_PEPPER_LEAVES.get().getDefaultState();
        protected static final BlockState PERUVIAN_PEPPER_LEAVES = PampasBlocks.PERUVIAN_PEPPER_LEAVES.get().getDefaultState();
        protected static final BlockState SILVER_PEPPER_LEAVES = PampasBlocks.SILVER_PEPPER_LEAVES.get().getDefaultState();
        protected static final BlockState URUGUAYAN_PEPPER_LEAVES = PampasBlocks.URUGUAYAN_PEPPER_LEAVES.get().getDefaultState();

        protected static final BlockState WOLF_APPLE_LOG = CerradoBlocks.WOLF_APPLE_LOG.get().getDefaultState();
        protected static final BlockState WOLF_APPLE_LEAVES = CerradoBlocks.WOLF_APPLE_LEAVES.get().getDefaultState();

        protected static final BlockState MANGABA_LOG = RestingaBlocks.MANGABA_LOG.get().getDefaultState();
        protected static final BlockState MANGABA_LEAVES = RestingaBlocks.MANGABA_LEAVES.get().getDefaultState();

        protected static final BlockState BRAZILNUT_LOG = AmazonRainforestBlocks.BRAZILNUT_LOG.get().getDefaultState();
        protected static final BlockState BRAZILNUT_LEAVES = AmazonRainforestBlocks.BRAZILNUT_LEAVES.get().getDefaultState();

        protected static final BlockState GUARANA_LEAVES = AmazonRainforestBlocks.GUARANA_LEAVES.get().getDefaultState();
        protected static final BlockState CUPUACU_LEAVES = AmazonRainforestBlocks.CUPUACU_LEAVES.get().getDefaultState();
        protected static final BlockState JUNGLE_LOG = Blocks.JUNGLE_LOG.getDefaultState();
        protected static final BlockState JUNGLE_LEAVES = Blocks.JUNGLE_LEAVES.getDefaultState();

        protected static final BlockState BRAZILWOOD_LOG = AtlanticForestBlocks.BRAZILWOOD_LOG.get().getDefaultState();
        protected static final BlockState BRAZILWOOD_LEAVES = AtlanticForestBlocks.BRAZILWOOD_LEAVES.get().getDefaultState();

        protected static final BlockState JUA_LOG = CaatingaBlocks.JUA_LOG.get().getDefaultState();
        protected static final BlockState JUA_LEAVES = CaatingaBlocks.JUA_LEAVES.get().getDefaultState();

        protected static final BlockState BRAZILLIAN_SASSAFRAS_LOG = AtlanticForestBlocks.BRAZILLIAN_SASSAFRAS_LOG.get().getDefaultState();
        protected static final BlockState BRAZILLIAN_SASSAFRAS_LEAVES = AtlanticForestBlocks.BRAZILLIAN_SASSAFRAS_LEAVES.get().getDefaultState();

        protected static final BlockState UMBU_LOG = CaatingaBlocks.UMBU_LOG.get().getDefaultState();
        protected static final BlockState UMBU_LEAVES = CaatingaBlocks.UMBU_LEAVES.get().getDefaultState();

        protected static final BlockState LOPHANTERA_LOG = AmazonRainforestBlocks.LOPHANTERA_LOG.get().getDefaultState();
        protected static final BlockState LOPHANTERA_LEAVES = AmazonRainforestBlocks.LOPHANTERA_LEAVES.get().getDefaultState();

        protected static final BlockState MANACA_DA_SERRA_LOG = AtlanticForestBlocks.MANACA_DA_SERRA_LOG.get().getDefaultState();
        protected static final BlockState MANACA_DA_SERRA_LEAVES = AtlanticForestBlocks.MANACA_DA_SERRA_LEAVES.get().getDefaultState();

        protected static final BlockState EUGENIA_LOG = AtlanticForestBlocks.EUGENIA_LOG.get().getDefaultState();
        protected static final BlockState PITANGA_LEAVES = AtlanticForestBlocks.PITANGA_LEAVES.get().getDefaultState();
        protected static final BlockState BLACK_PITANGA_LEAVES = AtlanticForestBlocks.BLACK_PITANGA_LEAVES.get().getDefaultState();
        protected static final BlockState CAGAITA_LEAVES = CerradoBlocks.CAGAITA_LEAVES.get().getDefaultState();
        protected static final BlockState RIO_GRANDE_CHERRY_LEAVES = AraucariaPlateauBlocks.RIO_GRANDE_CHERRY_LEAVES.get().getDefaultState();

        protected static final BlockState SHARINGA_LOG = AmazonRainforestBlocks.SHARINGA_LOG.get().getDefaultState();
        protected static final BlockState SHARINGA_LEAVES = AmazonRainforestBlocks.SHARINGA_LEAVES.get().getDefaultState();

        protected static final BlockState PARANA_PINE_LOG = AraucariaPlateauBlocks.PARANA_PINE_LOG.get().getDefaultState();
        protected static final BlockState PARANA_PINE_LEAVES = AraucariaPlateauBlocks.PARANA_PINE_LEAVES.get().getDefaultState();

        protected static final BlockState IMBUIA_LOG = AraucariaPlateauBlocks.IMBUIA_LOG.get().getDefaultState();
        protected static final BlockState IMBUIA_LEAVES = AraucariaPlateauBlocks.IMBUIA_LEAVES.get().getDefaultState();

        protected static final BlockState CECROPIA_LOG = AtlanticForestBlocks.CECROPIA_LOG.get().getDefaultState();
        protected static final BlockState CECROPIA_LEAVES = AtlanticForestBlocks.CECROPIA_LEAVES.get().getDefaultState();
        protected static final BlockState SILVER_CECROPIA_LEAVES = AtlanticForestBlocks.CECROPIA_SILVER_LEAVES.get().getDefaultState();

        protected static final BlockState PINK_PEROBA_LOG = AtlanticForestBlocks.PINK_PEROBA_LOG.get().getDefaultState();
        protected static final BlockState PINK_PEROBA_LEAVES = AtlanticForestBlocks.PINK_PEROBA_LEAVES.get().getDefaultState();

        protected static final BlockState JEQUITIBA_LOG = AtlanticForestBlocks.JEQUITIBA_LOG.get().getDefaultState();
        protected static final BlockState JEQUITIBA_LEAVES = AtlanticForestBlocks.JEQUITIBA_LEAVES.get().getDefaultState();

        protected static final BlockState BRAZILLIAN_ROSEWOOD_LOG = AtlanticForestBlocks.BRAZILLIAN_ROSEWOOD_LOG.get().getDefaultState();
        protected static final BlockState BRAZILLIAN_ROSEWOOD_LEAVES = AtlanticForestBlocks.BRAZILLIAN_ROSEWOOD_LEAVES.get().getDefaultState();

        protected static final BlockState JABUTICABA_LOG = AtlanticForestBlocks.JABUTICABA_LOG.get().getDefaultState();
        protected static final BlockState JABUTICABA_LEAVES = AtlanticForestBlocks.JABUTICABA_LEAVES.get().getDefaultState();

        protected static final BlockState ALGARROBILLO_LOG = PampasBlocks.ALGARROBILLO_LOG.get().getDefaultState();
        protected static final BlockState ALGARROBILLO_LEAVES = PampasBlocks.ALGARROBILLO_LEAVES.get().getDefaultState();

        protected static final BlockState CAVEN_THORN_LOG = PampasBlocks.CAVEN_THORN_LOG.get().getDefaultState();
        protected static final BlockState CAVEN_THORN_LEAVES = PampasBlocks.CAVEN_THORN_LEAVES.get().getDefaultState();

        protected static final BlockState BLACK_SUCUPIRA_LOG = CerradoBlocks.BLACK_SUCUPIRA_LOG.get().getDefaultState();
        protected static final BlockState BLACK_SUCUPIRA_LEAVES = CerradoBlocks.BLACK_SUCUPIRA_LEAVES.get().getDefaultState();

        protected static final BlockState BALSA_LOG = AmazonRainforestBlocks.BALSA_LOG.get().getDefaultState();
        protected static final BlockState BALSA_LEAVES = AmazonRainforestBlocks.BALSA_LEAVES.get().getDefaultState();

        protected static final BlockState COCKSPUR_CORAL_LOG = PampasBlocks.COCKSPUR_CORAL_LOG.get().getDefaultState();
        protected static final BlockState COCKSPUR_CORAL_LEAVES = PampasBlocks.COCKSPUR_CORAL_LEAVES.get().getDefaultState();

        protected static final BlockState SAPUCAIA_LOG = AtlanticForestBlocks.SAPUCAIA_LOG.get().getDefaultState();
        protected static final BlockState SAPUCAIA_LEAVES = AtlanticForestBlocks.SAPUCAIA_LEAVES.get().getDefaultState();

        protected static final BlockState MONKEY_CAJARANA_LOG = RestingaBlocks.MONKEY_CAJARANA_LOG.get().getDefaultState();
        protected static final BlockState MONKEY_CAJARANA_LEAVES = RestingaBlocks.MONKEY_CAJARANA_LEAVES.get().getDefaultState();

        protected static final BlockState PODZOL = Blocks.PODZOL.getDefaultState();

    }

    public static final ConfiguredFeature<?, ?> AMAZON_TREES = register("amazon_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(KAPOK_TREE.withChance(0.6F),
                            CUPUACU_TREE.withChance(0.5F), COCOA_TREE.withChance(0.5F), CAMU_CAMU_TREE.withChance(0.5F), SOMBREIRO_TREE.withChance(0.5F),
                            LARGE_CECROPIA_TREE.withChance(0.5F)), SHARINGA_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(6, 0.1F, 1))));

    //Copaiba, Sandbox tree, Andiroba
    public static final ConfiguredFeature<?, ?> VARZEA_TREES = register("varzea_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(CECROPIA_TREE.withChance(0.6F)),
                            KAPOK_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(6, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> BRAZILNUT_TREES = register("brazilnut_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BRAZILNUT_TREE.withChance(0.5F)),
                    BRAZILNUT_FANCY_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));

    //Add pupunha too
    public static final ConfiguredFeature<?, ?> VARZEA_PALMS = register("varzea_palms",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BURITI_PALM.withChance(0.3F)),
                    ACAI_PALM)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> PANTANAL_VEGETATION = register("pantanal_vegetation",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BURITI_PALM.withChance(0.3F)),
                    CECROPIA_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(0, 0.01F, 1))));

    public static final ConfiguredFeature<?, ?> ATLANTIC_FOREST_PALMS = register("atlantic_forest_palms",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(JUSSARA_PALM.withChance(0.5F)),
                    QUEEN_PALM)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(7, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> BALSA_TREES = register("balsa_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BALSA_TREE.withChance(0.5F)),
                    MEGA_BALSA_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(3, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> BACURI_TREES = register("bacuri_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BACURI_TREE.withChance(0.5F)),
                    MEGA_BACURI_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(6, 0.1F, 0))));

    public static final ConfiguredFeature<?, ?> ARAUCARIA_PLATEAU_MYRTACEAE = register("araucaria_plateau_myrtaceae",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(PITANGA_TREE.withChance(0.1F),
                    BLACK_PITANGA_TREE.withChance(0.02F), FEIJOA_SHRUB.withChance(0.7F), RIO_GRANDE_CHERRY_TREE.withChance(0.5F)),
                    RIO_GRANDE_CHERRY_FANCY_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(3, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> ATLANTIC_FOREST_TREES_WITH_PASSIONVINE = register("passionvine_atlantic_forest_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BRAZILLIAN_ROSEWOOD_WITH_PASSIONVINE.withChance(0.7F),
                    BRAZILLIAN_SASSAFRAS_TREE_WITH_PASSIONVINE.withChance(0.3F), CECROPIA_WITH_PASSIONVINE.withChance(0.3F),
                            SILVER_CECROPIA_WITH_PASSIONVINE.withChance(0.07F), BRAZILWOOD_TREE_WITH_PASSIONVINE.withChance(0.7F),
                    SAPUCAIA_TREE_WITH_PASSIONVINE.withChance(0.06F), MANACA_WITH_PASSIONVINE.withChance(0.1F), CAMBUCI_TREE_WITH_PASSIONVINE.withChance(0.2F)),
                            PINK_PEROBA_TREE_WITH_PASSIONFRUIT)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.5F, 3))));

    public static final ConfiguredFeature<?, ?> LOPHANTERA_TREES = register("lophantera_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(LOPHANTERA_TREE.withChance(0.5F)),
                    LOPHANTERA_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(3, 0.1F, 0))));

    public static final ConfiguredFeature<?, ?> MANACA_TREES = register("manaca_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(MANACA_FANCY_TREE.withChance(0.1F)),
                    MANACA_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(1, 0.1F, 0))));

    public static final ConfiguredFeature<?, ?> BRAZILWOOD_TREES = register("brazilwood_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BRAZILWOOD_TREE.withChance(0.2F)),
                    BRAZILWOOD_FANCY_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(1, 0.1F, 0))));

    public static final ConfiguredFeature<?, ?> SAVANNA_TRUMPET_TREES = register("savanna_trumpet_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(WHITE_IPE_TREE.withChance(0.2F),
                    PINK_IPE_TREE.withChance(0.3F), APRICOT_IPE_TREE.withChance(0.00000034F), PURPLE_IPE_TREE.withChance(0.3F)), YELLOW_IPE_TREE))
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                            .configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> FOREST_TRUMPET_TREES = register("forest_trumpet_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(WHITE_IPE_TREE.withChance(0.025641026F),
                            PINK_IPE_TREE.withChance(0.30769232F), APRICOT_IPE_TREE.withChance(0.00000034F),
                            YELLOW_IPE_TREE.withChance(0.33333334F)), PURPLE_IPE_TREE))
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                            .configure(new AtSurfaceWithExtraConfig(1, 0.01F, 0))));

    public static final ConfiguredFeature<?, ?> RESTINGA_TRUMPET_TREES = register("restinga_trumpet_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(WHITE_IPE_TREE.withChance(0.025641026F),
                            PINK_IPE_TREE.withChance(0.30769232F), YELLOW_IPE_TREE.withChance(0.33333334F)), PURPLE_IPE_TREE))
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                            .configure(new AtSurfaceWithExtraConfig(1, 0.001F, 0))));

    public static final ConfiguredFeature<?, ?> PARANA_PINE_TREES = register("parana_pine_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(PARANA_PINE_TREE_YOUNG.withChance(0.1F)),
                    PARANA_PINE_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> OCOTEA_TREES = register("ocotea_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BRAZILLIAN_SASSAFRAS_TREE.withChance(0.2F),
                            BRAZILLIAN_SASSAFRAS_FANCY_TREE.withChance(0.1F), IMBUIA_TREE.withChance(0.3F)), IMBUIA_FANCY_TREE))
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                            .configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> MATE_TREES = register("mate_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(YERBA_MATE_FANCY_TREE.withChance(0.1F)),
                    YERBA_MATE_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(6, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> CAATINGA_TREES = register("caatinga_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(UMBU_TREE.withChance(0.2F),
                    JUA_TREE.withChance(0.1F), WHITE_SILK_FLOSS_TREE.withChance(0.01F), WHITE_SILK_FLOSS_BIG_TREE.withChance(0.0198F)), BLACK_JUREMA_TREE))
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 0))));

    public static final ConfiguredFeature<?, ?> RESTINGA_TREES = register("restinga_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(MANGABA_TREE.withChance(0.1F),
                            CECROPIA_TREE.withChance(0.2F), MONKEY_CAJARANA_TREE1.withChance(0.1F), MONKEY_CAJARANA_TREE2.withChance(0.2F)), CASHEW_SHRUB))
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                            .configure(new AtSurfaceWithExtraConfig(12, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> BEACH_PEPPER_TREES = register("beach_pepper_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BRAZILLIAN_PEPPER_BIG_TREE.withChance(0.2F),
                    BRAZILLIAN_PEPPER_STOUT_TREE.withChance(0.7F)), BRAZILLIAN_PEPPER_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> PITANGA_TREES = register("pitanga_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BLACK_PITANGA_TREE.withChance(0.02F)),
                    PITANGA_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(3, 0.0F, 0))));

    public static final ConfiguredFeature<?, ?> PAMPAS_PITANGA_TREES = register("pampas_pitanga_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BLACK_PITANGA_TREE.withChance(0.02F)),
                    PITANGA_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(0, 0.05F, 1))));

    public static final ConfiguredFeature<?, ?> PINK_PEEPER_TREES = register("pink_peeper_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(PERUVIAN_PEPPER_FANCY_TREE.withChance(0.1F),
                            PERUVIAN_PEPPER_TREE.withChance(0.1F), BRAZILLIAN_PEPPER_BIG_TREE.withChance(0.01F), BRAZILLIAN_PEPPER_STOUT_TREE.withChance(0.2F)),
                            BRAZILLIAN_PEPPER_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                            .configure(new AtSurfaceWithExtraConfig(1, 0.1F, 2))));

    public static final ConfiguredFeature<?, ?> SCRUB_PINK_PEEPER_TREES = register("scrub_pink_peeper_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BRAZILLIAN_PEPPER_BIG_TREE.withChance(0.5F),
                    BRAZILLIAN_PEPPER_STOUT_TREE.withChance(0.2F)), BRAZILLIAN_PEPPER_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 2))));

    public static final ConfiguredFeature<?, ?> PAMPAS_SHRUBS = register("pampas_shrubs",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(SILVER_PEPPER_BUSH.withChance(0.4F)),
                    URUGUAYAN_PEPPER_BUSH)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(1, 0.08F, 1))));

    public static final ConfiguredFeature<?, ?> ATLANTIC_FOREST_UPPER_TREES = register("atlantic_forest_upper_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(CECROPIA_TREE.withChance(0.1F),
                    JEQUITIBA_TREE.withChance(0.1F), BRAZILLIAN_SASSAFRAS_TREE.withChance(0.1F), BRAZILLIAN_SASSAFRAS_FANCY_TREE.withChance(0.1F),
                            SILVER_CECROPIA_TREE.withChance(0.1F), SAPUCAIA_TREE.withChance(0.1F), BRAZILLIAN_ROSEWOOD_TREE.withChance(0.3F)),
                            PINK_PEROBA_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                            .configure(new AtSurfaceWithExtraConfig(12, 0.0F, 1))));

    public static final ConfiguredFeature<?, ?> CERRADO_FRUIT_TREES = register("cerrado_fruit_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(MANGABA_TREE.withChance(0.2F),
                            CAGAITA_TREE.withChance(0.2F), WOLF_APPLE_TREE.withChance(0.2F)), BURITI_PALM)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 2))));

    public static final ConfiguredFeature<?, ?> JABUTICABA_TREES = register("jabuticaba_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(JABUTICABA_TREE_WITH_PASSIONVINE.withChance(0.1F)),
                    JABUTICABA_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> PAMPAS_TREES = register("pampas_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(CAVEN_THORN_TREE.withChance(0.3F),
                    COCKSPUR_CORAL_TREE1.withChance(0.1F), COCKSPUR_CORAL_TREE2.withChance(0.2F)), ALGARROBILLO_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(0, 0.1F, 2))));

    public static final ConfiguredFeature<?, ?> CERRADO_TREES = register("cerrado_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BLACK_SUCUPIRA_TREE.withChance(0.8F)),
                    PINK_SILK_FLOSS_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));


    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String p_243968_0_, ConfiguredFeature<FC, ?> p_243968_1_) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, p_243968_0_, p_243968_1_);
    }
}


