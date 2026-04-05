package com.brbiomesmod.entity.custom;

import com.brbiomesmod.entity.ModEntityTypes;
import net.minecraft.block.material.Material;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public class CapybaraEntity extends AnimalEntity {

    public CapybaraEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 20.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.2D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.2D,
                Ingredient.fromItems(Items.WHEAT, Items.CARROT), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.1D));// slower panic

    }

    @Override
    protected boolean canFitPassenger(Entity passenger) {
        // Only allow parrots (or your custom birds)
        if (!(passenger instanceof ParrotEntity || passenger instanceof TocoToucanEntity)) return false;

        return this.getPassengers().size() < 3; // allow up to 3 birds
    }

    @Override
    public void updatePassenger(Entity passenger) {
        super.updatePassenger(passenger);

        int index = this.getPassengers().indexOf(passenger);

        float yOffset = 0.65F; // height of back

        float xOffset = 0.0F;
        float zOffset = 0.2F;

        // Different layouts depending on number of birds
        int count = this.getPassengers().size();

        if (count == 1) {
            // center
            xOffset = 0.0F;
            zOffset = 0.1F;
        }
        else if (count == 2) {
            // left and right
            xOffset = (index == 0) ? -0.25F : 0.25F;
            zOffset = 0.15F;
        }
        else if (count >= 3) {
            // triangle formation
            if (index == 0) {
                xOffset = 0.0F;
                zOffset = 0.0F;
            } else if (index == 1) {
                xOffset = -0.25F;
                zOffset = 0.3F;
            } else {
                xOffset = 0.25F;
                zOffset = 0.3F;
            }
        }

        float yaw = this.renderYawOffset * ((float)Math.PI / 180F);

        // rotate offsets with body
        double rotatedX = xOffset * MathHelper.cos(yaw) - zOffset * MathHelper.sin(yaw);
        double rotatedZ = xOffset * MathHelper.sin(yaw) + zOffset * MathHelper.cos(yaw);

        passenger.setPosition(
                this.getPosX() + rotatedX,
                this.getPosY() + yOffset,
                this.getPosZ() + rotatedZ
        );
    }

    @Override
    public void livingTick() {
        super.livingTick();

        // If in water → birds leave
        if (this.isInWater()) {
            this.removePassengers();
        }

        // If running fast → birds leave
        if (this.getMotion().lengthSquared() > 0.2D) {
            this.removePassengers();
        }
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() == Items.WHEAT || stack.getItem() == Items.CARROT;
    }

    @Override
    public AgeableEntity createChild(ServerWorld world, AgeableEntity mate) {
        return ModEntityTypes.CAPYBARA_ENTITY.get().create(world);
    }

    @Override
    public float getBlockPathWeight(BlockPos pos, IWorldReader worldIn) {
        if (worldIn.getBlockState(pos).getMaterial() == Material.WATER) {
            return 10.0F;
        }
        return super.getBlockPathWeight(pos, worldIn);
    }

    @Override
    public boolean canBreatheUnderwater() {
        return false; // keep realistic
    }

    @Override
    public int getMaxAir() {
        return 600; // stays underwater longer
    }
}
