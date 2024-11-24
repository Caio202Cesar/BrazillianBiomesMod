package com.brbiomesmod.entity.custom;

import com.brbiomesmod.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class ManedWolfEntity extends FoxEntity {
    public ManedWolfEntity(EntityType<? extends FoxEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() == ModItems.WOLF_APPLE;
    }

}
