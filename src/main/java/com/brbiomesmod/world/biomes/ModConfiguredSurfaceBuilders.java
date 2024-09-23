package com.brbiomesmod.world.biomes;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.block.CaatingaBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ModConfiguredSurfaceBuilders {

    public static ConfiguredSurfaceBuilder<?> CAATINGA_SURFACE = register("caatinga_surface", SurfaceBuilder.DEFAULT.configured(new SurfaceBuilderConfig(
            CaatingaBlocks.CAATINGA_SAND.get().defaultBlockState(), //top material
            Blocks.COARSE_DIRT.getBlock().defaultBlockState(), //under material
            Blocks.COARSE_DIRT.getBlock().defaultBlockState() //underwater material
    )));

    private static <SC extends ISurfaceBuilderConfig>ConfiguredSurfaceBuilder<SC> register(String name, ConfiguredSurfaceBuilder<SC> csb) {

        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER,
                new ResourceLocation(BrazillianBiomesMod.MOD_ID, name), csb);
    }
}
