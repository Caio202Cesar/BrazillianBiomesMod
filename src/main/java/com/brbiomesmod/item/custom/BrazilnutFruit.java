package com.brbiomesmod.item.custom;

import com.brbiomesmod.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.IItemProvider;
import net.minecraft.world.World;

public class BrazilnutFruit extends Item {
    public BrazilnutFruit(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        World world = context.getWorld();

        if(!world.isRemote) {
            PlayerEntity playerEntity = context.getPlayer();
            BlockState clickedBlock = world.getBlockState(context.getPos());

            rightClickOnCertainBlockState(clickedBlock, context, playerEntity);

        }

        return super.onItemUseFirst(stack, context);
    }

    private void rightClickOnCertainBlockState(BlockState clickedBlock, ItemUseContext context, PlayerEntity playerEntity) {
        // Check if the clicked block is stone
        if (clickedBlock.getBlock() == Blocks.STONE) {

            // Use get() on the RegistryObject to obtain the Item instance
            ItemStack firstItemStack = new ItemStack(ModItems.BRAZILNUT_SHELL.get());
            ItemStack secondItemStack = new ItemStack(ModItems.BRAZILNUT_WITH_PELL.get());

            // Add the items to the player's inventory
            playerEntity.inventory.addItemStackToInventory(firstItemStack);
            playerEntity.inventory.addItemStackToInventory(secondItemStack);

            // Optionally, you could remove the used item from the player’s hand if desired
            context.getItem().shrink(1); // Reduces the stack size by 1
        }
    }
}
