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
        texWidth = 64;
        texHeight = 64;

        body = new ModelRenderer(this);
        body.setPos(0.0F, 24.0F, 0.0F);
        body.texOffs(0, 0).addBox(-4.0F, -9.0F, -5.0F, 6.0F, 7.0F, 11.0F, 0.0F, false);

        legs = new ModelRenderer(this);
        legs.setPos(0.0F, 24.0F, 0.0F);
        legs.texOffs(22, 18).addBox(-4.0F, -2.0F, 4.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        legs.texOffs(22, 26).addBox(-4.0F, -2.0F, -4.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        legs.texOffs(0, 30).addBox(0.0F, -2.0F, -4.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        legs.texOffs(22, 22).addBox(0.0F, -2.0F, 4.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setPos(0.0F, 16.0F, -7.0F);
        head.texOffs(0, 18).addBox(-3.0F, -3.0F, -5.0F, 4.0F, 5.0F, 7.0F, 0.0F, false);
        head.texOffs(8, 30).addBox(-4.0F, -5.0F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        head.texOffs(14, 30).addBox(1.0F, -5.0F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        legs.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}