package com.brbiomesmod.entity.model;

import com.brbiomesmod.entity.custom.GoldenLionTamarinEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class GoldenLionTamarinModel<T extends GoldenLionTamarinEntity> extends EntityModel<T> {

    private final ModelRenderer bb_main;
    private final ModelRenderer head;
    private final ModelRenderer front_limb_right;
    private final ModelRenderer front_limb_left;
    private final ModelRenderer back_limb_right;
    private final ModelRenderer back_limb_left;
    private final ModelRenderer tail;
    private final ModelRenderer tail_middle_r1;
    private final ModelRenderer tail_top_r1;

    public GoldenLionTamarinModel() {
        textureWidth = 32;
        textureHeight = 32;

        // =========================
        // BODY ROOT
        // =========================
        bb_main = new ModelRenderer(this);
        bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
        bb_main.setTextureOffset(0, 0)
                .addBox(-2.0F, -8.0F, -3.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);

        // =========================
        // HEAD
        // =========================
        head = new ModelRenderer(this);
        head.setRotationPoint(-0.5F, -5.0F, -3.0F);
        bb_main.addChild(head);

        head.setTextureOffset(0, 8)
                .addBox(-2.5F, -4.0F, -3.0F, 5.0F, 4.0F, 3.0F, 0.0F, false);
        head.setTextureOffset(0, 1)
                .addBox(-1.5F, -2.0F, -5.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(16, 0)
                .addBox(-1.5F, -3.0F, -4.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);

        // =========================
        // FRONT LIMBS
        // =========================
        front_limb_right = new ModelRenderer(this);
        front_limb_right.setRotationPoint(1.0F, -5.0F, -2.0F);
        bb_main.addChild(front_limb_right);
        front_limb_right.setTextureOffset(20, 4)
                .addBox(0.0F, 0.0F, -1.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        front_limb_left = new ModelRenderer(this);
        front_limb_left.setRotationPoint(-2.0F, -5.0F, -2.0F);
        bb_main.addChild(front_limb_left);
        front_limb_left.setTextureOffset(16, 19)
                .addBox(0.0F, 0.0F, -1.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        // =========================
        // BACK LIMBS
        // =========================
        back_limb_right = new ModelRenderer(this);
        back_limb_right.setRotationPoint(1.0F, -5.0F, 1.0F);
        bb_main.addChild(back_limb_right);
        back_limb_right.setTextureOffset(16, 4)
                .addBox(0.0F, 0.0F, 0.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        back_limb_left = new ModelRenderer(this);
        back_limb_left.setRotationPoint(-2.0F, -5.0F, 1.0F);
        bb_main.addChild(back_limb_left);
        back_limb_left.setTextureOffset(12, 19)
                .addBox(0.0F, 0.0F, 0.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        // =========================
        // TAIL
        // =========================
        tail = new ModelRenderer(this);
        tail.setRotationPoint(-0.5F, -6.0F, 2.0F);
        bb_main.addChild(tail);
        tail.setTextureOffset(12, 15)
                .addBox(-0.5F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        tail_middle_r1 = new ModelRenderer(this);
        tail_middle_r1.setRotationPoint(0.0F, 0.0F, 3.0F);
        tail.addChild(tail_middle_r1);
        setRotationAngle(tail_middle_r1, 0.48F, 0.0F, 0.0F);
        tail_middle_r1.setTextureOffset(16, 10)
                .addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        tail_top_r1 = new ModelRenderer(this);
        tail_top_r1.setRotationPoint(0.0F, 1.0F, 1.0F);
        tail_middle_r1.addChild(tail_top_r1);
        setRotationAngle(tail_top_r1, -1.0F, 0.0F, 0.0F);
        tail_top_r1.setTextureOffset(0, 15)
                .addBox(-0.5F, -1.0F, 0.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
    }

    // =========================
    // ANIMATION
    // =========================
    @Override
    public void setRotationAngles(T entity,
                                  float limbSwing,
                                  float limbSwingAmount,
                                  float ageInTicks,
                                  float netHeadYaw,
                                  float headPitch) {

        head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        head.rotateAngleX = headPitch * ((float)Math.PI / 180F);

        front_limb_right.rotateAngleX =
                MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        front_limb_left.rotateAngleX =
                MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        back_limb_right.rotateAngleX =
                MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        back_limb_left.rotateAngleX =
                MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

        // Optional subtle tail swing
        tail.rotateAngleY = MathHelper.cos(ageInTicks * 0.2F) * 0.1F;
    }

    // =========================
    // RENDER
    // =========================
    @Override
    public void render(MatrixStack matrixStack,
                       IVertexBuilder buffer,
                       int packedLight,
                       int packedOverlay,
                       float red, float green, float blue, float alpha) {
        if (this.isChild) {

            matrixStack.push();

            // Make baby smaller
            matrixStack.scale(0.5F, 0.5F, 0.5F);

            // Adjust height so it doesn't render inside ground
            matrixStack.translate(0.0D, 1.5D, 0.0D);

            // Render model parts
            bb_main.render(matrixStack, buffer, packedLight, packedOverlay);

            matrixStack.pop();

        } else {

        bb_main.render(matrixStack, buffer, packedLight, packedOverlay,
                red, green, blue, alpha);
        }
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}