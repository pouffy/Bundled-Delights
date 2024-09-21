package com.pouffydev.bundledelight.init.bundles.builtin;

import com.pouffydev.bundledelight.BundledDelights;
import com.pouffydev.bundledelight.foundation.Bundle;
import com.pouffydev.bundledelight.foundation.BundledRegistrate;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.List;

public class BuiltinBundle extends Bundle {
    private static final BundledRegistrate registrate = BundledDelights.registrate().creativeModeTab(() -> BundledDelights.itemGroup);
    
    public BuiltinBundle() {
        super("bundledelight");
    }
    
    @Override
    public List<String> getRequiredClasses() {
        return List.of("com.pouffydev.bundledelight.BundledDelights");
    }
    
    @Override
    protected void onLoad() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BuiltinItems.register();
        BuiltinBlocks.register();
    }
    
    public String getName() {
        return "Builtin";
    }
}
