package com.pouffy.bundledelight.util;

import com.pouffy.bundledelight.BundledDelights;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forgespi.language.IModFileInfo;
import net.minecraftforge.forgespi.locating.IModFile;

@Mod.EventBusSubscriber
public class CommonEvents {
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModBusEvents {

        @SubscribeEvent
        public static void addPackFinders(AddPackFindersEvent event) {
            if (event.getPackType() == PackType.CLIENT_RESOURCES) {
                IModFileInfo modFileInfo = ModList.get().getModFileById(BundledDelights.MODID);
                if (modFileInfo == null) {
                    BundledDelights.LOGGER.error("Could not find Bundled Delight mod file info; built-in resource packs will be missing!");
                    return;
                }
                IModFile modFile = modFileInfo.getFile();
                event.addRepositorySource((consumer, constructor) -> {
                    consumer.accept(Pack.create(BundledDelights.asResource("bundledelight_resprites").toString(), false, () -> new ModFilePackResources("Bundled Delight Resprites", modFile, "resourcepacks/bundledelight_resprites"), constructor, Pack.Position.TOP, PackSource.DEFAULT));
                });
            }
        }

    }
}
