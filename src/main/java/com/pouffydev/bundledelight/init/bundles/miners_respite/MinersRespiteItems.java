package com.pouffydev.bundledelight.init.bundles.miners_respite;

import com.pouffydev.bundledelight.BundleDelightCreativeTab;
import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.common.elements.item.*;
import com.pouffydev.bundledelight.foundation.BundledRegistrate;
import com.pouffydev.bundledelight.foundation.bundle.BundleRegistryClass;
import com.pouffydev.bundledelight.init.FoodValues;
import com.sammy.minersdelight.setup.MDItems;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.resources.ResourceLocation;
import umpaz.farmersrespite.common.FRFoodValues;

public class MinersRespiteItems extends BundleRegistryClass {
    private static final BundledRegistrate registrate = BundledDelight.registrate().setCreativeTab(BundleDelightCreativeTab.MAIN_TAB);
    private static final BundledRegistrate noTabRegistrate = BundledDelight.registrate();

    public MinersRespiteItems() {
        super("miners_respite");
    }

    public static final ItemEntry<BundleTeaItem>
            greenTeaCup = registrate.teaItem(getBundleContentName("green_tea_cup"), FRFoodValues.GREEN_TEA, p -> p.craftRemainder(MDItems.COPPER_CUP.asItem())),
            longGreenTeaCup = noTabRegistrate.teaItem(getBundleContentName("long_green_tea_cup"), FRFoodValues.LONG_GREEN_TEA, p -> p.craftRemainder(MDItems.COPPER_CUP.asItem())),
            strongGreenTeaCup = noTabRegistrate.teaItem(getBundleContentName("strong_green_tea_cup"), FRFoodValues.STRONG_GREEN_TEA, p -> p.craftRemainder(MDItems.COPPER_CUP.asItem())),
            yellowTeaCup = registrate.teaItem(getBundleContentName("yellow_tea_cup"), FRFoodValues.YELLOW_TEA, p -> p.craftRemainder(MDItems.COPPER_CUP.asItem())),
            longYellowTeaCup = noTabRegistrate.teaItem(getBundleContentName("long_yellow_tea_cup"), FRFoodValues.LONG_YELLOW_TEA, p -> p.craftRemainder(MDItems.COPPER_CUP.asItem())),
            strongYellowTeaCup = noTabRegistrate.teaItem(getBundleContentName("strong_yellow_tea_cup"), FRFoodValues.STRONG_YELLOW_TEA, p -> p.craftRemainder(MDItems.COPPER_CUP.asItem())),
            blackTeaCup = registrate.teaItem(getBundleContentName("black_tea_cup"), FRFoodValues.BLACK_TEA, p -> p.craftRemainder(MDItems.COPPER_CUP.asItem())),
            longBlackTeaCup = noTabRegistrate.teaItem(getBundleContentName("long_black_tea_cup"), FRFoodValues.LONG_BLACK_TEA, p -> p.craftRemainder(MDItems.COPPER_CUP.asItem())),
            strongBlackTeaCup = noTabRegistrate.teaItem(getBundleContentName("strong_black_tea_cup"), FRFoodValues.STRONG_BLACK_TEA, p -> p.craftRemainder(MDItems.COPPER_CUP.asItem())),
            coffeeCup = registrate.teaItem(getBundleContentName("coffee_cup"), FRFoodValues.COFFEE, p -> p.craftRemainder(MDItems.COPPER_CUP.asItem())),
            longCoffeeCup = noTabRegistrate.teaItem(getBundleContentName("long_coffee_cup"), FRFoodValues.LONG_COFFEE, p -> p.craftRemainder(MDItems.COPPER_CUP.asItem())),
            strongCoffeeCup = noTabRegistrate.teaItem(getBundleContentName("strong_coffee_cup"), FRFoodValues.STRONG_COFFEE, p -> p.craftRemainder(MDItems.COPPER_CUP.asItem())),
            roseHipTeaCup = registrate.teaItem(getBundleContentName("rose_hip_tea_cup"), FRFoodValues.ROSE_HIP_TEA, p -> p.craftRemainder(MDItems.COPPER_CUP.asItem())),
            strongRoseHipTeaCup = noTabRegistrate.teaItem(getBundleContentName("strong_rose_hip_tea_cup"), FRFoodValues.STRONG_ROSE_HIP_TEA, p -> p.craftRemainder(MDItems.COPPER_CUP.asItem())),
            dandelionTeaCup = registrate.teaItem(getBundleContentName("dandelion_tea_cup"), FRFoodValues.DANDELION_TEA, p -> p.craftRemainder(MDItems.COPPER_CUP.asItem())),
            longDandelionTeaCup = noTabRegistrate.teaItem(getBundleContentName("long_dandelion_tea_cup"), FRFoodValues.LONG_DANDELION_TEA, p -> p.craftRemainder(MDItems.COPPER_CUP.asItem()));

