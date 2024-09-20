package com.pouffy.bundledelight.util.data;

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
        if (event.includeServer()) {
            BlockTags blockTags = new BlockTags(generator, "bundledelight", helper);
            generator.addProvider(true, blockTags);
            generator.addProvider(true, new ItemTags(generator, blockTags, "bundledelight", helper));
            //generator.addProvider(new EntityTags(generator, "bundledelight", helper));
            generator.addProvider(true, new Recipes(generator));
            generator.addProvider(true, new Advancements(generator));
        }

        if (event.includeClient()) {
            BlockStates blockStates = new BlockStates(generator, helper);
            generator.addProvider(true, blockStates);
            generator.addProvider(true, new ItemModels(generator, helper));
            generator.addProvider(true, new LangProvider(generator));
        }

    }
}

