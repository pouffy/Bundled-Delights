package com.pouffydev.bundledelight.foundation;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.common.elements.block.CompatFlavoredCakeBlock;
import com.pouffydev.bundledelight.common.elements.block.CompatFlavoredCandleCakeBlock;
import com.pouffydev.bundledelight.common.elements.item.BundleBoozeItem;
import com.pouffydev.bundledelight.common.elements.item.BundleDreadNogItem;
import com.pouffydev.bundledelight.datagen.blockstate.CakeGenerator;
import com.pouffydev.bundledelight.datagen.blockstate.CandleCakeGenerator;
import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import java.util.Objects;
import java.util.function.Supplier;

import static com.pouffydev.bundledelight.foundation.util.CommonUtil.getItem;

public class BundledRegistrate extends AbstractRegistrate<BundledRegistrate> {
    protected BundledRegistrate(String modid) {
        super(modid);
    }
    
    public static String autoLang(String id) {
        StringBuilder builder = new StringBuilder();
        boolean b = true;
        for (char c: id.toCharArray()) {
            if(c == '_') {
                builder.append(' ');
                b = true;
            } else {
                builder.append(b ? String.valueOf(c).toUpperCase() : c);
                b = false;
            }
        }
        return builder.toString();
    }
    
    public static boolean isClassFound(String className) {
        try {
            Class.forName(className, false, Thread.currentThread().getContextClassLoader());
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
    
    public static BundledRegistrate create(String modid) {
        return new BundledRegistrate(modid);
    }
    
    public static String removeSlash(String name) {
        return name.contains("/") ? name.split("/")[1] : name;
    }
    
    public static String getBundleName(String name, String modid) {
        return modid + "/" + name;
    }
    
    public static boolean isBuiltIn(String modid) {
        return Objects.equals(modid, "bundledelight");
    }
    
    public static String getBundleContentName(String name, String modid) {
        return isBuiltIn(modid) ? name : getBundleName(name, modid);
    }
    
    @Override
    public BundledRegistrate registerEventListeners(IEventBus bus) {
        return super.registerEventListeners(bus);
    }
    
    public static Item.Properties foodProps(FoodProperties food) {
        return new Item.Properties().food(food).tab(BundledDelight.itemGroup);
    }
    public static Item.Properties glassTankardFoodItemNoEffect() {
        return new Item.Properties().stacksTo(16).tab(BundledDelight.itemGroup);
    }
    public static Item.Properties glassTankardFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).stacksTo(16).tab(BundledDelight.itemGroup);
    }
    //ITEM
    public <T extends Item> ItemEntry<T> item(String name, NonNullFunction<Item.Properties, T> factory, NonNullUnaryOperator<Item.Properties> properties) {
        ItemBuilder<T, ?> builder = this.item(name, factory).properties(properties);
        return builder.register();
    }
    
    public ItemEntry<DrinkableItem> drinkableItem(String name) {
        return item(name, DrinkableItem::new, p->p);
    }
    
    public ItemEntry<ConsumableItem> consumableItem(String name) {
        return item(name, ConsumableItem::new, p->p);
    }
    
    public ItemEntry<DrinkableItem> drinkableItem(String name, NonNullUnaryOperator<Item.Properties> properties) {
        return item(name, DrinkableItem::new, properties);
    }
    
    public ItemEntry<ConsumableItem> consumableItem(String name, NonNullUnaryOperator<Item.Properties> properties) {
        return item(name, ConsumableItem::new, properties);
    }
    
    public ItemEntry<DrinkableItem> drinkableItem(String name, Item.Properties properties) {
        return drinkableItem(name, (p) -> properties);
    }
    
    public ItemEntry<ConsumableItem> consumableItem(String name, Item.Properties properties) {
        return consumableItem(name, (p) -> properties);
    }
    
    public ItemEntry<BundleBoozeItem> boozeItemNoExtraEffect(String name, int potency, int duration, NonNullUnaryOperator<Item.Properties> properties, BundleBoozeItem.Effect effect, int effectDuration, int effectAmplifier, boolean glass) {
        return item(name, (p) -> new BundleBoozeItem(potency, duration, p, effect, effectDuration, effectAmplifier, glass), properties);
    }
    
    public ItemEntry<BundleBoozeItem> boozeItemNoExtraEffect(String name, int potency, int duration, Item.Properties properties, boolean glass) {
        return item(name, (p) -> new BundleBoozeItem(potency, duration, p, BundleBoozeItem.Effect.None, 0, 0, glass), (p) -> properties);
    }
    
    public ItemEntry<BundleBoozeItem> boozeItem(String name, int potency, int duration, NonNullUnaryOperator<Item.Properties> properties, BundleBoozeItem.Effect effect, int effectDuration, int effectAmplifier, boolean glass) {
        return item(name, (p) -> new BundleBoozeItem(potency, duration, p, effect, effectDuration, effectAmplifier, glass), properties);
    }
    
    public ItemEntry<BundleBoozeItem> boozeItem(String name, int potency, int duration, Item.Properties properties, BundleBoozeItem.Effect effect, int effectDuration, int effectAmplifier, boolean glass) {
        return boozeItem(name, potency, duration, (p) -> properties, effect, effectDuration, effectAmplifier, glass);
    }
    
    public ItemEntry<BundleDreadNogItem> dreadNogItem(String name, int potency, int duration, NonNullUnaryOperator<Item.Properties> properties, boolean glass) {
        return item(name, (p) -> new BundleDreadNogItem(potency, duration, p, glass), properties);
    }
    
    public ItemEntry<BundleDreadNogItem> dreadNogItem(String name, int potency, int duration, Item.Properties properties, boolean glass) {
        return dreadNogItem(name, potency, duration, (p) -> properties, glass);
    }
    
    //BLOCK
    public BlockEntry<CompatFlavoredCakeBlock> cake(String name, FoodProperties food, NonNullUnaryOperator<BlockBehaviour.Properties> properties) {
        return block(name, (p) -> new CompatFlavoredCakeBlock(food, p))
                .properties(properties)
                .blockstate((ctx, provider) -> new CakeGenerator().generateCustom(ctx, provider))
                .item()
                .properties(p -> p.stacksTo(1))
                .model((c, p) -> p.singleTexture(c.getName(), new ResourceLocation("item/generated"), "layer0", p.modLoc("item/" + removeSlash(c.getName()))))
                .build()
                .register();
    }
    public BlockEntry<CompatFlavoredCandleCakeBlock> candleCake(String name, Supplier<Block> baseCake, Block candle, NonNullUnaryOperator<BlockBehaviour.Properties> properties) {
        return block(name, (p) -> new CompatFlavoredCandleCakeBlock(baseCake, candle, p))
                .properties(properties)
                .blockstate((ctx, provider) -> new CandleCakeGenerator().generateCustom(ctx, provider, "none"))
                .register();
    }
    public BlockEntry<CompatFlavoredCandleCakeBlock> candleCake(String name, Supplier<Block> baseCake, Block candle, NonNullUnaryOperator<BlockBehaviour.Properties> properties, String color) {
        return block(name, (p) -> new CompatFlavoredCandleCakeBlock(baseCake, candle, p))
                .properties(properties)
                .blockstate((ctx, provider) -> new CandleCakeGenerator().generateCustom(ctx, provider, color))
                .register();
    }
}
