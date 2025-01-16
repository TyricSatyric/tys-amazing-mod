package io.github.TyricSatyric.tys_amazing_mod;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class TysAmazingModBlockEntities {
	public static final BlockEntityType<ChangingToolBlockEntity> CHANGING_BLOCK = Registry.register(
		Registries.BLOCK_ENTITY_TYPE,
		new Identifier(TysAmazingMod.MOD_ID, "changing_block"),
			BlockEntityType.Builder.create(ChangingToolBlockEntity::new, TysAmazingModBlocks.CHANGING_BLOCK)
				.build(null)
	);

	public static void register() {
		TysAmazingMod.LOGGER.info("Registering");
	}
}
