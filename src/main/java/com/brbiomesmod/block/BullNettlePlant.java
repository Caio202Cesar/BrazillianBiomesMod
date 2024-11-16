package com.brbiomesmod.block;

import com.brbiomesmod.block.BlockClasses.CaatingaBlocks;
import net.minecraft.block.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class BullNettlePlant extends BushBlock {
    public BullNettlePlant() {
        super(FlowerBlock.Properties.from(Blocks.WITHER_ROSE).tickRandomly().doesNotBlockMovement().notSolid()
                .zeroHardnessAndResistance().sound(SoundType.PLANT).harvestTool(ToolType.HOE));
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderLayer() {
        RenderTypeLookup.setRenderLayer(CaatingaBlocks.CNIDOSCOLUS_URENS.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(CaatingaBlocks.CNIDOSCOLUS_URENS_FRUITING.get(), RenderType.getCutout());
    }

    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.matchesBlock(Blocks.GRASS_BLOCK) || state.matchesBlock(Blocks.DIRT)
                || state.matchesBlock(Blocks.COARSE_DIRT) || state.matchesBlock(Blocks.PODZOL)
                || state.matchesBlock(Blocks.FARMLAND) || state.matchesBlock(Blocks.RED_SAND)
                || state.matchesBlock(Blocks.SAND);
    }

    //Plant harmful effects
    @SuppressWarnings("deprecation")
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.attackEntityFrom(DamageSource.CACTUS, 3.0F);
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

