package com.pouffydev.bundledelight.foundation;

import com.pouffydev.bundledelight.common.elements.block.CompatFlavoredCakeBlock;
import com.pouffydev.bundledelight.common.elements.block.CompatFlavoredCandleCakeBlock;
import com.pouffydev.krystal_core.foundation.registry.block.BlockRegistryHelper;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public class BDBlockHelper extends BlockRegistryHelper {
    public final DeferredRegister<Block> BLOCKS;

    public BDBlockHelper(BlockRegistryHelper helper) {
        super(helper.getModId(), helper.getEventBus());
        BLOCKS = this.createRegister(Registries.BLOCK);
    }

    public <T extends Block> DeferredBlock<T> register(String name, Supplier<T> constructor) {
        return (DeferredBlock<T>) BLOCKS.register(name, constructor);
    }

    public <T extends CompatFlavoredCakeBlock> DeferredBlock<T> cake(String name, FoodProperties foodProperties) {
        return this.cake(name, foodProperties, (p) -> p);
    }

    public <T extends CompatFlavoredCakeBlock> DeferredBlock<T> cake(String name, FoodProperties foodProperties, Function<Block.Properties, Block.Properties> properties) {
        return (DeferredBlock<T>) register(name, () -> new CompatFlavoredCakeBlock(foodProperties, properties.apply(BlockBehaviour.Properties.of())));
    }

    public <T extends CompatFlavoredCandleCakeBlock> DeferredBlock<T> candleCake(String name, Holder<Block> baseCake, Block candle) {
        return this.candleCake(name, baseCake, candle, (p) -> p);
    }

    public <T extends CompatFlavoredCandleCakeBlock> DeferredBlock<T> candleCake(String name, Holder<Block> baseCake, Block candle, Function<Block.Properties, Block.Properties> properties) {
        return (DeferredBlock<T>) register(name, () -> new CompatFlavoredCandleCakeBlock(baseCake, candle, properties.apply(BlockBehaviour.Properties.of())));
    }
}
