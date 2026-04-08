package com.brbiomesmod.block.Custom.Vines;

import com.brbiomesmod.block.PlantsGroup;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class AristolochiaVine extends VineBlock {
    public AristolochiaVine() {
        super(AbstractBlock.Properties.from(Blocks.VINE).tickRandomly().zeroHardnessAndResistance()
                .sound(SoundType.PLANT).doesNotBlockMovement().notSolid().harvestTool(ToolType.HOE));
    }

    public boolean ticksRandomly(BlockState state) {
        return true;
    }

    /**
     * Performs a random tick on a block.
     *
     * @param state
     * @param worldIn
     * @param pos
     * @param random
     */

    //Hardiness Zone 10 to 12
    public static final float MIN_TEMP = 0.85F;
    public static final float MAX_TEMP = 1.6F;

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        super.randomTick(state, worldIn, pos, random);

        //Growth Logic
        float temp = worldIn.getBiome(pos).getTemperature();
        boolean underGlass = isUnderGlass(worldIn, pos);

        if (temp < MIN_TEMP && !underGlass || temp > MAX_TEMP) {
            if (random.nextFloat() < 0.25F) {
                worldIn.destroyBlock(pos, false); // no drop
            }

            return;
        }

        super.randomTick(state, worldIn, pos, random);
    }

    private boolean isUnderGlass(ServerWorld world, BlockPos pos) {

        BlockPos.Mutable checkPos = new BlockPos.Mutable(pos.getX(), pos.getY() + 1, pos.getZ());

        while (checkPos.getY() < world.getHeight()) {

            BlockState stateAbove = world.getBlockState(checkPos);

            if (stateAbove.isAir() || stateAbove.getBlock() instanceof VineBlock) {
                checkPos.move(Direction.UP);
                continue;
            }

            // If this block is glass → protected
            if (stateAbove.getMaterial() == Material.GLASS) {
                return true;
            }

            // Any other solid block blocks protection
            return false;
        }

        return false;
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderLayer() {
        RenderTypeLookup.setRenderLayer(PlantsGroup.BRAZILLIAN_DUTCHMAN_PIPE_VINE.get(), RenderType.getCutout());
    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 90;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 85;
    }

    public PlantType getPlantType(IBlockReader world, BlockPos pos) {
        return PlantType.PLAINS;
    }
}
