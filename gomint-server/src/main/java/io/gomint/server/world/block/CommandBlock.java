package io.gomint.server.world.block;

import io.gomint.server.entity.tileentity.BannerTileEntity;
import io.gomint.server.entity.tileentity.CommandBlockTileEntity;
import io.gomint.server.entity.tileentity.TileEntity;
import io.gomint.taglib.NBTTagCompound;
import io.gomint.world.block.BlockCommandBlock;
import io.gomint.world.block.BlockType;

import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( sId = "minecraft:command_block" )
public class CommandBlock extends ContainerBlock implements BlockCommandBlock {

    @Override
    public String getBlockId() {
        return "minecraft:command_block";
    }

    @Override
    public float getBlastResistance() {
        return 1.8E7f;
    }

    @Override
    public BlockType getBlockType() {
        return BlockType.COMMAND_BLOCK;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

    @Override
    public boolean needsTileEntity() {
        return true;
    }

    @Override
    TileEntity createTileEntity( NBTTagCompound compound ) {
        super.createTileEntity( compound );
        return this.tileEntities.construct(CommandBlockTileEntity.class, compound, this, this.items);
    }

}
