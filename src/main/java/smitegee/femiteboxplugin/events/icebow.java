package smitegee.femiteboxplugin.events;

import org.bukkit.EntityEffect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class icebow implements Listener {

    // IceBow event listener goes here...
    public void OnProjectileHit(ProjectileHitEvent e) {

        Player p = (Player) e.getHitEntity();

        if (p.hasPermission("femiteboxplugin.fmb.bypassarrow")) return;

        PotionEffect potionEffect = new PotionEffect(PotionEffectType.SLOW, 5, 3, false, false, false);
        p.addPotionEffect(potionEffect);
        p.playSound(p.getLocation(), Sound.BLOCK_AMETHYST_CLUSTER_BREAK, 10, 2);
    }
}
