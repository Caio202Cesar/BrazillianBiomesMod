package com.brbiomesmod.events;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.events.loot.ApricotIpeStructureAdditionModifier;
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
                new MateCupStructureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(BrazillianBiomesMod.MOD_ID,"mate_cup_in_bonus_chest")),
                new MateCupStructureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(BrazillianBiomesMod.MOD_ID,"mate_cup_in_abandoned_mineshaft")),
                new MateCupStructureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(BrazillianBiomesMod.MOD_ID,"mate_cup_in_dungeon")),
                new MateCupStructureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(BrazillianBiomesMod.MOD_ID,"mate_cup_in_stronghold")),
                new ApricotIpeStructureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(BrazillianBiomesMod.MOD_ID,"apricot_ipe_sapling_in_abandoned_mineshaft")),
                new ApricotIpeStructureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(BrazillianBiomesMod.MOD_ID,"apricot_ipe_sapling_in_dungeon")),
                new ApricotIpeStructureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(BrazillianBiomesMod.MOD_ID,"apricot_ipe_sapling_in_stronghold"))
        );
    }
}
