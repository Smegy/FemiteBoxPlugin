package smitegee.femiteboxplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class setmaxhealth implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        Player p = (Player) commandSender;

        double current_maxhp = p.getMaxHealth();
        double new_maxhp = Double.valueOf(args[0]);

        if (new_maxhp <= -1) {
            p.sendMessage("Invalid maximum health value.");
            return true;
        }

        if (new_maxhp >= 200) {
            p.sendMessage("HP Limit reached (max 200)");
            return true;
        }

        if (args.length >= 1 && args[0].equalsIgnoreCase("normal")) {
            p.setMaxHealth(20);
            return true;
        }


        p.setMaxHealth(new_maxhp);


        return false;
    }
}