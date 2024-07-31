package smitegee.femiteboxplugin.elemental.lightning;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class thunder_clap implements Listener {

    private JavaPlugin plugin;

    public thunder_clap(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack chestplate = player.getInventory().getChestplate();


        if (chestplate != null && chestplate.getType() == Material.DIAMOND_CHESTPLATE && chestplate.getItemMeta().getDisplayName().equals("Lightning Chestplate")) {
            if (event.getAction().isRightClick()) {
                player.getWorld().strikeLightning(player.getLocation());
                player.getNearbyEntities(5, 5, 5).forEach(entity -> {
                    if (entity instanceof Player) {
                        Player nearbyPlayer = (Player) entity;
                        nearbyPlayer.damage(10);
                    }
            });
        }
    }
    }
}