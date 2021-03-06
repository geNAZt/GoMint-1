package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.taglib.NBTTagCompound;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:green_glazed_terracotta", id = 233)
public class ItemGreenGlazedTerracotta extends ItemStack implements io.gomint.inventory.item.ItemGreenGlazedTerracotta {

    @Override
    public ItemType getItemType() {
        return ItemType.GREEN_GLAZED_TERRACOTTA;
    }

}
