package net.gyula.wildaside.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class HangingVibrionVegetationGrowerStr1AdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x, y + 1, z))).getMaterial() == net.minecraft.world.level.material.Material.STONE) {
			if (world.isEmptyBlock(new BlockPos(x, y, z)) && world.isEmptyBlock(new BlockPos(x, y - 1, z)) && world.isEmptyBlock(new BlockPos(x, y - 2, z)) && world.isEmptyBlock(new BlockPos(x, y - 3, z))) {
				return true;
			}
		}
		return false;
	}
}
