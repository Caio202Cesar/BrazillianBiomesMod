package com.brbiomesmod.Util;

import com.brbiomesmod.block.WoodGroup;
import com.brbiomesmod.item.ModItems;
import com.caiocesarmods.caiocesarbiomes.block.ModWood;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "brbiomesmod", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ItemGivingBarkHandler {
    @SubscribeEvent
    public static void onRightClickLog(PlayerInteractEvent.RightClickBlock event) {

        PlayerEntity player = event.getPlayer();
        World world = event.getWorld();
        BlockPos pos = event.getPos();

        ItemStack held = player.getHeldItem(event.getHand());

        // Only axes
        if (!(held.getItem() instanceof AxeItem))
            return;

        BlockState state = world.getBlockState(pos);

        // Check the sandbox tree log
        if (state.getBlock() != WoodGroup.SANDBOX_TREE_THORNLESS_LOG.get())
            return;

        if (!world.isRemote) {

            // Give ficus latex
            Block.spawnAsEntity(
                    world,
                    pos,
                    new ItemStack(ModItems.ASSACU_POISON_SAP.get())
            );


            // Replace with stripped log
            world.setBlockState(
                    pos,
                    ModWood.STRIPPED_LIGHTWOOD_LOG.get()
                            .getDefaultState()
            );


            // Damage axe
            if (!player.isCreative()) {
                held.damageItem(1, player,
                        p -> p.sendBreakAnimation(event.getHand()));
            }
        }

        // Check the sharinga log
        if (state.getBlock() != WoodGroup.SHARINGA_LOG.get())
            return;

        if (!world.isRemote) {

            // Give ficus latex
            Block.spawnAsEntity(
                    world,
                    pos,
                    new ItemStack(com.caiocesarmods.caiocesarbiomes.item.ModItems.STICKY_LATEX.get())
            );


            // Replace with stripped log
            world.setBlockState(
                    pos,
                    ModWood.STRIPPED_LIGHTWOOD_LOG.get()
                            .getDefaultState()
            );


            // Damage axe
            if (!player.isCreative()) {
                held.damageItem(1, player,
                        p -> p.sendBreakAnimation(event.getHand()));
            }
        }
    }
}
