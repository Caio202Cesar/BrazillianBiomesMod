package com.brbiomesmod.block.BlockClasses;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.block.AcaiBunchBlock;
import com.brbiomesmod.block.BuritiBunchBlock;
import com.brbiomesmod.block.Custom.Leaves.*;
import com.brbiomesmod.block.Custom.Log.ModLogs;
import com.brbiomesmod.block.Custom.Log.PalmitoLog;
import com.brbiomesmod.block.ModPlanks;
import com.brbiomesmod.block.Saplings.*;
import com.brbiomesmod.block.Custom.Log.SilkFlossLog;
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

public class CerradoBlocks {
    public static List<Block> blocksList = new ArrayList<>();

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, BrazillianBiomesMod.MOD_ID);

    public static final RegistryObject<Block> WOLF_APPLE_LOG = registerBlock("wolf_apple_log",
            ModLogs::new);
    public static final RegistryObject<Block> WOLF_APPLE_WOOD = registerBlock("wolf_apple_wood",
            ModLogs::new);
    public static final RegistryObject<Block> WOLF_APPLE_LEAVES = registerBlock("wolf_apple_leaves",
            () -> new WolfAppleLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), CerradoBlocks.WOLF_APPLE_FLOWERING_LEAVES));
    public static final RegistryObject<Block> WOLF_APPLE_FLOWERING_LEAVES = registerBlock("wolf_apple_flowering_leaves",
            () -> new WolfAppleFloweringLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), CerradoBlocks.WOLF_APPLE_FRUITING_LEAVES));
    public static final RegistryObject<Block> WOLF_APPLE_FRUITING_LEAVES = registerBlock("wolf_apple_fruiting_leaves",
            () -> new WolfAppleFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), CerradoBlocks.WOLF_APPLE_LEAVES));
    public static final RegistryObject<Block> WOLF_APPLE_SAPLING = registerBlock("wolf_apple_sapling",
            WolfAppleSapling::new);
    public static final RegistryObject<Block> WOLF_APPLE_PLANKS = registerBlock("wolf_apple_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> WOLF_APPLE_SLAB = registerBlock("wolf_apple_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> WOLF_APPLE_STAIRS = registerBlock("wolf_apple_stairs",
            () -> new StairsBlock(() -> WOLF_APPLE_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> WOLF_APPLE_FENCE = registerBlock("wolf_apple_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> WOLF_APPLE_FENCE_GATE = registerBlock("wolf_apple_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_WOLF_APPLE_SAPLING = BLOCKS.register("potted_wolf_apple_sapling",
            () -> new FlowerPotBlock(CerradoBlocks.WOLF_APPLE_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance()));


    public static final RegistryObject<Block> BLACK_SUCUPIRA_LOG = registerBlock("black_sucupira_log",
            ModLogs::new);
    public static final RegistryObject<Block> BLACK_SUCUPIRA_WOOD = registerBlock("black_sucupira_wood",
            ModLogs::new);
    public static final RegistryObject<Block> BLACK_SUCUPIRA_LEAVES = registerBlock("black_sucupira_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> BLACK_SUCUPIRA_SAPLING = registerBlock("black_sucupira_sapling",
            BlackSucupiraSapling::new);
    public static final RegistryObject<Block> BLACK_SUCUPIRA_PLANKS = registerBlock("black_sucupira_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> BLACK_SUCUPIRA_SLAB = registerBlock("black_sucupira_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> BLACK_SUCUPIRA_STAIRS = registerBlock("black_sucupira_stairs",
            () -> new StairsBlock(() -> BLACK_SUCUPIRA_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> BLACK_SUCUPIRA_FENCE = registerBlock("black_sucupira_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> BLACK_SUCUPIRA_FENCE_GATE = registerBlock("black_sucupira_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_BLACK_SUCUPIRA_SAPLING = BLOCKS.register("potted_black_sucupira_sapling",
            () -> new FlowerPotBlock(CerradoBlocks.BLACK_SUCUPIRA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance()));


    public static final RegistryObject<Block> CAGAITA_LEAVES = registerBlock("cagaita_leaves",
            () -> new CagaitaLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), CerradoBlocks.CAGAITA_FLOWERING_LEAVES));
    public static final RegistryObject<Block> CAGAITA_FLOWERING_LEAVES = registerBlock("cagaita_flowering_leaves",
            () -> new CagaitaFloweringLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), CerradoBlocks.CAGAITA_FRUITING_LEAVES));
    public static final RegistryObject<Block> CAGAITA_FRUITING_LEAVES = registerBlock("cagaita_fruiting_leaves",
            () -> new CagaitaFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), CerradoBlocks.CAGAITA_LEAVES));
    public static final RegistryObject<Block> CAGAITA_SAPLING = registerBlock("cagaita_sapling",
            CagaitaSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_CAGAITA_SAPLING = BLOCKS.register("potted_cagaita_sapling",
            () -> new FlowerPotBlock(CerradoBlocks.CAGAITA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance()));


    public static final RegistryObject<Block> BURITI_LEAVES = registerBlock("buriti_leaves",
            () -> new BuritiLeaves(AbstractBlock.Properties.create(Material.LEAVES)
                    .hardnessAndResistance(0.2f)
                    .tickRandomly() // Enables random ticks
                    .notSolid()
                    .sound(SoundType.PLANT)));
    public static final RegistryObject<Block> BURITI_LOG = registerBlock("buriti_log",
            ModLogs::new);
    public static final RegistryObject<Block> BURITI_SAPLING = registerBlock("buriti_sapling",
            AcaiSapling::new);
    public static final RegistryObject<Block> BURITI_BUNCH = registerBlock("buriti_bunch",
            BuritiBunchBlock::new);


    public static final RegistryObject<Block> SILK_FLOSS_LOG = registerBlock("silk_floss_log",
            SilkFlossLog::new);
    public static final RegistryObject<Block> SILK_FLOSS_WOOD = registerBlock("silk_floss_thornless_wood",
            ModLogs::new);
    public static final RegistryObject<Block> SILK_FLOSS_THORNY_WOOD = registerBlock("silk_floss_thorny_wood",
            SilkFlossLog::new);
    public static final RegistryObject<Block> PINK_SILK_FLOSS_LEAVES = registerBlock("silk_floss_pink_leaves",
            () -> new PinkSilkFlossLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), CerradoBlocks.PINK_SILK_FLOSS_FLOWERING_LEAVES));
    public static final RegistryObject<Block> PINK_SILK_FLOSS_FLOWERING_LEAVES = registerBlock("silk_floss_pink_flowering_leaves",
            () -> new PinkSilkFlossFloweringLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), CerradoBlocks.PINK_SILK_FLOSS_FRUITING_LEAVES));
    public static final RegistryObject<Block> PINK_SILK_FLOSS_FRUITING_LEAVES = registerBlock("silk_floss_pink_fruiting_leaves",
            () -> new PinkSilkFlossFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), CerradoBlocks.PINK_SILK_FLOSS_LEAVES));
    public static final RegistryObject<Block> PINK_SILK_FLOSS_SAPLING = registerBlock("silk_floss_pink_sapling",
            PinkSilkFlossSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_PINK_SILK_FLOSS_SAPLING = BLOCKS.register("potted_silk_floss_pink_sapling",
            () -> new FlowerPotBlock(CerradoBlocks.PINK_SILK_FLOSS_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance()));


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

