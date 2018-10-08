package com.monkeybee11.monkeysmod.block;

import java.util.List;

import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public interface IGrowing {
	
	int getFullyGrown();
	boolean isFullygrown(IBlockState state);
	default List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		NonNullList<ItemStack> ret = NonNullList.create();
		getDrops(ret, world, pos, state, fortune);
		return ret;
	}
	
	void getDrops(NonNullList<ItemStack> ret, IBlockAccess world, BlockPos pos, IBlockState state, int fortune);
	
	PropertyInteger getAgeProperty();

}
