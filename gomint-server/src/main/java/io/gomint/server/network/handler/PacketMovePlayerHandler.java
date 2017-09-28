package io.gomint.server.network.handler;

import io.gomint.event.player.PlayerMoveEvent;
import io.gomint.math.Location;
import io.gomint.server.entity.EntityPlayer;
import io.gomint.server.network.PlayerConnection;
import io.gomint.server.network.packet.PacketMovePlayer;
import io.gomint.server.world.block.Block;

/**
 * @author geNAZt
 * @version 1.0
 */
public class PacketMovePlayerHandler implements PacketHandler<PacketMovePlayer> {

    @Override
    public void handle( PacketMovePlayer packet, long currentTimeMillis, PlayerConnection connection ) {
        EntityPlayer entity = connection.getEntity();
        Location to = entity.getLocation();
        to.setX( packet.getX() );
        to.setY( packet.getY() - entity.getEyeHeight() ); // Subtract eye height since client sends it at the eyes
        to.setZ( packet.getZ() );
        to.setHeadYaw( packet.getHeadYaw() );
        to.setYaw( packet.getYaw() );
        to.setPitch( packet.getPitch() );

        Location from = entity.getLocation();

        // The packet did not contain any movement? skip it
        if ( from.getX() - to.getX() == 0 &&
                from.getY() - to.getY() == 0 &&
                from.getZ() - to.getZ() == 0 &&
                from.getHeadYaw() - to.getHeadYaw() == 0 &&
                from.getYaw() - to.getYaw() == 0 &&
                from.getPitch() - to.getPitch() == 0 ) {
            return;
        }

        PlayerMoveEvent playerMoveEvent = connection.getNetworkManager().getServer().getPluginManager().callEvent(
                new PlayerMoveEvent( entity, from, to )
        );

        if ( playerMoveEvent.isCancelled() ) {
            playerMoveEvent.setTo( playerMoveEvent.getFrom() );
        }

        to = playerMoveEvent.getTo();
        if ( to.getX() != packet.getX() || to.getY() != packet.getY() - entity.getEyeHeight() || to.getZ() != packet.getZ() ||
                !to.getWorld().equals( entity.getWorld() ) || to.getYaw() != packet.getYaw() ||
                to.getPitch() != packet.getPitch() || to.getHeadYaw() != packet.getHeadYaw() ) {
            entity.teleport( to );
        }

        entity.setPosition( to.getX(), to.getY(), to.getZ() );
        entity.setPitch( to.getPitch() );
        entity.setYaw( to.getYaw() );
        entity.setHeadYaw( to.getHeadYaw() );

        entity.getBoundingBox().setBounds(
                entity.getPositionX() - ( entity.getWidth() / 2 ),
                entity.getPositionY(),
                entity.getPositionZ() - ( entity.getWidth() / 2 ),
                entity.getPositionX() + ( entity.getWidth() / 2 ),
                entity.getPositionY() + entity.getHeight(),
                entity.getPositionZ() + ( entity.getWidth() / 2 )
        );

        if ( (int) from.getX() != (int) to.getX() ||
                (int) from.getZ() != (int) to.getZ() ||
                !to.getWorld().equals( from.getWorld() ) ) {
            connection.checkForNewChunks( from );

            // Check for interaction
            Block block = from.getWorld().getBlockAt( from.toBlockPosition() );
            block.gotOff( entity );

            block = to.getWorld().getBlockAt( to.toBlockPosition() );
            block.stepOn( entity );
        }
    }

}
