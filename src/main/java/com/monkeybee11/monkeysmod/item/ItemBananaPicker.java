package com.monkeybee11.monkeysmod.item;

import com.monkeybee11.monkeysmod.monkeysmod;
import net.minecraft.item.Item;

public class ItemBananaPicker extends Item {

	public ItemBananaPicker(String unlocalizedName, String registryName) {
		setUnlocalizedName(monkeysmod.MODID + "." + unlocalizedName);
		setRegistryName(registryName);
		setCreativeTab(monkeysmod.TUTORIAL_TAB);
	}
}