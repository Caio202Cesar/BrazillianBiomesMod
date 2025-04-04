package com.brbiomesmod.block.BlockClasses;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.block.*;
import com.brbiomesmod.block.Custom.Log.JabuticabaFloweringLog;
import com.brbiomesmod.block.Custom.Log.JabuticabaFruitingLog;
import com.brbiomesmod.block.Custom.Leaves.*;
import com.brbiomesmod.block.Custom.Log.JabuticabaLog;
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

public class AtlanticForestBlocks {
    public static List<Block> blocksList = new ArrayList<>();

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, BrazillianBiomesMod.MOD_ID);

    public static final RegistryObject<Block> QUEEN_PALM_LOG = registerBlock("queen_palm_log",
            ModLogs::new);
    public static final RegistryObject<Block> QUEEN_PALM_LEAVES = registerBlock("queen_palm_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> QUEEN_PALM_SAPLING = registerBlock("queen_palm_sapling",
            QueenPalmSapling::new);

    public static final RegistryObject<Block> JUSSARA_LEAVES = registerBlock("jussara_leaves",
            () -> new AcaiLeaves(AbstractBlock.Properties.create(Material.LEAVES)
                    .hardnessAndResistance(0.2f)
                    .tickRandomly() // Enables random ticks
                    .notSolid()
                    .sound(SoundType.PLANT)));
    public static final RegistryObject<Block> JUSSARA_SAPLING = registerBlock("jussara_sapling",
            JussaraSapling::new);

    public static final RegistryObject<Block> BRAZILWOOD_LOG = registerBlock("brazilwood_log",
            ModLogs::new);
    public static final RegistryObject<Block> BRAZILWOOD_WOOD = registerBlock("brazilwood_wood",
            ModLogs::new);
    public static final RegistryObject<Block> BRAZILWOOD_PLANKS = registerBlock("brazilwood_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> BRAZILWOOD_LEAVES = registerBlock("brazilwood_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> BRAZILWOOD_SAPLING = registerBlock("brazilwood_sapling",
            BrazilwoodSapling::new);
    public static final RegistryObject<Block> BRAZILWOOD_SLAB = registerBlock("brazilwood_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> BRAZILWOOD_STAIRS = registerBlock("brazilwood_stairs",
            () -> new StairsBlock(() -> BRAZILWOOD_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> BRAZILWOOD_FENCE = registerBlock("brazilwood_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> BRAZILWOOD_FENCE_GATE = registerBlock("brazilwood_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_BRAZILWOOD_SAPLING = BLOCKS.register("potted_brazilwood_sapling",
            () -> new FlowerPotBlock(AtlanticForestBlocks.BRAZILWOOD_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> JABUTICABA_LOG = registerBlock("jabuticaba_log",
            JabuticabaLog::new);
    public static final RegistryObject<Block> JABUTICABA_WOOD = registerBlock("jabuticaba_wood",
            ModLogs::new);
    public static final RegistryObject<Block> JABUTICABA_FLOWERING_LOG = registerBlock("jabuticaba_flowering_log",
            JabuticabaFloweringLog::new);
    public static final RegistryObject<Block> JABUTICABA_FRUITING_LOG = registerBlock("jabuticaba_fruiting_log",
            JabuticabaFruitingLog::new);
    public static final RegistryObject<Block> JABUTICABA_LEAVES = registerBlock("jabuticaba_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> JABUTICABA_PLANKS = registerBlock("jabuticaba_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> JABUTICABA_SAPLING = registerBlock("jabuticaba_sapling",
            JabuticabaSapling::new);
    public static final RegistryObject<Block> JABUTICABA_SLAB = registerBlock("jabuticaba_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> JABUTICABA_STAIRS = registerBlock("jabuticaba_stairs",
            () -> new StairsBlock(() -> JABUTICABA_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> JABUTICABA_FENCE = registerBlock("jabuticaba_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> JABUTICABA_FENCE_GATE = registerBlock("jabuticaba_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_JABUTICABA_SAPLING = BLOCKS.register("potted_jabuticaba_sapling",
            () -> new FlowerPotBlock(AtlanticForestBlocks.JABUTICABA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> CAMBUCI_LOG = registerBlock("cambuci_log",
            ModLogs::new);
    public static final RegistryObject<Block> CAMBUCI_WOOD = registerBlock("cambuci_wood",
            ModLogs::new);
    public static final RegistryObject<Block> CAMBUCI_PLANKS = registerBlock("cambuci_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> CAMBUCI_LEAVES = registerBlock("cambuci_leaves",
            () -> new CambuciLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), AtlanticForestBlocks.CAMBUCI_FLOWERING_LEAVES));
    public static final RegistryObject<Block> CAMBUCI_FLOWERING_LEAVES = registerBlock("cambuci_flowering_leaves",
            () -> new CambuciFloweringLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), AtlanticForestBlocks.CAMBUCI_FRUITING_LEAVES));
    public static final RegistryObject<Block> CAMBUCI_FRUITING_LEAVES = registerBlock("cambuci_fruiting_leaves",
            () -> new CambuciFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), AtlanticForestBlocks.CAMBUCI_LEAVES));
    public static final RegistryObject<Block> CAMBUCI_SAPLING = registerBlock("cambuci_sapling",
            CambuciSapling::new);
    public static final RegistryObject<Block> CAMBUCI_SLAB = registerBlock("cambuci_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> CAMBUCI_STAIRS = registerBlock("cambuci_stairs",
            () -> new StairsBlock(() -> CAMBUCI_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> CAMBUCI_FENCE = registerBlock("cambuci_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> CAMBUCI_FENCE_GATE = registerBlock("cambuci_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_CAMBUCI_SAPLING = BLOCKS.register("potted_cambuci_sapling",
            () -> new FlowerPotBlock(AtlanticForestBlocks.CAMBUCI_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> CECROPIA_LOG = registerBlock("cecropia_log",
            ModLogs::new);
    public static final RegistryObject<Block> CECROPIA_WOOD = registerBlock("cecropia_wood",
            ModLogs::new);
    public static final RegistryObject<Block> CECROPIA_SILVER_LEAVES = registerBlock("cecropia_silver_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> CECROPIA_SILVER_SAPLING = registerBlock("cecropia_silver_sapling",
            SilverCecropiaSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_CECROPIA_SILVER_SAPLING = BLOCKS.register("potted_cecropia_silver_sapling",
            () -> new FlowerPotBlock(AtlanticForestBlocks.CECROPIA_SILVER_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> CECROPIA_LEAVES = registerBlock("cecropia_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> CECROPIA_SAPLING = registerBlock("cecropia_sapling",
            CecropiaSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_CECROPIA_SAPLING = BLOCKS.register("potted_cecropia_sapling",
            () -> new FlowerPotBlock(AtlanticForestBlocks.CECROPIA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


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
    public static final RegistryObject<Block> BRAZILLIAN_SASSAFRAS_SLAB = registerBlock("brazillian_sassafras_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> BRAZILLIAN_SASSAFRAS_STAIRS = registerBlock("brazillian_sassafras_stairs",
            () -> new StairsBlock(() -> BRAZILLIAN_SASSAFRAS_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> BRAZILLIAN_SASSAFRAS_FENCE = registerBlock("brazillian_sassafras_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> BRAZILLIAN_SASSAFRAS_FENCE_GATE = registerBlock("brazillian_sassafras_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_BRAZILLIAN_SASSAFRAS_SAPLING = BLOCKS.register("potted_brazillian_sassafras_sapling",
            () -> new FlowerPotBlock(AtlanticForestBlocks.BRAZILLIAN_SASSAFRAS_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> MANACA_DA_SERRA_LOG = registerBlock("manaca_da_serra_log",
            ModLogs::new);
    public static final RegistryObject<Block> MANACA_DA_SERRA_WOOD = registerBlock("manaca_da_serra_wood",
            ModLogs::new);
    public static final RegistryObject<Block> MANACA_DA_SERRA_LEAVES = registerBlock("manaca_da_serra_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> MANACA_DA_SERRA_PLANKS = registerBlock("manaca_da_serra_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> MANACA_DA_SERRA_SAPLING = registerBlock("manaca_da_serra_sapling",
            ManacaSapling::new);
    public static final RegistryObject<Block> MANACA_DA_SERRA_SLAB = registerBlock("manaca_da_serra_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> MANACA_DA_SERRA_STAIRS = registerBlock("manaca_da_serra_stairs",
            () -> new StairsBlock(() -> MANACA_DA_SERRA_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> MANACA_DA_SERRA_FENCE = registerBlock("manaca_da_serra_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> MANACA_DA_SERRA_FENCE_GATE = registerBlock("manaca_da_serra_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_MANACA_DA_SERRA_SAPLING = BLOCKS.register("potted_manaca_da_serra_sapling",
            () -> new FlowerPotBlock(AtlanticForestBlocks.MANACA_DA_SERRA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> IPE_LOG = registerBlock("ipe_log",
            ModLogs::new);
    public static final RegistryObject<Block> IPE_WOOD = registerBlock("ipe_wood",
            ModLogs::new);
    public static final RegistryObject<Block> IPE_PLANKS = registerBlock("ipe_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> IPE_SLAB = registerBlock("ipe_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> IPE_STAIRS = registerBlock("ipe_stairs",
            () -> new StairsBlock(() -> IPE_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> IPE_FENCE = registerBlock("ipe_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> IPE_FENCE_GATE = registerBlock("ipe_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> YELLOW_IPE_BLOSSOM = registerBlock("yellow_ipe_blossom",
            ModLeaves::new);
    public static final RegistryObject<Block> YELLOW_IPE_SAPLING = registerBlock("yellow_ipe_sapling",
            YellowIpeSapling::new);
    public static final RegistryObject<Block> PURPLE_IPE_BLOSSOM = registerBlock("purple_ipe_blossom",
            ModLeaves::new);
    public static final RegistryObject<Block> PURPLE_IPE_SAPLING = registerBlock("purple_ipe_sapling",
            PurpleIpeSapling::new);
    public static final RegistryObject<Block> APRICOT_IPE_BLOSSOM = registerBlock("apricot_ipe_blossom",
            ModLeaves::new);
    public static final RegistryObject<Block> APRICOT_IPE_SAPLING = registerBlock("apricot_ipe_sapling",
            ApricotIpeSapling::new);
    public static final RegistryObject<Block> PINK_IPE_BLOSSOM = registerBlock("pink_ipe_blossom",
            ModLeaves::new);
    public static final RegistryObject<Block> PINK_IPE_SAPLING = registerBlock("pink_ipe_sapling",
            PinkIpeSapling::new);
    public static final RegistryObject<Block> WHITE_IPE_BLOSSOM = registerBlock("white_ipe_blossom",
            ModLeaves::new);
    public static final RegistryObject<Block> WHITE_IPE_SAPLING = registerBlock("white_ipe_sapling",
            WhiteIpeSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_YELLOW_IPE_SAPLING = BLOCKS.register("potted_yellow_ipe_sapling",
            () -> new FlowerPotBlock(AtlanticForestBlocks.YELLOW_IPE_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_PURPLE_IPE_SAPLING = BLOCKS.register("potted_purple_ipe_sapling",
            () -> new FlowerPotBlock(AtlanticForestBlocks.PURPLE_IPE_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_APRICOT_IPE_SAPLING = BLOCKS.register("potted_apricot_ipe_sapling",
            () -> new FlowerPotBlock(AtlanticForestBlocks.APRICOT_IPE_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_PINK_IPE_SAPLING = BLOCKS.register("potted_pink_ipe_sapling",
            () -> new FlowerPotBlock(AtlanticForestBlocks.PINK_IPE_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_WHITE_IPE_SAPLING = BLOCKS.register("potted_white_ipe_sapling",
            () -> new FlowerPotBlock(AtlanticForestBlocks.WHITE_IPE_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> EUGENIA_LOG = registerBlock("eugenia_log",
            ModLogs::new);
    public static final RegistryObject<Block> EUGENIA_WOOD = registerBlock("eugenia_wood",
            ModLogs::new);
    public static final RegistryObject<Block> EUGENIA_PLANKS = registerBlock("eugenia_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> EUGENIA_SLAB = registerBlock("eugenia_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> EUGENIA_STAIRS = registerBlock("eugenia_stairs",
            () -> new StairsBlock(() -> EUGENIA_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> EUGENIA_FENCE = registerBlock("eugenia_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> EUGENIA_FENCE_GATE = registerBlock("eugenia_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> PITANGA_LEAVES = registerBlock("pitanga_leaves",
            () -> new PitangaLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), AtlanticForestBlocks.PITANGA_FLOWERING_LEAVES));
    public static final RegistryObject<Block> PITANGA_FLOWERING_LEAVES = registerBlock("pitanga_flowering_leaves",
            () -> new PitangaFloweringLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), AtlanticForestBlocks.PITANGA_FRUITING_LEAVES));
    public static final RegistryObject<Block> PITANGA_FRUITING_LEAVES = registerBlock("pitanga_fruiting_leaves",
            () -> new PitangaFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), AtlanticForestBlocks.PITANGA_LEAVES));
    public static final RegistryObject<Block> BLACK_PITANGA_LEAVES = registerBlock("pitanga_black_leaves",
            () -> new BlackPitangaLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), AtlanticForestBlocks.BLACK_PITANGA_FLOWERING_LEAVES));
    public static final RegistryObject<Block> BLACK_PITANGA_FLOWERING_LEAVES = registerBlock("pitanga_black_flowering_leaves",
            () -> new BlackPitangaFloweringLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), AtlanticForestBlocks.BLACK_PITANGA_FRUITING_LEAVES));
    public static final RegistryObject<Block> BLACK_PITANGA_FRUITING_LEAVES = registerBlock("pitanga_black_fruiting_leaves",
            () -> new BlackPitangaFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), AtlanticForestBlocks.BLACK_PITANGA_LEAVES));
    public static final RegistryObject<Block> PITANGA_SAPLING = registerBlock("pitanga_sapling",
            PitangaSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_PITANGA_SAPLING = BLOCKS.register("potted_pitanga_sapling",
            () -> new FlowerPotBlock(AtlanticForestBlocks.PITANGA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> PINK_PEROBA_LOG = registerBlock("pink_peroba_log",
            ModLogs::new);
    public static final RegistryObject<Block> PINK_PEROBA_WOOD = registerBlock("pink_peroba_wood",
            ModLogs::new);
    public static final RegistryObject<Block> PINK_PEROBA_PLANKS = registerBlock("pink_peroba_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> PINK_PEROBA_LEAVES = registerBlock("pink_peroba_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> PINK_PEROBA_SAPLING = registerBlock("pink_peroba_sapling",
            PinkPerobaSapling::new);
    public static final RegistryObject<Block> PINK_PEROBA_SLAB = registerBlock("pink_peroba_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> PINK_PEROBA_STAIRS = registerBlock("pink_peroba_stairs",
            () -> new StairsBlock(() -> PINK_PEROBA_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> PINK_PEROBA_FENCE = registerBlock("pink_peroba_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> PINK_PEROBA_FENCE_GATE = registerBlock("pink_peroba_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_PINK_PEROBA_SAPLING = BLOCKS.register("potted_pink_peroba_sapling",
            () -> new FlowerPotBlock(AtlanticForestBlocks.PINK_PEROBA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> JEQUITIBA_LOG = registerBlock("jequitiba_log",
            ModLogs::new);
    public static final RegistryObject<Block> JEQUITIBA_WOOD = registerBlock("jequitiba_wood",
            ModLogs::new);
    public static final RegistryObject<Block> JEQUITIBA_PLANKS = registerBlock("jequitiba_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> JEQUITIBA_LEAVES = registerBlock("jequitiba_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> JEQUITIBA_SAPLING = registerBlock("jequitiba_sapling",
            JequitibaSapling::new);
    public static final RegistryObject<Block> JEQUITIBA_SLAB = registerBlock("jequitiba_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> JEQUITIBA_STAIRS = registerBlock("jequitiba_stairs",
            () -> new StairsBlock(() -> JEQUITIBA_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> JEQUITIBA_FENCE = registerBlock("jequitiba_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> JEQUITIBA_FENCE_GATE = registerBlock("jequitiba_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_JEQUITIBA_SAPLING = BLOCKS.register("potted_jequitiba_sapling",
            () -> new FlowerPotBlock(AtlanticForestBlocks.JEQUITIBA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> BRAZILLIAN_ROSEWOOD_LOG = registerBlock("brazillian_rosewood_log",
            ModLogs::new);
    public static final RegistryObject<Block> BRAZILLIAN_ROSEWOOD_WOOD = registerBlock("brazillian_rosewood_wood",
            ModLogs::new);
    public static final RegistryObject<Block> BRAZILLIAN_ROSEWOOD_PLANKS = registerBlock("brazillian_rosewood_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> BRAZILLIAN_ROSEWOOD_LEAVES = registerBlock("brazillian_rosewood_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> BRAZILLIAN_ROSEWOOD_SAPLING = registerBlock("brazillian_rosewood_sapling",
            BrazillianRosewoodSapling::new);
    public static final RegistryObject<Block> BRAZILLIAN_ROSEWOOD_SLAB = registerBlock("brazillian_rosewood_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> BRAZILLIAN_ROSEWOOD_STAIRS = registerBlock("brazillian_rosewood_stairs",
            () -> new StairsBlock(() -> BRAZILLIAN_ROSEWOOD_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> BRAZILLIAN_ROSEWOOD_FENCE = registerBlock("brazillian_rosewood_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> BRAZILLIAN_ROSEWOOD_FENCE_GATE = registerBlock("brazillian_rosewood_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_BRAZILLIAN_ROSEWOOD_SAPLING = BLOCKS.register("potted_brazillian_rosewood_sapling",
            () -> new FlowerPotBlock(AtlanticForestBlocks.BRAZILLIAN_ROSEWOOD_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> SAPUCAIA_LOG = registerBlock("sapucaia_log",
            ModLogs::new);
    public static final RegistryObject<Block> SAPUCAIA_WOOD = registerBlock("sapucaia_wood",
            ModLogs::new);
    public static final RegistryObject<Block> SAPUCAIA_PLANKS = registerBlock("sapucaia_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> SAPUCAIA_LEAVES = registerBlock("sapucaia_leaves",
            () -> new SapucaiaLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), AtlanticForestBlocks.SAPUCAIA_FRUITING_LEAVES));
    public static final RegistryObject<Block> SAPUCAIA_FLOWERING_LEAVES = registerBlock("sapucaia_flowering_leaves",
            () -> new SapucaiaFloweringLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), AtlanticForestBlocks.SAPUCAIA_LEAVES));
    public static final RegistryObject<Block> SAPUCAIA_FRUITING_LEAVES = registerBlock("sapucaia_fruiting_leaves",
            () -> new SapucaiaFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), AtlanticForestBlocks.SAPUCAIA_FLOWERING_LEAVES));
    public static final RegistryObject<Block> SAPUCAIA_SAPLING = registerBlock("sapucaia_sapling",
            SapucaiaSapling::new);
    public static final RegistryObject<Block> SAPUCAIA_SLAB = registerBlock("sapucaia_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> SAPUCAIA_STAIRS = registerBlock("sapucaia_stairs",
            () -> new StairsBlock(() -> SAPUCAIA_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> SAPUCAIA_FENCE = registerBlock("sapucaia_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> SAPUCAIA_FENCE_GATE = registerBlock("sapucaia_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_SAPUCAIA_SAPLING = BLOCKS.register("potted_sapucaia_sapling",
            () -> new FlowerPotBlock(AtlanticForestBlocks.SAPUCAIA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));

    public static final RegistryObject<Block> WHITE_ANGEL_TRUMPET = registerBlock("angel_trumpet_white",
            AngelTrumpetPlant::new);
    public static final RegistryObject<Block> PINK_ANGEL_TRUMPET = registerBlock("angel_trumpet_pink",
            AngelTrumpetPlant::new);
    public static final RegistryObject<Block> YELLOW_ANGEL_TRUMPET = registerBlock("angel_trumpet_yellow",
            AngelTrumpetPlant::new);
    public static final RegistryObject<Block> SALMON_ANGEL_TRUMPET = registerBlock("angel_trumpet_salmon",
            AngelTrumpetPlant::new);
    public static final RegistryObject<Block> ORANGE_ANGEL_TRUMPET = registerBlock("angel_trumpet_orange",
            AngelTrumpetPlant::new);

    public static final RegistryObject<Block> PASSION_FRUIT_VINE = registerBlock("passion_fruit_vine",
            PassionfruitVine::new);
    public static final RegistryObject<Block> PASSION_FRUIT_FLOWERING_VINE = registerBlock("passion_fruit_flowering_vine",
            PassionfruitFloweringVine::new);
    public static final RegistryObject<Block> PASSION_FRUIT_FRUITING_VINE = registerBlock("passion_fruit_fruiting_vine",
            PassionfruitFruitingVine::new);
    public static final RegistryObject<Block> BRAZILLIAN_DUTCHMAN_PIPE_VINE = registerBlock("brazillian_dutchman_pipe_vine",
            AristolochiaVine::new);
    public static final RegistryObject<Block> TILLANDSIA_STRICTA = registerBlock("tillandsia_stricta",
            EpiphytePlant::new);


    public static final RegistryObject<Block> CATTLEYA_PURPURATA = registerBlock("cattleya_purpurata",
            () -> new FlowerBlock(Effects.JUMP_BOOST, 6, AbstractBlock.Properties.from(Blocks.CORNFLOWER)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_CATTLEYA_PURPURATA = BLOCKS.register("potted_cattleya_purpurata",
            () -> new FlowerPotBlock(AtlanticForestBlocks.CATTLEYA_PURPURATA.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));

    public static final RegistryObject<Block> CATTLEYA_LADY_ACKLAND = registerBlock("cattleya_lady_ackland",
            () -> new FlowerBlock(Effects.NIGHT_VISION, 6, AbstractBlock.Properties.from(Blocks.CORNFLOWER)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_CATTLEYA_LADY_ACKLAND = BLOCKS.register("potted_cattleya_lady_ackland",
            () -> new FlowerPotBlock(AtlanticForestBlocks.CATTLEYA_LADY_ACKLAND.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));

    public static final RegistryObject<Block> SILVER_VASE_BROMELIAD = registerBlock("silver_vase_bromeliad",
            EpiphytePlant::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_SILVER_VASE_BROMELIAD = BLOCKS.register("potted_silver_vase_bromeliad",
            () -> new FlowerPotBlock(AtlanticForestBlocks.SILVER_VASE_BROMELIAD.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));

    public static final RegistryObject<Block> FIREBALL_NEOREGELIA = registerBlock("fireball_neoregelia",
            EpiphytePlant::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_FIREBALL_NEOREGELIA = BLOCKS.register("potted_fireball_neoregelia",
            () -> new FlowerPotBlock(AtlanticForestBlocks.FIREBALL_NEOREGELIA.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));

    public static final RegistryObject<Block> AECHMEA_ALBA = registerBlock("aechmea_alba",
            EpiphytePlant::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_AECHMEA_ALBA = BLOCKS.register("potted_aechmea_alba",
            () -> new FlowerPotBlock(AtlanticForestBlocks.AECHMEA_ALBA.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));

    public static final RegistryObject<Block> NEOREGELIA_MARMORATA = registerBlock("neoregelia_marmorata",
            EpiphytePlant::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_NEOREGELIA_MARMORATA = BLOCKS.register("potted_neoregelia_marmorata",
            () -> new FlowerPotBlock(AtlanticForestBlocks.NEOREGELIA_MARMORATA.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));

    public static final RegistryObject<Block> RED_GUZMANIA = registerBlock("red_guzmania",
            EpiphytePlant::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_RED_GUZMANIA = BLOCKS.register("potted_red_guzmania",
            () -> new FlowerPotBlock(AtlanticForestBlocks.RED_GUZMANIA.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));

    public static final RegistryObject<Block> PINK_GUZMANIA = registerBlock("pink_guzmania",
            EpiphytePlant::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_PINK_GUZMANIA = BLOCKS.register("potted_pink_guzmania",
            () -> new FlowerPotBlock(AtlanticForestBlocks.PINK_GUZMANIA.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));

    public static final RegistryObject<Block> YELLOW_GUZMANIA = registerBlock("yellow_guzmania",
            EpiphytePlant::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_YELLOW_GUZMANIA = BLOCKS.register("potted_yellow_guzmania",
            () -> new FlowerPotBlock(AtlanticForestBlocks.YELLOW_GUZMANIA.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));

    public static final RegistryObject<Block> ORANGE_GUZMANIA = registerBlock("orange_guzmania",
            EpiphytePlant::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_ORANGE_GUZMANIA = BLOCKS.register("potted_orange_guzmania",
            () -> new FlowerPotBlock(AtlanticForestBlocks.ORANGE_GUZMANIA.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.ATLANTIC_FOREST_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

