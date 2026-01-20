package com.brbiomesmod.item;

import com.brbiomesmod.block.PlantsGroup;
import com.brbiomesmod.block.TreesGroup;
import com.brbiomesmod.block.WoodGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup FOOD_GROUP = new ItemGroup("BrazilianBiomes:Food")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.ACAI_BOWL.get());
        }};

    public static final ItemGroup FRUITS_AND_VEGETABLES_GROUP = new ItemGroup("BrazilianBiomes:Fruits&Vegetables")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.PARANA_PINE_CONE.get());
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
            return new ItemStack(ModItems.BRAZILNUT_SHELL.get());
        }};
}
