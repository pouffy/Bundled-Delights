package com.pouffy.bundledelight.compats.neapolitan;

import com.pouffy.bundledelight.compats.CompatibleMod;
import com.pouffy.bundledelight.compats.farmersrespite.RespiteMDItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class NeapolitanCompat extends CompatibleMod {
    public static final String MODID = "neapolitan";

    @Override
    public String getModID() {
        return MODID;
    }

    @Override
    protected void onLoad() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        NeapolitanCompatItems.ITEMS.register(bus);
    }

}
