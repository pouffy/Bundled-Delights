package com.pouffydev.bundledelight.foundation.data;

import com.google.gson.JsonObject;
import com.pouffydev.bundledelight.BundleManager;
import com.pouffydev.bundledelight.BundledDelight;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

import java.util.Objects;

public class BundleLoadedCondition implements ICondition {
    private static final ResourceLocation NAME = new ResourceLocation(BundledDelight.MODID, "bundle_loaded");
    private final String bundle;
    
    public BundleLoadedCondition(String bundle) {
        this.bundle = bundle;
    }
    
    @Override
    public ResourceLocation getID() {
        return NAME;
    }
    
    @Override
    public boolean test(IContext iContext) {
        return BundleManager.getBundle(bundle) != null && Objects.requireNonNull(BundleManager.getBundle(bundle)).isLoaded();
    }
    
    public static class Serializer implements IConditionSerializer<BundleLoadedCondition> {
        public static final Serializer INSTANCE = new Serializer();
        
        public Serializer() {
        }
        
        @Override
        public void write(JsonObject jsonObject, BundleLoadedCondition bundleLoadedCondition) {
            jsonObject.addProperty("bundle", bundleLoadedCondition.bundle);
        }
        
        @Override
        public BundleLoadedCondition read(JsonObject jsonObject) {
            return new BundleLoadedCondition(GsonHelper.getAsString(jsonObject, "bundle"));
        }
        
        @Override
        public ResourceLocation getID() {
            return BundleLoadedCondition.NAME;
        }
    }
}
