package net.swofty.types.generic.event.actions.player.npc;

import net.minestom.server.event.Event;
import net.minestom.server.event.player.PlayerMoveEvent;
import net.swofty.types.generic.SkyBlockConst;
import net.swofty.types.generic.entity.npc.SkyBlockNPC;
import net.swofty.types.generic.user.SkyBlockPlayer;
import net.swofty.types.generic.event.SkyBlockEvent;

public class ActionPlayerMoveNPC extends SkyBlockEvent {
    @Override
    public Class<? extends Event> getEvent() {
        return PlayerMoveEvent.class;
    }

    @Override
    public void run(Event event) {
        PlayerMoveEvent playerEvent = (PlayerMoveEvent) event;
        final SkyBlockPlayer player = (SkyBlockPlayer) playerEvent.getPlayer();

        if (SkyBlockConst.isIslandServer()) return;

        SkyBlockNPC.updateForPlayer(player);
    }
}
