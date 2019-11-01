package com.ashindigo.lux.registry;

import com.ashindigo.lux.Lux;
import com.ashindigo.lux.blockentities.LuxAbsorberBlockEntity;
import com.ashindigo.lux.blockentities.LuxStorageBlockEntity;
import com.ashindigo.lux.blockentities.networking.RefractingLensBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class BlockEntityRegistry {
	public static final BlockEntityType<LuxAbsorberBlockEntity> LUX_ABSORBER_BLOCK_ENTITY = register(
			"lux_absorber",
			LuxAbsorberBlockEntity::new,
			BlockRegistry.LUX_ABSORBER_BLOCK
	);
	public static final BlockEntityType<LuxStorageBlockEntity> LUX_STORAGE_BLOCK_ENTITY = register(
			"lux_storage",
			LuxStorageBlockEntity::new,
			BlockRegistry.LUX_STORAGE
	);

	public static final BlockEntityType<RefractingLensBlockEntity> REFRACTING_LENS_BLOCK_ENTITY = register("refracting_lens", RefractingLensBlockEntity::new, BlockRegistry.REFRACTING_LENS);

	private BlockEntityRegistry() {
		// NO-OP
	}

	public static void initialize() {
		// NO-OP
	}

	private static <B extends BlockEntity> BlockEntityType<B> register(String name, Supplier<B> supplier, Block... supportedBlocks) {
		return Registry.register(Registry.BLOCK_ENTITY, new Identifier(Lux.MOD_ID, name), BlockEntityType.Builder.create(supplier, supportedBlocks).build(null));
	}
}
