package com.ashindigo.lux.items;

import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockRotation;

public class Screwdriver extends Item {

    public Screwdriver(Settings item$Settings_1) {
        super(item$Settings_1);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext usageContext) {
        BlockState state = usageContext.getWorld().getBlockState(usageContext.getBlockPos());
        usageContext.getWorld().setBlockState(usageContext.getBlockPos(), state.rotate(BlockRotation.CLOCKWISE_90));
        return super.useOnBlock(usageContext);
    }
}
