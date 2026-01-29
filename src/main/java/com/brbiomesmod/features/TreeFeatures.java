package com.brbiomesmod.features;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.block.TreesGroup;
import com.brbiomesmod.features.FoliagePlacers.*;
import com.brbiomesmod.features.TreeDecorators.*;
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
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CASHEW_TREE_WITH_PASSIONVINE = register("cashew_shrub_with_passionvine",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.CASHEW_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.CASHEW_LEAVES),
                    new BushFoliagePlacer(FeatureSpread.create(1), FeatureSpread.create(0), 3),
                    new MegaJungleTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).setDecorators(ImmutableList.of(
                    CaatingaPassionFruitVineLeavesDecorator.INSTANCE, CaatingaPassionFruitVineTrunkDecorator.INSTANCE)).build()));

    //Acai Palm
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ACAI_PALM = register("acai_palm",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.PALMITO_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.ACAI_LEAVES),
                    new AcaiFoliagePlacer(FeatureSpread.create(1), FeatureSpread.create(0)),
                    new StraightTrunkPlacer(10, 8, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> JUSSARA_PALM = register("jussara_palm",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.PALMITO_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.JUSSARA_LEAVES),
                    new JussaraFoliagePlacer(FeatureSpread.create(1), FeatureSpread.create(0)),
                    new StraightTrunkPlacer(16, 8, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));

    //Queen Palm
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> QUEEN_PALM = register("queen_palm",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.QUEEN_PALM_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.QUEEN_PALM_LEAVES),
                    new QueenPalmFoliagePlacer(FeatureSpread.create(1), FeatureSpread.create(0)),
                    new StraightTrunkPlacer(10, 4, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> QUEEN_PALM_WITH_VINE = register("vined_queen_palm",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.QUEEN_PALM_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.QUEEN_PALM_LEAVES),
                    new QueenPalmFoliagePlacer(FeatureSpread.create(1), FeatureSpread.create(0)),
                    new StraightTrunkPlacer(10, 4, 0),
                    new TwoLayerFeature(1, 0, 1))).setDecorators(ImmutableList.of(
                    CaatingaPassionFruitVineLeavesDecorator.INSTANCE, CaatingaPassionFruitVineTrunkDecorator.INSTANCE)).build()));

    //Jelly Palm
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> JELLY_PALM = register("jelly_palm",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.JELLY_PALM_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.JELLY_PALM_LEAVES),
                    new JellyPalmFoliagePlacer(FeatureSpread.create(1), FeatureSpread.create(0)),
                    new StraightTrunkPlacer(6, 4, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> TALL_JELLY_PALM = register("tall_jelly_palm",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.JELLY_PALM_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.JELLY_PALM_LEAVES),
                    new JellyPalmFoliagePlacer(FeatureSpread.create(1), FeatureSpread.create(0)),
                    new StraightTrunkPlacer(10, 4, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> JELLY_PALM_CAATINGA_PASSIONFLOWER = register("jelly_palm_caatinga_passionflower",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.JELLY_PALM_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.JELLY_PALM_LEAVES),
                    new JellyPalmFoliagePlacer(FeatureSpread.create(1), FeatureSpread.create(0)),
                    new StraightTrunkPlacer(6, 4, 0),
                    new TwoLayerFeature(1, 0, 1))).setDecorators(ImmutableList.of(
                    CaatingaPassionFruitVineLeavesDecorator.INSTANCE, CaatingaPassionFruitVineTrunkDecorator.INSTANCE)).build()));

    //Carnauba Palm
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CARNAUBA_PALM = register("carnauba_palm",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.CARNAUBA_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.CARNAUBA_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(15, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CARNAUBA_PALM_WITH_PASSIONVINE = register("carnauba_palm_passionvine",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.CARNAUBA_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.CARNAUBA_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(15, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).setDecorators(ImmutableList.of(
                    CaatingaPassionFruitVineLeavesDecorator.INSTANCE, CaatingaPassionFruitVineTrunkDecorator.INSTANCE)).setIgnoreVines().build()));

    //Kapok Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> KAPOK_TREE = register("kapok_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.KAPOK_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.KAPOK_LEAVES),
                    new JungleFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new MegaJungleTrunkPlacer(10, 20, 4),
                    new TwoLayerFeature(1, 0, 1))).setDecorators(ImmutableList.of(
                    TrunkVineTreeDecorator.INSTANCE, LeaveVineTreeDecorator.field_236871_b_)).setIgnoreVines().build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> YOUNG_KAPOK_TREE = register("young_kapok_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.SILK_FLOSS_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.KAPOK_LEAVES),
                    new SpruceFoliagePlacer(FeatureSpread.create(4, 1), FeatureSpread.create(0, 4), FeatureSpread.create(1, 1)),
                    new StraightTrunkPlacer(13, 4, 0),
                    new TwoLayerFeature(3, 0, 2))).setIgnoreVines().build()));

    //Black Jurema Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BLACK_JUREMA_TREE = register("black_jurema_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.BLACK_JUREMA_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.BLACK_JUREMA_LEAVES),
                    new AcaciaFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0)),
                    new ForkyTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BLACK_JUREMA_TREE_WITH_PASSIONVINE = register("black_jurema_tree_passionvine",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.BLACK_JUREMA_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.BLACK_JUREMA_LEAVES),
                    new AcaciaFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0)),
                    new ForkyTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).setDecorators(ImmutableList.of(
                    CaatingaPassionFruitVineLeavesDecorator.INSTANCE, CaatingaPassionFruitVineTrunkDecorator.INSTANCE)).build()));

    //Ipe Trees
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> YELLOW_IPE_TREE = register("yellow_ipe_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.IPE_LOG),
                    new SimpleBlockStateProvider(States.YELLOW_IPE_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING)
                    .setDecorators(ImmutableList.of(Features.Placements.BEES_002_PLACEMENT)).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PURPLE_IPE_TREE = register("purple_ipe_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.IPE_LOG),
                    new SimpleBlockStateProvider(States.PURPLE_IPE_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING)
                    .setDecorators(ImmutableList.of(Features.Placements.BEES_002_PLACEMENT)).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PINK_IPE_TREE = register("pink_ipe_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.IPE_LOG),
                    new SimpleBlockStateProvider(States.PINK_IPE_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> WHITE_IPE_TREE = register("white_ipe_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.IPE_LOG),
                    new SimpleBlockStateProvider(States.WHITE_IPE_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> APRICOT_IPE_TREE = register("apricot_ipe_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.IPE_LOG),
                    new SimpleBlockStateProvider(States.APRICOT_IPE_LEAVES),
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
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MANGABA_TREE_WITH_VINE = register("mangaba_tree_with_vine",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.MANGABA_LOG),
                    new SimpleBlockStateProvider(States.MANGABA_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new ForkyTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).setDecorators(ImmutableList.of(
                    CaatingaPassionFruitVineLeavesDecorator.INSTANCE, CaatingaPassionFruitVineTrunkDecorator.INSTANCE)).build()));

    //Wolf Apple Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> WOLF_APPLE_TREE = register("wolf_apple_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.WOLF_APPLE_LOG),
                    new SimpleBlockStateProvider(States.WOLF_APPLE_LEAVES),
                    new AcaciaFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0)),
                    new ForkyTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> WOLF_APPLE_TREE_WITH_VINE = register("wolf_apple_tree_with_vine",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.WOLF_APPLE_LOG),
                    new SimpleBlockStateProvider(States.WOLF_APPLE_LEAVES),
                    new AcaciaFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0)),
                    new ForkyTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).setDecorators(ImmutableList.of(
                    CaatingaPassionFruitVineLeavesDecorator.INSTANCE, CaatingaPassionFruitVineTrunkDecorator.INSTANCE)).build()));

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
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> JUA_TREE_WITH_PASSIONVINE = register("jua_tree_with_passionvine",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.JUA_LOG),
                    new SimpleBlockStateProvider(States.JUA_LEAVES),
                    new DarkOakFoliagePlacer(FeatureSpread.create(1), FeatureSpread.create(0)),
                    new DarkOakTrunkPlacer(3, 4, 1),
                    new TwoLayerFeature(1, 0, 1)))
                    .setDecorators(ImmutableList.of(CaatingaPassionFruitVineLeavesDecorator.INSTANCE,
                            CaatingaPassionFruitVineTrunkDecorator.INSTANCE)).setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));

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

    //Dutchman Vine Trees
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?>  BRAZILLIAN_SASSAFRAS_TREE_WITH_VINE =
            register("brazillian_sassafras_fancy_tree_with_vine",
                    Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.BRAZILLIAN_SASSAFRAS_LOG),
                            new SimpleBlockStateProvider(States.BRAZILLIAN_SASSAFRAS_LEAVES),
                            new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                            new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0,
                            OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING)
                            .setDecorators(ImmutableList.of(DutchmanPipeVineDecorator.INSTANCE)).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> DUTCHMAN_VINE_BRAZILWOOD = register("dutchman_vine_brazilwood",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.BRAZILWOOD_LOG),
                    new SimpleBlockStateProvider(States.BRAZILWOOD_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING)
                    .setDecorators(ImmutableList.of(DutchmanPipeVineDecorator.INSTANCE)).setIgnoreVines().build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PINK_PEROBA_TREE_WITH_DUTCHMAN_VINE = register("dutchman_vine_pink_peroba",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.PINK_PEROBA_LOG),
                    new SimpleBlockStateProvider(States.PINK_PEROBA_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(4, 17, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING)
                    .setDecorators(ImmutableList.of(DutchmanPipeVineDecorator.INSTANCE)).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BRAZILLIAN_ROSEWOOD_WITH_DUTCHMAN_VINE = register("dutchman_vine_brazillian_rosewood",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TreeFeatures.States.BRAZILLIAN_ROSEWOOD_LOG),
                    new SimpleBlockStateProvider(States.BRAZILLIAN_ROSEWOOD_LEAVES),
                    new AcaciaFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0)),
                    new ForkyTrunkPlacer(5, 2, 2),
                    new TwoLayerFeature(1, 0, 2))).setIgnoreVines()
                    .setDecorators(ImmutableList.of(DutchmanPipeVineDecorator.INSTANCE)).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> JABUTICABA_TREE_WITH_DUTCHMAN_VINE = register("dutchman_vine_jabuticaba_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.JABUTICABA_LOG),
                    new SimpleBlockStateProvider(States.JABUTICABA_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new DarkOakTrunkPlacer(6, 2, 1),
                    new ThreeLayerFeature(1, 1, 0, 1, 2, OptionalInt.empty())))
                    .setMaxWaterDepth(Integer.MAX_VALUE).setHeightmap(Heightmap.Type.MOTION_BLOCKING)
                    .setDecorators(ImmutableList.of(DutchmanPipeVineDecorator.INSTANCE)).setIgnoreVines().build()));


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
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PITANGA_BUSH = register("pitanga_bush",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.EUGENIA_LOG),
                    new SimpleBlockStateProvider(States.PITANGA_LEAVES),
                    new BushFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(1), 2),
                    new StraightTrunkPlacer(1, 0, 0),
                    new TwoLayerFeature(0, 0, 0))).setHeightmap(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BLACK_PITANGA_BUSH = register("black_pitanga_bush",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.EUGENIA_LOG),
                    new SimpleBlockStateProvider(States.BLACK_PITANGA_LEAVES),
                    new BushFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(1), 2),
                    new StraightTrunkPlacer(1, 0, 0),
                    new TwoLayerFeature(0, 0, 0))).setHeightmap(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES).build()));

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
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PARANA_PINE_TREE2 = register("parana_pine_tree2",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.PARANA_PINE_LOG),
                    new SimpleBlockStateProvider(States.PARANA_PINE_LEAVES),
                    new DarkOakFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0)),
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
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CECROPIA_WITH_CAATINGA_PASSIONVINE = register("caatinga_passionvine_cecropia_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.CECROPIA_LOG),
                    new SimpleBlockStateProvider(States.CECROPIA_LEAVES),
                    new JungleFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(7, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .setDecorators(ImmutableList.of(CaatingaPassionFruitVineLeavesDecorator.INSTANCE, CaatingaPassionFruitVineTrunkDecorator.INSTANCE)).setIgnoreVines().build()));


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
                    new AcaciaFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0)),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0,
                            OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING).setIgnoreVines().build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BRAZILLIAN_ROSEWOOD_WITH_PASSIONVINE = register("brazillian_rosewood_with_passionvine",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.BRAZILLIAN_ROSEWOOD_LOG),
                    new SimpleBlockStateProvider(States.BRAZILLIAN_ROSEWOOD_LEAVES),
                    new AcaciaFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0)),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0,
                            OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING).setIgnoreVines()
                    .setDecorators(ImmutableList.of(PassionFruitVineLeavesDecorator.INSTANCE, PassionFruitVineTrunkDecorator.INSTANCE)).build()));

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
                    .setDecorators(ImmutableList.of(PassionFruitVineLeavesDecorator.INSTANCE, PassionFruitVineTrunkDecorator.INSTANCE)).setIgnoreVines().build()));

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
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BLACK_SUCUPIRA_TREE_WITH_PASSIONFRUIT =
            register("black_sucupira_tree_with_passionfruit",
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
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> WHITE_SILK_FLOSS_TREE_PASSIONVINE = register("white_silk_floss_tree_passionvine",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.SILK_FLOSS_LOG),
                    new SimpleBlockStateProvider(States.WHITE_SILK_FLOSS_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0,
                            OptionalInt.of(4)))).setDecorators(ImmutableList.of(
                    CaatingaPassionFruitVineLeavesDecorator.INSTANCE, CaatingaPassionFruitVineTrunkDecorator.INSTANCE))
                    .setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> WHITE_SILK_FLOSS_BIG_TREE_PASSIONVINE = register("white_silk_floss_big_tree_passionvine",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.SILK_FLOSS_LOG),
                    new SimpleBlockStateProvider(States.WHITE_SILK_FLOSS_LEAVES),
                    new JungleFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new MegaJungleTrunkPlacer(3, 7, 0),
                    new TwoLayerFeature(0, 0, 0,
                            OptionalInt.of(4)))).setDecorators(ImmutableList.of(
                    CaatingaPassionFruitVineLeavesDecorator.INSTANCE, CaatingaPassionFruitVineTrunkDecorator.INSTANCE))
                    .setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PINK_SILK_FLOSS_TREE = register("pink_silk_floss_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.SILK_FLOSS_LOG),
                    new SimpleBlockStateProvider(States.PINK_SILK_FLOSS_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0,
                            OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PINK_SILK_FLOSS_TREE_WITH_PASSIONVINE = register("passionvine_pink_silk_floss_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.SILK_FLOSS_LOG),
                    new SimpleBlockStateProvider(States.PINK_SILK_FLOSS_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0,
                            OptionalInt.of(4)))).setDecorators(ImmutableList.of(
                    CaatingaPassionFruitVineLeavesDecorator.INSTANCE, CaatingaPassionFruitVineTrunkDecorator.INSTANCE)).setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));

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

    //Xaxim
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> XAXIM_TREE = register("xaxim_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.XAXIM_LOG),
                    new SimpleBlockStateProvider(States.XAXIM_LEAVES),
                    new XaximFoliagePlacer(FeatureSpread.create(1), FeatureSpread.create(0)),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));

    //Jenipapo Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> JENIPAPO_TREE = register("jenipapo_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.JUNGLE_LOG),
                    new SimpleBlockStateProvider(States.JENIPAPO_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(7, 5, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .setIgnoreVines().build()));

    //Guapuruvu
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> GUAPURUVU_TREE = register("guapuruvu_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.GUAPURUVU_LOG),
                    new SimpleBlockStateProvider(States.GUAPURUVU_LEAVES),
                    new JungleFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(17, 3, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));

    //Purpleheart
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PURPLEHEART_TREE = register("purpleheart_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.PURPLEHEART_LOG),
                    new SimpleBlockStateProvider(States.PURPLEHEART_LEAVES),
                    new JungleFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 2),
                    new MegaJungleTrunkPlacer(10, 2, 19),
                    new TwoLayerFeature(1, 1, 2))).build()));

    //Pequi Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PEQUI_TREE = register("pequi_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.PEQUI_LOG),
                    new SimpleBlockStateProvider(States.PEQUI_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(3), FeatureSpread.create(0), 3),
                    new ForkyTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PEQUI_TREE_WITH_VINE = register("pequi_tree_with_vine",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.PEQUI_LOG),
                    new SimpleBlockStateProvider(States.PEQUI_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(3), FeatureSpread.create(0), 3),
                    new ForkyTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).setDecorators(ImmutableList.of(
                    CaatingaPassionFruitVineLeavesDecorator.INSTANCE, CaatingaPassionFruitVineTrunkDecorator.INSTANCE)).build()));

    //Yellow Mombin tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> YELLOW_MOMBIN_TREE = register("yellow_mombin_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.YELLOW_MOMBIN_LOG),
                    new SimpleBlockStateProvider(States.YELLOW_MOMBIN_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> YELLOW_MOMBIN_TREE_WITH_VINE = register("yellow_mombin_tree_with_vine",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.YELLOW_MOMBIN_LOG),
                    new SimpleBlockStateProvider(States.YELLOW_MOMBIN_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING).setDecorators(ImmutableList.of(
                    CaatingaPassionFruitVineLeavesDecorator.INSTANCE, CaatingaPassionFruitVineTrunkDecorator.INSTANCE)).build()));

    //Sandbox Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> SANDBOX_TREE = register("sandbox_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.SANDBOX_TREE_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.SANDBOX_TREE_LEAVES),
                    new JungleFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new MegaJungleTrunkPlacer(10, 18, 4),
                    new TwoLayerFeature(1, 0, 1))).setDecorators(ImmutableList.of(
                    TrunkVineTreeDecorator.INSTANCE, LeaveVineTreeDecorator.field_236871_b_)).setIgnoreVines().build()));


    public static final class States {

        protected static final BlockState KAPOK_LOG = TreesGroup.KAPOK_LOG.get().getDefaultState();
        protected static final BlockState KAPOK_LEAVES = TreesGroup.KAPOK_LEAVES.get().getDefaultState();

        protected static final BlockState SANDBOX_TREE_LOG = TreesGroup.SANDBOX_TREE_LOG.get().getDefaultState();
        protected static final BlockState SANDBOX_TREE_LEAVES = TreesGroup.SANDBOX_TREE_LEAVES.get().getDefaultState();

        protected static final BlockState PEQUI_LOG = TreesGroup.PEQUI_LOG.get().getDefaultState();
        protected static final BlockState PEQUI_LEAVES = TreesGroup.PEQUI_LEAVES.get().getDefaultState();

        protected static final BlockState YELLOW_MOMBIN_LOG = TreesGroup.YELLOW_MOMBIN_LOG.get().getDefaultState();
        protected static final BlockState YELLOW_MOMBIN_LEAVES = TreesGroup.YELLOW_MOMBIN_LEAVES.get().getDefaultState();

        protected static final BlockState PURPLEHEART_LOG = TreesGroup.PURPLEHEART_LOG.get().getDefaultState();
        protected static final BlockState PURPLEHEART_LEAVES = TreesGroup.PURPLEHEART_LEAVES.get().getDefaultState();

        protected static final BlockState GUAPURUVU_LOG = TreesGroup.GUAPURUVU_LOG.get().getDefaultState();
        protected static final BlockState GUAPURUVU_LEAVES = TreesGroup.GUAPURUVU_LEAVES.get().getDefaultState();

        protected static final BlockState XAXIM_LOG = TreesGroup.XAXIM_LOG.get().getDefaultState();
        protected static final BlockState XAXIM_LEAVES = TreesGroup.XAXIM_LEAVES.get().getDefaultState();

        protected static final BlockState JENIPAPO_LEAVES = TreesGroup.JENIPAPO_LEAVES.get().getDefaultState();

        protected static final BlockState BURITI_LEAVES = TreesGroup.BURITI_LEAVES.get().getDefaultState();
        protected static final BlockState BURITI_LOG = TreesGroup.BURITI_LOG.get().getDefaultState();

        protected static final BlockState PALMITO_LOG = TreesGroup.PALMITO_LOG.get().getDefaultState();
        protected static final BlockState ACAI_LEAVES = TreesGroup.ACAI_LEAVES.get().getDefaultState();
        protected static final BlockState JUSSARA_LEAVES = TreesGroup.JUSSARA_LEAVES.get().getDefaultState();

        protected static final BlockState QUEEN_PALM_LOG = TreesGroup.QUEEN_PALM_LOG.get().getDefaultState();
        protected static final BlockState QUEEN_PALM_LEAVES = TreesGroup.QUEEN_PALM_LEAVES.get().getDefaultState();

        protected static final BlockState CARNAUBA_LOG = TreesGroup.CARNAUBA_LOG.get().getDefaultState();
        protected static final BlockState CARNAUBA_LEAVES = TreesGroup.CARNAUBA_LEAVES.get().getDefaultState();

        protected static final BlockState JELLY_PALM_LOG = TreesGroup.JELLY_PALM_LOG.get().getDefaultState();
        protected static final BlockState JELLY_PALM_LEAVES = TreesGroup.JELLY_PALM_LEAVES.get().getDefaultState();

        protected static final BlockState SOMBREIRO_LOG = TreesGroup.SOMBREIRO_LOG.get().getDefaultState();
        protected static final BlockState SOMBREIRO_LEAVES = TreesGroup.SOMBREIRO_LEAVES.get().getDefaultState();

        protected static final BlockState CASHEW_LOG = TreesGroup.CASHEW_LOG.get().getDefaultState();
        protected static final BlockState CASHEW_LEAVES = TreesGroup.CASHEW_LEAVES.get().getDefaultState();

        protected static final BlockState YERBA_MATE_LOG = TreesGroup.YERBA_MATE_LOG.get().getDefaultState();
        protected static final BlockState YERBA_MATE_LEAVES = TreesGroup.YERBA_MATE_LEAVES.get().getDefaultState();

        protected static final BlockState FEIJOA_LOG = TreesGroup.FEIJOA_LOG.get().getDefaultState();
        protected static final BlockState FEIJOA_LEAVES = TreesGroup.FEIJOA_LEAVES.get().getDefaultState();

        protected static final BlockState BLACK_JUREMA_LOG = TreesGroup.BLACK_JUREMA_LOG.get().getDefaultState();
        protected static final BlockState BLACK_JUREMA_LEAVES = TreesGroup.BLACK_JUREMA_LEAVES.get().getDefaultState();

        protected static final BlockState SILK_FLOSS_LOG = TreesGroup.SILK_FLOSS_LOG.get().getDefaultState();
        protected static final BlockState WHITE_SILK_FLOSS_LEAVES = TreesGroup.WHITE_SILK_FLOSS_LEAVES.get().getDefaultState();
        protected static final BlockState PINK_SILK_FLOSS_LEAVES = TreesGroup.PINK_SILK_FLOSS_LEAVES.get().getDefaultState();

        protected static final BlockState BACURI_LOG = TreesGroup.BACURI_LOG.get().getDefaultState();
        protected static final BlockState BACURI_LEAVES = TreesGroup.BACURI_LEAVES.get().getDefaultState();

        protected static final BlockState CAMU_CAMU_LOG = TreesGroup.CAMU_CAMU_LOG.get().getDefaultState();
        protected static final BlockState CAMU_CAMU_LEAVES = TreesGroup.CAMU_CAMU_LEAVES.get().getDefaultState();

        protected static final BlockState IPE_LOG = TreesGroup.IPE_LOG.get().getDefaultState();
        protected static final BlockState YELLOW_IPE_LEAVES = TreesGroup.YELLOW_IPE_LEAVES.get().getDefaultState();
        protected static final BlockState PURPLE_IPE_LEAVES = TreesGroup.PURPLE_IPE_LEAVES.get().getDefaultState();
        protected static final BlockState PINK_IPE_LEAVES = TreesGroup.PINK_IPE_LEAVES.get().getDefaultState();
        protected static final BlockState WHITE_IPE_LEAVES = TreesGroup.WHITE_IPE_LEAVES.get().getDefaultState();
        protected static final BlockState APRICOT_IPE_LEAVES = TreesGroup.APRICOT_IPE_LEAVES.get().getDefaultState();

        protected static final BlockState CAMBUCI_LOG = TreesGroup.CAMBUCI_LOG.get().getDefaultState();
        protected static final BlockState CAMBUCI_LEAVES = TreesGroup.CAMBUCI_LEAVES.get().getDefaultState();

        protected static final BlockState SCHINUS_LOG = TreesGroup.SCHINUS_LOG.get().getDefaultState();
        protected static final BlockState BRAZILLIAN_PEPPER_LEAVES = TreesGroup.BRAZILLIAN_PEPPER_LEAVES.get().getDefaultState();
        protected static final BlockState PERUVIAN_PEPPER_LEAVES = TreesGroup.PERUVIAN_PEPPER_LEAVES.get().getDefaultState();
        protected static final BlockState SILVER_PEPPER_LEAVES = TreesGroup.SILVER_PEPPER_LEAVES.get().getDefaultState();

        protected static final BlockState WOLF_APPLE_LOG = TreesGroup.WOLF_APPLE_LOG.get().getDefaultState();
        protected static final BlockState WOLF_APPLE_LEAVES = TreesGroup.WOLF_APPLE_LEAVES.get().getDefaultState();

        protected static final BlockState MANGABA_LOG = TreesGroup.MANGABA_LOG.get().getDefaultState();
        protected static final BlockState MANGABA_LEAVES = TreesGroup.MANGABA_LEAVES.get().getDefaultState();

        protected static final BlockState BRAZILNUT_LOG = TreesGroup.BRAZILNUT_LOG.get().getDefaultState();
        protected static final BlockState BRAZILNUT_LEAVES = TreesGroup.BRAZILNUT_LEAVES.get().getDefaultState();

        protected static final BlockState GUARANA_LEAVES = TreesGroup.GUARANA_LEAVES.get().getDefaultState();
        protected static final BlockState CUPUACU_LEAVES = TreesGroup.CUPUACU_LEAVES.get().getDefaultState();
        protected static final BlockState JUNGLE_LOG = Blocks.JUNGLE_LOG.getDefaultState();
        protected static final BlockState JUNGLE_LEAVES = Blocks.JUNGLE_LEAVES.getDefaultState();

        protected static final BlockState BRAZILWOOD_LOG = TreesGroup.BRAZILWOOD_LOG.get().getDefaultState();
        protected static final BlockState BRAZILWOOD_LEAVES = TreesGroup.BRAZILWOOD_LEAVES.get().getDefaultState();

        protected static final BlockState JUA_LOG = TreesGroup.JUA_LOG.get().getDefaultState();
        protected static final BlockState JUA_LEAVES = TreesGroup.JUA_LEAVES.get().getDefaultState();

        protected static final BlockState BRAZILLIAN_SASSAFRAS_LOG = TreesGroup.BRAZILLIAN_SASSAFRAS_LOG.get().getDefaultState();
        protected static final BlockState BRAZILLIAN_SASSAFRAS_LEAVES = TreesGroup.BRAZILLIAN_SASSAFRAS_LEAVES.get().getDefaultState();

        protected static final BlockState UMBU_LOG = TreesGroup.UMBU_LOG.get().getDefaultState();
        protected static final BlockState UMBU_LEAVES = TreesGroup.UMBU_LEAVES.get().getDefaultState();

        protected static final BlockState LOPHANTERA_LOG = TreesGroup.LOPHANTERA_LOG.get().getDefaultState();
        protected static final BlockState LOPHANTERA_LEAVES = TreesGroup.LOPHANTERA_LEAVES.get().getDefaultState();

        protected static final BlockState MANACA_DA_SERRA_LOG = TreesGroup.MANACA_DA_SERRA_LOG.get().getDefaultState();
        protected static final BlockState MANACA_DA_SERRA_LEAVES = TreesGroup.MANACA_DA_SERRA_LEAVES.get().getDefaultState();

        protected static final BlockState EUGENIA_LOG = TreesGroup.EUGENIA_LOG.get().getDefaultState();
        protected static final BlockState PITANGA_LEAVES = TreesGroup.PITANGA_LEAVES.get().getDefaultState();
        protected static final BlockState BLACK_PITANGA_LEAVES = TreesGroup.BLACK_PITANGA_LEAVES.get().getDefaultState();
        protected static final BlockState CAGAITA_LEAVES = TreesGroup.CAGAITA_LEAVES.get().getDefaultState();
        protected static final BlockState RIO_GRANDE_CHERRY_LEAVES = TreesGroup.RIO_GRANDE_CHERRY_LEAVES.get().getDefaultState();

        protected static final BlockState SHARINGA_LOG = TreesGroup.SHARINGA_LOG.get().getDefaultState();
        protected static final BlockState SHARINGA_LEAVES = TreesGroup.SHARINGA_LEAVES.get().getDefaultState();

        protected static final BlockState PARANA_PINE_LOG = TreesGroup.PARANA_PINE_LOG.get().getDefaultState();
        protected static final BlockState PARANA_PINE_LEAVES = TreesGroup.PARANA_PINE_LEAVES.get().getDefaultState();

        protected static final BlockState IMBUIA_LOG = TreesGroup.IMBUIA_LOG.get().getDefaultState();
        protected static final BlockState IMBUIA_LEAVES = TreesGroup.IMBUIA_LEAVES.get().getDefaultState();

        protected static final BlockState CECROPIA_LOG = TreesGroup.CECROPIA_LOG.get().getDefaultState();
        protected static final BlockState CECROPIA_LEAVES = TreesGroup.CECROPIA_LEAVES.get().getDefaultState();
        protected static final BlockState SILVER_CECROPIA_LEAVES = TreesGroup.CECROPIA_SILVER_LEAVES.get().getDefaultState();

        protected static final BlockState PINK_PEROBA_LOG = TreesGroup.PINK_PEROBA_LOG.get().getDefaultState();
        protected static final BlockState PINK_PEROBA_LEAVES = TreesGroup.PINK_PEROBA_LEAVES.get().getDefaultState();

        protected static final BlockState JEQUITIBA_LOG = TreesGroup.JEQUITIBA_LOG.get().getDefaultState();
        protected static final BlockState JEQUITIBA_LEAVES = TreesGroup.JEQUITIBA_LEAVES.get().getDefaultState();

        protected static final BlockState BRAZILLIAN_ROSEWOOD_LOG = TreesGroup.BRAZILLIAN_ROSEWOOD_LOG.get().getDefaultState();
        protected static final BlockState BRAZILLIAN_ROSEWOOD_LEAVES = TreesGroup.BRAZILLIAN_ROSEWOOD_LEAVES.get().getDefaultState();

        protected static final BlockState JABUTICABA_LOG = TreesGroup.JABUTICABA_LOG.get().getDefaultState();
        protected static final BlockState JABUTICABA_LEAVES = TreesGroup.JABUTICABA_LEAVES.get().getDefaultState();

        protected static final BlockState ALGARROBILLO_LOG = TreesGroup.ALGARROBILLO_LOG.get().getDefaultState();
        protected static final BlockState ALGARROBILLO_LEAVES = TreesGroup.ALGARROBILLO_LEAVES.get().getDefaultState();

        protected static final BlockState CAVEN_THORN_LOG = TreesGroup.CAVEN_THORN_LOG.get().getDefaultState();
        protected static final BlockState CAVEN_THORN_LEAVES = TreesGroup.CAVEN_THORN_LEAVES.get().getDefaultState();

        protected static final BlockState BLACK_SUCUPIRA_LOG = TreesGroup.BLACK_SUCUPIRA_LOG.get().getDefaultState();
        protected static final BlockState BLACK_SUCUPIRA_LEAVES = TreesGroup.BLACK_SUCUPIRA_LEAVES.get().getDefaultState();

        protected static final BlockState BALSA_LOG = TreesGroup.BALSA_LOG.get().getDefaultState();
        protected static final BlockState BALSA_LEAVES = TreesGroup.BALSA_LEAVES.get().getDefaultState();

        protected static final BlockState COCKSPUR_CORAL_LOG = TreesGroup.COCKSPUR_CORAL_LOG.get().getDefaultState();
        protected static final BlockState COCKSPUR_CORAL_LEAVES = TreesGroup.COCKSPUR_CORAL_LEAVES.get().getDefaultState();

        protected static final BlockState SAPUCAIA_LOG = TreesGroup.SAPUCAIA_LOG.get().getDefaultState();
        protected static final BlockState SAPUCAIA_LEAVES = TreesGroup.SAPUCAIA_LEAVES.get().getDefaultState();

        protected static final BlockState MONKEY_CAJARANA_LOG = TreesGroup.MONKEY_CAJARANA_LOG.get().getDefaultState();
        protected static final BlockState MONKEY_CAJARANA_LEAVES = TreesGroup.MONKEY_CAJARANA_LEAVES.get().getDefaultState();

        protected static final BlockState PODZOL = Blocks.PODZOL.getDefaultState();

    }

    //Atlantic forest vegetation
    public static final ConfiguredFeature<?, ?> ATLANTIC_FOREST_PALMS = register("atlantic_forest_palms",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(JUSSARA_PALM.withChance(0.5F)),
                    QUEEN_PALM)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(7, 0.1F, 1))));
    public static final ConfiguredFeature<?, ?> ATLANTIC_FOREST_TREES_WITH_PASSIONVINE = register("passionvine_atlantic_forest_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BRAZILLIAN_ROSEWOOD_WITH_PASSIONVINE.withChance(0.5F),
                            BRAZILLIAN_SASSAFRAS_TREE_WITH_PASSIONVINE.withChance(0.3F), CECROPIA_WITH_PASSIONVINE.withChance(0.3F),
                            SILVER_CECROPIA_WITH_PASSIONVINE.withChance(0.17F), BRAZILWOOD_TREE_WITH_PASSIONVINE.withChance(0.5F),
                            SAPUCAIA_TREE_WITH_PASSIONVINE.withChance(0.3F), MANACA_WITH_PASSIONVINE.withChance(0.1F),
                            JABUTICABA_TREE_WITH_PASSIONVINE.withChance(0.3F)),
                            PINK_PEROBA_TREE_WITH_PASSIONFRUIT)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.5F, 3))));
    public static final ConfiguredFeature<?, ?> ATLANTIC_FOREST_UPPER_TREES = register("atlantic_forest_upper_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(CECROPIA_TREE.withChance(0.3F),
                    JEQUITIBA_TREE.withChance(0.4F), BRAZILLIAN_SASSAFRAS_TREE.withChance(0.3F), GUAPURUVU_TREE.withChance(0.2F),
                    BRAZILLIAN_SASSAFRAS_FANCY_TREE.withChance(0.3F), MANACA_FANCY_TREE.withChance(0.4F), MANACA_TREE.withChance(0.3F),
                    SILVER_CECROPIA_TREE.withChance(0.2F), BLACK_SUCUPIRA_TREE.withChance(0.3F), SAPUCAIA_TREE.withChance(0.4F),
                    BRAZILLIAN_ROSEWOOD_TREE.withChance(0.5F), BRAZILWOOD_TREE.withChance(0.4F),BRAZILWOOD_FANCY_TREE.withChance(0.5F),
                    JENIPAPO_TREE.withChance(0.3F), JABUTICABA_TREE.withChance(0.5F), PURPLEHEART_TREE.withChance(0.3F), YELLOW_MOMBIN_TREE.withChance(0.4F)),
                    PINK_PEROBA_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(12, 0.4F, 3))));
    public static final ConfiguredFeature<?, ?> CAMBUCI_TREES = register("cambuci_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(CAMBUCI_TREE_WITH_PASSIONVINE.withChance(0.005F)),
                    CAMBUCI_TREE)).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(5, 0.0F, 0))));
    public static final ConfiguredFeature<?, ?> ATLANTIC_FOREST_TREE_WITH_DUTCHMAN_VINE = register("atlantic_forest_trees_with_dutchman_vine",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of
                    (BRAZILLIAN_SASSAFRAS_TREE_WITH_VINE.withChance(0.14F), JABUTICABA_TREE_WITH_DUTCHMAN_VINE.withChance(0.15F),
                            DUTCHMAN_VINE_BRAZILWOOD.withChance(0.2F), PINK_PEROBA_TREE_WITH_DUTCHMAN_VINE.withChance(0.3F)),
                    BRAZILLIAN_ROSEWOOD_WITH_DUTCHMAN_VINE)).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(0, 0.5F, 3))));

    //Amazon rainforest vegetation
    public static final ConfiguredFeature<?, ?> AMAZON_TREES = register("amazon_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(YOUNG_KAPOK_TREE.withChance(0.4F), KAPOK_TREE.withChance(0.35F),
                            CUPUACU_TREE.withChance(0.4F), COCOA_TREE.withChance(0.4F), CAMU_CAMU_TREE.withChance(0.25F), SOMBREIRO_TREE.withChance(0.3F),
                            LARGE_CECROPIA_TREE.withChance(0.2F), SHARINGA_TREE.withChance(0.5F), LOPHANTERA_TREE2.withChance(0.25F),
                            BACURI_TREE.withChance(0.3F), BLACK_SUCUPIRA_TREE.withChance(0.3F), MEGA_BACURI_TREE.withChance(0.34F),
                            BALSA_TREE.withChance(0.5F), SANDBOX_TREE.withChance(0.4F), JENIPAPO_TREE.withChance(0.3F),
                            MEGA_BALSA_TREE.withChance(0.5F), YELLOW_MOMBIN_TREE.withChance(0.2F), BRAZILNUT_TREE.withChance(0.5F),  BRAZILNUT_FANCY_TREE.withChance(0.5F),
                            PURPLEHEART_TREE.withChance(0.4F)), LOPHANTERA_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(12, 0.0F, 2))));
    public static final ConfiguredFeature<?, ?> VARZEA_TREES = register("varzea_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(CECROPIA_TREE.withChance(0.09F),
                            KAPOK_TREE.withChance(0.25F), YELLOW_MOMBIN_TREE.withChance(0.17F), JENIPAPO_TREE.withChance(0.22F),
                            YOUNG_KAPOK_TREE.withChance(0.4F)), SANDBOX_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.3F, 1))));//Add copaiba and andiroba
    public static final ConfiguredFeature<?, ?> VARZEA_PALMS = register("varzea_palms",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BURITI_PALM.withChance(0.3F)),
                    ACAI_PALM)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));//Add pupunha too


    //Pampas Vegetation
    public static final ConfiguredFeature<?, ?> PAMPAS_PALMS = register("pampas_palms",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(QUEEN_PALM.withChance(0.2F)),
                    JELLY_PALM)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(0, 0.3F, 4))));
    public static final ConfiguredFeature<?, ?> BUTIA_SAVANNA_VEGETATION = register("butia_savanna_vegetation",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(TALL_JELLY_PALM.withChance(0.5F)),
                    JELLY_PALM)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(8, 0.1F, 1))));
    public static final ConfiguredFeature<?, ?> PAMPAS_TREES = register("pampas_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(CAVEN_THORN_TREE.withChance(0.3F),
                    COCKSPUR_CORAL_TREE1.withChance(0.1F), COCKSPUR_CORAL_TREE2.withChance(0.2F)), ALGARROBILLO_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(0, 0.1F, 2))));


    //Pantanal Vegetation
    public static final ConfiguredFeature<?, ?> PANTANAL_VEGETATION = register("pantanal_vegetation",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BURITI_PALM.withChance(0.3F),
                    JENIPAPO_TREE.withChance(0.3F), PINK_SILK_FLOSS_TREE.withChance(0.3F), BLACK_SUCUPIRA_TREE.withChance(0.3F)),
                    CECROPIA_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(3, 0.1F, 0))));


    //Araucaria Plateau
    public static final ConfiguredFeature<?, ?> ARAUCARIA_PLATEAU_MYRTACEAE = register("araucaria_plateau_myrtaceae",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(PITANGA_TREE.withChance(0.1F),
                    BLACK_PITANGA_TREE.withChance(0.02F), FEIJOA_SHRUB.withChance(0.7F), RIO_GRANDE_CHERRY_TREE.withChance(0.5F)),
                    RIO_GRANDE_CHERRY_FANCY_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(3, 0.1F, 1))));
    public static final ConfiguredFeature<?, ?> PARANA_PINE_TREES = register("parana_pine_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(PARANA_PINE_TREE_YOUNG.withChance(0.2F),
                    PARANA_PINE_TREE.withChance(0.4F), XAXIM_TREE.withChance(0.5F)),
                    PARANA_PINE_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(7, 0.1F, 1))));
    public static final ConfiguredFeature<?, ?> OCOTEA_TREES = register("ocotea_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BRAZILLIAN_SASSAFRAS_TREE.withChance(0.2F),
                            BRAZILLIAN_SASSAFRAS_FANCY_TREE.withChance(0.1F), IMBUIA_TREE.withChance(0.3F)), IMBUIA_FANCY_TREE))
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                            .configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
    public static final ConfiguredFeature<?, ?> MATE_TREES = register("mate_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(YERBA_MATE_FANCY_TREE.withChance(0.1F)),
                    YERBA_MATE_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(6, 0.1F, 1))));


    //Trumpet Trees
    public static final ConfiguredFeature<?, ?> SAVANNA_TRUMPET_TREES = register("savanna_trumpet_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(WHITE_IPE_TREE.withChance(0.2F),
                    PINK_IPE_TREE.withChance(0.3F), APRICOT_IPE_TREE.withChance(0.000034F), PURPLE_IPE_TREE.withChance(0.3F)), YELLOW_IPE_TREE))
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                            .configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));
    public static final ConfiguredFeature<?, ?> FOREST_TRUMPET_TREES = register("forest_trumpet_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(WHITE_IPE_TREE.withChance(0.025641026F),
                            PINK_IPE_TREE.withChance(0.30769232F), APRICOT_IPE_TREE.withChance(0.000034F),
                            YELLOW_IPE_TREE.withChance(0.33333334F)), PURPLE_IPE_TREE))
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                            .configure(new AtSurfaceWithExtraConfig(1, 0.01F, 0))));
    public static final ConfiguredFeature<?, ?> RESTINGA_TRUMPET_TREES = register("restinga_trumpet_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(PURPLE_IPE_TREE.withChance(0.3F),
                            PINK_IPE_TREE.withChance(0.30769232F), YELLOW_IPE_TREE.withChance(0.33333334F)), WHITE_IPE_TREE))
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                            .configure(new AtSurfaceWithExtraConfig(1, 0.1F, 0))));

    //Caatinga vegetation
    public static final ConfiguredFeature<?, ?> CAATINGA_TREES = register("caatinga_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(UMBU_TREE.withChance(0.2F),
                    JUA_TREE.withChance(0.1F), JUA_TREE_WITH_PASSIONVINE.withChance(0.03F), WHITE_SILK_FLOSS_TREE.withChance(0.01F),
                            CARNAUBA_PALM.withChance(0.2F), BLACK_SUCUPIRA_TREE.withChance(0.03F), CARNAUBA_PALM_WITH_PASSIONVINE.withChance(0.03F),
                            BLACK_JUREMA_TREE_WITH_PASSIONVINE.withChance(0.05F), WHITE_SILK_FLOSS_BIG_TREE_PASSIONVINE.withChance(0.025F),
                            WHITE_SILK_FLOSS_TREE_PASSIONVINE.withChance(0.045F), WHITE_SILK_FLOSS_BIG_TREE.withChance(0.0198F)), BLACK_JUREMA_TREE))
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 2))));

    //Restinga vegetation
    public static final ConfiguredFeature<?, ?> RESTINGA_TREES = register("restinga_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(MANGABA_TREE.withChance(0.1F),
                            CECROPIA_TREE.withChance(0.2F), CECROPIA_WITH_CAATINGA_PASSIONVINE.withChance(0.0083F), YELLOW_MOMBIN_TREE.withChance(0.09F),
                            MONKEY_CAJARANA_TREE1.withChance(0.1F), JUA_TREE.withChance(0.089F), JUA_TREE_WITH_PASSIONVINE.withChance(0.0079F),
                            MONKEY_CAJARANA_TREE2.withChance(0.2F), BRAZILWOOD_TREE.withChance(0.1F), BRAZILWOOD_FANCY_TREE.withChance(0.09F),
                            JENIPAPO_TREE.withChance(0.1F), BLACK_SUCUPIRA_TREE.withChance(0.1F), CASHEW_TREE_WITH_PASSIONVINE.withChance(0.02F),
                            YELLOW_MOMBIN_TREE_WITH_VINE.withChance(0.015F), MANGABA_TREE_WITH_VINE.withChance(0.015F)), CASHEW_SHRUB))
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                            .configure(new AtSurfaceWithExtraConfig(12, 0.1F, 1))));

    //Brazilian pepper
    public static final ConfiguredFeature<?, ?> BEACH_PEPPER_TREES = register("beach_pepper_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BRAZILLIAN_PEPPER_BIG_TREE.withChance(0.2F),
                    BRAZILLIAN_PEPPER_STOUT_TREE.withChance(0.7F)), BRAZILLIAN_PEPPER_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1))));
    public static final ConfiguredFeature<?, ?> PINK_PEEPER_TREES = register("pink_peeper_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(PERUVIAN_PEPPER_FANCY_TREE.withChance(0.1F),
                    PERUVIAN_PEPPER_TREE.withChance(0.1F), BRAZILLIAN_PEPPER_BIG_TREE.withChance(0.01F), BRAZILLIAN_PEPPER_STOUT_TREE.withChance(0.2F),
                    SILVER_PEPPER_BUSH.withChance(0.1F)), BRAZILLIAN_PEPPER_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(0, 0.2F, 4))));
    public static final ConfiguredFeature<?, ?> SCRUB_PINK_PEEPER_TREES = register("scrub_pink_peeper_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BRAZILLIAN_PEPPER_BIG_TREE.withChance(0.5F),
                            BRAZILLIAN_PEPPER_STOUT_TREE.withChance(0.2F)), BRAZILLIAN_PEPPER_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 2))));

    //Pitanga trees
    public static final ConfiguredFeature<?, ?> PITANGA_TREES = register("pitanga_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BLACK_PITANGA_TREE.withChance(0.02F)),
                    PITANGA_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(3, 0.0F, 0))));
    public static final ConfiguredFeature<?, ?> PAMPAS_PITANGA_TREES = register("pampas_pitanga_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BLACK_PITANGA_TREE.withChance(0.02F)),
                    PITANGA_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(0, 0.05F, 1))));

    //Cerrado vegetation
    public static final ConfiguredFeature<?, ?> CERRADO_FRUIT_TREES = register("cerrado_fruit_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(MANGABA_TREE.withChance(0.1985F),
                            CAGAITA_TREE.withChance(0.1895F), YELLOW_MOMBIN_TREE.withChance(0.13F), JENIPAPO_TREE.withChance(0.2F),
                            YELLOW_MOMBIN_TREE_WITH_VINE.withChance(0.0095F), PEQUI_TREE.withChance(0.35F), MANGABA_TREE_WITH_VINE.withChance(0.0003F),
                            WOLF_APPLE_TREE_WITH_VINE.withChance(0.0025F), PEQUI_TREE_WITH_VINE.withChance(0.0005F), CECROPIA_TREE.withChance(0.08F),
                            CECROPIA_WITH_CAATINGA_PASSIONVINE.withChance(0.0003F)),
                            WOLF_APPLE_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.3F, 2))));
    public static final ConfiguredFeature<?, ?> CERRADO_PALM_TREES = register("cerrado_palm_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(QUEEN_PALM.withChance(0.5F),
                            JELLY_PALM.withChance(0.2F), JELLY_PALM_CAATINGA_PASSIONFLOWER.withChance(0.03F), QUEEN_PALM_WITH_VINE.withChance(0.004F)),
                            BURITI_PALM)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));
    public static final ConfiguredFeature<?, ?> CERRADO_TREES = register("cerrado_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BLACK_SUCUPIRA_TREE.withChance(0.8F),
                    BLACK_SUCUPIRA_TREE_WITH_PASSIONFRUIT.withChance(0.0004F), PINK_SILK_FLOSS_TREE_WITH_PASSIONVINE.withChance(0.00054F)),
                    PINK_SILK_FLOSS_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));


    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String p_243968_0_, ConfiguredFeature<FC, ?> p_243968_1_) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, p_243968_0_, p_243968_1_);
    }
}


