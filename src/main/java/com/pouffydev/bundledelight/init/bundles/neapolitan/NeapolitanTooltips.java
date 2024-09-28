package com.pouffydev.bundledelight.init.bundles.neapolitan;

import com.google.common.collect.ImmutableMap;
import com.pouffydev.bundledelight.BundleManager;
import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.foundation.lang.Components;
import com.pouffydev.bundledelight.foundation.lang.Lang;
import com.pouffydev.bundledelight.foundation.util.client.BDTextUtils;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringUtil;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;

@Mod.EventBusSubscriber(modid = BundledDelight.MODID, value = Dist.CLIENT)
public class NeapolitanTooltips {

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void addTooltipToNeapolitanFoods(ItemTooltipEvent event) {
        if (Objects.requireNonNull(BundleManager.getBundle("neapolitan")).isLoaded()) {
            Item food = event.getItemStack().getItem();
            List<MutableComponent> effects = new ArrayList<>();
            for (Map.Entry<String, List<MutableComponent>> entry : NEAPOLITAN_EFFECTS.entrySet()) {
                Optional<Item> item = getNeapolitanItem(entry.getKey());
                if (item.isPresent() && item.get() == food) {
                    effects = entry.getValue();
                    break;
                }
            }
            if (effects != null) {
                List<Component> tooltip = event.getToolTip();
                int lastBeforeAdvancedTooltip = tooltip.size() - 1;
                for (MutableComponent effect : effects) {
                    tooltip.add(lastBeforeAdvancedTooltip, effect);
                }
            }
        }
    }

    public static Map<String, List<MutableComponent>> NEAPOLITAN_EFFECTS;
    public static final ResourceLocation sugarRush = new ResourceLocation("neapolitan", "sugar_rush");
    public static final ResourceLocation vanillaScent = new ResourceLocation("neapolitan", "vanilla_scent");
    public static final ResourceLocation agility = new ResourceLocation("neapolitan", "agility");
    public static final ResourceLocation berserking = new ResourceLocation("neapolitan", "berserking");
    public static final ResourceLocation harmony = new ResourceLocation("neapolitan", "harmony");
    public static final ResourceLocation poison = new ResourceLocation("minecraft", "poison");

    public static Optional<Item> getNeapolitanItem(String id) {
        return Optional.ofNullable(ForgeRegistries.ITEMS.getValue(new ResourceLocation("neapolitan", id)));
    }

