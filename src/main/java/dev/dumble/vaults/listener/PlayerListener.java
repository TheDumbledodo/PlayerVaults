package dev.dumble.vaults.listener;

import dev.dumble.vaults.controller.PlayerDataController;
import dev.dumble.vaults.model.PlayerData;
import gg.supervisor.core.annotation.Component;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public final class PlayerListener implements Listener {

    private final PlayerDataController controller;

    @EventHandler
    public void onPlayerPreLogin(AsyncPlayerPreLoginEvent event) {
        final UUID uuid = event.getUniqueId();

        if (controller.get(uuid) == null) {

            final PlayerData playerData = new PlayerData();
            playerData.setName(event.getName());

            controller.save(uuid, playerData);
        }
    }
}