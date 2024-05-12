package com.iantapply.blessings.utils.logger;

import org.bukkit.ChatColor;

/**
 * The different levels of logging that can be used in the plugin
 * Contains the name and color of the logging level to use in the Bukkit console
 */
public enum LoggingLevel {
    WARNING("WARNING", ChatColor.RED),
    INFO("INFO", ChatColor.YELLOW),
    ERROR("ERROR", ChatColor.DARK_RED),
    DEBUG("DEBUG", ChatColor.WHITE);

    private final String name;
    private final ChatColor color;

    /**
     * Create a new logging level
     * @param name The name of the logging level to use in the console
     * @param color The Minecraft chat color of the logging level
     */
    LoggingLevel(String name, ChatColor color) {
        this.name = name;
        this.color = color;
    }

    /**
     * Get the name of the logging level
     * @return The name of the logging level used for the console
     */
    public String getName() {
        return name;
    }

    /**
     * Get the color of the logging level
     * @return The color of the logging level used for the console
     */
    public ChatColor getColor() {
        return color;
    }
}
