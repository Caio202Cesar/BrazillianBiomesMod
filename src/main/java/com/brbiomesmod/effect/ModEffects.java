package com.brbiomesmod.effect;

import com.caiocesarmods.caiocesarbiomes.CaioCesarBiomesMod;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEffects {
    public static final DeferredRegister<Effect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.POTIONS, CaioCesarBiomesMod.MOD_ID);

    public static final RegistryObject<Effect> DIARRHEA = EFFECTS.register("diarrhea_effect",
            () -> new DiarrheaEffect(EffectType.HARMFUL, 0x964b00));

    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }

}
