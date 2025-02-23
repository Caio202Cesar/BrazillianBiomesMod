package com.brbiomesmod.block;

import com.brbiomesmod.block.BlockClasses.AmazonRainforestBlocks;
import com.brbiomesmod.block.BlockClasses.AtlanticForestBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.ToolType;

public class AngelTrumpetPlant extends DoublePlantBlock {
    public AngelTrumpetPlant() {
        super(Properties.create(Material.TALL_PLANTS).tickRandomly().doesNotBlockMovement().notSolid()
                .zeroHardnessAndResistance().sound(SoundType.PLANT).harvestTool(ToolType.HOE));
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderLayer() {
        RenderTypeLookup.setRenderLayer(AtlanticForestBlocks.WHITE_ANGEL_TRUMPET.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AtlanticForestBlocks.YELLOW_ANGEL_TRUMPET.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AtlanticForestBlocks.PINK_ANGEL_TRUMPET.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AtlanticForestBlocks.SALMON_ANGEL_TRUMPET.get(), RenderType.getCutout());
    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 80;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 60;
    }

    public PlantType getPlantType(IBlockReader world, BlockPos pos) {
        return PlantType.CROP;
    }
}
