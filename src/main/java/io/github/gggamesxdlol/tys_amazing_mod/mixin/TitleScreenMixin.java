package io.github.gggamesxdlol.tys_amazing_mod.mixin;

import io.github.gggamesxdlol.tys_amazing_mod.TysAmazingMod;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {
	@Inject(method = "init", at = @At("TAIL"))
	public void onInit(CallbackInfo ci) {
		TysAmazingMod.LOGGER.info("This line is printed by an example mod mixin!");
	}
}
