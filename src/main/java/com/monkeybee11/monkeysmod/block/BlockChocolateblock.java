package com.monkeybee11.monkeysmod.block;

import com.monkeybee11.monkeysmod.monkeysmod;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockChocolateblock extends Block {
	
	public BlockChocolateblock(Material material, String unlocalizedName, String registryName)
	{
		this(material, SoundType.SNOW, unlocalizedName, registryName);
	}
	
	public BlockChocolateblock(Material material, SoundType sound, String unlocalizedname, String registryName)
	{
		super(material);
		setUnlocalizedName(monkeysmod.MODID + "." + unlocalizedname);
		setRegistryName(registryName);
		setCreativeTab(monkeysmod.TUTORIAL_TAB);
		setSoundType(sound);
	}
}
