package com.brbiomesmod.features;

import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;

public class ModDefaultBiomeFeatures extends DefaultBiomeFeatures {
    public static void withAmazonTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeatures.AMAZON_TREES);
    }
    public static void withAmazonVarzeaTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeatures.VARZEA_TREES);
    }
    public static void withCerradoPalms(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeatures.CERRADO_PALM_TREES);
    }
    public static void withPampasPalms(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeatures.PAMPAS_PALMS);
    }
    public static void withGuaranaShrubs(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeatures.GUARANA_SHRUB);
    }
    public static void withDutchmanVineTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeatures.ATLANTIC_FOREST_TREE_WITH_DUTCHMAN_VINE);
    }
    public static void withAtlanticForestPalms(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeatures.ATLANTIC_FOREST_PALMS);
    }
    public static void withRestingaTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeatures.RESTINGA_TREES);
    }
    public static void withBeachPepperTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeatures.BEACH_PEPPER_TREES);
    }
    public static void withForestTrumpetTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeatures.FOREST_TRUMPET_TREES);
    }
    public static void withRestingaTrumpetTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeatures.RESTINGA_TRUMPET_TREES);
    }
    public static void withSavannaTrumpetTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeatures.SAVANNA_TRUMPET_TREES);
    }
    public static void withCambuciTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeatures.CAMBUCI_TREES);
    }
    public static void withParanaPineTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeatures.PARANA_PINE_TREES);
    }
    public static void withYerbaMateTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeatures.MATE_TREES);
    }
    public static void withOcoteaTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeatures.OCOTEA_TREES);
    }
    public static void withXaximPlant(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.PATCH_XAXIM_PLANT);
    }
    public static void withAmazonianPlants(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.AMAZONIAN_PLANTS);
    }
    public static void withVeloziaPlant(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.PATCH_VELOZIA_PLANT);
    }
    public static void withPampasGrass(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.PATCH_PAMPAS_GRASS);
    }
    public static void withAraucariaPlateauMyrtaceae(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeatures.ARAUCARIA_PLATEAU_MYRTACEAE);
    }
    public static void withCaatingaTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeatures.CAATINGA_TREES);
    }
    public static void withBullNettles(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.BULL_NETTLES);
    }
    public static void withPitangaTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeatures.PITANGA_TREES);
    }
    public static void withPampasPitangaTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeatures.PAMPAS_PITANGA_TREES);
    }
    public static void withPampasFlowers(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.PAMPAS_PLAINS_FLOWER_PATCH);
    }
    public static void withAraucariaForestFlowers(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.ARAUCARIA_FOREST_FLOWERS);
    }
    public static void withAtlanticForestUpperTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeatures.ATLANTIC_FOREST_UPPER_TREES);
    }
    public static void withPinkPeeperTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeatures.PINK_PEEPER_TREES);
    }
    public static void withScrubPinkPeeperTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeatures.SCRUB_PINK_PEEPER_TREES);
    }
    public static void withCassavaPlants(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.PATCH_CASSAVA_PLANT);
    }
    public static void withAtlanticForestFlowers(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.ATLANTIC_FOREST_FLOWERS);
    }
    public static void withAngelTrumpetBushes(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.ANGEL_TRUMPET_BUSHES);
    }
    public static void withCerradoFruitTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeatures.CERRADO_FRUIT_TREES);
    }
    public static void withPassionvineAtlanticForestTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeatures.ATLANTIC_FOREST_TREES_WITH_PASSIONVINE);
    }
    public static void withIpomaeaPesCaprae(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.IPOMAEA_PES_CAPRAE_PATCH);
    }
    public static void withPampasTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeatures.PAMPAS_TREES);
    }
    public static void withXananaFlower(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.XANANA_PATCH);
    }
    public static void withTurkTurbanCactus(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.TURK_TURBAN_CACTUS);
    }
    public static void withCerradoTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeatures.CERRADO_TREES);
    }
    public static void withWetlandSeaGrass(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.SEAGRASS_SWAMP);
    }
}
