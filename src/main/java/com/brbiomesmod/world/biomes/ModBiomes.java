package com.brbiomesmod.world.biomes;

import com.brbiomesmod.BrazillianBiomesMod;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBiomes {

    private static int calculateSkyColor(float p_244206_0_) {
        float lvt_1_1_ = p_244206_0_ / 3.0F;
        lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
    }

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES,
            BrazillianBiomesMod.MOD_ID);

    public static final RegistryObject<Biome> CAATINGA_BIOME = BIOMES.register("caatinga_biome",
            () -> makeCaatingaBiome(() -> ModConfiguredSurfaceBuilders.CAATINGA_SURFACE, 0.125F, 0.05F));

    private static Biome makeCaatingaBiome(final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilder, float depth, float scale) {
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
        DefaultBiomeFeatures.farmAnimals(mobspawninfo$builder);
        DefaultBiomeFeatures.commonSpawns(mobspawninfo$builder);
        DefaultBiomeFeatures.desertSpawns(mobspawninfo$builder);
        mobspawninfo$builder.addSpawn(EntityClassification.MONSTER,
                new MobSpawnInfo.Spawners(EntityType.HUSK, 100, 5, 10));
        mobspawninfo$builder.addSpawn(EntityClassification.MONSTER,
                new MobSpawnInfo.Spawners(EntityType.HOGLIN, 78, 3, 7));
        mobspawninfo$builder.addSpawn(EntityClassification.MONSTER,
                new MobSpawnInfo.Spawners(EntityType.SKELETON_HORSE, 60, 1, 5));
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                (new BiomeGenerationSettings.Builder()).surfaceBuilder(surfaceBuilder);

        DefaultBiomeFeatures.addDefaultLakes(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addInfestedStone(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDesertExtraVegetation(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultCarvers(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultOres(biomegenerationsettings$builder);

        biomegenerationsettings$builder.addFeature(GenerationStage.Decoration.LAKES, Features.PATCH_SUGAR_CANE_BADLANDS);

        return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.DESERT).depth(depth).scale(scale)
                .temperature(1.5F).downfall(0.0F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204)
                        .waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(1.3F))
                        .ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build())
                .generationSettings(biomegenerationsettings$builder.build()).build();

    }

    public static void register(IEventBus eventBus) {
        BIOMES.register(eventBus);
    }

    //Araucaria Plateau
    static {
        createBiome("araucaria_plateau", BiomeMaker::theVoidBiome);
    }

    public static RegistryKey<Biome> ARAUCARIA_PLATEAU = registerBiome("araucaria_plateau");

    public static RegistryKey<Biome> registerBiome(String biomeName) {
        return RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(BrazillianBiomesMod.MOD_ID, biomeName));
    }

    public static RegistryObject<Biome> createBiome(String biomeName, Supplier<Biome> biome) {
        return BIOMES.register(biomeName, biome);
    }

    public static void registerBiomes() {
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(ARAUCARIA_PLATEAU,12));
    }

    public static void registerBiome() {
    }
}
