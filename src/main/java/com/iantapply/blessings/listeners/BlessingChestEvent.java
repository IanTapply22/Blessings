package com.iantapply.blessings.listeners;

import com.iantapply.blessings.blessing.Blessing;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

/**
 * The event listener for the blessing chest interaction. All usual player interactions are caught
 * well in advance.
 */
public class BlessingChestEvent implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        // General initialization of the event
        Player player = event.getPlayer();
        Block clickedBlock = event.getClickedBlock();

        if (clickedBlock == null) return;
        if (clickedBlock.getType() != Material.CHEST) return;
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        // Cast the clicked block to a chest
        Chest chestState = (Chest) clickedBlock.getState();
        Inventory chestInventory = chestState.getInventory();
        String chestName = chestInventory.getName();

        if (chestName == null) return;

        String BLESSING_CHEST_NAME = "Blessing";
        if (!chestName.equals(BLESSING_CHEST_NAME)) return;

        event.setCancelled(true);

        // Finally crease the blessing and start it
        Blessing blessing = new Blessing(chestState, player);
        blessing.start();
    }
}
