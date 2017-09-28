package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 221 )
public class OrangeGlazedTerracotta extends Block {

    @Override
    public int getBlockId() {
        return 221;
    }

    @Override
    public long getBreakTime() {
        return 2100;
    }

}
