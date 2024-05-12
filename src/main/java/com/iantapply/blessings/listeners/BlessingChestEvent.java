package com.iantapply.blessings.listeners;

import com.iantapply.blessings.BlessingAnimation;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class BlessingChestEvent implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Block clickedBlock = event.getClickedBlock();

        // If it isn't a valid block, skip the rest of the code
        if (clickedBlock == null) {
            return;
        }

        // If the block isn't a chest, skip the rest of the code
        if (clickedBlock.getType() != Material.CHEST) {
            return;
        }

        // If the player didn't right click the block, skip the rest of the code
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        /**
         * We can know that the block is a chest, so we can cast it to a Chest object
         */

        Chest chestState = (Chest) clickedBlock.getState();
        String chestName = chestState.getCustomName();

        // If the chest doesn't have a custom name, skip the rest of the code
        if (chestName == null) {
            return;
        }

        // If the chest name isn't "Blessing", skip the rest of the code
        if (!chestName.equals("Blessing")) {
            return;
        }

        event.setCancelled(true);

        BlessingAnimation.playOpenChestAnimation(chestState, true);
        BlessingAnimation.createBlessingAnimation(player, clickedBlock);
        player.playSound(player.getLocation(), Sound.BLOCK_CHEST_OPEN, 10f, 1);
    }
}
