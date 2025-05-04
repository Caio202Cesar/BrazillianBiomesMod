package com.brbiomesmod.block;

import com.brbiomesmod.block.BlockClasses.AmazonRainforestBlocks;
import com.brbiomesmod.block.BlockClasses.AraucariaPlateauBlocks;
import com.brbiomesmod.block.BlockClasses.AtlanticForestBlocks;
import net.minecraft.block.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.ToolType;

public class EpiphytePlant extends BushBlock {
    public EpiphytePlant() {
        super(AbstractBlock.Properties.from(Blocks.CORNFLOWER).tickRandomly().zeroHardnessAndResistance()
                .sound(SoundType.PLANT).doesNotBlockMovement().notSolid().harvestTool(ToolType.HOE));
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderLayer() {
        RenderTypeLookup.setRenderLayer(AtlanticForestBlocks.TILLANDSIA_STRICTA.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AraucariaPlateauBlocks.SMALL_XAXIM_PLANT.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(AtlanticForestBlocks.SILVER_VASE_BROMELIAD.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AtlanticForestBlocks.POTTED_SILVER_VASE_BROMELIAD.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(AtlanticForestBlocks.FIREBALL_NEOREGELIA.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AtlanticForestBlocks.POTTED_FIREBALL_NEOREGELIA.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(AtlanticForestBlocks.AECHMEA_ALBA.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AtlanticForestBlocks.POTTED_AECHMEA_ALBA.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(AtlanticForestBlocks.NEOREGELIA_MARMORATA.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AtlanticForestBlocks.POTTED_NEOREGELIA_MARMORATA.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(AtlanticForestBlocks.RED_GUZMANIA.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AtlanticForestBlocks.POTTED_RED_GUZMANIA.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(AtlanticForestBlocks.YELLOW_GUZMANIA.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AtlanticForestBlocks.POTTED_YELLOW_GUZMANIA.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(AtlanticForestBlocks.PINK_GUZMANIA.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AtlanticForestBlocks.POTTED_PINK_GUZMANIA.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(AtlanticForestBlocks.ORANGE_GUZMANIA.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AtlanticForestBlocks.POTTED_ORANGE_GUZMANIA.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(AmazonRainforestBlocks.AMAZONIAN_ZEBRA_PLANT.get(), RenderType.getCutout());

    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 80;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 60;
    }

    public PlantType getPlantType(IBlockReader world, BlockPos pos) {
        return PlantType.CAVE;
    }
}
