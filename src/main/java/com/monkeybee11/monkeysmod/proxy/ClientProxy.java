package com.monkeybee11.monkeysmod.proxy;

import com.monkeybee11.monkeysmod.init.ModEvent;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
 
public class ClientProxy implements IProxy {
 
    public void preInit(FMLPreInitializationEvent event) {
    	    
    }

    public void init(FMLInitializationEvent event) {
    	ModEvent.init();
    	
    }
 
    public void postInit(FMLPostInitializationEvent event) {
 
    }
 
}