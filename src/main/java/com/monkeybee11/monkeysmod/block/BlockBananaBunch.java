package com.monkeybee11.monkeysmod.block;

import java.util.Random;

import javax.annotation.Nullable;

import com.monkeybee11.monkeysmod.monkeysmod;
import com.monkeybee11.monkeysmod.init.TutorialItems;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBananaBunch extends Block implements IGrowable, IGrowing {

	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 2);

	public static boolean fruitRemoval = false;

	public BlockBananaBunch(Material material, String unlocalizedName, String registryName) {
		super(material);
		setUnlocalizedName(monkeysmod.MODID + "." + unlocalizedName);
		setRegistryName(registryName);
		setCreativeTab(monkeysmod.TUTORIAL_TAB);
		this.setTickRandomly(true);
	};

	@Override
	public PropertyInteger getAgeProperty() {
		return AGE;
	}

	@Override
	public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
		if (getMetaFromState(blockState) >= 2) {
			return 0f;
		}
		return 5f;
	}

	@Override
	public int getFullyGrown() {
		return 2;
	}

	@Override
	public boolean isFullygrown(IBlockState state) {
		return getMetaFromState(state) >= 2;
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos) {
		return NULL_AABB;
	}

	public void neighborChange(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (!this.isPlantedright(worldIn, pos)) {
			this.dropBlock(worldIn, pos, state);
		}
	}

	private boolean isPlantedright(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos.up()).getMaterial().isSolid();
	}

	private void dropBlock(World worldIn, BlockPos pos, IBlockState state) {
		if (!(state.getValue(AGE) != 3)) {

		}
		worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
		this.dropBlockAsItem(worldIn, pos, state, 0);
	}

	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state,
			int fortune) {
		if (getMetaFromState(state) >= 2) {
			if (!fruitRemoval) {
				drops.add(new ItemStack(Items.AIR, 1));
			}
			drops.add(new ItemStack(TutorialItems.BASIC_ITEM, 6));
		}
	}

	@Override
	public boolean canPlaceBlockAt(World world, BlockPos pos) {
		final Block leafBlock = world.getBlockState(pos.up()).getBlock();
		return isUnderTreeLeaf(leafBlock);
	}

	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn) {
		validatePosition(worldIn, pos);
	}

	public void validatePosition(World world, BlockPos pos) {

		if (!this.canPlaceBlockAt(world, pos)) {
			world.setBlockToAir(pos);
		}
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	private boolean isUnderTreeLeaf(Block leafBlock) {
		return leafBlock == Blocks.LEAVES;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(AGE, meta);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(AGE);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, AGE);
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		int x = state.getValue(AGE);

		if (x < 2) {
			state = state.withProperty(AGE, x + 1);
			worldIn.setBlockState(pos, state, 2);
		}

		super.updateTick(worldIn, pos, state, rand);

	}

	private void grow(World worldIn, BlockPos pos, IBlockState state) {
		int m = state.getValue(AGE) + MathHelper.getInt(worldIn.rand, 1, 2);
		if(m > 2) {
			m = 2;
		}
		worldIn.setBlockState(pos, state.withProperty(AGE, m), 2);
	}

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return state.getValue(AGE) < 2;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return true;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		this.grow(worldIn, pos, state);
	}

}