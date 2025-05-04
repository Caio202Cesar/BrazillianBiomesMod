package com.brbiomesmod.block.BlockClasses;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.block.*;
import com.brbiomesmod.block.Custom.Leaves.*;
import com.brbiomesmod.block.Custom.Log.ModLogs;
import com.brbiomesmod.block.Custom.Log.PalmitoLog;
import com.brbiomesmod.block.Custom.Log.SilkFlossLog;
import com.brbiomesmod.block.Saplings.*;
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

public class WoodGroup {
    public static List<Block> blocksList = new ArrayList<>();

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, BrazillianBiomesMod.MOD_ID);


    public static final RegistryObject<Block> KAPOK_WOOD = registerBlock("kapok_wood",
            ModLogs::new);
    public static final RegistryObject<Block> SILK_FLOSS_WOOD = registerBlock("silk_floss_thornless_wood",
            ModLogs::new);
    public static final RegistryObject<Block> SILK_FLOSS_THORNY_WOOD = registerBlock("silk_floss_thorny_wood",
            SilkFlossLog::new);
    public static final RegistryObject<Block> BALSA_LOG = registerBlock("balsa_log",
            ModLogs::new);
    public static final RegistryObject<Block> BALSA_LEAVES = registerBlock("balsa_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> BALSA_PLANKS = registerBlock("balsa_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> BALSA_SAPLING = registerBlock("balsa_sapling",
            BalsaSapling::new);
    public static final RegistryObject<Block> BALSA_WOOD = registerBlock("balsa_wood",
            ModLogs::new);
    public static final RegistryObject<Block> BALSA_SLAB = registerBlock("balsa_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> BALSA_STAIRS = registerBlock("balsa_stairs",
            () -> new StairsBlock(() -> BALSA_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> BALSA_FENCE = registerBlock("balsa_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> BALSA_FENCE_GATE = registerBlock("balsa_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_BALSA_SAPLING = BLOCKS.register("potted_balsa_sapling",
            () -> new FlowerPotBlock(WoodGroup.BALSA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> LOPHANTERA_LOG = registerBlock("lophantera_log",
            ModLogs::new);
    public static final RegistryObject<Block> LOPHANTERA_LEAVES = registerBlock("lophantera_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> LOPHANTERA_PLANKS = registerBlock("lophantera_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> LOPHANTERA_SAPLING = registerBlock("lophantera_sapling",
            LophanteraSapling::new);
    public static final RegistryObject<Block> LOPHANTERA_WOOD = registerBlock("lophantera_wood",
            ModLogs::new);
    public static final RegistryObject<Block> LOPHANTERA_SLAB = registerBlock("lophantera_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> LOPHANTERA_STAIRS = registerBlock("lophantera_stairs",
            () -> new StairsBlock(() -> LOPHANTERA_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> LOPHANTERA_FENCE = registerBlock("lophantera_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> LOPHANTERA_FENCE_GATE = registerBlock("lophantera_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_LOPHANTERA_SAPLING = BLOCKS.register("potted_lophantera_sapling",
            () -> new FlowerPotBlock(WoodGroup.LOPHANTERA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    //Cupuacu and Guarana trunk is made of Jungle Log
    public static final RegistryObject<Block> CUPUACU_LEAVES = registerBlock("cupuacu_leaves",
            () -> new CupuacuLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), WoodGroup.CUPUACU_FRUITING_LEAVES));
    public static final RegistryObject<Block> CUPUACU_FRUITING_LEAVES = registerBlock("cupuacu_fruiting_leaves",
            () -> new CupuacuFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), WoodGroup.CUPUACU_FRUITING_LEAVES));
    public static final RegistryObject<Block> CUPUACU_SAPLING = registerBlock("cupuacu_sapling",
            CupuacuSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_CUPUACU_SAPLING = BLOCKS.register("potted_cupuacu_sapling",
            () -> new FlowerPotBlock(WoodGroup.CUPUACU_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> GUARANA_LEAVES = registerBlock("guarana_leaves",
            GuaranaLeaves::new);
    public static final RegistryObject<Block> GUARANA_SAPLING = registerBlock("guarana_sapling",
            GuaranaSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_GUARANA_SAPLING = BLOCKS.register("potted_guarana_sapling",
            () -> new FlowerPotBlock(WoodGroup.GUARANA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));





    public static final RegistryObject<Block> BANANA_LEAVES = registerBlock("banana_leaves",
            () -> new BananaLeaves(AbstractBlock.Properties.create(Material.LEAVES)
                    .hardnessAndResistance(0.2f)
                    .tickRandomly() // Enables random ticks
                    .notSolid()
                    .sound(SoundType.PLANT)));
    public static final RegistryObject<Block> BANANA_LOG = registerBlock("banana_log",
            PalmitoLog::new);
    public static final RegistryObject<Block> BANANA_SAPLING = registerBlock("banana_sapling",
            BananaSapling::new);
    public static final RegistryObject<Block> BANANA_FLOWER = registerBlock("banana_flower",
            BananaFlowerBlock::new); //Can be harvested and cooked
    public static final RegistryObject<Block> BANANA_BUNCH = registerBlock("banana_bunch",
            BananaBunchBlock::new);
    public static final RegistryObject<Block> BANANA_STALK = registerBlock("banana_stalk",
            BananaStalkBlock::new);

    public static final RegistryObject<Block> BRAZILNUT_LOG = registerBlock("brazilnut_log",
            ModLogs::new);
    public static final RegistryObject<Block> BRAZILNUT_LEAVES = registerBlock("brazilnut_leaves",
            BrazilnutLeaves::new);
    public static final RegistryObject<Block> BRAZILNUT_PLANKS = registerBlock("brazilnut_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> BRAZILNUT_SAPLING = registerBlock("brazilnut_sapling",
            BrazilnutSapling::new);
    public static final RegistryObject<Block> BRAZILNUT_WOOD = registerBlock("brazilnut_wood",
            ModLogs::new);
    public static final RegistryObject<Block> BRAZILNUT_SLAB = registerBlock("brazilnut_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> BRAZILNUT_STAIRS = registerBlock("brazilnut_stairs",
            () -> new StairsBlock(() -> BRAZILNUT_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> BRAZILNUT_FENCE = registerBlock("brazilnut_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> BRAZILNUT_FENCE_GATE = registerBlock("brazilnut_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_BRAZILNUT_SAPLING = BLOCKS.register("potted_brazilnut_sapling",
            () -> new FlowerPotBlock(WoodGroup.BRAZILNUT_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> SHARINGA_LOG = registerBlock("sharinga_log",
            ModLogs::new);
    public static final RegistryObject<Block> SHARINGA_LEAVES = registerBlock("sharinga_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> SHARINGA_PLANKS = registerBlock("sharinga_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> SHARINGA_SAPLING = registerBlock("sharinga_sapling",
            SharingaSapling::new);
    public static final RegistryObject<Block> SHARINGA_WOOD = registerBlock("sharinga_wood",
            ModLogs::new);
    public static final RegistryObject<Block> SHARINGA_SLAB = registerBlock("sharinga_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> SHARINGA_STAIRS = registerBlock("sharinga_stairs",
            () -> new StairsBlock(() -> SHARINGA_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> SHARINGA_FENCE = registerBlock("sharinga_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> SHARINGA_FENCE_GATE = registerBlock("sharinga_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_SHARINGA_SAPLING = BLOCKS.register("potted_sharinga_sapling",
            () -> new FlowerPotBlock(WoodGroup.SHARINGA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> BACURI_LOG = registerBlock("bacuri_log",
            ModLogs::new);
    public static final RegistryObject<Block> BACURI_LEAVES = registerBlock("bacuri_leaves",
            () -> new BacuriLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), WoodGroup.BACURI_FLOWERING_LEAVES));
    public static final RegistryObject<Block> BACURI_FLOWERING_LEAVES = registerBlock("bacuri_flowering_leaves",
            () -> new BacuriFloweringLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), WoodGroup.BACURI_FRUITING_LEAVES));
    public static final RegistryObject<Block> BACURI_FRUITING_LEAVES = registerBlock("bacuri_fruiting_leaves",
            () -> new BacuriFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), WoodGroup.BACURI_LEAVES));
    public static final RegistryObject<Block> BACURI_PLANKS = registerBlock("bacuri_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> BACURI_SAPLING = registerBlock("bacuri_sapling",
            BacuriSapling::new);
    public static final RegistryObject<Block> BACURI_WOOD = registerBlock("bacuri_wood",
            ModLogs::new);
    public static final RegistryObject<Block> BACURI_SLAB = registerBlock("bacuri_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> BACURI_STAIRS = registerBlock("bacuri_stairs",
            () -> new StairsBlock(() -> BACURI_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> BACURI_FENCE = registerBlock("bacuri_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> BACURI_FENCE_GATE = registerBlock("bacuri_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_BACURI_SAPLING = BLOCKS.register("potted_bacuri_sapling",
            () -> new FlowerPotBlock(WoodGroup.BACURI_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> CAMU_CAMU_LOG = registerBlock("camu_camu_log",
            ModLogs::new);
    public static final RegistryObject<Block> CAMU_CAMU_LEAVES = registerBlock("camu_camu_leaves",
            () -> new CamuCamuLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), WoodGroup.CAMU_CAMU_FLOWERING_LEAVES));
    public static final RegistryObject<Block> CAMU_CAMU_FLOWERING_LEAVES = registerBlock("camu_camu_flowering_leaves",
            () -> new CamuCamuFloweringLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), WoodGroup.CAMU_CAMU_FRUITING_LEAVES));
    public static final RegistryObject<Block> CAMU_CAMU_FRUITING_LEAVES = registerBlock("camu_camu_fruiting_leaves",
            () -> new CamuCamuFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), WoodGroup.CAMU_CAMU_LEAVES));
    public static final RegistryObject<Block> CAMU_CAMU_PLANKS = registerBlock("camu_camu_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> CAMU_CAMU_SAPLING = registerBlock("camu_camu_sapling",
            CamuCamuSapling::new);
    public static final RegistryObject<Block> CAMU_CAMU_WOOD = registerBlock("camu_camu_wood",
            ModLogs::new);
    public static final RegistryObject<Block> CAMU_CAMU_SLAB = registerBlock("camu_camu_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> CAMU_CAMU_STAIRS = registerBlock("camu_camu_stairs",
            () -> new StairsBlock(() -> CAMU_CAMU_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> CAMU_CAMU_FENCE = registerBlock("camu_camu_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> CAMU_CAMU_FENCE_GATE = registerBlock("camu_camu_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_CAMU_CAMU_SAPLING = BLOCKS.register("potted_camu_camu_sapling",
            () -> new FlowerPotBlock(WoodGroup.CAMU_CAMU_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> SOMBREIRO_LOG = registerBlock("sombreiro_log",
            ModLogs::new);
    public static final RegistryObject<Block> SOMBREIRO_LEAVES = registerBlock("sombreiro_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> SOMBREIRO_PLANKS = registerBlock("sombreiro_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> SOMBREIRO_SAPLING = registerBlock("sombreiro_sapling",
            SombreiroSapling::new);
    public static final RegistryObject<Block> SOMBREIRO_WOOD = registerBlock("sombreiro_wood",
            ModLogs::new);
    public static final RegistryObject<Block> SOMBREIRO_SLAB = registerBlock("sombreiro_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> SOMBREIRO_STAIRS = registerBlock("sombreiro_stairs",
            () -> new StairsBlock(() -> SOMBREIRO_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> SOMBREIRO_FENCE = registerBlock("sombreiro_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> SOMBREIRO_FENCE_GATE = registerBlock("sombreiro_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_SOMBREIRO_SAPLING = BLOCKS.register("potted_sombreiro_sapling",
            () -> new FlowerPotBlock(WoodGroup.SOMBREIRO_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> FEIJOA_WOOD = registerBlock("feijoa_wood",
            ModLogs::new);
    public static final RegistryObject<Block> FEIJOA_PLANKS = registerBlock("feijoa_planks",
            ModPlanks::new);
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


    public static final RegistryObject<Block> YERBA_MATE_WOOD = registerBlock("yerba_mate_wood",
            ModLogs::new);
    public static final RegistryObject<Block> YERBA_MATE_PLANKS = registerBlock("yerba_mate_planks",
            ModPlanks::new);
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


    public static final RegistryObject<Block> IMBUIA_WOOD = registerBlock("imbuia_wood",
            ModLogs::new);
    public static final RegistryObject<Block> IMBUIA_PLANKS = registerBlock("imbuia_planks",
            ModPlanks::new);
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


    public static final RegistryObject<Block> PINK_PEROBA_WOOD = registerBlock("pink_peroba_wood",
            ModLogs::new);
    public static final RegistryObject<Block> PINK_PEROBA_PLANKS = registerBlock("pink_peroba_planks",
            ModPlanks::new);
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


    public static final RegistryObject<Block> JEQUITIBA_WOOD = registerBlock("jequitiba_wood",
            ModLogs::new);
    public static final RegistryObject<Block> JEQUITIBA_PLANKS = registerBlock("jequitiba_planks",
            ModPlanks::new);
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


    public static final RegistryObject<Block> SAPUCAIA_WOOD = registerBlock("sapucaia_wood",
            ModLogs::new);
    public static final RegistryObject<Block> SAPUCAIA_PLANKS = registerBlock("sapucaia_planks",
            ModPlanks::new);
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


    public static final RegistryObject<Block> MANACA_DA_SERRA_WOOD = registerBlock("manaca_da_serra_wood",
            ModLogs::new);
    public static final RegistryObject<Block> MANACA_DA_SERRA_PLANKS = registerBlock("manaca_da_serra_planks",
            ModPlanks::new);
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


    public static final RegistryObject<Block> BRAZILLIAN_ROSEWOOD_WOOD = registerBlock("brazillian_rosewood_wood",
            ModLogs::new);
    public static final RegistryObject<Block> BRAZILLIAN_ROSEWOOD_PLANKS = registerBlock("brazillian_rosewood_planks",
            ModPlanks::new);
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


    public static final RegistryObject<Block> BRAZILLIAN_SASSAFRAS_WOOD = registerBlock("brazillian_sassafras_wood",
            ModLogs::new);
    public static final RegistryObject<Block> BRAZILLIAN_SASSAFRAS_PLANKS = registerBlock("brazillian_sassafras_planks",
            ModPlanks::new);
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


    public static final RegistryObject<Block> UMBU_WOOD = registerBlock("umbu_wood",
            ModLogs::new);
    public static final RegistryObject<Block> UMBU_PLANKS = registerBlock("umbu_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> UMBU_SLAB = registerBlock("umbu_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> UMBU_STAIRS = registerBlock("umbu_stairs",
            () -> new StairsBlock(() -> UMBU_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> UMBU_FENCE = registerBlock("umbu_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> UMBU_FENCE_GATE = registerBlock("umbu_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));


    public static final RegistryObject<Block> JABUTICABA_WOOD = registerBlock("jabuticaba_wood",
            ModLogs::new);
    public static final RegistryObject<Block> JABUTICABA_PLANKS = registerBlock("jabuticaba_planks",
            ModPlanks::new);
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


    public static final RegistryObject<Block> CAMBUCI_WOOD = registerBlock("cambuci_wood",
            ModLogs::new);
    public static final RegistryObject<Block> CAMBUCI_PLANKS = registerBlock("cambuci_planks",
            ModPlanks::new);
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


    public static final RegistryObject<Block> BRAZILWOOD_WOOD = registerBlock("brazilwood_wood",
            ModLogs::new);
    public static final RegistryObject<Block> BRAZILWOOD_PLANKS = registerBlock("brazilwood_planks",
            ModPlanks::new);
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


    public static final RegistryObject<Block> WOLF_APPLE_WOOD = registerBlock("wolf_apple_wood",
            ModLogs::new);
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


    public static final RegistryObject<Block> CECROPIA_WOOD = registerBlock("cecropia_wood",
            ModLogs::new);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.WOOD_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
