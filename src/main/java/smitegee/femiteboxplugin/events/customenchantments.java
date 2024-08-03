package smitegee.femiteboxplugin.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class customenchantments implements Listener {


    // Summon mob if hit (if lots enchant)
    @EventHandler
    public void EDBEA(EntityDamageByEntityEvent e) {


        if (e.getDamager() == (Player) e.getDamager() && e.getEntity() == (Player) e.getEntity()) {

            Player ent = (Player) e.getEntity();
            Entity dmg = (Entity) e.getDamager();



                //spawn 3 zombies on the damager

                ItemStack itemStack = ent.getEquipment().getItemInMainHand();

                //get enchantment


                if (ent.getEquipment().getHelmet().containsEnchantment(Enchantment.LUCK)) {
                    for (int i = 0; i < 3; i++) {
                        Husk zombie = (Husk) ent.getWorld().spawnEntity(ent.getLocation(), EntityType.HUSK);
                        zombie.setBaby(true);
                        zombie.setCustomName(ChatColor.RED + "Killer Zombie");
                        zombie.setCustomNameVisible(true);
                        zombie.attack(dmg);
                    }
                } else return;

                if (ent.getEquipment().getHelmet().containsEnchantment(Enchantment.PIERCING)) {
                    for (int i = 0; i < 5; i++) {
                        IronGolem zombie = (IronGolem) ent.getWorld().spawnEntity(ent.getLocation(), EntityType.IRON_GOLEM);
                            zombie.setCustomName(ChatColor.RED + "Bloody Golem");
                        zombie.setCustomNameVisible(true);
                        zombie.attack(dmg);
                    }
                } else return;

                if (ent.getEquipment().getHelmet().containsEnchantment(Enchantment.VANISHING_CURSE)) {
                    for (int i = 0; i < 8; i++) {
                        WitherSkeleton zombie = (WitherSkeleton) ent.getWorld().spawnEntity(ent.getLocation(), EntityType.WITHER_SKELETON);
                        PotionEffect pot = new PotionEffect(PotionEffectType.SPEED, 10000, 3, false,false, false);
                        zombie.addPotionEffect(pot);
                        PotionEffect pot2 = new PotionEffect(PotionEffectType.HARM, 10000, 3, false,false, false);
                        zombie.addPotionEffect(pot2);
                        zombie.setCustomName(ChatColor.RED + "Killer Skeleton");
                        zombie.setCustomNameVisible(true);
                        zombie.attack(dmg);
                    }
                } else return;
            } else return;
        }


    // Mine a 3x3 area if the player has lure on thier helmet
    @EventHandler
    public void BBA(BlockBreakEvent e) {
        Player player = e.getPlayer();

        if (player.getEquipment().getItemInMainHand() == null) return;

        if (e.getBlock().getType().equals(Material.BEDROCK)) return;

        if (!player.getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.LURE) &&
                !player.getInventory().getItemInMainHand().getType().equals(Material.NETHERITE_PICKAXE)) return;

        int x = e.getBlock().getLocation().getBlockX();
        int y = e.getBlock().getLocation().getBlockY();
        int z = e.getBlock().getLocation().getBlockZ();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                for (int k = -1; k <= 1; k++) {
                    Material blockType = e.getPlayer().getWorld().getBlockAt(x + i, y + j, z + k).getType();

                    if (blockType.equals(Material.BEDROCK)) {
                        Bukkit.getServer().getLogger().warning("Bedrock in way");
                        continue; // Skip breaking bedrock
                    }

// Break the block and give everything to the player
                    e.getPlayer().getWorld().getBlockAt(x + i, y + j, z + k).breakNaturally(player.getInventory().getItemInMainHand());
                }
            }
        }
    }
}
