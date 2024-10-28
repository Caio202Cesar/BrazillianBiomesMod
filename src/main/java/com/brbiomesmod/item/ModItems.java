package com.brbiomesmod.item;

import com.brbiomesmod.BrazillianBiomesMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BrazillianBiomesMod.MOD_ID);

    public static final RegistryObject<Item> CASHEW_FRUIT = ITEMS.register("cashewfruit",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));
    public static final RegistryObject<Item> CASHEW_APPLE = ITEMS.register("cashew_apple",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));
    public static final RegistryObject<Item> CASHEWNUT = ITEMS.register("cashewnut",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));
    public static final RegistryObject<Item> COOKED_CASHEWNUT = ITEMS.register("cooked_cashewnut",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> JUA_BERRIES = ITEMS.register("jua_berries",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> CAMBUCI = ITEMS.register("cambuci",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));
    public static final RegistryObject<Item> PITANGA = ITEMS.register("pitanga",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));
    public static final RegistryObject<Item> BLACK_PITANGA = ITEMS.register("black_pitanga",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> PARANA_PINE_CONE = ITEMS.register("parana_pine_cone",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));
    public static final RegistryObject<Item> PARANA_PINE_COOKED_PINENUTS = ITEMS.register("parana_pine_cooked_pinenuts",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> GUARANA_FRUIT = ITEMS.register("guarana_fruit",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));
    public static final RegistryObject<Item> GUARANA_SEEDS = ITEMS.register("guarana_seeds",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> CASSAVA = ITEMS.register("cassava",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> ACAI_BERRIES = ITEMS.register("acai_berries",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> UMBU = ITEMS.register("umbu",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> WOLF_APPLE = ITEMS.register("wolf_apple",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> MATE_LEAF = ITEMS.register("mate_leaf",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> JABUTICABA = ITEMS.register("jabuticaba",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> PINEAPPLE_GUAVA = ITEMS.register("pineapple_guava",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> TOURMALINE_PARAIBA = ITEMS.register("tourmaline_paraiba",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
