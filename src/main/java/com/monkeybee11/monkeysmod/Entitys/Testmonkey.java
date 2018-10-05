package com.monkeybee11.monkeysmod.Entitys;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

public class Testmonkey extends EntityMob {

	public Testmonkey(World worldIn) {
		super(worldIn);
		this.setSize(1, 1.8F);
	}

	protected void initEntityAI() {

		this.tasks.addTask(0, new EntityAILookIdle(this));
		this.tasks.addTask(1, new EntityAIWander(this, 0.5d));
		this.targetTasks.addTask(0, new EntityAIAttackMelee(this, 1.0D, true));
	}

	public double getYOFFset() {

		return 0.1F;
	}

	protected void applyEntityAttributes() {

		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.0D);
	}

	// this is to check if animal / monster can brake crops

	protected boolean canTriggerWalking() {
		return false;
	}

	// this is the animal / monsters voice box

	protected SoundEvent getAmbientSound() {

		return SoundEvents.ENTITY_VILLAGER_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource p_184601_1_) {

		return SoundEvents.ENTITY_PLAYER_HURT;
	}

	protected SoundEvent getDeathSound() {

		return SoundEvents.ENTITY_PLAYER_DEATH;
	}

	protected void playStepSound(BlockPos pos, Block blockIn) {

		this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F);
	}

	public boolean attackEntityFrom(DamageSource source, float amount) {

		if (this.isEntityInvulnerable(source)) {

			return false;
		} else {
			return super.attackEntityFrom(source, amount);
		}
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return LootTableList.ENTITIES_BAT;
	}

	public void onUpdate() {
		this.renderYawOffset = this.rotationYaw;
		super.onUpdate();
	}

	public float getBlockPathWeight(BlockPos pos) {

		return this.world.getBlockState(pos.down()).getBlock() == Blocks.STONE ? 10.0F : super.getBlockPathWeight(pos);
	}

	// make sure its not to light

	protected boolean isValidLightLevel() {
		return true;
	}

	// make sure theres room for the monster to teleport in to the world

	public boolean getCanSpawnHere() {

		if (super.getCanSpawnHere()) {
			EntityPlayer entityplayer = this.world.getNearestPlayerNotCreative(this, 5.0D);
			return entityplayer == null;
		} else {
			return false;
		}
	}
}
