package ru.mkdata.ocenergyadapter.Block.Tail;

import cofh.redstoneflux.api.IEnergyHandler;
import li.cil.oc.api.machine.Arguments;
import li.cil.oc.api.machine.Callback;
import li.cil.oc.api.machine.Context;
import li.cil.oc.api.network.SimpleComponent;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraftforge.fml.common.Optional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mikhail
 * block energy handler tail
 */
@Optional.Interface(iface = "li.cil.oc.api.network.SimpleComponent", modid = "opencomputers")
public class BlockEnergyHandlerTail extends TileEntity implements SimpleComponent, ITickable {
    double stored = 0.0;
    double maxEnergy = 0.0;

    @Override
    public String getComponentName() {
        return "ocenergyadapter";
    }

    @Callback
    @Optional.Method(modid = "opencomputers")
    public Object[] getEnergyStored(Context context, Arguments args) {
        return new Object[]{stored};
    }

    @Callback
    @Optional.Method(modid = "opencomputers")
    public Object[] getMaxEnergyStored(Context context, Arguments args) {
        return new Object[]{maxEnergy};
    }

    @Override
    public void update() {
        List<TileEntity> tileEntityList = new ArrayList<>();
        tileEntityList.add(this.world.getTileEntity(this.pos.up()));
        tileEntityList.add(this.world.getTileEntity(this.pos.down()));
        tileEntityList.add(this.world.getTileEntity(this.pos.west()));
        tileEntityList.add(this.world.getTileEntity(this.pos.south()));
        tileEntityList.add(this.world.getTileEntity(this.pos.east()));
        tileEntityList.add(this.world.getTileEntity(this.pos.north()));
        for (TileEntity ent : tileEntityList) {
            if (ent instanceof IEnergyHandler) {
                IEnergyHandler UpEntity = ((IEnergyHandler) ent);
                stored = UpEntity.getEnergyStored(null);
                maxEnergy = UpEntity.getMaxEnergyStored(null);
            }
        }
    }
}