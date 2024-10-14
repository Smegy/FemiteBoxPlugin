package smitegee.femiteboxplugin.Boss;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Husk;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class Zombie implements Listener {

    @EventHandler
    public void onBossItemDrop(PlayerDropItemEvent e) {

        Player p = e.getPlayer();
        ItemStack item = e.getItemDrop().getItemStack();

        ItemStack zombie_helmet = new ItemStack(Material.LEATHER_HELMET);
        zombie_helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 12);

        ItemStack zombie_weapon = new ItemStack(Material.IRON_SWORD);
        zombie_weapon.addEnchantment(Enchantment.DAMAGE_ALL, 10);



        if (item.getType().equals(Material.SEA_PICKLE)) {
            e.setCancelled(true);
            Husk zombie = (Husk) p.getWorld().spawnEntity(p.getLocation(), EntityType.HUSK);
            int x = zombie.getLocation().getBlockX();
            int y = zombie.getLocation().getBlockY();
            int z = zombie.getLocation().getBlockZ();

           zombie.getWorld().spawnParticle(Particle.DRAGON_BREATH, zombie.getLocation(), 100);
            zombie.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, zombie.getLocation(), 100);

            zombie.setMaxHealth(601);
            zombie.setHealth(600);

            zombie.getEquipment().setHelmet(zombie_helmet);
            zombie.getEquipment().setItemInMainHand(zombie_weapon);

            zombie.setCustomName(ChatColor.RED + "Zombie");
            zombie.setCustomNameVisible(true);

            zombie.getEquipment().setItemInMainHandDropChance(0);

            p.sendMessage(ChatColor.YELLOW + "A Zombie has been summoned!");
        } else return;
    }

    @EventHandler
    public void onBossDeath(EntityDeathEvent e) {
        Component comp = Component.text("Zombie Flesh").color(TextColor.color(80, 0, 4)).decorate(TextDecoration.BOLD);
        Entity ent = e.getEntity();

        ItemStack zombie_drop = new ItemStack(Material.SEA_LANTERN);
        zombie_drop.editMeta(itemMeta -> {
            itemMeta.displayName(comp);
        });

        if (ent instanceof Husk && ent.getCustomName().contains("Zom")) {
            Location loc = ent.getLocation();

            ent.getWorld().dropItem(loc, zombie_drop);
            ent.getWorld().spawnParticle(Particle.DRAGON_BREATH, ent.getLocation(), 100);
            ent.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, ent.getLocation(), 100);

        } else return;
    }
}