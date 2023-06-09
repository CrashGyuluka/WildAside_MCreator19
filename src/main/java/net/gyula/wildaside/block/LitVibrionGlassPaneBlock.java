
package net.gyula.wildaside.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class LitVibrionGlassPaneBlock extends IronBarsBlock {
	public LitVibrionGlassPaneBlock() {
		super(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_YELLOW).sound(SoundType.GLASS).strength(0.4f).lightLevel(s -> 7).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}
}
