package smitegee.femiteboxplugin.HYPE;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class AspectOfEnd implements Listener {


    @EventHandler
    public void PIE(PlayerInteractEvent e) {
        Player p = e.getPlayer();


        if (p.getEquipment().getItemInMainHand() == null) return;
        if (p.getEquipment().getItemInMainHand().getItemMeta() == null) return;



        if (p.getInventory().getItemInMainHand().getType().equals(Material.DIAMOND) && p.hasPermission("femiteboxplugin.admin")) {

            ItemStack aote = e.getItem();
            Location b = e.getClickedBlock().getLocation();

            if (aote.getItemMeta().getDisplayName().contains("ᴀ") && aote.getItemMeta().getDisplayName().contains("ᴏ") && aote.getItemMeta().getDisplayName().contains("ᴛ") && aote.getItemMeta().getDisplayName().contains("ᴅ")) {
int why = b.getBlockY();
                p.teleport(b);
            } else return;
        } else return;
    }

}