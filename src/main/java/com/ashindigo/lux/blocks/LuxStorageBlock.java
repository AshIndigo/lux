package com.ashindigo.lux.blocks;

import com.ashindigo.lux.tileentities.LuxStorageBlockEntity;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;

public class LuxStorageBlock extends BlockWithEntity {
    public LuxStorageBlock(Settings block$Settings_1) {
        super(block$Settings_1);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
        return new LuxStorageBlockEntity();
    }
}
