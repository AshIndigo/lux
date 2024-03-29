package com.ashindigo.lux.api;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface LuxNetworkNode {

    /**
     * Get the next node in the network
     * @param world Current world
     * @param pos Position of this block
     * @return The next node in the network
     */
    LuxNetworkNode getNextNode(World world, BlockPos pos);

    BlockPos getPos();
}

