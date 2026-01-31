package com.brbiomesmod.Util;

import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "brbiomesmod", bus = Mod.EventBusSubscriber.Bus.FORGE)

public class SulphurSmeltingHandler {
    public static final ITag<Item> SULPHUR_TAG =
            ItemTags.makeWrapperTag("forge:sulphur");

    @SubscribeEvent
    public static void onFuelBurnTime(FurnaceFuelBurnTimeEvent event) {
        if (event.getItemStack().getItem().isIn(SULPHUR_TAG)) {
            event.setBurnTime(1200);
        }
    }
}
