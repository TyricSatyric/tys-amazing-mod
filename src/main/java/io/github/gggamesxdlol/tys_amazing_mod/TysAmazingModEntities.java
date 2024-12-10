package io.github.gggamesxdlol.tys_amazing_mod;

import com.mojang.datafixers.DataFixer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.feature_flags.FeatureFlagBitSet;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.entity.impl.QuiltEntityType;

public class TysAmazingModEntities {
	public static final EntityType<BestestItemEntity> BESTEST_ITEM_ENTITY = Registry.register(
			Registries.ENTITY_TYPE,
			new Identifier(TysAmazingMod.MOD_ID, "bestest_item_entity"),
			EntityType.Builder.<BestestItemEntity>create(BestestItemEntity::new, SpawnGroup.MISC)
				.setDimensions(0.25f, 0.25f)
				.trackingTickInterval(10)
				.maxTrackingRange(4)
				.build("bestest_item_entity")
	);

	public static void register()
	{
		TysAmazingMod.LOGGER.info("Registering");
	}
}

