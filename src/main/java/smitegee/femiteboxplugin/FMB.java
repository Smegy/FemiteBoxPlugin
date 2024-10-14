package smitegee.femiteboxplugin;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import smitegee.femiteboxplugin.Boss.Zombie;
import smitegee.femiteboxplugin.HYPE.AspectOfEnd;
import smitegee.femiteboxplugin.commands.*;
import smitegee.femiteboxplugin.events.*;

public class FMB extends JavaPlugin{

    //Make a money integer for every player


/*      <dependency>
          <groupId>net.kyori</groupId>
          <artifactId>adventure-api</artifactId>
          <version>4.5.0</version>
        </dependency>
*/


    @Override
    public void onEnable() {

        //Events
        getServer().getPluginManager().registerEvents(new BowTNTEvent(), this);
        getServer().getPluginManager().registerEvents(new lsword(), this);
        getServer().getPluginManager().registerEvents(new customenchantments(), this);
        getServer().getPluginManager().registerEvents(new BlockFindingEvents(), this);
        getServer().getPluginManager().registerEvents(new AspectOfEnd(), this);

        //Commands
        getCommand("femiteboxplugin").setExecutor(new FemiteBoxPlugin());
        getCommand("fmbsee").setExecutor(new fmbsee());
        getCommand("showtitle").setExecutor(new showtitleCommand());
        getCommand("maxhp").setExecutor(new setmaxhealth());
        getCommand("nv_class").setExecutor(new vision());



        // BOSS
        getServer().getPluginManager().registerEvents(new Zombie(), this);


        //Permissions
        Bukkit.getPluginManager().addPermission(new Permission("femiteboxplugin.fmb.admin.likeluckperms.menu"));
        Bukkit.getPluginManager().addPermission(new Permission("femiteboxplugin.getitem"));
        Bukkit.getPluginManager().addPermission(new Permission("femiteboxplugin.showitem"));
        Bukkit.getPluginManager().addPermission(new Permission("femiteboxplugin.admin"));
        Bukkit.getPluginManager().addPermission(new Permission("femiteboxplugin.commands.default"));
        Bukkit.getPluginManager().addPermission(new Permission("femiteboxplugin.admin.commands"));
        Bukkit.getPluginManager().addPermission(new Permission("femiteboxplugin.admin.commands.maxhp"));


        new BukkitRunnable() {
            @Override
            public void run() {
                final Component textComponent = Component.text("")
                        .append(Component.text("Hey! Please join our ", NamedTextColor.LIGHT_PURPLE).decorate(TextDecoration.BOLD))
                        .append(Component.text("Discord!", NamedTextColor.BLUE)
                                .clickEvent(ClickEvent.openUrl("https://discord.gg/6E6EjtHHcW")).decorate(TextDecoration.BOLD,TextDecoration.ITALIC));

// Send the message to all online players
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendMessage(textComponent);
                }
            }
        }.runTaskTimer(this, 0, 3600);
    }
    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("FemiteBoxPlugin has been disabled!");
    }

}

