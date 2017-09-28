package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 220 )
public class WhiteGlazedTerracotta extends Block {

    @Override
    public int getBlockId() {
        return 220;
    }

    @Override
    public long getBreakTime() {
        return 2100;
    }

}
