package net.gyula.wildaside.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.gyula.wildaside.init.WildasideModGameRules;
import net.gyula.wildaside.init.WildasideModBlocks;

import java.util.Map;

public class SubstiliumTreeGrowerUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		boolean canPlace = false;
		double canPlaceLoop = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double i = 0;
		double height = 0;
		if (world.getLevelData().getGameRules().getBoolean(WildasideModGameRules.WILDASIDEDEBUGMODE) == false) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = Blocks.CAVE_AIR.defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 2, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 3, z))) {
				if (Math.random() >= 0.3) {
					i = 0;
					canPlaceLoop = 0;
					canPlace = true;
					height = Mth.nextInt(RandomSource.create(), 6, 12);
					for (int index0 = 0; index0 < (int) height; index0++) {
						canPlaceLoop = canPlaceLoop + 1;
						if (world.getBlockState(BlockPos.containing(x, y + canPlaceLoop, z)).canOcclude()) {
							canPlace = false;
						}
					}
					if (canPlace == true) {
						for (int index1 = 0; index1 < (int) height; index1++) {
							world.setBlock(BlockPos.containing(x, y + i, z), WildasideModBlocks.SUBSTILIUM_STEM.get().defaultBlockState(), 3);
							i = i + 1;
						}
						sx = -1;
						found = false;
						for (int index2 = 0; index2 < 3; index2++) {
							sy = height / 3;
							for (int index3 = 0; index3 < (int) (height - height / 3); index3++) {
								sz = -1;
								for (int index4 = 0; index4 < 3; index4++) {
									if (Math.random() >= 0.69) {
										if (!world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).canOcclude()) {
											if (Math.random() >= 0.15) {
												world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), WildasideModBlocks.VIBRION_BLOCK.get().defaultBlockState(), 3);
											} else {
												world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), WildasideModBlocks.VIBRION_GEL.get().defaultBlockState(), 3);
											}
										}
									}
									sz = sz + 1;
								}
								sy = sy + 1;
							}
							sx = sx + 1;
						}
						if (!world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).canOcclude()) {
							world.setBlock(BlockPos.containing(x, y + height, z), WildasideModBlocks.VIBRION_BLOCK.get().defaultBlockState(), 3);
						}
					}
				} else {
					canPlace = true;
					for (int index5 = 0; index5 < (int) height; index5++) {
						canPlaceLoop = canPlaceLoop + 1;
						if (world.getBlockState(BlockPos.containing(x, y + canPlaceLoop, z)).canOcclude()) {
							canPlace = false;
						}
					}
					if (canPlace == true) {
						if (Math.random() >= 0.35) {
							if (Math.random() >= 0.6) {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("wildaside", "substilium_mushroom_1"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y, z - 2), BlockPos.containing(x - 2, y, z - 2),
												new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							} else if (Math.random() >= 0.6) {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("wildaside", "substilium_mushroom_2"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y, z - 2), BlockPos.containing(x - 2, y, z - 2),
												new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							} else {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("wildaside", "substilium_mushroom_3"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y, z - 2), BlockPos.containing(x - 2, y, z - 2),
												new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							}
						} else {
							if (Math.random() >= 0.7) {
								if (Math.random() >= 0.5) {
									if (world instanceof ServerLevel _serverworld) {
										StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("wildaside", "taller_substilium_shroom_tree"));
										if (template != null) {
											template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y, z - 2), BlockPos.containing(x - 2, y, z - 2),
													new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
										}
									}
								} else {
									if (world instanceof ServerLevel _serverworld) {
										StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("wildaside", "taller_substilium_shroom_tree_2"));
										if (template != null) {
											template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y, z - 2), BlockPos.containing(x - 2, y, z - 2),
													new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
										}
									}
								}
							} else {
								if (Math.random() >= 0.5) {
									if (world instanceof ServerLevel _serverworld) {
										StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("wildaside", "tallest_substilium_shroom_tree_2"));
										if (template != null) {
											template.placeInWorld(_serverworld, BlockPos.containing(x - 3, y, z - 3), BlockPos.containing(x - 3, y, z - 3),
													new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
										}
									}
								} else {
									if (world instanceof ServerLevel _serverworld) {
										StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("wildaside", "tallest_substilium_shroom_tree_1"));
										if (template != null) {
											template.placeInWorld(_serverworld, BlockPos.containing(x - 3, y, z - 3), BlockPos.containing(x - 3, y, z - 3),
													new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
