package io.github.TyricSatyric.tys_amazing_mod;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ChangingToolBlock extends BlockWithEntity {
	public static List<TagKey<Block>> effectiveTools;
	public static TagKey<Block> currentEffectiveTool;
	private static int resetTimer = 5;
	public static int timerInterval = 0;
	public static int timer = 0;
	public static int amountOfTools = 0;
	protected ChangingToolBlock(List<TagKey<Block>> effectiveTools, Settings settings) {
		super(settings);
		ChangingToolBlock.effectiveTools = effectiveTools;
		amountOfTools = effectiveTools.size();
		timerInterval = resetTimer;
		resetTimer *= amountOfTools;
		timer = 1;
	}

	@Override
	public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new ChangingToolBlockEntity(pos, state);
	}

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}

	public boolean neededToolIsUseful(TagKey<Block> usedTool, World world, BlockPos pos)
	{
		BlockEntity blockEntity = world.getBlockEntity(pos);
		currentEffectiveTool = effectiveTools.get((int) Math.floor(((double)timer/(double)timerInterval)));

		TysAmazingMod.LOGGER.info("{}", currentEffectiveTool);
		TysAmazingMod.LOGGER.info(String.valueOf(timer));
		return usedTool == currentEffectiveTool;
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
		TysAmazingMod.LOGGER.info("Tick");
		timer++;
		if (timer == resetTimer)
			timer = 1;

		return checkType(type, TysAmazingModBlockEntities.CHANGING_BLOCK, ChangingToolBlockEntity::tick);
	}


}
