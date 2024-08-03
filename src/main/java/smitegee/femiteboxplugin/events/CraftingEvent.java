package smitegee.femiteboxplugin.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CraftingEvent implements Listener {



    public void InventoryInteractEvent(InventoryInteractEvent e) {


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


        Inventory ctable = e.getInventory();


        if (ctable.getItem(3).getType().equals(Material.EMERALD) &&
                ctable.getItem(12).getType().equals(Material.EMERALD) &&
                ctable.getItem(21).getType().equals(Material.EMERALD)) {

            if (ctable.getItem(4).getType().equals(Material.STICK) &&
                    ctable.getItem(14).getType().equals(Material.STICK) &&
                    ctable.getItem(22).getType().equals(Material.STICK)) {


                ctable.clear();
                ctable.setItem(13, item);
            }
        }
    }
}