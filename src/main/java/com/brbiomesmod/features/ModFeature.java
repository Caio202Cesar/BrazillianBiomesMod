package com.brbiomesmod.features;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.block.BlockClasses.AtlanticForestBlocks;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFeature {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(ForgeRegistries.FEATURES, BrazillianBiomesMod.MOD_ID);

    public static final RegistryObject<Feature<NoFeatureConfig>> PASSION_FRUIT_VINE_FEATURE = FEATURES.register("passion_fruit_vine_feature",
            () -> new PassionFruitVineFeature(NoFeatureConfig.CODEC,
                    () -> AtlanticForestBlocks.PASSION_FRUIT_VINE.get().getDefaultState()));


}
