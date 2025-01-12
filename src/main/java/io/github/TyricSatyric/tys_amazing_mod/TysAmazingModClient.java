package io.github.TyricSatyric.tys_amazing_mod;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

public class TysAmazingModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient(ModContainer mod) {
		TysAmazingModRenderers.register();
	}
}
