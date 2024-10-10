package com.pouffydev.bundledelight.common.elements.item;

import com.pouffydev.bundledelight.foundation.lang.Components;
import com.pouffydev.bundledelight.foundation.util.client.BDTextUtils;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class BundleNeapolitanItem extends BundleConsumableItem {
    private Type type = Type.neapolitan;

    public BundleNeapolitanItem(Properties properties) {
        super(properties);
    }


    enum Type {
        neapolitan,
        respiteful
        ;

        public List<MutableComponent> getTooltip() {
            List<MutableComponent> result = new ArrayList<>(List.of(Components.empty()));
            if (this == neapolitan) {
                MutableComponent textHeal = BDTextUtils.InstantHealth.getFromFloat(2.0F).getTooltip();
                String vcAmp = "";
                MutableComponent vcTooltip = BDTextUtils.getTranslation("bundledelight", "tooltip.vanilla_scent", vcAmp, StringUtil.formatTickDuration(200));
                String srAmp = BDTextUtils.toRomanNumeral(2) + " ";
                MutableComponent srTooltip = BDTextUtils.getTranslation("bundledelight", "tooltip.sugar_rush", srAmp, StringUtil.formatTickDuration(400));
                result.add(textHeal);
                result.add(vcTooltip);
                result.add(srTooltip);
            } else {

            }
            return result;
        }
    }
}
