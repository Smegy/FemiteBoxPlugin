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

        Player player = (Player) e.getEntity();
        WitherSkeleton windicator = (WitherSkeleton) e.getDamager();
        ItemStack item = windicator.getEquipment().getItemInMainHand();

        if (windicator instanceof WitherSkeleton && player instanceof Player) {

            if (item.equals(Material.NETHERITE_AXE) &&
                    item.hasItemMeta() &&
                    item.getItemMeta().hasDisplayName() &&
                    item.getItemMeta().getDisplayName().equals(ChatColor.BLACK + "" + ChatColor.BOLD + "Zyphor's" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + " Axe")) {

                player.setGlowing(true);
                player.getWorld().createExplosion(player.getLocation(), 10);

                player.getLocation().getWorld().strikeLightning(player.getLocation());
                player.getLocation().getWorld().strikeLightning(player.getLocation());
                player.getLocation().getWorld().strikeLightning(player.getLocation());
                player.getLocation().getWorld().strikeLightning(player.getLocation());
                player.getLocation().getWorld().strikeLightning(player.getLocation());
            }





        }
    }
}
