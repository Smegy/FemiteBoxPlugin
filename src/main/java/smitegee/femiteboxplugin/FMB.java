package smitegee.femiteboxplugin;

import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;
import smitegee.femiteboxplugin.commands.FemiteBoxPlugin;
import smitegee.femiteboxplugin.events.BowTNTEvent;
import smitegee.femiteboxplugin.events.lsword;
import smitegee.femiteboxplugin.events.zyphorsaxe;

public class FMB extends JavaPlugin{
    @Override
    public void onEnable() {
        //
        getServer().getPluginManager().registerEvents(new BowTNTEvent(), this);
        getCommand("femiteboxplugin").setExecutor(new FemiteBoxPlugin());
        getServer().getPluginManager().registerEvents(new lsword(), this);
        getServer().getPluginManager().registerEvents(new zyphorsaxe(), this);

        //Permissions

        Bukkit.getPluginManager().addPermission(new Permission("femiteboxplugin.fmb.admin.likeluckperms.menu"));
        Bukkit.getPluginManager().addPermission(new Permission("femiteboxplugin.*"));
        Bukkit.getPluginManager().addPermission(new Permission("femiteboxplugin.fmb.admin.getitem.weapon"));
        Bukkit.getPluginManager().addPermission(new Permission("femiteboxplugin.fmb.admin.zyphorsaxe"));

    }
}