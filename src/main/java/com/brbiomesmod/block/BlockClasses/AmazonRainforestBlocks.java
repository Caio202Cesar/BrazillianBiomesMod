package com.brbiomesmod.block.BlockClasses;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.block.*;
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
            ModLeaves::new);
    public static final RegistryObject<Block> KAPOK_SAPLING = registerBlock("kapok_sapling",
            KapokSapling::new);
    public static final RegistryObject<Block> KAPOK_WOOD = registerBlock("kapok_wood",
            ModLogs::new);

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
    public static final RegistryObject<Block> BALSA_STAIRS = registerBlock("balsa_stairs",
            () -> new StairsBlock(() -> BALSA_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));


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
    public static final RegistryObject<Block> LOPHANTERA_STAIRS = registerBlock("lophantera_stairs",
            () -> new StairsBlock(() -> LOPHANTERA_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));


    //Cupuacu and Guarana trunk is made of Jungle Log
    public static final RegistryObject<Block> CUPUACU_LEAVES = registerBlock("cupuacu_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> CUPUACU_SAPLING = registerBlock("cupuacu_sapling",
            CupuacuSapling::new);

    public static final RegistryObject<Block> GUARANA_LEAVES = registerBlock("guarana_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> GUARANA_SAPLING = registerBlock("guarana_sapling",
            GuaranaSapling::new);


    public static final RegistryObject<Block> BRAZILNUT_LOG = registerBlock("brazilnut_log",
            ModLogs::new);
    public static final RegistryObject<Block> BRAZILNUT_LEAVES = registerBlock("brazilnut_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> BRAZILNUT_PLANKS = registerBlock("brazilnut_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> BRAZILNUT_SAPLING = registerBlock("brazilnut_sapling",
            BrazilnutSapling::new);
    public static final RegistryObject<Block> BRAZILNUT_WOOD = registerBlock("brazilnut_wood",
            ModLogs::new);
    public static final RegistryObject<Block> BRAZILNUT_STAIRS = registerBlock("brazilnut_stairs",
            () -> new StairsBlock(() -> BRAZILNUT_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));


    //public static final RegistryObject<Block> PALMITO_LOG = registerBlock("palmito_log", ModLogs::new);
    //public static final RegistryObject<Block> PALMITO = registerBlock("palmito", ModLogs::new);
    //public static final RegistryObject<Block> ACAI_FROND = registerBlock("acai_frond", ModLeaves::new);
    //public static final RegistryObject<Block> ACAI_BUNCH = registerBlock("acai_bunch", AcaiBunchBlock::new);


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
    public static final RegistryObject<Block> SHARINGA_STAIRS = registerBlock("sharinga_stairs",
            () -> new StairsBlock(() -> SHARINGA_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));


    public static final RegistryObject<Block> BACURI_LOG = registerBlock("bacuri_log",
            ModLogs::new);
    public static final RegistryObject<Block> BACURI_LEAVES = registerBlock("bacuri_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> BACURI_PLANKS = registerBlock("bacuri_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> BACURI_SAPLING = registerBlock("bacuri_sapling",
            BacuriSapling::new);
    public static final RegistryObject<Block> BACURI_WOOD = registerBlock("bacuri_wood",
            ModLogs::new);
    public static final RegistryObject<Block> BACURI_STAIRS = registerBlock("bacuri_stairs",
            () -> new StairsBlock(() -> BACURI_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));


    public static final RegistryObject<Block> CAMU_CAMU_LOG = registerBlock("camu_camu_log",
            ModLogs::new);
    public static final RegistryObject<Block> CAMU_CAMU_LEAVES = registerBlock("camu_camu_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> CAMU_CAMU_PLANKS = registerBlock("camu_camu_planks",
            ModPlanks::new);
    public static final RegistryObject<Block> CAMU_CAMU_SAPLING = registerBlock("camu_camu_sapling",
            CamuCamuSapling::new);
    public static final RegistryObject<Block> CAMU_CAMU_WOOD = registerBlock("camu_camu_wood",
            ModLogs::new);
    public static final RegistryObject<Block> CAMU_CAMU_STAIRS = registerBlock("camu_camu_stairs",
            () -> new StairsBlock(() -> CAMU_CAMU_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(1).harvestTool(ToolType.AXE)));


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
