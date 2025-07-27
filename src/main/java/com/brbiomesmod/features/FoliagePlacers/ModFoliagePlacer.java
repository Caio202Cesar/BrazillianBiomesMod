package com.brbiomesmod.features.FoliagePlacers;

import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFoliagePlacer {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, "brbiomesmod");

    public static final RegistryObject<FoliagePlacerType<AcaiFoliagePlacer>> ACAI_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("acai_foliage_placer",
                    () -> new FoliagePlacerType<>(AcaiFoliagePlacer.CODEC));

    public static final RegistryObject<FoliagePlacerType<JussaraFoliagePlacer>> JUSSARA_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("jussara_foliage_placer",
                    () -> new FoliagePlacerType<>(JussaraFoliagePlacer.CODEC));

    public static final RegistryObject<FoliagePlacerType<QueenPalmFoliagePlacer>> QUEEN_PALM_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("queen_palm_foliage_placer",
                    () -> new FoliagePlacerType<>(QueenPalmFoliagePlacer.CODEC));

    public static final RegistryObject<FoliagePlacerType<JellyPalmFoliagePlacer>> JELLY_PALM_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("jelly_palm_foliage_placer",
                    () -> new FoliagePlacerType<>(JellyPalmFoliagePlacer.CODEC));

    public static final RegistryObject<FoliagePlacerType<ParanaPineFoliagePlacer>> PARANA_PINE_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("parana_pine_foliage_placer",
                    () -> new FoliagePlacerType<>(ParanaPineFoliagePlacer.CODEC));

    public static final RegistryObject<FoliagePlacerType<XaximFoliagePlacer>> XAXIM_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("xaxim_foliage_placer",
                    () -> new FoliagePlacerType<>(XaximFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACERS.register(eventBus);
    }
}

