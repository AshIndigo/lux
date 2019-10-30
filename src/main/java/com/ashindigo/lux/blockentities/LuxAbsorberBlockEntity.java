package com.ashindigo.lux.blockentities;

import com.ashindigo.lux.api.LuxSource;
import com.ashindigo.lux.api.LuxStorage;
import com.ashindigo.lux.registry.BlockEntityRegistry;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.Tickable;

public class LuxAbsorberBlockEntity extends BlockEntity implements LuxSource, Tickable, LuxStorage {

	private int storedLux = 0;
	private boolean running;

	public LuxAbsorberBlockEntity() {
		super(BlockEntityRegistry.LUX_ABSORBER_BLOCK_ENTITY);
	}

	@Override // Assuming WIP
	public boolean canRun() {
		return getWorld().isDaylight() && getWorld().isSkyVisible(pos) && getStoredLux() < getStoredLux();
	}

	@Override // Assuming WIP
	public boolean isGenerating() {
		return running;
	}

	@Override
	public void tick() {
		storedLux = canRun() ? storedLux + 1 : storedLux;
		running = canRun();

	}

	@Override
	public int getStoredLux() {
		return storedLux;
	}

	@Override
	public int getMaxCapacity() {
		return 5000;
	}
}
