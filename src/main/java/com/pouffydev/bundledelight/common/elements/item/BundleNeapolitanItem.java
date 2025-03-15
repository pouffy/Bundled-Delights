package com.pouffydev.bundledelight.common.elements.item;

import com.pouffydev.bundledelight.foundation.lang.Components;
import com.pouffydev.bundledelight.foundation.util.CommonUtil;
import com.pouffydev.bundledelight.foundation.util.client.BDTextUtils;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

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
                // put respiteful tooltips here
            }
            return result;
        }

        public void affectConsumer(Level level, LivingEntity entity) {
            if (this == neapolitan) {
                CommonUtil.addEffect(entity, 200, 0, new ResourceLocation("neapolitan", "vanilla_scent"));
                CommonUtil.addEffect(entity, 400, 1, new ResourceLocation("neapolitan", "sugar_rush"));
                BundleHealingItem.applyHealing(2.0F, level, entity);
            } else {
                // put respiteful effects here
            }
        }
    }
}
