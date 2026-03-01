package com.brbiomesmod.entity.model;

import com.brbiomesmod.entity.custom.BotoEntity;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

public class BotoModel<T extends BotoEntity> extends EntityModel<T> {

    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer snout;
    private final ModelRenderer tail;
    private final ModelRenderer right_fin;
    private final ModelRenderer left_fin;
    private final ModelRenderer back_fin;
    private final ModelRenderer tail_fin;

    public BotoModel() {
        textureWidth = 64;
        textureHeight = 64;

        // BODY (root reference)
        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 24.0F, -3.0F);
        body.setTextureOffset(0, 13)
                .addBox(-1.0F, -2.0F, -10.0F, 2.0F, 2.0F, 4.0F);
        body.setTextureOffset(22, 0)
                .addBox(-4.0F, -7.0F, 0.0F, 8.0F, 7.0F, 13.0F);

        // HEAD
        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 24.0F, -9.0F);
        head.setTextureOffset(0, 0)
                .addBox(-4.0F, -7.0F, 0.0F, 8.0F, 7.0F, 6.0F);

        // SNOUT (properly attached visually)
        snout = new ModelRenderer(this);
        snout.setRotationPoint(0.0F, 0.0F, -4.0F);
        snout.setTextureOffset(0, 19)
                .addBox(-1.5F, -1.0F, -5.0F, 3.0F, 2.0F, 5.0F, 0.0F, false);
        head.addChild(snout);

        // TAIL
        tail = new ModelRenderer(this);
        tail.setRotationPoint(0.0F, 24.0F, 8.0F);
        tail.setTextureOffset(0, 19)
                .addBox(-2.0F, -5.5F, 0.0F, 4.0F, 5.0F, 11.0F);

        // RIGHT FIN
        right_fin = new ModelRenderer(this);
        right_fin.setRotationPoint(-4.5F, 24.0F, -2.0F);
        right_fin.setTextureOffset(48, 20)
                .addBox(-0.5F, -4.0F, 0.0F, 1.0F, 4.0F, 7.0F);

        // LEFT FIN
        left_fin = new ModelRenderer(this);
        left_fin.setRotationPoint(4.5F, 24.0F, -2.0F);
        left_fin.setTextureOffset(48, 20)
                .addBox(-0.5F, -4.0F, 0.0F, 1.0F, 4.0F, 7.0F);

        // BACK FIN
        back_fin = new ModelRenderer(this);
        back_fin.setRotationPoint(0.0F, 24.0F, -5.0F);
        back_fin.setTextureOffset(51, 0)
                .addBox(-0.5F, -11.0F, 8.0F, 1.0F, 4.0F, 5.0F);

        // TAIL FIN
        tail_fin = new ModelRenderer(this);
        tail_fin.setRotationPoint(0.0F, 24.0F, 19.0F);
        tail_fin.setTextureOffset(19, 20)
                .addBox(-5.0F, -3.5F, 0.0F, 10.0F, 1.0F, 6.0F);
    }

    @Override
    public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount,
                                  float ageInTicks, float netHeadYaw, float headPitch) {

        float speed = 0.2F;
        float degree = 0.5F;

        tail.rotateAngleY = MathHelper.cos(ageInTicks * speed) * degree;
        tail_fin.rotateAngleY = MathHelper.cos(ageInTicks * speed) * degree * 1.5F;
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer,
                       int packedLight, int packedOverlay,
                       float red, float green, float blue, float alpha) {

        head.render(matrixStack, buffer, packedLight, packedOverlay);
        snout.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        tail.render(matrixStack, buffer, packedLight, packedOverlay);
        right_fin.render(matrixStack, buffer, packedLight, packedOverlay);
        left_fin.render(matrixStack, buffer, packedLight, packedOverlay);
        back_fin.render(matrixStack, buffer, packedLight, packedOverlay);
        tail_fin.render(matrixStack, buffer, packedLight, packedOverlay);
    }
}