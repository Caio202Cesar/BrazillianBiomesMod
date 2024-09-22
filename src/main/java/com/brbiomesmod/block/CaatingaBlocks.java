package com.brbiomesmod.block;

import com.brbiomesmod.BrazillianBiomesMod;
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
            () -> new Block(AbstractBlock.Properties.of(Material.DIRT).harvestLevel(1).harvestTool(ToolType.SHOVEL)
                    .strength(0.5f).sound(SoundType.SAND)));


    public static final RegistryObject<Block> CASHEW_LOG = registerBlock("cashew_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0f).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> CASHEW_WOOD = registerBlock("cashew_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0f).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> CASHEW_STRIPPED_LOG = registerBlock("cashew_stripped_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(2.0f).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> CASHEW_STRIPPED_WOOD = registerBlock("cashew_stripped_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(2.0f).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> CASHEW_PLANKS = registerBlock("cashew_planks",
            () -> new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(2.0f, 3.0f).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> CASHEW_LEAVES = registerBlock("cashew_leaves",
            () -> new LeavesBlock(AbstractBlock.Properties.of(Material.LEAVES).strength(0.2F).randomTicks()
                    .sound(SoundType.GRASS).noOcclusion().isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false)
                    .harvestTool(ToolType.HOE)));

    public static final RegistryObject<Block> CASHEW_FRUITING_LEAVES = registerBlock("cashew_fruiting_leaves",
            () -> new LeavesBlock(AbstractBlock.Properties.of(Material.LEAVES).strength(0.2F).randomTicks()
                    .sound(SoundType.GRASS).noOcclusion().isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false)
                    .harvestTool(ToolType.HOE)));


    public static final RegistryObject<Block> JUA_LOG = registerBlock("jua_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0f).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> JUA_WOOD = registerBlock("jua_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0f).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> JUA_STRIPPED_LOG = registerBlock("jua_stripped_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(2.0f).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> JUA_STRIPPED_WOOD = registerBlock("jua_stripped_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(2.0f).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> JUA_PLANKS = registerBlock("jua_planks",
            () -> new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(2.0f, 3.0f).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> JUA_LEAVES = registerBlock("jua_leaves",
            () -> new LeavesBlock(AbstractBlock.Properties.of(Material.LEAVES).strength(0.2F).randomTicks()
                    .sound(SoundType.GRASS).noOcclusion().isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false)
                    .harvestTool(ToolType.HOE)));

    public static final RegistryObject<Block> JUA_FRUITING_LEAVES = registerBlock("jua_fruiting_leaves",
            () -> new LeavesBlock(AbstractBlock.Properties.of(Material.LEAVES).strength(0.2F).randomTicks()
                    .sound(SoundType.GRASS).noOcclusion().isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false)
                    .harvestTool(ToolType.HOE)));


    public static final RegistryObject<Block> BLACK_JUREMA_LOG = registerBlock("black_jurema_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0f).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> BLACK_JUREMA_WOOD = registerBlock("black_jurema_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0f).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> BLACK_JUREMA_LEAVES = registerBlock("black_jurema_leaves",
            () -> new LeavesBlock(AbstractBlock.Properties.of(Material.LEAVES).strength(0.2F).randomTicks()
                    .sound(SoundType.GRASS).noOcclusion().isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false)
                    .harvestTool(ToolType.HOE)));


    public static final RegistryObject<Block> UMBU_LOG = registerBlock("umbu_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0f).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> UMBU_WOOD = registerBlock("umbu_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0f).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> UMBU_STRIPPED_LOG = registerBlock("umbu_stripped_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(2.0f).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> UMBU_STRIPPED_WOOD = registerBlock("umbu_stripped_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(2.0f).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> UMBU_PLANKS = registerBlock("umbu_planks",
            () -> new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(2.0f, 3.0f).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> UMBU_LEAVES = registerBlock("umbu_leaves",
            () -> new LeavesBlock(AbstractBlock.Properties.of(Material.LEAVES).strength(0.2F).randomTicks()
                    .sound(SoundType.GRASS).noOcclusion().isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false)
                    .harvestTool(ToolType.HOE)));

    public static final RegistryObject<Block> UMBU_FRUITING_LEAVES = registerBlock("umbu_fruiting_leaves",
            () -> new LeavesBlock(AbstractBlock.Properties.of(Material.LEAVES).strength(0.2F).randomTicks()
                    .sound(SoundType.GRASS).noOcclusion().isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false)
                    .harvestTool(ToolType.HOE)));


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ModItemGroup.CAATINGA_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
