package com.brbiomesmod.block.Custom.Log;

import com.brbiomesmod.events.ModParticles;
import com.brbiomesmod.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class SharingaTapperedLog extends RotatedPillarBlock {
    public static final IntegerProperty LATEX = IntegerProperty.create("latex", 0, 3);

    public SharingaTapperedLog() {
        super(Properties.from(Blocks.STRIPPED_OAK_LOG)
                .sound(SoundType.WOOD)
                .hardnessAndResistance(2.0F)
                .harvestTool(ToolType.AXE)
                .tickRandomly());

        this.setDefaultState(this.stateContainer.getBaseState()
                .with(AXIS, Direction.Axis.Y)
                .with(LATEX, 0));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(AXIS, LATEX);
    }

    /* ------------------------- */
    /* Latex accumulation (SERVER)
    /* ------------------------- */

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int latex = state.get(LATEX);

        if (latex < 3 && random.nextInt(40) == 0) {
            world.setBlockState(pos, state.with(LATEX, latex + 1), 3);
        }
    }

    /* ------------------------- */
    /* Latex drip particles (CLIENT)
    /* ------------------------- */

    @Override
    public void animateTick(BlockState state, World world, BlockPos pos, Random random) {

        if (state.get(LATEX) == 0 || random.nextInt(6) != 0)
            return;

        Direction direction = Direction.Plane.HORIZONTAL.random(random);

        double x = pos.getX() + 0.5D;
        double y = pos.getY() + random.nextDouble();
        double z = pos.getZ() + 0.5D;

        double offset = 0.52D;

        x += direction.getXOffset() * offset;
        z += direction.getZOffset() * offset;

        world.addParticle(
                ModParticles.LATEX_DRIP.get(),
                x, y, z,
                0.0D,
                -0.01D,
                0.0D
        );
    }

    /* ------------------------- */
    /* Harvesting latex
    /* ------------------------- */

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos,
                                             PlayerEntity player, Hand hand, BlockRayTraceResult hit) {

        ItemStack stack = player.getHeldItem(hand);

        // Must be empty bucket
        if (stack.getItem() != Items.BUCKET)
            return ActionResultType.PASS;

        int latex = state.get(LATEX);
        if (latex == 0)
            return ActionResultType.PASS;

        if (!world.isRemote) {
            stack.shrink(1);

            ItemStack latexBucket = new ItemStack(ModItems.LATEX_BUCKET.get());
            if (!player.addItemStackToInventory(latexBucket)) {
                player.dropItem(latexBucket, false);
            }

            world.setBlockState(pos, state.with(LATEX, 0), 3);

            world.playSound(null, pos,
                    SoundEvents.ITEM_BUCKET_FILL,
                    SoundCategory.BLOCKS,
                    1.0F, 1.0F);
        }

        return ActionResultType.SUCCESS;
    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 5;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 10;
    }

}
