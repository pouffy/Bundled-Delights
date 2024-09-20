package com.pouffydev.bundledelight.foundation.util.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        modid = "bundledelight",
        bus = Mod.EventBusSubscriber.Bus.MOD
)
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
        generator.addProvider(event.includeClient(), new LangProvider(generator));
    }
}

