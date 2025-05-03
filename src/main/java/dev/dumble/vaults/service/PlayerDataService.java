package dev.dumble.vaults.service;

import dev.dumble.vaults.model.PlayerData;
import dev.dumble.vaults.repository.PlayerDataRepository;
import gg.supervisor.core.annotation.Component;
import lombok.AllArgsConstructor;

import java.util.UUID;

@Component
@AllArgsConstructor
public class PlayerDataService {

    private final PlayerDataRepository repository;

    public PlayerData load(UUID uuid) {
        return repository.find(uuid.toString());
    }

    public void save(UUID uuid, PlayerData playerData) {
        repository.save(uuid.toString(), playerData);
    }
}