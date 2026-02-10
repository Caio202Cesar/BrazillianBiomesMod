package com.brbiomesmod.world.biomes;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.features.ModDefaultBiomeFeatures;
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

//The Dunes are a sub-biome of it and features Ipomaea_pes_caprae.
public class DunasRestingaBiome {
    public static final DeferredRegister<Biome> BIOMES
            = DeferredRegister.create(ForgeRegistries.BIOMES, BrazillianBiomesMod.MOD_ID);

    private static ConfiguredSurfaceBuilder<?> DefaultSurfaceBuilder;
    public static final RegistryObject<Biome> DUNAS_RESTINGA = BIOMES.register("dunas_restinga",
            () -> makeDunasRestingaBiome(() -> ModConfiguredSurfaceBuilders.RESTINGA_SURFACE, 0.45F, 0.3F));


    private static Biome makeDunasRestingaBiome(final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilder, float depth, float scale) {
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
        DefaultBiomeFeatures.withPassiveMobs(mobspawninfo$builder);
        DefaultBiomeFeatures.withBatsAndHostiles(mobspawninfo$builder);
        mobspawninfo$builder.withSpawner(EntityClassification.CREATURE,
                new MobSpawnInfo.Spawners(EntityType.PARROT, 100, 7, 10));
        mobspawninfo$builder.withSpawner(EntityClassification.CREATURE,
                new MobSpawnInfo.Spawners(EntityType.OCELOT, 100, 7, 10));

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
        DefaultBiomeFeatures.withTallGrass(biomegenerationsettings$builder);
        ModDefaultBiomeFeatures.withRestingaTrumpetTrees(biomegenerationsettings$builder);
        ModDefaultBiomeFeatures.withRestingaTrees(biomegenerationsettings$builder);
        ModDefaultBiomeFeatures.withPitangaTrees(biomegenerationsettings$builder);
        ModDefaultBiomeFeatures.withXananaFlower(biomegenerationsettings$builder);
        ModDefaultBiomeFeatures.withBeachPepperTrees(biomegenerationsettings$builder);

        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.LAKES, Features.LAKE_LAVA);


        return (new Biome.Builder()).precipitation(Biome.RainType.NONE).category(Biome.Category.BEACH).depth(depth).scale(scale)
                .temperature(1.2F).downfall(0.7F).setEffects((new BiomeAmbience.Builder()).setWaterColor(4757429)
                        .setWaterFogColor(4765085).withSkyColor(4169700).withFoliageColor(4110351)
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

