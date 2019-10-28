package com.ashindigo.lux;

import com.ashindigo.lux.client.LuxAbosrberRenderer;
import com.ashindigo.lux.tileentities.LuxAbsorberTE;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.BlockEntityRendererRegistry;

public class LuxClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.INSTANCE.register(LuxAbsorberTE.class, new LuxAbosrberRenderer());
    }
}
