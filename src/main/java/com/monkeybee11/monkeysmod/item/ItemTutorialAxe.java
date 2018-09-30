package com.monkeybee11.monkeysmod.item;

import com.monkeybee11.monkeysmod.monkeysmod;

import net.minecraft.item.ItemAxe;

public class ItemTutorialAxe extends ItemAxe {

    public ItemTutorialAxe(ToolMaterial material, float damage, float speed, String unlocalizedName, String registryName) {
        super(material, damage, speed);

		setUnlocalizedName(monkeysmod.MODID + "." + unlocalizedName);
		setRegistryName(registryName);
	    setCreativeTab(monkeysmod.TUTORIAL_TAB);
	}

	public ItemTutorialAxe(ToolMaterial material, String unlocalizedName, String registryName) {
		this(material, 8.0F, -3.1F, unlocalizedName, registryName);
	}
}