    //TODO: FSR The potion effect names from Neapolitan don't translate. I have no clue why.
    static {
        if (Objects.requireNonNull(BundleManager.getBundle("neapolitan")).isLoaded()) {
            NEAPOLITAN_EFFECTS = new ImmutableMap.Builder<String, List<MutableComponent>>()
                    .put("chocolate_bar", List.of(BDTextUtils.getFoodEffectTooltip(sugarRush, 400, 1).withStyle(ChatFormatting.BLUE)))
                    .put("chocolate_spider_eye", List.of(BDTextUtils.getFoodEffectTooltip(sugarRush, 800, 0).withStyle(ChatFormatting.BLUE), BDTextUtils.getFoodEffectTooltip(poison, 80, 0).withStyle(ChatFormatting.RED)))
                    .put("chocolate_ice_cream", List.of(BDTextUtils.getFoodEffectTooltip(sugarRush, 600, 2).withStyle(ChatFormatting.BLUE)))
                    .put("chocolate_milkshake", List.of(BDTextUtils.getFoodEffectTooltip(sugarRush, 300, 2).withStyle(ChatFormatting.BLUE)))
                    .put("dried_vanilla_pods", List.of(BDTextUtils.getFoodEffectTooltip(vanillaScent, 200, 0).withStyle(ChatFormatting.BLUE)))
                    .put("vanilla_fudge", List.of(BDTextUtils.getFoodEffectTooltip(vanillaScent, 100, 0).withStyle(ChatFormatting.BLUE)))
                    .put("vanilla_pudding", List.of(BDTextUtils.getFoodEffectTooltip(vanillaScent, 300, 0).withStyle(ChatFormatting.BLUE)))
                    .put("vanilla_ice_cream", List.of(BDTextUtils.getFoodEffectTooltip(vanillaScent, 400, 0).withStyle(ChatFormatting.BLUE)))
                    .put("vanilla_milkshake", List.of(BDTextUtils.getFoodEffectTooltip(vanillaScent, 200, 0).withStyle(ChatFormatting.BLUE)))
                    .put("banana", List.of(BDTextUtils.getFoodEffectTooltip(agility, 300, 0).withStyle(ChatFormatting.BLUE)))
                    .put("banana_bread", List.of(BDTextUtils.getFoodEffectTooltip(agility, 600, 0).withStyle(ChatFormatting.BLUE)))
                    .put("dried_banana", List.of(BDTextUtils.getFoodEffectTooltip(agility, 200, 0).withStyle(ChatFormatting.BLUE)))
                    .put("banana_ice_cream", List.of(BDTextUtils.getFoodEffectTooltip(agility, 1200, 0).withStyle(ChatFormatting.BLUE)))
                    .put("banana_milkshake", List.of(BDTextUtils.getFoodEffectTooltip(agility, 600, 0).withStyle(ChatFormatting.BLUE)))
                    .put("mint_leaves", List.of(BDTextUtils.getFoodEffectTooltip(berserking, 600, 0).withStyle(ChatFormatting.BLUE)))
                    .put("mint_chops", List.of(BDTextUtils.getFoodEffectTooltip(berserking, 900, 0).withStyle(ChatFormatting.BLUE)))
                    .put("cooked_mint_chops", List.of(BDTextUtils.getFoodEffectTooltip(berserking, 1200, 0).withStyle(ChatFormatting.BLUE)))
                    .put("mint_candies", List.of(BDTextUtils.getFoodEffectTooltip(berserking, 2400, 0).withStyle(ChatFormatting.BLUE)))
                    .put("mint_ice_cream", List.of(BDTextUtils.getFoodEffectTooltip(berserking, 1600, 0).withStyle(ChatFormatting.BLUE)))
                    .put("mint_milkshake", List.of(BDTextUtils.getFoodEffectTooltip(berserking, 800, 0).withStyle(ChatFormatting.BLUE)))
                    .put("roasted_adzuki_beans", List.of(BDTextUtils.getFoodEffectTooltip(harmony, 100, 0).withStyle(ChatFormatting.BLUE)))
                    .put("adzuki_bun", List.of(BDTextUtils.getFoodEffectTooltip(harmony, 300, 0).withStyle(ChatFormatting.BLUE)))
                    .put("adzuki_stew", List.of(BDTextUtils.getFoodEffectTooltip(harmony, 400, 0).withStyle(ChatFormatting.BLUE)))
                    .put("adzuki_ice_cream", List.of(BDTextUtils.getFoodEffectTooltip(harmony, 600, 0).withStyle(ChatFormatting.BLUE)))
                    .put("adzuki_milkshake", List.of(BDTextUtils.getFoodEffectTooltip(harmony, 300, 0).withStyle(ChatFormatting.BLUE)))
                    .put("chocolate_strawberries", List.of(BDTextUtils.getFoodEffectTooltip(sugarRush, 200, 1).withStyle(ChatFormatting.BLUE)))
                    .put("vanilla_chocolate_fingers", List.of(BDTextUtils.getFoodEffectTooltip(sugarRush, 200, 0).withStyle(ChatFormatting.BLUE), BDTextUtils.getFoodEffectTooltip(vanillaScent, 100, 0).withStyle(ChatFormatting.BLUE)))
                    .put("strawberry_banana_smoothie", List.of(BDTextUtils.getFoodEffectTooltip(agility, 600, 0).withStyle(ChatFormatting.BLUE)))
                    .put("mint_chocolate", List.of(BDTextUtils.getFoodEffectTooltip(sugarRush, 200, 0).withStyle(ChatFormatting.BLUE), BDTextUtils.getFoodEffectTooltip(berserking, 1200, 0).withStyle(ChatFormatting.BLUE)))
                    .put("strawberry_bean_bonbons", List.of(BDTextUtils.getFoodEffectTooltip(harmony, 100, 0).withStyle(ChatFormatting.BLUE)))
                    .put("adzuki_curry", List.of(BDTextUtils.getFoodEffectTooltip(harmony, 300, 1).withStyle(ChatFormatting.BLUE), BDTextUtils.getFoodEffectTooltip(agility, 300, 1).withStyle(ChatFormatting.BLUE)))
                    .put("neapolitan_ice_cream", List.of(BDTextUtils.getFoodEffectTooltip(sugarRush, 400, 1).withStyle(ChatFormatting.BLUE), BDTextUtils.getFoodEffectTooltip(vanillaScent, 200, 0).withStyle(ChatFormatting.BLUE)))
                    .build();
        } else {
            NEAPOLITAN_EFFECTS = ImmutableMap.of();
        }

        enum Effect {
            None,
            Sugar_Rush,
            Vanilla_Scent,
            Agility,
            Berserking,
            Harmony,
            Poison
            ;

            ResourceLocation getEffect() {
                return switch (this) {
                    case Sugar_Rush -> sugarRush;
                    case Vanilla_Scent -> vanillaScent;
                    case Agility -> agility;
                    case Berserking -> berserking;
                    case Harmony -> harmony;
                    case Poison -> poison;
                    default -> null;
                };
            }

            public MutableComponent getTooltip(int duration, int amplifier) {
                if (getEffect() == null) {
                    return null;
                }
                String romanNumeral = amplifier > 0 ? BDTextUtils.toRomanNumeral(amplifier + 1) + " " : "";
                String translationKey = "effect." + getEffect().getNamespace() + "." + getEffect().getPath();
                MutableComponent formattedName = Components.translatable(translationKey);
                BundledDelight.LOGGER.info("Fetching translation for key: {}, effectName: {}, duration: {}, amplifier: {}", "bundledelight.tooltip.mobeffect", formattedName.getString(), duration, amplifier);
                return BDTextUtils.getTranslation("bundledelight", "tooltip.mobeffect", formattedName.getString(), romanNumeral, StringUtil.formatTickDuration(duration));
            }
        }
    }
}
