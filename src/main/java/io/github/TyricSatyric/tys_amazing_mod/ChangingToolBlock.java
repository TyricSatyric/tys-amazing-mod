package io.github.TyricSatyric.tys_amazing_mod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.client.texture.Sprite;
import net.minecraft.registry.tag.TagFile;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class ChangingToolBlock extends Block {
	public static boolean isPillar = false;
	public static List<TagKey<Block>> effectiveTools;
	public static TagKey<Block> currentEffectiveTool;
	private static int resetTimer = 5;
	public static int timerInterval = 0;
	public static int timer = 0;
	public static int amountOfTools = 0;


	public ChangingToolBlock(List<TagKey<Block>> effectiveTools, Settings settings) {
		super(settings);
		ChangingToolBlock.effectiveTools = effectiveTools;
		amountOfTools = effectiveTools.size();
		timerInterval = resetTimer;
		resetTimer *= amountOfTools;
	}



	public boolean neededToolIsUseful(TagKey<Block> usedTool)
	{
		switch (amountOfTools)
		{
			case 2:
				currentEffectiveTool = effectiveTools.get(timer <= timerInterval ? 0 : 1);
				break;
			case 3:
				currentEffectiveTool = effectiveTools.get(timer <= timerInterval ? 0 : timer <= timerInterval*2? 1 : 2);
                break;
			case 4:
				currentEffectiveTool = effectiveTools.get(timer <= timerInterval ? 0 : timer <= timerInterval*2 ? 1 : timer <= timerInterval*3 ? 2 : 3);
				break;
            default:
				currentEffectiveTool = effectiveTools.get(0);
				break;
		}

		TysAmazingMod.LOGGER.info("{}", currentEffectiveTool);
		TysAmazingMod.LOGGER.info(String.valueOf(timer));
		return usedTool == currentEffectiveTool;
	}


	@Override
	public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, RandomGenerator random) {
		super.scheduledTick(state, world, pos, random);
		if (timer == resetTimer)
			timer = 0;
		timer++;
	}
}
