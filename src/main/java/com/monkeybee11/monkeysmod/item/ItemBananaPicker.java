package com.monkeybee11.monkeysmod.item;

import java.util.List;

import com.monkeybee11.monkeysmod.monkeysmod;
import com.monkeybee11.monkeysmod.block.BlockBananaBunch;
import com.monkeybee11.monkeysmod.block.IGrowing;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ItemBananaPicker extends Item {

	public ItemBananaPicker(String unlocalizedName, String registryName) {
		setUnlocalizedName(monkeysmod.MODID + "." + unlocalizedName);
		setRegistryName(registryName);
		setCreativeTab(monkeysmod.TUTORIAL_TAB);
	}

	@SubscribeEvent
	public void onPlayerInteract(PlayerInteractEvent.RightClickBlock event) {
		final IBlockState blockState = event.getWorld().getBlockState(event.getPos());
		
		if(event.getEntityPlayer() == null)
			return;

		
		if (!(blockState.getBlock() instanceof BlockBananaBunch))
			return;
		
		if (canPickBanana(blockState)) {
			if (!event.getWorld().isRemote)
				pickFruit(blockState, event.getEntityPlayer(), event.getWorld(), event.getPos());
			event.getEntityPlayer().swingArm(EnumHand.MAIN_HAND);
		}
	}
	private static boolean canPickBanana(IBlockState blockState) {
		if (!(blockState.getBlock() instanceof BlockBananaBunch))
			return false;
		final IGrowing blockPamFruit = (IGrowing) blockState.getBlock();
		return blockPamFruit.isFullygrown(blockState);
	}

	private static void pickFruit(IBlockState blockState, EntityPlayer player, World world, BlockPos blockPos) {
		final IGrowing blockPamFruit = (IGrowing) blockState.getBlock();

		final ItemStack stack = player.getHeldItemMainhand();
		final int fortune = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, stack);
		final List<ItemStack> drops = blockPamFruit.getDrops(world, blockPos, blockState, fortune);

		ForgeEventFactory.fireBlockHarvesting(drops, world, blockPos, blockState, fortune, 1f, false, player);

		if (BlockBananaBunch.fruitRemoval) {
			world.setBlockToAir(blockPos);
		} else {
			world.setBlockState(blockPos, blockState.withProperty(blockPamFruit.getAgeProperty(), 0), 3);
		}

		for (ItemStack drop : drops) {
			dropItem(drop, world, blockPos);
		}
	}

	private static void dropItem(ItemStack itemStack, World world, BlockPos pos) {
		if (world.restoringBlockSnapshots || world.isRemote)
			return;

		float f = 0.5F;
		double d0 = (world.rand.nextFloat() * f) + 0.25D;
		double d1 = (world.rand.nextFloat() * f) + 0.25D;
		double d2 = (world.rand.nextFloat() * f) + 0.25D;

		final EntityItem entityItem = new EntityItem(world, pos.getX() + d0, pos.getY() + d1, pos.getZ() + d2,
				itemStack);
		entityItem.setDefaultPickupDelay();
		world.spawnEntity(entityItem);
	}
}
