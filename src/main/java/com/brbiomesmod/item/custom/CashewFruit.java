package com.brbiomesmod.item.custom;

import com.brbiomesmod.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CashewFruit extends Item {
    public CashewFruit(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true; // This item will have a container.
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        // Dynamically resolve CASHEW_APPLE at runtime
        Item containerItem = ModItems.CASHEW_APPLE.get();
        return new ItemStack(containerItem);
    }
}
