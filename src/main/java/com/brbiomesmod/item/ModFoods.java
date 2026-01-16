package com.brbiomesmod.item;

import net.minecraft.item.Food;
import net.minecraft.item.Foods;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

@SuppressWarnings("deprecation")
public class ModFoods extends Foods {
    public static final Food CASHEW_APPLE = (new Food.Builder()).hunger(2).saturation(0.3F).build();
    public static final Food COOKED_CASHEWNUT = (new Food.Builder()).hunger(2).saturation(0.1F).build();
    public static final Food JUA_BERRIES = (new Food.Builder()).hunger(2).saturation(0.1F).build();
    public static final Food CAMBUCI = (new Food.Builder()).hunger(2).saturation(0.3F).build();
    public static final Food MONKEY_CAJARANA = (new Food.Builder()).hunger(2).saturation(0.3F).build();
    public static final Food PITANGA = (new Food.Builder()).hunger(2).saturation(0.1F).build();
    public static final Food BLACK_PITANGA = (new Food.Builder()).hunger(2).saturation(0.1F).build();
    public static final Food RIO_GRANDE_CHERRY = (new Food.Builder()).hunger(2).saturation(0.1F).build();
    public static final Food COOKED_PARANA_PINENUT = (new Food.Builder()).hunger(2).saturation(0.1F).build();
    public static final Food GUARANA_FRUIT = (new Food.Builder()).hunger(2).saturation(0.1F)
            .effect(new EffectInstance(Effects.JUMP_BOOST, 100, 0), 0.6F)
            .effect(new EffectInstance(Effects.SPEED, 100, 0), 0.6F).build();
    public static final Food PELLED_BRAZILNUT = (new Food.Builder()).hunger(1).saturation(0.1F).build();
    public static final Food ROASTED_BRAZILNUT = (new Food.Builder()).hunger(2).saturation(0.2F).build();
    public static final Food SAPUCAIA_NUTS = (new Food.Builder()).hunger(2).saturation(0.2F).build();
    public static final Food CASSAVA = (new Food.Builder()).hunger(1).saturation(0.1F)
            .effect(new EffectInstance(Effects.POISON, 100, 3), 1.0F)
            .effect(new EffectInstance(Effects.HUNGER, 300, 2), 1.0F)
            .effect(new EffectInstance(Effects.NAUSEA, 300, 0), 1.0F).build();
    public static final Food COOKED_CASSAVA = (new Food.Builder()).hunger(5).saturation(0.6F).build();
    public static final Food UMBU = (new Food.Builder()).hunger(2).saturation(0.3F).build();
    public static final Food CUPUACU = (new Food.Builder()).hunger(6).saturation(0.6F).build();
    public static final Food CUPUACU_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).meat().build();
    public static final Food WOLF_APPLE = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food PINEAPPLE_GUAVA = (new Food.Builder()).hunger(2).saturation(0.1F).build();
    public static final Food MANGABA = (new Food.Builder()).hunger(2).saturation(0.1F).build();
    public static final Food JABUTICABA = (new Food.Builder()).hunger(2).saturation(0.1F).build();
    public static final Food TURK_TURBAN_BERRIES = (new Food.Builder()).hunger(1).saturation(0.1F).build();
    public static final Food CAGAITA = (new Food.Builder()).hunger(2).saturation(0.1F)
            .effect(new EffectInstance(Effects.HUNGER, 300, 2), 1.0F)
            .effect(new EffectInstance(Effects.NAUSEA, 300, 0), 1.0F).build();
    public static final Food CECROPIA_FRUITS = (new Food.Builder()).hunger(2).saturation(0.1F).build();
    public static final Food BACURI = (new Food.Builder()).hunger(2).saturation(0.3F).build();
    public static final Food CAMU_CAMU_FRUITS = (new Food.Builder()).hunger(2).saturation(0.1F).build();
    public static final Food PINK_PEPPER = (new Food.Builder()).hunger(1).saturation(0.1F).build();
    public static final Food MATE = (new Food.Builder()).hunger(4).saturation(0.1F)
            .effect(new EffectInstance(Effects.REGENERATION, 100, 1), 1.0F)
            .effect(new EffectInstance(Effects.SPEED, 2400, 0), 1.0F)
            .effect(new EffectInstance(Effects.JUMP_BOOST, 2400, 0), 1.0F).build();
    public static final Food PASSIONFRUIT = (new Food.Builder()).hunger(5).saturation(0.4F).build();
    public static final Food PITANGA_JUICE = (new Food.Builder()).hunger(4).saturation(0.1F).build();
    public static final Food BLACK_PITANGA_JUICE = (new Food.Builder()).hunger(4).saturation(0.1F).build();
    public static final Food CASHEW_JUICE = (new Food.Builder()).hunger(4).saturation(0.1F).build();
    public static final Food FEIJOA_JUICE = (new Food.Builder()).hunger(4).saturation(0.1F).build();
    public static final Food CAMBUCI_JUICE = (new Food.Builder()).hunger(4).saturation(0.1F).build();
    public static final Food JABUTICABA_JUICE = (new Food.Builder()).hunger(4).saturation(0.1F).build();
    public static final Food PASSIONFRUIT_JUICE = (new Food.Builder()).hunger(4).saturation(0.1F).build();
    public static final Food MANGABA_JUICE = (new Food.Builder()).hunger(4).saturation(0.1F).build();
    public static final Food RIO_GRANDE_CHERRY_JUICE = (new Food.Builder()).hunger(4).saturation(0.1F).build();
    public static final Food CAMU_CAMU_JUICE = (new Food.Builder()).hunger(4).saturation(0.1F).build();
    public static final Food CUPUACU_JUICE = (new Food.Builder()).hunger(4).saturation(0.1F).build();
    public static final Food UMBU_JUICE = (new Food.Builder()).hunger(4).saturation(0.1F).build();
    public static final Food BACURI_PASTE = (new Food.Builder()).hunger(4).saturation(0.4F).build();
    public static final Food ACAI_JUICE = (new Food.Builder()).hunger(4).saturation(0.4F)
            .effect(new EffectInstance(Effects.SPEED, 2400, 0), 1.0F)
            .effect(new EffectInstance(Effects.JUMP_BOOST, 2400, 0), 1.0F).build();
    public static final Food BURITI_JUICE = (new Food.Builder()).hunger(4).saturation(0.1F).build();
    public static final Food GUARANA_SODA = (new Food.Builder()).hunger(2).saturation(0.1F)
            .effect(new EffectInstance(Effects.JUMP_BOOST, 100, 0), 0.6F)
            .effect(new EffectInstance(Effects.SPEED, 100, 0), 0.6F).build();
    public static final Food BURITI = (new Food.Builder()).hunger(2).saturation(0.3F).build();
    public static final Food ACAI_BERRIES = (new Food.Builder()).hunger(2).saturation(0.3F).build();
    public static final Food PALM_HEART = (new Food.Builder()).hunger(4).saturation(0.4F).build();
    public static final Food ACAI_BOWL = (new Food.Builder()).hunger(6).saturation(0.6F)
            .effect(new EffectInstance(Effects.SPEED, 2400, 0), 1.0F)
            .effect(new EffectInstance(Effects.JUMP_BOOST, 2400, 0), 1.0F).build();
    public static final Food ACAI_WITH_BANANA = (new Food.Builder()).hunger(8).saturation(0.8F)
            .effect(new EffectInstance(Effects.SPEED, 2400, 0), 1.0F)
            .effect(new EffectInstance(Effects.JUMP_BOOST, 2400, 0), 1.0F).build();
    public static final Food ACAI_WITH_CUPUACU = (new Food.Builder()).hunger(6).saturation(0.6F)
            .effect(new EffectInstance(Effects.SPEED, 2400, 0), 1.0F)
            .effect(new EffectInstance(Effects.JUMP_BOOST, 2400, 0), 1.0F).build();
    public static final Food BUTIA = (new Food.Builder()).hunger(2).saturation(0.1F).build();
    public static final Food JENIPAPO = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food GREEN_JENIPAPO = (new Food.Builder()).hunger(4).saturation(0.3F)
            .effect(new EffectInstance(Effects.HUNGER, 300, 2), 1.0F).build();
    public static final Food CAATINGA_PASSIONFRUIT = (new Food.Builder()).hunger(5).saturation(0.4F).build();
    public static final Food YELLOW_MOMBIN = (new Food.Builder()).hunger(2).saturation(0.1F).build();
    public static final Food COOKED_PEQUI = (new Food.Builder()).hunger(2).saturation(0.3F).build();
    public static final Food ACAI_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food ACAI_BANANA_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food BLACK_PITANGA_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food BACURI_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food BRAZILNUT_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food BURITI_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food BUTIA_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food CAGAITA_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food CAMBUCI_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food CAMU_CAMU_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food CASHEWNUT_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food CASHEW_APPLE_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food CHOCOLATE_SPICY_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food COCONUT_TAPIOCA_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food FEIJOA_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food GUARANA_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F)
            .effect(new EffectInstance(Effects.JUMP_BOOST, 100, 0), 0.6F)
            .effect(new EffectInstance(Effects.SPEED, 100, 0), 0.6F).build();
    public static final Food JABUTICABA_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food JENIPAPO_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food JUA_BERRIES_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food MANGABA_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food MATE_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food SPICY_MILK_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food PARANA_PINE_NUT_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food PASSIONFRUIT_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food PASSIONFRUIT_CHOCOLATE_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food PASSIONFRUIT_SPICY_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food PITANGA_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food PEQUI_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food RIO_GRANDE_CHERRY_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food UMBU_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food TAPIOCA = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food PASSIONFRUIT_MOUSSE = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food CECROPIA_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food YELLOW_MOMBIN_ICE_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();

}
