package smitegee.femiteboxplugin.elemental.shadow;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ShadowCloakLeggings implements Listener {

    private JavaPlugin plugin;

    public ShadowCloakLeggings(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerToggleSneak(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        ItemStack leggings = player.getInventory().getLeggings();

        if (leggings != null && leggings.getType() == Material.DIAMOND_LEGGINGS && leggings.getItemMeta().getDisplayName().equals("Shadow Leggings")) {
            if (player.isSneaking()) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1, false, false));
            } else {
                player.removePotionEffect(PotionEffectType.INVISIBILITY);
            }
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        ItemStack leggings = player.getInventory().getLeggings();

        if (leggings != null && leggings.getType() == Material.DIAMOND_LEGGINGS && leggings.getItemMeta().getDisplayName().equals("Shadow Leggings")) {
            if (player.getVelocity().length() == 0) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1, false, false));
            } else {
                player.removePotionEffect(PotionEffectType.INVISIBILITY);
            }
        }
    }
}