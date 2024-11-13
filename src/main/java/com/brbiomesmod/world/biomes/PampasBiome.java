package com.brbiomesmod.world.biomes;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.features.ModDefaultBiomeFeatures;
import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

import static net.minecraft.world.biome.BiomeMaker.makePlainsBiome;

public class PampasBiome {
    public static final DeferredRegister<Biome> BIOMES
            = DeferredRegister.create(ForgeRegistries.BIOMES, BrazillianBiomesMod.MOD_ID);

    private static ConfiguredSurfaceBuilder<?> DefaultSurfaceBuilder;
    public static final RegistryObject<Biome> PAMPAS = BIOMES.register("pampas",
            () -> makePlainsBiome(() -> ConfiguredSurfaceBuilders.GRASS, 0.1f, 0.126f));


    private static Biome makePlainsBiome(final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilder, float depth, float scale) {
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
        DefaultBiomeFeatures.withPassiveMobs(mobspawninfo$builder);
        DefaultBiomeFeatures.withBatsAndHostiles(mobspawninfo$builder);
        mobspawninfo$builder.withSpawner(EntityClassification.MONSTER,
                new MobSpawnInfo.Spawners(EntityType.HOGLIN, 70, 7, 10));
        mobspawninfo$builder.withSpawner(EntityClassification.CREATURE,
                new MobSpawnInfo.Spawners(EntityType.OCELOT, 100, 7, 10));

        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(surfaceBuilder);

        biomegenerationsettings$builder.withStructure(StructureFeatures.MINESHAFT);
        biomegenerationsettings$builder.withStructure(StructureFeatures.RUINED_PORTAL);
        biomegenerationsettings$builder.withStructure(StructureFeatures.BURIED_TREASURE);
        biomegenerationsettings$builder.withStructure(StructureFeatures.PILLAGER_OUTPOST);

        DefaultBiomeFeatures.withCavesAndCanyons(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withMonsterRoom(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withCommonOverworldBlocks(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withOverworldOres(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withNoiseTallGrass(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withClayDisks(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withStrongholdAndMineshaft(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withFossils(biomegenerationsettings$builder);
        ModDefaultBiomeFeatures.withPinkPeeperTrees(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withTallGrass(biomegenerationsettings$builder);

        return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).category(Biome.Category.PLAINS).depth(depth).scale(scale)
                .temperature(0.8F).downfall(0.4F).setEffects((new BiomeAmbience.Builder()).setWaterColor(4159204)
                        .setWaterFogColor(4765085).withSkyColor(7907327).withFoliageColor(7842607)
                        .withGrassColor(9551193).setFogColor(14807295)
                        .setAmbientSound(SoundEvents.MUSIC_CREATIVE)
                        .setMusic(BackgroundMusicTracks.getDefaultBackgroundMusicSelector(SoundEvents.MUSIC_CREATIVE))
                        .build())
                .withMobSpawnSettings(mobspawninfo$builder.build()).withGenerationSettings(biomegenerationsettings$builder.build()).build();
    }

    public static void register(IEventBus eventBus) {
        BIOMES.register(eventBus);
    }
}
