package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 229 )
public class CyanGlazedTerracotta extends Block {

    @Override
    public int getBlockId() {
        return 229;
    }

    @Override
    public long getBreakTime() {
        return 2100;
    }

}
