package com.monkeybee11.monkeysmod.block;

import com.monkeybee11.monkeysmod.monkeysmod;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
 
public class BlockBasic extends Block {
 
    public BlockBasic(Material material, String unlocalizedName, String registryName) {
        this(material, SoundType.STONE, unlocalizedName, registryName);
    }
 
    public BlockBasic(Material material, SoundType sound, String unlocalizedName, String registryName) {
        super(material);
        setUnlocalizedName(monkeysmod.MODID + "." + unlocalizedName);
        setRegistryName(registryName);
        setCreativeTab(monkeysmod.TUTORIAL_TAB);
        setSoundType(sound);
    }
 
}