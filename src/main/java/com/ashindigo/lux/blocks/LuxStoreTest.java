package com.ashindigo.lux.blocks;

import com.ashindigo.lux.api.LuxElements;
import com.ashindigo.lux.api.LuxReceiver;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;

public class LuxStoreTest extends BlockWithEntity {
    public LuxStoreTest(Settings block$Settings_1) {
        super(block$Settings_1);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
        return null;
    }
}
