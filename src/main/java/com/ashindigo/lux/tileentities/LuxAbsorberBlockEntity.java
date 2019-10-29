package com.ashindigo.lux.tileentities;

import com.ashindigo.lux.Lux;
import com.ashindigo.lux.api.LuxSource;
import com.ashindigo.lux.registry.BlockEntityRegistry;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Tickable;

public class LuxAbsorberBlockEntity extends BlockEntity implements LuxSource, Tickable {

    int maxLuxStorage = 5000;
    int storedLux = 0;
    private boolean running;

    public LuxAbsorberBlockEntity() {
        super(BlockEntityRegistry.LUX_ABSORBER_BLOCK_ENTITY);
    }

    @Override // Assuming WIP
    public boolean canRun() {
        return getWorld().isDaylight() && getWorld().isSkyVisible(pos) && storedLux < maxLuxStorage;
    }

    @Override // Assuming WIP
    public boolean isRunning() {
        return running;
    }

    @Override
    public void tick() {
        storedLux = canRun() ? storedLux + 1 : storedLux;
        running = canRun();
    }
}
