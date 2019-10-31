package com.ashindigo.lux.blockentities.networking;

import com.ashindigo.lux.api.LuxNetworkNode;
import com.ashindigo.lux.registry.BlockEntityRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

// Safe delete when possible
public class RefractorLensTileEntity extends BlockEntity implements LuxNetworkNode {
    public RefractorLensTileEntity() {
        super(BlockEntityRegistry.REFRACTOR_LENS_BLOCK_ENTITY);
    }


    @Override
    public LuxNetworkNode getNextNode(World world, BlockPos pos) {
        return null;
    }

    @Override
    public BlockState getState() {
        return world.getBlockState(pos);
    }
}
