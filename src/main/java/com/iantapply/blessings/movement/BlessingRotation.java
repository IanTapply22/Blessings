package com.iantapply.blessings.runnables;

import org.bukkit.entity.ArmorStand;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * A runnable that rotates a blessing armor stands head
 */
public class BlessingRotation extends BukkitRunnable {

    // The armor stand of the blessing
    private final ArmorStand armorStand;
    private double rotationDegrees = 0.17;

    /**
     * Creates a rotation that runs on the armor stands when controlled by a runnable
     * @param armorStand The armor stand to rotate
     */
    public BlessingRotation(ArmorStand armorStand) {
        this.armorStand = armorStand;
    }

    /**
     * Creates a rotation that runs on the armor stands when controlled by a runnable
     * @param armorStand The armor stand to rotate
     * @param rotationDegrees The amount of degrees to rotate the armor stand's head every runnable cycle
     */
    public BlessingRotation(ArmorStand armorStand, double rotationDegrees) {
        this.armorStand = armorStand;
        this.rotationDegrees = rotationDegrees;
    }

    /**
     * Rotate the armor stand's head by 0.17 degrees every runnable cycle
     */
    @Override
    public void run() {
        // If the armor stand is dead, cancel the runnable
        if (armorStand.isDead()) {
            cancel();
        }

        this.armorStand.setHeadPose(this.armorStand.getHeadPose().add(0.0, this.rotationDegrees, 0.0));
    }
}
