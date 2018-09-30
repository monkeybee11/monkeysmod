package com.monkeybee11.monkeysmod.item;

import com.monkeybee11.monkeysmod.monkeysmod;

import net.minecraft.item.ItemHoe;

public class ItemTutorialHoe extends ItemHoe {

	public ItemTutorialHoe(ToolMaterial material, String unlocalizedName, String registryName) {
		super(material);

		setUnlocalizedName(monkeysmod.MODID + "." + unlocalizedName);
		setRegistryName(registryName);
		setCreativeTab(monkeysmod.TUTORIAL_TAB);
	}
}