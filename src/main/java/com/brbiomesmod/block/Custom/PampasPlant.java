package com.brbiomesmod.block.Custom;

import com.brbiomesmod.block.PlantsGroup;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.block.SoundType;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.ToolType;

public class PampasPlant extends BushBlock {
    public PampasPlant() {
        super(Properties.from(Blocks.DANDELION).tickRandomly().doesNotBlockMovement().notSolid()
                .zeroHardnessAndResistance().sound(SoundType.PLANT).harvestTool(ToolType.HOE));
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderLayer() {
        RenderTypeLookup.setRenderLayer(PlantsGroup.MACELA.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(PlantsGroup.ASPILIA_MONTEVIDENSIS.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(PlantsGroup.MANDEVILLA_COCCINEA.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(PlantsGroup.VELAME_OF_RIO_GRANDE.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(PlantsGroup.POTTED_MACELA.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(PlantsGroup.POTTED_ASPILIA_MONTEVIDENSIS.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(PlantsGroup.POTTED_MANDEVILLA_COCCINEA.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(PlantsGroup.POTTED_VELAME_OF_RIO_GRANDE.get(), RenderType.getCutout());

    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 80;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 60;
    }

    public PlantType getPlantType(IBlockReader world, BlockPos pos) {
        return PlantType.PLAINS;
    }
}
