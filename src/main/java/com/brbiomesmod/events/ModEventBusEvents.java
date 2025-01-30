package com.brbiomesmod.events;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.events.loot.CalabashSeedsAdditionModifier;
import com.brbiomesmod.events.loot.CalabashSeedsStructureAdditionModifier;
import com.brbiomesmod.events.loot.MateCupStructureAdditionModifier;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = BrazillianBiomesMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                           event) {
        event.getRegistry().registerAll(
                new CalabashSeedsAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(BrazillianBiomesMod.MOD_ID,"calabash_seeds_from_grass")),
                new CalabashSeedsStructureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(BrazillianBiomesMod.MOD_ID,"calabash_seeds_in_abandoned_mineshaft")),
                new CalabashSeedsStructureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(BrazillianBiomesMod.MOD_ID,"calabash_seeds_in_dungeon")),
                new CalabashSeedsStructureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(BrazillianBiomesMod.MOD_ID,"calabash_seeds_in_stronghold")),
                new MateCupStructureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(BrazillianBiomesMod.MOD_ID,"mate_cup_in_bonus_chest")),
                new CalabashSeedsStructureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(BrazillianBiomesMod.MOD_ID,"mate_cup_in_abandoned_mineshaft")),
                new CalabashSeedsStructureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(BrazillianBiomesMod.MOD_ID,"mate_cup_in_dungeon")),
                new CalabashSeedsStructureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(BrazillianBiomesMod.MOD_ID,"mate_cup_in_stronghold"))
        );
    }
}
