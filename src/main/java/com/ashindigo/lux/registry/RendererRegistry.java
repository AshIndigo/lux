package com.ashindigo.lux.registry;

import com.ashindigo.lux.blockentities.LuxAbsorberBlockEntity;
import com.ashindigo.lux.client.LuxAbsorberRenderer;
import net.fabricmc.fabric.api.client.render.BlockEntityRendererRegistry;

public class RendererRegistry {
	private RendererRegistry() {
		// NO-OP
	}

	public static void initialize() {
		BlockEntityRendererRegistry.INSTANCE.register(LuxAbsorberBlockEntity.class, new LuxAbsorberRenderer());
	}
}
