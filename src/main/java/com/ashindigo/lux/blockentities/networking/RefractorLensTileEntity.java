package com.ashindigo.lux.blockentities.networking;

import com.ashindigo.lux.api.LuxNetworkNode;
import com.ashindigo.lux.registry.BlockEntityRegistry;
import com.ashindigo.lux.util.networking.LuxNetworkUtil;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Map;


public class RefractorLensTileEntity extends BlockEntity implements LuxNetworkNode {
    public RefractorLensTileEntity() {
        super(BlockEntityRegistry.REFRACTOR_LENS_BLOCK_ENTITY);
    }


    @Override
    public LuxNetworkNode getNextNode(World world, BlockPos pos) {
        Map<BlockState, BlockPos> map = LuxNetworkUtil.simpleLOSCheck(world, pos, 16, world.getBlockState(pos).get(Properties.FACING));
        return (world.getBlockEntity(map.values().iterator().next()) instanceof LuxNetworkNode) ? (LuxNetworkNode) world.getBlockEntity(map.values().iterator().next()) : this;
    }

}
