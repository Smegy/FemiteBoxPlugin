package smitegee.femiteboxplugin.elemental.lightning;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class Stormbringer implements Listener {

    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            ItemStack item = player.getInventory().getItemInMainHand();
            //get the display name as a component

            if (item != null && item.getType() == Material.DIAMOND_SWORD && item.getItemMeta().getDisplayName().equals(Component.text("ꜱᴛᴏʀᴍʙʀɪɴɢᴇʀ", TextColor.color( 201, 82, 232)))) {
                double chance = Math.random();
                if (chance < 0.2) { // 20% chance to call down lightning
                    event.getEntity().getWorld().strikeLightning(event.getEntity().getLocation());
                    event.setDamage(event.getDamage() + 5); // Extra damage
                    if (chance < 0.1) {
                        // Add stun effect here if needed
                        ((Player) event.getEntity()).addPotionEffect(new PotionEffect(org.bukkit.potion.PotionEffectType.BLINDNESS, 6, 1));
                    }
                }
            }
        }
    }
}