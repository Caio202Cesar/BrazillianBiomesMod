package com.brbiomesmod.entity.goals;

import com.brbiomesmod.entity.custom.CapybaraEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.Goal;

import java.util.List;

public class SitOnCapybaraGoal extends Goal {

    private final CreatureEntity bird;
    private CapybaraEntity target;

    public SitOnCapybaraGoal(CreatureEntity bird) {
        this.bird = bird;
    }

    @Override
    public boolean shouldExecute() {
        List<CapybaraEntity> list = bird.world.getEntitiesWithinAABB(
                CapybaraEntity.class,
                bird.getBoundingBox().grow(6.0D)
        );

        if (!list.isEmpty()) {
            target = list.get(0);
            return target.getPassengers().size() < 2;
        }

        return false;
    }

    @Override
    public void startExecuting() {
        bird.getNavigator().tryMoveToEntityLiving(target, 1.0D);
    }

    @Override
    public void tick() {
        if (target == null) return;

        if (bird.getDistance(target) < 2.0D) {
            bird.startRiding(target);
        }
    }
}
