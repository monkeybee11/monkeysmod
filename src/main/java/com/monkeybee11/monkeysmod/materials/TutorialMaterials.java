package com.monkeybee11.monkeysmod.materials;

import com.monkeybee11.monkeysmod.monkeysmod;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class TutorialMaterials {
  //keeping this for refrance if more tools need it                            (name, harvestLevel, maxUses, efficiency, damage, enchantability); 
	public static final ToolMaterial TUTORIAL_TOOL = EnumHelper.addToolMaterial(monkeysmod.MODID + ":" + "tutorial_tool", 2, 400, 6, 5, 9);
 //keeping this for refrance if more tools need it                            (name, textureName, durability, reductionAmounts, enchantability, soundOnEquip, toughness);
	public static final ArmorMaterial TUTORIAL_ARMOR = EnumHelper.addArmorMaterial(monkeysmod.MODID + ":" + "tutorial_armor", monkeysmod.MODID + ":tutorial", 16, new int[]{2, 5, 6, 3}, 5, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0);
}
