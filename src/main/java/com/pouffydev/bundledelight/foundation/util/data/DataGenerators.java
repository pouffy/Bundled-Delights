package com.pouffydev.bundledelight.foundation.util.data;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.pouffydev.bundledelight.BundledDelights;
import com.pouffydev.bundledelight.foundation.util.FilesHelper;
import com.tterrag.registrate.providers.ProviderType;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Map;
import java.util.function.BiConsumer;

public class DataGenerators {
    public DataGenerators() {
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();
        
        BlockTags blockTags = new BlockTags(generator, "bundledelight", helper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new ItemTags(generator, blockTags, "bundledelight", helper));
        //generator.addProvider(new EntityTags(generator, "bundledelight", helper));
        generator.addProvider(event.includeServer(), new Recipes(generator));
        generator.addProvider(event.includeServer(), new Advancements(generator));
        
        BlockStates blockStates = new BlockStates(generator, helper);
        generator.addProvider(event.includeClient(), blockStates);
        generator.addProvider(event.includeClient(), new ItemModels(generator, blockStates.models().existingFileHelper));
    }
    
    private static void addExtraRegistrateData() {
        BundledDelights.registrate.addDataGenerator(ProviderType.LANG, provider -> {
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

