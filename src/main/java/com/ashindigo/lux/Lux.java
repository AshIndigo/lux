package com.ashindigo.lux;

import com.ashindigo.lux.blocks.LuxAbsorber;
import com.ashindigo.lux.blocks.LuxStoreTest;
import com.ashindigo.lux.tileentities.LuxAbsorberTE;
import com.ashindigo.lux.tileentities.LuxStoreTestTE;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Lux implements ModInitializer {

    public static final String MODID = "lux";
    static LuxAbsorber luxAbsorber;
    public static BlockEntityType<LuxAbsorberTE> luxAbsorberTE;
    static LuxStoreTest luxStore;
    public static BlockEntityType<LuxStoreTestTE> luxStoreTE;

    public static final ItemGroup luxGroup = FabricItemGroupBuilder.build(new Identifier(MODID, MODID), () -> new ItemStack(luxAbsorber, 1));

    @Override
    public void onInitialize() {
        // Lux Absorber
        luxAbsorber = new LuxAbsorber(FabricBlockSettings.of(Material.METAL).strength(3F, 3F).build());
        Registry.register(Registry.BLOCK, new Identifier(MODID, "luxabsorber"), luxAbsorber);
        Registry.register(Registry.ITEM, new Identifier(MODID, "luxabsorber"), new BlockItem(luxAbsorber, new Item.Settings().group(luxGroup)));
        luxAbsorberTE = BlockEntityType.Builder.create(LuxAbsorberTE::new, luxAbsorber).build(null);
        Registry.register(Registry.BLOCK_ENTITY, new Identifier(MODID, "luxabsorber"), luxAbsorberTE);
        // Lux Store
        luxStore = new LuxStoreTest(FabricBlockSettings.of(Material.METAL).strength(3F, 3F).build());
        Registry.register(Registry.BLOCK, new Identifier(MODID, "luxstore"), luxStore);
        Registry.register(Registry.ITEM, new Identifier(MODID, "luxstore"), new BlockItem(luxStore, new Item.Settings().group(luxGroup)));
        luxStoreTE = BlockEntityType.Builder.create(LuxStoreTestTE::new, luxStore).build(null);
        Registry.register(Registry.BLOCK_ENTITY, new Identifier(MODID, "luxstore"), luxStoreTE);
    }
}
