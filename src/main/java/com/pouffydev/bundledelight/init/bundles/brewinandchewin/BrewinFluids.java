package com.pouffydev.bundledelight.init.bundles.brewinandchewin;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.krystal_core.KrystalCore;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;


public class BrewinFluids {
    public static final DeferredRegister<FluidType> FLUID_TYPES = KrystalCore.getRegistryHelper().createRegister(NeoForgeRegistries.Keys.FLUID_TYPES);
    public static final DeferredRegister<Fluid> FLUIDS = KrystalCore.getRegistryHelper().createRegister(Registries.FLUID);

    public static final DeferredHolder<FluidType, FluidType> ROOT_BEER_TYPE = FLUID_TYPES.register("root_beer", () -> new FluidType(FluidType.Properties.create().sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)));

    public static final BaseFlowingFluid.Properties ROOT_BEER_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(ROOT_BEER_TYPE, BrewinFluids.ROOT_BEER, BrewinFluids.FLOWING_ROOT_BEER);
    public static final DeferredHolder<Fluid, FlowingFluid> ROOT_BEER = FLUIDS.register("root_beer", () -> new BaseFlowingFluid.Source(ROOT_BEER_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_ROOT_BEER = FLUIDS.register("flowing_root_beer", () -> new BaseFlowingFluid.Flowing(ROOT_BEER_FLUID_PROPERTIES));

    public static void register() {
        BundledDelight.LOGGER.info("Registering Brewin Fluids");
    }
}
