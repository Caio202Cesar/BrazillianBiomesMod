package com.brbiomesmod.world.biomes.Util;

public class ModBiomeRelationships {
    public static void register() {

        BiomeRelationshipRegistry.register(
                ModBiomes.AMAZON_RAINFOREST,
                ModBiomes.AMAZON_RAINFOREST_EDGE,
                RelationshipType.EDGE,
                7,
                17,
                6,
                false, false);

        BiomeRelationshipRegistry.register(
                ModBiomes.AMAZON_RAINFOREST,
                ModBiomes.AMAZON_VARZEA_FOREST,
                RelationshipType.SUB_BIOME,
                8,
                0,
                6,
                false, false);

        BiomeRelationshipRegistry.register(
                ModBiomes.DUNAS_RESTINGA,
                ModBiomes.RESTINGA_BEACH,
                RelationshipType.BEACH,
                8,
                0,
                6,
                true, false);

        BiomeRelationshipRegistry.register(
                ModBiomes.PAMPAS,
                ModBiomes.PAMPAS_COAST,
                RelationshipType.SUB_BIOME,
                8,
                0,
                6,
                false, false);

        BiomeRelationshipRegistry.register(
                ModBiomes.PAMPAS,
                ModBiomes.COXILHAS,
                RelationshipType.SUB_BIOME,
                8,
                0,
                6,
                false, false);

        BiomeRelationshipRegistry.register(
                ModBiomes.PAMPAS,
                ModBiomes.BUTIA_PAMPAS,
                RelationshipType.SUB_BIOME,
                4,
                0,
                6,
                false, false);

        /*BiomeRelationshipRegistry.registerRiver(
                ModBiomes.AMAZON_RAINFOREST,
                ModBiomes.BLACK_RIVER);

        BiomeRelationshipRegistry.registerRiver(
                ModBiomes.AMAZON_VARZEA_FOREST,
                ModBiomes.AMAZON_SOLIMON_RIVER);*/
    }
}
