package com.brbiomesmod;

import com.brbiomesmod.Seasons.Season;
import com.brbiomesmod.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = BrazillianBiomesMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEventSubscriber {

    @SubscribeEvent
    public static void onRenderGameOverlay(RenderGameOverlayEvent.Text event) {
        Season.onRenderGameOverlay(event);
    }

    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        PlayerEntity player = event.getPlayer();
        CompoundNBT data = player.getPersistentData();

        // Prevent multiple books
        if (!data.getBoolean("HasFloraGuide")) {
            // Create Patchouli guide book ItemStack manually
            ItemStack book = new ItemStack(ForgeRegistries.ITEMS.getValue(
                    new ResourceLocation("patchouli", "guide_book")
            ));

            // Attach the book ID so Patchouli knows which book to open
            CompoundNBT tag = book.getOrCreateTag();
            tag.putString("patchouli:book", "brbiomesmod:flora_guide");

            // Give to player
            player.addItemStackToInventory(book);

            // Mark as given
            data.putBoolean("HasFloraGuide", true);
        }
    }
}
