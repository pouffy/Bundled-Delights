package com.pouffy.bundledelight.compat;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.ModList;

public abstract class CompatibleDoubleMod {
    private boolean isLoaded;

    public abstract String getModID();
    public abstract String getOtherModID();

    public void tryLoad() {
        if (ModList.get().isLoaded(this.getModID()) && (ModList.get().isLoaded(this.getOtherModID()))) {
            this.isLoaded = true;

            this.onLoad();
        }

    }

    protected abstract void onLoad();

    public boolean isLoaded() {
        return this.isLoaded;
    }

    public ResourceLocation getLocation(String path) {
        return new ResourceLocation(this.getModID(), path);
    }

}
