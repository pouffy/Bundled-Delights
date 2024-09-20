package com.pouffy.bundledelight.compats.neapolitan;

import com.pouffy.bundledelight.compats.CompatibleMod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class NeapolitanCompat extends CompatibleMod {
    public static final String CLASS = "com.teamabnormals.neapolitan.core.Neapolitan";
    public static final String MODID = "neapolitan";

    @Override
    public String getModid() {
        return MODID;
    }
    
    @Override
    public String getRequiredClass() {
        return CLASS;
    }

    @Override
    protected void onLoad() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        NeapolitanCompatItems.ITEMS.register(bus);
        NeapolitanCompatBlocks.BLOCKS.register(bus);
    }

}
