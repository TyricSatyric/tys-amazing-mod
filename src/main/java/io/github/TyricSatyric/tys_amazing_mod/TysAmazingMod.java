package io.github.TyricSatyric.tys_amazing_mod;

import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TysAmazingMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("Tys Amazing Mod");
	public static final String MOD_ID = "tys_amazing_mod";

	@Override
	public void onInitialize(ModContainer mod) {

		LOGGER.info("Hello Quilt world from {}!", mod.metadata().name());

		TysAmazingModEntities.register();
		TysAmazingModBlocks.register(mod);
		TysAmazingModItems.register(mod);
	}
}
