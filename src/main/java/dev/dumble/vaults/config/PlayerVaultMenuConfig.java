package dev.dumble.vaults.config;

import gg.supervisor.configuration.yaml.YamlConfigService;
import gg.supervisor.core.annotation.Configuration;
import lombok.Getter;

@Getter
@Configuration(path = "menus", fileName = "player-vault-menu.yml", service = YamlConfigService.class)
public class PlayerVaultMenuConfig {

    public String title = "&8Personal Vault";
    public int rows = 5;
}