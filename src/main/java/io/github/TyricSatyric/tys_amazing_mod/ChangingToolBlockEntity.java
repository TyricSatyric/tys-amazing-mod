package io.github.TyricSatyric.tys_amazing_mod;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ChangingToolBlockEntity extends BlockEntity {
	public ChangingToolBlockEntity(BlockPos pos, BlockState state) {
		super(TysAmazingModBlockEntities.CHANGING_BLOCK, pos, state);
	}


	public static void tick(World world, BlockPos pos, BlockState state, ChangingToolBlockEntity blockEntity) {

	}


}
