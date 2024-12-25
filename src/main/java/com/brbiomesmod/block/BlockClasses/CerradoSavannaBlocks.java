package com.brbiomesmod.block.BlockClasses;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.block.ModLeaves;
import com.brbiomesmod.block.ModLogs;
import com.brbiomesmod.block.ModPlanks;
import com.brbiomesmod.block.Saplings.BlackSucupiraSapling;
import com.brbiomesmod.block.Saplings.CagaitaSapling;
import com.brbiomesmod.block.Saplings.PinkSilkFlossSapling;
import com.brbiomesmod.block.Saplings.WolfAppleSapling;
import com.brbiomesmod.block.SilkFlossLog;
import com.brbiomesmod.item.ModItemGroup;
import com.brbiomesmod.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class CerradoSavannaBlocks {
    public static List<Block> blocksList = new ArrayList<>();

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, BrazillianBiomesMod.MOD_ID);


    public static final RegistryObject<Block> WOLF_APPLE_LOG = registerBlock("wolf_apple_log",
            ModLogs::new);
    public static final RegistryObject<Block> WOLF_APPLE_LEAVES = registerBlock("wolf_apple_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> WOLF_APPLE_SAPLING = registerBlock("wolf_apple_sapling",
            WolfAppleSapling::new);
    public static final RegistryObject<Block> WOLF_APPLE_PLANKS = registerBlock("wolf_apple_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> WOLF_APPLE_STAIRS = registerBlock("wolf_apple_stairs",
            () -> new StairsBlock(() -> WOLF_APPLE_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> WOLF_APPLE_FENCE = registerBlock("wolf_apple_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));

    public static final RegistryObject<Block> WOLF_APPLE_FENCE_GATE = registerBlock("wolf_apple_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));


    public static final RegistryObject<Block> BLACK_SUCUPIRA_LOG = registerBlock("black_sucupira_log",
            ModLogs::new);
    public static final RegistryObject<Block> BLACK_SUCUPIRA_LEAVES = registerBlock("black_sucupira_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> BLACK_SUCUPIRA_SAPLING = registerBlock("black_sucupira_sapling",
            BlackSucupiraSapling::new);
    public static final RegistryObject<Block> BLACK_SUCUPIRA_PLANKS = registerBlock("black_sucupira_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> BLACK_SUCUPIRA_STAIRS = registerBlock("black_sucupira_stairs",
            () -> new StairsBlock(() -> BLACK_SUCUPIRA_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> BLACK_SUCUPIRA_FENCE = registerBlock("black_sucupira_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));

    public static final RegistryObject<Block> BLACK_SUCUPIRA_FENCE_GATE = registerBlock("black_sucupira_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));


    public static final RegistryObject<Block> CAGAITA_LEAVES = registerBlock("cagaita_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> CAGAITA_SAPLING = registerBlock("cagaita_sapling",
            CagaitaSapling::new);

    public static final RegistryObject<Block> SILK_FLOSS_LOG = registerBlock("silk_floss_log",
            SilkFlossLog::new);
    public static final RegistryObject<Block> PINK_SILK_FLOSS_LEAVES = registerBlock("silk_floss_pink_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> PINK_SILK_FLOSS_SAPLING = registerBlock("silk_floss_pink_sapling",
            PinkSilkFlossSapling::new);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.CERRADO_SAVANNA_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

