package com.brbiomesmod.block.BlockClasses;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.block.*;
import com.brbiomesmod.block.Custom.Leaves.*;
import com.brbiomesmod.block.Custom.Log.ModLogs;
import com.brbiomesmod.block.Custom.Log.PalmitoLog;
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

public class AmazonRainforestBlocks {
    public static List<Block> blocksList = new ArrayList<>();

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, BrazillianBiomesMod.MOD_ID);

    public static final RegistryObject<Block> KAPOK_LOG = registerBlock("kapok_log",
            ModLogs::new);
    public static final RegistryObject<Block> KAPOK_LEAVES = registerBlock("kapok_leaves",
            KapokLeaves::new);
    public static final RegistryObject<Block> KAPOK_SAPLING = registerBlock("kapok_sapling",
            KapokSapling::new);
    public static final RegistryObject<Block> KAPOK_WOOD = registerBlock("kapok_wood",
            ModLogs::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_KAPOK_SAPLING = BLOCKS.register("potted_kapok_sapling",
            () -> new FlowerPotBlock(AmazonRainforestBlocks.KAPOK_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


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
            () -> new FlowerPotBlock(AmazonRainforestBlocks.BALSA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
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
            () -> new FlowerPotBlock(AmazonRainforestBlocks.LOPHANTERA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    //Cupuacu and Guarana trunk is made of Jungle Log
    public static final RegistryObject<Block> CUPUACU_LEAVES = registerBlock("cupuacu_leaves",
            () -> new CupuacuLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), AmazonRainforestBlocks.CUPUACU_FRUITING_LEAVES));
    public static final RegistryObject<Block> CUPUACU_FRUITING_LEAVES = registerBlock("cupuacu_fruiting_leaves",
            () -> new CupuacuFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), AmazonRainforestBlocks.CUPUACU_FRUITING_LEAVES));
    public static final RegistryObject<Block> CUPUACU_SAPLING = registerBlock("cupuacu_sapling",
            CupuacuSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_CUPUACU_SAPLING = BLOCKS.register("potted_cupuacu_sapling",
            () -> new FlowerPotBlock(AmazonRainforestBlocks.CUPUACU_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> GUARANA_LEAVES = registerBlock("guarana_leaves",
            GuaranaLeaves::new);
    public static final RegistryObject<Block> GUARANA_SAPLING = registerBlock("guarana_sapling",
            GuaranaSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_GUARANA_SAPLING = BLOCKS.register("potted_guarana_sapling",
            () -> new FlowerPotBlock(AmazonRainforestBlocks.GUARANA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> ACAI_LEAVES = registerBlock("acai_leaves",
            () -> new AcaiLeaves(AbstractBlock.Properties.create(Material.LEAVES)
                    .hardnessAndResistance(0.2f)
                    .tickRandomly() // Enables random ticks
                    .notSolid()
                    .sound(SoundType.PLANT)));
    public static final RegistryObject<Block> PALMITO_LOG = registerBlock("palmito_log",
            PalmitoLog::new);
    public static final RegistryObject<Block> ACAI_SAPLING = registerBlock("acai_sapling",
            AcaiSapling::new);
    public static final RegistryObject<Block> ACAI_BUNCH = registerBlock("acai_bunch",
            AcaiBunchBlock::new);


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
            () -> new FlowerPotBlock(AmazonRainforestBlocks.BRAZILNUT_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
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
            () -> new FlowerPotBlock(AmazonRainforestBlocks.SHARINGA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> BACURI_LOG = registerBlock("bacuri_log",
            ModLogs::new);
    public static final RegistryObject<Block> BACURI_LEAVES = registerBlock("bacuri_leaves",
            () -> new BacuriLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), AmazonRainforestBlocks.BACURI_FLOWERING_LEAVES));
    public static final RegistryObject<Block> BACURI_FLOWERING_LEAVES = registerBlock("bacuri_flowering_leaves",
            () -> new BacuriFloweringLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), AmazonRainforestBlocks.BACURI_FRUITING_LEAVES));
    public static final RegistryObject<Block> BACURI_FRUITING_LEAVES = registerBlock("bacuri_fruiting_leaves",
            () -> new BacuriFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), AmazonRainforestBlocks.BACURI_LEAVES));
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
            () -> new FlowerPotBlock(AmazonRainforestBlocks.BACURI_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> CAMU_CAMU_LOG = registerBlock("camu_camu_log",
            ModLogs::new);
    public static final RegistryObject<Block> CAMU_CAMU_LEAVES = registerBlock("camu_camu_leaves",
            () -> new CamuCamuLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), AmazonRainforestBlocks.CAMU_CAMU_FLOWERING_LEAVES));
    public static final RegistryObject<Block> CAMU_CAMU_FLOWERING_LEAVES = registerBlock("camu_camu_flowering_leaves",
            () -> new CamuCamuFloweringLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), AmazonRainforestBlocks.CAMU_CAMU_FRUITING_LEAVES));
    public static final RegistryObject<Block> CAMU_CAMU_FRUITING_LEAVES = registerBlock("camu_camu_fruiting_leaves",
            () -> new CamuCamuFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), AmazonRainforestBlocks.CAMU_CAMU_LEAVES));
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
            () -> new FlowerPotBlock(AmazonRainforestBlocks.CAMU_CAMU_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
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
            () -> new FlowerPotBlock(AmazonRainforestBlocks.SOMBREIRO_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> CASSAVA_PLANT = registerBlock("cassava_plant",
            CassavaPlant::new);
    public static final  RegistryObject<Block> CASSAVA_CROP = BLOCKS.register("cassava_crop",
            () -> new CassavaCropBlock(AbstractBlock.Properties.from(Blocks.WHEAT).sound(SoundType.CROP)));

    //public static final RegistryObject<Block> VITORIA_REGIA = registerBlock("vitoria_regia", VitoriaRegiaBlock::new);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.AMAZON_RAINFOREST_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
