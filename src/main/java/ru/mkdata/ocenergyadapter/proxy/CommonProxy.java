package ru.mkdata.ocenergyadapter.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import ru.mkdata.ocenergyadapter.Block.Register.BlockEnergyHandlerRegister;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        BlockEnergyHandlerRegister.register();
    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }

}