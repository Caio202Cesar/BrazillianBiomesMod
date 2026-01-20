package com.brbiomesmod;

import com.brbiomesmod.block.MiscBlocks;
import com.brbiomesmod.block.PlantsGroup;
import com.brbiomesmod.block.TreesGroup;
import com.brbiomesmod.block.WoodGroup;
import com.brbiomesmod.events.ModParticles;
import com.brbiomesmod.features.FoliagePlacers.ModFoliagePlacer;
import com.brbiomesmod.features.TreeDecorators.ModTreeDecorators;
import com.brbiomesmod.item.ModItems;
import com.brbiomesmod.world.biomes.*;
import com.brbiomesmod.world.biomes.Util.ModBiomeGeneration;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
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

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        ModParticles.PARTICLES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModFoliagePlacer.register(FMLJavaModLoadingContext.get().getModEventBus());

    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

            ModBiomeGeneration.generateBiomes();


        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().fontRenderer);

            RenderTypeLookup.setRenderLayer(MiscBlocks.CASSAVA_CROP.get(), RenderType.getCutout());
        });
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
