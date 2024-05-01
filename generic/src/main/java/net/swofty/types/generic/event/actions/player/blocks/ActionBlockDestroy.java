package net.swofty.types.generic.event.actions.player.blocks;

import net.minestom.server.event.Event;
import net.minestom.server.event.player.PlayerBlockBreakEvent;
import net.swofty.types.generic.block.SkyBlockBlock;
import net.swofty.types.generic.block.impl.BlockBreakable;
import net.swofty.types.generic.event.SkyBlockEvent;

public class ActionBlockDestroy extends SkyBlockEvent {
    @Override
    public Class<? extends Event> getEvent() {
        return PlayerBlockBreakEvent.class;
    }

    @Override
    public void run(Event tempEvent) {
        PlayerBlockBreakEvent event = (PlayerBlockBreakEvent) tempEvent;
        if (SkyBlockBlock.isSkyBlockBlock(event.getBlock())) {
            SkyBlockBlock block = new SkyBlockBlock(event.getBlock());
            if (block.getGenericInstance() instanceof BlockBreakable breakable) {
                breakable.onBreak(event, block);
            }
        }
    }
}
