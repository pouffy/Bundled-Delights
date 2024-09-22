package com.pouffydev.bundledelight.foundation.data;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

public interface FinishedData {
    void serializeData(JsonObject var1);
    
    default JsonObject serialize() {
        JsonObject object = new JsonObject();
        object.addProperty("type", getType().toString());
        this.serializeData(object);
        return object;
    }
    
    ResourceLocation getId();
    
    ResourceLocation getType();
    
    @Nullable
    JsonObject serializeAdvancement();
    
    @Nullable
    ResourceLocation getAdvancementId();
}
