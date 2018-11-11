package com.monkeybee11.monkeysmod.item;

import com.monkeybee11.monkeysmod.monkeysmod;
import com.monkeybee11.monkeysmod.init.TutorialItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class ItemBrush extends Item {

	public ItemBrush(String unlocalizedName, String registryName) {
		setUnlocalizedName(monkeysmod.MODID + "." + unlocalizedName);
		setRegistryName(registryName);
		setCreativeTab(monkeysmod.TUTORIAL_TAB);
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer playerIn, Entity entity) {

		ItemStack itemStack = playerIn.getHeldItemMainhand();
		ItemStack IItemStack = playerIn.getHeldItemOffhand();
		if (itemStack.getItem() == TutorialItems.ITEM_BRUSH)
			if (IItemStack.getItem() == Items.WATER_BUCKET) {

				for (int a =0; a<6; a++) {
					onUsingTick(getDefaultInstance(), playerIn, 6);
					DamageSource source = DamageSource.GENERIC;
					entity.attackEntityFrom(source, 2);
				}
				

			}
		return true;
	}
}
