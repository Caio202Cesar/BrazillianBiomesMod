package com.brbiomesmod.entity.render;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.entity.custom.GoldenLionTamarinEntity;
import com.brbiomesmod.entity.model.GoldenLionTamarinModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GoldenLionTamarinRenderer extends MobRenderer<GoldenLionTamarinEntity, GoldenLionTamarinModel<GoldenLionTamarinEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(BrazillianBiomesMod.MOD_ID, "textures/entity/golden_lion_tamarin.png");

    public GoldenLionTamarinRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new GoldenLionTamarinModel<>(), 0.1F);
    }

    @Override
    public ResourceLocation getEntityTexture(GoldenLionTamarinEntity entity) {
        return TEXTURE;
    }
}
