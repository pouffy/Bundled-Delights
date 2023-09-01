package com.pouffy.bundledelight.util.data;

import com.google.common.collect.Sets;
import com.pouffy.bundledelight.BundledDelights;
import com.pouffy.bundledelight.compat.brewinandchewin.BrewinCompatItems;
import com.pouffy.bundledelight.compat.brewinandchewin.BrewinMDCompatItems;
import com.pouffy.bundledelight.compat.farmersrespite.RespiteMDCompatItems;
import com.pouffy.bundledelight.compat.neapolitan.NeapolitanCompatItems;
import com.pouffy.bundledelight.compat.respiteful.RespitefulMDCompatItems;
import com.pouffy.bundledelight.init.BDItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ItemModels extends ItemModelProvider {
    public static final String GENERATED = "item/generated";
    public static final String HANDHELD = "item/handheld";
    public static final ResourceLocation MUG = new ResourceLocation(BundledDelights.MODID, "item/mug");
    public ItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, "bundledelight", existingFileHelper);
    }

    protected void registerModels() {
        Set<Item> items = ForgeRegistries.ITEMS.getValues().stream().filter((i) -> {
            return "bundledelight".equals(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(i)).getNamespace());
        }).collect(Collectors.toSet());
        takeAll(items, (i) -> {
            return i instanceof BlockItem;
        }).forEach((item) -> {
            this.blockBasedModel(item, "");
        });
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection") Set<Item> handheldItems = Sets.newHashSet();
        takeAll(items, (Object[])((Item[])handheldItems.toArray(new Item[0]))).forEach((item) -> {
            this.itemHandheldModel((Item) item, this.resourceItem(this.itemName((Item) item)));
        });
        items.forEach((item) -> {
            this.itemGeneratedModel(item, this.resourceItem(this.itemName(item)));
        });
        Set<Item> mugItems = Sets.newHashSet(
                RespiteMDCompatItems.CUP.get(),
                RespiteMDCompatItems.GREEN_TEA_CUP.get(),
                RespiteMDCompatItems.LONG_GREEN_TEA_CUP.get(),
                RespiteMDCompatItems.STRONG_GREEN_TEA_CUP.get(),
                RespiteMDCompatItems.YELLOW_TEA_CUP.get(),
                RespiteMDCompatItems.LONG_YELLOW_TEA_CUP.get(),
                RespiteMDCompatItems.STRONG_YELLOW_TEA_CUP.get(),
                RespiteMDCompatItems.BLACK_TEA_CUP.get(),
                RespiteMDCompatItems.LONG_BLACK_TEA_CUP.get(),
                RespiteMDCompatItems.STRONG_BLACK_TEA_CUP.get(),
                RespiteMDCompatItems.ROSE_HIP_TEA_CUP.get(),
                RespiteMDCompatItems.STRONG_ROSE_HIP_TEA_CUP.get(),
                RespiteMDCompatItems.DANDELION_TEA_CUP.get(),
                RespiteMDCompatItems.LONG_DANDELION_TEA_CUP.get(),
                RespiteMDCompatItems.PURULENT_TEA_CUP.get(),
                RespiteMDCompatItems.STRONG_PURULENT_TEA_CUP.get(),
                RespiteMDCompatItems.COFFEE_CUP.get(),
                RespiteMDCompatItems.LONG_COFFEE_CUP.get(),
                RespiteMDCompatItems.STRONG_COFFEE_CUP.get(),
                RespitefulMDCompatItems.MINT_GREEN_TEA_CUP.get(),
                RespitefulMDCompatItems.ADZUKI_MILK_TEA_CUP.get(),
                RespitefulMDCompatItems.MOCHA_COFFEE_CUP.get(),
                RespitefulMDCompatItems.VANILLA_MILK_TEA_CUP.get(),
                BrewinMDCompatItems.COPPER_TANKARD.get(),
                BrewinMDCompatItems.BEER_SWIG.get(),
                BrewinMDCompatItems.BLOODY_MARY_SWIG.get(),
                BrewinMDCompatItems.DREAD_NOG_SWIG.get(),
                BrewinMDCompatItems.EGG_GROG_SWIG.get(),
                BrewinMDCompatItems.GLITTERING_GRENADINE_SWIG.get(),
                BrewinMDCompatItems.KOMBUCHA_SWIG.get(),
                BrewinMDCompatItems.PALE_JANE_SWIG.get(),
                BrewinMDCompatItems.RADIANT_BREW_SWIG.get(),
                BrewinMDCompatItems.RED_RUM_SWIG.get(),
                BrewinMDCompatItems.RICE_WINE_SWIG.get(),
                BrewinMDCompatItems.SACCHARINE_RUM_SWIG.get(),
                BrewinMDCompatItems.MEAD_SWIG.get(),
                BrewinMDCompatItems.WITHERING_DROSS_SWIG.get(),
                BrewinMDCompatItems.VODKA_SWIG.get(),
                BrewinMDCompatItems.SALTY_FOLLY_SWIG.get(),
                BrewinMDCompatItems.STEEL_TOE_STOUT_SWIG.get(),
                BrewinMDCompatItems.STRONGROOT_ALE_SWIG.get(),
                BrewinMDCompatItems.ROOT_BEER_SWIG.get(),
                //MinersCompatItems.BORSCHT_CUP.get(),
                //MinersCompatItems.NETTLE_SOUP_CUP.get(),
                BrewinCompatItems.GLASS_TANKARD.get(),
                BrewinCompatItems.BEER_GLASS.get(),
                BrewinCompatItems.BLOODY_MARY_GLASS.get(),
                BrewinCompatItems.DREAD_NOG_GLASS.get(),
                BrewinCompatItems.EGG_GROG_GLASS.get(),
                BrewinCompatItems.GLITTERING_GRENADINE_GLASS.get(),
                BrewinCompatItems.KOMBUCHA_GLASS.get(),
                BrewinCompatItems.PALE_JANE_GLASS.get(),
                BrewinCompatItems.RADIANT_BREW_GLASS.get(),
                BrewinCompatItems.RED_RUM_GLASS.get(),
                BrewinCompatItems.RICE_WINE_GLASS.get(),
                BrewinCompatItems.SACCHARINE_RUM_GLASS.get(),
                BrewinCompatItems.MEAD_GLASS.get(),
                BrewinCompatItems.WITHERING_DROSS_GLASS.get(),
                BrewinCompatItems.VODKA_GLASS.get(),
                BrewinCompatItems.SALTY_FOLLY_GLASS.get(),
                BrewinCompatItems.STEEL_TOE_STOUT_GLASS.get(),
                BrewinCompatItems.STRONGROOT_ALE_GLASS.get(),
                //BrewinCompatItems.RADIANT_BREW.get(),
                //BrewinCompatItems.ROOT_BEER.get(),
                BrewinCompatItems.ROOT_BEER_GLASS.get()
                );
        takeAll(items, mugItems.toArray(new Item[0])).forEach(item -> itemMugModel(item, resourceItem(itemName(item))));
        Set<Item> generatedItems = Sets.newHashSet(
                NeapolitanCompatItems.STRAWBERRY_CAKE.get(),
                BDItems.CARROT_CAKE.get()
        );
        takeAll(items, generatedItems.toArray(new Item[0])).forEach(item -> itemGeneratedModel(item, resourceItem(itemName(item))));
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
