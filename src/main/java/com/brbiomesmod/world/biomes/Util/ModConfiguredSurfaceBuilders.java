package com.brbiomesmod.world.biomes.Util;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.block.BlockClasses.CaatingaBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ModConfiguredSurfaceBuilders {

    public static ConfiguredSurfaceBuilder<?> CAATINGA_SURFACE = register("caatinga_surface",
            SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(
            Blocks.COARSE_DIRT.getBlock().getDefaultState(), //top material
            Blocks.STONE.getBlock().getDefaultState(), //under material
            CaatingaBlocks.CAATINGA_SAND.get().getDefaultState() //underwater material
    )));

    public static ConfiguredSurfaceBuilder<?> FOREST_SURFACE = register("forest_surface",
            SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(
                    Blocks.PODZOL.getBlock().getDefaultState(), //top material
                    Blocks.STONE.getBlock().getDefaultState(), //under material
                    Blocks.GRAVEL.getBlock().getDefaultState() //underwater material
            )));

    private static <SC extends ISurfaceBuilderConfig>ConfiguredSurfaceBuilder<SC> register(String name, ConfiguredSurfaceBuilder<SC> csb) {

        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER,
                new ResourceLocation(BrazillianBiomesMod.MOD_ID, name), csb);
    }
}
