package com.brbiomesmod.events;

import com.brbiomesmod.BrazillianBiomesMod;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, BrazillianBiomesMod.MOD_ID);

    public static final RegistryObject<EntityType<SandboxSeedEntity>> SANDBOX_SEED =
            ENTITY_TYPES.register("sandbox_seed",
                    () -> EntityType.Builder.<SandboxSeedEntity>create(SandboxSeedEntity::new, EntityClassification.MISC)
                            .size(0.25f, 0.25f)
                            .setUpdateInterval(10)
                            .setTrackingRange(64)
                            .build("sandbox_seed"));
}
