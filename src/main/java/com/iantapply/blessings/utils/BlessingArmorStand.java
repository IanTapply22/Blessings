package com.iantapply.blessings.utils;

import org.bukkit.entity.ArmorStand;
import org.bukkit.scheduler.BukkitRunnable;

public class BlessingHead {
    /**
     * Teleport the armor stand up
     * @param armorStand The armor stand to teleport
     * @return The new BukkitRunnable
     */
    public static BukkitRunnable teleportArmorStand(ArmorStand armorStand) {
        return new BukkitRunnable() {
            @Override
            public void run() {
                armorStand.teleport(armorStand.getLocation().add(0, 0.1, 0));
            }
        };
    }
}
