package io.github.gggamesxdlol.tys_amazing_mod;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.item.setting.api.CustomDamageHandler;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import java.util.Random;


public class TysAmazingModItems {
	public static final Item BESTEST_ITEM = new BestestItem(new QuiltItemSettings()
		.maxCount(43)
		.rarity(Rarity.EPIC));
	//I have no idea what I'm doing
	public static void register(ModContainer mod)
	{
		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "bestest_item"), BESTEST_ITEM);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries ->
		{
			entries.addItem(BESTEST_ITEM);
		});
	}
}
