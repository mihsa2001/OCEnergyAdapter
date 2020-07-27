package ru.mkdata.ocenergyadapter.Block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;
import ru.mkdata.ocenergyadapter.Block.Entity.BlockTileEntity;
import ru.mkdata.ocenergyadapter.Block.Tail.BlockEnergyHandlerTail;

public class BlockEnergyHandler extends BlockTileEntity<BlockEnergyHandlerTail> {

    public BlockEnergyHandler(String name, Material material, float hardness, float resistanse, SoundType soundType) {

        super(name, material, hardness, resistanse, soundType);
        this.setCreativeTab(CreativeTabs.REDSTONE);
        this.setHarvestLevel("pickaxe", 2);
    }


    @Override
    public Class<BlockEnergyHandlerTail> getTileEntityClass() {

        return BlockEnergyHandlerTail.class;
    }

    @Override
    public BlockEnergyHandlerTail createTileEntity(World world, IBlockState blockState) {

        return new BlockEnergyHandlerTail();
    }
}
