package com.brbiomesmod.block.Custom.Saplings;

import com.brbiomesmod.block.TreesGroup;
import com.brbiomesmod.features.TreeFeatures;
import net.minecraft.block.*;
import net.minecraft.block.trees.Tree;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class LophanteraSapling extends SaplingBlock {
    public LophanteraSapling() {
        super(new LophanteraTree(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING).hardnessAndResistance(0.0f)
                .sound(SoundType.PLANT));
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderLayer() {
        RenderTypeLookup.setRenderLayer(TreesGroup.LOPHANTERA_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(TreesGroup.POTTED_LOPHANTERA_SAPLING.get(), RenderType.getCutout());

    }

    public boolean ticksRandomly(BlockState state) {
        return true;
    }

    /**
     * Performs a random tick on a block.
     *
     * @param state
     * @param world
     * @param pos
     * @param random
     */
    //Hardy to zone 11 without protection
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {

        float biomeTemp = world.getBiome(pos).getTemperature(pos);
        float minTemp = 0.9f;
        float maxTemp = 1.6f;

        boolean isProtectedByGlass = isUnderGlass(world, pos);

        if ((biomeTemp >= minTemp && biomeTemp <= maxTemp)
                || (biomeTemp < minTemp && isProtectedByGlass)) {

            super.randomTick(state, world, pos, random);
        }
    }

    private boolean isUnderGlass(ServerWorld world, BlockPos pos) {

        BlockPos.Mutable mutable = new BlockPos.Mutable();

        // Step 1: Find the first block above that blocks the sky (roof height)
        int roofY = -1;

        for (int y = pos.getY() + 1; y < world.getHeight(); y++) {
            mutable.setPos(pos.getX(), y, pos.getZ());

            if (!world.isAirBlock(mutable)) {
                roofY = y;
                break;
            }
        }

        if (roofY == -1) {
            return false; // No roof found
        }

        // (radius 2 → 5x5 small green house)
        // (radius 3 → 7x7 medium green house)
        // (radius 4 → 9x9 large green house)
        int radius = 2;

        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {

                mutable.setPos(pos.getX() + x, roofY, pos.getZ() + z);
                BlockState state = world.getBlockState(mutable);

                if (!(state.getBlock() instanceof GlassBlock)) {
                    return false; // If any block is not glass → fail
                }
            }
        }

        return true; // Entire roof area is glass
    }

    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {

        if (!(worldIn instanceof World)) {
            return false;
        }

        World world = (World) worldIn;
        float temp = world.getBiome(pos).getTemperature(pos);

        boolean isProtectedByGlass = false;

        if (world instanceof ServerWorld) {
            isProtectedByGlass = isUnderGlass((ServerWorld) world, pos);
        }

        float minTemp = 0.9F;
        float maxTemp = 1.6F;

        // If protected, ignore cold restriction
        if (!isProtectedByGlass) {
            if (temp < minTemp || temp > maxTemp) {
                return false;
            }
        } else {
            // Under glass → only block extreme heat
            if (temp > maxTemp) {
                return false;
            }
        }

        return super.canGrow(worldIn, pos, state, isClient);
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random random, BlockPos pos, BlockState state) {
        // Always allow for the check, we'll block in grow()
        return true;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn,
                                             BlockPos pos, PlayerEntity player,
                                             Hand handIn, BlockRayTraceResult hit) {

        if (!worldIn.isRemote) {

            float temp = worldIn.getBiome(pos).getTemperature(pos);
            float minTemp = 0.9f;
            float maxTemp = 1.6f;

            boolean isProtectedByGlass = false;

            if (worldIn instanceof ServerWorld) {
                isProtectedByGlass = isUnderGlass((ServerWorld) worldIn, pos);
            }

            if (temp < minTemp && !isProtectedByGlass) {
                player.sendMessage(
                        new StringTextComponent("This biome is too cold for this sapling."),
                        player.getUniqueID()
                );
                return ActionResultType.SUCCESS;
            }

            if (temp > maxTemp) {
                player.sendMessage(
                        new StringTextComponent("This biome is too hot for this sapling."),
                        player.getUniqueID()
                );
                return ActionResultType.SUCCESS;
            }

            return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
        }

        return ActionResultType.SUCCESS;
    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 80;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 60;
    }

    private static class LophanteraTree extends Tree {
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random random, boolean p_225546_2_) {
            if (random.nextInt(10) == 0) {
                return TreeFeatures.LOPHANTERA_TREE;
            } else {
                return TreeFeatures.LOPHANTERA_TREE2;
            }
        }
    }
}
