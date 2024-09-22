package com.brbiomesmod.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup CAATINGA_GROUP = new ItemGroup("BRBCaatingaTab")
    {
        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(ModItems.JUA_BERRIES.get());
        }
    };

    public static final ItemGroup ATLANTIC_FOREST_GROUP = new ItemGroup("BRBAtlanticForestTab")
    {
        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(ModItems.CAMBUCI.get());
        }
    };

    public static final ItemGroup ARAUCARIA_PLATEAU_GROUP = new ItemGroup("BRBAraucariaPlateauTab")
    {
        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(ModItems.PARANA_PINE_CONE.get());
        }
    };

    public static final ItemGroup AMAZON_RAINFOREST_GROUP = new ItemGroup("BRBAmazonRainforestTab")
    {
        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(ModItems.GUARANA_FRUIT.get());
        }
    };
}
