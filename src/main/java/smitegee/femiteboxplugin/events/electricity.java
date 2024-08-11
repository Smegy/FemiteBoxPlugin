package smitegee.femiteboxplugin.events;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.Sound;
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
        final TextComponent iname = Component.text("ᴘᴜʀᴇ ᴇʟᴇᴄᴛʀɪᴄɪᴛʏ", TextColor.color(248, 255, 110));

        ItemStack it = new ItemStack(Material.YELLOW_DYE, 1);
        it.editMeta(m -> m.displayName(iname));



        if (in.contains("ᴇ")) {
            if (in.contains("ʟ")) {
                if (in.contains("ᴇ")) {

                    if (hb.getType().equals(Material.COAL_BLOCK)) {
                        p.sendMessage("You have used your electricity");
                        p.getInventory().removeItem(i);
                        p.getInventory().addItem(it);
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_FLUTE, 1, 1);
                    } else return;
                } else return;
            } else return;

        } else return;

    }
}