package smitegee.femiteboxplugin.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

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

                if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Gaster") &&
                        player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Blaster")) {
                    PotionEffect pot = new PotionEffect(PotionEffectType.POISON, 5, 1, false, false, false);
                    PotionEffect pot2 = new PotionEffect(PotionEffectType.HARM, 5, 1, false, false, false);
                    PotionEffect pot3 = new PotionEffect(PotionEffectType.SLOW, 5, 1, false, false, false);
                    PotionEffect pot4 = new PotionEffect(PotionEffectType.WEAKNESS, 5, 1, false, false, false);
                    arrow.addCustomEffect(pot, true);
                    arrow.addCustomEffect(pot2, true);
                    arrow.addCustomEffect(pot3, true);
                    arrow.addCustomEffect(pot4, true);



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
