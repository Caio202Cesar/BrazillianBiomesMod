package com.brbiomesmod.block;

import com.brbiomesmod.block.BlockClasses.CaatingaBlocks;
import com.brbiomesmod.block.BlockClasses.RestingaBlocks;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.potion.Effects;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.ToolType;

public class XananaFlower extends FlowerBlock {
    public XananaFlower() {
        super(Effects.WATER_BREATHING, 6, AbstractBlock.Properties.from(Blocks.CORNFLOWER));
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderLayer() {
        RenderTypeLookup.setRenderLayer(RestingaBlocks.XANANA.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RestingaBlocks.XANANA_BIG.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RestingaBlocks.POTTED_XANANA.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RestingaBlocks.POTTED_BIG_XANANA.get(), RenderType.getCutout());
    }

    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.matchesBlock(Blocks.GRASS_BLOCK) || state.matchesBlock(Blocks.DIRT)
                || state.matchesBlock(Blocks.COARSE_DIRT) || state.matchesBlock(Blocks.SAND);
    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 80;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 60;
    }

    public PlantType getPlantType(IBlockReader world, BlockPos pos) {
        return PlantType.BEACH;
    }
}

