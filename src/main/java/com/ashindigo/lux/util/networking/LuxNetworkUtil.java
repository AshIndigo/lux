package com.ashindigo.lux.util.networking;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Map;

public class LuxNetworkUtil {

    /**
     * Simple direction LOS to see if there are any non air blocks in the way
     *
     * @param world     Block's world
     * @param pos       Starting position
     * @param distance  Max distance for line of sight
     * @param direction The direction in which to test
     * @return A key value map with the block state and its position
     */
    public static Map<BlockState, BlockPos> simpleLOSCheck(World world, BlockPos pos, int distance, Direction direction) {
        for (int i = 1; i <= distance; i++) {
            if (!world.getBlockState(pos.offset(direction, i)).isAir()) {
                return Collections.singletonMap(world.getBlockState(pos.offset(direction, i)), pos.offset(direction, i));
            }
        }
        return Collections.singletonMap(Blocks.AIR.getDefaultState(), pos.offset(direction, distance)); // Return AIR if all else fails
    }
}
