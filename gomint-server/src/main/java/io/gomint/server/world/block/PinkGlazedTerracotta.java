package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 226 )
public class PinkGlazedTerracotta extends Block {

    @Override
    public int getBlockId() {
        return 226;
    }

    @Override
    public long getBreakTime() {
        return 2100;
    }

}
