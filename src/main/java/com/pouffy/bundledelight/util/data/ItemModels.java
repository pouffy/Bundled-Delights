package com.pouffy.bundledelight.util.data;

import com.google.common.collect.Sets;
import com.pouffy.bundledelight.BundledDelights;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ItemModels extends ItemModelProvider {
    public static final String GENERATED = "item/generated";
    public static final String HANDHELD = "item/handheld";
    public static final ResourceLocation MUG = new ResourceLocation("bundledelight", "item/mug");

    public ItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, "bundledelight", existingFileHelper);
    }

    protected void registerModels() {
        Set<Item> items = (Set) ForgeRegistries.ITEMS.getValues().stream().filter((i) -> {
            return "bundledelight".equals(ForgeRegistries.ITEMS.getKey(i).getNamespace());
        }).collect(Collectors.toSet());
        takeAll(items, (i) -> {
            return i instanceof BlockItem;
        }).forEach((item) -> {
            this.blockBasedModel(item, "");
        });
        Set<Item> handheldItems = Sets.newHashSet();
        takeAll(items, (Object[])((Item[])handheldItems.toArray(new Item[0]))).forEach((item) -> {
            this.itemHandheldModel((Item) item, this.resourceItem(this.itemName((Item) item)));
        });
        items.forEach((item) -> {
            this.itemGeneratedModel(item, this.resourceItem(this.itemName(item)));
        });
    }

    public void blockBasedModel(Item item, String suffix) {
        String var10001 = this.itemName(item);
        String var10003 = this.itemName(item);
        this.withExistingParent(var10001, this.resourceBlock(var10003 + suffix));
    }

    public void itemHandheldModel(Item item, ResourceLocation texture) {
        ((ItemModelBuilder)this.withExistingParent(this.itemName(item), "item/handheld")).texture("layer0", texture);
    }

    public void itemGeneratedModel(Item item, ResourceLocation texture) {
        ((ItemModelBuilder)this.withExistingParent(this.itemName(item), "item/generated")).texture("layer0", texture);
    }

    public void itemMugModel(Item item, ResourceLocation texture) {
        ((ItemModelBuilder)this.withExistingParent(this.itemName(item), MUG)).texture("layer0", texture);
    }

    private String itemName(Item item) {
        return item.getRegistryName().getPath();
    }

    public ResourceLocation resourceBlock(String path) {
        return new ResourceLocation("bundledelight", "block/" + path);
    }

    public ResourceLocation resourceItem(String path) {
        return new ResourceLocation("bundledelight", "item/" + path);
    }

    @SafeVarargs
    public static <T> Collection<T> takeAll(Set<? extends T> src, T... items) {
        List<T> ret = Arrays.asList(items);
        Object[] var3 = items;
        int var4 = items.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            T item = (T) var3[var5];
            if (!src.contains(item)) {
                BundledDelights.LOGGER.warn("Item {} not found in set", item);
            }
        }

        if (!src.removeAll(ret)) {
            BundledDelights.LOGGER.warn("takeAll array didn't yield anything ({})", Arrays.toString(items));
        }

        return ret;
    }

    public static <T> Collection<T> takeAll(Set<T> src, Predicate<T> pred) {
        List<T> ret = new ArrayList();
        Iterator<T> iter = src.iterator();

        while(iter.hasNext()) {
            T item = iter.next();
            if (pred.test(item)) {
                iter.remove();
                ret.add(item);
            }
        }

        if (ret.isEmpty()) {
            BundledDelights.LOGGER.warn("takeAll predicate yielded nothing", new Throwable());
        }

        return ret;
    }
}
