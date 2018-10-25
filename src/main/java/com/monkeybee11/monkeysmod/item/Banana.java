package com.monkeybee11.monkeysmod.item;

import com.monkeybee11.monkeysmod.monkeysmod;
import com.monkeybee11.monkeysmod.init.TutorialItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Banana extends ItemFood  {
	
	public Banana(String unlocalizedName, String registryName, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(monkeysmod.MODID + "." + unlocalizedName);
		setRegistryName(registryName);
		setCreativeTab(monkeysmod.TUTORIAL_TAB);}
	
	@Override
   public void  onFoodEaten(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
		
           playerIn.inventory.addItemStackToInventory(new ItemStack(TutorialItems.BANANA_PEEL, 1));
			
    }
}