package smitegee.femiteboxplugin;

import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;
import smitegee.femiteboxplugin.commands.FMBAdmin;
import smitegee.femiteboxplugin.commands.FemiteBoxPlugin;
import smitegee.femiteboxplugin.commands.fmbsee;
import smitegee.femiteboxplugin.events.BowTNTEvent;
import smitegee.femiteboxplugin.events.customenchantments;
import smitegee.femiteboxplugin.events.lsword;
import smitegee.femiteboxplugin.events.zyphorsaxe;

public class FMB extends JavaPlugin{

    //Make a money integer for every player


    @Override
    public void onEnable() {

        Bukkit.getServer().getLogger().warning("I forgot");

        //Events
        getServer().getPluginManager().registerEvents(new BowTNTEvent(), this);
        getServer().getPluginManager().registerEvents(new lsword(), this);
        getServer().getPluginManager().registerEvents(new zyphorsaxe(), this);
        getServer().getPluginManager().registerEvents(new customenchantments(), this);

        //Commands
        getCommand("femiteboxplugin").setExecutor(new FemiteBoxPlugin());
        getCommand("fmbadmin").setExecutor(new FMBAdmin());
        getCommand("fmbsee").setExecutor(new fmbsee());

        //Permissions
        Bukkit.getPluginManager().addPermission(new Permission("femiteboxplugin.fmb.admin.likeluckperms.menu"));
        Bukkit.getPluginManager().addPermission(new Permission("femiteboxplugin.fmb.admin.getitem"));
        Bukkit.getPluginManager().addPermission(new Permission("femiteboxplugin.fmb.admin.zyphorsaxe"));
        Bukkit.getPluginManager().addPermission(new Permission("femiteboxplugin.fmb.showitem"));
        Bukkit.getPluginManager().addPermission(new Permission("femiteboxplugin.admin"));


    }
}