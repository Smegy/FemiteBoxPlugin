package smitegee.femiteboxplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class crafting implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        //Make new things (Inventories, blah blah)
        Player p = (Player) commandSender;
        Inventory ctable = Bukkit.createInventory(null, 9, ChatColor.RED+"Crafting Table");
        p.openInventory(ctable);

        //Recipes



        return false;
    }
}