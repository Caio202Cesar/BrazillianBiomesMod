package com.brbiomesmod.block.BlockClasses;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.block.ModLeaves;
import com.brbiomesmod.block.ModLogs;
import com.brbiomesmod.block.ModPlanks;
import com.brbiomesmod.block.PampasPlant;
import com.brbiomesmod.block.Saplings.*;
import com.brbiomesmod.item.ModItemGroup;
import com.brbiomesmod.item.ModItems;
import com.electronwill.nightconfig.core.ConfigSpec;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
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


    public static final RegistryObject<Block> ALGARROBILLO_LOG = registerBlock("algarrobillo_log",
            ModLogs::new);
    public static final RegistryObject<Block> ALGARROBILLO_LEAVES = registerBlock("algarrobillo_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> ALGARROBILLO_SAPLING = registerBlock("algarrobillo_sapling",
            AlgarrobilloSapling::new);
    public static final RegistryObject<Block> ALGARROBILLO_PLANKS = registerBlock("algarrobillo_planks",
            ModPlanks::new);


    public static final RegistryObject<Block> CAVEN_THORN_LOG = registerBlock("caven_thorn_log",
            ModLogs::new);
    public static final RegistryObject<Block> CAVEN_THORN_LEAVES = registerBlock("caven_thorn_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> CAVEN_THORN_SAPLING = registerBlock("caven_thorn_sapling",
            CavenThornSapling::new);


    public static final RegistryObject<Block> MACELA = registerBlock("macela",
            PampasPlant::new);
    public static final RegistryObject<Block> ASPILIA_MONTEVIDENSIS = registerBlock("aspilia_montevidensis",
            PampasPlant::new);
    public static final RegistryObject<Block> MANDEVILLA_COCCINEA = registerBlock("mandevilla_coccinea",
            PampasPlant::new);
    public static final RegistryObject<Block> VELAME_OF_RIO_GRANDE = registerBlock("velame_of_rio_grande",
            PampasPlant::new);


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

