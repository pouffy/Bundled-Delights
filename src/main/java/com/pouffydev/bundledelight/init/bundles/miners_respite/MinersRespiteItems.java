package com.pouffydev.bundledelight.init.bundles.miners_respite;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.common.elements.item.*;
import com.pouffydev.bundledelight.foundation.BundledRegistrate;
import com.pouffydev.bundledelight.foundation.bundle.BundleRegistryClass;
import com.pouffydev.bundledelight.init.FoodValues;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.resources.ResourceLocation;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public class MinersRespiteItems extends BundleRegistryClass {
    private static final BundledRegistrate registrate = BundledDelight.registrate().creativeModeTab(() -> BundledDelight.itemGroup);
    private static final BundledRegistrate noTabRegistrate = BundledDelight.registrate();

    public MinersRespiteItems() {
        super("miners_respite");
    }

    public static final ItemEntry<BundleTeaItem>
            greenTeaCup = registrate.teaItem(getBundleContentName("green_tea_cup"), FoodValues.GREEN_TEA, p -> p),
            longGreenTeaCup = noTabRegistrate.teaItem(getBundleContentName("long_green_tea_cup"), FoodValues.LONG_GREEN_TEA, p -> p),
            strongGreenTeaCup = noTabRegistrate.teaItem(getBundleContentName("strong_green_tea_cup"), FoodValues.STRONG_GREEN_TEA, p -> p),
            yellowTeaCup = registrate.teaItem(getBundleContentName("yellow_tea_cup"), FoodValues.YELLOW_TEA, p -> p),
            longYellowTeaCup = noTabRegistrate.teaItem(getBundleContentName("long_yellow_tea_cup"), FoodValues.LONG_YELLOW_TEA, p -> p),
            strongYellowTeaCup = noTabRegistrate.teaItem(getBundleContentName("strong_yellow_tea_cup"), FoodValues.STRONG_YELLOW_TEA, p -> p),
            blackTeaCup = registrate.teaItem(getBundleContentName("black_tea_cup"), FoodValues.BLACK_TEA, BundleTeaItem.Effect.Caffeinated, 600, 0, p -> p),
            longBlackTeaCup = noTabRegistrate.teaItem(getBundleContentName("long_black_tea_cup"), FoodValues.LONG_BLACK_TEA, BundleTeaItem.Effect.Caffeinated, 900, 0, p -> p),
            strongBlackTeaCup = noTabRegistrate.teaItem(getBundleContentName("strong_black_tea_cup"), FoodValues.STRONG_BLACK_TEA, BundleTeaItem.Effect.Caffeinated, 300, 1, p -> p),
            coffeeCup = registrate.teaItem(getBundleContentName("coffee_cup"), FoodValues.COFFEE, BundleTeaItem.Effect.Caffeinated, 6000, 1, p -> p),
            longCoffeeCup = noTabRegistrate.teaItem(getBundleContentName("long_coffee_cup"), FoodValues.LONG_COFFEE, BundleTeaItem.Effect.Caffeinated, 12000, 0, p -> p),
            strongCoffeeCup = noTabRegistrate.teaItem(getBundleContentName("strong_coffee_cup"), FoodValues.STRONG_COFFEE, BundleTeaItem.Effect.Caffeinated, 3000, 2, p -> p),
            roseHipTeaCup = registrate.teaItem(getBundleContentName("rose_hip_tea_cup"), FoodValues.ROSE_HIP_TEA, p -> p),
            strongRoseHipTeaCup = noTabRegistrate.teaItem(getBundleContentName("strong_rose_hip_tea_cup"), FoodValues.STRONG_ROSE_HIP_TEA, p -> p),
            dandelionTeaCup = registrate.teaItem(getBundleContentName("dandelion_tea_cup"), FoodValues.DANDELION_TEA, p -> p),
            longDandelionTeaCup = noTabRegistrate.teaItem(getBundleContentName("long_dandelion_tea_cup"), FoodValues.LONG_DANDELION_TEA, p -> p);

    public static final ItemEntry<BundlePurulentTeaItem>
            purulentTeaCup = registrate.purulentTea(getBundleContentName("purulent_tea_cup"), FoodValues.PURULENT_TEA, 600, p -> p),
            longPurulentTeaCup = noTabRegistrate.purulentTea(getBundleContentName("long_purulent_tea_cup"), FoodValues.LONG_PURULENT_TEA, 300, p -> p),
            strongPurulentTeaCup = noTabRegistrate.purulentTea(getBundleContentName("strong_purulent_tea_cup"), FoodValues.PURULENT_TEA, 600, p -> p);

    public static final ItemEntry<BundleDrinkableItem> strongAppleCiderCup = noTabRegistrate.item(getBundleContentName("strong_apple_cider_cup"), (p) -> new BundleDrinkableItem(p).withRemainderItem(BundleConsumableItem.RemainderItem.copperCup))
            .properties(p -> p.food(FoodValues.STRONG_APPLE_CIDER).stacksTo(16))
            .model((c, p) -> p.withExistingParent(c.getName(), new ResourceLocation("bundledelight", "item/mug")).texture("layer0", p.modLoc("item/apple_cider_cup")))
            .lang("Apple Cider Cup")
            .register();

    public static final ItemEntry<BundleDrinkableItem> longAppleCiderCup = noTabRegistrate.item(getBundleContentName("long_apple_cider_cup"), (p) -> new BundleDrinkableItem(p).withRemainderItem(BundleConsumableItem.RemainderItem.copperCup))
            .properties(p -> p.food(FoodValues.LONG_APPLE_CIDER).stacksTo(16))
            .model((c, p) -> p.withExistingParent(c.getName(), new ResourceLocation("bundledelight", "item/mug")).texture("layer0", p.modLoc("item/apple_cider_cup")))
            .lang("Apple Cider Cup")
            .register();

    public static final ItemEntry<BundleHotCocoaItem> strongHotCocoaCup = noTabRegistrate.item(getBundleContentName("strong_hot_cocoa_cup"), BundleHotCocoaItem::new)
            .properties(p -> p.stacksTo(16))
            .model((c, p) -> p.withExistingParent(c.getName(), new ResourceLocation("bundledelight", "item/mug")).texture("layer0", p.modLoc("item/hot_cocoa_cup")))
            .lang("Hot Cocoa Cup")
            .register();

    public static final ItemEntry<BundleMelonJuiceItem> strongMelonJuiceCup = noTabRegistrate.item(getBundleContentName("strong_melon_juice_cup"), (p) -> new BundleMelonJuiceItem(p, 4.0F))
            .properties(p -> p.stacksTo(16))
            .model((c, p) -> p.withExistingParent(c.getName(), new ResourceLocation("bundledelight", "item/mug")).texture("layer0", p.modLoc("item/melon_juice_cup")))
            .lang("Melon Juice Cup")
            .register();

    public static void register() {
        BundledDelight.LOGGER.info("Registering Miner's Respite items");
    }

}
