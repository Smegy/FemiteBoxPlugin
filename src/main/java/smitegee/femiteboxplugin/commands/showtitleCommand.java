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
import org.jetbrains.annotations.NotNull;

public class showtitleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length < 3) {
            sender.sendMessage("Usage: /showtitle <player> <title> <subtitle>");
            return false;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage("Player not found!");
            return false;
        }

        Component titleText = Component.text("Teleporting to", TextColor.color(255, 255, 0)).decorate(TextDecoration.BOLD);
        Component subtitleText = Component.text("The Nether", TextColor.color(102, 9, 9));

        Title title = Title.title(titleText, subtitleText);

        target.showTitle(title);
        sender.sendMessage("Title sent to " + target.getName());
        return true;
    }
}