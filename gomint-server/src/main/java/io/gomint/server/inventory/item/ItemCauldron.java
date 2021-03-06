package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( sId = "minecraft:cauldron", id = 380 )
public class ItemCauldron extends ItemStack implements io.gomint.inventory.item.ItemCauldron {

    @Override
    public ItemType getItemType() {
        return ItemType.CAULDRON;
    }

}
