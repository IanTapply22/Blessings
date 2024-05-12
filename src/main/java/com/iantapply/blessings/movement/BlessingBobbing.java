package com.iantapply.blessings.runnables;

import org.bukkit.entity.ArmorStand;
import org.bukkit.scheduler.BukkitRunnable;

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
