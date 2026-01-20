package com.brbiomesmod.item.custom;

import com.brbiomesmod.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SapucaiaFruit extends Item {
    public SapucaiaFruit(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true; // This item will have a container.
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        // Dynamically resolve CASHEW_APPLE at runtime
        Item containerItem = ModItems.SAPUCAIA_SHELL.get();
        return new ItemStack(containerItem);
    }
}
