package com.pouffydev.bundledelight;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pouffydev.bundledelight.compat.farmersrespite.RespiteMDCompatItems;
import com.pouffydev.bundledelight.foundation.BundledRegistrate;
import com.pouffydev.bundledelight.foundation.util.Configuration;
import com.pouffydev.bundledelight.foundation.util.data.DataGenerators;
import com.pouffydev.bundledelight.init.BDBlocks;
import com.pouffydev.bundledelight.init.BDEffects;
import com.pouffydev.bundledelight.init.BDItems;
import com.pouffydev.bundledelight.init.bundles.builtin.BuiltinItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("bundledelight")
public class BundledDelights
{
    public static final String MODID = "bundledelight";
    public static final BundledRegistrate registrate = BundledRegistrate.create(MODID);
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting()
            .disableHtmlEscaping()
            .create();
    
    public static final CreativeModeTab itemGroup = new CreativeModeTab(MODID) {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(BuiltinItems.borscht.get());
        }
    };
    public static final Logger LOGGER = LogManager.getLogger();


    public BundledDelights()
    {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        IEventBus modEventBus = FMLJavaModLoadingContext.get()
                .getModEventBus();
        
        
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;
        
        registrate.registerEventListeners(modEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Configuration.COMMON_CONFIG);
        //CompatibleManager.visit();
        //DoubleCompatibleManager.visit();
        BundleManager.visit();

        //BDItems.ITEMS.register(modEventBus);
        //BDBlocks.BLOCKS.register(modEventBus);
        BDEffects.EFFECTS.register(modEventBus);
        modEventBus.addListener(EventPriority.LOWEST, DataGenerators::gatherData);
        //Compats
        RespiteMDCompatItems.ITEMS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // Some example code to dispatch IMC to another mod
        InterModComms.sendTo("bundledelight", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.messageSupplier().get()).
                collect(Collectors.toList()));
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("Bundling your Delights");
    }
    
    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MODID, path);
    }
    public static @NotNull BundledRegistrate registrate() {
        return registrate;
    }
}
