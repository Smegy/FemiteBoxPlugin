package smitegee.femiteboxplugin.events;

import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;

public class itemtag implements Listener {


    @EventHandler
    public void AsyncPlayEvent(AsyncChatEvent e) {
        Player p = (Player) e.getPlayer();
        Component msg = e.message();

        if (msg.equals("showmedatitem")) {
            e.setCancelled(true);
            ItemStack item = p.getInventory().getItemInMainHand();
            Bukkit.getServer().broadcastMessage(p.getName() + " has shown thier item: " + item.getItemMeta().getDisplayName());

        }
    }
}

