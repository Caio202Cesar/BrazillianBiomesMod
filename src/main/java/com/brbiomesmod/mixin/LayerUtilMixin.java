package com.brbiomesmod.mixin;

import com.brbiomesmod.world.biomes.Util.Layers.BeachReplacementLayer;
import com.brbiomesmod.world.biomes.Util.Layers.RelationshipLayer;
import com.brbiomesmod.world.biomes.Util.Layers.RiverRelationshipLayer;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraft.world.gen.layer.MixRiverLayer;
import net.minecraft.world.gen.layer.RareBiomeLayer;
import net.minecraft.world.gen.layer.ShoreLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LayerUtil.class)
public class LayerUtilMixin {

    @Redirect(
            method = "setupOverworldLayer",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/layer/RareBiomeLayer;apply(Lnet/minecraft/world/gen/IExtendedNoiseRandom;Lnet/minecraft/world/gen/area/IAreaFactory;)Lnet/minecraft/world/gen/area/IAreaFactory;"
            )
    )
    private static <T extends IArea> IAreaFactory<T> redirectRareBiome(
            RareBiomeLayer instance,
            IExtendedNoiseRandom<T> random,
            IAreaFactory<T> area) {

        System.out.println("[CCB] Injecting RelationshipLayer after RareBiomeLayer");

        IAreaFactory<T> result = instance.apply(random, area);

        return RelationshipLayer.INSTANCE.apply(random, result);
    }

    @Redirect(
            method = "setupOverworldLayer",
            at = @At(
                    value = "INVOKE",
                    target =
                            "Lnet/minecraft/world/gen/layer/ShoreLayer;apply(Lnet/minecraft/world/gen/IExtendedNoiseRandom;Lnet/minecraft/world/gen/area/IAreaFactory;)Lnet/minecraft/world/gen/area/IAreaFactory;"
            )
    )

    private static <T extends IArea>
    IAreaFactory<T> redirectShoreLayer(
            ShoreLayer instance,
            IExtendedNoiseRandom<T> random,
            IAreaFactory<T> area) {

        // Vanilla shore generation
        IAreaFactory<T> result = instance.apply(random, area);

        System.out.println("[CCB] Injecting BeachRelationshipLayer");

        // Your custom beaches
        return BeachReplacementLayer.INSTANCE.apply(
                random,
                area,
                result);
    }

    @Redirect(
            method = "setupOverworldLayer",
            at = @At(
                    value = "INVOKE",
                    target =
                            "Lnet/minecraft/world/gen/layer/MixRiverLayer;apply(Lnet/minecraft/world/gen/IExtendedNoiseRandom;Lnet/minecraft/world/gen/area/IAreaFactory;Lnet/minecraft/world/gen/area/IAreaFactory;)Lnet/minecraft/world/gen/area/IAreaFactory;"
            )
    )
    private static <T extends IArea>
    IAreaFactory<T> redirectMixRiverLayer(
            MixRiverLayer instance,
            IExtendedNoiseRandom<T> random,
            IAreaFactory<T> biomeLayer,
            IAreaFactory<T> riverLayer) {

        // Vanilla river mixing
        IAreaFactory<T> result =
                instance.apply(random, biomeLayer, riverLayer);

        System.out.println("[CCB] Injecting RiverRelationshipLayer");

        // Replace vanilla rivers with custom river biomes
        return RiverRelationshipLayer.INSTANCE.apply(
                random,
                biomeLayer,
                result);
    }
}