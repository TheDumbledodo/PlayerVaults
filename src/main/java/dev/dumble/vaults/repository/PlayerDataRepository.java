package dev.dumble.vaults.repository;

import dev.dumble.vaults.model.PlayerData;
import gg.supervisor.core.annotation.Component;
import gg.supervisor.core.repository.JsonPlayerRepository;

@Component
public interface PlayerDataRepository extends JsonPlayerRepository<PlayerData> {

}