package com.brbiomesmod.item.custom;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.world.World;

public class RubberizedPickaxeItem extends PickaxeItem {

    public RubberizedPickaxeItem(IItemTier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return false; // remove brilho roxo
    }

    @Override
    public void onCreated(ItemStack stack, World world, PlayerEntity player) {
        if (!world.isRemote) {
            stack.addEnchantment(Enchantments.SILK_TOUCH, 1);
        }
    }
}
