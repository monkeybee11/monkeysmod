package com.monkeybee11.monkeysmod.init;

import com.monkeybee11.monkeysmod.monkeysmod;
import com.monkeybee11.monkeysmod.item.Banana;
import com.monkeybee11.monkeysmod.item.BananaPeel;
import com.monkeybee11.monkeysmod.item.BasicItem;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(monkeysmod.MODID)
public class TutorialItems {
	
	public static final Item BASIC_ITEM  = new BasicItem("unlocalizedName","registryName");
	public static final Item TUTORIAL_AXE = null;
	public static final Item TUTORIAL_PICKAXE = null;
	public static final Item TUTORIAL_HOE = null;
	public static final Item TUTORIAL_SHOVEL = null;
	public static final Item TUTORIAL_SWORD = null;
	public static final Item TUTORIAL_HELMET = null;
	public static final Item TUTORIAL_CHESTPLATE = null;
	public static final Item TUTORIAL_LEGGINGS = null;
	public static final Item TUTORIAL_BOOTS = null;
	public static final Item BANANA_PICKER = null;
	public static final Item BANANA = new Banana("unlocalizedName","registryName", 5, 0.3f, false);
	public static final Item BANANA_PEEL = new BananaPeel("unlocalizedName","registryName");
}
