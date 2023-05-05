package com.pouffy.bundledelight.compats;

import com.pouffy.bundledelight.compats.brewinandchewin.BrewinMDCompat;
import com.pouffy.bundledelight.compats.farmersrespite.RespiteMDCompat;
import com.pouffy.bundledelight.compats.respiteful.RespitefulMDCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DoubleCompatibleManager {
    public static final List<CompatibleDoubleMod> MODS;
    public static final RespiteMDCompat FRMD;
    public static final BrewinMDCompat BNCMD;
    public static final RespitefulMDCompat RMD;


    static {
        List<CompatibleDoubleMod> mods = new ArrayList<>();
        mods.add(FRMD = new RespiteMDCompat());
        mods.add(BNCMD = new BrewinMDCompat());
        mods.add(RMD = new RespitefulMDCompat());

        for (CompatibleDoubleMod mod : mods) {
            mod.tryLoad();
        }

        MODS = Collections.unmodifiableList(mods);

    }

    public static void visit() {

    }
}
