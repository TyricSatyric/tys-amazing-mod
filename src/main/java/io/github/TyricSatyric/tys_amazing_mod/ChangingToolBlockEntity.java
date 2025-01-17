package io.github.TyricSatyric.tys_amazing_mod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class ChangingToolBlockEntity extends BlockEntity {
	public static BlockPos pos;
	List<TagKey<Block>> effectiveTools;
	public TagKey<Block> currentEffectiveTool;
	private int resetTimer = 200;
	public int timerInterval = 0;
	public int timer = 0;
	public int amountOfTools = 0;
	public ChangingToolBlockEntity(BlockPos pos, BlockState state) {
		super(TysAmazingModBlockEntities.CHANGING_BLOCK, pos, state);
		ChangingToolBlockEntity.pos = pos;
		this.effectiveTools = ChangingToolBlock.effectiveTools;
		amountOfTools = effectiveTools.size();
		timerInterval = resetTimer;
		resetTimer *= amountOfTools;
		timer = 1;
	}

	public boolean isCurrentToolUseful(TagKey<Block> usedTool)
	{
		currentEffectiveTool = effectiveTools.get((int) Math.floor(((double)timer/(double)timerInterval)));

		return usedTool == currentEffectiveTool;

	}

	public static void tick(World world, BlockPos pos, BlockState state, ChangingToolBlockEntity blockEntity) {
		blockEntity.timer++;
		if (blockEntity.timer == blockEntity.resetTimer)
			blockEntity.timer = 1;
	}


}
