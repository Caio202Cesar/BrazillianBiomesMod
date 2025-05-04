package com.brbiomesmod.item;

import com.brbiomesmod.block.BlockClasses.*;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup FOOD_GROUP = new ItemGroup("BrazilianBiomes:Food")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.CAMBUCI.get());
        }};

    public static final ItemGroup PLANTS_GROUP = new ItemGroup("BrazilianBiomes:Plants")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(PlantsGroup.AMAZONIAN_ZEBRA_PLANT.get());
        }};

    public static final ItemGroup WOOD_GROUP = new ItemGroup("BrazilianBiomes:Woods")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(WoodGroup.BALSA_PLANKS.get());
        }};

    public static final ItemGroup TREE_GROUP = new ItemGroup("BrazilianBiomes:Trees")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(TreesGroup.BRAZILWOOD_SAPLING.get());
        }};

    public static final ItemGroup MISC_GROUP = new ItemGroup("BrazilianBiomes:Miscellaneous")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(MiscBlocks.CAATINGA_SAND.get());
        }};






    public static final ItemGroup ATLANTIC_FOREST_GROUP = new ItemGroup("BRBAtlanticForestTab")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.CAMBUCI.get());
        }
    };

    public static final ItemGroup ARAUCARIA_PLATEAU_GROUP = new ItemGroup("BRBAraucariaPlateauTab")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.PARANA_PINE_CONE.get());
        }
    };

    public static final ItemGroup AMAZON_RAINFOREST_GROUP = new ItemGroup("BRBAmazonRainforestTab")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.GUARANA_FRUIT.get());
        }
    };
}
