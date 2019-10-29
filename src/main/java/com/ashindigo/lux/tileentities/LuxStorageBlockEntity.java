package com.ashindigo.lux.tileentities;

import com.ashindigo.lux.api.LuxElements;
import com.ashindigo.lux.api.LuxReceiver;
import com.ashindigo.lux.api.LuxStorage;
import com.ashindigo.lux.registry.BlockEntityRegistry;
import net.minecraft.block.entity.BlockEntity;

public class LuxStorageBlockEntity extends BlockEntity implements LuxStorage, LuxReceiver {
	private int storedLux;

	public LuxStorageBlockEntity() {
		super(BlockEntityRegistry.LUX_STORAGE_BLOCK_ENTITY);
	}

	@Override
	public void receiveLux(LuxElements lux, int amount) {

	}

	@Override
	public boolean canRecieve(LuxElements lux) {
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
}
