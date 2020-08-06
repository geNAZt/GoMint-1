/*
 * Copyright (c) 2018 Gomint team
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.world.block;

import io.gomint.world.block.data.BlockColor;

/**
 * @author geNAZt
 * @version 1.0
 */
public interface BlockGlazedTerracotta extends BlockFacing {

    /**
     * Set the color of this block
     *
     * @param color of this block
     */
    void setColor( BlockColor color );

    /**
     * Get the color of this block
     *
     * @return color of this block
     */
    BlockColor getColor();

}
