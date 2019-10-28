package com.ashindigo.lux.blocks;

import com.ashindigo.lux.api.LuxSource;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;

public class LuxAbsorber extends BlockWithEntity {

    public LuxAbsorber(Settings block$Settings_1) {
        super(block$Settings_1);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
        return null;
    }
}
