package dev.dumble.vaults.model;

import gg.supervisor.util.serializer.ItemSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class PlayerData {

    private String name;
    private String serializedItems;

    public Optional<ItemStack[]> getSerializedItems() {
        if (serializedItems == null || serializedItems.isEmpty())
            return Optional.empty();

        try {
            final ItemStack[] deserializedItems = ItemSerializer.itemStackArrayFromBase64(serializedItems);

            return Optional.of(deserializedItems);

        } catch (IOException exception) {
            return Optional.empty();
        }
    }
}