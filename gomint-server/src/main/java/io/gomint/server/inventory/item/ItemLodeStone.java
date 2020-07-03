package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author KingAli
 * @version 1.0
 */
@RegisterInfo(id = 477 ,sId = "minecraft:lodestone" )
public class ItemLodeStone extends ItemStack implements io.gomint.inventory.item.ItemLodeStone {

    @Override
    public String getBlockId() {
        return "minecraft:lodestone";
    }

    @Override
    public ItemType getType() {
        return ItemType.LODESTONE;
    }
}