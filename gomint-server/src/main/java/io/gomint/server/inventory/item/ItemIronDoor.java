package io.gomint.server.inventory.item;
import io.gomint.inventory.item.ItemType;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.taglib.NBTTagCompound;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 330 )
public class ItemIronDoor extends ItemStack implements io.gomint.inventory.item.ItemIronDoor {



    @Override
    public int getBlockId() {
        return 71;
    }

    @Override
    public ItemType getType() {
        return ItemType.IRON_DOOR;
    }

}
