package com.iantapply.blessings.utils;

import org.bukkit.entity.ArmorStand;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Used to interact with the armor stand of the blessing and to
 * teleport it to locations.
 */
public class BlessingArmorStand {
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
