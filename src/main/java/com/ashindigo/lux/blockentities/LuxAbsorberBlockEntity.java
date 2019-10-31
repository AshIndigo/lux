package com.ashindigo.lux.blockentities;

import com.ashindigo.lux.api.*;
import com.ashindigo.lux.registry.BlockEntityRegistry;
import com.ashindigo.lux.util.networking.LuxNetworkUtil;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.BlockPos;

import java.util.Collections;
import java.util.Map;

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
        if (getStoredLux() > 0) {
            if (world != null) {
				Map<BlockState, BlockPos> cur = null;
                Map<BlockState, BlockPos> prev = Collections.singletonMap(world.getBlockState(pos), pos);
				LuxNetworkNode node = null;
                while (cur != prev) { // Could infinitely loop or last for a long time
                	node = ((LuxNetworkNode) prev.keySet().iterator().next()).getNextNode(world, prev.values().iterator().next());
                    if (node instanceof LuxReceiver) {
                    	break;
					}
					cur = Collections.singletonMap(node.getState(), node.getPos());
                }
				if (node instanceof LuxReceiver && ((LuxReceiver) node).canReceive(LuxElements.WHITE)) {
					((LuxReceiver) node).receiveLux(LuxElements.WHITE, 1);
					storedLux -= 1;
				}
			}
        }
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
