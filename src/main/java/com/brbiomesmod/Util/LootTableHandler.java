package com.brbiomesmod.Util;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.item.ModItems;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.block.Blocks;
import net.minecraft.block.CocoaBlock;
import net.minecraft.loot.ConstantRange;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.conditions.BlockStateProperty;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        modid = BrazillianBiomesMod.MOD_ID,
        bus = Mod.EventBusSubscriber.Bus.FORGE
)
public class LootTableHandler {

    @SubscribeEvent
    public static void onLootTableLoad(LootTableLoadEvent event) {

        if (event.getName().equals(
                new ResourceLocation("minecraft", "blocks/cocoa"))) {

            event.setTable(
                    LootTable.builder()
                            .addLootPool(
                                    LootPool.builder()
                                            .name("cocoa_fruit")
                                            .rolls(ConstantRange.of(1))
                                            .addEntry(
                                                    ItemLootEntry.builder(
                                                                    ModItems.COCOA_FRUIT.get()
                                                            )
                                                            .acceptCondition(
                                                                    BlockStateProperty.builder(
                                                                                    Blocks.COCOA
                                                                            )
                                                                            .fromProperties(
                                                                                    StatePropertiesPredicate.Builder
                                                                                            .newBuilder()
                                                                                            .withIntProp(
                                                                                                    CocoaBlock.AGE,
                                                                                                    2
                                                                                            )
                                                                            )
                                                            )
                                            )
                            )
                            .build()
            );
        }
    }
}
