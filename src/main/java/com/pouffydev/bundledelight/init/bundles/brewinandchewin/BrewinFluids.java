package com.pouffydev.bundledelight.init.bundles.brewinandchewin;

import com.pouffydev.bundledelight.BundledDelight;
import com.tterrag.registrate.util.entry.FluidEntry;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import static com.pouffydev.bundledelight.BundledDelight.registrate;

public class BrewinFluids {

    public static FluidEntry<ForgeFlowingFluid.Flowing>
            rootBeer = registrate.alcohol("root_beer", 0x4b422d).noBucket().register()
            ;

    public static void register() {
        BundledDelight.LOGGER.info("Registering Brewin Fluids");
    }
}
