package dev.dumble.vaults.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.PaperCommandManager;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import dev.dumble.vaults.config.PlayerVaultMenuConfig;
import dev.dumble.vaults.controller.PlayerDataController;
import dev.dumble.vaults.menu.PlayerVaultMenu;
import gg.supervisor.core.annotation.Component;
import org.bukkit.entity.Player;

@Component
@CommandAlias("playervault|pv")
@CommandPermission("vaults.open.use")
public class ACFPlayerVaultCommand extends BaseCommand {

    private final PlayerDataController controller;
    private final PlayerVaultMenuConfig config;

    public ACFPlayerVaultCommand(PaperCommandManager commandManager, PlayerDataController controller, PlayerVaultMenuConfig config) {
        this.controller = controller;
        this.config = config;

        commandManager.registerCommand(this);
    }

    @Default
    @Description("Opens your personal vault.")
    public void openVault(Player player) {
        new PlayerVaultMenu(controller, config, player);
    }
}
