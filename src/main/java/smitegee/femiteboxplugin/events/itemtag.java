package smitegee.femiteboxplugin.events;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.util.ComponentMessageThrowable;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class itemtag implements Listener {


    @EventHandler
    public void AsyncPlayEvent(AsyncChatEvent e) {
        Player p = (Player) e.getPlayer();
        String msg = e.message().toString();
        //check what the msg is needed from config.yml

        if (msg.equals("SHOW-ITEM")) {
            e.setCancelled(true);
            ItemStack item = p.getInventory().getItemInMainHand();
            Bukkit.getServer().broadcastMessage(p.getName() + " has shown their item: " + item.getItemMeta().getDisplayName());
        } else {
            //do nothing if the msg is not the one needed
            return;
        }
    }
}

