package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.taglib.NBTTagCompound;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:brick_stairs", id = 108)
public class ItemBrickStairs extends ItemStack implements io.gomint.inventory.item.ItemBrickStairs {

    @Override
    public ItemType getItemType() {
        return ItemType.BRICK_STAIRS;
    }

}
