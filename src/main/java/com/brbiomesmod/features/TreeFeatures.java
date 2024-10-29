package com.brbiomesmod.features;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.block.BlockClasses.*;
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
                    new StraightTrunkPlacer(4, 2, 0),
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
                    new DarkOakFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0)),
                    new DarkOakTrunkPlacer(3, 4, 0), new TwoLayerFeature(0, 0, 0,
                    OptionalInt.of(4)))).setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));

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

    public TreeFeatures(Codec<CustomTreeFeatureConfig> configCodec) {

    }

    public abstract boolean place(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config);


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
    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String p_243968_0_, ConfiguredFeature<FC, ?> p_243968_1_) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, p_243968_0_, p_243968_1_);
    }

}


