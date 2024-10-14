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
import smitegee.smiteapi.ItemHelper.ItemHelper;
import smitegee.smiteapi.economy.EconomyManager;

import java.util.ArrayList;
import java.util.List;

public class FemiteBoxPlugin implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        Player player = (Player) sender;


        String ver = ChatColor.AQUA + " Running Version 1.10.6";

//        Items
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ChatColor.RED + "TNT Bow");
        im.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        im.setUnbreakable(true);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        //Lore
        List<String> lore1 = new ArrayList<>();
        lore1.add(ChatColor.GRAY + "Enchantments");
        lore1.add(ChatColor.GOLD + "     Infinite I");
        lore1.add(ChatColor.GOLD + "     Explosion I");
        lore1.add("");
        lore1.add("");
        lore1.add(ChatColor.GRAY + "My father gave this bow to me, said its a family tradition to give it up.");
        lore1.add("");
        lore1.add("");
        lore1.add(ChatColor.GOLD + "" + ChatColor.BOLD + "[GODLY]");

        im.setLore(lore1);
        item.setItemMeta(im);




        ItemStack item2 = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta im2 = item2.getItemMeta();
        im2.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Lightning Sword");
        im2.addEnchant(Enchantment.CHANNELING, 1, true);
        im2.setUnbreakable(true);
        im2.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        //Lore
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY+"Enchantments");
        lore.add(ChatColor.GOLD+"     Lightning I");
        lore.add("");
        lore.add("");
        lore.add(ChatColor.GRAY + "Found it on the ground, dont think i will find the owner");
        lore.add("");
        lore.add("");
        lore.add(ChatColor.GOLD + "" + ChatColor.BOLD + "[LEGENDARY]");
        im2.setLore(lore);
        item2.setItemMeta(im2);



        ItemStack item3 = new ItemStack(Material.NETHERITE_AXE, 1);
        ItemMeta itemMeta3 = item3.getItemMeta();
        itemMeta3.setDisplayName(ChatColor.BLACK + "" + ChatColor.BOLD + "Zyphor's" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + " Axe");
        itemMeta3.addEnchant(Enchantment.DAMAGE_ALL, 28, true);
        itemMeta3.addEnchant(Enchantment.FIRE_ASPECT, 10, true);
        itemMeta3.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta3.setUnbreakable(true);

        List<String> lore3 = new ArrayList<>();

        lore3.add(ChatColor.GRAY+"Enchantments");
        lore3.add(ChatColor.AQUA + "     Fire Aspect X");
        lore3.add(ChatColor.AQUA + "     Sharpness XXVIII");
        lore3.add(ChatColor.AQUA + "     Explosion X");
        lore3.add(ChatColor.AQUA + "     Lightning V");
        lore3.add("");
        lore3.add("");
        lore3.add(ChatColor.GRAY + "Dropped from the one and only... ZYPHOR");
        lore3.add("");
        lore3.add("");
        lore3.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "[GODLY+++]");

        itemMeta3.setLore(lore3);
        item3.setItemMeta(itemMeta3);





        // Args
        if (player.hasPermission("femiteboxplugin.fmb.admin.likeluckperms.menu")) {
            sender.sendMessage(ChatColor.DARK_GREEN +"[FMB]" + ver);
            sender.sendMessage(ChatColor.AQUA + "> getItem");
            sender.sendMessage(ChatColor.DARK_GRAY + "> Gives you a choice,");
            sender.sendMessage(ChatColor.AQUA + "> showItem");
            sender.sendMessage(ChatColor.DARK_GRAY + "> Shows the item in your hand");
            sender.sendMessage(ChatColor.AQUA + "> menu1");
            sender.sendMessage(ChatColor.DARK_GRAY + "> What do you think it does?");
            return true;
        } else {
            sender.sendMessage(ChatColor.DARK_GREEN +"[FMB]" + ver);
        }




        if (args.length >= 1 && args[0].equalsIgnoreCase("menu")) {
            Inventory inv = Bukkit.createInventory(null, 36, "Item Menu");
            inv.setItem(11, item);
            inv.setItem(13, item2);
            inv.setItem(15, item3);
            player.openInventory(inv);
            return true;
        }

        //GetItem

        if (args.length >= 1 && args[0].equalsIgnoreCase("getItem")) {

            if (!player.hasPermission("femiteboxplugin.getitem")) return true;




                if (args.length >= 3 && args[2].equalsIgnoreCase("lsword")) {
                    player.getInventory().addItem(item2);
                    sender.sendMessage(ChatColor.AQUA + "> Got Lightning Sword");
                    return true;
                }

                if (args.length >= 3 && args[2].equalsIgnoreCase("tntbow")) {
                    player.getInventory().addItem(item);
                    sender.sendMessage(ChatColor.AQUA + "> Got TNT Bow");
                    return true;
                }


                if (args.length >= 3 && args[2].equalsIgnoreCase("zyphor")) {
                    player.getInventory().addItem(item3);
                    sender.sendMessage(ChatColor.AQUA + "> Got Zyphor's Axe");
                    return true;
                }

                if (args.length >= 3 && args[1].equalsIgnoreCase("weapon")) {
                    sender.sendMessage(ChatColor.DARK_GREEN +"[FMB]" + ver);
                    sender.sendMessage(ChatColor.AQUA + "> /fbp getItem lsword");
                    sender.sendMessage(ChatColor.AQUA + "> /fbp getItem tntbow");
                    sender.sendMessage(ChatColor.AQUA + "> /fbp getItem zyphor");

                    return true;
                }
        }
        if (args.length >= 1 && args[0].equalsIgnoreCase("showItem")) {
            if (!player.hasPermission("femiteboxplugin.showitem")) return true;

            ItemStack playeritem = player.getInventory().getItemInMainHand();

            if (playeritem.getItemMeta().getDisplayName().equals(null)) {
                sender.sendMessage("Player"+ChatColor.AQUA+player.getName()+" has shown thier item: "+playeritem.getType());
                return true;
            }
            else {
                sender.sendMessage("");
                Bukkit.broadcastMessage("Player"+ChatColor.AQUA + player.getName() + " has shown their item: " + playeritem.getItemMeta().getDisplayName());
                return true;
            }
        }
        return false;
    }
}
