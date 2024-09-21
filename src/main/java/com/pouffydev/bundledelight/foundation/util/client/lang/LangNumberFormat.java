package com.pouffydev.bundledelight.foundation.util.client.lang;

import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;

import java.text.NumberFormat;
import java.util.Locale;

public class LangNumberFormat {
    private NumberFormat format = NumberFormat.getNumberInstance(Locale.ROOT);
    public static LangNumberFormat numberFormat = new LangNumberFormat();
    
    public NumberFormat get() {
        return format;
    }
    
    public void update() {
        format = NumberFormat.getInstance(Minecraft.getInstance()
                .getLanguageManager()
                .getSelected()
                .getJavaLocale());
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(0);
        format.setGroupingUsed(true);
    }
    
    public static String format(double d) {
        if (Mth.equal(d, 0))
            d = 0;
        return numberFormat.get()
                .format(d)
                .replace("\u00A0", " ");
    }
    
}
