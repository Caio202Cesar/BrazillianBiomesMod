package com.brbiomesmod.block.BlockClasses;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.block.*;
import com.brbiomesmod.block.Saplings.*;
import com.brbiomesmod.item.ModItemGroup;
import com.brbiomesmod.item.ModItems;
import com.electronwill.nightconfig.core.ConfigSpec;
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

public class PampasPlainsBlocks {
    public static List<Block> blocksList = new ArrayList<>();

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, BrazillianBiomesMod.MOD_ID);


    public static final RegistryObject<Block> SCHINUS_LOG = registerBlock("schinus_log",
            ModLogs::new);
    public static final RegistryObject<Block> SCHINUS_PLANKS = registerBlock("schinus_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> BRAZILLIAN_PEPPER_LEAVES = registerBlock("brazillian_pepper_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> PERUVIAN_PEPPER_LEAVES = registerBlock("peruvian_pepper_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> BRAZILLIAN_PEPPER_SAPLING = registerBlock("brazillian_pepper_sapling",
            BrazillianPepperSapling::new);
    public static final RegistryObject<Block> PERUVIAN_PEPPER_SAPLING = registerBlock("peruvian_pepper_sapling",
            PeruvianPepperSapling::new);
    public static final RegistryObject<Block> SILVER_PEPPER_LEAVES = registerBlock("silver_pepper_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> SILVER_PEPPER_SAPLING = registerBlock("silver_pepper_sapling",
            SilverPepperSapling::new);
    public static final RegistryObject<Block> URUGUAYAN_PEPPER_LEAVES = registerBlock("uruguayan_pepper_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> URUGUAYAN_PEPPER_SAPLING = registerBlock("uruguayan_pepper_sapling",
            UruguayanPepperSapling::new);
    public static final RegistryObject<Block> SCHINUS_STAIRS = registerBlock("schinus_stairs",
            () -> new StairsBlock(() -> SCHINUS_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));


    public static final RegistryObject<Block> ALGARROBILLO_LOG = registerBlock("algarrobillo_log",
            ModLogs::new);
    public static final RegistryObject<Block> ALGARROBILLO_LEAVES = registerBlock("algarrobillo_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> ALGARROBILLO_SAPLING = registerBlock("algarrobillo_sapling",
            AlgarrobilloSapling::new);
    public static final RegistryObject<Block> ALGARROBILLO_PLANKS = registerBlock("algarrobillo_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> ALGARROBILLO_STAIRS = registerBlock("algarrobillo_stairs",
            () -> new StairsBlock(() -> ALGARROBILLO_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));


    public static final RegistryObject<Block> CAVEN_THORN_LOG = registerBlock("caven_thorn_log",
            ModLogs::new);
    public static final RegistryObject<Block> CAVEN_THORN_LEAVES = registerBlock("caven_thorn_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> CAVEN_THORN_SAPLING = registerBlock("caven_thorn_sapling",
            CavenThornSapling::new);


    public static final RegistryObject<Block> COCKSPUR_CORAL_LOG = registerBlock("cockspur_coral_log",
            ModLogs::new);
    public static final RegistryObject<Block> COCKSPUR_CORAL_LEAVES = registerBlock("cockspur_coral_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> COCKSPUR_CORAL_SAPLING = registerBlock("cockspur_coral_sapling",
            CockspurCoralSapling::new);
    public static final RegistryObject<Block> COCKSPUR_CORAL_PLANKS = registerBlock("cockspur_coral_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> COCKSPUR_CORAL_STAIRS = registerBlock("cockspur_coral_stairs",
            () -> new StairsBlock(() -> COCKSPUR_CORAL_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));


    public static final RegistryObject<Block> MACELA = registerBlock("macela",
            PampasPlant::new);
    public static final RegistryObject<Block> ASPILIA_MONTEVIDENSIS = registerBlock("aspilia_montevidensis",
            PampasPlant::new);
    public static final RegistryObject<Block> MANDEVILLA_COCCINEA = registerBlock("mandevilla_coccinea",
            PampasPlant::new);
    public static final RegistryObject<Block> VELAME_OF_RIO_GRANDE = registerBlock("velame_of_rio_grande",
            PampasPlant::new);


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

