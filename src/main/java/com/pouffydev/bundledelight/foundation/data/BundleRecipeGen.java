package com.pouffydev.bundledelight.foundation.data;

import java.util.function.Consumer;

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
    
    public abstract String getBundleName();
    
    
}
