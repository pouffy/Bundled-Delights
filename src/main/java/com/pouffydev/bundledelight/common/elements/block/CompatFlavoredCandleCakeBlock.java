package com.pouffydev.bundledelight.common.elements.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import lombok.Getter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;
import java.util.stream.Collectors;

public class CompatFlavoredCandleCakeBlock extends AbstractCandleBlock {
    public static final MapCodec<CompatFlavoredCandleCakeBlock> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(
            BuiltInRegistries.BLOCK.holderByNameCodec().fieldOf("base").forGetter((cakeBlock) -> cakeBlock.baseCake),
            BuiltInRegistries.BLOCK.byNameCodec().fieldOf("candle").forGetter((cakeBlock) -> cakeBlock.candle),
            propertiesCodec()).apply(instance, CompatFlavoredCandleCakeBlock::new));

    public static final BooleanProperty LIT;
    protected static final VoxelShape CAKE_SHAPE;
    protected static final VoxelShape CANDLE_SHAPE;
    protected static final VoxelShape SHAPE;
    private static final Map<Pair<Block, CompatFlavoredCakeBlock>, CompatFlavoredCandleCakeBlock> BY_CANDLE_AND_CAKE;
    private static final Iterable<Vec3> PARTICLE_OFFSETS;
    private final Holder<Block> baseCake;
    @Getter
    private final Block candle;
    
    public CompatFlavoredCandleCakeBlock(Holder<Block> baseCake, Block candle, BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, Boolean.FALSE));
        this.baseCake = baseCake;
        this.candle = candle;
        BY_CANDLE_AND_CAKE.put(Pair.of(candle, (CompatFlavoredCakeBlock)baseCake.value()), this);
    }

    @Override
    protected MapCodec<? extends AbstractCandleBlock> codec() {
        return null;
    }

    protected Iterable<Vec3> getParticleOffsets(BlockState p_152868_) {
        return PARTICLE_OFFSETS;
    }
    
    public VoxelShape getShape(BlockState p_152875_, BlockGetter p_152876_, BlockPos p_152877_, CollisionContext p_152878_) {
        return SHAPE;
    }
    
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (!itemstack.is(Items.FLINT_AND_STEEL) && !itemstack.is(Items.FIRE_CHARGE)) {
            Object var9 = this.baseCake.value();
            if (var9 instanceof CompatFlavoredCakeBlock) {
                CompatFlavoredCakeBlock cakeBlock = (CompatFlavoredCakeBlock)var9;
                if (candleHit(result) && player.getItemInHand(hand).isEmpty() && (Boolean)state.getValue(LIT)) {
                    extinguish(player, state, level, pos);
                    return InteractionResult.sidedSuccess(level.isClientSide);
                }
                
                InteractionResult interactionresult = cakeBlock.eatSlice(level, pos, cakeBlock.defaultBlockState(), player);
                if (interactionresult.consumesAction()) {
                    dropResources(state, level, pos);
                }
                
                return interactionresult;
            }
        }
        
        return InteractionResult.PASS;
    }
    
    public ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
        return new ItemStack(this.baseCake.value());
    }
    
    private static boolean candleHit(BlockHitResult result) {
        return result.getLocation().y - (double)result.getBlockPos().getY() > 0.5;
    }
    
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_152905_) {
        p_152905_.add(LIT);
    }
    
    public BlockState updateShape(BlockState p_152898_, Direction p_152899_, BlockState p_152900_, LevelAccessor p_152901_, BlockPos p_152902_, BlockPos p_152903_) {
        return p_152899_ == Direction.DOWN && !p_152898_.canSurvive(p_152901_, p_152902_) ? Blocks.AIR.defaultBlockState() : super.updateShape(p_152898_, p_152899_, p_152900_, p_152901_, p_152902_, p_152903_);
    }

    public boolean canSurvive(BlockState p_152891_, LevelReader p_152892_, BlockPos p_152893_) {
        return p_152892_.getBlockState(p_152893_.below()).isSolid();
    }
    
    public int getAnalogOutputSignal(BlockState p_152880_, Level p_152881_, BlockPos p_152882_) {
        return CakeBlock.FULL_CAKE_SIGNAL;
    }
    
    public boolean hasAnalogOutputSignal(BlockState p_152909_) {
        return true;
    }
    
    public boolean isPathfindable(BlockState p_152870_, BlockGetter p_152871_, BlockPos p_152872_, PathComputationType p_152873_) {
        return false;
    }
    
    public static boolean hasEntry(Block candle, CompatFlavoredCakeBlock cake) {
        return BY_CANDLE_AND_CAKE.get(Pair.of(candle, cake)) != null;
    }
    
    public static BlockState byCandle(Block candle, CompatFlavoredCakeBlock cake) {
        return BY_CANDLE_AND_CAKE.get(Pair.of(candle, cake)).defaultBlockState();
    }

    public Block getCake() {
        return this.baseCake.value();
    }
    
    public static Iterable<Block> getCandleCakes() {
        return BuiltInRegistries.BLOCK.stream().filter((block) -> {
            ResourceLocation registryName = BuiltInRegistries.BLOCK.getKey(block);
            return "bundledelight".equals(registryName.getNamespace()) && block instanceof CompatFlavoredCandleCakeBlock;
        }).collect(Collectors.toList());
    }
    
    static {
        LIT = AbstractCandleBlock.LIT;
        CAKE_SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 8.0, 15.0);
        CANDLE_SHAPE = Block.box(7.0, 8.0, 7.0, 9.0, 14.0, 9.0);
        SHAPE = Shapes.or(CAKE_SHAPE, CANDLE_SHAPE);
        BY_CANDLE_AND_CAKE = Maps.newHashMap();
        PARTICLE_OFFSETS = ImmutableList.of(new Vec3(0.5, 1.0, 0.5));
    }
}
