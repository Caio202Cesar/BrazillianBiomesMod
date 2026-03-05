package com.brbiomesmod.item;

import com.brbiomesmod.block.PlantsGroup;
import com.brbiomesmod.block.TreesGroup;
import com.brbiomesmod.block.WoodGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup FOOD_GROUP = new ItemGroup("brazilian_biomes_food")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.ACAI_BOWL.get());
        }};

    public static final ItemGroup FRUITS_AND_VEGETABLES_GROUP = new ItemGroup("brazilian_biomes_fruits_vegetables")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.PARANA_PINE_CONE.get());
        }};

    public static final ItemGroup PLANTS_GROUP = new ItemGroup("brazilian_biomes_plants")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(PlantsGroup.AMAZONIAN_ZEBRA_PLANT.get());
        }};

    public static final ItemGroup WOOD_GROUP = new ItemGroup("brazilian_biomes_woods")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(WoodGroup.BALSA_PLANKS.get());
        }};

    public static final ItemGroup TREE_GROUP = new ItemGroup("brazilian_biomes_trees")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(TreesGroup.BRAZILWOOD_SAPLING.get());
        }};

    public static final ItemGroup MISC_GROUP = new ItemGroup("brazilian_biomes_miscellaneous")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.BRAZILNUT_SHELL.get());
        }};

    public static final ItemGroup CREATURES_GROUP = new ItemGroup("brazilian_biomes_creatures")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.MAPINGUARI_SPAWN_EGG.get());
        }};
}
