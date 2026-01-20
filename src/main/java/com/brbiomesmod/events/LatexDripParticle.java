package com.brbiomesmod.events;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LatexDripParticle extends SpriteTexturedParticle {

    protected LatexDripParticle(ClientWorld world, double x, double y, double z) {
        super(world, x, y, z);

        this.particleGravity = 0.03F;
        this.maxAge = 40;

        this.motionX = 0.0D;
        this.motionY = -0.02D;
        this.motionZ = 0.0D;

        this.setSize(0.02F, 0.02F);
    }

    @Override
    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Factory implements IParticleFactory<BasicParticleType> {

        private final IAnimatedSprite sprites;

        public Factory(IAnimatedSprite sprites) {
            this.sprites = sprites;
        }

        @Override
        public Particle makeParticle(BasicParticleType type, ClientWorld world,
                                     double x, double y, double z,
                                     double xSpeed, double ySpeed, double zSpeed) {

            LatexDripParticle particle = new LatexDripParticle(world, x, y, z);
            particle.selectSpriteRandomly(this.sprites);
            return particle;
        }
    }
}
