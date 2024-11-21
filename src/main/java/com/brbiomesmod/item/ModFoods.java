package com.brbiomesmod.item;

import net.minecraft.item.Food;
import net.minecraft.item.Foods;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

@SuppressWarnings("deprecation")
public class ModFoods extends Foods {
    public static final Food CASHEW_APPLE = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food COOKED_CASHEWNUT = (new Food.Builder()).hunger(2).saturation(0.1F).build();
    public static final Food JUA_BERRIES = (new Food.Builder()).hunger(2).saturation(0.1F).build();
    public static final Food CAMBUCI = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food PITANGA = (new Food.Builder()).hunger(2).saturation(0.1F).build();
    public static final Food BLACK_PITANGA = (new Food.Builder()).hunger(2).saturation(0.1F).build();
    public static final Food COOKED_PARANA_PINENUT = (new Food.Builder()).hunger(2).saturation(0.1F).build();
    public static final Food GUARANA_FRUIT = (new Food.Builder()).hunger(2).saturation(0.1F)
            .effect(new EffectInstance(Effects.JUMP_BOOST, 100, 0), 0.6F)
            .effect(new EffectInstance(Effects.SPEED, 100, 0), 0.6F).build();
    public static final Food PELLED_BRAZILNUT = (new Food.Builder()).hunger(1).saturation(0.1F).build();
    public static final Food ROASTED_BRAZILNUT = (new Food.Builder()).hunger(2).saturation(0.2F).build();
    public static final Food CASSAVA = (new Food.Builder()).hunger(1).saturation(0.1F)
            .effect(new EffectInstance(Effects.POISON, 100, 3), 1.0F)
            .effect(new EffectInstance(Effects.HUNGER, 300, 2), 1.0F)
            .effect(new EffectInstance(Effects.NAUSEA, 300, 0), 1.0F).build();
    public static final Food COOKED_CASSAVA = (new Food.Builder()).hunger(5).saturation(0.6F).build();
    public static final Food UMBU = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food CUPUACU = (new Food.Builder()).hunger(6).saturation(0.6F).build();
    public static final Food WOLF_APPLE = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food PINEAPPLE_GUAVA = (new Food.Builder()).hunger(2).saturation(0.1F).build();
    public static final Food MANGABA = (new Food.Builder()).hunger(2).saturation(0.1F).build();
    public static final Food JABUTICABA = (new Food.Builder()).hunger(2).saturation(0.1F).build();
    public static final Food TURK_TURBAN_BERRIES = (new Food.Builder()).hunger(1).saturation(0.1F).build();

}
