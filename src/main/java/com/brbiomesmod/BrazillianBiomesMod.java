package com.brbiomesmod;

import com.brbiomesmod.Util.ModSoundEvents;
import com.brbiomesmod.block.MiscBlocks;
import com.brbiomesmod.block.PlantsGroup;
import com.brbiomesmod.block.TreesGroup;
import com.brbiomesmod.block.WoodGroup;
import com.brbiomesmod.entity.ModEntityTypes;
import com.brbiomesmod.entity.custom.BotoEntity;
import com.brbiomesmod.entity.render.*;
import com.brbiomesmod.events.ModEntities;
import com.brbiomesmod.events.ModParticles;
import com.brbiomesmod.features.FoliagePlacers.ModFoliagePlacer;
import com.brbiomesmod.features.TreeDecorators.ModTreeDecorators;
import com.brbiomesmod.item.ModItems;
import com.brbiomesmod.world.biomes.*;
import com.brbiomesmod.world.biomes.Util.ModBiomeGeneration;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.item.AxeItem;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BrazillianBiomesMod.MOD_ID)
public class BrazillianBiomesMod {
    public static final String MOD_ID = "brbiomesmod";

    private static final Logger LOGGER = LogManager.getLogger();

    public BrazillianBiomesMod() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        MiscBlocks.register(eventBus);
        TreesGroup.register(eventBus);
        PlantsGroup.register(eventBus);
        WoodGroup.register(eventBus);

