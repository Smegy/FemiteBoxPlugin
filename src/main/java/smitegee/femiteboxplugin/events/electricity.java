package smitegee.femiteboxplugin.events;

import jdk.javadoc.internal.doclint.HtmlTag;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class electricity implements Listener {

    @EventHandler
    public void elecmain(PlayerInteractEvent e) {

        Player p = e.getPlayer();
        Block hb = e.getClickedBlock();
        ItemStack i = e.getItem();
        String in = i.getItemMeta().getDisplayName();



        if (in.contains("ᴇ")) {
            if (in.contains("ʟ")) {
                if (in.contains("ᴇ")) {

                    if (hb.getType().equals(Material.COAL_BLOCK)) {
                        p.sendMessage("You have used your electricity");
                    } else return;

                } else return;
            } else return;

        }else return;

    }
}