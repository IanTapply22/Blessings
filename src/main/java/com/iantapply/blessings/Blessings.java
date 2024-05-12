package com.iantapply.blessings;

import com.iantapply.blessings.listeners.BlessingChestEvent;
import com.iantapply.blessings.utils.logger.Logger;
import com.iantapply.blessings.utils.logger.LoggingLevel;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * A simple plugin that mimics Hypixel Skyblock dungeons blessings.
 * Please modify this to any extent you wish
 */
public final class Blessings extends JavaPlugin {
    private static Blessings plugin;

    @Override
    public void onEnable() {
        Logger.log(LoggingLevel.INFO, "Initializing Blessings plugin...");
        plugin = this;
        getServer().getPluginManager().registerEvents(new BlessingChestEvent(), this);
        Logger.log(LoggingLevel.INFO, "Blessings plugin initialized!");
    }

    @Override
    public void onDisable() {
        Logger.log(LoggingLevel.INFO, "Disabled Blessings plugin...");
    }

    /**
     * Get the plugin instance
     * @return The Blessings plugin instance
     */
    public static Blessings getPlugin() {
        return plugin;
    }
}