        ModTreeDecorators.register(eventBus);
        ModEntityTypes.register(eventBus);
        ModSoundEvents.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::enqueueIMC);
        eventBus.addListener(this::processIMC);
        eventBus.addListener(this::doClientStuff);

        AmazonRainforestBiome.register(eventBus);
        AraucariaPlateauBiome.register(eventBus);
        PantanalBiome.register(eventBus);
        CaatingaBiome.register(eventBus);
        AtlanticForestBiome.register(eventBus);
        DunasRestingaBiome.register(eventBus);
        PampasBiome.register(eventBus);
        CerradoBiome.register(eventBus);
        RestingaBeachBiome.register(eventBus);
        AmazonVarzeaForestBiome.register(eventBus);
        ButiaPampasBiome.register(eventBus);
        PampasCoastalFields.register(eventBus);
        AtlanticForestHillsBiome.register(eventBus);
        CoxilhasBiome.register(eventBus);
        AmazonRainforestEdgeBiome.register(eventBus);
        CocalForestBiome.register(eventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        ModParticles.PARTICLES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModEntities.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModFoliagePlacer.register(FMLJavaModLoadingContext.get().getModEventBus());

    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

            AxeItem.BLOCK_STRIPPING_MAP = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.BLOCK_STRIPPING_MAP)
                    .put(TreesGroup.BRAZILLIAN_ROSEWOOD_LOG.get(), TreesGroup.STRIPPED_BRAZILLIAN_ROSEWOOD_LOG.get())
                    .put(TreesGroup.BRAZILLIAN_SASSAFRAS_LOG.get(), TreesGroup.STRIPPED_BRAZILLIAN_SASSAFRAS_LOG.get())
                    .put(TreesGroup.CAMBUCI_LOG.get(), TreesGroup.STRIPPED_CAMBUCI_LOG.get())
                    .put(TreesGroup.CASHEW_LOG.get(), TreesGroup.STRIPPED_CASHEW_LOG.get())
                    .put(TreesGroup.EUGENIA_LOG.get(), TreesGroup.STRIPPED_EUGENIA_LOG.get())
                    .put(TreesGroup.FEIJOA_LOG.get(), TreesGroup.STRIPPED_FEIJOA_LOG.get())
                    .put(TreesGroup.IMBUIA_LOG.get(), TreesGroup.STRIPPED_IMBUIA_LOG.get())
                    .put(TreesGroup.IPE_LOG.get(), TreesGroup.STRIPPED_IPE_LOG.get())
                    .put(TreesGroup.JEQUITIBA_LOG.get(), TreesGroup.STRIPPED_JEQUITIBA_LOG.get())
                    .put(TreesGroup.LOPHANTERA_LOG.get(), TreesGroup.STRIPPED_LOPHANTERA_LOG.get())
                    .put(TreesGroup.MANACA_DA_SERRA_LOG.get(), TreesGroup.STRIPPED_MANACA_DA_SERRA_LOG.get())
                    .put(TreesGroup.PARANA_PINE_LOG.get(), TreesGroup.STRIPPED_PARANA_PINE_LOG.get())
                    .put(TreesGroup.PINK_PEROBA_LOG.get(), TreesGroup.STRIPPED_PINK_PEROBA_LOG.get())
                    .put(TreesGroup.PODOCARPUS_LAMBERTII_LOG.get(), TreesGroup.STRIPPED_PODOCARPUS_LAMBERTII_LOG.get())
                    .put(TreesGroup.UMBU_LOG.get(), TreesGroup.STRIPPED_UMBU_LOG.get())
                    .put(TreesGroup.WOLF_APPLE_LOG.get(), TreesGroup.STRIPPED_WOLF_APPLE_LOG.get())
                    .put(TreesGroup.JENIPAPO_LOG.get(), Blocks.STRIPPED_JUNGLE_LOG)
                    .put(TreesGroup.SILK_FLOSS_LOG.get(), Blocks.STRIPPED_JUNGLE_LOG)
                    .put(TreesGroup.KAPOK_LOG.get(), Blocks.STRIPPED_JUNGLE_LOG)
                    .put(TreesGroup.YERBA_MATE_LOG.get(), TreesGroup.STRIPPED_YERBA_MATE_LOG.get())
                    .put(TreesGroup.SANDBOX_TREE_LOG.get(), TreesGroup.SANDBOX_TREE_THORNLESS_LOG.get())
                    .put(TreesGroup.SANDBOX_TREE_THORNLESS_LOG.get(), TreesGroup.STRIPPED_SANDBOX_TREE_LOG.get())
                    .put(TreesGroup.SAPUCAIA_LOG.get(), TreesGroup.STRIPPED_SAPUCAIA_LOG.get())
                    .put(TreesGroup.JABUTICABA_LOG.get(), TreesGroup.STRIPPED_JABUTICABA_LOG.get())
                    .put(TreesGroup.JABUTICABA_FLOWERING_LOG.get(), TreesGroup.STRIPPED_JABUTICABA_LOG.get())
                    .put(TreesGroup.JABUTICABA_FRUITING_LOG.get(), TreesGroup.STRIPPED_JABUTICABA_LOG.get())
                    .put(TreesGroup.BRAZILWOOD_LOG.get(), TreesGroup.STRIPPED_BRAZILWOOD_LOG.get())
                    .put(TreesGroup.BLACK_SUCUPIRA_LOG.get(), TreesGroup.STRIPPED_BLACK_SUCUPIRA_LOG.get())
                    .put(TreesGroup.BLACK_JUREMA_LOG.get(), Blocks.STRIPPED_ACACIA_LOG)
                    .put(TreesGroup.CAVEN_THORN_LOG.get(), Blocks.STRIPPED_ACACIA_LOG)
                    .put(TreesGroup.ALGARROBILLO_LOG.get(), TreesGroup.STRIPPED_ALGARROBILLO_LOG.get())
                    .put(TreesGroup.COCKSPUR_CORAL_LOG.get(), TreesGroup.STRIPPED_COCKSPUR_CORAL_LOG.get())
                    .put(TreesGroup.SCHINUS_LOG.get(), TreesGroup.STRIPPED_SCHINUS_LOG.get())
                    .put(TreesGroup.JUA_LOG.get(), TreesGroup.STRIPPED_JUA_LOG.get())
                    .put(TreesGroup.MANGABA_LOG.get(), TreesGroup.STRIPPED_MANGABA_LOG.get())
                    .put(TreesGroup.MONKEY_CAJARANA_LOG.get(), TreesGroup.STRIPPED_MONKEY_CAJARANA_LOG.get())
                    .put(TreesGroup.BALSA_LOG.get(), TreesGroup.STRIPPED_BALSA_LOG.get())
                    .put(TreesGroup.BRAZILNUT_LOG.get(), TreesGroup.STRIPPED_BRAZILNUT_LOG.get())
                    .put(TreesGroup.SHARINGA_LOG.get(), TreesGroup.STRIPPED_SHARINGA_LOG.get())
                    .build();

            ModBiomeGeneration.generateBiomes();

            EntitySpawnPlacementRegistry.register(
                    ModEntityTypes.BOTO_ENTITY.get(),
                    EntitySpawnPlacementRegistry.PlacementType.IN_WATER,
                    Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                    BotoEntity::canSpawn
            );
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().fontRenderer);

            RenderTypeLookup.setRenderLayer(MiscBlocks.CASSAVA_CROP.get(), RenderType.getCutout());

        });

        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.TOCO_TOUCAN_ENTITY.get(), TocoToucanRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.MAPINGUARI_ENTITY.get(), MapinguariRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BOTO_ENTITY.get(), BotoRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.GOLDEN_LION_TAMARIN_ENTITY.get(), GoldenLionTamarinRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.MANED_WOLF_ENTITY.get(), ManedWolfRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CAPYBARA_ENTITY.get(), CapybaraRenderer::new);

    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        InterModComms.sendTo("brbiomesmod", "helloworld", () -> {
            LOGGER.info("Hello world from the MDK");
            return "Hello world";
        });
    }

    private void processIMC(final InterModProcessEvent event) {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m -> m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)

    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
