package com.pouffydev.bundledelight.compat;

import com.pouffydev.bundledelight.compat.abnormals_delight.AbnormalsNeapolitanCompat;
import com.pouffydev.bundledelight.compat.brewinandchewin.BrewinMDCompat;
import com.pouffydev.bundledelight.compat.farmersrespite.RespiteMDCompat;
import com.pouffydev.bundledelight.compat.neapolitan.NeapolitanMDCompat;
import com.pouffydev.bundledelight.compat.respiteful.RespitefulMDCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DoubleCompatibleManager {
    public static final List<CompatibleDoubleMod> MODS;
    public static final RespiteMDCompat FRMD;
    public static final BrewinMDCompat BNCMD;
    public static final RespitefulMDCompat RMD;
    public static final NeapolitanMDCompat NPMD;
    public static final AbnormalsNeapolitanCompat ABNP;


    static {
        List<CompatibleDoubleMod> mods = new ArrayList<>();
        mods.add(FRMD = new RespiteMDCompat());
        mods.add(BNCMD = new BrewinMDCompat());
        mods.add(RMD = new RespitefulMDCompat());
        mods.add(NPMD = new NeapolitanMDCompat());
        mods.add(ABNP = new AbnormalsNeapolitanCompat());

        for (CompatibleDoubleMod mod : mods) {
            mod.tryLoad();
        }

        MODS = Collections.unmodifiableList(mods);

    }

    public static void visit() {

    }
}
