package com.pouffydev.bundledelight.init.bundles.farmersrespite;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.foundation.BundledRegistrate;
import com.pouffydev.bundledelight.foundation.bundle.BundleRegistryClass;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;

public class RespiteBlocks extends BundleRegistryClass {
    public static final BundledRegistrate registrate = BundledDelight.registrate().creativeModeTab(() -> BundledDelight.itemGroup);

    public RespiteBlocks() {
        super("farmersrespite");
    }

    public static final BlockEntry<Block>
            powderedGreenTeaLeavesSack = registrate.sack(getBundleContentName("powdered_green_tea_leaves_sack"), (p) -> p),
            powderedYellowTeaLeavesSack = registrate.sack(getBundleContentName("powdered_yellow_tea_leaves_sack"), (p) -> p),
            powderedBlackTeaLeavesSack = registrate.sack(getBundleContentName("powdered_black_tea_leaves_sack"), (p) -> p),
            powderedCoffeeBeansSack = registrate.sack(getBundleContentName("powdered_coffee_beans_sack"), (p) -> p);

    public static void register() {
        BundledDelight.LOGGER.info("Registering Respite Blocks");
    }
}
