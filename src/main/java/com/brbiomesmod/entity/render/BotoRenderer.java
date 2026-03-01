package com.brbiomesmod.entity.render;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.entity.custom.BotoEntity;
import com.brbiomesmod.entity.model.BotoModel;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

public class BotoRenderer extends MobRenderer<BotoEntity, BotoModel<BotoEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(BrazillianBiomesMod.MOD_ID, "textures/entity/boto.png");

    public BotoRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new BotoModel<>(), 1F);
    }

    @Override
    protected void applyRotations(BotoEntity entity, MatrixStack matrixStack, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entity, matrixStack, ageInTicks, rotationYaw, partialTicks);
        matrixStack.rotate(Vector3f.XP.rotationDegrees(180.0F));
    }

    @Override
    public ResourceLocation getEntityTexture(BotoEntity entity) {
        return TEXTURE;
    }
}
