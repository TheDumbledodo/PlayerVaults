package dev.dumble.vaults.menu;

import dev.dumble.vaults.config.PlayerVaultMenuConfig;
import dev.dumble.vaults.controller.PlayerDataController;
import dev.dumble.vaults.model.PlayerData;
import gg.supervisor.menu.guis.impl.PersonalizedMenu;
import gg.supervisor.util.chat.Text;
import gg.supervisor.util.serializer.ItemSerializer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Collections;
import java.util.UUID;

public class PlayerVaultMenu extends PersonalizedMenu {

    public PlayerVaultMenu(PlayerDataController controller, PlayerVaultMenuConfig config, Player player) {
        super(player, config.getRows(), Text.translate(config.getTitle()), Collections.emptySet());

        open();

        final UUID uuid = player.getUniqueId();
        final PlayerData playerData = controller.get(uuid);

        playerData.getSerializedItems().ifPresent(items -> getInventory().setContents(items));

        setCloseGuiAction(event -> {

            final Inventory inventory = event.getInventory();
            final String serializedItems = inventory.isEmpty() ? null : ItemSerializer.itemStackArrayToBase64(inventory.getContents());

            playerData.setSerializedItems(serializedItems);
            controller.save(uuid, playerData);
        });
    }
}