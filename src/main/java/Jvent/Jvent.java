package Jvent;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class Jvent extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {

    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.RED + "joined the game!");



    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.YELLOW + " left the game!");
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.GREEN + "you Move");
    }


    @EventHandler
    public void kick(PlayerKickEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.BLUE + "you Kick");
    }


    @EventHandler
    public void de(PlayerDeathEvent event) {
        Player player = event.getEntity();
        player.sendMessage(ChatColor.DARK_BLUE + "you Death");

    }
    @EventHandler
    public void c(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.DARK_PURPLE + "you Interact");
    }


}
