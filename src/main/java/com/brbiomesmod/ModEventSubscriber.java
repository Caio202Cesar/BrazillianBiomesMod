package com.brbiomesmod;

import com.brbiomesmod.Seasons.Season;
import com.brbiomesmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

@Mod.EventBusSubscriber(modid = BrazillianBiomesMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEventSubscriber {

    @SubscribeEvent
    public static void onRenderGameOverlay(RenderGameOverlayEvent.Text event) {
        Season.onRenderGameOverlay(event);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        PlayerEntity player = event.player;
        ItemStack heldItem = player.getHeldItemMainhand(); // or getHeldItemOffhand()

        if (!heldItem.isEmpty() && heldItem.getItem() == ModItems.ASSACU_POISON_SAP.get()) {
            // Apply nausea effect if not already present
            if (!player.isPotionActive(Effects.POISON)) {
                player.addPotionEffect(new EffectInstance(Effects.POISON, 60, 30, true, true));
            }
            if (!player.isPotionActive(Effects.BLINDNESS)) {
                player.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 400, 300, true, true));
            }
            if (!player.isPotionActive(Effects.INSTANT_DAMAGE)) {
                player.addPotionEffect(new EffectInstance(Effects.INSTANT_DAMAGE, 60, 70, true, true));
            }
        }
    }

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {

        PlayerEntity player = event.getPlayer();
        if (player == null) return;

        ItemStack tool = player.getHeldItemMainhand();

        if (!isRubberized(tool)) return;

        World world = (World) event.getWorld();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);

        if (!(world instanceof ServerWorld)) return;

        // Cancel normal drop behavior
        event.setCanceled(true);

        // Create fake Silk Touch tool
        ItemStack silkTool = tool.copy();
        silkTool.addEnchantment(Enchantments.SILK_TOUCH, 1);

        LootContext.Builder builder = new LootContext.Builder((ServerWorld) world)
                .withRandom(world.rand)
                .withParameter(LootParameters.TOOL, silkTool)
                .withNullableParameter(LootParameters.BLOCK_ENTITY, world.getTileEntity(pos))
                .withParameter(LootParameters.THIS_ENTITY, player);

        List<ItemStack> drops = state.getDrops(builder);

        // Remove block
        world.removeBlock(pos, false);

        // Spawn drops manually
        for (ItemStack drop : drops) {
            Block.spawnAsEntity(world, pos, drop);
        }
    }

    private static boolean isRubberized(ItemStack stack) {
        return stack.getItem() == ModItems.RUBBERIZED_NETHERITE_PICKAXE.get()
                || stack.getItem() == ModItems.RUBBERIZED_NETHERITE_SHOVEL.get();
    }

    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        PlayerEntity player = event.getPlayer();
        CompoundNBT data = player.getPersistentData();

        // Prevent multiple books
        if (!data.getBoolean("HasFloraGuide")) {
            // Create Patchouli guide book ItemStack manually
            ItemStack book = new ItemStack(ForgeRegistries.ITEMS.getValue(
                    new ResourceLocation("patchouli", "guide_book")
            ));

            // Attach the book ID so Patchouli knows which book to open
            CompoundNBT tag = book.getOrCreateTag();
            tag.putString("patchouli:book", "brbiomesmod:flora_guide");

            // Give to player
            player.addItemStackToInventory(book);

            // Mark as given
            data.putBoolean("HasFloraGuide", true);
        }
    }
}
