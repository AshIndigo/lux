package com.ashindigo.lux.registry;

import com.ashindigo.lux.Lux;
import com.ashindigo.lux.blocks.LuxAbsorberBlock;
import com.ashindigo.lux.blocks.LuxStorageBlock;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Function;

public class BlockRegistry {
	private BlockRegistry() {
		// NO-OP
	}

	public static void initialize() {
		// NO-OP
	}

	public static final Block LUX_ABSORBER_BLOCK = register("lux_absorber", new LuxAbsorberBlock(FabricBlockSettings.of(Material.METAL).strength(3F, 3F).build()), new Item.Settings().group(Lux.ITEM_GROUP));
	public static final Block LUX_STORAGE = register("lux_storage", new LuxStorageBlock(FabricBlockSettings.of(Material.METAL).strength(3F, 3F).build()), new Item.Settings().group(Lux.ITEM_GROUP));

	public static <T extends Block> T register(String name, T block, Item.Settings settings) {
		return register(name, block, new BlockItem(block, settings));
	}

	public static <T extends Block> T register(String name, T block) {
		return register(name, block, new Item.Settings().group(Lux.ITEM_GROUP));
	}

	public static <T extends Block> T register(String name, T block, Function<T, BlockItem> itemFactory) {
		return register(name, block, itemFactory.apply(block));
	}

	public static <T extends Block> T register(String name, T block, BlockItem item) {
		T b = Registry.register(Registry.BLOCK, new Identifier(Lux.MOD_ID, name), block);
		if (item != null) {
			BlockItem bi = ItemRegistry.register(name, item);
			bi.appendBlocks(BlockItem.BLOCK_ITEMS, bi);
		}
		return b;
	}

	public static <T extends Block> T registerNoItem(String name, T block) {
		T b = Registry.register(Registry.BLOCK, new Identifier(Lux.MOD_ID, name), block);
		return b;
	}
}
