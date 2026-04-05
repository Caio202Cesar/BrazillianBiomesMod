package com.brbiomesmod.entity.model;

import com.brbiomesmod.entity.custom.GoldenLionTamarinEntity;
import com.brbiomesmod.entity.custom.ManedWolfEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ManedWolfModel<T extends ManedWolfEntity> extends EntityModel<T> {
    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer leg1;
    private final ModelRenderer leg2;
    private final ModelRenderer leg3;
    private final ModelRenderer leg4;
    private final ModelRenderer tail;

    public ManedWolfModel() {
        textureWidth = 64;
        textureHeight = 64;

        head = new ModelRenderer(this, 0, 0);
        head.setRotationPoint(-1.0F, 10.5F, -3.0F);
        head.setTextureOffset(1, 5).addBox(-3.0F, -2.0F, -5.0F, 8.0F, 6.0F, 6.0F, 0.0F, false);
        head.setTextureOffset(15, 1).addBox(3.0F, -4.0F, -4.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(8, 1).addBox(-3.0F, -4.0F, -4.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(6, 18).addBox(-1.0F, 2.0F, -8.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 16.0F, -6.0F);
        setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
        body.setTextureOffset(24, 15).addBox(-3.0F, 4.0F, 1.5F, 6.0F, 11.0F, 6.0F, 0.0F, false);

        leg1 = new ModelRenderer(this, 0, 18);
        leg1.setRotationPoint(-5.0F, 17.5F, 7.0F);
        leg1.setTextureOffset(13, 24).addBox(1.999F, -3.5F, -1.0F, 2.0F, 10.0F, 2.0F, 0.0F, false);

        leg2 = new ModelRenderer(this, 0, 18);
        leg2.setRotationPoint(-1.0F, 17.5F, 7.0F);
        leg2.setTextureOffset(4, 24).addBox(2.001F, -3.5F, -1.0F, 2.0F, 10.0F, 2.0F, 0.0F, false);

        leg3 = new ModelRenderer(this, 0, 18);
        leg3.setRotationPoint(-5.0F, 17.5F, 0.0F);
        leg3.setTextureOffset(13, 24).addBox(1.999F, -3.5F, -1.0F, 2.0F, 10.0F, 2.0F, 0.0F, false);

        leg4 = new ModelRenderer(this, 0, 18);
        leg4.setRotationPoint(-1.0F, 17.5F, 0.0F);
        leg4.setTextureOffset(4, 24).addBox(2.001F, -3.5F, -1.0F, 2.0F, 10.0F, 2.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setRotationPoint(-4.0F, 17.0F, 9.0F);
        setRotationAngle(tail, 1.5708F, 0.0F, 0.0F);
        tail.setTextureOffset(19, 33).addBox(3.0F, 0.0F, -6.0F, 2.0F, 2.0F, 12.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        head.rotateAngleX = headPitch * ((float)Math.PI / 180F);

        leg1.rotateAngleX =
                MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        leg2.rotateAngleX =
                MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        leg3.rotateAngleX =
                MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        leg4.rotateAngleX =
                MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        if (this.isChild) {

            matrixStack.push();

            // Make baby smaller
            matrixStack.scale(0.5F, 0.5F, 0.5F);

            // Adjust height so it doesn't render inside ground
            matrixStack.translate(0.0D, 1.5D, 0.0D);

            // Render model parts
            head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
            body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
            leg1.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
            leg2.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
            leg3.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
            leg4.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
            tail.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);

            matrixStack.pop();

        } else {

            head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
            body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
            leg1.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
            leg2.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
            leg3.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
            leg4.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
            tail.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        }
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
