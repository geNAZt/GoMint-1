/*
 * Copyright (c) 2018 Gomint team
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.world.block;

/**
 * @author geNAZt
 * @version 1.0
 */
public interface BlockSlab extends Block {

    /**
     * Is this slab on the top part of the block
     *
     * @return true if top, false if not
     */
    boolean isTop();

    /**
     * Set this slab to the top or bottom
     *
     * @param top if true this slab if on the top, false on the bottom
     */
    void setTop( boolean top );

}
