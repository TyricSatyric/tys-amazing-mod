package io.github.TyricSatyric.tys_amazing_mod;

import net.fabricmc.fabric.api.entity.event.v1.EntityElytraEvents;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.resource.Material;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Lazy;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.item.setting.api.CustomDamageHandler;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;
import org.quiltmc.quiltmappings.constants.MiningLevels;

import java.util.Random;
import java.util.function.Supplier;


public class TysAmazingModItems {
	public static final BestestItem BESTEST_ITEM = new BestestItem(new QuiltItemSettings()
		.maxCount(43)
		.rarity(Rarity.EPIC));
	public static final BestestSword BESTEST_SWORD = new BestestSword(TysMaterials.BESTEST_MATERIAL,
		1,
		2147000000,
		new QuiltItemSettings()
			.rarity(Rarity.EPIC));
	public static final BowItem BESTTEST = new BowItem(new QuiltItemSettings());
	//I have no idea what I'm doing
	public static void register(ModContainer mod)
	{
		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "bestest_item"), BESTEST_ITEM);
		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "bestest_sword"), BESTEST_SWORD);
		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "besttest"), BESTTEST);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries ->
		{
			entries.addItem(BESTEST_ITEM);
			entries.addItem(BESTEST_SWORD);
			entries.addItem(BESTTEST);
		});
	}
}

