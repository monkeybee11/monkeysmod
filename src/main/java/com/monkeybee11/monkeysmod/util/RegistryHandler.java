package com.monkeybee11.monkeysmod.util;

import com.monkeybee11.monkeysmod.block.BlockBasic;
import com.monkeybee11.monkeysmod.block.BlockBananaBunch;
import com.monkeybee11.monkeysmod.block.BlockChocolateblock;
import com.monkeybee11.monkeysmod.init.TutorialBlocks;
import com.monkeybee11.monkeysmod.item.ItemBananaPicker;
import com.monkeybee11.monkeysmod.item.Banana;
import com.monkeybee11.monkeysmod.item.BananaPeel;
import com.monkeybee11.monkeysmod.item.BasicItem;
import com.monkeybee11.monkeysmod.item.ItemTutorialArmor;
import com.monkeybee11.monkeysmod.item.ItemTutorialAxe;
import com.monkeybee11.monkeysmod.item.ItemTutorialHoe;
import com.monkeybee11.monkeysmod.item.ItemTutorialPickaxe;
import com.monkeybee11.monkeysmod.item.ItemTutorialShovel;
import com.monkeybee11.monkeysmod.item.ItemTutorialSword;
import com.monkeybee11.monkeysmod.materials.TutorialMaterials;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler {

	@SubscribeEvent
	public static void registerBlocks(Register<Block> event) {
		final Block[] blocks = { new BlockBasic(Material.ROCK, "blockBasic", "basic_block"),
				new BlockBananaBunch(Material.PLANTS, "bananabunch", "banana_bunch"),
				new BlockChocolateblock(Material.SNOW, "chocolateblock", "chocolate_block") };

		event.getRegistry().registerAll(blocks);
	}
	@SubscribeEvent
	public static void registerItems(Register<Item> event) {
		final Item[] item = { new BasicItem("itemBasic", "Basic_item"),
				new ItemTutorialAxe(TutorialMaterials.TUTORIAL_TOOL, "axeTutorial", "tutorial_axe"),
				new ItemTutorialPickaxe(TutorialMaterials.TUTORIAL_TOOL, "pickaxeTutorial", "tutorial_pickaxe"),
				new ItemTutorialHoe(TutorialMaterials.TUTORIAL_TOOL, "hoeTutorial", "tutorial_hoe"),
				new ItemTutorialShovel(TutorialMaterials.TUTORIAL_TOOL, "shovelTutorial", "tutorial_shovel"),
				new ItemTutorialSword(TutorialMaterials.TUTORIAL_TOOL, "swordTutorial", "tutorial_sword"),
				new ItemTutorialArmor(TutorialMaterials.TUTORIAL_ARMOR, EntityEquipmentSlot.HEAD, "helmetTutorial",
						"tutorial_helmet"),
				new ItemTutorialArmor(TutorialMaterials.TUTORIAL_ARMOR, EntityEquipmentSlot.CHEST, "chestplateTutorial",
						"tutorial_chestplate"),
				new ItemTutorialArmor(TutorialMaterials.TUTORIAL_ARMOR, EntityEquipmentSlot.LEGS, "leggingsTutorial",
						"tutorial_leggings"),
				new ItemTutorialArmor(TutorialMaterials.TUTORIAL_ARMOR, EntityEquipmentSlot.FEET, "bootsTutorial",
						"tutorial_boots"),
				new ItemBananaPicker("bananapicker", "banana_picker"),
				new Banana("banana", "banana", 5, 0.f, false),
				new BananaPeel("PeelBanana","Banana_peel")};

		final Item[] itemBlocks = {
				new ItemBlock(TutorialBlocks.BASIC_BLOCK).setRegistryName(TutorialBlocks.BASIC_BLOCK.getRegistryName()),
     			new ItemBlock(TutorialBlocks.BANANA_BUNCH).setRegistryName(TutorialBlocks.BANANA_BUNCH.getRegistryName()),
				new ItemBlock(TutorialBlocks.CHOCOLATE_BLOCK)
						.setRegistryName(TutorialBlocks.CHOCOLATE_BLOCK.getRegistryName()) };

		event.getRegistry().registerAll(item);
		event.getRegistry().registerAll(itemBlocks);
	
}
}
