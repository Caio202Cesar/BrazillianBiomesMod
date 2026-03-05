package com.brbiomesmod.entity;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.entity.custom.*;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, BrazillianBiomesMod.MOD_ID);


    public static final RegistryObject<EntityType<TocoToucanEntity>> TOCO_TOUCAN_ENTITY =
            ENTITY_TYPES.register("toco_toucan",
                    () -> EntityType.Builder.create(TocoToucanEntity::new,
                                    EntityClassification.CREATURE).size(0.4f, 0.3f)
                            .build(new ResourceLocation(BrazillianBiomesMod.MOD_ID, "toco_toucan").toString()));

    public static final RegistryObject<EntityType<MapinguariEntity>> MAPINGUARI_ENTITY =
            ENTITY_TYPES.register("mapinguari",
                    () -> EntityType.Builder.create(MapinguariEntity::new,
                                    EntityClassification.MONSTER).size(1.6F, 2.9F)
                            .build(new ResourceLocation(BrazillianBiomesMod.MOD_ID, "mapinguari").toString()));

    public static final RegistryObject<EntityType<BotoEntity>> BOTO_ENTITY =
            ENTITY_TYPES.register("boto_dolphin",
                    () -> EntityType.Builder.create(BotoEntity::new,
                                    EntityClassification.WATER_CREATURE).size(0.9F, 0.6F)
                            .build(new ResourceLocation(BrazillianBiomesMod.MOD_ID, "boto_dolphin").toString()));

    public static final RegistryObject<EntityType<GoldenLionTamarinEntity>> GOLDEN_LION_TAMARIN_ENTITY =
            ENTITY_TYPES.register("golden_lion_tamarin",
                    () -> EntityType.Builder.create(GoldenLionTamarinEntity::new,
                                    EntityClassification.CREATURE).size(0.5F, 0.7F)
                            .build(new ResourceLocation(BrazillianBiomesMod.MOD_ID, "golden_lion_tamarin").toString()));

    public static final RegistryObject<EntityType<ManedWolfEntity>> MANED_WOLF_ENTITY =
            ENTITY_TYPES.register("maned_wolf",
                    () -> EntityType.Builder.create(ManedWolfEntity::new,
                                    EntityClassification.CREATURE).size(0.5F, 0.7F)
                            .build(new ResourceLocation(BrazillianBiomesMod.MOD_ID, "maned_wolf").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
