package com.monkeybee11.monkeysmod.item;

import com.monkeybee11.monkeysmod.monkeysmod;
import com.monkeybee11.monkeysmod.init.TutorialItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class BasicItem extends Item {

	public BasicItem(String unlocalizedName, String registryName) {
		setUnlocalizedName(monkeysmod.MODID + "." + unlocalizedName);
		setRegistryName(registryName);
		setCreativeTab(monkeysmod.TUTORIAL_TAB);}

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

    	ItemStack itemStack = playerIn.getHeldItem(handIn);
		itemStack.setCount(itemStack.getCount() - 1);
		playerIn.inventory.addItemStackToInventory(new ItemStack(TutorialItems.BANANA, 1));
		return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
	}
}
	
	



