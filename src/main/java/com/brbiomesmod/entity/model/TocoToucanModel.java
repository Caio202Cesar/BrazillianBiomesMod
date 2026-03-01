package com.brbiomesmod.entity.model;

import com.brbiomesmod.entity.custom.TocoToucanEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;

public class TocoToucanModel<T extends TocoToucanEntity> extends EntityModel<T> {
    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer left_wing;
    private final ModelRenderer left_wing_rotation;
    private final ModelRenderer right_wing;
    private final ModelRenderer right_wing_rotation;
    private final ModelRenderer left_leg;
    private final ModelRenderer right_leg;
    private final ModelRenderer tail;

    public TocoToucanModel() {
        textureWidth = 32;
        textureHeight = 32;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 16.0F, -0.5F);
        head.setTextureOffset(2, 2)
                .addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

        head.setTextureOffset(7, 3)
                .addBox(-0.5F, -1.5F, -6.0F, 1.0F, 2.0F, 5.0F, 0.0F, false);

        head.setTextureOffset(16, 7)
                .addBox(-0.5F, -0.75F, -5.95F, 1.0F, 1.0F, 1.0F, -0.01F, false);


        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 16.5F, -1.0F);
        body.setTextureOffset(2, 8)
                .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, 0.0F, false);


        left_wing = new ModelRenderer(this);
        left_wing.setRotationPoint(1.5F, 16.9F, -0.8F);

        left_wing_rotation = new ModelRenderer(this);
        left_wing_rotation.setRotationPoint(0.0F, 2.5F, 0.0F);
        left_wing.addChild(left_wing_rotation);

        left_wing_rotation.setTextureOffset(19, 8)
                .addBox(-0.5F, -2.5F, -1.5F, 1.0F, 5.0F, 3.0F, 0.0F, false);

        // Remove 180° Y flip unless truly needed
        // setRotationAngle(leftWingRotation, 0.0F, 3.1416F, 0.0F);

        right_wing = new ModelRenderer(this);
        right_wing.setRotationPoint(-1.5F, 16.9F, -0.8F);

        right_wing_rotation = new ModelRenderer(this);
        right_wing_rotation.setRotationPoint(0.0F, 2.5F, 0.0F);
        right_wing.addChild(right_wing_rotation);

        right_wing_rotation.setTextureOffset(19, 8)
                .addBox(-0.5F, -2.5F, -1.5F, 1.0F, 5.0F, 3.0F, 0.0F, true); // mirrored


        // LEFT LEG
        left_leg = new ModelRenderer(this);
        left_leg.setRotationPoint(1.0F, 22.0F, -1.0F);
        left_leg.setTextureOffset(14, 18)
                .addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);


        // RIGHT LEG
        right_leg = new ModelRenderer(this);
        right_leg.setRotationPoint(-1.0F, 22.0F, -1.0F);
        right_leg.setTextureOffset(14, 18)
                .addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, true);


        tail = new ModelRenderer(this);
        tail.setRotationPoint(0.0F, 21.1F, 1.2F);
        tail.setTextureOffset(22, 1)
                .addBox(-1.5F, -1.0F, -1.0F, 3.0F, 4.0F, 1.0F, 0.0F, false);

    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;

    }


    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount,
                                  float ageInTicks, float netHeadYaw, float headPitch) {

        // Head movement
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);

        Vector3d motion = entityIn.getMotion();

        boolean isFlying = !entityIn.isOnGround() && Math.abs(motion.y) > 0.01D;

        if (isFlying) {
            float flap = MathHelper.cos(ageInTicks * 2.5F) * 1.2F;

            right_wing_rotation.rotateAngleZ = flap;
            left_wing_rotation.rotateAngleZ = -flap;
        } else {
            float glide = 0.15F;
            right_wing_rotation.rotateAngleZ = glide;
            left_wing_rotation.rotateAngleZ = -glide;
        }
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
        left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        right_wing.render(matrixStack, buffer, packedLight, packedOverlay);
        left_wing.render(matrixStack, buffer, packedLight, packedOverlay);
    }
}
