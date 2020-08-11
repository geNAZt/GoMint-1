/*
 * Copyright (c) 2018 Gomint team
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockType;

@RegisterInfo(sId = "minecraft:bell")
public class Bell extends Block {
    @Override
    public float getBlastResistance() {
        return 0;
    }

    @Override
    public BlockType getBlockType() {
        return BlockType.BELL;
    }
}
