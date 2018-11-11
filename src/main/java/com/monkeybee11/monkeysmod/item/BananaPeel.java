package com.monkeybee11.monkeysmod.item;

import com.monkeybee11.monkeysmod.monkeysmod;
import com.monkeybee11.monkeysmod.init.TutorialItems;

import net.minecraft.item.Item;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BananaPeel extends Item {
	
	public BananaPeel(String unlocalizedName, String registryName) {
		setUnlocalizedName(monkeysmod.MODID + "." + unlocalizedName);
		setRegistryName(registryName);
		setCreativeTab(monkeysmod.TUTORIAL_TAB);}
	
	@SubscribeEvent
	public void onItemPickedUp(EntityItemPickupEvent event) {        
           if (Item.getItemById(0) == TutorialItems.BANANA_PEEL) {
			onItemPickedUp(event);
			event.getEntityPlayer().motionX = 10;
			

		}
	}
}