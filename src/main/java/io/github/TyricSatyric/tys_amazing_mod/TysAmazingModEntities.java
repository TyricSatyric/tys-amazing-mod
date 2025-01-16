package io.github.TyricSatyric.tys_amazing_mod;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

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

