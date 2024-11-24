package com.brbiomesmod.entity;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.entity.custom.ManedWolfEntity;
import com.brbiomesmod.entity.custom.MapinguariEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, BrazillianBiomesMod.MOD_ID);

    public static final RegistryObject<EntityType<MapinguariEntity>> MAPINGUARI =
            ENTITY_TYPES.register("mapinguari", () -> EntityType.Builder.create(MapinguariEntity::new,
                    EntityClassification.MONSTER).size(3f, 3f).build(new ResourceLocation(BrazillianBiomesMod.MOD_ID,
                    "mapinguari").toString()));

    public static final RegistryObject<EntityType<ManedWolfEntity>> MANED_WOLF =
            ENTITY_TYPES.register("maned_wolf", () -> EntityType.Builder.create(ManedWolfEntity::new,
                    EntityClassification.CREATURE).size(0.6F, 0.7F).build(new ResourceLocation(BrazillianBiomesMod.MOD_ID,
                    "maned_wolf").toString()));

    public static final RegistryObject<EntityType<CuracangaEntity>> CURACANGA =
            ENTITY_TYPES.register("curacanga", () -> EntityType.Builder.create(CuracangaEntity::new,
                    EntityClassification.MONSTER).immuneToFire().size(0.4f, 0.4f).build(new ResourceLocation(BrazillianBiomesMod.MOD_ID,
                    "curacanga").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
