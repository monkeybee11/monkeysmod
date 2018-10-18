package com.monkeybee11.monkeysmod.init;

import net.minecraft.item.ItemFood;

public class itemBanana extends ItemFood {

   public itemBanana(String name, int amount, float saturation, boolean isWolfFood)
   {
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(name);
		setRegistryName(name);
   }

}