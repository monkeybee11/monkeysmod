package com.monkeybee11.monkeysmod.fluid;

import com.monkeybee11.monkeysmod.monkeysmod;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class RainbowWater extends Fluid
{
    protected static int mapColor = 0xFFFFFFFF;
    protected static float overlayAlpha = 0.2F;
    protected static SoundEvent emptySound = SoundEvents.ITEM_BUCKET_EMPTY;
    protected static SoundEvent fillSound = SoundEvents.ITEM_BUCKET_FILL;
    protected static Material material = Material.WATER;
 
    public RainbowWater(String fluidName, ResourceLocation still, ResourceLocation flowing) 
    {
        super(fluidName, still, flowing);
    }
 
    public RainbowWater(String fluidName, ResourceLocation still, ResourceLocation flowing, int mapColor) 
    {
        this(fluidName, still, flowing);
        setColor(mapColor);
    }
 
    public RainbowWater(String fluidName, ResourceLocation still, ResourceLocation flowing, int mapColor, float overlayAlpha) 
    {
        this(fluidName, still, flowing, mapColor);
        setAlpha(overlayAlpha);
    }
 
    @Override
    public int getColor()
    {
        return mapColor;
    }
 
    public RainbowWater setColor(int parColor)
    {
        mapColor = parColor;
        return this;
    }
 
    public float getAlpha()
    {
        return overlayAlpha;
    }
 
    public RainbowWater setAlpha(float parOverlayAlpha)
    {
        overlayAlpha = parOverlayAlpha;
        return this;
    }
 
    @Override
    public RainbowWater setEmptySound(SoundEvent parSound)
    {
        emptySound = parSound;
        return this;
    }
 
    @Override
    public SoundEvent getEmptySound()
    {
        return emptySound;
    }
 
    @Override
    public RainbowWater setFillSound(SoundEvent parSound)
    {
        fillSound = parSound;
        return this;
    }
 
    @Override
    public SoundEvent getFillSound()
    {
        return fillSound;
    }
 
    public RainbowWater setMaterial(Material parMaterial)
    {
        material = parMaterial;
        return this;
    }
 
    public Material getMaterial()
    {
        return material;
    }
    
    public static class TutorialMaterials
    
    {
    	
    public final static Material RAINBOWWATER = new MaterialLiquid( MapColor.WATER);
    }
 
    @Override
    public boolean doesVaporize(FluidStack fluidStack)
    {
        if (block == null)
            return false;
        return block.getDefaultState().getMaterial() == getMaterial();
    }
    

    
    @SuppressWarnings("unused")
	private void setCreativeTab(CreativeTabs tutorialTab) {
		setCreativeTab(monkeysmod.TUTORIAL_TAB);
		
	}



	public static final RainbowWater RAINBOWWATER = (RainbowWater) new RainbowWater(
    		   "rainbowwater", 
    		   new ResourceLocation(monkeysmod.MODID,"rainbowwater_still"), 
    		   new ResourceLocation(monkeysmod.MODID, "rainbowwater_still")
    		   )
    		   .setMaterial(TutorialMaterials.RAINBOWWATER)
    		   .setDensity(1100)
    		   .setGaseous(false)
    		   .setLuminosity(14)
    		   .setViscosity(25000)
    		   .setTemperature(300);

static{FluidRegistry.enableUniversalBucket();FluidRegistry.addBucketForFluid(RAINBOWWATER);}

public String getRegistryName() {
	// TODO Auto-generated method stub
	return null;
}


}