package io.gomint.server.inventory.item;
import io.gomint.inventory.item.ItemType;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.taglib.NBTTagCompound;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 397 )
public class ItemSkull extends ItemStack implements io.gomint.inventory.item.ItemSkull {




    @Override
    public int getBlockId() {
        return 144;
    }

    @Override
    public ItemType getType() {
        return ItemType.SKULL;
    }

}
