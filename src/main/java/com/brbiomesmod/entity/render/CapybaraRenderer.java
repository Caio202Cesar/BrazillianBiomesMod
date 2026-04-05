package com.brbiomesmod.entity.render;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.entity.custom.CapybaraEntity;
import com.brbiomesmod.entity.model.CapybaraModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CapybaraRenderer extends MobRenderer<CapybaraEntity, CapybaraModel<CapybaraEntity>> {

    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(BrazillianBiomesMod.MOD_ID, "textures/entity/capybara.png");

    public CapybaraRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new CapybaraModel<>(), 0.6F); //
    }

    @Override
    public ResourceLocation getEntityTexture(CapybaraEntity entity) {
        return TEXTURE;
    }
}
