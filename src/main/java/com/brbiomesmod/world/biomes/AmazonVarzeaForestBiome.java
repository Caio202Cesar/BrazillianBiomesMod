package com.brbiomesmod.world.biomes;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.features.ModDefaultBiomeFeatures;
import com.brbiomesmod.features.TreeFeatures;
import com.brbiomesmod.world.biomes.Util.ModConfiguredSurfaceBuilders;
import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class AmazonVarzeaForestBiome {
public static final DeferredRegister<Biome> BIOMES
        = DeferredRegister.create(ForgeRegistries.BIOMES, BrazillianBiomesMod.MOD_ID);

private static ConfiguredSurfaceBuilder<?> DefaultSurfaceBuilder;
public static final RegistryObject<Biome> AMAZON_VARZEA_FOREST = BIOMES.register("amazon_varzea_forest",
        () -> makeAmazonRainforestBiome(() -> ConfiguredSurfaceBuilders.SWAMP, -0.1f, 0.120f));

//Varzea trees: kapok, sandbox tree, andiroba and buriti
private static Biome makeAmazonRainforestBiome(final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilder, float depth, float scale) {
    MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
    DefaultBiomeFeatures.withPassiveMobs(mobspawninfo$builder);
    DefaultBiomeFeatures.withBatsAndHostiles(mobspawninfo$builder);
    mobspawninfo$builder.withSpawner(EntityClassification.CREATURE,
            new MobSpawnInfo.Spawners(EntityType.BAT, 70, 2, 10));
    mobspawninfo$builder.withSpawner(EntityClassification.CREATURE,
            new MobSpawnInfo.Spawners(EntityType.PARROT, 100, 7, 10));
    mobspawninfo$builder.withSpawner(EntityClassification.CREATURE,
            new MobSpawnInfo.Spawners(EntityType.OCELOT, 100, 7, 10));
    mobspawninfo$builder.withSpawner(EntityClassification.MONSTER,
            new MobSpawnInfo.Spawners(EntityType.SLIME, 100, 7, 10));

    BiomeGenerationSettings.Builder biomegenerationsettings$builder =
            (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(surfaceBuilder);

    biomegenerationsettings$builder.withStructure(StructureFeatures.MINESHAFT);
    biomegenerationsettings$builder.withStructure(StructureFeatures.RUINED_PORTAL_JUNGLE);
    biomegenerationsettings$builder.withStructure(StructureFeatures.BURIED_TREASURE);
    biomegenerationsettings$builder.withStructure(StructureFeatures.PILLAGER_OUTPOST);
    biomegenerationsettings$builder.withStructure(StructureFeatures.JUNGLE_PYRAMID);

    DefaultBiomeFeatures.withCavesAndCanyons(biomegenerationsettings$builder);
    DefaultBiomeFeatures.withMonsterRoom(biomegenerationsettings$builder);
    DefaultBiomeFeatures.withCommonOverworldBlocks(biomegenerationsettings$builder);
    DefaultBiomeFeatures.withOverworldOres(biomegenerationsettings$builder);
    DefaultBiomeFeatures.withClayDisks(biomegenerationsettings$builder);
    DefaultBiomeFeatures.withStrongholdAndMineshaft(biomegenerationsettings$builder);
    DefaultBiomeFeatures.withFossils(biomegenerationsettings$builder);
    DefaultBiomeFeatures.withSavannaGrass(biomegenerationsettings$builder);
    DefaultBiomeFeatures.withNoiseTallGrass(biomegenerationsettings$builder);
    ModDefaultBiomeFeatures.withCassavaPlants(biomegenerationsettings$builder);
    ModDefaultBiomeFeatures.withAmazonVarzeaTrees(biomegenerationsettings$builder);
    ModDefaultBiomeFeatures.withWetlandSeaGrass(biomegenerationsettings$builder);

    biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeatures.VARZEA_PALMS);
    biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.LAKES, Features.LAKE_LAVA);

    return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).category(Biome.Category.JUNGLE).depth(depth).scale(scale)
            .temperature(1.2F).downfall(1.0F).setEffects((new BiomeAmbience.Builder()).setWaterColor(10787684)
                    .setWaterFogColor(10787684).withSkyColor(4169700).withFoliageColor(3830303)
                    .withGrassColor(6604607).setFogColor(14807295)
                    .setAmbientSound(SoundEvents.MUSIC_CREATIVE)
                    .setMusic(BackgroundMusicTracks.getDefaultBackgroundMusicSelector(SoundEvents.MUSIC_CREATIVE))
                    .build())
            .withMobSpawnSettings(mobspawninfo$builder.build()).withGenerationSettings(biomegenerationsettings$builder.build()).build();
}

public static void register(IEventBus eventBus) {
    BIOMES.register(eventBus);
}
}
