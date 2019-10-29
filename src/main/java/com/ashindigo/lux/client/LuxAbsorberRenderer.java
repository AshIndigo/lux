package com.ashindigo.lux.client;

import com.ashindigo.lux.tileentities.LuxAbsorberBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.util.Identifier;

public class LuxAbsorberRenderer extends BlockEntityRenderer<LuxAbsorberBlockEntity> {

	private static final Identifier BEAM = new Identifier("minecraft", "textures/entity/beacon_beam.png");


	@Override
	public void render(LuxAbsorberBlockEntity blockEntity, double x, double y, double z, float partialTicks, int destroyStage) {
		//GlStateManager.pushMatrix();
		if (blockEntity.isGenerating()) {

		}
	}
}
