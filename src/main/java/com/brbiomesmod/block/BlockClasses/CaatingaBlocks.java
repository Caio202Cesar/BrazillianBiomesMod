package com.brbiomesmod.block.BlockClasses;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.block.*;
import com.brbiomesmod.block.Saplings.BlackJuremaSapling;
import com.brbiomesmod.block.Saplings.JuaSapling;
import com.brbiomesmod.block.Saplings.MangabaSapling;
import com.brbiomesmod.block.Saplings.UmbuSapling;
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
    public static final RegistryObject<Block> JUA_STRIPPED_LOG = registerBlock("jua_stripped_log",
            ModLogs::new);
    public static final RegistryObject<Block> JUA_STRIPPED_WOOD = registerBlock("jua_stripped_wood",
            ModLogs::new);
    public static final RegistryObject<Block> JUA_PLANKS = registerBlock("jua_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> JUA_LEAVES = registerBlock("jua_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> JUA_SAPLING = registerBlock("jua_sapling",
            JuaSapling::new);


    public static final RegistryObject<Block> BLACK_JUREMA_LOG = registerBlock("black_jurema_log",
            ModLogs::new);
    public static final RegistryObject<Block> BLACK_JUREMA_WOOD = registerBlock("black_jurema_wood",
            ModLogs::new);
    public static final RegistryObject<Block> BLACK_JUREMA_LEAVES = registerBlock("black_jurema_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> BLACK_JUREMA_SAPLING = registerBlock("black_jurema_sapling",
            BlackJuremaSapling::new);


    public static final RegistryObject<Block> UMBU_LOG = registerBlock("umbu_log",
            ModLogs::new);
    public static final RegistryObject<Block> UMBU_WOOD = registerBlock("umbu_wood",
            ModLogs::new);
    public static final RegistryObject<Block> UMBU_STRIPPED_LOG = registerBlock("umbu_stripped_log",
            ModLogs::new);
    public static final RegistryObject<Block> UMBU_STRIPPED_WOOD = registerBlock("umbu_stripped_wood",
            ModLogs::new);
    public static final RegistryObject<Block> UMBU_PLANKS = registerBlock("umbu_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> UMBU_LEAVES = registerBlock("umbu_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> UMBU_SAPLING = registerBlock("umbu_sapling",
            UmbuSapling::new);


    public static final RegistryObject<Block> MANGABA_LEAVES = registerBlock("mangaba_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> MANGABA_LOG = registerBlock("mangaba_log",
            ModLogs::new);
    public static final RegistryObject<Block> MANGABA_SAPLING = registerBlock("mangaba_sapling",
            MangabaSapling::new);


    public static final RegistryObject<Block> XANANA = registerBlock("xanana",
            XananaFlower::new);
    public static final RegistryObject<Block> XANANA_BIG = registerBlock("xanana_big",
            XananaFlower::new);
    public static final RegistryObject<Block> CNIDOSCOLUS_URENS = registerBlock("bull_nettle",
            BullNettlePlant::new);
    public static final RegistryObject<Block> CNIDOSCOLUS_URENS_FRUITING = registerBlock("bull_nettle_fruiting",
            BullNettlePlant::new);


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
