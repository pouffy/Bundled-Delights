package com.pouffydev.bundledelight.foundation.data;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import vectorwing.farmersdelight.common.crafting.ingredient.ChanceResult;

public abstract class BundleRecipeGen {
    // Cooking Pot Times
    public static final int FAST_COOKING = 100;
    public static final int NORMAL_COOKING = 200;
    public static final int SLOW_COOKING = 400;
    
    // Fermenting Times
    public static final int FERMENTING_TIME = 12000;
    
    // Experience Amounts
    public static final float SMALL_EXP = 0.35F;
    public static final float MEDIUM_EXP = 1.0F;
    public static final float LARGE_EXP = 2.0F;
    
    public static final float SMALL_FERMENT_EXP = 0.35F;
    public static final float MEDIUM_FERMENT_EXP = 0.6F;
    public static final float LARGE_FERMENT_EXP = 1.3F;

    // Create Recipe Types
    public static final ResourceLocation MILLSTONE = new ResourceLocation("create", "milling");
    
    public abstract String getBundleName();

    public static ChanceResult createCuttingResult(ItemLike result, int count, float chance) {
        return new ChanceResult(new ItemStack(result.asItem(), count), chance);
    }
    public static ChanceResult createCuttingResult(ItemLike result, int count) {
        return new ChanceResult(new ItemStack(result.asItem(), count), 1.0F);
    }
}
