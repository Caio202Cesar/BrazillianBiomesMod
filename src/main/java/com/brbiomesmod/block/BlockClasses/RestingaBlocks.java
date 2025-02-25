package com.brbiomesmod.block.BlockClasses;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.block.*;
import com.brbiomesmod.block.Custom.Leaves.*;
import com.brbiomesmod.block.Saplings.CashewSapling;
import com.brbiomesmod.block.Saplings.MangabaSapling;
import com.brbiomesmod.block.Saplings.MonkeyCajaranaSapling;
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
            () -> new CashewLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), RestingaBlocks.CASHEW_FRUITING_LEAVES));
    public static final RegistryObject<Block> CASHEW_FRUITING_LEAVES = registerBlock("cashew_fruiting_leaves",
            () -> new CashewFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), RestingaBlocks.CASHEW_LEAVES));
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
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_CASHEW_SAPLING = BLOCKS.register("potted_cashew_sapling",
            () -> new FlowerPotBlock(RestingaBlocks.CASHEW_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> MANGABA_LOG = registerBlock("mangaba_log",
            ModLogs::new);
    public static final RegistryObject<Block> MANGABA_WOOD = registerBlock("mangaba_wood",
            ModLogs::new);
    public static final RegistryObject<Block> MANGABA_PLANKS = registerBlock("mangaba_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> MANGABA_LEAVES = registerBlock("mangaba_leaves",
            MangabaLeaves::new);
    public static final RegistryObject<Block> MANGABA_FLOWERING_LEAVES = registerBlock("mangaba_flowering_leaves",
            MangabaLeaves::new);
    public static final RegistryObject<Block> MANGABA_FRUITING_LEAVES = registerBlock("mangaba_fruiting_leaves",
            MangabaLeaves::new);
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
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_MANGABA_SAPLING = BLOCKS.register("potted_mangaba_sapling",
            () -> new FlowerPotBlock(RestingaBlocks.MANGABA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> MONKEY_CAJARANA_LEAVES = registerBlock("monkey_cajarana_leaves",
            MonkeyCajaranaLeaves::new);
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
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_MONKEY_CAJARANA_SAPLING = BLOCKS.register("potted_monkey_cajarana_sapling",
            () -> new FlowerPotBlock(RestingaBlocks.MONKEY_CAJARANA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> XANANA = registerBlock("xanana",
            XananaFlower::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_XANANA = BLOCKS.register("potted_xanana",
            () -> new FlowerPotBlock(RestingaBlocks.XANANA.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> XANANA_BIG = registerBlock("xanana_big",
            XananaFlower::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_BIG_XANANA = BLOCKS.register("potted_big_xanana",
            () -> new FlowerPotBlock(RestingaBlocks.XANANA_BIG.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> IPOMAEA_PES_CAPRAE = registerBlock("ipomaea_pes_caprae",
            BeachFlower::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_IPOMAEA_PES_CAPRAE = BLOCKS.register("potted_ipomaea_pes_caprae",
            () -> new FlowerPotBlock(RestingaBlocks.IPOMAEA_PES_CAPRAE.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


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

