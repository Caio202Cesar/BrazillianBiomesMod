package com.brbiomesmod.events;

import com.brbiomesmod.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class SandboxSeedEntity extends ThrowableEntity implements IRendersAsItem {
    private LivingEntity shooter;

    public SandboxSeedEntity(EntityType<? extends SandboxSeedEntity> type, World world) {
        super(type, world);
    }

    // thrower constructor
    public SandboxSeedEntity(World world, LivingEntity shooter) {
        super(ModEntities.SANDBOX_SEED.get(), shooter, world);
    }

    public SandboxSeedEntity(EntityType<? extends SandboxSeedEntity> type, World world, double x, double y, double z) {
        super(type, x, y, z, world);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (!world.isRemote) {
            if (result.getType() == RayTraceResult.Type.ENTITY) {
                EntityRayTraceResult hit = (EntityRayTraceResult) result;
                hit.getEntity().attackEntityFrom(DamageSource.GENERIC, 3.0F);
            }
            this.remove();
        }
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(ModItems.SANDBOX_TREE_SEEDS.get());
    }

    @Override
    protected void registerData() {

    }
}