package com.monkeybee11.monkeysmod;

import org.apache.logging.log4j.Logger;

import com.monkeybee11.monkeysmod.proxy.IProxy;
import com.monkeybee11.monkeysmod.proxy.ServerProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = monkeysmod.MODID, name = monkeysmod.NAME, version = monkeysmod.VERSION, acceptedMinecraftVersions = monkeysmod.MC_VERSION)
public class monkeysmod {


    public static final String MODID = "monkeysmod";
    public static final String NAME = "monkeysmod";
    public static final String VERSION = "1.0";
	public static final String MC_VERSION = "[1.12.2]";
	
	public static final String CLIENT = "com.monkeybee11.monkeysmod.proxy.ClientProxy";
	public static final String SERVER = "com.monkeybee11.monkeysmod.proxy.ServerProxy";
	
	@SidedProxy(clientSide = monkeysmod.CLIENT, serverSide = monkeysmod.SERVER)
	public static IProxy proxy;

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
	    logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
	    logger.info("monkeysmod.NAME" + "say hi!");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

}