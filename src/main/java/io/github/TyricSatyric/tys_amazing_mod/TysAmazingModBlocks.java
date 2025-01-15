package io.github.TyricSatyric.tys_amazing_mod;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import java.util.ArrayList;
import java.util.Arrays;

public class TysAmazingModBlocks {
	public static final ChangingToolBlock TEST_BLOCK = new ChangingToolBlock(
		(ArrayList<net.minecraft.registry.tag.TagKey<net.minecraft.block.Block>>)
			Arrays.asList(BlockTags.AXE_MINEABLE, BlockTags.PICKAXE_MINEABLE),
		QuiltBlockSettings.create());
	public static void register(ModContainer mod)
	{
		Registry.register(Registries.BLOCK, new Identifier(mod.metadata().id(), "changing_block"), TEST_BLOCK);
		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "changing_block"), new BlockItem(TEST_BLOCK, new QuiltItemSettings()));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.OPERATOR_UTILITIES).register(entries -> {
			entries.addItem(TEST_BLOCK.asItem());
		});
	}
}
