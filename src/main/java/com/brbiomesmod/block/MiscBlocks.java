package com.brbiomesmod.block;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.block.Custom.CaatingaSand;
import com.brbiomesmod.block.Custom.Crops.CassavaCropBlock;
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

public class MiscBlocks {
    public static List<Block> blocksList = new ArrayList<>();

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, BrazillianBiomesMod.MOD_ID);

    public static final RegistryObject<Block> CAATINGA_SAND = registerBlock("caatinga_sand",
            CaatingaSand::new);

    public static final  RegistryObject<Block> CASSAVA_CROP = BLOCKS.register("cassava_crop",
            () -> new CassavaCropBlock(AbstractBlock.Properties.from(Blocks.WHEAT).sound(SoundType.CROP)));

    public static final RegistryObject<Block> TOURMALINE_PARAIBA_ORE = registerBlock("tourmaline_paraiba_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(2).harvestTool(ToolType.PICKAXE)
                    .setRequiresTool().hardnessAndResistance(5f)));
    public static final RegistryObject<Block> TOURMALINE_PARAIBA_BLOCK = registerBlock("tourmaline_paraiba_block",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON).harvestLevel(2).harvestTool(ToolType.PICKAXE)
                    .setRequiresTool().hardnessAndResistance(5f)));

    public static final RegistryObject<Block> RAW_RUBBER_BLOCK = registerBlock("raw_rubber_block",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL).harvestLevel(2).harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1f)));
    public static final RegistryObject<Block> VULCANIZED_RUBBER_BLOCK = registerBlock("vulcanized_rubber_block",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL).harvestLevel(2).harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1f)));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.MISC_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
