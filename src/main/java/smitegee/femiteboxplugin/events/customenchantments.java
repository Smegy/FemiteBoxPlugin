package smitegee.femiteboxplugin.events;

import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class customenchantments implements Listener {


    // Summon mob if hit (if lots enchant)
    public void EDBEA(EntityDamageByEntityEvent e) {


        if (e.getDamager() == (Player) e.getDamager() && e.getEntity() == (Player) e.getEntity()) {

            Player ent = (Player) e.getEntity();
            Player dmg = (Player) e.getDamager();

            if (ent.getEquipment().getHelmet().getItemMeta().hasEnchant(Enchantment.LUCK)) {

                //spawn 3 zombies on the damager
                for (int i = 0; i < 3; i++) {
                    Zombie zombie = (Zombie) ent.getWorld().spawnEntity(ent.getLocation(), EntityType.ZOMBIE);
                    zombie.setBaby(true);
                    zombie.setCustomName(ChatColor.RED + "Killer Zombie");
                    zombie.setCustomNameVisible(true);
                    ent.getWorld().playSound(ent.getLocation(), "mob.zombie.spawn", 1, 1);
                }
            }
        }
    }


    // Mine a 3x3 area if the player has lure on thier helmet

    public void BBA(BlockBreakEvent e) {
        Player player = e.getPlayer();

        if (player.getEquipment().getHelmet().getItemMeta().hasEnchant(Enchantment.LURE)) {

            int x = e.getBlock().getLocation().getBlockX();
            int y = e.getBlock().getLocation().getBlockY();
            int z = e.getBlock().getLocation().getBlockZ();

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    for (int k = -1; k <= 1; k++) {
                        e.getPlayer().getWorld().getBlockAt(x + i, y + j, z + k).breakNaturally();
                    }
                }
            }
        }
    }

}
