package com.ashindigo.lux.client;

import com.ashindigo.lux.tileentities.LuxAbsorberTE;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.render.block.entity.BeaconBlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.util.Identifier;

public class LuxAbosrberRenderer extends BlockEntityRenderer<LuxAbsorberTE> {

    private static final Identifier BEAM = new Identifier("minecraft", "textures/entity/beacon_beam.png");


    @Override
    public void render(LuxAbsorberTE blockEntity, double x, double y, double z, float partialTicks, int destroyStage) {
        //GlStateManager.pushMatrix();
        if (blockEntity.isRunning()) {

        }
    }
}
