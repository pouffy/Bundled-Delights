package com.pouffydev.bundledelight.init;

import com.pouffydev.bundledelight.BundledDelights;
import com.pouffydev.bundledelight.compat.item.MissingEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BDEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, BundledDelights.MODID);
    
    public static final RegistryObject<MobEffect> MISSING_EFFECT = EFFECTS.register("missing_effect", MissingEffect::new);
}
