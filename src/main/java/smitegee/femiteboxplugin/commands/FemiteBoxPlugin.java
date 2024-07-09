package smitegee.femiteboxplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class FemiteBoxPlugin implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        Player player = (Player) sender;


        String ver = ChatColor.AQUA + " Running Version 1.6.4";



        //Items
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ChatColor.RED + "TNT Bow");
        im.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        im.setUnbreakable(true);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        //Lore
        List<String> lore1 = new ArrayList<>();
        lore1.add(ChatColor.GRAY + "Enchantments");
        lore1.add(ChatColor.AQUA + "     Infinite I");
        lore1.add(ChatColor.AQUA + "     Explosion I");
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
        lore.add(ChatColor.AQUA+"     Lightning I");
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
        lore3.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "[Zyphor?]");

        itemMeta3.setLore(lore3);
        item3.setItemMeta(itemMeta3);

        //Ice Bow,
        ItemStack iceBow = new ItemStack(Material.BOW, 1);
        ItemMeta iceBowMeta = iceBow.getItemMeta();
        iceBowMeta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Ice Bow");
        iceBowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
        iceBowMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        iceBowMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        iceBowMeta.setUnbreakable(true);
        iceBow.setItemMeta(iceBowMeta);



        //Frost Blade
        ItemStack fb = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta fbm = fb.getItemMeta();
        fbm.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Frost Blade");
        fbm.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        fbm.setUnbreakable(true);
        fb.setItemMeta(fbm);




        // Args
        if (player.hasPermission("femiteboxplugin.fmb.admin.likeluckperms.menu")) {
            sender.sendMessage(ChatColor.DARK_GREEN +"[FMB]" + ver);
            sender.sendMessage(ChatColor.AQUA + "> getItem");
            sender.sendMessage(ChatColor.DARK_GRAY + "> Gives you a choice,");
            sender.sendMessage(ChatColor.AQUA + "> showItem");
            sender.sendMessage(ChatColor.DARK_GRAY + "> Shows the item in your hand");
        } else {
            sender.sendMessage(ChatColor.DARK_GREEN +"[FMB]" + ver);
        }

        //GetItem

        if (!player.hasPermission("femiteboxplugin.fmb.admin.getitem")) return true;

        if (args.length >= 1 && args[0].equalsIgnoreCase("getItem")) {


            if (args.length >= 2 && args[1].equalsIgnoreCase("weapon")) {


                if (args.length >= 3 && args[2].equalsIgnoreCase("lsword")) {
                    player.getInventory().addItem(item2);
                    sender.sendMessage(ChatColor.AQUA + "> Got Lightning Sword");
                }

                if (args.length >= 3 && args[2].equalsIgnoreCase("tntbow")) {
                    player.getInventory().addItem(item);
                    sender.sendMessage(ChatColor.AQUA + "> Got TNT Bow");
                }

                if (args.length >= 3 && args[2].equalsIgnoreCase("fb")) {
                    player.getInventory().addItem(fb);
                    sender.sendMessage(ChatColor.AQUA + "> Got Frost Blade");
                }

                if (args.length >= 3 && args[2].equalsIgnoreCase("icebow")) {
                    player.getInventory().addItem(iceBow);
                    sender.sendMessage(ChatColor.AQUA + "> Got Ice Bow");
                }

                if (args.length >= 3 && args[2].equalsIgnoreCase("zyphor")) {
                    player.getInventory().addItem(item3);
                    sender.sendMessage(ChatColor.AQUA + "> Got Zyphor's Axe");
                }

                if (args.length >= 3 && args[1].equalsIgnoreCase("weapon")) {
                    sender.sendMessage(ChatColor.DARK_GREEN +"[FMB]" + ver);
                    sender.sendMessage(ChatColor.AQUA + "> /fbp getItem weapon lsword");
                    sender.sendMessage(ChatColor.AQUA + "> /fbp getItem weapon tntbow");
                    sender.sendMessage(ChatColor.AQUA + "> /fbp getItem weapon zyphor");
                    sender.sendMessage(ChatColor.AQUA + "> /fbp getItem weapon fb");
                    sender.sendMessage(ChatColor.AQUA + "> /fbp getItem weapon icebow");


                }
            }


        }
        if (args.length >= 3 && args[0].equalsIgnoreCase("getItem")) {
            sender.sendMessage(ChatColor.DARK_GREEN +"[FMB]" + ver);
            sender.sendMessage(ChatColor.AQUA + "> /fbp getItem weapon");


        }


        if (args.length >= 1 && args[0].equalsIgnoreCase("showItem") && player.hasPermission("femiteboxplugin.fmb.showitem")) {
            String playeritem = player.getInventory().getItemInMainHand().getItemMeta().getDisplayName();

            sender.sendMessage(ChatColor.LIGHT_PURPLE + "[FMB]" + ChatColor.RED + "Your Item:"  + ChatColor.GOLD + playeritem);
            sender.sendMessage("");
            Bukkit.broadcastMessage(ChatColor.AQUA + "[" + player.getName() + "]" + " has shown their item: " + playeritem);
        } else {
            // message to send if it doesn't work
            sender.sendMessage(ChatColor.DARK_GREEN +"[FMB]" + ver);
            sender.sendMessage(ChatColor.RED +"The sub-command you used isnt just made for you");
        }


        return false;
    }
}
