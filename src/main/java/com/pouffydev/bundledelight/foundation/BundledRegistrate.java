package com.pouffydev.bundledelight.foundation;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.common.elements.block.CompatFlavoredCakeBlock;
import com.pouffydev.bundledelight.common.elements.block.CompatFlavoredCandleCakeBlock;
import com.pouffydev.bundledelight.common.elements.item.*;
import com.pouffydev.bundledelight.datagen.blockstate.CakeGenerator;
import com.pouffydev.bundledelight.datagen.blockstate.CandleCakeGenerator;
import com.pouffydev.bundledelight.datagen.blockstate.SackGenerator;
import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.builders.Builder;
import com.tterrag.registrate.builders.FluidBuilder;
import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.RegistryObject;
import umpaz.brewinandchewin.common.fluid.AlcoholFluidType;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class BundledRegistrate extends AbstractRegistrate<BundledRegistrate> {
    private static final Map<RegistryEntry<?>, RegistryObject<CreativeModeTab>> TAB_LOOKUP = Collections.synchronizedMap(new IdentityHashMap<>());
    @Nullable
    protected RegistryObject<CreativeModeTab> currentTab;

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
        return new Item.Properties().food(food);
    }
    public static Item.Properties tankardFoodItemNoEffect() {
        return new Item.Properties().stacksTo(16);
    }
    public static Item.Properties tankardFoodItem(FoodProperties food) {
        return new Item.Properties().stacksTo(16);
    }
    //ITEM
    public <T extends Item> ItemEntry<T> item(String name, NonNullFunction<Item.Properties, T> factory, NonNullUnaryOperator<Item.Properties> properties) {
        ItemBuilder<T, ?> builder = this.item(name, factory).properties(properties);
        return builder.register();
    }

    public ItemEntry<BundleMilkshakeItem> milkshakeItem(String name, FoodProperties food, NonNullUnaryOperator<Item.Properties> properties) {
        return item(name, (p) -> new BundleMilkshakeItem(p.food(food).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)), properties);
    }

    public ItemEntry<BundleMilkshakeItem> milkshakeItem(String name, FoodProperties food, Item.Properties properties) {
        return milkshakeItem(name, food, (p) -> properties);
    }

    public ItemEntry<BundleMilkshakeItem> milkshakeItem(String name, FoodProperties food, float healAmount, NonNullUnaryOperator<Item.Properties> properties) {
        return item(name, (p) -> new BundleMilkshakeItem(p.food(food).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)).withHealAmount(healAmount), properties);
    }

    public ItemEntry<BundleMilkshakeItem> milkshakeItem(String name, FoodProperties food, float healAmount, Item.Properties properties) {
        return milkshakeItem(name, food, healAmount, (p) -> properties);
    }

    public ItemEntry<BundleIceCreamItem> iceCreamItem(String name, FoodProperties food, NonNullUnaryOperator<Item.Properties> properties, BundleConsumableItem.RemainderItem remainder) {
        return item(name, (p) -> new BundleIceCreamItem(p.food(food).stacksTo(1), remainder), properties);
    }

    public ItemEntry<BundleIceCreamItem> iceCreamItem(String name, FoodProperties food, Item.Properties properties, BundleConsumableItem.RemainderItem remainder) {
        return iceCreamItem(name, food, (p) -> properties, remainder);
    }

    public ItemEntry<BundleIceCreamItem> iceCreamItem(String name, FoodProperties food, float healAmount, NonNullUnaryOperator<Item.Properties> properties, BundleConsumableItem.RemainderItem remainder) {
        return item(name, (p) -> new BundleIceCreamItem(p.food(food).stacksTo(1), remainder).withHealAmount(healAmount), properties);
    }

    public ItemEntry<BundleIceCreamItem> iceCreamItem(String name, FoodProperties food, float healAmount, Item.Properties properties, BundleConsumableItem.RemainderItem remainder) {
        return iceCreamItem(name, food, healAmount, (p) -> properties, remainder);
    }

    public ItemEntry<BundleIceCreamItem> iceCreamItem(String name, FoodProperties food, BundleIceCreamItem.Effect effect, int duration, int amplifier, NonNullUnaryOperator<Item.Properties> properties, BundleConsumableItem.RemainderItem remainder) {
        return item(name, (p) -> new BundleIceCreamItem(p.food(food).stacksTo(1), remainder).withEffect(effect, duration, amplifier), properties);
    }

    public ItemEntry<BundleIceCreamItem> iceCreamItem(String name, FoodProperties food, BundleIceCreamItem.Effect effect, int duration, int amplifier, Item.Properties properties, BundleConsumableItem.RemainderItem remainder) {
        return iceCreamItem(name, food, effect, duration, amplifier, (p) -> properties, remainder);
    }

    public ItemEntry<BundleIceCreamItem> iceCreamItem(String name, FoodProperties food, float healAmount, BundleIceCreamItem.Effect effect, int duration, int amplifier, NonNullUnaryOperator<Item.Properties> properties, BundleConsumableItem.RemainderItem remainder) {
        return item(name, (p) -> new BundleIceCreamItem(p.food(food).stacksTo(1), remainder).withHealAmount(healAmount).withEffect(effect, duration, amplifier), properties);
    }

    public ItemEntry<BundleIceCreamItem> iceCreamItem(String name, FoodProperties food, float healAmount, BundleIceCreamItem.Effect effect, int duration, int amplifier, Item.Properties properties, BundleConsumableItem.RemainderItem remainder) {
        return iceCreamItem(name, food, healAmount, effect, duration, amplifier, (p) -> properties, remainder);
    }

    public ItemEntry<BundleHealingDrinkItem> healingDrinkItem(String name, float healAmount, NonNullUnaryOperator<Item.Properties> properties) {
        return item(name, (p) -> new BundleHealingDrinkItem(healAmount, p), properties);
    }

    public ItemEntry<BundleHealingDrinkItem> healingDrinkItem(String name, float healAmount, Item.Properties properties) {
        return healingDrinkItem(name, healAmount, (p) -> properties);
    }

    public ItemEntry<BundleHealingItem> healingItem(String name, float healAmount, NonNullUnaryOperator<Item.Properties> properties) {
        return item(name, (p) -> new BundleHealingItem(healAmount, p), properties);
    }

    public ItemEntry<BundleHealingItem> healingItem(String name, float healAmount, Item.Properties properties) {
        return healingItem(name, healAmount, (p) -> properties);
    }

    public ItemEntry<BundleCakeSliceItem> cakeSliceItem(String name, FoodProperties food, NonNullUnaryOperator<Item.Properties> properties) {
        return item(name, (p) -> new BundleCakeSliceItem(p.food(food)), properties);
    }

    public ItemEntry<BundleCakeSliceItem> cakeSliceItem(String name, FoodProperties food, Item.Properties properties) {
        return cakeSliceItem(name, food, (p) -> properties);
    }

    public ItemEntry<BundleCakeSliceItem> cakeSliceItem(String name, float healAmount, FoodProperties food, NonNullUnaryOperator<Item.Properties> properties) {
        return item(name, (p) -> new BundleCakeSliceItem(p.food(food)).withHealAmount(healAmount), properties);
    }

    public ItemEntry<BundleCakeSliceItem> cakeSliceItem(String name, float healAmount, FoodProperties food, Item.Properties properties) {
        return cakeSliceItem(name, healAmount, food, (p) -> properties);
    }
    
    public ItemEntry<BundleDrinkableItem> drinkableItem(String name) {
        return item(name, BundleDrinkableItem::new, p->p);
    }
    
    public ItemEntry<ConsumableItem> consumableItem(String name) {
        return item(name, ConsumableItem::new, p->p);
    }
    
    public ItemEntry<BundleDrinkableItem> drinkableItem(String name, NonNullUnaryOperator<Item.Properties> properties) {
        return item(name, BundleDrinkableItem::new, properties);
    }
    
    public ItemEntry<ConsumableItem> consumableItem(String name, NonNullUnaryOperator<Item.Properties> properties) {
        return item(name, (p) -> new ConsumableItem(p, true), properties);
    }
    
    public ItemEntry<BundleDrinkableItem> drinkableItem(String name, Item.Properties properties) {
        return drinkableItem(name, (p) -> properties);
    }
    
    public ItemEntry<ConsumableItem> consumableItem(String name, Item.Properties properties) {
        return consumableItem(name, (p) -> properties);
    }
    
    public ItemEntry<BundleBoozeItem> boozeItemNoExtraEffect(String name, int potency, int duration, NonNullUnaryOperator<Item.Properties> properties, BundleBoozeItem.Effect effect, int effectDuration, int effectAmplifier, int intoxicationDuration, BundleConsumableItem.RemainderItem remainder) {
        return item(name, (p) -> new BundleBoozeItem(potency, duration, p, effect, effectDuration, effectAmplifier, intoxicationDuration, remainder))
                .properties(properties)
                .model((c, p) -> p.withExistingParent(c.getName(), new ResourceLocation("bundledelight", "item/mug")).texture("layer0", p.modLoc("item/" + c.getName())))
                .register();
    }
    
    public ItemEntry<BundleBoozeItem> boozeItemNoExtraEffect(String name, int potency, int duration, int intoxicationDuration, Item.Properties properties, BundleConsumableItem.RemainderItem remainder) {
        return item(name, (p) -> new BundleBoozeItem(potency, duration, p, BundleBoozeItem.Effect.None, 0, 0, intoxicationDuration, remainder), (p) -> properties);
    }
    
    public ItemEntry<BundleBoozeItem> boozeItem(String name, int potency, int duration, NonNullUnaryOperator<Item.Properties> properties, BundleBoozeItem.Effect effect, int effectDuration, int effectAmplifier, int intoxicationDuration, BundleConsumableItem.RemainderItem remainder) {
        return item(name, (p) -> new BundleBoozeItem(potency, duration, p, effect, effectDuration, effectAmplifier, intoxicationDuration, remainder))
                .properties(properties)
                .model((c, p) -> p.withExistingParent(c.getName(), new ResourceLocation("bundledelight", "item/mug")).texture("layer0", p.modLoc("item/" + c.getName())))
                .register();
    }
    
    public ItemEntry<BundleBoozeItem> boozeItem(String name, int potency, int duration, Item.Properties properties, BundleBoozeItem.Effect effect, int effectDuration, int effectAmplifier, int intoxicationDuration, BundleConsumableItem.RemainderItem remainder) {
        return boozeItem(name, potency, duration, (p) -> properties, effect, effectDuration, effectAmplifier, intoxicationDuration, remainder);
    }
    
    public ItemEntry<BundleDreadNogItem> dreadNogItem(String name, int potency, int duration, NonNullUnaryOperator<Item.Properties> properties, BundleConsumableItem.RemainderItem remainder) {
        return item(name, (p) -> new BundleDreadNogItem(potency, duration, p, remainder))
                .properties(properties)
                .model((c, p) -> p.withExistingParent(c.getName(), new ResourceLocation("bundledelight", "item/mug")).texture("layer0", p.modLoc("item/" + c.getName())))
                .register();
    }
    
    public ItemEntry<BundleDreadNogItem> dreadNogItem(String name, int potency, int duration, Item.Properties properties, BundleConsumableItem.RemainderItem remainder) {
        return dreadNogItem(name, potency, duration, (p) -> properties, remainder);
    }

    public ItemEntry<BundleTeaItem> teaItem(String name, FoodProperties food, NonNullUnaryOperator<Item.Properties> properties) {
        return item(name, (p) -> new BundleTeaItem(p.food(food), true))
                .properties((p) -> p.stacksTo(16))
                .model((c, p) -> p.withExistingParent(c.getName(), new ResourceLocation("bundledelight", "item/mug")).texture("layer0", p.modLoc("item/" + c.getName().replace("strong_", "").replace("long_", ""))))
                .lang(autoLang(name).replace("Strong ", "").replace("Long ", ""))
                .register();
    }

    public ItemEntry<BundleTeaItem> teaItem(String name, FoodProperties food, Item.Properties properties) {
        return teaItem(name, food, (p) -> properties);
    }

    public ItemEntry<BundleTeaItem> teaItem(String name, FoodProperties food, BundleTeaItem.Effect effect, int duration, int amplifier, NonNullUnaryOperator<Item.Properties> properties) {
        return item(name, (p) -> new BundleTeaItem(p.food(food), effect, duration, amplifier, true))
                .properties((p) -> p.stacksTo(16))
                .model((c, p) -> p.withExistingParent(c.getName(), new ResourceLocation("bundledelight", "item/mug")).texture("layer0", p.modLoc("item/" + c.getName().replace("strong_", "").replace("long_", ""))))
                .lang(autoLang(name).replace("Strong ", "").replace("Long ", ""))
                .register();
    }

    public ItemEntry<BundleTeaItem> teaItem(String name, FoodProperties food, BundleTeaItem.Effect effect, int duration, int amplifier, Item.Properties properties) {
        return teaItem(name, food, effect, duration, amplifier, (p) -> properties);
    }

    public ItemEntry<BundlePurulentTeaItem> purulentTea(String name, FoodProperties food, int effectBoost, BundleTeaItem.Effect effect, int duration, int amplifier, NonNullUnaryOperator<Item.Properties> properties) {
        return item(name, (p) -> new BundlePurulentTeaItem(p.food(food), effect, duration, amplifier, effectBoost, true))
                .properties((p) -> p.stacksTo(16))
                .model((c, p) -> p.withExistingParent(c.getName(), new ResourceLocation("bundledelight", "item/mug")).texture("layer0", p.modLoc("item/" + c.getName().replace("strong_", "").replace("long_", ""))))
                .lang("Purulent Tea Cup")
                .register();
    }

    public ItemEntry<BundlePurulentTeaItem> purulentTea(String name, FoodProperties food, int effectBoost, BundleTeaItem.Effect effect, int duration, int amplifier, Item.Properties properties) {
        return purulentTea(name, food, effectBoost, effect, duration, amplifier, (p) -> properties);
    }

    public ItemEntry<BundlePurulentTeaItem> purulentTea(String name, FoodProperties food, int effectBoost, NonNullUnaryOperator<Item.Properties> properties) {
        return item(name, (p) -> new BundlePurulentTeaItem(p.food(food), effectBoost, true))
                .properties((p) -> p.stacksTo(16))
                .model((c, p) -> p.withExistingParent(c.getName(), new ResourceLocation("bundledelight", "item/mug")).texture("layer0", p.modLoc("item/" + c.getName().replace("strong_", "").replace("long_", ""))))
                .lang("Purulent Tea Cup")
                .register();
    }

    public ItemEntry<BundlePurulentTeaItem> purulentTea(String name, FoodProperties food, int effectBoost, Item.Properties properties) {
        return purulentTea(name, food, effectBoost, (p) -> properties);
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

    public BlockEntry<Block> sack(String name, NonNullUnaryOperator<BlockBehaviour.Properties> properties) {
        return block(name, Block::new)
                .properties(properties.andThen(p -> BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)))
                .blockstate((ctx, provider) -> new SackGenerator().generateSack(ctx, provider))
                .item()
                .model((c, p) -> p.withExistingParent(c.getName(), p.modLoc("block/" + c.getName())))
                .build()
                .register();
    }

    public BlockEntry<Block> crate(String name, NonNullUnaryOperator<BlockBehaviour.Properties> properties) {
        return block(name, Block::new)
                .properties(properties.andThen(p -> BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)))
                .blockstate((ctx, provider) -> new SackGenerator().generateCrate(ctx, provider))
                .item()
                .model((c, p) -> p.withExistingParent(c.getName(), p.modLoc("block/" + c.getName())))
                .build()
                .register();
    }

    public BlockEntry<Block> iceCreamBlock(String name, MapColor materialColor, NonNullUnaryOperator<BlockBehaviour.Properties> properties) {
        return block(name, Block::new)
                .properties(properties.andThen(p -> BlockBehaviour.Properties.of().mapColor(materialColor).strength(0.2F).sound(SoundType.SNOW)))
                .blockstate((ctx, provider) -> provider.cubeAll(ctx.get()))
                .item()
                .model((c, p) -> p.withExistingParent(c.getName(), p.modLoc("block/" + c.getName())))
                .build()
                .register();
    }

    public FluidBuilder<ForgeFlowingFluid.Flowing, BundledRegistrate> alcohol(String name, int color) {
        return fluid(name, AlcoholFluidType.FLUID_STILL_TEXTURE, AlcoholFluidType.FLUID_FLOWING_TEXTURE, createAlcohol(color), ForgeFlowingFluid.Flowing::new);
    }

    public static FluidBuilder.FluidTypeFactory createAlcohol(int color) {
        return (properties, still, flow) -> new AlcoholFluidType(color | 0xFF000000);
    }

    @Nullable
    public BundledRegistrate setCreativeTab(RegistryObject<CreativeModeTab> tab) {
        currentTab = tab;
        return self();
    }

    public RegistryObject<CreativeModeTab> getCreativeTab() {
        return currentTab;
    }

    public static boolean isInCreativeTab(RegistryEntry<?> entry, RegistryObject<CreativeModeTab> tab) {
        return TAB_LOOKUP.get(entry) == tab;
    }

    @Override
    protected <R, T extends R> RegistryEntry<T> accept(String name, ResourceKey<? extends Registry<R>> type, Builder<R, T, ?, ?> builder, NonNullSupplier<? extends T> creator, NonNullFunction<RegistryObject<T>, ? extends RegistryEntry<T>> entryFactory) {
        RegistryEntry<T> entry = super.accept(name, type, builder, creator, entryFactory);
        if (currentTab != null)
            TAB_LOOKUP.put(entry, currentTab);

        return entry;
    }
}
