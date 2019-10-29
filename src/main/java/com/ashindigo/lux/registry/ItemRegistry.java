package com.ashindigo.lux.registry;

import com.ashindigo.lux.Lux;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {
	private ItemRegistry() {
		// NO-OP
	}

	public static void initialize() {
		// NO-OP
	}

	public static <T extends Item> T register(String name, T item) {
		return Registry.register(Registry.ITEM, new Identifier(Lux.MOD_ID, name), item);
	}
}
