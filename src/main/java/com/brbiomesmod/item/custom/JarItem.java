package com.brbiomesmod.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class JarItem extends Item {
    public JarItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true; // This item will have a container.
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        Item containerItem = ForgeRegistries.ITEMS.getValue(
                new ResourceLocation("caiocesarbiomes", "jar")
        );

        if (containerItem != null) {
            return new ItemStack(containerItem);
        }

        return ItemStack.EMPTY; // fallback if mod/item not found
    }
}