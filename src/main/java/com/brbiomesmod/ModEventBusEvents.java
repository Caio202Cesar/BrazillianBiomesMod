package com.brbiomesmod;

import com.brbiomesmod.entity.ModEntityTypes;
import com.brbiomesmod.entity.custom.BotoEntity;
import com.brbiomesmod.entity.custom.GoldenLionTamarinEntity;
import com.brbiomesmod.entity.custom.MapinguariEntity;
import com.brbiomesmod.entity.custom.TocoToucanEntity;
import com.brbiomesmod.item.custom.ModSpawnEggItem;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BrazillianBiomesMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.TOCO_TOUCAN_ENTITY.get(), TocoToucanEntity.setCustomAttributes().create());
        event.put(ModEntityTypes.MAPINGUARI_ENTITY.get(), MapinguariEntity.setCustomAttributes().create());
        event.put(ModEntityTypes.BOTO_ENTITY.get(), BotoEntity.setCustomAttributes().create());
        event.put(ModEntityTypes.GOLDEN_LION_TAMARIN_ENTITY.get(), GoldenLionTamarinEntity.setCustomAttributes().create());

    }

    @SubscribeEvent
    public static void onRegisterEntities(RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggItem.initSpawnEggs();
    }
}
