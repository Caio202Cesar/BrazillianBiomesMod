package com.brbiomesmod.world.gen;

import com.brbiomesmod.block.BlockClasses.CaatingaBlocks;
import net.minecraft.block.Block;
import net.minecraftforge.common.util.Lazy;

public enum OreType {
    TOURMALINE_PARAIBA(Lazy.of(CaatingaBlocks.TOURMALINE_PARAIBA_ORE), 8, 25, 50, 3);

    private final Lazy<Block> block;
    private final int maxVeinSize;
    private final int minHeight;
    private final int maxHeight;
    private final int veinsPerChunk;

    private OreType(Lazy block, int maxVeinSize, int minHeight, int maxHeight, int veinsPerChunk) {
        this.block = block;
        this.maxVeinSize = maxVeinSize;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.veinsPerChunk = veinsPerChunk;
    }

    public int getVeinsPerChunk() {
        return this.veinsPerChunk;
    }

    public Lazy<Block> getBlock() {
        return this.block;
    }

    public int getMaxVeinSize() {
        return this.maxVeinSize;
    }

    public int getMinHeight() {
        return this.minHeight;
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public static OreType get(Block block) {
        OreType[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            OreType ore = var1[var3];
            if (block == ore.block) {
                return ore;
            }
        }

        return null;
    }
}
