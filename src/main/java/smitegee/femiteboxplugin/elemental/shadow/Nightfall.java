package smitegee.femiteboxplugin.elemental;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Nightfall implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            ItemStack item = player.getInventory().getItemInMainHand();

            if (item != null && item.getType() == Material.DIAMOND_SWORD && item.getItemMeta().getDisplayName().equals("Nightfall")) {
                if (isBehindTarget(player, event.getEntity())) {
                    event.setDamage(event.getDamage() + 5); // Extra damage when hitting from behind
                    double chance = Math.random();
                    if (chance < 0.3) { // 30% chance to apply blindness
                        ((Player) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 1));
                    }
                }
            }
        }
    }

    private boolean isBehindTarget(Player attacker, org.bukkit.entity.Entity target) {
// Check if the attacker is behind the target
        double angle = attacker.getLocation().getDirection().angle(target.getLocation().getDirection());
        return angle < Math.PI / 4; // Adjust the angle as needed
    }
}