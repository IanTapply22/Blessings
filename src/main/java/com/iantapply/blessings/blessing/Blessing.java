package com.iantapply.blessings.blessing;

import com.iantapply.blessings.Blessings;
import com.iantapply.blessings.movement.BlessingBobbing;
import com.iantapply.blessings.movement.BlessingRotation;
import com.iantapply.blessings.sound.Sounds;
import com.iantapply.blessings.utils.BlessingChest;
import com.iantapply.blessings.utils.BlessingArmorStand;
import com.iantapply.blessings.utils.BlessingSkull;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Blessing {
    String headURL = "https://textures.minecraft.net/texture/e93e2068617872c542ecda1d27df4ece91c699907bf327c4ddb85309412d3939";
    Block chestBlock;
    Player player;
    ArmorStand armorStand;
    Integer duration = 20;

    /**
     * Creates a new blessing instance
     * @param chestBlock The chest block of the blessing
     * @param player The player that the blessing is for
     */
    public Blessing(Block chestBlock, Player player) {
        this.chestBlock = chestBlock;
        this.player = player;
    }

    /**
     * Creates a new blessing instance
     * @param headURL The texture URL of the head used for the blessing
     * @param chestBlock The chest block of the blessing
     * @param player The player that the blessing is for
     */
    public Blessing(String headURL, Block chestBlock, Player player) {
        this.headURL = headURL;
        this.chestBlock = chestBlock;
        this.player = player;
    }

    /**
     * Creates a new blessing instance
     * @param headURL The texture URL of the head used for the blessing
     * @param chestBlock The chest block of the blessing
     * @param player The player that the blessing is for
     * @param duration The duration that the blessing is active for
     */
    public Blessing(String headURL, Block chestBlock, Player player, Integer duration) {
        this.headURL = headURL;
        this.chestBlock = chestBlock;
        this.player = player;
        this.duration = duration;
    }

    /**
     * Gets the texture URL of the head used for the blessing
     * @return The URL of the head
     */
    public String getHeadURL() {
        return headURL;
    }

    /**
     * Gets the chest block of the blessing
     * @return The chest as a block object
     */
    public Block getChestBlock() {
        return chestBlock;
    }

    /**
     * Gets the player that the blessing is for
     * @return The player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the armor stand of the blessing itself
     * @return The armor stand
     */
    public ArmorStand getArmorStand() {
        return armorStand;
    }

    /**
     * Gets the duration that the blessing is active for
     * @return The duration of the blessing in seconds
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * Starts the blessing and all of its subcomponents
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public void start() throws NoSuchFieldException, IllegalAccessException {
        BlessingChest.executeChestAnimation(this.player, (Chest) this.chestBlock, true);
        createBlessingArmorStand();
        triggerBlessingSound();
        elevate();
        attachBlessingMovement();
        startCountdown(this.duration);
    }

    /**
     * Cancels the blessing and removes the armor stand. Note: Some runnables will still be active
     */
    public void cancel() {
        this.armorStand.remove();
    }

    /**
     * Creates the armor stand and its configurations for the blessing
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public void createBlessingArmorStand() throws NoSuchFieldException, IllegalAccessException {
        this.armorStand = player.getWorld().spawn(chestBlock.getLocation().add(0.5, -1,0.5), ArmorStand.class);
        this.armorStand.setGravity(false);
        this.armorStand.getEquipment().setHelmet(new ItemStack(BlessingSkull.getSkull(this.headURL)));
        armorStand.setVisible(false);
    }

    /**
     * Attaches the movement components of the blessing
     */
    public void attachBlessingMovement() {
        new BlessingRotation(armorStand).runTaskTimer(Blessings.getPlugin(), 0, 1);
        new BlessingBobbing(armorStand, 0.1, 0.1).runTaskTimer(Blessings.getPlugin(), 0, 1);
    }

    /**
     * Triggers the sound of the blessing when the chest is opened
     */
    public void triggerBlessingSound() {
        Sounds.playSound(player, 1f, 0.793701f).runTaskLater(Blessings.getPlugin(), 5L);
        Sounds.playSound(player, 1f, 0.890899f).runTaskLater(Blessings.getPlugin(), 10L);
        Sounds.playSound(player, 1f, 1.0f).runTaskLater(Blessings.getPlugin(), 15L);
        Sounds.playSound(player, 1f, 1.059463f).runTaskLater(Blessings.getPlugin(), 20L);
        Sounds.playSound(player, 1f, 1.189207f).runTaskLater(Blessings.getPlugin(), 25L);
    }

    /**
     * Starts the duration counter of the blessing
     * @param duration The duration that the blessing is active
     */
    public void startCountdown(Integer duration) {
        Bukkit.getScheduler().runTaskTimer(Blessings.getPlugin(), new Runnable() {
            int time = duration;
            boolean active = true;

            @Override
            public void run() {

                if (this.time == 0)
                {
                    getArmorStand().remove();
                    this.active = false;
                }
                this.time--;
            }
        }, 0L, 20L);
    }

    /**
     * Elevates the blessing out of the chest location
     */
    public void elevate() {
        for (int i = 0; i < 18; i += 2) {
            BlessingArmorStand.teleportArmorStand(this.armorStand).runTaskLater(Blessings.getPlugin(), i);
        }
    }
}
