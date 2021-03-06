/*
 * Copyright (c) 2018 Gomint team
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.test.world;

import io.gomint.server.test.IntegrationTest;
import io.gomint.server.util.collection.FreezableSortedMap;
import io.gomint.server.world.BlockRuntimeIDs;
import io.gomint.server.world.block.Block;
import io.gomint.server.world.block.Log;
import io.gomint.world.World;
import io.gomint.world.WorldType;
import io.gomint.world.block.data.Axis;
import io.gomint.world.block.data.LogType;
import io.gomint.world.generator.CreateOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WorldTest extends IntegrationTest {

    private World world;

    @Test
    @Order(1)
    public void generateNonExisting() {
        this.world = this.server.createWorld("test", new CreateOptions().worldType(WorldType.IN_MEMORY));
    }

    @Test
    @Order(2)
    public void setLog() {
        Block block = this.world.getBlockAt(50,50,50);
        Log log = block.setBlockType(Log.class);

        // Normal Y oak
        testLogState(log, Axis.Y, LogType.OAK, false, false,
            "minecraft:log", new FreezableSortedMap<>() {{
                put("old_log_type", "oak");
                put("pillar_axis", "y");
            }});

        // Stripped X acacia
        testLogState(log, Axis.X, LogType.ACACIA, true, false,
            "minecraft:stripped_acacia_log", new FreezableSortedMap<>() {{
                put("pillar_axis", "x");
            }});

        testLogState(log, Axis.Z, LogType.CRIMSON, true, false,
            "minecraft:stripped_crimson_stem", new FreezableSortedMap<>() {{
                put("pillar_axis", "z");
            }});

        testLogState(log, Axis.Z, LogType.CRIMSON, true, true,
            "minecraft:stripped_crimson_hyphae", new FreezableSortedMap<>() {{
                put("pillar_axis", "z");
            }});

        testLogState(log, Axis.Z, LogType.JUNGLE, true, true,
            "minecraft:wood", new FreezableSortedMap<>() {{
                put("pillar_axis", "z");
                put("wood_type", "jungle");
                put("stripped_bit", (byte) 1);
            }});
    }

    private void testLogState(Log log, Axis axis, LogType logType, boolean stripped, boolean barkOnAllSides, String blockId, FreezableSortedMap<String, Object> neededStates) {
        // Set the state on the block instance
        log.setAxis(axis);
        log.setLogType(logType);
        log.setStripped(stripped);
        log.setBarkOnAllSides(barkOnAllSides);
        int currentRuntimeId = log.getRuntimeId();

        int neededRuntimeId = BlockRuntimeIDs.toBlockIdentifier(blockId, neededStates).getRuntimeId();

        Assertions.assertEquals(neededRuntimeId, currentRuntimeId, "Wanted and current runtime id differ");
    }

}
