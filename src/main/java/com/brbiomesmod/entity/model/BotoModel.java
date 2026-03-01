package com.brbiomesmod.entity.model;

import com.brbiomesmod.entity.custom.BotoEntity;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class BotoModel<T extends BotoEntity> extends EntityModel<T> {

    private final ModelRenderer head;
    private final ModelRenderer snout;
    private final ModelRenderer body;
    private final ModelRenderer tail;
    private final ModelRenderer tailFin;
    private final ModelRenderer rightFin;
    private final ModelRenderer leftFin;
    private final ModelRenderer backFin;

    public BotoModel() {
        textureWidth = 64;
        textureHeight = 64;

        // BODY
        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 22.0F, 0.0F);
        body.setTextureOffset(22, 0)
                .addBox(-4.0F, -5.0F, -6.0F, 8, 7, 13);

        // HEAD
        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, -2.0F, -6.0F);
        body.addChild(head);
        // Main skull
        head.setTextureOffset(0, 0)
                .addBox(-4.0F, -3.0F, -4.0F, 8, 7, 4);

        // SNOUT (Rostrum)
        snout = new ModelRenderer(this);
        snout.setRotationPoint(0.0F, 0.0F, -4.0F);
        head.addChild(snout);

        snout.setTextureOffset(0, 32)
                .addBox(-1.0F, -1.5F, -8.0F, 2, 3, 8);

        // TAIL BASE
        tail = new ModelRenderer(this);
        tail.setRotationPoint(0.0F, -1.0F, 7.0F);
        body.addChild(tail);
        tail.setTextureOffset(0, 19)
                .addBox(-2.0F, -2.5F, 0.0F, 4, 5, 11);

        // TAIL FIN
        tailFin = new ModelRenderer(this);
        tailFin.setRotationPoint(0.0F, 0.0F, 11.0F);
        tail.addChild(tailFin);
        tailFin.setTextureOffset(19, 20)
                .addBox(-5.0F, -0.5F, -1.0F, 10, 1, 6);

        // RIGHT FIN
        rightFin = new ModelRenderer(this);
        rightFin.setRotationPoint(-4.0F, 0.0F, -2.0F);
        body.addChild(rightFin);
        rightFin.setTextureOffset(48, 20)
                .addBox(-1.0F, 0.0F, 0.0F, 1, 4, 7);

        // LEFT FIN
        leftFin = new ModelRenderer(this);
        leftFin.setRotationPoint(4.0F, 0.0F, -2.0F);
        body.addChild(leftFin);
        leftFin.setTextureOffset(48, 20)
                .addBox(0.0F, 0.0F, 0.0F, 1, 4, 7);

        // BACK FIN
        backFin = new ModelRenderer(this);
        backFin.setRotationPoint(0.0F, -5.0F, 2.0F);
        body.addChild(backFin);
        backFin.setTextureOffset(51, 0)
                .addBox(-0.5F, 0.0F, 0.0F, 1, 4, 5);
    }

    @Override
    public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount,
                                  float ageInTicks, float netHeadYaw, float headPitch) {

        // Reset rotations
        head.rotateAngleX = 0;
        head.rotateAngleY = 0;
        head.rotateAngleZ = 0;

        body.rotateAngleX = 0;
        body.rotateAngleY = 0;
        body.rotateAngleZ = 0;

        tail.rotateAngleX = 0;
        tail.rotateAngleY = 0;
        tail.rotateAngleZ = 0;

        tailFin.rotateAngleX = 0;
        tailFin.rotateAngleY = 0;
        tailFin.rotateAngleZ = 0;

        // Swimming animation
        if (entity.getMotion().lengthSquared() > 0.0001D) {
            float swimSpeed = 0.15F;
            float swimDegree = 0.6F;

            body.rotateAngleX = MathHelper.cos(ageInTicks * swimSpeed) * swimDegree * 0.2F;
            tail.rotateAngleX = MathHelper.cos(ageInTicks * swimSpeed) * swimDegree;
            tailFin.rotateAngleX = MathHelper.cos(ageInTicks * swimSpeed) * swimDegree * 1.5F;
        }

        // Fins subtle movement
        rightFin.rotateAngleZ = -0.2F;
        leftFin.rotateAngleZ = 0.2F;
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight,
                       int packedOverlay, float red, float green, float blue, float alpha) {

        body.render(matrixStack, buffer, packedLight, packedOverlay);
    }
}
