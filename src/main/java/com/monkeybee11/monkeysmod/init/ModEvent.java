package com.monkeybee11.monkeysmod.init;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModEvent {
	
	public static void init() {
		MinecraftForge.EVENT_BUS.register(new ModEvent());
	}
	

    @SubscribeEvent
    public void onItemPickedUp(EntityItemPickupEvent event) {
           if (event.getItem().getItem().getItem() == TutorialItems.BANANA_PEEL) {
        	   EntityPlayer EntityPlayer = event.getEntityPlayer();
        	   EntityPlayer.setVelocity(5, .2, 5);
        }
    }
}
