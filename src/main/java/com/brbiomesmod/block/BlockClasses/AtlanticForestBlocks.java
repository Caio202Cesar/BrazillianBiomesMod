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

public class AtlanticForestBlocks {
    public static List<Block> blocksList = new ArrayList<>();

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, BrazillianBiomesMod.MOD_ID);


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


    public static final RegistryObject<Block> JABUTICABA_LOG = registerBlock("jabuticaba_log",
            ModLogs::new);
    public static final RegistryObject<Block> JABUTICABA_FLOWERING_LOG = registerBlock("jabuticaba_flowering_log",
            ModLogs::new);
    public static final RegistryObject<Block> JABUTICABA_FRUITING_LOG = registerBlock("jabuticaba_fruiting_log",
            ModLogs::new);
    public static final RegistryObject<Block> JABUTICABA_LEAVES = registerBlock("jabuticaba_leaves",
            ModLeaves::new);


    public static final RegistryObject<Block> QUEEN_PALM_LOG = registerBlock("queen_palm_log",
            ModLogs::new);
    public static final RegistryObject<Block> QUEEN_PALM_WOOD = registerBlock("queen_palm_wood",
            ModLogs::new);
    public static final RegistryObject<Block> QUEEN_PALM_PLANKS = registerBlock("queen_palm_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> QUEEN_PALM_FROND = registerBlock("queen_palm_frond",
            ModLeaves::new);


    public static final RegistryObject<Block> JUSSARA_FROND = registerBlock("jussara_frond",
            ModLeaves::new);


    public static final RegistryObject<Block> CAMBUCI_LOG = registerBlock("cambuci_log",
            ModLogs::new);
    public static final RegistryObject<Block> CAMBUCI_WOOD = registerBlock("cambuci_wood",
            ModLogs::new);
    public static final RegistryObject<Block> CAMBUCI_PLANKS = registerBlock("cambuci_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> CAMBUCI_LEAVES = registerBlock("cambuci_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> CAMBUCI_SAPLING = registerBlock("cambuci_sapling",
            CambuciSapling::new);


    public static final RegistryObject<Block> CECROPIA_LOG = registerBlock("cecropia_log",
            ModLogs::new);
    public static final RegistryObject<Block> CECROPIA_WOOD = registerBlock("cecropia_wood",
            ModLogs::new);
    public static final RegistryObject<Block> CECROPIA_LEAVES = registerBlock("cecropia_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> CECROPIA_SILVER_SAPLING = registerBlock("cecropia_silver_sapling",
            SilverCecropiaSapling::new);
    public static final RegistryObject<Block> CECROPIA_SILVER_LEAVES = registerBlock("cecropia_silver_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> CECROPIA_SAPLING = registerBlock("cecropia_sapling",
            CecropiaSapling::new);


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


    public static final RegistryObject<Block> IPE_LOG = registerBlock("ipe_log",
            ModLogs::new);
    public static final RegistryObject<Block> YELLOW_IPE_BLOSSOM = registerBlock("yellow_ipe_blossom",
            ModLeaves::new);
    public static final RegistryObject<Block> YELLOW_IPE_SAPLING = registerBlock("yellow_ipe_sapling",
            YellowIpeSapling::new);
    public static final RegistryObject<Block> PURPLE_IPE_BLOSSOM = registerBlock("purple_ipe_blossom",
            ModLeaves::new);
    public static final RegistryObject<Block> PURPLE_IPE_SAPLING = registerBlock("purple_ipe_sapling",
            PurpleIpeSapling::new);
    public static final RegistryObject<Block> PINK_IPE_BLOSSOM = registerBlock("pink_ipe_blossom",
            ModLeaves::new);
    public static final RegistryObject<Block> PINK_IPE_SAPLING = registerBlock("pink_ipe_sapling",
            PinkIpeSapling::new);
    public static final RegistryObject<Block> WHITE_IPE_BLOSSOM = registerBlock("white_ipe_blossom",
            ModLeaves::new);
    public static final RegistryObject<Block> WHITE_IPE_SAPLING = registerBlock("white_ipe_sapling",
            WhiteIpeSapling::new);


    public static final RegistryObject<Block> EUGENIA_LOG = registerBlock("eugenia_log",
            ModLogs::new);
    public static final RegistryObject<Block> PITANGA_LEAVES = registerBlock("pitanga_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> BLACK_PITANGA_LEAVES = registerBlock("pitanga_black_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> PITANGA_SAPLING = registerBlock("pitanga_sapling",
            PitangaSapling::new);


    public static final RegistryObject<Block> PINK_PEROBA_LOG = registerBlock("pink_peroba_log",
            ModLogs::new);
    public static final RegistryObject<Block> PINK_PEROBA_LEAVES = registerBlock("pink_peroba_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> PINK_PEROBA_SAPLING = registerBlock("pink_peroba_sapling",
            PinkPerobaSapling::new);


    public static final RegistryObject<Block> JEQUITIBA_LOG = registerBlock("jequitiba_log",
            ModLogs::new);
    public static final RegistryObject<Block> JEQUITIBA_LEAVES = registerBlock("jequitiba_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> JEQUITIBA_SAPLING = registerBlock("jequitiba_sapling",
            JequitibaSapling::new);


    public static final RegistryObject<Block> BRAZILLIAN_ROSEWOOD_LOG = registerBlock("brazillian_rosewood_log",
            ModLogs::new);
    public static final RegistryObject<Block> BRAZILLIAN_ROSEWOOD_LEAVES = registerBlock("brazillian_rosewood_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> BRAZILLIAN_ROSEWOOD_SAPLING = registerBlock("brazillian_rosewood_sapling",
            BrazillianRosewoodSapling::new);


    public static final RegistryObject<Block> PASSION_FRUIT_VINE = registerBlock("passion_fruit_vine",
            PassionFruitVine::new);
    public static final RegistryObject<Block> PASSION_FRUIT_FLOWERING_VINE = registerBlock("passion_fruit_flowering_vine",
            PassionFruitVine::new);
    public static final RegistryObject<Block> BRAZILLIAN_DUTCHMAN_PIPE_VINE = registerBlock("brazillian_dutchman_pipe_vine",
            AristolochiaVine::new);
    public static final RegistryObject<Block> TILLANDSIA_STRICTA = registerBlock("tillandsia_stricta",
            EpiphytePlant::new);



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

