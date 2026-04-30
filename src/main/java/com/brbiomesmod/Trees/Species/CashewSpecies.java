package com.brbiomesmod.Trees.Species;

import com.ferreusveritas.dynamictrees.trees.Species;

public class CashewSpecies extends Species {

    public static final TypedRegistry.EntryType<Species> TYPE = createDefaultType(MapleSpecies::new);

    public MapleSpecies(ResourceLocation name, Family family, LeavesProperties leavesProperties) {
        super(name, family, leavesProperties);
    }

    @Override
    public Species generateSeed() {
        this.setSeed(RegistryHandler.addItem(this.getSeedName(), () -> new MapleSeed(this)));
        return this;
    }
}
