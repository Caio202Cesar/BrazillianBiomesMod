package com.brbiomesmod.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class CapybaraModel extends EntityModel<Entity> {
    private final ModelRenderer body;
    private final ModelRenderer legs;
    private final ModelRenderer head;

    public CapybaraModel() {
        textureWidth = 64;
        textureHeight = 64;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 24.0F, 0.0F);
        body.setTextureOffset(0, 0).addBox(-4.0F, -9.0F, -5.0F, 6.0F, 7.0F, 11.0F, 0.0F, false);

        legs = new ModelRenderer(this);
        legs.setRotationPoint(0.0F, 24.0F, 0.0F);
        legs.setTextureOffset(22, 18).addBox(-4.0F, -2.0F, 4.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        legs.setTextureOffset(22, 26).addBox(-4.0F, -2.0F, -4.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        legs.setTextureOffset(0, 30).addBox(0.0F, -2.0F, -4.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        legs.setTextureOffset(22, 22).addBox(0.0F, -2.0F, 4.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 16.0F, -7.0F);
        head.setTextureOffset(0, 18).addBox(-3.0F, -3.0F, -5.0F, 4.0F, 5.0F, 7.0F, 0.0F, false);
        head.setTextureOffset(8, 30).addBox(-4.0F, -5.0F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        head.setTextureOffset(14, 30).addBox(1.0F, -5.0F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        legs.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        head.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }
}