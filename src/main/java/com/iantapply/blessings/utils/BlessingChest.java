package com.iantapply.blessings.utils;

import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.TileEntityChest;
import net.minecraft.server.v1_8_R3.WorldServer;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Chest;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.entity.Player;

/**
 * Interacts with the chest block to display open and closing animations
 */
public class BlessingChest {
    /**
     * Execute the chest animation
     * @param chest The chest to animate
     * @param open Whether the chest should be opened or closed
     */
    public static void executeChestAnimation(Player player, Chest chest, boolean open) {
        Location location = chest.getLocation();
        WorldServer world = ((CraftWorld) location.getWorld()).getHandle();
        BlockPosition position = new BlockPosition(location.getX(), location.getY(), location.getZ());
        TileEntityChest tileChest = (TileEntityChest) world.getTileEntity(position);
        world.playBlockAction(position, tileChest.w(), 1, open ? 1 : 0);

        if (open) {
            player.playSound(player.getLocation(), Sound.CHEST_OPEN, 10f, 1);
        } else {
            player.playSound(player.getLocation(), Sound.CHEST_CLOSE, 10f, 1);
        }
    }
}
