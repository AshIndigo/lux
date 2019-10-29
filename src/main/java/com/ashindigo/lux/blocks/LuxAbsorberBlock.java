package com.ashindigo.lux.blocks;

import com.ashindigo.lux.tileentities.LuxAbsorberBlockEntity;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class LuxAbsorberBlock extends BlockWithEntity {

	public LuxAbsorberBlock(Settings block$Settings_1) {
		super(block$Settings_1);
	}

	@Override
	public BlockEntity createBlockEntity(BlockView blockView) {
		return new LuxAbsorberBlockEntity();
	}

	@Override
	@Deprecated
	public BlockRenderType getRenderType(BlockState blockState_1) {
		return BlockRenderType.MODEL;
	}

	@Override
	public boolean isOpaque(BlockState blockState_1) {
		return false;
	}

	@Override
	public boolean isSimpleFullBlock(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
		return false;
	}
}
