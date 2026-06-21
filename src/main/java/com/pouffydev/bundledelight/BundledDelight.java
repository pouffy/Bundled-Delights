package com.pouffydev.bundledelight;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pouffydev.bundledelight.datagen.BundledDatagen;
import com.pouffydev.bundledelight.init.CommonSetup;
import com.pouffydev.krystal_core.KrystalCore;
import com.pouffydev.krystal_core.foundation.bundle.BundleManager;
import com.pouffydev.krystal_core.foundation.registry.RegistryHelper;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Contract;

@Mod(BundledDelight.MODID)
public class BundledDelight {
    public static BundledDelight INSTANCE;
    public static final String MODID = "bundledelight";
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting()
            .disableHtmlEscaping()
            .create();
    
    public static final boolean isDevelopmentEnvironment = !FMLEnvironment.production;

    public static final Logger LOGGER = LogManager.getLogger();

    public final BundleManager bundleManager;

    private final IEventBus modEventBus;
    private final RegistryHelper registryHelper;
    
    public BundledDelight(IEventBus modEventBus, ModContainer modContainer) {
        KrystalCore.disableDebugFeatures();
        this.modEventBus = modEventBus;
        INSTANCE = this;
        this.registryHelper = new RegistryHelper(MODID, modEventBus);
        this.bundleManager = BundleManager.create(MODID, modEventBus);
        BundleDelightCreativeTab.staticInit();
        
        modEventBus.addListener(EventPriority.LOWEST, BundledDatagen::gatherData);
        modEventBus.addListener(CommonSetup::init);
    }

    public static IEventBus getEventBus() {
        return INSTANCE.modEventBus;
    }

    public static RegistryHelper getRegistryHelper() {
        return INSTANCE.registryHelper;
    }

    @Contract("_ -> new")
    public static ResourceLocation location(String path) {
        if (path.contains(":")) {
            return ResourceLocation.tryParse(path);
        }
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}
