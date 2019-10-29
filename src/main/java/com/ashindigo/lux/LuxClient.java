package com.ashindigo.lux;

import com.ashindigo.lux.registry.RendererRegistry;
import net.fabricmc.api.ClientModInitializer;

public class LuxClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		RendererRegistry.initialize();
	}
}
