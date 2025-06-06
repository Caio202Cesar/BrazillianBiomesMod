package com.brbiomesmod.world.biomes;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.features.ModDefaultBiomeFeatures;
import com.brbiomesmod.world.biomes.Util.ModConfiguredSurfaceBuilders;
import com.brbiomesmod.world.gen.ModOreGeneration;
import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class CaatingaBiome {
public static final DeferredRegister<Biome> BIOMES
        = DeferredRegister.create(ForgeRegistries.BIOMES, BrazillianBiomesMod.MOD_ID);

private static ConfiguredSurfaceBuilder<?> DefaultSurfaceBuilder;
public static final RegistryObject<Biome> CAATINGA = BIOMES.register("caatinga_shrubland",
        () -> makeCaatingaBiome(() -> ModConfiguredSurfaceBuilders.CAATINGA_SURFACE, 0.1f, 0.4f));


private static Biome makeCaatingaBiome(final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilder, float depth, float scale) {
    MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
    DefaultBiomeFeatures.withPassiveMobs(mobspawninfo$builder);
    DefaultBiomeFeatures.withBatsAndHostiles(mobspawninfo$builder);
    mobspawninfo$builder.withSpawner(EntityClassification.MONSTER,
            new MobSpawnInfo.Spawners(EntityType.HUSK, 100, 7, 10));
    mobspawninfo$builder.withSpawner(EntityClassification.CREATURE,
            new MobSpawnInfo.Spawners(EntityType.MULE, 100, 7, 10));
    mobspawninfo$builder.withSpawner(EntityClassification.CREATURE,
            new MobSpawnInfo.Spawners(EntityType.DONKEY, 100, 7, 10));
    BiomeGenerationSettings.Builder biomegenerationsettings$builder =
            (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(surfaceBuilder);

    biomegenerationsettings$builder.withStructure(StructureFeatures.MINESHAFT);
    biomegenerationsettings$builder.withStructure(StructureFeatures.RUINED_PORTAL_DESERT);
    biomegenerationsettings$builder.withStructure(StructureFeatures.BURIED_TREASURE);
    biomegenerationsettings$builder.withStructure(StructureFeatures.PILLAGER_OUTPOST);
    biomegenerationsettings$builder.withStructure(StructureFeatures.VILLAGE_SAVANNA);

    DefaultBiomeFeatures.withCavesAndCanyons(biomegenerationsettings$builder);
    DefaultBiomeFeatures.withMonsterRoom(biomegenerationsettings$builder);
    DefaultBiomeFeatures.withCommonOverworldBlocks(biomegenerationsettings$builder);
    DefaultBiomeFeatures.withOverworldOres(biomegenerationsettings$builder);
    DefaultBiomeFeatures.withClayDisks(biomegenerationsettings$builder);
    DefaultBiomeFeatures.withStrongholdAndMineshaft(biomegenerationsettings$builder);
    DefaultBiomeFeatures.withFossils(biomegenerationsettings$builder);
    DefaultBiomeFeatures.withDesertWells(biomegenerationsettings$builder);
    ModDefaultBiomeFeatures.withCaatingaTrees(biomegenerationsettings$builder);
    ModDefaultBiomeFeatures.withBullNettles(biomegenerationsettings$builder);
    DefaultBiomeFeatures.withDesertDeadBushes(biomegenerationsettings$builder);
    DefaultBiomeFeatures.withDisks(biomegenerationsettings$builder);
    ModDefaultBiomeFeatures.withTurkTurbanCactus(biomegenerationsettings$builder);
    ModDefaultBiomeFeatures.withScrubPinkPeeperTrees(biomegenerationsettings$builder);

    biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.LAKES, Features.LAKE_LAVA);


    return (new Biome.Builder()).precipitation(Biome.RainType.NONE).category(Biome.Category.DESERT).depth(depth).scale(scale)
            .temperature(2.0F).downfall(0.0F).setEffects((new BiomeAmbience.Builder()).setWaterColor(993300)
                    .setWaterFogColor(993300).withSkyColor(8569325).withFoliageColor(7441937)
                    .withGrassColor(142107676).setFogColor(14807295)
                    .setAmbientSound(SoundEvents.MUSIC_CREATIVE)
                    .setMusic(BackgroundMusicTracks.getDefaultBackgroundMusicSelector(SoundEvents.MUSIC_CREATIVE))
                    .build())
            .withMobSpawnSettings(mobspawninfo$builder.build()).withGenerationSettings(biomegenerationsettings$builder.build()).build();
}

public static void register(IEventBus eventBus) {
    BIOMES.register(eventBus);
}
}
