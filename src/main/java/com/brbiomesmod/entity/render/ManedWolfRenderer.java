package com.brbiomesmod.entity.render;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.entity.custom.BotoEntity;
import com.brbiomesmod.entity.custom.ManedWolfEntity;
import com.brbiomesmod.entity.model.BotoModel;
import com.brbiomesmod.entity.model.ManedWolfModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ManedWolfRenderer extends MobRenderer<ManedWolfEntity, ManedWolfModel<ManedWolfEntity>> {

    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(BrazillianBiomesMod.MOD_ID, "textures/entity/maned_wolf.png");

    public ManedWolfRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ManedWolfModel<>(), 0.6F); //
    }

    @Override
    public ResourceLocation getEntityTexture(ManedWolfEntity entity) {
        return TEXTURE;
    }
}
