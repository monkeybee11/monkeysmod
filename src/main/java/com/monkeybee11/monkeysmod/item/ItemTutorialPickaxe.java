package com.monkeybee11.monkeysmod.item;

import com.monkeybee11.monkeysmod.monkeysmod;

import net.minecraft.item.ItemPickaxe;

public class ItemTutorialPickaxe extends ItemPickaxe {

	public ItemTutorialPickaxe(ToolMaterial material, String unlocalizedName, String registryName) {
		super(material);

		setUnlocalizedName(monkeysmod.MODID + "." + unlocalizedName);
		setRegistryName(registryName);
	    setCreativeTab(monkeysmod.TUTORIAL_TAB);
	    
	}
	
}