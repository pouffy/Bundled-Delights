package com.pouffy.bundledelight.compat;

import com.pouffy.bundledelight.compat.abnormals_delight.AbnormalsCompat;
import com.pouffy.bundledelight.compat.brewinandchewin.BrewinCompat;
import com.pouffy.bundledelight.compat.farmersrespite.RespiteCompat;
import com.pouffy.bundledelight.compat.farmersrespite.RespiteMDCompatItems;
import com.pouffy.bundledelight.compat.item.CompatEffectDrink;
import com.pouffy.bundledelight.compat.miners_delight.MinersCompat;
import com.pouffy.bundledelight.compat.neapolitan.NeapolitanCompat;
import com.pouffy.bundledelight.init.BDItems;

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
