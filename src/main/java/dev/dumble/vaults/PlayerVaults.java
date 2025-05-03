package dev.dumble.vaults;

import co.aikar.commands.PaperCommandManager;
import gg.supervisor.core.loader.SupervisorLoader;
import gg.supervisor.menu.util.MenuUtil;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerVaults extends JavaPlugin {

    @Override
    public void onEnable() {
        SupervisorLoader.register(this, new PaperCommandManager(this));
    }

    @Override
    public void onDisable() {
        MenuUtil.closeAllMenus();
    }
}