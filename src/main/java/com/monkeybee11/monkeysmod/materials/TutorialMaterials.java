package com.monkeybee11.monkeysmod.materials;

import com.monkeybee11.monkeysmod.monkeysmod;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class TutorialMaterials {
  //keeping this for refrance if more tools need it                            (name, harvestLevel, maxUses, efficiency, damage, enchantability); 
	public static final ToolMaterial TUTORIAL_TOOL = EnumHelper.addToolMaterial(monkeysmod.MODID + ":" + "tutorial_tool", 2, 400, 6, 5, 9);
    
}
