package com.brbiomesmod.item;

import com.brbiomesmod.block.BlockClasses.PampasPlainsBlocks;
import com.brbiomesmod.block.BlockClasses.RestingaBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup CAATINGA_GROUP = new ItemGroup("BRBCaatingaTab")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.JUA_BERRIES.get());
        }
    };

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

    public static final ItemGroup RESTINGA_GROUP = new ItemGroup("BRBRestingaTab")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(RestingaBlocks.IPOMAEA_PES_CAPRAE.get());
        }
    };

    public static final ItemGroup CERRADO_SAVANNA_GROUP = new ItemGroup("BRBCerradoSavannaTab")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.WOLF_APPLE.get());
        }
    };

    public static final ItemGroup PAMPAS_GROUP = new ItemGroup("BRBPampasTab")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(PampasPlainsBlocks.CAVEN_THORN_SAPLING.get());
        }
    };
}
