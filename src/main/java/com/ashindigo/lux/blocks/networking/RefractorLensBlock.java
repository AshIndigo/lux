package com.ashindigo.lux.blocks.networking;

import com.ashindigo.lux.api.LuxNetworkNode;
import com.ashindigo.lux.util.networking.LuxNetworkUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Map;

public class RefractorLensBlock extends Block implements LuxNetworkNode {
    private static final DirectionProperty FACING;

    static {
        FACING = Properties.HORIZONTAL_FACING;
    }

    public RefractorLensBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateFactory.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(FACING, context.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.get(FACING)));
    }

    @Override
    public boolean isOpaque(BlockState blockState_1) {
        return false;
    }

    @Override
    public boolean isSimpleFullBlock(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
        return false;
    }

    @Override
    protected void appendProperties(StateFactory.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public LuxNetworkNode getNextNode(World world, BlockPos pos) {
        Map<BlockState, BlockPos> map = LuxNetworkUtil.simpleLOSCheck(world, pos, 16, world.getBlockState(pos).get(FACING));
        return (map.keySet().iterator().next().getBlock() instanceof LuxNetworkNode) ? (LuxNetworkNode) map.keySet().iterator().next().getBlock() : this;
    }

    @Override
    public BlockPos getPos() {
        return null;
    }

    @Override
    public BlockState getState() {
        return null;
    }
}
