package ru.mkdata.ocenergyadapter;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.mkdata.ocenergyadapter.proxy.CommonProxy;

/**
 * @author mikhail
 * main class of modification
 */
@Mod(modid = OCEnergyAdapter.MODID, name = OCEnergyAdapter.NAME, version = OCEnergyAdapter.VERSION)
public class OCEnergyAdapter {
    public static final String MODID = "ocenergyadapter";
    public static final String NAME = "Open Computers energy adapter";
    public static final String VERSION = "1.0";
    @SidedProxy(clientSide = "ru.mkdata.ocenergyadapter.proxy.ClientProxy", serverSide = "ru.mkdata.ocenergyadapter.proxy.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
