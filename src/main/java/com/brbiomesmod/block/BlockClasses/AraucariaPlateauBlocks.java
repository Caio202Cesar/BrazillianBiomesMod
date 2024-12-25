package com.brbiomesmod.block.BlockClasses;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.block.*;
import com.brbiomesmod.block.Saplings.*;
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

public class AraucariaPlateauBlocks {
    public static List<Block> blocksList = new ArrayList<>();

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, BrazillianBiomesMod.MOD_ID);


    public static final RegistryObject<Block> BRAZILLIAN_SASSAFRAS_LOG = registerBlock("brazillian_sassafras_log",
            ModLogs::new);
    public static final RegistryObject<Block> BRAZILLIAN_SASSAFRAS_WOOD = registerBlock("brazillian_sassafras_wood",
            ModLogs::new);
    public static final RegistryObject<Block> BRAZILLIAN_SASSAFRAS_PLANKS = registerBlock("brazillian_sassafras_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> BRAZILLIAN_SASSAFRAS_LEAVES = registerBlock("brazillian_sassafras_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> BRAZILLIAN_SASSAFRAS_SAPLING = registerBlock("brazillian_sassafras_sapling",
            BrazillianSassafrasSapling::new);
    public static final RegistryObject<Block> BRAZILLIAN_SASSAFRAS_STAIRS = registerBlock("brazillian_sassafras_stairs",
            () -> new StairsBlock(() -> BRAZILLIAN_SASSAFRAS_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> BRAZILLIAN_SASSAFRAS_FENCE = registerBlock("brazillian_sassafras_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));

    public static final RegistryObject<Block> BRAZILLIAN_SASSAFRAS_FENCE_GATE = registerBlock("brazillian_sassafras_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));


    public static final RegistryObject<Block> PARANA_PINE_LOG = registerBlock("parana_pine_log",
            ModLogs::new);
    public static final RegistryObject<Block> PARANA_PINE_WOOD = registerBlock("parana_pine_wood",
            ModLogs::new);
    public static final RegistryObject<Block> PARANA_PINE_PLANKS = registerBlock("parana_pine_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> PARANA_PINE_LEAVES = registerBlock("parana_pine_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> PARANA_PINE_SAPLING = registerBlock("parana_pine_sapling",
            ParanaPineSapling::new);
    public static final RegistryObject<Block> PARANA_PINE_STAIRS = registerBlock("parana_pine_stairs",
            () -> new StairsBlock(() -> PARANA_PINE_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> PARANA_PINE_FENCE = registerBlock("parana_pine_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));

    public static final RegistryObject<Block> PARANA_PINE_FENCE_GATE = registerBlock("parana_pine_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));


    public static final RegistryObject<Block> IMBUIA_LOG = registerBlock("imbuia_log",
            ModLogs::new);
    public static final RegistryObject<Block> IMBUIA_WOOD = registerBlock("imbuia_wood",
            ModLogs::new);
    public static final RegistryObject<Block> IMBUIA_PLANKS = registerBlock("imbuia_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> IMBUIA_LEAVES = registerBlock("imbuia_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> IMBUIA_SAPLING = registerBlock("imbuia_sapling",
            ImbuiaSapling::new);
    public static final RegistryObject<Block> IMBUIA_STAIRS = registerBlock("imbuia_stairs",
            () -> new StairsBlock(() -> IMBUIA_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> IMBUIA_FENCE = registerBlock("imbuia_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));

    public static final RegistryObject<Block> IMBUIA_FENCE_GATE = registerBlock("imbuia_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));


    public static final RegistryObject<Block> YERBA_MATE_LOG = registerBlock("yerba_mate_log",
            ModLogs::new);
    public static final RegistryObject<Block> YERBA_MATE_WOOD = registerBlock("yerba_mate_wood",
            ModLogs::new);
    public static final RegistryObject<Block> YERBA_MATE_LEAVES = registerBlock("yerba_mate_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> YERBA_MATE_PLANKS = registerBlock("yerba_mate_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> YERBA_MATE_SAPLING = registerBlock("yerba_mate_sapling",
            YerbaMateSapling::new);
    public static final RegistryObject<Block> YERBA_MATE_STAIRS = registerBlock("yerba_mate_stairs",
            () -> new StairsBlock(() -> YERBA_MATE_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> IMBUIA_FENCE = registerBlock("imbuia_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));

    public static final RegistryObject<Block> IMBUIA_FENCE_GATE = registerBlock("imbuia_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));


    public static final RegistryObject<Block> FEIJOA_LOG = registerBlock("feijoa_log",
            ModLogs::new);
    public static final RegistryObject<Block> FEIJOA_WOOD = registerBlock("feijoa_wood",
            ModLogs::new);
    public static final RegistryObject<Block> FEIJOA_LEAVES = registerBlock("feijoa_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> FEIJOA_PLANKS = registerBlock("feijoa_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> FEIJOA_SAPLING = registerBlock("feijoa_sapling",
            FeijoaSapling::new);
    public static final RegistryObject<Block> FEIJOA_STAIRS = registerBlock("feijoa_stairs",
            () -> new StairsBlock(() -> FEIJOA_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> IMBUIA_FENCE = registerBlock("imbuia_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));

    public static final RegistryObject<Block> IMBUIA_FENCE_GATE = registerBlock("imbuia_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));


    public static final RegistryObject<Block> RIO_GRANDE_CHERRY_LEAVES = registerBlock("rio_grande_cherry_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> RIO_GRANDE_CHERRY_SAPLING = registerBlock("rio_grande_cherry_sapling",
            RioGrandeCherrySapling::new);


    public static final RegistryObject<Block> XAXIM_PLANT = registerBlock("xaxim_plant",
            XaximPlant::new);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.ARAUCARIA_PLATEAU_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
