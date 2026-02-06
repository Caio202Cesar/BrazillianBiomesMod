package com.brbiomesmod.events;

import com.brbiomesmod.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EnderPearlEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "brbiomesmod")
public class RubberClothingEvents {

    //Rubber boots and leggings absorb damage fall
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

    private static boolean isFullRubber(PlayerEntity player) {

        return player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ModItems.RUBBER_HELMET.get()
                && player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ModItems.RUBBER_CHESTPLATE.get()
                && player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ModItems.RUBBER_LEGGINGS.get()
                && player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ModItems.RUBBER_BOOTS.get();
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        if (!(event.getEntityLiving() instanceof PlayerEntity)) return;

        Entity src = event.getSource().getImmediateSource();
        PlayerEntity player = (PlayerEntity) event.getEntityLiving();

        //Prevent damage from hot floor and magma blocks
        if (event.getSource() != DamageSource.HOT_FLOOR) return;

        ItemStack boots = player.getItemStackFromSlot(EquipmentSlotType.FEET);

        if (boots.getItem() == ModItems.RUBBER_BOOTS.get()) {

            // cancel magma damage
            event.setCanceled(true);
        }

        //Protection from spines
        if (event.getSource() != DamageSource.CACTUS &&
                event.getSource() != DamageSource.SWEET_BERRY_BUSH) return;

        if (!isFullRubber(player)) return;

        event.setCanceled(true);

        //Full rubber armor absorbs certain projectiles damage
        boolean allowedProjectile =
                src instanceof AbstractArrowEntity
                        || src instanceof SnowballEntity
                        || src instanceof EnderPearlEntity;

        if (!allowedProjectile) return;
        if (src instanceof TridentEntity) return;

        if (!isFullRubber(player)) return;

        double relativeHitY = src.getPosY() - player.getPosY();
        double percent = relativeHitY / player.getHeight();

        EquipmentSlotType slotHit;

        if (percent > 0.75) slotHit = EquipmentSlotType.HEAD;
        else if (percent > 0.35) slotHit = EquipmentSlotType.CHEST;
        else if (percent > 0.15) slotHit = EquipmentSlotType.LEGS;
        else slotHit = EquipmentSlotType.FEET;

        ItemStack armor = player.getItemStackFromSlot(slotHit);

        boolean isRubberPiece =
                (slotHit == EquipmentSlotType.HEAD && armor.getItem() == ModItems.RUBBER_HELMET.get())
                        || (slotHit == EquipmentSlotType.CHEST && armor.getItem() == ModItems.RUBBER_CHESTPLATE.get())
                        || (slotHit == EquipmentSlotType.LEGS && armor.getItem() == ModItems.RUBBER_LEGGINGS.get())
                        || (slotHit == EquipmentSlotType.FEET && armor.getItem() == ModItems.RUBBER_BOOTS.get());

        if (!isRubberPiece) return;

        event.setAmount(0F);

        armor.damageItem(6, player,
                (p) -> p.sendBreakAnimation(slotHit));

        player.world.playSound(null, player.getPosition(),
                SoundEvents.BLOCK_BONE_BLOCK_HIT,
                SoundCategory.PLAYERS, 1F, 1F);

        src.remove();
    }
}
