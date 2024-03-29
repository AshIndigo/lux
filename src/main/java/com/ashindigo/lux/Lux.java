package com.ashindigo.lux;

import com.ashindigo.lux.registry.BlockEntityRegistry;
import com.ashindigo.lux.registry.BlockRegistry;
import com.ashindigo.lux.registry.ItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class Lux implements ModInitializer {
	public static final String MOD_ID = "lux";
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "group"), () -> new ItemStack(BlockRegistry.LUX_ABSORBER_BLOCK));

	@Override
	public void onInitialize() {
		ItemRegistry.initialize();
		BlockRegistry.initialize();
		BlockEntityRegistry.initialize();
	}
}
