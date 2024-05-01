package net.swofty.types.generic.event.actions.player.npc;

import net.minestom.server.event.Event;
import net.minestom.server.event.player.PlayerMoveEvent;
import net.swofty.types.generic.SkyBlockConst;
import net.swofty.types.generic.entity.animalnpc.SkyBlockAnimalNPC;
import net.swofty.types.generic.event.SkyBlockEvent;
import net.swofty.types.generic.user.SkyBlockPlayer;

public class ActionPlayerMoveAnimalNPC extends SkyBlockEvent {
    @Override
    public Class<? extends Event> getEvent() {
        return PlayerMoveEvent.class;
    }

    @Override
    public void run(Event tempEvent) {
        PlayerMoveEvent event = (PlayerMoveEvent) tempEvent;
        final SkyBlockPlayer player = (SkyBlockPlayer) event.getPlayer();

        if (SkyBlockConst.isIslandServer()) return;

        SkyBlockAnimalNPC.updateForPlayer(player);
    }
}
