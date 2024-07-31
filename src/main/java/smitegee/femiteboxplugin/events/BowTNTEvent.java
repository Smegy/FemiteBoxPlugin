package smitegee.femiteboxplugin.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class BowTNTEvent implements Listener {


    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {

        if (event.getEntity() instanceof Firework) return;
        Arrow arrow = (Arrow) event.getEntity();
        Player player = (Player) arrow.getShooter();
        if (event.getEntity() instanceof Arrow) {
            if (arrow.getShooter() instanceof Player) {
                if (player.getInventory().getItemInMainHand().getItemMeta().hasDisplayName() &&
                        player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.RED + "TNT Bow")) {

// Spawn the TNT
                    TNTPrimed tnt = (TNTPrimed) arrow.getLocation().getWorld().spawn(arrow.getLocation(), TNTPrimed.class);
                    tnt.setFuseTicks(20); // 1 sec

// Remove the arrow
                    arrow.remove();
                }
            }
        }
    }
}
