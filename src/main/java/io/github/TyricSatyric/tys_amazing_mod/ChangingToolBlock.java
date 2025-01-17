package io.github.TyricSatyric.tys_amazing_mod;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ChangingToolBlock extends BlockWithEntity implements BlockEntityProvider {
	public static List<TagKey<Block>> effectiveTools;
	public BlockPos pos;
	public World world;
	ChangingToolBlockEntity blockEntity;
	protected ChangingToolBlock(List<TagKey<Block>> effectiveTools, Settings settings) {
		super(settings);
		ChangingToolBlock.effectiveTools = effectiveTools;
	}

	@Nullable
	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		this.pos = pos;
		return new ChangingToolBlockEntity(pos, state);
	}


	@Override
	public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
		super.onPlaced(world, pos, state, placer, itemStack);
		createBlockEntity(pos, state);
	}

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}

	public boolean neededToolIsUseful(TagKey<Block> usedTool, ChangingToolBlock block)
	{

		return blockEntity.currentEffectiveTool == usedTool;
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
		this.world = world;
		return checkType(type, TysAmazingModBlockEntities.CHANGING_BLOCK, ChangingToolBlockEntity::tick);
	}


	public static ActionResult onAttacked(PlayerEntity playerEntity, World world, Hand hand, BlockPos blockPos, Direction direction)
	{
		ChangingToolBlock block = (ChangingToolBlock)world.getBlockState(blockPos).getBlock();
		block.blockEntity = (ChangingToolBlockEntity) world.getBlockEntity(blockPos);

		return ActionResult.PASS;
	}
}