    public static final ItemEntry<BundlePurulentTeaItem>
            purulentTeaCup = registrate.purulentTea(getBundleContentName("purulent_tea_cup"), FRFoodValues.PURULENT_TEA, 600, p -> p.craftRemainder(MDItems.COPPER_CUP.asItem())),
            longPurulentTeaCup = noTabRegistrate.purulentTea(getBundleContentName("long_purulent_tea_cup"), FRFoodValues.LONG_PURULENT_TEA, 300, p -> p.craftRemainder(MDItems.COPPER_CUP.asItem())),
            strongPurulentTeaCup = noTabRegistrate.purulentTea(getBundleContentName("strong_purulent_tea_cup"), FRFoodValues.PURULENT_TEA, 600, p -> p.craftRemainder(MDItems.COPPER_CUP.asItem()));

    public static final ItemEntry<BundleGamblersTeaItem>
            gamblersTeaCup = registrate.gamblersTea(getBundleContentName("gamblers_tea_cup"), p -> p.craftRemainder(MDItems.COPPER_CUP.asItem())),
            longGamblersTeaCup = noTabRegistrate.gamblersTea(getBundleContentName("long_gamblers_tea_cup"), 300, 0, p -> p.craftRemainder(MDItems.COPPER_CUP.asItem())),
            strongGamblersTeaCup = noTabRegistrate.gamblersTea(getBundleContentName("strong_gamblers_tea_cup"), 200, 1, p -> p.craftRemainder(MDItems.COPPER_CUP.asItem()));

    public static final ItemEntry<BundleDrinkableItem> strongAppleCiderCup = noTabRegistrate.item(getBundleContentName("strong_apple_cider_cup"), (p) -> new BundleDrinkableItem(p).withRemainderItem(BundleConsumableItem.RemainderItem.copperCup))
            .properties(p -> p.food(FRFoodValues.STRONG_APPLE_CIDER).stacksTo(16).craftRemainder(MDItems.COPPER_CUP.asItem()))
            .model((c, p) -> p.withExistingParent(c.getName(), new ResourceLocation("bundledelight", "item/mug")).texture("layer0", p.modLoc("item/apple_cider_cup")))
            .lang("Apple Cider Cup")
            .register();

    public static final ItemEntry<BundleDrinkableItem> longAppleCiderCup = noTabRegistrate.item(getBundleContentName("long_apple_cider_cup"), (p) -> new BundleDrinkableItem(p).withRemainderItem(BundleConsumableItem.RemainderItem.copperCup))
            .properties(p -> p.food(FRFoodValues.LONG_APPLE_CIDER).stacksTo(16).craftRemainder(MDItems.COPPER_CUP.asItem()))
            .model((c, p) -> p.withExistingParent(c.getName(), new ResourceLocation("bundledelight", "item/mug")).texture("layer0", p.modLoc("item/apple_cider_cup")))
            .lang("Apple Cider Cup")
            .register();

    public static final ItemEntry<BundleHotCocoaItem> strongHotCocoaCup = noTabRegistrate.item(getBundleContentName("strong_hot_cocoa_cup"), BundleHotCocoaItem::new)
            .properties(p -> p.stacksTo(16).craftRemainder(MDItems.COPPER_CUP.asItem()))
            .model((c, p) -> p.withExistingParent(c.getName(), new ResourceLocation("bundledelight", "item/mug")).texture("layer0", p.modLoc("item/hot_cocoa_cup")))
            .lang("Hot Cocoa Cup")
            .register();

    public static final ItemEntry<BundleMelonJuiceItem> strongMelonJuiceCup = noTabRegistrate.item(getBundleContentName("strong_melon_juice_cup"), (p) -> new BundleMelonJuiceItem(p, 4.0F))
            .properties(p -> p.stacksTo(16).craftRemainder(MDItems.COPPER_CUP.asItem()))
            .model((c, p) -> p.withExistingParent(c.getName(), new ResourceLocation("bundledelight", "item/mug")).texture("layer0", p.modLoc("item/melon_juice_cup")))
            .lang("Melon Juice Cup")
            .register();

    public static void register() {
        BundledDelight.LOGGER.info("Registering Miner's Respite items");
    }

}
