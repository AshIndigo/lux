package com.ashindigo.lux.blockentities;

import com.ashindigo.lux.api.*;
import com.ashindigo.lux.registry.BlockEntityRegistry;
import com.ashindigo.lux.util.networking.LuxNetworkUtil;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Map;

public class LuxAbsorberBlockEntity extends BlockEntity implements LuxSource, Tickable, LuxStorage {

    private int storedLux = 0;
    private boolean running;

    public LuxAbsorberBlockEntity() {
        super(BlockEntityRegistry.LUX_ABSORBER_BLOCK_ENTITY);
    }

    @Override // Assuming WIP
    public boolean canRun() {
        if (world != null) {
            return world.isDaylight() && world.isSkyVisible(pos.offset(Direction.UP)) && getStoredLux() < getMaxCapacity();
        }
        return false;
    }

    @Override
    public boolean isGenerating() {
        return running;
    }

    @Override
    public void tick() {
        storedLux = canRun() ? storedLux + 1 : storedLux;
        running = canRun();
        if (getStoredLux() > 0) {
            if (world != null) {
                LuxNetworkNode node = this;
                LuxNetworkNode tempNode;
                while (!(node instanceof LuxReceiver)) {
                    tempNode = node.getNextNode(world, node.getPos()); // Infinite loop issue, keep track of previous node?
                    if (node == tempNode && !(tempNode instanceof LuxSource)) {
                        break;
                    } else {
                        node = tempNode;
                    }
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

    @Override
    public LuxNetworkNode getNextNode(World world, BlockPos pos) {
        Map<BlockState, BlockPos> map = LuxNetworkUtil.simpleLOSCheck(world, pos, 16, world.getBlockState(pos).get(Properties.FACING));
        if (world.getBlockState(map.values().iterator().next()).getBlock() instanceof BlockWithEntity) {
            return (world.getBlockEntity(map.values().iterator().next()) instanceof LuxNetworkNode) ? (LuxNetworkNode) world.getBlockEntity(map.values().iterator().next()) : this;
        }
    }
}
