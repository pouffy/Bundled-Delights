package com.pouffy.bundledelight.compats;

import com.pouffy.bundledelight.compats.brewinandchewin.BrewinCompat;
import com.pouffy.bundledelight.compats.brewinandchewin.BrewinMDCompat;
import com.pouffy.bundledelight.compats.farmersrespite.RespiteCompat;
import com.pouffy.bundledelight.compats.farmersrespite.RespiteMDCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DoubleCompatibleManager {
    public static final List<CompatibleDoubleMod> MODS;
    public static final RespiteMDCompat FRMD;
    public static final BrewinMDCompat BNCMD;


    static {
        List<CompatibleDoubleMod> mods = new ArrayList<>();
        mods.add(FRMD = new RespiteMDCompat());
        mods.add(BNCMD = new BrewinMDCompat());

        for (CompatibleDoubleMod mod : mods) {
            mod.tryLoad();
        }

        MODS = Collections.unmodifiableList(mods);

    }

    public static void visit() {

    }
}
