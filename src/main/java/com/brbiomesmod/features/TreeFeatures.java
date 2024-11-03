package com.brbiomesmod.features;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.block.BlockClasses.*;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.*;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraft.world.gen.trunkplacer.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.OptionalInt;
import java.util.Random;

import static net.minecraft.item.UseAction.BLOCK;

public abstract class TreeFeatures implements IFeatureConfig {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, BrazillianBiomesMod.MOD_ID);

    //Cashew Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CASHEW_SHRUB = register("cashew_shrub",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.CASHEW_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.CASHEW_LEAVES),
                    new BushFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new MegaJungleTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CASHEW_TREE = register("cashew_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.CASHEW_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.CASHEW_LEAVES),
                    new BushFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new ForkyTrunkPlacer(4, 2, 0), //replace for straight if it goes bad
                    new TwoLayerFeature(1, 0, 1))).build()));

    //Kapok Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> KAPOK_TREE = register("kapok_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.KAPOK_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.KAPOK_LEAVES),
                    new JungleFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new MegaJungleTrunkPlacer(10, 20, 4),
                    new TwoLayerFeature(1, 0, 1))).build()));

    //Black Jurema Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BLACK_JUREMA_TREE = register("black_jurema_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.BLACK_JUREMA_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.BLACK_JUREMA_LEAVES),
                    new AcaciaFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0)),
                    new ForkyTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));

    //Ipe Trees
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> YELLOW_IPE_TREE = register("yellow_ipe_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.IPE_LOG),
                    new SimpleBlockStateProvider(States.YELLOW_IPE_BLOSSOM),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> YELLOW_IPE_FANCY_TREE = register("yellow_ipe_fancy_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.IPE_LOG),
                    new SimpleBlockStateProvider(States.YELLOW_IPE_BLOSSOM),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PURPLE_IPE_TREE = register("purple_ipe_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.IPE_LOG),
                    new SimpleBlockStateProvider(States.PURPLE_IPE_BLOSSOM),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));
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

    //FeijoaShrub
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FEIJOA_SHRUB = register("feijoa_shrub",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.FEIJOA_LOG),
                    new SimpleBlockStateProvider(States.FEIJOA_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(1), 2),
                    new StraightTrunkPlacer(2, 1, 0),
                    new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));

    //Cambuci Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CAMBUCI_TREE = register("cambuci_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.CAMBUCI_LOG),
                    new SimpleBlockStateProvider(States.CAMBUCI_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));

    //Peruvian Pepper Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PERUVIAN_PEPPER_TREE = register("peruvian_pepper_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.SCHINUS_LOG),
                    new SimpleBlockStateProvider(States.PERUVIAN_PEPPER_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PERUVIAN_PEPPER_FANCY_TREE = register("peruvian_pepper_fancy_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.SCHINUS_LOG),
                    new SimpleBlockStateProvider(States.PERUVIAN_PEPPER_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));

    //Brazillian Pepper Tree
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BRAZILLIAN_PEPPER_TREE = register("brazillian_pepper_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.SCHINUS_LOG),
                    new SimpleBlockStateProvider(States.BRAZILLIAN_PEPPER_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BRAZILLIAN_PEPPER_BIG_TREE = register("brazillian_pepper_big_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.SCHINUS_LOG),
                    new SimpleBlockStateProvider(States.BRAZILLIAN_PEPPER_LEAVES),
                    new DarkOakFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0)),
                    new DarkOakTrunkPlacer(3, 4, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));

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
                    new BushFoliagePlacer(FeatureSpread.create(1), FeatureSpread.create(0), 2),
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
                    new DarkOakFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0)),
                    new GiantTrunkPlacer(13, 2, 14),
                    new TwoLayerFeature(1, 1, 2))).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PARANA_PINE_TREE_YOUNG = register("young_parana_pine_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.PARANA_PINE_LOG),
                    new SimpleBlockStateProvider(States.PARANA_PINE_LEAVES),
                    new MegaPineFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), FeatureSpread.create(13, 4)),
                    new StraightTrunkPlacer(6, 2, 14),
                    new TwoLayerFeature(1, 1, 2))).build()));

    //Imbuia Trees
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> IMBUIA_TREE = register("imbuia_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.YERBA_MATE_LOG),
                    new SimpleBlockStateProvider(States.IMBUIA_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> IMBUIA_FANCY_TREE = register("imbuia_fancy_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(TreeFeatures.States.IMBUIA_LOG),
                    new SimpleBlockStateProvider(States.IMBUIA_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new DarkOakTrunkPlacer(6, 2, 1),
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
                    new TwoLayerFeature(1, 0, 1))).build()));

    public static final class States {

        protected static final BlockState KAPOK_LOG = AmazonRainforestBlocks.KAPOK_LOG.get().getDefaultState();
        protected static final BlockState KAPOK_LEAVES = AmazonRainforestBlocks.KAPOK_LEAVES.get().getDefaultState();

        protected static final BlockState CASHEW_LOG = RestingaBlocks.CASHEW_LOG.get().getDefaultState();
        protected static final BlockState CASHEW_LEAVES = RestingaBlocks.CASHEW_LEAVES.get().getDefaultState();

        protected static final BlockState YERBA_MATE_LOG = AraucariaPlateauBlocks.YERBA_MATE_LOG.get().getDefaultState();
        protected static final BlockState YERBA_MATE_LEAVES = AraucariaPlateauBlocks.YERBA_MATE_LEAVES.get().getDefaultState();

        protected static final BlockState FEIJOA_LOG = AraucariaPlateauBlocks.FEIJOA_LOG.get().getDefaultState();
        protected static final BlockState FEIJOA_LEAVES = AraucariaPlateauBlocks.FEIJOA_LEAVES.get().getDefaultState();

        protected static final BlockState BLACK_JUREMA_LOG = CaatingaBlocks.BLACK_JUREMA_LOG.get().getDefaultState();
        protected static final BlockState BLACK_JUREMA_LEAVES = CaatingaBlocks.BLACK_JUREMA_LEAVES.get().getDefaultState();

        protected static final BlockState IPE_LOG = AtlanticForestBlocks.IPE_LOG.get().getDefaultState();
        protected static final BlockState YELLOW_IPE_BLOSSOM = AtlanticForestBlocks.YELLOW_IPE_BLOSSOM.get().getDefaultState();
        protected static final BlockState PURPLE_IPE_BLOSSOM = AtlanticForestBlocks.PURPLE_IPE_BLOSSOM.get().getDefaultState();
        protected static final BlockState PINK_IPE_BLOSSOM = AtlanticForestBlocks.PINK_IPE_BLOSSOM.get().getDefaultState();
        protected static final BlockState WHITE_IPE_BLOSSOM = AtlanticForestBlocks.WHITE_IPE_BLOSSOM.get().getDefaultState();

        protected static final BlockState CAMBUCI_LOG = AtlanticForestBlocks.CAMBUCI_LOG.get().getDefaultState();
        protected static final BlockState CAMBUCI_LEAVES = AtlanticForestBlocks.CAMBUCI_LEAVES.get().getDefaultState();

        protected static final BlockState SCHINUS_LOG = PampasPlainsBlocks.SCHINUS_LOG.get().getDefaultState();
        protected static final BlockState BRAZILLIAN_PEPPER_LEAVES = PampasPlainsBlocks.BRAZILLIAN_PEPPER_LEAVES.get().getDefaultState();
        protected static final BlockState PERUVIAN_PEPPER_LEAVES = PampasPlainsBlocks.PERUVIAN_PEPPER_LEAVES.get().getDefaultState();

        protected static final BlockState WOLF_APPLE_LOG = CerradoSavannaBlocks.WOLF_APPLE_LOG.get().getDefaultState();
        protected static final BlockState WOLF_APPLE_LEAVES = CerradoSavannaBlocks.WOLF_APPLE_LEAVES.get().getDefaultState();

        protected static final BlockState MANGABA_LOG = CaatingaBlocks.MANGABA_LOG.get().getDefaultState();
        protected static final BlockState MANGABA_LEAVES = CaatingaBlocks.MANGABA_LEAVES.get().getDefaultState();

        protected static final BlockState BRAZILNUT_LOG = AmazonRainforestBlocks.BRAZILNUT_LOG.get().getDefaultState();
        protected static final BlockState BRAZILNUT_LEAVES = AmazonRainforestBlocks.BRAZILNUT_LEAVES.get().getDefaultState();

        protected static final BlockState GUARANA_LEAVES = AmazonRainforestBlocks.GUARANA_LEAVES.get().getDefaultState();
        protected static final BlockState CUPUACU_LEAVES = AmazonRainforestBlocks.CUPUACU_LEAVES.get().getDefaultState();
        protected static final BlockState JUNGLE_LOG = Blocks.JUNGLE_LOG.getDefaultState();

        protected static final BlockState BRAZILWOOD_LOG = AtlanticForestBlocks.BRAZILWOOD_LOG.get().getDefaultState();
        protected static final BlockState BRAZILWOOD_LEAVES = AtlanticForestBlocks.BRAZILWOOD_LEAVES.get().getDefaultState();

        protected static final BlockState JUA_LOG = CaatingaBlocks.JUA_LOG.get().getDefaultState();
        protected static final BlockState JUA_LEAVES = CaatingaBlocks.JUA_LEAVES.get().getDefaultState();

        protected static final BlockState BRAZILLIAN_SASSAFRAS_LOG = AraucariaPlateauBlocks.BRAZILLIAN_SASSAFRAS_LOG.get().getDefaultState();
        protected static final BlockState BRAZILLIAN_SASSAFRAS_LEAVES = AraucariaPlateauBlocks.BRAZILLIAN_SASSAFRAS_LEAVES.get().getDefaultState();

        protected static final BlockState UMBU_LOG = CaatingaBlocks.UMBU_LOG.get().getDefaultState();
        protected static final BlockState UMBU_LEAVES = CaatingaBlocks.UMBU_LEAVES.get().getDefaultState();

        protected static final BlockState LOPHANTERA_LOG = AmazonRainforestBlocks.LOPHANTERA_LOG.get().getDefaultState();
        protected static final BlockState LOPHANTERA_LEAVES = AmazonRainforestBlocks.LOPHANTERA_LEAVES.get().getDefaultState();

        protected static final BlockState MANACA_DA_SERRA_LOG = AtlanticForestBlocks.MANACA_DA_SERRA_LOG.get().getDefaultState();
        protected static final BlockState MANACA_DA_SERRA_LEAVES = AtlanticForestBlocks.MANACA_DA_SERRA_LEAVES.get().getDefaultState();

        protected static final BlockState EUGENIA_LOG = AtlanticForestBlocks.EUGENIA_LOG.get().getDefaultState();
        protected static final BlockState PITANGA_LEAVES = AtlanticForestBlocks.PITANGA_LEAVES.get().getDefaultState();
        protected static final BlockState BLACK_PITANGA_LEAVES = AtlanticForestBlocks.BLACK_PITANGA_LEAVES.get().getDefaultState();

        protected static final BlockState SHARINGA_LOG = AmazonRainforestBlocks.SHARINGA_LOG.get().getDefaultState();
        protected static final BlockState SHARINGA_LEAVES = AmazonRainforestBlocks.SHARINGA_LEAVES.get().getDefaultState();

        protected static final BlockState PARANA_PINE_LOG = AraucariaPlateauBlocks.PARANA_PINE_LOG.get().getDefaultState();
        protected static final BlockState PARANA_PINE_LEAVES = AraucariaPlateauBlocks.PARANA_PINE_LEAVES.get().getDefaultState();

        protected static final BlockState IMBUIA_LOG = AraucariaPlateauBlocks.IMBUIA_LOG.get().getDefaultState();
        protected static final BlockState IMBUIA_LEAVES = AraucariaPlateauBlocks.IMBUIA_LEAVES.get().getDefaultState();

        protected static final BlockState CECROPIA_LOG = RestingaBlocks.CECROPIA_LOG.get().getDefaultState();
        protected static final BlockState CECROPIA_LEAVES = RestingaBlocks.CECROPIA_LEAVES.get().getDefaultState();
        protected static final BlockState SILVER_CECROPIA_LEAVES = AtlanticForestBlocks.CECROPIA_SILVER_LEAVES.get().getDefaultState();
    }

    public static final ConfiguredFeature<?, ?> AMAZON_TREES = register("amazon_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(SHARINGA_TREE.withChance(0.2F),
                            CUPUACU_TREE.withChance(0.1F)), KAPOK_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(6, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> BRAZILNUT_TREES = register("brazilnut_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BRAZILNUT_TREE.withChance(0.5F)),
                    BRAZILNUT_FANCY_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> LOPHANTERA_TREES = register("lophantera_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(LOPHANTERA_TREE.withChance(0.5F)),
                    LOPHANTERA_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> MANACA_TREES = register("manaca_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(MANACA_FANCY_TREE.withChance(0.1F)),
                    MANACA_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> BRAZILWOOD_TREES = register("brazilwood_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BRAZILWOOD_TREE.withChance(0.2F)),
                    BRAZILWOOD_FANCY_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(4, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> CASHEW_TREES = register("cashew_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(CASHEW_TREE.withChance(0.5F)),
                    CASHEW_SHRUB)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> TRUMPET_TREES = register("trumpet_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(WHITE_IPE_TREE.withChance(0.025641026F),
                    PINK_IPE_TREE.withChance(0.30769232F), PURPLE_IPE_TREE.withChance(0.33333334F)), YELLOW_IPE_FANCY_TREE))
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                            .configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> PARANA_PINE_TREES = register("parana_pine_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(PARANA_PINE_TREE_YOUNG.withChance(0.1F)),
                    PARANA_PINE_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> OCOTEA_TREES = register("ocotea_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BRAZILLIAN_SASSAFRAS_TREE.withChance(0.2F),
                            IMBUIA_FANCY_TREE.withChance(0.3F)), IMBUIA_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(6, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> MATE_TREES = register("mate_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(YERBA_MATE_FANCY_TREE.withChance(0.1F)),
                    YERBA_MATE_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> CAATINGA_TREES = register("caatinga_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(UMBU_TREE.withChance(0.2F),
                            JUA_TREE.withChance(0.1F)), BLACK_JUREMA_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> PITANGA_TREES = register("pitanga_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BLACK_PITANGA_TREE.withChance(0.02F)),
                    PITANGA_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> FOREST_CECROPIA_TREES = register("cecropia_trees",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(CECROPIA_TREE.withChance(0.2F)),
                    SILVER_CECROPIA_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                    .configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String p_243968_0_, ConfiguredFeature<FC, ?> p_243968_1_) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, p_243968_0_, p_243968_1_);
    }
}


