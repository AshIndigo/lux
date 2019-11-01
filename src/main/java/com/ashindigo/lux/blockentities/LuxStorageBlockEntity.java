package com.ashindigo.lux.blockentities;

import com.ashindigo.lux.api.LuxElements;
import com.ashindigo.lux.api.LuxNetworkNode;
import com.ashindigo.lux.api.LuxReceiver;
import com.ashindigo.lux.api.LuxStorage;
import com.ashindigo.lux.registry.BlockEntityRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LuxStorageBlockEntity extends BlockEntity implements LuxStorage, LuxReceiver {

	private int storedLux;

	public LuxStorageBlockEntity() {
		super(BlockEntityRegistry.LUX_STORAGE_BLOCK_ENTITY);
	}


	@Override
	public int receiveLux(LuxElements lux, int amount) {
		System.out.println(storedLux);
		if (storedLux + amount < getMaxCapacity()) {
			storedLux += amount;
			return 0;
		} else {
			storedLux += (storedLux + amount) - getMaxCapacity();
			return (storedLux + amount) - getMaxCapacity();
		}
	}

	@Override
	public boolean canReceive(LuxElements lux) {
		return true;
	}

	@Override
	public int getStoredLux() {
		return storedLux;
	}

	@Override
	public int getMaxCapacity() {
		return 10000;
	}

	@Override
	public LuxNetworkNode getNextNode(World world, BlockPos pos) {
		return this;
	}
}
