package smitegee.femiteboxplugin.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class zyphorsaxe implements Listener {

    @EventHandler
    public void EntityDamageEvent(EntityDamageByEntityEvent e) {



        if ((e.getDamager() instanceof WitherSkeleton) && (e.getEntity() instanceof Player)) return;
            Player player = (Player) e.getEntity();
            WitherSkeleton windicator = (WitherSkeleton) e.getDamager();
            ItemStack item = windicator.getEquipment().getItemInMainHand();
            if (item.getType().equals(Material.NETHERITE_AXE) &&
                    item.hasItemMeta() &&
                    item.getItemMeta().hasDisplayName() &&
                    item.getItemMeta().getDisplayName().equals(ChatColor.BLACK + "" + ChatColor.BOLD + "Zyphor's" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + " Axe")) {

                player.getWorld().createExplosion(player.getLocation(), 10);

                player.getLocation().getWorld().strikeLightning(player.getLocation());
                player.getLocation().getWorld().strikeLightning(player.getLocation());
                player.getLocation().getWorld().strikeLightning(player.getLocation());
                player.getLocation().getWorld().strikeLightning(player.getLocation());
                player.getLocation().getWorld().strikeLightning(player.getLocation());
            }
        }
    }

