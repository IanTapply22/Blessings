package com.iantapply.blessings.utils.logger;

import org.bukkit.Bukkit;

/**
 * A utility class to log messages easily to the Bukkit console
 */
public class Logger {
    /**
     * Log a message to the console with STDOUT
     * @param message The message to log
     */
    public static void logWithSTDOUT(String message) {
        System.out.println(message);
    }

    /**
     * Log a message to the console
     * @param level The logging level
     * @param message The message to log
     */
    public static void log(LoggingLevel level, String message) {
        Bukkit.getServer().getConsoleSender().sendMessage(level.getColor() + "[" + level.getName() + "] " + message);
    }
}
