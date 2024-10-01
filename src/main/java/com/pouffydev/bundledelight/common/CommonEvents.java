package com.pouffydev.bundledelight.common;

import com.google.common.collect.Maps;
import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.datagen.BundleTags;
import com.pouffydev.bundledelight.init.bundles.builtin.BuiltinBlocks;
import com.pouffydev.bundledelight.init.bundles.builtin.BuiltinItems;
import com.pouffydev.bundledelight.init.bundles.neapolitan.NeapolitanBlocks;
import com.pouffydev.bundledelight.init.bundles.neapolitan.NeapolitanItems;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.HashMap;
import java.util.Objects;

@Mod.EventBusSubscriber(modid = BundledDelight.MODID)
public class CommonEvents {
    public CommonEvents() {
    }
    public static final HashMap<ResourceLocation, ResourceLocation> SLICES_TO_CAKES = Util.make(Maps.newHashMap(), (list) -> {
        list.put(BuiltinItems.carrotCakeSlice.getId(), BuiltinBlocks.carrotCake.getId());
        list.put(NeapolitanItems.whiteStrawberryCakeSlice.getId(), NeapolitanBlocks.whiteStrawberryCake.getId());
    });
    public static final HashMap<TagKey<Block>, ResourceLocation> TAGS_TO_SLICES = Util.make(Maps.newHashMap(), (list) -> {
        list.put(BundleTags.DROPS_CARROT_CAKE_SLICE, BuiltinItems.carrotCakeSlice.getId());
        list.put(BundleTags.DROPS_WHITE_STRAWBERRY_CAKE_SLICE, NeapolitanItems.whiteStrawberryCakeSlice.getId());
    });

    public static ItemEntry<?> getCakeSlice(BlockState state) {
        TagKey<Block> cakeTag = BundleTags.DROPS_CAKE_SLICE;

        for (TagKey<Block> blockTagKey : TAGS_TO_SLICES.keySet()) {
            if (state.is(blockTagKey)) {
                cakeTag = blockTagKey;
            }
        }
        ResourceLocation cakeSlice = TAGS_TO_SLICES.get(cakeTag);
        RegistryEntry<Item> item = BundledDelight.registrate().get(cakeSlice.getPath(), Registry.ITEM_REGISTRY);
        if (!item.isPresent()) {
            return BuiltinItems.carrotCakeSlice;
        }

        return ItemEntry.cast(item);
    }

    @SubscribeEvent
    public static void onCakeInteraction(PlayerInteractEvent.RightClickBlock event) {
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = event.getLevel().getBlockState(pos);
        ItemStack tool = event.getEntity().getItemInHand(event.getHand());
        if (tool.is(ModTags.KNIVES)) {
            if (state.is(BundleTags.DROPS_CAKE_SLICE)) {
                ItemEntry<?> cakeSlice = getCakeSlice(state);
                if (cakeSlice == null) {
                    event.setCancellationResult(InteractionResult.FAIL);
                    event.setCanceled(true);
                }
                if (state.hasProperty(CakeBlock.BITES)) {
                    int bites = state.getValue(CakeBlock.BITES);
                    if (bites < 6) {
                        world.setBlock(pos, state.setValue(CakeBlock.BITES, bites + 1), 3);
                    } else {
                        world.removeBlock(pos, false);
                    }
                } else {
                    world.setBlock(pos, Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(SLICES_TO_CAKES.get(cakeSlice.getId()))).defaultBlockState().setValue(CakeBlock.BITES, 1), 3);
                    Block.dropResources(state, world, pos);
                }

                Containers.dropItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(cakeSlice.get()));
                world.playSound(null, pos, SoundEvents.WOOL_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
                event.setCancellationResult(InteractionResult.SUCCESS);
                event.setCanceled(true);
            }
        }

    }
}
