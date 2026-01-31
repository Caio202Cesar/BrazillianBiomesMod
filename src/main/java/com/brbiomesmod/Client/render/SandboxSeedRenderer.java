package com.brbiomesmod.Client.render;

import com.brbiomesmod.events.SandboxSeedEntity;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SandboxSeedRenderer extends SpriteRenderer<SandboxSeedEntity> {

    public SandboxSeedRenderer(EntityRendererManager manager, ItemRenderer itemRenderer) {
        super(manager, itemRenderer);
    }
}
