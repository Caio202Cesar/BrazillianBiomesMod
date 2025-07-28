package com.brbiomesmod;

import com.brbiomesmod.Seasons.Season;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryManager;

@Mod.EventBusSubscriber(modid = BrazillianBiomesMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEventSubscriber {

    @SubscribeEvent
    public static void onRenderGameOverlay(RenderGameOverlayEvent.Text event) {
        Season.onRenderGameOverlay(event);
    }

    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        if (!(event.getPlayer() instanceof ServerPlayerEntity)) return;

        ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();

        // Create the book item
        Item patchouliBookItem = RegistryManager.ACTIVE.getRegistry(Item.class).getValue(new ResourceLocation("patchouli", "guide_book"));
        if (patchouliBookItem == null) {
            System.err.println("Patchouli guide book item not found!");
            return;
        }

        ItemStack bookStack = new ItemStack(patchouliBookItem);

        // Set the specific book ID (this must match your book's JSON file name)
        bookStack.getOrCreateTag().putString("patchouli:book", BrazillianBiomesMod.MOD_ID + ":flora_guide");

        // Give it to the player
        player.inventory.addItemStackToInventory(bookStack);
    }
}
