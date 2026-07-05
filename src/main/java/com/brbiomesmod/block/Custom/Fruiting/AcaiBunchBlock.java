package com.brbiomesmod.block.Custom.Fruiting;


import com.brbiomesmod.block.TreesGroup;
import net.minecraft.block.*;
import net.minecraft.block.material.PushReaction;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class AcaiBunchBlock extends Block {
    public AcaiBunchBlock() {
        super(AbstractBlock.Properties.from(Blocks.BEEHIVE).zeroHardnessAndResistance().tickRandomly()
                .sound(SoundType.WET_GRASS).notSolid().doesNotBlockMovement().harvestTool(ToolType.HOE));
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderLayer() {
        RenderTypeLookup.setRenderLayer(TreesGroup.ACAI_BUNCH.get(), RenderType.getCutout());

    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos) {
        BlockState above = world.getBlockState(pos.up());

        return above.getBlock() == TreesGroup.ACAI_LEAVES.get()
                || above.getBlock() == TreesGroup.JUSSARA_LEAVES.get();
    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 50;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 10;
    }

    public PushReaction getPushReaction(BlockState state) {
        return PushReaction.DESTROY;
    }
}
