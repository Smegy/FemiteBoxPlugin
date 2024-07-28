package smitegee.femiteboxplugin;

import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;
import smitegee.femiteboxplugin.commands.*;
import smitegee.femiteboxplugin.events.*;

public class FMB extends JavaPlugin{

    //Make a money integer for every player


//      <dependency>
//          <groupId>net.kyori</groupId>
//          <artifactId>adventure-api</artifactId>
//          <version>4.5.0</version>
//      </dependency>


    @Override
    public void onEnable() {

        Bukkit.getServer().getLogger().warning("I forgot");

        //Events
        getServer().getPluginManager().registerEvents(new BowTNTEvent(), this);
        getServer().getPluginManager().registerEvents(new lsword(), this);
        getServer().getPluginManager().registerEvents(new zyphorsaxe(), this);
        getServer().getPluginManager().registerEvents(new customenchantments(), this);
        getServer().getPluginManager().registerEvents(new itemtag(), this);
        getServer().getPluginManager().registerEvents(new BlockFindingEvents(), this);

        //Commands
        getCommand("femiteboxplugin").setExecutor(new FemiteBoxPlugin());
        getCommand("fmbadmin").setExecutor(new FMBAdmin());
        getCommand("fmbsee").setExecutor(new fmbsee());
        getCommand("summonmob").setExecutor(new summonmob());
        getCommand("keypad").setExecutor(new keypad());


        //Permissions
        Bukkit.getPluginManager().addPermission(new Permission("femiteboxplugin.fmb.admin.likeluckperms.menu"));
        Bukkit.getPluginManager().addPermission(new Permission("femiteboxplugin.fmb.admin.getitem"));
        Bukkit.getPluginManager().addPermission(new Permission("femiteboxplugin.fmb.admin.zyphorsaxe"));
        Bukkit.getPluginManager().addPermission(new Permission("femiteboxplugin.fmb.showitem"));
        Bukkit.getPluginManager().addPermission(new Permission("femiteboxplugin.admin"));
        Bukkit.getPluginManager().addPermission(new Permission("femiteboxplugin.default"));


        //Config
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();
        reloadConfig();
        Bukkit.getConsoleSender().sendMessage("FemiteBoxPlugin has been enabled!");
    }
}