package com.brbiomesmod;

import com.brbiomesmod.block.Custom.Fruiting.AcaiBunchBlock;
import com.brbiomesmod.block.Custom.Fruiting.BuritiBunchBlock;
import com.brbiomesmod.block.Custom.Fruiting.PindoBunchBlock;
import com.brbiomesmod.block.Custom.Plants.*;
import com.brbiomesmod.block.Custom.Saplings.*;
import com.brbiomesmod.block.Custom.TallPlants.AngelTrumpetPlant;
import com.brbiomesmod.block.Custom.TallPlants.CassavaPlant;
import com.brbiomesmod.block.Custom.TallPlants.XaximPlant;
import com.brbiomesmod.block.Custom.Vines.AristolochiaVine;
import com.brbiomesmod.block.Custom.Vines.CaatingaPassionfruitVine;
import com.brbiomesmod.block.Custom.Vines.PassionfruitVine;
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
        PassionfruitVine.registerRenderLayer();
        AristolochiaVine.registerRenderLayer();
        EpiphytePlant.registerRenderLayer();
        OrchidPlant.registerRenderLayer();
        PampasPlant.registerRenderLayer();
        CactusPlant.registerRenderLayer();
        AngelTrumpetPlant.registerRenderLayer();
        AcaiBunchBlock.registerRenderLayer();
        BuritiBunchBlock.registerRenderLayer();
        PindoBunchBlock.registerRenderLayer();
        CaatingaPassionfruitVine.registerRenderLayer();

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
        PinkSilkFlossSapling.registerRenderLayer();
        RioGrandeCherrySapling.registerRenderLayer();
        MonkeyCajaranaSapling.registerRenderLayer();
        ApricotIpeSapling.registerRenderLayer();
        SombreiroSapling.registerRenderLayer();
        QueenPalmSapling.registerRenderLayer();
        CarnaubaSapling.registerRenderLayer();
        BuritiSapling.registerRenderLayer();
        JellyPalmSapling.registerRenderLayer();
        AcaiSapling.registerRenderLayer();
        JussaraSapling.registerRenderLayer();
        XaximSapling.registerRenderLayer();
        JenipapoSapling.registerRenderLayer();
        PequiSapling.registerRenderLayer();
        GuapuruvuSapling.registerRenderLayer();
        SandboxTreeSapling.registerRenderLayer();
        YellowMombinSapling.registerRenderLayer();
        PurpleheartSapling.registerRenderLayer();
        HumboldtWillowSapling.registerRenderLayer();
    }
}
