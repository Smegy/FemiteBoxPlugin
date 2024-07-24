package smitegee.femiteboxplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Husk;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vindicator;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class summonmob implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player p = (Player) commandSender;
        ItemStack itemStack = p.getInventory().getItemInMainHand();
        String itemStackName = itemStack.getItemMeta().getDisplayName();

        if (!itemStackName.contains("Egg")) return true;

        //Coal Boss
        {
            if (itemStack.getItemMeta().hasDisplayName() && itemStackName.equalsIgnoreCase(ChatColor.GRAY+""+ChatColor.BOLD+"Coal Boss")) {
                Husk zombie = (Husk) p.getWorld().spawnEntity(p.getLocation(), EntityType.HUSK);
                EntityEquipment inv = zombie.getEquipment();

                inv.getItemInMainHand().setType(Material.NETHERITE_SWORD);
                inv.getItemInOffHand().setType(Material.BLACK_GLAZED_TERRACOTTA);

                zombie.setHealth(250);
                zombie.attack(p);
            }

            //Gold Boss
            if (itemStack.getItemMeta().hasDisplayName() && itemStackName.equalsIgnoreCase(ChatColor.GOLD+""+ChatColor.BOLD+"Gold Boss Egg")) {
                Vindicator zombie = (Vindicator) p.getWorld().spawnEntity(p.getLocation(), EntityType.VINDICATOR);
                EntityEquipment inv = zombie.getEquipment();

                zombie.setHealth(350);
                zombie.attack(p);
                zombie.sendMessage(p.getName() + " You are DONE");

                inv.getItemInMainHand().setType(Material.NETHERITE_AXE);
                inv.getItemInOffHand().setType(Material.NETHER_BRICK);


                inv.getHelmet().setType(Material.NETHERITE_HELMET);
                inv.getChestplate().setType(Material.NETHERITE_CHESTPLATE);
                inv.getLeggings().setType(Material.NETHERITE_LEGGINGS);
                inv.getBoots().setType(Material.NETHERITE_BOOTS);


            }
         }

        return false;
    }
}