package smitegee.femiteboxplugin.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class frostblade implements Listener {

    public void EntityDamageByEntityEvent(EntityDamageByEntityEvent e) {
        Player dmg = (Player) e.getDamager();
        Player def = (Player) e.getEntity();
        ItemStack item = dmg.getInventory().getItemInMainHand();
        PotionEffect potionEffect = new PotionEffect(PotionEffectType.SLOW, 2,255, false, false, false);
        PotionEffect potionEffect2 = new PotionEffect(PotionEffectType.WEAKNESS, 5,3, false, false, false);

        if (item.getType().equals(Material.DIAMOND_SWORD) &&
                item.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "" + ChatColor.BOLD + "Frost Blade")) {

            def.addPotionEffect(potionEffect);
            def.addPotionEffect(potionEffect2);
            dmg.sendMessage("Congratulations! you just froze some random kid named " + def.getName());

        }
    }
}
