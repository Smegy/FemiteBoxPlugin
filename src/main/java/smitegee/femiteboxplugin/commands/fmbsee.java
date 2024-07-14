package smitegee.femiteboxplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class fmbsee implements CommandExecutor {

    @Override
    public boolean onCommand( CommandSender sender,  Command command,  String label, String[] args) {


        String pname = args[0].toString();

        Player target = Bukkit.getPlayer(pname);
        Player p = (Player) sender;
        Inventory inv = target.getInventory();
        Inventory ec = target.getEnderChest();


        if (!p.hasPermission("femiteboxplugin.fmb.fmbsee")) return true;

         if (target == null) {
             sender.sendMessage("Player not found.");
             return true;
         }

         if (args.length == 0) {
              sender.sendMessage("Usage: /fsee <playername> ec/inv");
              return true;
          }

         if (args.length == 1 && args[1].equalsIgnoreCase("inv")) {
             p.openInventory(inv);
         }
        if (args.length == 1 && args[1].equalsIgnoreCase("inv")) {
            p.openInventory(ec);
        }

        //      /fsee hráč inv/ec




  return false;
    }
}
