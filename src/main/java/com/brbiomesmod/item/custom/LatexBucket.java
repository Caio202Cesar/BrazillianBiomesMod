package com.brbiomesmod.item.custom;

import com.brbiomesmod.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class LatexBucket extends Item {
    public LatexBucket(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true; // This item will have a container.
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        // Dynamically resolve CASHEW_APPLE at runtime
        Item containerItem = Items.BUCKET;
        return new ItemStack(containerItem);
    }
}
