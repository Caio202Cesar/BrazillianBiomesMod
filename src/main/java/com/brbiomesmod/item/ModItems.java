package com.brbiomesmod.item;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.item.custom.BrazilnutFruit;
import com.brbiomesmod.item.custom.CashewFruit;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BrazillianBiomesMod.MOD_ID);

    public static final RegistryObject<Item> CASHEW_FRUIT = ITEMS.register("cashew_fruit",
            () -> new CashewFruit(new Item.Properties().group(ItemGroup.FOOD)));
    public static final RegistryObject<Item> CASHEW_APPLE = ITEMS.register("cashew_apple",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.CASHEW_APPLE)));
    public static final RegistryObject<Item> CASHEWNUT = ITEMS.register("cashewnut",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));
    public static final RegistryObject<Item> COOKED_CASHEWNUT = ITEMS.register("cooked_cashewnut",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.COOKED_CASHEWNUT)));

    public static final RegistryObject<Item> JUA_BERRIES = ITEMS.register("jua_berries",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.JUA_BERRIES)));

    public static final RegistryObject<Item> CAMBUCI = ITEMS.register("cambuci",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.CAMBUCI)));
    public static final RegistryObject<Item> PITANGA = ITEMS.register("pitanga",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.PITANGA)));
    public static final RegistryObject<Item> BLACK_PITANGA = ITEMS.register("black_pitanga",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.BLACK_PITANGA)));

    public static final RegistryObject<Item> PARANA_PINE_CONE = ITEMS.register("parana_pine_cone",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));
    public static final RegistryObject<Item> PARANA_PINE_COOKED_PINENUTS = ITEMS.register("parana_pine_cooked_pinenuts",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.COOKED_PARANA_PINENUT)));

    public static final RegistryObject<Item> GUARANA_FRUIT = ITEMS.register("guarana_fruit",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.GUARANA_FRUIT)));
    public static final RegistryObject<Item> GUARANA_SEEDS = ITEMS.register("guarana_seeds",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> BRAZILNUT_FRUIT = ITEMS.register("brazilnut_fruit",
            () -> new BrazilnutFruit(new Item.Properties().group(ItemGroup.FOOD)));
    public static final RegistryObject<Item> BRAZILNUT_SHELL = ITEMS.register("brazilnut_shell",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> BRAZILNUT_WITH_PELL = ITEMS.register("brazilnut_with_pell",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));
    public static final RegistryObject<Item> PELLED_BRAZILNUT = ITEMS.register("pelled_brazilnut",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.PELLED_BRAZILNUT)));
    public static final RegistryObject<Item> ROASTED_BRAZILNUT = ITEMS.register("roasted_brazilnut",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.ROASTED_BRAZILNUT)));

    public static final RegistryObject<Item> CASSAVA = ITEMS.register("cassava",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.CASSAVA)));
    public static final RegistryObject<Item> COOKED_CASSAVA = ITEMS.register("cooked_cassava",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.COOKED_CASSAVA)));
    public static final RegistryObject<Item> CASSAVA_SEEDS = ITEMS.register("cassava_seeds",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));

    //public static final RegistryObject<Item> ACAI_BERRIES = ITEMS.register("acai_berries", () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> UMBU = ITEMS.register("umbu",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.UMBU)));

    public static final RegistryObject<Item> MANGABA_FRUITS = ITEMS.register("mangaba_fruits",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.MANGABA)));

    public static final RegistryObject<Item> PINK_PEEPER = ITEMS.register("pink_peeper",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> CUPUACU = ITEMS.register("cupuacu",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.CUPUACU)));

    public static final RegistryObject<Item> WOLF_APPLE = ITEMS.register("wolf_apple",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.WOLF_APPLE)));

    public static final RegistryObject<Item> MATE_LEAF = ITEMS.register("mate_leaf",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> JABUTICABA = ITEMS.register("jabuticaba",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.JABUTICABA)));

    public static final RegistryObject<Item> PINEAPPLE_GUAVA = ITEMS.register("pineapple_guava",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.PINEAPPLE_GUAVA)));

    public static final RegistryObject<Item> TOURMALINE_PARAIBA = ITEMS.register("tourmaline_paraiba",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));


    public static final RegistryObject<Item> PURPLE_IPE_FLOWERS = ITEMS.register("purple_ipe_flowers",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));

    public static final RegistryObject<Item> WHITE_IPE_FLOWERS = ITEMS.register("white_ipe_flowers",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));

    public static final RegistryObject<Item> PINK_IPE_FLOWERS = ITEMS.register("pink_ipe_flowers",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));

    public static final RegistryObject<Item> YELLOW_IPE_FLOWERS = ITEMS.register("yellow_ipe_flowers",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
