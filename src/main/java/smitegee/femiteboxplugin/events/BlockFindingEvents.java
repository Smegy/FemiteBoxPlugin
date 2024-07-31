package smitegee.femiteboxplugin.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityToggleSwimEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BlockFindingEvents implements Listener {

    @EventHandler
    public void EntityToggleSwimEvent(EntityToggleSwimEvent e) {
        //check if it's a player and if it's swimming.
        if (e.getEntity() instanceof Player && e.isSwimming()) {

            Player player = (Player) e.getEntity();
            PotionEffect potionEffect = new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 100, 255, false, false, false);
            player.addPotionEffect(potionEffect);
        }
    }
    @EventHandler
    public void OnBlockPlace(BlockPlaceEvent e) {
        if (e.getBlock().getType().equals(Material.CRAFTING_TABLE)) {
            e.setCancelled(true);
            return;
        } else {
            //shit needs to be done ngl
            return;
        }
    }
}
