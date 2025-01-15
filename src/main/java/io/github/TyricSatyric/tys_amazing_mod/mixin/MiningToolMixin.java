package io.github.TyricSatyric.tys_amazing_mod.mixin;

import io.github.TyricSatyric.tys_amazing_mod.ChangingToolBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.Vanishable;
import net.minecraft.registry.tag.TagKey;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(MiningToolItem.class)
public class MiningToolMixin {

	@Shadow
	@Final
	private TagKey<Block> effectiveBlocks;

	@Shadow
	@Final
	protected float miningSpeed;

	/**
	 * @author Tyric
	 * @reason Changes the mining speed multiplier behavior
	 */
	@Overwrite
	public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
		if(state.getBlock() instanceof ChangingToolBlock block)
		{
			return block.neededToolIsUseful(effectiveBlocks) ? this.miningSpeed : 1.0F;
		}
		return state.isIn(this.effectiveBlocks) ? this.miningSpeed : 1.0F;
	}
}
