package com.brbiomesmod.block.BlockClasses;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.block.*;
import com.brbiomesmod.block.Custom.Leaves.ButiaLeaves;
import com.brbiomesmod.block.Custom.Leaves.ModLeaves;
import com.brbiomesmod.block.Custom.Leaves.PinkPeeperLeaves;
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

public class PampasBlocks {
    public static List<Block> blocksList = new ArrayList<>();

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, BrazillianBiomesMod.MOD_ID);

    public static final RegistryObject<Block> JELLY_PALM_LOG = registerBlock("jelly_palm_log",
            ModLogs::new);
    public static final RegistryObject<Block> JELLY_PALM_LEAVES = registerBlock("jelly_palm_leaves",
            () -> new ButiaLeaves(AbstractBlock.Properties.create(Material.LEAVES)
                    .hardnessAndResistance(0.2f)
                    .tickRandomly() // Enables random ticks
                    .notSolid()
                    .sound(SoundType.PLANT)));
    public static final RegistryObject<Block> JELLY_PALM_SAPLING = registerBlock("jelly_palm_sapling",
            JellyPalmSapling::new);
    public static final RegistryObject<Block> PINDO_BUNCH = registerBlock("pindo_bunch",
            PindoBunchBlock::new);

    public static final RegistryObject<Block> SCHINUS_LOG = registerBlock("schinus_log",
            ModLogs::new);
    public static final RegistryObject<Block> SCHINUS_PLANKS = registerBlock("schinus_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> SCHINUS_WOOD = registerBlock("schinus_wood",
            ModLogs::new);
    public static final RegistryObject<Block> SCHINUS_SLAB = registerBlock("schinus_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> SCHINUS_STAIRS = registerBlock("schinus_stairs",
            () -> new StairsBlock(() -> SCHINUS_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> SCHINUS_FENCE = registerBlock("schinus_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> SCHINUS_FENCE_GATE = registerBlock("schinus_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> BRAZILLIAN_PEPPER_LEAVES = registerBlock("brazillian_pepper_leaves",
            PinkPeeperLeaves::new);
    public static final RegistryObject<Block> PERUVIAN_PEPPER_LEAVES = registerBlock("peruvian_pepper_leaves",
            PinkPeeperLeaves::new);
    public static final RegistryObject<Block> BRAZILLIAN_PEPPER_SAPLING = registerBlock("brazillian_pepper_sapling",
            BrazillianPepperSapling::new);
    public static final RegistryObject<Block> PERUVIAN_PEPPER_SAPLING = registerBlock("peruvian_pepper_sapling",
            PeruvianPepperSapling::new);
    public static final RegistryObject<Block> SILVER_PEPPER_LEAVES = registerBlock("silver_pepper_leaves",
            PinkPeeperLeaves::new);
    public static final RegistryObject<Block> SILVER_PEPPER_SAPLING = registerBlock("silver_pepper_sapling",
            SilverPepperSapling::new);
    public static final RegistryObject<Block> URUGUAYAN_PEPPER_LEAVES = registerBlock("uruguayan_pepper_leaves",
            PinkPeeperLeaves::new);
    public static final RegistryObject<Block> URUGUAYAN_PEPPER_SAPLING = registerBlock("uruguayan_pepper_sapling",
            UruguayanPepperSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_BRAZILLIAN_PEPPER_SAPLING = BLOCKS.register("potted_brazillian_pepper_sapling",
            () -> new FlowerPotBlock(PampasBlocks.BRAZILLIAN_PEPPER_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_PERUVIAN_PEPPER_SAPLING = BLOCKS.register("potted_peruvian_pepper_sapling",
            () -> new FlowerPotBlock(PampasBlocks.PERUVIAN_PEPPER_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_SILVER_PEPPER_SAPLING = BLOCKS.register("potted_silver_pepper_sapling",
            () -> new FlowerPotBlock(PampasBlocks.SILVER_PEPPER_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_URUGUAYAN_PEPPER_SAPLING = BLOCKS.register("potted_uruguayan_pepper_sapling",
            () -> new FlowerPotBlock(PampasBlocks.URUGUAYAN_PEPPER_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> ALGARROBILLO_LOG = registerBlock("algarrobillo_log",
            ModLogs::new);
    public static final RegistryObject<Block> ALGARROBILLO_WOOD = registerBlock("algarrobillo_wood",
            ModLogs::new);
    public static final RegistryObject<Block> ALGARROBILLO_LEAVES = registerBlock("algarrobillo_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> ALGARROBILLO_SAPLING = registerBlock("algarrobillo_sapling",
            AlgarrobilloSapling::new);
    public static final RegistryObject<Block> ALGARROBILLO_PLANKS = registerBlock("algarrobillo_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> ALGARROBILLO_SLAB = registerBlock("algarrobillo_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> ALGARROBILLO_STAIRS = registerBlock("algarrobillo_stairs",
            () -> new StairsBlock(() -> ALGARROBILLO_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> ALGARROBILLO_FENCE = registerBlock("algarrobillo_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> ALGARROBILLO_FENCE_GATE = registerBlock("algarrobillo_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_ALGARROBILLO_SAPLING = BLOCKS.register("potted_algarrobillo_sapling",
            () -> new FlowerPotBlock(PampasBlocks.ALGARROBILLO_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> CAVEN_THORN_LOG = registerBlock("caven_thorn_log",
            ModLogs::new);
    public static final RegistryObject<Block> CAVEN_THORN_WOOD = registerBlock("caven_thorn_wood",
            ModLogs::new);
    public static final RegistryObject<Block> CAVEN_THORN_LEAVES = registerBlock("caven_thorn_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> CAVEN_THORN_SAPLING = registerBlock("caven_thorn_sapling",
            CavenThornSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_CAVEN_THORN_SAPLING = BLOCKS.register("potted_caven_thorn_sapling",
            () -> new FlowerPotBlock(PampasBlocks.CAVEN_THORN_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> COCKSPUR_CORAL_LOG = registerBlock("cockspur_coral_log",
            ModLogs::new);
    public static final RegistryObject<Block> COCKSPUR_CORAL_WOOD = registerBlock("cockspur_coral_wood",
            ModLogs::new);
    public static final RegistryObject<Block> COCKSPUR_CORAL_LEAVES = registerBlock("cockspur_coral_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> COCKSPUR_CORAL_SAPLING = registerBlock("cockspur_coral_sapling",
            CockspurCoralSapling::new);
    public static final RegistryObject<Block> COCKSPUR_CORAL_PLANKS = registerBlock("cockspur_coral_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> COCKSPUR_CORAL_SLAB = registerBlock("cockspur_coral_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> COCKSPUR_CORAL_STAIRS = registerBlock("cockspur_coral_stairs",
            () -> new StairsBlock(() -> COCKSPUR_CORAL_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> COCKSPUR_CORAL_FENCE = registerBlock("cockspur_coral_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    public static final RegistryObject<Block> COCKSPUR_CORAL_FENCE_GATE = registerBlock("cockspur_coral_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE)
                    .hardnessAndResistance(3f)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_COCKSPUR_CORAL_SAPLING = BLOCKS.register("potted_cockspur_coral_sapling",
            () -> new FlowerPotBlock(PampasBlocks.COCKSPUR_CORAL_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> MACELA = registerBlock("macela",
            () -> new FlowerBlock(Effects.REGENERATION, 6, AbstractBlock.Properties.from(Blocks.CORNFLOWER)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_MACELA = BLOCKS.register("potted_macela",
            () -> new FlowerPotBlock(PampasBlocks.MACELA.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));

    public static final RegistryObject<Block> ASPILIA_MONTEVIDENSIS = registerBlock("aspilia_montevidensis",
            () -> new FlowerBlock(Effects.JUMP_BOOST, 6, AbstractBlock.Properties.from(Blocks.CORNFLOWER)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_ASPILIA_MONTEVIDENSIS = BLOCKS.register("potted_aspilia_montevidensis",
            () -> new FlowerPotBlock(PampasBlocks.ASPILIA_MONTEVIDENSIS.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));

    public static final RegistryObject<Block> MANDEVILLA_COCCINEA = registerBlock("mandevilla_coccinea",
            () -> new FlowerBlock(Effects.REGENERATION, 6, AbstractBlock.Properties.from(Blocks.CORNFLOWER)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_MANDEVILLA_COCCINEA = BLOCKS.register("potted_mandevilla_coccinea",
            () -> new FlowerPotBlock(PampasBlocks.MANDEVILLA_COCCINEA.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));

    public static final RegistryObject<Block> VELAME_OF_RIO_GRANDE = registerBlock("velame_of_rio_grande",
            () -> new FlowerBlock(Effects.BLINDNESS, 6, AbstractBlock.Properties.from(Blocks.CORNFLOWER)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_VELAME_OF_RIO_GRANDE = BLOCKS.register("potted_velame_of_rio_grande",
            () -> new FlowerPotBlock(PampasBlocks.VELAME_OF_RIO_GRANDE.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final  RegistryObject<Block> CALABASH_CROP = BLOCKS.register("calabash_crop",
            () -> new CalabashCropBlock(AbstractBlock.Properties.from(Blocks.WHEAT).sound(SoundType.CROP)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.PAMPAS_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

