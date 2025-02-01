package com.brbiomesmod.block.BlockClasses;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.block.*;
import com.brbiomesmod.block.Saplings.CashewSapling;
import com.brbiomesmod.block.Saplings.MangabaSapling;
import com.brbiomesmod.block.Saplings.MonkeyCajaranaSapling;
import com.brbiomesmod.item.ModItemGroup;
import com.brbiomesmod.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
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

public class RestingaBlocks {
    public static List<Block> blocksList = new ArrayList<>();

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, BrazillianBiomesMod.MOD_ID);


    public static final RegistryObject<Block> CASHEW_LOG = registerBlock("cashew_log",
            ModLogs::new);
    public static final RegistryObject<Block> CASHEW_WOOD = registerBlock("cashew_wood",
            ModLogs::new);
    public static final RegistryObject<Block> CASHEW_PLANKS = registerBlock("cashew_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> CASHEW_LEAVES = registerBlock("cashew_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> CASHEW_SAPLING = registerBlock("cashew_sapling",
            CashewSapling::new);
    public static final RegistryObject<Block> CASHEW_SLAB = registerBlock("cashew_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> CASHEW_STAIRS = registerBlock("cashew_stairs",
            () -> new StairsBlock(() -> CASHEW_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> CASHEW_FENCE = registerBlock("cashew_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> CASHEW_FENCE_GATE = registerBlock("cashew_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));

    //public static final RegistryObject<Block> CASHEW_STRIPPED_LOG = registerBlock("cashew_stripped_log", ModLogs::new);
    //public static final RegistryObject<Block> CASHEW_STRIPPED_WOOD = registerBlock("cashew_stripped_wood", ModLogs::new);


    public static final RegistryObject<Block> MANGABA_LEAVES = registerBlock("mangaba_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> MANGABA_LOG = registerBlock("mangaba_log",
            ModLogs::new);
    public static final RegistryObject<Block> MANGABA_WOOD = registerBlock("mangaba_wood",
            ModLogs::new);
    public static final RegistryObject<Block> MANGABA_PLANKS = registerBlock("mangaba_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> MANGABA_SAPLING = registerBlock("mangaba_sapling",
            MangabaSapling::new);
    public static final RegistryObject<Block> MANGABA_SLAB = registerBlock("mangaba_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> MANGABA_STAIRS = registerBlock("mangaba_stairs",
            () -> new StairsBlock(() -> MANGABA_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> MANGABA_FENCE = registerBlock("mangaba_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> MANGABA_FENCE_GATE = registerBlock("mangaba_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));


    public static final RegistryObject<Block> PITOMBA_LEAVES = registerBlock("pitomba_leaves",
            ModLeaves::new);


    public static final RegistryObject<Block> MONKEY_CAJARANA_LEAVES = registerBlock("monkey_cajarana_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> MONKEY_CAJARANA_LOG = registerBlock("monkey_cajarana_log",
            ModLogs::new);
    public static final RegistryObject<Block> MONKEY_CAJARANA_WOOD = registerBlock("monkey_cajarana_wood",
            ModLogs::new);
    public static final RegistryObject<Block> MONKEY_CAJARANA_SAPLING = registerBlock("monkey_cajarana_sapling",
            MonkeyCajaranaSapling::new);
    public static final RegistryObject<Block> MONKEY_CAJARANA_PLANKS = registerBlock("monkey_cajarana_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> MONKEY_CAJARANA_SLAB = registerBlock("monkey_cajarana_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> MONKEY_CAJARANA_STAIRS = registerBlock("monkey_cajarana_stairs",
            () -> new StairsBlock(() -> MONKEY_CAJARANA_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> MONKEY_CAJARANA_FENCE = registerBlock("monkey_cajarana_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> MONKEY_CAJARANA_FENCE_GATE = registerBlock("monkey_cajarana_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));


    public static final RegistryObject<Block> XANANA = registerBlock("xanana",
            XananaFlower::new);
    public static final RegistryObject<Block> XANANA_BIG = registerBlock("xanana_big",
            XananaFlower::new);
    public static final RegistryObject<Block> IPOMAEA_PES_CAPRAE = registerBlock("ipomaea_pes_caprae",
            BeachFlower::new);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.RESTINGA_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

