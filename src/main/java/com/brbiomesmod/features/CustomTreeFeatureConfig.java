package com.brbiomesmod.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class CustomTreeFeatureConfig implements IFeatureConfig {
    // Define any parameters you need for your tree configuration
    public static final Codec<CustomTreeFeatureConfig> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    // Add parameters here, for example:
                    Codec.INT.fieldOf("height").orElse(5).forGetter(config -> config.height),
                    Codec.STRING.fieldOf("wood_type").orElse("oak").forGetter(config -> config.woodType)
                    // Add more parameters as needed
            ).apply(instance, CustomTreeFeatureConfig::new)
    );

    public final int height;
    public final String woodType;

    // Constructor
    public CustomTreeFeatureConfig(int height, String woodType) {
        this.height = height;
        this.woodType = woodType;
    }
}
