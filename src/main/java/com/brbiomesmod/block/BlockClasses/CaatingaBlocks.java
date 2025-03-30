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
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class CaatingaBlocks {
    public static List<Block> blocksList = new ArrayList<>();

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, BrazillianBiomesMod.MOD_ID);

    public static final RegistryObject<Block> CAATINGA_SAND = registerBlock("caatinga_sand",
            CaatingaSand::new);

    public static final RegistryObject<Block> JUA_LOG = registerBlock("jua_log",
            ModLogs::new);
    public static final RegistryObject<Block> JUA_WOOD = registerBlock("jua_wood",
            ModLogs::new);
    //public static final RegistryObject<Block> JUA_STRIPPED_LOG = registerBlock("jua_stripped_log", ModLogs::new);
    //public static final RegistryObject<Block> JUA_STRIPPED_WOOD = registerBlock("jua_stripped_wood", ModLogs::new);
    public static final RegistryObject<Block> JUA_PLANKS = registerBlock("jua_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> JUA_LEAVES = registerBlock("jua_leaves",
            () -> new JuaLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), CaatingaBlocks.JUA_FRUITING_LEAVES));
    public static final RegistryObject<Block> JUA_FRUITING_LEAVES = registerBlock("jua_fruiting_leaves",
            () -> new JuaFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), CaatingaBlocks.JUA_LEAVES));
    public static final RegistryObject<Block> JUA_SAPLING = registerBlock("jua_sapling",
            JuaSapling::new);
    public static final RegistryObject<Block> JUA_SLAB = registerBlock("jua_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> JUA_STAIRS = registerBlock("jua_stairs",
            () -> new StairsBlock(() -> JUA_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> JUA_FENCE = registerBlock("jua_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> JUA_FENCE_GATE = registerBlock("jua_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_JUA_SAPLING = BLOCKS.register("potted_jua_sapling",
            () -> new FlowerPotBlock(CaatingaBlocks.JUA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance()));


    public static final RegistryObject<Block> BLACK_JUREMA_LOG = registerBlock("black_jurema_log",
            ModLogs::new);
    public static final RegistryObject<Block> BLACK_JUREMA_WOOD = registerBlock("black_jurema_wood",
            ModLogs::new);
    public static final RegistryObject<Block> BLACK_JUREMA_LEAVES = registerBlock("black_jurema_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> BLACK_JUREMA_SAPLING = registerBlock("black_jurema_sapling",
            BlackJuremaSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_BLACK_JUREMA_SAPLING = BLOCKS.register("potted_black_jurema_sapling",
            () -> new FlowerPotBlock(CaatingaBlocks.BLACK_JUREMA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance()));


    public static final RegistryObject<Block> UMBU_LOG = registerBlock("umbu_log",
            ModLogs::new);
    public static final RegistryObject<Block> UMBU_WOOD = registerBlock("umbu_wood",
            ModLogs::new);
    public static final RegistryObject<Block> UMBU_PLANKS = registerBlock("umbu_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> UMBU_LEAVES = registerBlock("umbu_leaves",
            () -> new UmbuLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), CaatingaBlocks.UMBU_FRUITING_LEAVES));
    public static final RegistryObject<Block> UMBU_FRUITING_LEAVES = registerBlock("umbu_fruiting_leaves",
            () -> new UmbuLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), CaatingaBlocks.UMBU_FRUITING_LEAVES));
    public static final RegistryObject<Block> UMBU_SAPLING = registerBlock("umbu_sapling",
            UmbuSapling::new);
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
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_UMBU_SAPLING = BLOCKS.register("potted_umbu_sapling",
            () -> new FlowerPotBlock(CaatingaBlocks.UMBU_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance()));


    public static final RegistryObject<Block> CARNAUBA_LOG = registerBlock("carnauba_log",
            ModLogs::new);
    public static final RegistryObject<Block> CARNAUBA_LEAVES = registerBlock("carnauba_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> CARNAUBA_SAPLING = registerBlock("carnauba_sapling",
            CarnaubaSapling::new);

    //public static final RegistryObject<Block> CATINGUEIRA_LOG = registerBlock("catingueira_log", ModLogs::new);
    //public static final RegistryObject<Block> CATINGUEIRA_LEAVES = registerBlock("catingueira_leaves", ModLeaves::new);


    public static final RegistryObject<Block> WHITE_SILK_FLOSS_LEAVES = registerBlock("silk_floss_white_leaves",
            () -> new WhiteSilkFlossLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), CaatingaBlocks.WHITE_SILK_FLOSS_FLOWERING_LEAVES));
    public static final RegistryObject<Block> WHITE_SILK_FLOSS_FLOWERING_LEAVES = registerBlock("silk_floss_white_flowering_leaves",
            () -> new WhiteSilkFlossFloweringLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), CaatingaBlocks.WHITE_SILK_FLOSS_FRUITING_LEAVES));
    public static final RegistryObject<Block> WHITE_SILK_FLOSS_FRUITING_LEAVES = registerBlock("silk_floss_white_fruiting_leaves",
            () -> new WhiteSilkFlossFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), CaatingaBlocks.WHITE_SILK_FLOSS_LEAVES));
    public static final RegistryObject<Block> WHITE_SILK_FLOSS_SAPLING = registerBlock("silk_floss_white_sapling",
            KapokLeaves::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_WHITE_SILK_FLOSS_SAPLING = BLOCKS.register("potted_silk_floss_white_sapling",
            () -> new FlowerPotBlock(CaatingaBlocks.WHITE_SILK_FLOSS_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance()));


    public static final RegistryObject<Block> CNIDOSCOLUS_URENS = registerBlock("bull_nettle",
            BullNettlePlant::new);
    public static final RegistryObject<Block> CNIDOSCOLUS_URENS_FRUITING = registerBlock("bull_nettle_fruiting",
            BullNettlePlant::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_CNIDOSCOLUS_URENS = BLOCKS.register("potted_bull_nettle",
            () -> new FlowerPotBlock(CaatingaBlocks.CNIDOSCOLUS_URENS.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance()));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_CNIDOSCOLUS_URENS_FRUITING = BLOCKS.register("potted_bull_nettle_fruiting",
            () -> new FlowerPotBlock(CaatingaBlocks.CNIDOSCOLUS_URENS_FRUITING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance()));


    public static final RegistryObject<Block> TURK_TURBAN_CACTUS = registerBlock("turk_turban_cactus",
            CactusPlant::new);
    public static final RegistryObject<Block> TURK_TURBAN_FRUITING_CACTUS = registerBlock("turk_turban_fruiting_cactus",
            FruitingCactusPlant::new);


    public static final RegistryObject<Block> TOURMALINE_PARAIBA_ORE = registerBlock("tourmaline_paraiba_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(2).harvestTool(ToolType.PICKAXE)
                    .setRequiresTool().hardnessAndResistance(5f)));
    public static final RegistryObject<Block> TOURMALINE_PARAIBA_BLOCK = registerBlock("tourmaline_paraiba_block",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON).harvestLevel(2).harvestTool(ToolType.PICKAXE)
                    .setRequiresTool().hardnessAndResistance(5f)));


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.CAATINGA_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
