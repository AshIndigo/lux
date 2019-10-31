package com.ashindigo.lux.api;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

// TODO Gonna need TE's so I can have position
public interface LuxNetworkNode {

    /**
     * Get the next node in the network
     * @param world Current world
     * @param pos Position of this block
     * @return The next node in the network
     */
    LuxNetworkNode getNextNode(World world, BlockPos pos);

    BlockPos getPos();

    BlockState getState();
}

