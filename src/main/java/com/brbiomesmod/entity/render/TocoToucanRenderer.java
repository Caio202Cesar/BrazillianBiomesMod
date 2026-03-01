package com.brbiomesmod.entity.render;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.entity.custom.TocoToucanEntity;
import com.brbiomesmod.entity.model.TocoToucanModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class TocoToucanRenderer extends MobRenderer<TocoToucanEntity, TocoToucanModel<TocoToucanEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(BrazillianBiomesMod.MOD_ID, "textures/entity/toco_toucan.png");

    public TocoToucanRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new TocoToucanModel<>(), 0.2F);
    }

    @Override
    public ResourceLocation getEntityTexture(TocoToucanEntity entity) {
        return TEXTURE;
    }
}
