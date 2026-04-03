package com.brbiomesmod.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class UFOModel extends EntityModel<Entity> {
    private final ModelRenderer bb_main;

    public UFOModel() {
        textureWidth = 256;
        textureHeight = 256;

        bb_main = new ModelRenderer(this);
        bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
        bb_main.setTextureOffset(0, 0).addBox(-17.0F, -8.0F, -17.0F, 35.0F, 2.0F, 35.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 37).addBox(-14.0F, -6.0F, -14.0F, 29.0F, 2.0F, 29.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 68).addBox(-14.0F, -10.0F, -14.0F, 29.0F, 2.0F, 29.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 99).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 3.0F, 16.0F, 0.0F, false);
        bb_main.setTextureOffset(116, 37).addBox(-5.0F, -17.0F, -5.0F, 10.0F, 5.0F, 10.0F, 0.0F, false);
        bb_main.setTextureOffset(64, 99).addBox(-8.0F, -13.0F, -8.0F, 16.0F, 3.0F, 16.0F, 0.0F, false);
        bb_main.setTextureOffset(116, 52).addBox(-5.0F, -2.0F, -5.0F, 10.0F, 2.0F, 10.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {

    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {

    }
}
