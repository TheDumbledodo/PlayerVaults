package dev.dumble.vaults.controller;

import dev.dumble.vaults.model.PlayerData;
import dev.dumble.vaults.service.PlayerDataService;
import gg.supervisor.core.annotation.Component;
import lombok.AllArgsConstructor;

import java.util.UUID;

@Component
@AllArgsConstructor
public class PlayerDataController {

    private final PlayerDataService playerDataService;

    public PlayerData get(UUID uuid) {
        return playerDataService.load(uuid);
    }

    public void save(UUID uuid, PlayerData playerData) {
        playerDataService.save(uuid, playerData);
    }
}