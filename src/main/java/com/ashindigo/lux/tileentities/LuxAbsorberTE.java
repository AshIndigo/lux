package com.ashindigo.lux.tileentities;

import com.ashindigo.lux.Lux;
import com.ashindigo.lux.api.LuxSource;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Tickable;

public class LuxAbsorberTE extends BlockEntity implements LuxSource, Tickable {

    int maxLuxStorage = 5000;
    int storedLux = 0;
    private boolean running;

    public LuxAbsorberTE() {
        super(Lux.luxAbsorberTE);
    }

    @Override
    public boolean canRun() {
        return getWorld().isDaylight() && getWorld().isSkyVisible(pos) && storedLux < maxLuxStorage;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public void tick() {
        if (canRun()) {
            storedLux++;
            running = true;
        } else {
            running = false;
        }
    }
}
