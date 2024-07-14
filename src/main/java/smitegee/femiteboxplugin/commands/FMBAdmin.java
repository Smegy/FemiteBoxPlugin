package smitegee.femiteboxplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FMBAdmin implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        Player pl = (Player) sender;
        String pname = args[0];
        String msg = args[1];
        Player target = Bukkit.getPlayer(pname);




       if (!pl.hasPermission("femiteboxplugin.admin")) return true;

        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Usage: /fmbadmin <playername> message");
            return true;
        }
        if (args.length >= 1 && args[0].equalsIgnoreCase("getblock")) {
            pl.getLocation().getBlock();
        }



        target.sendMessage("You got a message from " + pl.getName() + ": " + msg);

        pl.sendMessage("You sent a message to " + target + ", here is your message: " + msg);





        return false;
    }
}
