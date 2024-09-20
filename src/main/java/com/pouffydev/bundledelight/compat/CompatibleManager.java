package com.pouffydev.bundledelight.compat;

import com.pouffydev.bundledelight.compat.abnormals_delight.AbnormalsCompat;
import com.pouffydev.bundledelight.compat.brewinandchewin.BrewinCompat;
import com.pouffydev.bundledelight.compat.farmersrespite.RespiteCompat;
import com.pouffydev.bundledelight.compat.farmersrespite.RespiteMDCompatItems;
import com.pouffydev.bundledelight.compat.item.CompatEffectDrink;
import com.pouffydev.bundledelight.compat.miners_delight.MinersCompat;
import com.pouffydev.bundledelight.compat.neapolitan.NeapolitanCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompatibleManager {
    public static final List<CompatibleMod> MODS;

    public static final BrewinCompat BNC;
    public static final RespiteCompat FR;
    public static final MinersCompat MD;
    public static final NeapolitanCompat NP;
    public static final AbnormalsCompat AB;


    static {
        List<CompatibleMod> mods = new ArrayList<>();
        mods.add(BNC = new BrewinCompat());
        mods.add(FR = new RespiteCompat());
        mods.add(MD = new MinersCompat());
        mods.add(NP = new NeapolitanCompat());
        mods.add(AB = new AbnormalsCompat());

        for (CompatibleMod mod : mods) {
            mod.tryLoad();
        }
        List<CompatEffectDrink> drinks = new ArrayList<>();
        drinks.add((CompatEffectDrink) RespiteMDCompatItems.GREEN_TEA_CUP.get());
        drinks.add((CompatEffectDrink) RespiteMDCompatItems.LONG_GREEN_TEA_CUP.get());
        drinks.add((CompatEffectDrink) RespiteMDCompatItems.STRONG_GREEN_TEA_CUP.get());
        drinks.add((CompatEffectDrink) RespiteMDCompatItems.YELLOW_TEA_CUP.get());
        drinks.add((CompatEffectDrink) RespiteMDCompatItems.LONG_YELLOW_TEA_CUP.get());
        drinks.add((CompatEffectDrink) RespiteMDCompatItems.STRONG_YELLOW_TEA_CUP.get());
        drinks.add((CompatEffectDrink) RespiteMDCompatItems.BLACK_TEA_CUP.get());
        drinks.add((CompatEffectDrink) RespiteMDCompatItems.LONG_BLACK_TEA_CUP.get());
        drinks.add((CompatEffectDrink) RespiteMDCompatItems.STRONG_BLACK_TEA_CUP.get());
        for (CompatEffectDrink drink : drinks) {
            drink.findModAndAddProperties();
        }

        MODS = Collections.unmodifiableList(mods);
    }

    public static void visit() {

    }
}
