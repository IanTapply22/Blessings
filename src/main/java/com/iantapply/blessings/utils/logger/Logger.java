package com.iantapply.blessings.utils;

import org.bukkit.Bukkit;

public class Logger {
    public static void logToConsole(String message) {
        System.out.println(message);
    }

    public static void logToServerConsole(String message, String level) {
        Bukkit.getServer().getConsoleSender().sendMessage("[" + level + "] " + message);
    }
}
