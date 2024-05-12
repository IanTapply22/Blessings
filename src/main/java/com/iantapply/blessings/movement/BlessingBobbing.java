package com.iantapply.blessings.movement;

import org.bukkit.entity.ArmorStand;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Handles all the vertical movement of the blessing armor stand.
 * This runnable is just a simple sin wave that moves the armor stand up and down.
 */
public class BlessingBobbing extends BukkitRunnable {

    private long currentTick = 0;
    private double lastYOffset = 0;

    // The armor stand of the blessing
    private final ArmorStand armorStand;
    private final double amplitude;
    private final double frequency;


    public BlessingBobbing(ArmorStand armorStand, double amplitude, double frequency) {
        this.armorStand = armorStand;
        this.amplitude = amplitude;
        this.frequency = frequency;
    }

    @Override
    public void run() {
        // If the armor stand is dead, cancel the runnable
        if (armorStand.isDead()) {
            cancel();
        }

        double yOffset = Math.sin(Math.toRadians(currentTick * frequency)) * amplitude;
        armorStand.teleport(armorStand.getLocation().add(0, (yOffset - lastYOffset), 0));
        lastYOffset = yOffset;
        currentTick++;
    }
}
