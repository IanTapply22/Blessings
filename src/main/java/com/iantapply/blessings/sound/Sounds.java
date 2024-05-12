package com.iantapply.blessings.sound;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Used to interact with the playing of sounds in the plugin
 */
public class Sounds {

    /**
     * Plays a note pling noise to the player
     * @param player The player to play the sound to
     * @param volume The volume of the sound
     * @param pitch The pitch of the sound
     * @return The new BukkitRunnable to play the sound
     */
    public static BukkitRunnable playSound(Player player, Float volume, Float pitch) {
        return new BukkitRunnable() {
            @Override
            public void run() {
                player.playSound(player.getLocation(), Sound.NOTE_PLING, volume, pitch);
            }
        };
    }
}
