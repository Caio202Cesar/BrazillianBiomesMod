package com.brbiomesmod.block.Custom.Plants;

import com.brbiomesmod.block.PlantsGroup;
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
        RenderTypeLookup.setRenderLayer(PlantsGroup.TILLANDSIA_STRICTA.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(PlantsGroup.SMALL_XAXIM_PLANT.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(PlantsGroup.SILVER_VASE_BROMELIAD.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(PlantsGroup.POTTED_SILVER_VASE_BROMELIAD.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(PlantsGroup.FIREBALL_NEOREGELIA.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(PlantsGroup.POTTED_FIREBALL_NEOREGELIA.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(PlantsGroup.AECHMEA_ALBA.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(PlantsGroup.POTTED_AECHMEA_ALBA.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(PlantsGroup.NEOREGELIA_MARMORATA.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(PlantsGroup.POTTED_NEOREGELIA_MARMORATA.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(PlantsGroup.RED_GUZMANIA.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(PlantsGroup.POTTED_RED_GUZMANIA.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(PlantsGroup.YELLOW_GUZMANIA.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(PlantsGroup.POTTED_YELLOW_GUZMANIA.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(PlantsGroup.PINK_GUZMANIA.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(PlantsGroup.POTTED_PINK_GUZMANIA.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(PlantsGroup.ORANGE_GUZMANIA.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(PlantsGroup.POTTED_ORANGE_GUZMANIA.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(PlantsGroup.AMAZONIAN_ZEBRA_PLANT.get(), RenderType.getCutout());

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
