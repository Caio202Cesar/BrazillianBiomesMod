package com.brbiomesmod.Util;


import net.minecraft.block.ComposterBlock;
import net.minecraft.util.IItemProvider;

public final class CompostingHelper {

    private CompostingHelper() {}

    public static void registerCompostable(IItemProvider item, float chance) {
        ComposterBlock.CHANCES.put(item, chance);
    }
}
