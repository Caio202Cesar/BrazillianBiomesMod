package com.brbiomesmod.features;

import com.brbiomesmod.BrazillianBiomesMod;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTreeDecorators {
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS =
            DeferredRegister.create(ForgeRegistries.TREE_DECORATOR_TYPES, BrazillianBiomesMod.MOD_ID);

    public static final RegistryObject<TreeDecoratorType<PassionFruitVineLeavesDecorator>> PASSIONVINE_DECORATOR =
            TREE_DECORATORS.register("passionvine_decorator",
                    () -> new TreeDecoratorType<>(PassionFruitVineLeavesDecorator.CODEC));

    public static void register(IEventBus eventBus) {
        TREE_DECORATORS.register(eventBus);
    }
}


