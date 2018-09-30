package com.monkeybee11.monkeysmod.tabs;

import com.monkeybee11.monkeysmod.monkeysmod;
import com.monkeybee11.monkeysmod.init.TutorialItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TutorialTab extends CreativeTabs {

	public TutorialTab(String name) {
		super(monkeysmod.MODID + "." + name);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(TutorialItems.BASIC_ITEM);
	}
}
