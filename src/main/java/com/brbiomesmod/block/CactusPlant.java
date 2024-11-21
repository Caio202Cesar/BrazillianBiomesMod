package com.brbiomesmod.block;

import com.brbiomesmod.block.BlockClasses.CaatingaBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.block.SoundType;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class CactusPlant extends BushBlock {
    public CactusPlant() {
        super(Properties.from(Blocks.CHORUS_PLANT).tickRandomly().hardnessAndResistance(0.1f)
                .sound(SoundType.CORAL).harvestTool(ToolType.HOE));
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderLayer() {
        RenderTypeLookup.setRenderLayer(CaatingaBlocks.TURK_TURBAN_CACTUS.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(CaatingaBlocks.TURK_TURBAN_FRUITING_CACTUS.get(), RenderType.getCutout());
    }

    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.matchesBlock(Blocks.COARSE_DIRT) || state.matchesBlock(Blocks.RED_SAND)
                || state.matchesBlock(Blocks.SAND);
    }

    //Plant harmful effects
    @SuppressWarnings("deprecation")
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.attackEntityFrom(DamageSource.CACTUS, 1.0F);
    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 90;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 80;
    }

    @Nullable
    public PathNodeType getAiPathNodeType(BlockState state, IBlockReader world, BlockPos pos, @Nullable MobEntity entity) {
        return PathNodeType.DANGER_CACTUS;
    }

    public PlantType getPlantType(IBlockReader world, BlockPos pos) {
        return PlantType.DESERT;
    }
}

