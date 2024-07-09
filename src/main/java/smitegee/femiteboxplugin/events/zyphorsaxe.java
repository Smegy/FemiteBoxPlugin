package smitegee.femiteboxplugin.events;

import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class zyphorsaxe implements Listener {

    public void EntityDamageEvent(EntityDamageByEntityEvent e) {
        Entity attacker = e.getDamager();
        Entity entity = e.getEntity();

        if (attacker instanceof Vindicator && entity instanceof Player) {



            Player player = (Player) entity;
            Vindicator vindicator = (Vindicator) attacker;
            player.setGlowing(true);
            player.getWorld().createExplosion(player.getLocation(), 10);

            entity.getLocation().getWorld().strikeLightning(entity.getLocation());
            entity.getLocation().getWorld().strikeLightning(entity.getLocation());
            entity.getLocation().getWorld().strikeLightning(entity.getLocation());
            entity.getLocation().getWorld().strikeLightning(entity.getLocation());
            entity.getLocation().getWorld().strikeLightning(entity.getLocation());

        }
    }
}
