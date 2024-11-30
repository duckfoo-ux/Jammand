package Jmmand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class jammand extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        getLogger().info("Jammand is enabled");
        getCommand("jammand").setExecutor(this);
        saveDefaultConfig(); // 이건 config.yml 있을때 쓰기
        saveResource("config.yml",  false); // 이건 config.yml 있을때 쓰기

    }
    // Ctrl + o 를 사용하여 onCommand  하기
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
       Player p = (Player) sender;
       Item item = new Item();
       if (args.length == 0) {
           p.sendMessage(ChatColor.RED + "JammandㅣKommand");


           p.sendMessage("jammand");
       } else {
           if (args[0].equalsIgnoreCase("Kammand")) {

            p.sendMessage(ChatColor.BLUE + "kammand");
            p.getInventory().addItem(item.setSlot(Material.REDSTONE_LAMP, "BOMM"));

           }
       }




        return false;
    }

    @Override
    public void onDisable() {
        getLogger().info("Jammand is disabled");


    }
}
