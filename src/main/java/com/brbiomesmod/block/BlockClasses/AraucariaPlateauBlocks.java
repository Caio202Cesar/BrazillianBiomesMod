package com.brbiomesmod.block.BlockClasses;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.block.*;
import com.brbiomesmod.block.Custom.Leaves.*;
import com.brbiomesmod.block.Custom.Log.ModLogs;
import com.brbiomesmod.block.Saplings.*;
import com.brbiomesmod.item.ModItemGroup;
import com.brbiomesmod.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.potion.Effects;
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


    public static final RegistryObject<Block> PARANA_PINE_LOG = registerBlock("parana_pine_log",
            ModLogs::new);
    public static final RegistryObject<Block> PARANA_PINE_LEAVES = registerBlock("parana_pine_leaves",
            () -> new ParanaPineLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), AraucariaPlateauBlocks.PARANA_PINE_FRUITING_LEAVES));
    public static final RegistryObject<Block> PARANA_PINE_FRUITING_LEAVES = registerBlock("parana_pine_fruiting_leaves",
            () -> new ParanaPineFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), AraucariaPlateauBlocks.PARANA_PINE_LEAVES));
    public static final RegistryObject<Block> PARANA_PINE_WOOD = registerBlock("parana_pine_wood",
            ModLogs::new);
    public static final RegistryObject<Block> PARANA_PINE_PLANKS = registerBlock("parana_pine_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> PARANA_PINE_SLAB = registerBlock("parana_pine_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> PARANA_PINE_STAIRS = registerBlock("parana_pine_stairs",
            () -> new StairsBlock(() -> PARANA_PINE_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> PARANA_PINE_FENCE = registerBlock("parana_pine_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> PARANA_PINE_FENCE_GATE = registerBlock("parana_pine_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> PARANA_PINE_SAPLING = registerBlock("parana_pine_sapling",
            ParanaPineSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_PARANA_PINE_SAPLING = BLOCKS.register("potted_parana_pine_sapling",
            () -> new FlowerPotBlock(AraucariaPlateauBlocks.PARANA_PINE_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


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
    public static final RegistryObject<Block> IMBUIA_SLAB = registerBlock("imbuia_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> IMBUIA_STAIRS = registerBlock("imbuia_stairs",
            () -> new StairsBlock(() -> IMBUIA_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> IMBUIA_FENCE = registerBlock("imbuia_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> IMBUIA_FENCE_GATE = registerBlock("imbuia_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_IMBUIA_SAPLING = BLOCKS.register("potted_imbuia_sapling",
            () -> new FlowerPotBlock(AraucariaPlateauBlocks.IMBUIA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> YERBA_MATE_LOG = registerBlock("yerba_mate_log",
            ModLogs::new);
    public static final RegistryObject<Block> YERBA_MATE_WOOD = registerBlock("yerba_mate_wood",
            ModLogs::new);
    public static final RegistryObject<Block> YERBA_MATE_LEAVES = registerBlock("yerba_mate_leaves",
            YerbaMateLeaves::new);
    public static final RegistryObject<Block> YERBA_MATE_PLANKS = registerBlock("yerba_mate_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> YERBA_MATE_SAPLING = registerBlock("yerba_mate_sapling",
            YerbaMateSapling::new);
    public static final RegistryObject<Block> YERBA_MATE_SLAB = registerBlock("yerba_mate_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> YERBA_MATE_STAIRS = registerBlock("yerba_mate_stairs",
            () -> new StairsBlock(() -> YERBA_MATE_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> YERBA_MATE_FENCE = registerBlock("yerba_mate_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> YERBA_MATE_FENCE_GATE = registerBlock("yerba_mate_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_YERBA_MATE_SAPLING = BLOCKS.register("potted_yerba_mate_sapling",
            () -> new FlowerPotBlock(AraucariaPlateauBlocks.YERBA_MATE_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> FEIJOA_LOG = registerBlock("feijoa_log",
            ModLogs::new);
    public static final RegistryObject<Block> FEIJOA_WOOD = registerBlock("feijoa_wood",
            ModLogs::new);
    public static final RegistryObject<Block> FEIJOA_LEAVES = registerBlock("feijoa_leaves",
            () -> new FeijoaLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), AraucariaPlateauBlocks.FEIJOA_FLOWERING_LEAVES));
    public static final RegistryObject<Block> FEIJOA_FLOWERING_LEAVES = registerBlock("feijoa_flowering_leaves",
            () -> new FeijoaFloweringLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), AraucariaPlateauBlocks.FEIJOA_FRUITING_LEAVES));
    public static final RegistryObject<Block> FEIJOA_FRUITING_LEAVES = registerBlock("feijoa_fruiting_leaves",
            () -> new FeijoaFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), AraucariaPlateauBlocks.FEIJOA_LEAVES));
    public static final RegistryObject<Block> FEIJOA_PLANKS = registerBlock("feijoa_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> FEIJOA_SAPLING = registerBlock("feijoa_sapling",
            FeijoaSapling::new);
    public static final RegistryObject<Block> FEIJOA_SLAB = registerBlock("feijoa_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> FEIJOA_STAIRS = registerBlock("feijoa_stairs",
            () -> new StairsBlock(() -> FEIJOA_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> FEIJOA_FENCE = registerBlock("feijoa_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> FEIJOA_FENCE_GATE = registerBlock("feijoa_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_FEIJOA_SAPLING = BLOCKS.register("potted_feijoa_sapling",
            () -> new FlowerPotBlock(AraucariaPlateauBlocks.FEIJOA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> RIO_GRANDE_CHERRY_LEAVES = registerBlock("rio_grande_cherry_leaves",
            () -> new RioGrandeCherryLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), AraucariaPlateauBlocks.RIO_GRANDE_CHERRY_FLOWERING_LEAVES));
    public static final RegistryObject<Block> RIO_GRANDE_CHERRY_FLOWERING_LEAVES = registerBlock("rio_grande_cherry_flowering_leaves",
            () -> new RioGrandeCherryFloweringLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), AraucariaPlateauBlocks.RIO_GRANDE_CHERRY_FRUITING_LEAVES));
    public static final RegistryObject<Block> RIO_GRANDE_CHERRY_FRUITING_LEAVES = registerBlock("rio_grande_cherry_fruiting_leaves",
            () -> new RioGrandeCherryFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), AraucariaPlateauBlocks.RIO_GRANDE_CHERRY_LEAVES));
    public static final RegistryObject<Block> RIO_GRANDE_CHERRY_SAPLING = registerBlock("rio_grande_cherry_sapling",
            RioGrandeCherrySapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_RIO_GRANDE_CHERRY_SAPLING = BLOCKS.register("potted_rio_grande_cherry_sapling",
            () -> new FlowerPotBlock(AraucariaPlateauBlocks.RIO_GRANDE_CHERRY_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> XAXIM_PLANT = registerBlock("xaxim_plant",
            XaximPlant::new);

    public static final RegistryObject<Block> CATTLEYA_COCCINEA = registerBlock("cattleya_coccinea",
            () -> new FlowerBlock(Effects.NIGHT_VISION, 6, AbstractBlock.Properties.from(Blocks.CORNFLOWER)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_CATTLEYA_COCCINEA = BLOCKS.register("potted_cattleya_coccinea",
            () -> new FlowerPotBlock(AraucariaPlateauBlocks.CATTLEYA_COCCINEA.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


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
