package smitegee.femiteboxplugin.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;

public class lsword implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractAtEntityEvent event) {
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();

        Player player = event.getPlayer();

        if (!item.hasItemMeta()) return;
        if (player.getInventory().getItemInMainHand().getType().equals(Material.IRON_SWORD) &&
                player.getInventory().getItemInMainHand().containsEnchantment(Enchantment.CHANNELING) && player.getInventory().getItemInMainHand().getItemMeta().hasDisplayName() &&
                player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.GOLD +  "" + ChatColor.BOLD   + "Lightning Sword")) {


            event.getRightClicked().getWorld().strikeLightning(event.getRightClicked().getLocation());
        }




    }

}
