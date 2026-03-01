package com.brbiomesmod.entity.model;

import com.brbiomesmod.entity.custom.MapinguariEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class MapinguariModel<T extends MapinguariEntity> extends EntityModel<T> {
    private final ModelRenderer body;
    private final ModelRenderer right_arm;
    private final ModelRenderer left_arm;
    private final ModelRenderer right_leg;
    private final ModelRenderer left_leg;

    public MapinguariModel() {
        textureWidth = 128;
        textureHeight = 128;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, -7.0F, 0.0F); // -7.0F offset converted
        body.setTextureOffset(0, 40)
                .addBox(-9.0F, -2.0F, -6.0F,
                        18.0F, 12.0F, 11.0F,
                        0.0F);

        body.setTextureOffset(0, 70)
                .addBox(-4.5F, 10.0F, -3.0F,
                        9.0F, 5.0F, 6.0F,
                        0.5F);

        // ================= RIGHT ARM =================
        right_arm = new ModelRenderer(this);
        right_arm.setRotationPoint(-5.0F, -7.0F, 0.0F);
        right_arm.setTextureOffset(60, 21)
                .addBox(-13.0F, -2.5F, -3.0F,
                        4.0F, 30.0F, 6.0F,
                        0.0F);

        // ================= LEFT ARM =================
        left_arm = new ModelRenderer(this);
        left_arm.setRotationPoint(5.0F, -7.0F, 0.0F);
        left_arm.setTextureOffset(60, 58)
                .addBox(9.0F, -2.5F, -3.0F,
                        4.0F, 30.0F, 6.0F,
                        0.0F);

        // ================= RIGHT LEG =================
        right_leg = new ModelRenderer(this);
        right_leg.setRotationPoint(-5F, 11F, 0F);
        right_leg.setTextureOffset(37, 0)
                .addBox(-3.5F, -3.0F, -3.0F,
                        6.0F, 16.0F, 5.0F,
                        0.0F);

        // ================= LEFT LEG =================
        left_leg = new ModelRenderer(this);
        left_leg.setRotationPoint(4F, 11F, 0F);
        left_leg.setTextureOffset(60, 0)
                .addBox(-3.5F, -3.0F, -3.0F,
                        6.0F, 16.0F, 5.0F,
                        0.0F);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float walkSpeed = 0.45F;

        // Legs — slower, heavier stride
        this.right_leg.rotateAngleX =
                MathHelper.cos(limbSwing * walkSpeed + (float)Math.PI)
                        * 1.0F * limbSwingAmount;

        this.left_leg.rotateAngleX =
                MathHelper.cos(limbSwing * walkSpeed)
                        * 1.0F * limbSwingAmount;

        // Arms — exaggerated forward swing (crushing motion)
        this.right_arm.rotateAngleX =
                MathHelper.cos(limbSwing * walkSpeed)
                        * 1.3F * limbSwingAmount;

        this.left_arm.rotateAngleX =
                MathHelper.cos(limbSwing * walkSpeed + (float)Math.PI)
                        * 1.3F * limbSwingAmount;

        // Slight body sway for weight
        this.body.rotateAngleX =
                MathHelper.cos(ageInTicks * 0.05F) * 0.02F;

        // ===== ATTACK OVERRIDE =====
        if (entityIn.swingProgress > 0) {
            float attackProgress = entityIn.swingProgress;

            this.right_arm.rotateAngleX = -2.0F * attackProgress;
            this.left_arm.rotateAngleX = -2.0F * attackProgress;
        }

    }


    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        right_arm.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        left_arm.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        right_leg.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        left_leg.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }
}
