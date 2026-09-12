package com.brbiomesmod.mixin;

import com.brbiomesmod.block.WoodGroup;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CocoaBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.state.properties.BlockStateProperties.HORIZONTAL_FACING;

@Mixin(CocoaBlock.class)
public class CocoaBlockMixin {
    @Inject(
            method = "isValidPosition",
            at = @At("HEAD"),
            cancellable = true
    )

    public void isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        Block block = worldIn.getBlockState(pos.offset(state.get(HORIZONTAL_FACING))).getBlock();

        if (block.getBlock() == Blocks.JUNGLE_LOG) {
            cir.cancel();
        }
    }
}


