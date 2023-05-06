package net.gyula.wildaside.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

public class UpdateStructureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 1, 10));
	}
}
