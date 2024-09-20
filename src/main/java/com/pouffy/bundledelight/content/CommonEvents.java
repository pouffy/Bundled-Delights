package com.pouffy.bundledelight.content;

import com.google.common.collect.Maps;
import com.pouffy.bundledelight.BundledDelights;
import com.pouffy.bundledelight.compats.abnormals_delight.AbnormalsNeapolitanCompatItems;
import com.pouffy.bundledelight.compats.neapolitan.NeapolitanCompatBlocks;
import com.pouffy.bundledelight.content.tag.BDTags;
import com.pouffy.bundledelight.init.BDBlocks;
import com.pouffy.bundledelight.init.BDItems;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.HashMap;
import java.util.Iterator;
import java.util.function.Supplier;
@SuppressWarnings("unchecked")
@Mod.EventBusSubscriber(
        modid = BundledDelights.MODID
)
public class CommonEvents {
    public static final IntegerProperty BITES = IntegerProperty.create("bites", 0, 9);
    public CommonEvents() {
    }
    public static final HashMap<Supplier<Item>, ResourceLocation> SLICES_TO_CAKES = (HashMap)Util.make(Maps.newHashMap(), (list) -> {
        list.put(BDItems.CARROT_CAKE_SLICE, BDBlocks.CARROT_CAKE);
        //list.put(AbnormalsNeapolitanCompatItems.WHITE_STRAWBERRY_CAKE_SLICE, NeapolitanCompatBlocks.STRAWBERRY_CAKE);
    });
    public static final HashMap<TagKey<Block>, Supplier<Item>> TAGS_TO_SLICES = (HashMap) Util.make(Maps.newHashMap(), (list) -> {
        list.put(BDTags.DROPS_CARROT_CAKE_SLICE, BDItems.CARROT_CAKE_SLICE);
        //list.put(BDTags.DROPS_WHITE_STRAWBERRY_CAKE_SLICE, NeapolitanCompatBlocks.STRAWBERRY_CAKE);
    });
    public static Supplier<Item> getCakeSlice(BlockState state) {
        TagKey<Block> cakeTag = BDTags.DROPS_CAKE_SLICE;
        Iterator var2 = TAGS_TO_SLICES.keySet().iterator();

        while(var2.hasNext()) {
            TagKey<Block> tagKey = (TagKey)var2.next();
            if (state.is(tagKey)) {
                cakeTag = tagKey;
            }
        }

        return (Supplier)TAGS_TO_SLICES.get(cakeTag);
    }
    @SubscribeEvent
    public static void onCakeInteraction(PlayerInteractEvent.RightClickBlock event) {
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = event.getLevel().getBlockState(pos);
        ItemStack tool = event.getItemStack();
        ResourceLocation name = ForgeRegistries.BLOCKS.getKey(state.getBlock());
        if (tool.is(ModTags.KNIVES) && name != null) {
            if (state.is(BDTags.DROPS_CAKE_SLICE)) {
                Supplier<Item> cakeSlice = getCakeSlice(state);
                if (state.hasProperty(CakeBlock.BITES)) {
                    int bites = (Integer)state.getValue(CakeBlock.BITES);
                    if (bites < 6) {
                        world.setBlock(pos, (BlockState)state.setValue(CakeBlock.BITES, bites + 1), 3);
                    } else {
                        world.removeBlock(pos, false);
                    }
                } else {
                    world.setBlock(pos, (BlockState)((Block) ForgeRegistries.BLOCKS.getValue((ResourceLocation)SLICES_TO_CAKES.get(cakeSlice))).defaultBlockState().setValue(CakeBlock.BITES, 1), 3);
                    Block.dropResources(state, world, pos);
                }

                Containers.dropItemStack(world, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), new ItemStack((ItemLike)cakeSlice.get()));
                world.playSound((Player)null, pos, SoundEvents.WOOL_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
                event.setCancellationResult(InteractionResult.SUCCESS);
                event.setCanceled(true);
            }
        }

    }
}
