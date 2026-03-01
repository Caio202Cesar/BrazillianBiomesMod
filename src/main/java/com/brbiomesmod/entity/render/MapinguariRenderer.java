package com.brbiomesmod.entity.render;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.entity.custom.MapinguariEntity;
import com.brbiomesmod.entity.custom.TocoToucanEntity;
import com.brbiomesmod.entity.model.MapinguariModel;
import com.brbiomesmod.entity.model.TocoToucanModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class MapinguariRenderer extends MobRenderer<MapinguariEntity, MapinguariModel<MapinguariEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(BrazillianBiomesMod.MOD_ID, "textures/entity/mapinguari.png");

    public MapinguariRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new MapinguariModel<>(), 2F);
    }

    @Override
    public ResourceLocation getEntityTexture(MapinguariEntity entity) {
        return TEXTURE;
    }
}
