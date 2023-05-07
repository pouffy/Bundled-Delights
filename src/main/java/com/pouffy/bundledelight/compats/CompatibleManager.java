package com.pouffy.bundledelight.compats;

import com.pouffy.bundledelight.compats.abnormals_delight.AbnormalsCompat;
import com.pouffy.bundledelight.compats.brewinandchewin.BrewinCompat;
import com.pouffy.bundledelight.compats.farmersrespite.RespiteCompat;
import com.pouffy.bundledelight.compats.miners_delight.MinersCompat;
import com.pouffy.bundledelight.compats.neapolitan.NeapolitanCompat;

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

        MODS = Collections.unmodifiableList(mods);
    }

    public static void visit() {

    }
}
