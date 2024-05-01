package net.swofty.types.generic.mission.missions.lumber;

import net.minestom.server.event.Event;
import net.swofty.types.generic.event.EventNodes;
import net.swofty.types.generic.event.SkyBlockEvent;
import net.swofty.types.generic.event.custom.PlayerRegionChangeEvent;
import net.swofty.types.generic.mission.MissionData;
import net.swofty.types.generic.mission.SkyBlockMission;
import net.swofty.types.generic.region.RegionType;
import net.swofty.types.generic.user.SkyBlockPlayer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MissionTalkToLumberjack extends SkyBlockMission {
    @SkyBlockEvent(node = EventNodes.CUSTOM, requireDataLoaded = false)
    public void onRegionChange(PlayerRegionChangeEvent event) {
        MissionData data = event.getPlayer().getMissionData();

        if (event.getTo() == null || !event.getTo().equals(RegionType.FOREST)) {
            return;
        }

        if (data.isCurrentlyActive(this.getClass()) || data.hasCompleted(this.getClass())) {
            return;
        }

        data.setSkyBlockPlayer(event.getPlayer());
        data.startMission(this.getClass());
    }

    @Override
    public String getID() {
        return "talk_to_lumberjack";
    }

    @Override
    public String getName() {
        return "Talk to the Lumber Jack";
    }

    @Override
    public HashMap<String, Object> onStart(SkyBlockPlayer player, MissionData.ActiveMission mission) {
        return new HashMap<>();
    }

    @Override
    public void onEnd(SkyBlockPlayer player, Map<String, Object> customData, MissionData.ActiveMission mission) {
        player.getMissionData().startMission(MissionBreakOaklog.class);
    }

    @Override
    public Set<RegionType> getValidRegions() {
        return Set.of(RegionType.FOREST);
    }
}

