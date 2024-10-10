package com.pouffydev.bundledelight.init.bundles.neapolitan;

import com.google.common.collect.ImmutableMap;
import com.pouffydev.bundledelight.BundleManager;
import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.foundation.lang.Components;
import com.pouffydev.bundledelight.foundation.util.client.BDTextUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringUtil;
import net.minecraft.world.food.FoodProperties;
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
                    FoodProperties foodProperties = item.get().getFoodProperties();
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
                    .put("chocolate_bar", List.of(Effect.Sugar_Rush.getTooltip(400, 1)))
                    .put("chocolate_spider_eye", List.of(Effect.Sugar_Rush.getTooltip(800, 0), Effect.Poison.getTooltip(80, 0)))
                    .put("chocolate_ice_cream", List.of(Effect.Sugar_Rush.getTooltip(600, 2)))
                    .put("chocolate_milkshake", List.of(Effect.Sugar_Rush.getTooltip(300, 2)))
                    .put("dried_vanilla_pods", List.of(Effect.Vanilla_Scent.getTooltip(200, 0)))
                    .put("vanilla_fudge", List.of(Effect.Vanilla_Scent.getTooltip(100, 0)))
                    .put("vanilla_pudding", List.of(Effect.Vanilla_Scent.getTooltip(300, 0)))
                    .put("vanilla_ice_cream", List.of(Effect.Vanilla_Scent.getTooltip(400, 0)))
                    .put("vanilla_milkshake", List.of(Effect.Vanilla_Scent.getTooltip(200, 0)))
                    .put("banana", List.of(Effect.Agility.getTooltip(300, 0)))
                    .put("banana_bread", List.of(Effect.Agility.getTooltip(600, 0)))
                    .put("dried_banana", List.of(Effect.Agility.getTooltip(200, 0)))
                    .put("banana_ice_cream", List.of(Effect.Agility.getTooltip(1200, 0)))
                    .put("banana_milkshake", List.of(Effect.Agility.getTooltip(600, 0)))
                    .put("mint_leaves", List.of(Effect.Berserking.getTooltip(600, 0)))
                    .put("mint_chops", List.of(Effect.Berserking.getTooltip(900, 0)))
                    .put("cooked_mint_chops", List.of(Effect.Berserking.getTooltip(1200, 0)))
                    .put("mint_candies", List.of(Effect.Berserking.getTooltip(2400, 0)))
                    .put("mint_ice_cream", List.of(Effect.Berserking.getTooltip(1600, 0)))
                    .put("mint_milkshake", List.of(Effect.Berserking.getTooltip(800, 0)))
                    .put("roasted_adzuki_beans", List.of(Effect.Harmony.getTooltip(100, 0)))
                    .put("adzuki_bun", List.of(Effect.Harmony.getTooltip(300, 0)))
                    .put("adzuki_stew", List.of(Effect.Harmony.getTooltip(400, 0)))
                    .put("adzuki_ice_cream", List.of(Effect.Harmony.getTooltip(600, 0)))
                    .put("adzuki_milkshake", List.of(Effect.Harmony.getTooltip(300, 0)))
                    .put("chocolate_strawberries", List.of(Effect.Sugar_Rush.getTooltip(200, 1), BDTextUtils.InstantHealth.getFromFloat(1.0F).getTooltip()))
                    .put("vanilla_chocolate_fingers", List.of(Effect.Sugar_Rush.getTooltip(200, 0), Effect.Vanilla_Scent.getTooltip(100, 0)))
                    .put("strawberry_banana_smoothie", List.of(Effect.Agility.getTooltip(600, 0), BDTextUtils.InstantHealth.getFromFloat(2.0F).getTooltip()))
                    .put("mint_chocolate", List.of(Effect.Sugar_Rush.getTooltip(200, 0), Effect.Berserking.getTooltip(1200, 0)))
                    .put("strawberry_bean_bonbons", List.of(Effect.Harmony.getTooltip(100, 0), BDTextUtils.InstantHealth.getFromFloat(2.0F).getTooltip()))
                    .put("adzuki_curry", List.of(Effect.Harmony.getTooltip(300, 1), Effect.Agility.getTooltip(300, 1)))
                    .put("neapolitan_ice_cream", List.of(Effect.Sugar_Rush.getTooltip(400, 1), Effect.Vanilla_Scent.getTooltip(200, 0), BDTextUtils.InstantHealth.getFromFloat(2.0F).getTooltip()))

                    .put("strawberries", List.of(BDTextUtils.InstantHealth.getFromFloat(2.0F).getTooltip()))
                    .put("white_strawberries", List.of(BDTextUtils.InstantHealth.getFromFloat(4.0F).getTooltip()))
                    .put("strawberry_scones", List.of(BDTextUtils.InstantHealth.getFromFloat(1.0F).getTooltip()))
                    .put("strawberry_ice_cream", List.of(BDTextUtils.InstantHealth.getFromFloat(3.0F).getTooltip()))
                    .put("strawberry_milkshake", List.of(BDTextUtils.InstantHealth.getFromFloat(3.0F).getTooltip()))
                    .build();
        } else {
            NEAPOLITAN_EFFECTS = ImmutableMap.of();
        }


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
                return Components.empty();
            }
            String romanNumeral = amplifier > 0 ? BDTextUtils.toRomanNumeral(amplifier + 1) + " " : "";
            MutableComponent result = BDTextUtils.getTranslation("bundledelight", "tooltip." + getEffect().getPath(), romanNumeral, StringUtil.formatTickDuration(duration));
            if (this == Poison) {
                MutableComponent formattedName = Component.translatable("effect.minecraft.poison");
                result = BDTextUtils.getTranslation("bundledelight", "tooltip.mobeffect", formattedName.getString(), romanNumeral, StringUtil.formatTickDuration(duration)).withStyle(ChatFormatting.RED);
            } else {
                result = result.withStyle(ChatFormatting.BLUE);
            }
            return result;
        }
    }

    enum InstantHealth {
        Tiny,
        Minor,
        Medium,
        Large
        ;

        public MutableComponent getTooltip() {
            return BDTextUtils.getTranslation("bundledelight", "tooltip.instant_health." + this.name().toLowerCase()).withStyle(ChatFormatting.BLUE);
        }
    }
}
