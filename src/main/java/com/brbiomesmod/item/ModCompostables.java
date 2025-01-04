package com.brbiomesmod.item;

import net.minecraft.block.ComposterBlock;
import net.minecraft.item.Items;
import net.minecraft.util.IItemProvider;

import static net.minecraft.block.ComposterBlock.CHANCES;

public class ModCompostables extends ComposterBlock {
    public ModCompostables(Properties properties) {
        super(properties);
    }

    public static void compostable(float chance, IItemProvider item) {
        CHANCES.put(item.asItem(), chance);
    }

    public static void init() {
        CHANCES.defaultReturnValue(-1.0F);
        float f = 0.3F;
        float f1 = 0.5F;
        float f2 = 0.65F;
        float f3 = 0.85F;
        float f4 = 1.0F;

        //Food
        registerCompostable(0.65F, ModItems.PINK_PEEPER.get());


    }

    private static void registerCompostable(float chance, IItemProvider itemIn) {
        CHANCES.put(itemIn.asItem(), chance);
    }
}
