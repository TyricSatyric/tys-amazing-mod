package io.github.gggamesxdlol.tys_amazing_mod;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class TysAmazingModRenderers {
	public static void register()
	{
		EntityRendererRegistry.register(TysAmazingModEntities.BESTEST_ITEM_ENTITY, (FlyingItemEntityRenderer::new));
	}
}
