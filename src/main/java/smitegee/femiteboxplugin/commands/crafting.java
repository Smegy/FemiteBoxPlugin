package smitegee.femiteboxplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class crafting implements CommandExecutor {



    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {




        // Items
        //TNTBow
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ChatColor.RED + "TNT Bow");
        im.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        im.setUnbreakable(true);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        //Lore
        List<String> lore1 = new ArrayList<>();
        lore1.add(ChatColor.GRAY + "Enchantments");
        lore1.add(ChatColor.GREEN + "     Infinite I");
        lore1.add(ChatColor.GREEN + "     Explosion I");
        lore1.add("");
        lore1.add("");
        lore1.add(ChatColor.GRAY + "My father gave this bow to me, said its a family tradition to give it up.");
        lore1.add("");
        lore1.add("");
        lore1.add(ChatColor.GOLD + "" + ChatColor.BOLD + "[GODLY]");

        im.setLore(lore1);
        item.setItemMeta(im);


        //Make new things (Inventories, blah blah)
        Player p = (Player) commandSender;
        if (!p.hasPermission("femiteboxplugin.default")) return true;

        Inventory ctable = Bukkit.createInventory(null, 27, ChatColor.RED+"Crafting Table");
        p.openInventory(ctable);

        //Recipes

//        if (ctable.getItem(3).getType().equals(Material.EMERALD) &&
//                ctable.getItem(12).getType().equals(Material.EMERALD) &&
//                ctable.getItem(21).getType().equals(Material.EMERALD)) {
//
//            if (ctable.getItem(4).getType().equals(Material.STICK) &&
//                    ctable.getItem(14).getType().equals(Material.STICK) &&
//                    ctable.getItem(22).getType().equals(Material.STICK)) {
//
//
//                ctable.clear();
//                ctable.setItem(13, item);
//            }
//        }

        return false;
    }
}