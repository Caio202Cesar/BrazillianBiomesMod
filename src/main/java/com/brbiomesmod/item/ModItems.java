package com.brbiomesmod.item;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.block.MiscBlocks;
import com.brbiomesmod.item.custom.*;
import net.minecraft.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BrazillianBiomesMod.MOD_ID);

    //Food
    public static final RegistryObject<Item> CASHEW_FRUIT = ITEMS.register("cashew_fruit",
            () -> new CashewFruit(new Item.Properties().group(ModItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> CASHEW_APPLE = ITEMS.register("cashew_apple",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.CASHEW_APPLE)));
    public static final RegistryObject<Item> CASHEW_JUICE = ITEMS.register("cashew_apple_juice",
            () -> new BeverageItem(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1)
                    .food(ModFoods.CASHEW_JUICE)));
    public static final RegistryObject<Item> CASHEWNUT = ITEMS.register("cashewnut",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> COOKED_CASHEWNUT = ITEMS.register("cooked_cashewnut",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.COOKED_CASHEWNUT)));
    public static final RegistryObject<Item> JUA_BERRIES = ITEMS.register("jua_berries",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.JUA_BERRIES)));
    public static final RegistryObject<Item> CAMBUCI = ITEMS.register("cambuci",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.CAMBUCI)));
    public static final RegistryObject<Item> CAMBUCI_JUICE = ITEMS.register("cambuci_juice",
            () -> new BeverageItem(new Item.Properties().group(ModItemGroup.FOOD_GROUP).maxStackSize(1)
                    .food(ModFoods.CAMBUCI_JUICE)));
    public static final RegistryObject<Item> PITANGA = ITEMS.register("pitanga",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.PITANGA)));
    public static final RegistryObject<Item> PITANGA_JUICE = ITEMS.register("pitanga_juice",
            () -> new BeverageItem(new Item.Properties().group(ModItemGroup.FOOD_GROUP).maxStackSize(1)
                    .food(ModFoods.PITANGA_JUICE)));
    public static final RegistryObject<Item> BLACK_PITANGA = ITEMS.register("black_pitanga",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.BLACK_PITANGA)));
    public static final RegistryObject<Item> BLACK_PITANGA_JUICE = ITEMS.register("black_pitanga_juice",
            () -> new BeverageItem(new Item.Properties().group(ModItemGroup.FOOD_GROUP).maxStackSize(1)
                    .food(ModFoods.BLACK_PITANGA_JUICE)));
    public static final RegistryObject<Item> RIO_GRANDE_CHERRY = ITEMS.register("rio_grande_cherry",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.RIO_GRANDE_CHERRY)));
    public static final RegistryObject<Item> RIO_GRANDE_CHERRY_JUICE = ITEMS.register("rio_grande_cherry_juice",
            () -> new BeverageItem(new Item.Properties().group(ModItemGroup.FOOD_GROUP).maxStackSize(1)
                    .food(ModFoods.RIO_GRANDE_CHERRY_JUICE)));
    public static final RegistryObject<Item> UMBU = ITEMS.register("umbu",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.UMBU)));
    public static final RegistryObject<Item> UMBU_JUICE = ITEMS.register("umbu_juice",
            () -> new BeverageItem(new Item.Properties().group(ModItemGroup.FOOD_GROUP).maxStackSize(1)
                    .food(ModFoods.UMBU_JUICE)));
    public static final RegistryObject<Item> MANGABA_FRUITS = ITEMS.register("mangaba_fruits",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.MANGABA)));
    public static final RegistryObject<Item> MANGABA_JUICE = ITEMS.register("mangaba_juice",
            () -> new BeverageItem(new Item.Properties().group(ModItemGroup.FOOD_GROUP).maxStackSize(1)
                    .food(ModFoods.MANGABA_JUICE)));
    public static final RegistryObject<Item> WOLF_APPLE = ITEMS.register("wolf_apple",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.WOLF_APPLE)));
    public static final RegistryObject<Item> PARANA_PINE_CONE = ITEMS.register("parana_pine_cone",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> PARANA_PINE_COOKED_PINENUTS = ITEMS.register("parana_pine_cooked_pinenuts",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.COOKED_PARANA_PINENUT)));
    public static final RegistryObject<Item> GUARANA_FRUIT = ITEMS.register("guarana_fruit",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.GUARANA_FRUIT)));
    public static final RegistryObject<Item> GUARANA_SEEDS = ITEMS.register("guarana_seeds",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> GUARANA_SODA = ITEMS.register("guarana_soda",
            () -> new BeverageItem(new Item.Properties().group(ModItemGroup.FOOD_GROUP).maxStackSize(1)
                    .food(ModFoods.GUARANA_SODA)));
    public static final RegistryObject<Item> BRAZILNUT_FRUIT = ITEMS.register("brazilnut_fruit",
            () -> new BrazilnutFruit(new Item.Properties().group(ModItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> BRAZILNUT_WITH_PELL = ITEMS.register("brazilnut_with_pell",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> PELLED_BRAZILNUT = ITEMS.register("pelled_brazilnut",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.PELLED_BRAZILNUT)));
    public static final RegistryObject<Item> ROASTED_BRAZILNUT = ITEMS.register("roasted_brazilnut",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.ROASTED_BRAZILNUT)));
    public static final RegistryObject<Item> SAPUCAIA_FRUIT = ITEMS.register("sapucaia_fruit",
            () -> new SapucaiaFruit(new Item.Properties().group(ModItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> SAPUCAIA_NUTS = ITEMS.register("sapucaia_nuts",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.SAPUCAIA_NUTS)));
    public static final RegistryObject<Item> CASSAVA = ITEMS.register("cassava",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.CASSAVA)));
    public static final RegistryObject<Item> COOKED_CASSAVA = ITEMS.register("cooked_cassava",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.COOKED_CASSAVA)));
    public static final RegistryObject<Item> ACAI_BERRIES = ITEMS.register("acai_berries",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.ACAI_BERRIES)));
    public static final RegistryObject<Item> ACAI_JUICE = ITEMS.register("acai_juice",
            () -> new BeverageItem(new Item.Properties().group(ModItemGroup.FOOD_GROUP).maxStackSize(1)
                    .food(ModFoods.ACAI_JUICE)));
    public static final RegistryObject<Item> ACAI_BOWL = ITEMS.register("acai_bowl",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.ACAI_BOWL)));
    public static final RegistryObject<Item> ACAI_WITH_BANANA = ITEMS.register("acai_with_banana",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.ACAI_WITH_BANANA)));//extra food
    public static final RegistryObject<Item> ACAI_WITH_CUPUACU = ITEMS.register("acai_with_cupuacu",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.ACAI_WITH_CUPUACU)));
    public static final RegistryObject<Item> PALM_HEART = ITEMS.register("palm_heart",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.PALM_HEART)));
    public static final RegistryObject<Item> CUPUACU = ITEMS.register("cupuacu",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.CUPUACU)));
    public static final RegistryObject<Item> CUPUACU_CREAM = ITEMS.register("cupuacu_cream",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.CUPUACU_CREAM)));
    public static final RegistryObject<Item> CUPUACU_JUICE = ITEMS.register("cupuacu_juice",
            () -> new BeverageItem(new Item.Properties().group(ModItemGroup.FOOD_GROUP).maxStackSize(1)
                    .food(ModFoods.CUPUACU_JUICE)));
    public static final RegistryObject<Item> BURITI = ITEMS.register("buriti",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.BURITI)));
    public static final RegistryObject<Item> BURITI_JUICE = ITEMS.register("buriti_juice",
            () -> new BeverageItem(new Item.Properties().group(ModItemGroup.FOOD_GROUP).maxStackSize(1)
                    .food(ModFoods.BURITI_JUICE)));
    public static final RegistryObject<Item> BANANA = ITEMS.register("banana",
            () -> new ExoticItem(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.BANANA)));
    public static final RegistryObject<Item> PINK_PEEPER = ITEMS.register("pink_peeper",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.PINK_PEPPER)));
    public static final RegistryObject<Item> PINEAPPLE_GUAVA = ITEMS.register("pineapple_guava",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.PINEAPPLE_GUAVA)));
    public static final RegistryObject<Item> FEIJOA_JUICE = ITEMS.register("feijoa_juice",
            () -> new BeverageItem(new Item.Properties().group(ModItemGroup.FOOD_GROUP).maxStackSize(1)
                    .food(ModFoods.FEIJOA_JUICE)));
    public static final RegistryObject<Item> JABUTICABA = ITEMS.register("jabuticaba",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.JABUTICABA)));
    public static final RegistryObject<Item> JABUTICABA_JUICE = ITEMS.register("jabuticaba_juice",
            () -> new BeverageItem(new Item.Properties().group(ModItemGroup.FOOD_GROUP).maxStackSize(1)
                    .food(ModFoods.JABUTICABA_JUICE)));
    public static final RegistryObject<Item> PASSIONFRUIT = ITEMS.register("passionfruit",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.PASSIONFRUIT)));
    public static final RegistryObject<Item> PASSIONFRUIT_JUICE = ITEMS.register("passionfruit_juice",
            () -> new BeverageItem(new Item.Properties().group(ModItemGroup.FOOD_GROUP).maxStackSize(1)
                    .food(ModFoods.PASSIONFRUIT_JUICE)));
    public static final RegistryObject<Item> CAMU_CAMU_JUICE = ITEMS.register("camu_camu_juice",
            () -> new BeverageItem(new Item.Properties().group(ModItemGroup.FOOD_GROUP).maxStackSize(1)
                    .food(ModFoods.CAMU_CAMU_JUICE)));
    public static final RegistryObject<Item> TURK_TURBAN_BERRIES = ITEMS.register("turk_turban_berries",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.TURK_TURBAN_BERRIES)));
    public static final RegistryObject<Item> CAGAITA = ITEMS.register("cagaita_fruits",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.CAGAITA)));
    public static final RegistryObject<Item> CECROPIA_FRUITS = ITEMS.register("cecropia_fruits",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.CECROPIA_FRUITS)));
    public static final RegistryObject<Item> BACURI = ITEMS.register("bacuri",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.BACURI)));
    public static final RegistryObject<Item> MONKEY_CAJARANA = ITEMS.register("monkey_cajarana",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.MONKEY_CAJARANA)));
    public static final RegistryObject<Item> CAMU_CAMU_FRUITS = ITEMS.register("camu_camu_fruits",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.CAMU_CAMU_FRUITS)));
    public static final RegistryObject<Item> MATE = ITEMS.register("mate",
            () -> new MateItem(new Item.Properties().group(ModItemGroup.FOOD_GROUP).maxStackSize(1)
                    .food(ModFoods.MATE)));
    public static final RegistryObject<Item> BACURI_PASTE = ITEMS.register("bacuri_paste",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.BACURI_PASTE)));
    public static final RegistryObject<Item> COOKED_BANANA_FLOWER = ITEMS.register("cooked_banana_flower",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.COOKED_BANANA_FLOWER)));
    public static final RegistryObject<Item> BUTIA_FRUITS = ITEMS.register("butia_fruits",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.BUTIA)));
    public static final RegistryObject<Item> JENIPAPO = ITEMS.register("jenipapo",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP).food(ModFoods.JENIPAPO)));
    public static final RegistryObject<Item> PEQUI = ITEMS.register("pequi_fruit",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> COOKED_PEQUI = ITEMS.register("cooked_pequi_fruit",
            () -> new Item(new Item.Properties().group(ModItemGroup.FOOD_GROUP)));

    //Materials
    public static final RegistryObject<Item> BRAZILNUT_SHELL = ITEMS.register("brazilnut_shell",
            () -> new Item(new Item.Properties().group(ModItemGroup.MISC_GROUP)));
    public static final RegistryObject<Item> SAPUCAIA_SHELL = ITEMS.register("sapucaia_shell",
            () -> new Item(new Item.Properties().group(ModItemGroup.MISC_GROUP)));
    public static final RegistryObject<Item> TOURMALINE_PARAIBA = ITEMS.register("tourmaline_paraiba",
            () -> new Item(new Item.Properties().group(ModItemGroup.MISC_GROUP)));
    public static final RegistryObject<Item> PURPLE_IPE_FLOWERS = ITEMS.register("purple_ipe_flowers",
            () -> new Item(new Item.Properties().group(ModItemGroup.MISC_GROUP)));
    public static final RegistryObject<Item> WHITE_IPE_FLOWERS = ITEMS.register("white_ipe_flowers",
            () -> new Item(new Item.Properties().group(ModItemGroup.MISC_GROUP)));
    public static final RegistryObject<Item> PINK_IPE_FLOWERS = ITEMS.register("pink_ipe_flowers",
            () -> new Item(new Item.Properties().group(ModItemGroup.MISC_GROUP)));
    public static final RegistryObject<Item> YELLOW_IPE_FLOWERS = ITEMS.register("yellow_ipe_flowers",
            () -> new Item(new Item.Properties().group(ModItemGroup.MISC_GROUP)));
    public static final RegistryObject<Item> SILK_COTTON = ITEMS.register("silk_cotton",
            () -> new Item(new Item.Properties().group(ModItemGroup.MISC_GROUP)));
    public static final RegistryObject<Item> CASSAVA_SEEDS = ITEMS.register("cassava_seeds",
            () -> new BlockItem(MiscBlocks.CASSAVA_CROP.get(), new Item.Properties().group(ModItemGroup.MISC_GROUP)));
    public static final RegistryObject<Item> CALABASH_SEEDS = ITEMS.register("calabash_seeds",
            () -> new BlockItem(MiscBlocks.CALABASH_CROP.get(), new Item.Properties().group(ModItemGroup.MISC_GROUP)));
    public static final RegistryObject<Item> CALABASH = ITEMS.register("calabash",
            () -> new ExoticItem(new Item.Properties().group(ModItemGroup.MISC_GROUP)));
    public static final RegistryObject<Item> MATE_CUP = ITEMS.register("mate_cup",
            () -> new Item(new Item.Properties().group(ModItemGroup.MISC_GROUP)));
    public static final RegistryObject<Item> DRIED_CARNAUBA_LEAVES = ITEMS.register("dried_carnauba_leaves",
            () -> new Item(new Item.Properties().group(ModItemGroup.MISC_GROUP)));
    public static final RegistryObject<Item> CARNAUBA_WAX = ITEMS.register("carnauba_wax",
            () -> new Item(new Item.Properties().group(ModItemGroup.MISC_GROUP)));
    public static final RegistryObject<Item> MATE_LEAF = ITEMS.register("mate_leaf",
            () -> new Item(new Item.Properties().group(ModItemGroup.MISC_GROUP)));
    public static final RegistryObject<Item> ASSACU_POISON_SAP = ITEMS.register("assacu_poison_sap",
            () -> new Item(new Item.Properties().group(ModItemGroup.MISC_GROUP)));

    //Tools
    public static final RegistryObject<Item> TOURMALINE_SWORD = ITEMS.register("tourmaline_paraiba_sword",
            () -> new SwordItem(ModItemTier.TOURMALINE, 3, -2.4F,
                    new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> TOURMALINE_PICKAXE = ITEMS.register("tourmaline_paraiba_pickaxe",
            () -> new PickaxeItem(ModItemTier.TOURMALINE, 1, -2.8F,
                    new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> TOURMALINE_SHOVEL = ITEMS.register("tourmaline_paraiba_shovel",
            () -> new ShovelItem(ModItemTier.TOURMALINE, 1.5F, -3.0F,
                    new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> TOURMALINE_AXE = ITEMS.register("tourmaline_paraiba_axe",
            () -> new AxeItem(ModItemTier.TOURMALINE, 5.0F, -3.0F,
                    new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> TOURMALINE_HOE = ITEMS.register("tourmaline_paraiba_hoe",
            () -> new HoeItem(ModItemTier.TOURMALINE, -3, 0.0F,
                    new Item.Properties().group(ItemGroup.TOOLS)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
