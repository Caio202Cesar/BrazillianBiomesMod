package com.brbiomesmod.events;

import com.brbiomesmod.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "brbiomesmod")
public class RubberClothingEvents {

    @SubscribeEvent
    public static void onLivingFall(LivingFallEvent event) {

        if (!(event.getEntityLiving() instanceof PlayerEntity)) return;

        PlayerEntity player = (PlayerEntity) event.getEntityLiving();

        ItemStack boots = player.getItemStackFromSlot(EquipmentSlotType.FEET);
        ItemStack leggings = player.getItemStackFromSlot(EquipmentSlotType.LEGS);

        if (boots.getItem() == ModItems.RUBBER_BOOTS.get()) {

            // OPTION A — Reduce damage multiplier
            float multiplier = 0.5F; // 50% damage reduction
            event.setDamageMultiplier(event.getDamageMultiplier() * multiplier);

            // OPTION B — Reduce effective fall distance
            // event.setDistance(event.getDistance() * 0.6F);
        }

        if (leggings.getItem() == ModItems.RUBBER_LEGGINGS.get()) {

            // OPTION A — Reduce damage multiplier
            float multiplier = 0.35F; // 35% damage reduction
            event.setDamageMultiplier(event.getDamageMultiplier() * multiplier);

            // OPTION B — Reduce effective fall distance
            // event.setDistance(event.getDistance() * 0.6F);
        }
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {

        if (!(event.getEntityLiving() instanceof PlayerEntity)) return;

        PlayerEntity player = (PlayerEntity) event.getEntityLiving();

        // Check projectile damage
        if (!event.getSource().isProjectile()) return;

        ItemStack chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
        ItemStack helmet = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
        ItemStack leggings = player.getItemStackFromSlot(EquipmentSlotType.LEGS);

        if (chest.getItem() != ModItems.RUBBER_CHESTPLATE.get()) return;

        // Cancel damage
        event.setAmount(0F);

        // Damage armor durability
        int extraDamage = 4; // tweak balance here
        chest.damageItem(extraDamage, player,
                (p) -> p.sendBreakAnimation(EquipmentSlotType.CHEST));

        if (helmet.getItem() != ModItems.RUBBER_HELMET.get()) return;

        // Cancel damage
        event.setAmount(0F);

        // Damage armor durability
        helmet.damageItem(extraDamage, player,
                (p) -> p.sendBreakAnimation(EquipmentSlotType.HEAD));

        if (leggings.getItem() != ModItems.RUBBER_LEGGINGS.get()) return;

        // Cancel damage
        event.setAmount(0F);

        // Damage armor durability
        leggings.damageItem(extraDamage, player,
                (p) -> p.sendBreakAnimation(EquipmentSlotType.LEGS));
    }
}
