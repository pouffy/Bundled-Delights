package com.pouffy.bundledelight.compats;

import com.pouffy.bundledelight.util.ItemRegistryUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.ModList;

public abstract class CompatibleDoubleMod {
    private boolean isLoaded;

    public abstract String getRequiredClass();
    public abstract String getOtherRequiredClass();
    
    public abstract String getModid();

    public void tryLoad() {
        if (ItemRegistryUtils.isClassFound(this.getRequiredClass()) && ItemRegistryUtils.isClassFound(this.getOtherRequiredClass())) {
            this.isLoaded = true;

            this.onLoad();
        }

    }

    protected abstract void onLoad();

    public boolean isLoaded() {
        return this.isLoaded;
    }

    public ResourceLocation getLocation(String path) {
        return new ResourceLocation(this.getModid(), path);
    }

}
