package com.pouffydev.bundledelight.mixin.miners_delight;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.pouffydev.bundledelight.BundleManager;
import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.foundation.bundle.Bundle;
import com.sammy.minersdelight.logic.CupConversionReloadListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.*;

import java.util.HashMap;
import java.util.Map;


@Mixin(CupConversionReloadListener.class)
public class CupConversionReloadListenerMixin {

    @Shadow(remap = false)
    @Final
    public static HashMap<Item, Item> BOWL_TO_CUP;

    @Shadow(remap = false)
    public static Item itemFromJson(JsonElement jsonElement) {
        return null;
    }

    /**
     * @author PouffyDev
     * @reason Make it check for bundle specific conversions so it doesn't break when one item isn't found
     */
    @Overwrite(remap = false)
    protected void apply(Map<ResourceLocation, JsonElement> objectIn, ResourceManager resourceManagerIn, ProfilerFiller profilerIn) {
        BOWL_TO_CUP.clear();

        for(int i = 0; i < objectIn.size(); ++i) {
            ResourceLocation location = (ResourceLocation)objectIn.keySet().toArray()[i];
            JsonObject object = objectIn.get(location).getAsJsonObject();
            JsonArray entries = object.getAsJsonArray("entries");

            for (JsonElement entry : entries) {
                JsonObject entryObject = entry.getAsJsonObject();
                if (entryObject.has("bundle") && !bundledDelight$isBundleLoaded(entryObject.get("bundle").getAsString())) {
                    BundledDelight.LOGGER.warn("[Bundled Delight's 'Miner's Delight' MIXIN] Bundle " + entryObject.get("bundle").getAsString() + " is not loaded, skipping copper cup conversion");
                    continue;
                }
                Item bowlFood = itemFromJson(entryObject.get("bowl"));
                Item cupFood = itemFromJson(entryObject.get("cup"));
                BOWL_TO_CUP.put(bowlFood, cupFood);
            }
        }

    }

    @Unique
    private static boolean bundledDelight$isBundleLoaded(String bundleName) {
        Bundle bundle = BundleManager.getBundle(bundleName);
        return bundle != null && bundle.isLoaded();
    }
}
