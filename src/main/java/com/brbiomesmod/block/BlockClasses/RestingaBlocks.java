package com.brbiomesmod.block.BlockClasses;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.block.BeachFlower;
import com.brbiomesmod.block.ModLeaves;
import com.brbiomesmod.block.ModLogs;
import com.brbiomesmod.block.ModPlanks;
import com.brbiomesmod.block.Saplings.CashewSapling;
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

public class RestingaBlocks {
    public static List<Block> blocksList = new ArrayList<>();

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, BrazillianBiomesMod.MOD_ID);


    public static final RegistryObject<Block> CASHEW_LOG = registerBlock("cashew_log",
            ModLogs::new);
    public static final RegistryObject<Block> CASHEW_WOOD = registerBlock("cashew_wood",
            ModLogs::new);
    public static final RegistryObject<Block> CASHEW_STRIPPED_LOG = registerBlock("cashew_stripped_log",
            ModLogs::new);
    public static final RegistryObject<Block> CASHEW_STRIPPED_WOOD = registerBlock("cashew_stripped_wood",
            ModLogs::new);
    public static final RegistryObject<Block> CASHEW_PLANKS = registerBlock("cashew_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> CASHEW_LEAVES = registerBlock("cashew_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> CASHEW_SAPLING = registerBlock("cashew_sapling",
            CashewSapling::new);


    public static final RegistryObject<Block> IPOMAEA_PES_CAPRAE = registerBlock("ipomaea_pes_caprae",
            BeachFlower::new);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.RESTINGA_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

