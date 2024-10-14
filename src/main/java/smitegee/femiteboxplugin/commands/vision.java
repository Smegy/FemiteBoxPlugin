package smitegee.femiteboxplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class vision implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

       if (!(commandSender instanceof Player)) {
           commandSender.sendMessage("Only players can use this command!");
           return true;
       } else {
           Player p = (Player) commandSender;
           PotionEffect potionEffect = new PotionEffect(PotionEffectType.NIGHT_VISION,360, 255, false, false, false);
           p.addPotionEffect(potionEffect);
       }



        return true;
    }
}
