package com.brbiomesmod.Seasons;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public enum Season {
    SPRING, SUMMER, FALL, WINTER;

    public static String getSeason(long dayTime) {
        long days = dayTime / 24000; // Convert ticks to days
        long cycle = days % 96; // Assume a full year is 96 days (30 per season)

        if (cycle < 24) {
            return "SPRING";
        } else if (cycle < 48) {
            return "SUMMER";
        } else if (cycle < 72) {
            return "FALL";
        } else {
            return "WINTER";
        }
    }

    @SubscribeEvent
    public static void onRenderGameOverlay(RenderGameOverlayEvent.Text event) {
        Minecraft mc = Minecraft.getInstance();
        ClientPlayerEntity player = mc.player;
        if (player == null) return;
        World world = player.world;

        String season = getSeason(world.getDayTime());

        mc.fontRenderer.drawString(event.getMatrixStack(), "Harvest Season: " + season, 10, 10, 0xFFFFFF);
    }
}
