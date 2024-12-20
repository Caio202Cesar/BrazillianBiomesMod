package com.brbiomesmod;

import com.brbiomesmod.block.*;
import com.brbiomesmod.block.Saplings.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(
        bus = Mod.EventBusSubscriber.Bus.MOD,
        value = {Dist.CLIENT}
)

public class BrbiomesModBlocks$BlocksClientSideHandler {
    public BrbiomesModBlocks$BlocksClientSideHandler() {
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        CassavaPlant.registerRenderLayer();
        XaximPlant.registerRenderLayer();
        BeachFlower.registerRenderLayer();
        XananaFlower.registerRenderLayer();
        BullNettlePlant.registerRenderLayer();
        PassionFruitVine.registerRenderLayer();
        AristolochiaVine.registerRenderLayer();
        EpiphytePlant.registerRenderLayer();
        OrchidPlant.registerRenderLayer();
        PampasPlant.registerRenderLayer();
        CactusPlant.registerRenderLayer();

        AlgarrobilloSapling.registerRenderLayer();
        CavenThornSapling.registerRenderLayer();
        BlackJuremaSapling.registerRenderLayer();
        BlackSucupiraSapling.registerRenderLayer();
        BrazillianPepperSapling.registerRenderLayer();
        BrazillianRosewoodSapling.registerRenderLayer();
        BrazillianSassafrasSapling.registerRenderLayer();
        BrazilnutSapling.registerRenderLayer();
        BrazilwoodSapling.registerRenderLayer();
        BalsaSapling.registerRenderLayer();
        CambuciSapling.registerRenderLayer();
        CashewSapling.registerRenderLayer();
        CagaitaSapling.registerRenderLayer();
        CamuCamuSapling.registerRenderLayer();
        CecropiaSapling.registerRenderLayer();
        CupuacuSapling.registerRenderLayer();
        FeijoaSapling.registerRenderLayer();
        GuaranaSapling.registerRenderLayer();
        JabuticabaSapling.registerRenderLayer();
        JequitibaSapling.registerRenderLayer();
        JuaSapling.registerRenderLayer();
        KapokSapling.registerRenderLayer();
        LophanteraSapling.registerRenderLayer();
        ManacaSapling.registerRenderLayer();
        MangabaSapling.registerRenderLayer();
        ParanaPineSapling.registerRenderLayer();
        PeruvianPepperSapling.registerRenderLayer();
        PinkIpeSapling.registerRenderLayer();
        PinkPerobaSapling.registerRenderLayer();
        PitangaSapling.registerRenderLayer();
        PurpleIpeSapling.registerRenderLayer();
        SharingaSapling.registerRenderLayer();
        SilverCecropiaSapling.registerRenderLayer();
        SilverPepperSapling.registerRenderLayer();
        UmbuSapling.registerRenderLayer();
        WhiteIpeSapling.registerRenderLayer();
        WhiteSilkFlossSapling.registerRenderLayer();
        WolfAppleSapling.registerRenderLayer();
        YellowIpeSapling.registerRenderLayer();
        YerbaMateSapling.registerRenderLayer();
        ImbuiaSapling.registerRenderLayer();
        BacuriSapling.registerRenderLayer();
        SapucaiaSapling.registerRenderLayer();
        CockspurCoralSapling.registerRenderLayer();
        UruguayanPepperSapling.registerRenderLayer();
        PinkSilkFlossSapling.registerRenderLayer();
        RioGrandeCherrySapling.registerRenderLayer();
    }
}
