package smitegee.femiteboxplugin.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.jetbrains.annotations.NotNull;

public class showtitleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length < 1) {
            sender.sendMessage("Usage: /showtitle <player>");
            return false;
        }

        Player target = null;

        if (args[0].equalsIgnoreCase("@p")) {
            if (sender instanceof Player) {
                Player senderPlayer = (Player) sender;
                target = senderPlayer.getWorld().getNearbyEntities(senderPlayer.getLocation(), 10, 10, 10, entity -> entity instanceof Player)
                        .stream()
                        .map(entity -> (Player) entity)
                        .findFirst()
                        .orElse(null);
            } else {
                sender.sendMessage("The @p option can only be used by players.");
                return false;
            }
        } else {
            target = Bukkit.getPlayer(args[0]);
        }

        if (target == null) {
            sender.sendMessage("Player not found!");
            return false;
        }

        Component titleText = Component.text("Teleporting to:", TextColor.color( 247, 255, 71 )).decorate(TextDecoration.BOLD);
        Component subtitleText = Component.text("The Nether.", TextColor.color(155, 0, 0)).decorate(TextDecoration.BOLD);

        Title title = Title.title(titleText, subtitleText);

        target.showTitle(title);
        sender.sendMessage("Title sent to " + target.getName());
        return true;
    }
}