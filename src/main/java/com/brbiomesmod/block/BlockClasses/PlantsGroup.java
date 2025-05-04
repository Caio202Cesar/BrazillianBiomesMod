package com.brbiomesmod.block.BlockClasses;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.block.*;
import com.brbiomesmod.block.Custom.Log.JabuticabaFloweringLog;
import com.brbiomesmod.block.Custom.Log.JabuticabaFruitingLog;
import com.brbiomesmod.block.Custom.Leaves.*;
import com.brbiomesmod.block.Custom.Log.JabuticabaLog;
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

public class PlantsGroup {
    public static List<Block> blocksList = new ArrayList<>();

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, BrazillianBiomesMod.MOD_ID);


    public static final RegistryObject<Block> CATTLEYA_COCCINEA = registerBlock("cattleya_coccinea",
            () -> new FlowerBlock(Effects.NIGHT_VISION, 6, AbstractBlock.Properties.from(Blocks.CORNFLOWER)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_CATTLEYA_COCCINEA = BLOCKS.register("potted_cattleya_coccinea",
            () -> new FlowerPotBlock(PlantsGroup.CATTLEYA_COCCINEA.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> VELOZIA = registerBlock("velozia_plant",
            XaximPlant::new);
    public static final RegistryObject<Block> SMALL_XAXIM_PLANT = registerBlock("small_xaxim_plant",
            EpiphytePlant::new);
    public static final RegistryObject<Block> XAXIM_PLANT = registerBlock("xaxim_plant",
            XaximPlant::new);
    public static final RegistryObject<Block> AMAZONIAN_ZEBRA_PLANT = registerBlock("amazonian_zebra_plant",
            EpiphytePlant::new);
    public static final RegistryObject<Block> CASSAVA_PLANT = registerBlock("cassava_plant",
            CassavaPlant::new);
    public static final  RegistryObject<Block> CASSAVA_CROP = BLOCKS.register("cassava_crop",
            () -> new CassavaCropBlock(AbstractBlock.Properties.from(Blocks.WHEAT).sound(SoundType.CROP)));
    public static final RegistryObject<Block> WHITE_ANGEL_TRUMPET = registerBlock("angel_trumpet_white",
            AngelTrumpetPlant::new);
    public static final RegistryObject<Block> PINK_ANGEL_TRUMPET = registerBlock("angel_trumpet_pink",
            AngelTrumpetPlant::new);
    public static final RegistryObject<Block> YELLOW_ANGEL_TRUMPET = registerBlock("angel_trumpet_yellow",
            AngelTrumpetPlant::new);
    public static final RegistryObject<Block> SALMON_ANGEL_TRUMPET = registerBlock("angel_trumpet_salmon",
            AngelTrumpetPlant::new);
    public static final RegistryObject<Block> ORANGE_ANGEL_TRUMPET = registerBlock("angel_trumpet_orange",
            AngelTrumpetPlant::new);
    public static final RegistryObject<Block> PASSION_FRUIT_VINE = registerBlock("passion_fruit_vine",
            PassionfruitVine::new);
    public static final RegistryObject<Block> PASSION_FRUIT_FLOWERING_VINE = registerBlock("passion_fruit_flowering_vine",
            PassionfruitFloweringVine::new);
    public static final RegistryObject<Block> PASSION_FRUIT_FRUITING_VINE = registerBlock("passion_fruit_fruiting_vine",
            PassionfruitFruitingVine::new);
    public static final RegistryObject<Block> BRAZILLIAN_DUTCHMAN_PIPE_VINE = registerBlock("brazillian_dutchman_pipe_vine",
            AristolochiaVine::new);
    public static final RegistryObject<Block> TILLANDSIA_STRICTA = registerBlock("tillandsia_stricta",
            EpiphytePlant::new);
    public static final RegistryObject<Block> TURK_TURBAN_CACTUS = registerBlock("turk_turban_cactus",
            CactusPlant::new);
    public static final RegistryObject<Block> TURK_TURBAN_FRUITING_CACTUS = registerBlock("turk_turban_fruiting_cactus",
            FruitingCactusPlant::new);
    public static final RegistryObject<Block> CNIDOSCOLUS_URENS = registerBlock("bull_nettle",
            BullNettlePlant::new);
    public static final RegistryObject<Block> CNIDOSCOLUS_URENS_FRUITING = registerBlock("bull_nettle_fruiting",
            BullNettlePlant::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_CNIDOSCOLUS_URENS = BLOCKS.register("potted_bull_nettle",
            () -> new FlowerPotBlock(PlantsGroup.CNIDOSCOLUS_URENS.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance()));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_CNIDOSCOLUS_URENS_FRUITING = BLOCKS.register("potted_bull_nettle_fruiting",
            () -> new FlowerPotBlock(PlantsGroup.CNIDOSCOLUS_URENS_FRUITING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance()));

    public static final RegistryObject<Block> CATTLEYA_PURPURATA = registerBlock("cattleya_purpurata",
            () -> new FlowerBlock(Effects.JUMP_BOOST, 6, AbstractBlock.Properties.from(Blocks.CORNFLOWER)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_CATTLEYA_PURPURATA = BLOCKS.register("potted_cattleya_purpurata",
            () -> new FlowerPotBlock(PlantsGroup.CATTLEYA_PURPURATA.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));

    public static final RegistryObject<Block> CATTLEYA_LADY_ACKLAND = registerBlock("cattleya_lady_ackland",
            () -> new FlowerBlock(Effects.NIGHT_VISION, 6, AbstractBlock.Properties.from(Blocks.CORNFLOWER)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_CATTLEYA_LADY_ACKLAND = BLOCKS.register("potted_cattleya_lady_ackland",
            () -> new FlowerPotBlock(PlantsGroup.CATTLEYA_LADY_ACKLAND.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));

    public static final RegistryObject<Block> SILVER_VASE_BROMELIAD = registerBlock("silver_vase_bromeliad",
            EpiphytePlant::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_SILVER_VASE_BROMELIAD = BLOCKS.register("potted_silver_vase_bromeliad",
            () -> new FlowerPotBlock(PlantsGroup.SILVER_VASE_BROMELIAD.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));

    public static final RegistryObject<Block> FIREBALL_NEOREGELIA = registerBlock("fireball_neoregelia",
            EpiphytePlant::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_FIREBALL_NEOREGELIA = BLOCKS.register("potted_fireball_neoregelia",
            () -> new FlowerPotBlock(PlantsGroup.FIREBALL_NEOREGELIA.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));

    public static final RegistryObject<Block> AECHMEA_ALBA = registerBlock("aechmea_alba",
            EpiphytePlant::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_AECHMEA_ALBA = BLOCKS.register("potted_aechmea_alba",
            () -> new FlowerPotBlock(PlantsGroup.AECHMEA_ALBA.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));

    public static final RegistryObject<Block> NEOREGELIA_MARMORATA = registerBlock("neoregelia_marmorata",
            EpiphytePlant::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_NEOREGELIA_MARMORATA = BLOCKS.register("potted_neoregelia_marmorata",
            () -> new FlowerPotBlock(PlantsGroup.NEOREGELIA_MARMORATA.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));

    public static final RegistryObject<Block> RED_GUZMANIA = registerBlock("red_guzmania",
            EpiphytePlant::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_RED_GUZMANIA = BLOCKS.register("potted_red_guzmania",
            () -> new FlowerPotBlock(PlantsGroup.RED_GUZMANIA.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));

    public static final RegistryObject<Block> PINK_GUZMANIA = registerBlock("pink_guzmania",
            EpiphytePlant::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_PINK_GUZMANIA = BLOCKS.register("potted_pink_guzmania",
            () -> new FlowerPotBlock(PlantsGroup.PINK_GUZMANIA.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));

    public static final RegistryObject<Block> YELLOW_GUZMANIA = registerBlock("yellow_guzmania",
            EpiphytePlant::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_YELLOW_GUZMANIA = BLOCKS.register("potted_yellow_guzmania",
            () -> new FlowerPotBlock(PlantsGroup.YELLOW_GUZMANIA.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));

    public static final RegistryObject<Block> ORANGE_GUZMANIA = registerBlock("orange_guzmania",
            EpiphytePlant::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_ORANGE_GUZMANIA = BLOCKS.register("potted_orange_guzmania",
            () -> new FlowerPotBlock(PlantsGroup.ORANGE_GUZMANIA.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));

    public static final RegistryObject<Block> BLACK_ORCHID = registerBlock("black_orchid",
            OrchidPlant::new);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.PLANTS_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

