package io.github.TyricSatyric.tys_amazing_mod;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import java.util.List;

public class TysAmazingModBlocks {
	public static final ChangingToolBlock CHANGING_BLOCK = new ChangingToolBlock(
		List.of(BlockTags.AXE_MINEABLE, BlockTags.PICKAXE_MINEABLE), QuiltBlockSettings.create()
		.requiresTool()
		.ticksRandomly()
		.strength(2f));


	public static void register(ModContainer mod)
	{
		Registry.register(Registries.BLOCK, new Identifier(mod.metadata().id(), "changing_block"), CHANGING_BLOCK);
		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "changing_block"), new BlockItem(CHANGING_BLOCK, new QuiltItemSettings()));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.OPERATOR_UTILITIES).register(entries -> {
			entries.addItem(CHANGING_BLOCK.asItem());
		});
	}
}
