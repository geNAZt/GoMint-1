package io.gomint.inventory.item;

import io.gomint.GoMint;
import io.gomint.world.block.data.LogType;

/**
 * @author geNAZt
 * @version 1.0
 * @stability 3
 */
public interface ItemLog extends ItemAxis, ItemBurnable {

    /**
     * Create a new item stack with given class and amount
     *
     * @param amount which is used for the creation
     */
    static ItemLog create( int amount ) {
        return GoMint.instance().createItemStack( ItemLog.class, amount );
    }

    /**
     * Is this log stripped
     *
     * @return true when stripped, false when not
     */
    boolean isStripped();

    /**
     * Set stripped status of this log
     *
     * @param stripped true when the log should be stripped, false if not
     */
    void setStripped( boolean stripped );

    /**
     * Set the type of log
     *
     * @param type of log
     */
    void setLogType( LogType type );

    /**
     * Get the type of this log
     *
     * @return type of log
     */
    LogType getLogType();

    /**
     * Add bark textures to all sides or not
     *
     * @param allSides true when bark on all sides, false if not
     */
    void setBarkOnAllSides( boolean allSides );

    /**
     * Is bark on all sides?
     *
     * @return true when bark is on all sides, false when not
     */
    boolean isBarkOnAllSides();

}
