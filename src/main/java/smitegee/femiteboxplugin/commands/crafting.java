package smitegee.femiteboxplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
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
        Inventory ctable = Bukkit.createInventory(null, 9, ChatColor.RED+"Crafting Table");
        p.openInventory(ctable);

        //Recipes
        ItemStack S = new ItemStack(Material.STICK, 1);
        ItemStack E = new ItemStack(Material.EMERALD, 1);
        //Material A = Material.AIR;

        // E S
        // E A S
        // E S
        // RECIPE
        if (ctable.getItem(0).equals(E) && ctable.getItem(3).equals(E) && ctable.getItem(6).equals(E)
        && ctable.getItem(1).equals(S) && ctable.getItem(5).equals(S) && ctable.getItem(7).equals(S)) {
        ctable.clear();
        ctable.setItem(0, item);

        }
//        ctable.setItem(0, E);
//        ctable.setItem(3, E);
//        ctable.setItem(6, E);
//        ctable.setItem(1, S);
//        ctable.setItem(5, S);
//        ctable.setItem(7, S);





        return false;
    }
}