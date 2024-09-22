package com.pouffydev.bundledelight.datagen;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.pouffydev.bundledelight.BundleManager;
import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.foundation.helper.FilesHelper;
import com.tterrag.registrate.providers.ProviderType;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Map;
import java.util.function.BiConsumer;

public class BundledDatagen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        addExtraRegistrateData();
        
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        
        boolean client = event.includeClient();
        boolean server = event.includeServer();
        
        BundleManager.bundleDatagen(generator, existingFileHelper, client, server);
    }
    
    private static void addExtraRegistrateData() {
        BundleRegistrateTags.addGenerators();
        
        BundledDelight.registrate.addDataGenerator(ProviderType.LANG, provider -> {
            BiConsumer<String, String> langConsumer = provider::add;
            
        });
    }
    
    private static void provideDefaultLang(String fileName, BiConsumer<String, String> consumer) {
        String path = "assets/bundledelight/lang/default/" + fileName + ".json";
        JsonElement jsonElement = FilesHelper.loadJsonResource(path);
        if (jsonElement == null) {
            throw new IllegalStateException(String.format("Could not find default lang file: %s", path));
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().getAsString();
            consumer.accept(key, value);
        }
    }
}
