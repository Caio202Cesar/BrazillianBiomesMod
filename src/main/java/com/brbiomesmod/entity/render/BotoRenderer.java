package com.brbiomesmod.entity.render;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.entity.custom.BotoEntity;
import com.brbiomesmod.entity.model.BotoModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BotoRenderer extends MobRenderer<BotoEntity, BotoModel<BotoEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(BrazillianBiomesMod.MOD_ID, "textures/entity/boto.png");

    public BotoRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new BotoModel<>(), 2F);
    }

    @Override
    public ResourceLocation getEntityTexture(BotoEntity entity) {
        return TEXTURE;
    }
}
