package com.brbiomesmod.entity.model;

import com.brbiomesmod.entity.custom.CapybaraEntity;
import com.brbiomesmod.entity.custom.GoldenLionTamarinEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class CapybaraModel<T extends CapybaraEntity> extends EntityModel<T> {
    private final ModelRenderer body;
    private final ModelRenderer legFL;
    private final ModelRenderer legFR;
    private final ModelRenderer legBL;
    private final ModelRenderer legBR;
    private final ModelRenderer head;

    public CapybaraModel() {
        textureWidth = 64;
        textureHeight = 64;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 22.0F, 0.0F);
        body.setTextureOffset(0, 0).addBox(-4.0F, -9.0F, -5.0F, 6.0F, 7.0F, 11.0F, 0.0F, false);

        legFL = new ModelRenderer(this, 0, 18);
        legFL.setRotationPoint(0.0F, 22.0F, 0.0F);
        legFL.setTextureOffset(0, 30).addBox(0.0F, -2.0F, -4.0F, 2, 3, 2, 0, false);

        legFR = new ModelRenderer(this, 0, 18);
        legFR.setRotationPoint(0.0F, 22.0F, 0.0F);
        legFR.setTextureOffset(22, 26).addBox(-4.0F, -2.0F, -4.0F, 2, 3, 2, 0, false);

        legBL = new ModelRenderer(this, 0, 18);
        legBL.setRotationPoint(0.0F, 22.0F, 0.0F);
        legBL.setTextureOffset(22, 22).addBox(0.0F, -2.0F, 4.0F, 2, 3, 2, 0, false);

        legBR = new ModelRenderer(this, 0, 18);
        legBR.setRotationPoint(0.0F, 22.0F, 0.0F);
        legBR.setTextureOffset(22, 18).addBox(-4.0F, -3.0F, 4.0F, 2, 3, 2, 0, false);

        head = new ModelRenderer(this, 0, 0);
        head.setRotationPoint(0.0F, 16.0F, -7.0F);
        head.setTextureOffset(0, 18).addBox(-3.0F, -3.0F, -5.0F, 4.0F, 5.0F, 7.0F, 0.0F, false);
        head.setTextureOffset(8, 30).addBox(-4.0F, -5.0F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        head.setTextureOffset(14, 30).addBox(1.0F, -5.0F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float speed = 0.5F;
        float degree = 0.15F;

        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);

        this.legFL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F * speed) * degree * limbSwingAmount;
        this.legBR.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F * speed) * degree * limbSwingAmount;

        this.legFR.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F * speed + (float)Math.PI) * degree * limbSwingAmount;
        this.legBL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F * speed + (float)Math.PI) * degree * limbSwingAmount;
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
                       float red, float green, float blue, float alpha) {

        matrixStackIn.push();

        if (this.isChild) {
            float scale = 0.5F;

            // Scale entire baby
            matrixStackIn.scale(scale, scale, scale);
            matrixStackIn.translate(0.0D, 1.5D, 0.0D);

            // Render body + legs normally
            body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            legFL.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            legFR.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            legBL.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            legBR.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);

            // BIGGER HEAD (separate transform)
            matrixStackIn.push();
            matrixStackIn.scale(1.2F, 1.2F, 1.2F);
            head.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            matrixStackIn.pop();

        } else {
            // Adult rendering
            body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            legFL.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            legFR.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            legBL.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            legBR.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            head.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        }

        matrixStackIn.pop();
    }
}