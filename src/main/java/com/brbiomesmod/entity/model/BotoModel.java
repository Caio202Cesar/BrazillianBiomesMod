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
    private final ModelRenderer body;
    private final ModelRenderer tail;
    private final ModelRenderer tailFin;

    public BotoModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        float f = 18.0F;
        float f1 = -8.0F;
        this.body = new ModelRenderer(this, 22, 0);
        this.body.addBox(-4.0F, -7.0F, 0.0F, 8.0F, 7.0F, 13.0F);
        this.body.setRotationPoint(0.0F, 22.0F, -5.0F);
        ModelRenderer modelrenderer = new ModelRenderer(this, 51, 0);
        modelrenderer.addBox(-0.5F, 0.0F, 8.0F, 1.0F, 4.0F, 5.0F);
        modelrenderer.rotateAngleX = ((float)Math.PI / 3F);
        this.body.addChild(modelrenderer);
        ModelRenderer modelrenderer1 = new ModelRenderer(this, 48, 20);
        modelrenderer1.mirror = true;
        modelrenderer1.addBox(-0.5F, -4.0F, 0.0F, 1.0F, 4.0F, 7.0F);
        modelrenderer1.setRotationPoint(2.0F, -2.0F, 4.0F);
        modelrenderer1.rotateAngleX = ((float)Math.PI / 3F);
        modelrenderer1.rotateAngleZ = 2.0943952F;
        this.body.addChild(modelrenderer1);
        ModelRenderer modelrenderer2 = new ModelRenderer(this, 48, 20);
        modelrenderer2.addBox(-0.5F, -4.0F, 0.0F, 1.0F, 4.0F, 7.0F);
        modelrenderer2.setRotationPoint(-2.0F, -2.0F, 4.0F);
        modelrenderer2.rotateAngleX = ((float)Math.PI / 3F);
        modelrenderer2.rotateAngleZ = -2.0943952F;
        this.body.addChild(modelrenderer2);
        this.tail = new ModelRenderer(this, 0, 19);
        this.tail.addBox(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 11.0F);
        this.tail.setRotationPoint(0.0F, -2.5F, 11.0F);
        this.tail.rotateAngleX = -0.10471976F;
        this.body.addChild(this.tail);
        this.tailFin = new ModelRenderer(this, 19, 20);
        this.tailFin.addBox(-5.0F, -0.5F, 0.0F, 10.0F, 1.0F, 6.0F);
        this.tailFin.setRotationPoint(0.0F, 0.0F, 9.0F);
        this.tailFin.rotateAngleX = 0.0F;
        this.tail.addChild(this.tailFin);
        ModelRenderer modelrenderer3 = new ModelRenderer(this, 0, 0);
        modelrenderer3.addBox(-4.0F, -3.0F, -3.0F, 8.0F, 7.0F, 6.0F);
        modelrenderer3.setRotationPoint(0.0F, -4.0F, -3.0F);
        ModelRenderer modelrenderer4 = new ModelRenderer(this, 0, 13);
        modelrenderer4.addBox(-1.0F, 2.0F, -7.0F, 2.0F, 2.0F, 4.0F);
        modelrenderer3.addChild(modelrenderer4);
        this.body.addChild(modelrenderer3);
    }

    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(this.body);
    }

    /**
     * Sets this entity's model rotation angles
     */
    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount,
                                  float ageInTicks, float netHeadYaw, float headPitch) {

        // Reset rotations (important!)
        this.body.rotateAngleX = 0.0F;
        this.body.rotateAngleY = 0.0F;
        this.tail.rotateAngleX = -0.1F;
        this.tail.rotateAngleY = 0.0F;
        this.tailFin.rotateAngleX = 0.0F;

        // Head/body turning
        this.body.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F) * 0.5F;

        boolean isMoving = Entity.horizontalMag(entityIn.getMotion()) > 1.0E-7D;
        boolean inWater = entityIn.isInWater();

        if (inWater) {

            if (isMoving) {
                // Smooth swimming wave
                float swimSpeed = 0.4F;
                float swimDegree = 0.6F;

                this.body.rotateAngleY += MathHelper.cos(ageInTicks * swimSpeed) * 0.05F;

                this.tail.rotateAngleY =
                        MathHelper.cos(ageInTicks * swimSpeed) * swimDegree;

                this.tailFin.rotateAngleY =
                        MathHelper.cos(ageInTicks * swimSpeed + 0.5F) * swimDegree * 1.4F;
            }
            else {
                // Idle floating motion
                this.body.rotateAngleX =
                        MathHelper.cos(ageInTicks * 0.1F) * 0.02F;

                this.tail.rotateAngleY =
                        MathHelper.cos(ageInTicks * 0.15F) * 0.1F;
            }
        }
        else {
            // Beached flop animation
            this.body.rotateAngleZ =
                    MathHelper.cos(ageInTicks * 0.8F) * 0.2F;

            this.tail.rotateAngleY =
                    MathHelper.cos(ageInTicks * 0.8F) * 0.6F;
        }
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {

    }
}
