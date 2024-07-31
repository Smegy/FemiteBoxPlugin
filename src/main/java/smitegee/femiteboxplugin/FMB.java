package smitegee.femiteboxplugin;

import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;
import smitegee.femiteboxplugin.commands.*;
import smitegee.femiteboxplugin.elemental.Nightfall;
import smitegee.femiteboxplugin.elemental.lightning.Stormbringer;
import smitegee.femiteboxplugin.elemental.lightning.thunder_clap;
import smitegee.femiteboxplugin.elemental.shadow.ShadowCloakLeggings;
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
        getServer().getPluginManager().registerEvents(new zyphorsaxe(), this);
        getServer().getPluginManager().registerEvents(new customenchantments(), this);
        getServer().getPluginManager().registerEvents(new itemtag(), this);
        getServer().getPluginManager().registerEvents(new BlockFindingEvents(), this);

        //Commands
        getCommand("femiteboxplugin").setExecutor(new FemiteBoxPlugin());
        getCommand("fmbsee").setExecutor(new fmbsee());
        getCommand("summonmob").setExecutor(new summonmob());
        getCommand("keypad").setExecutor(new keypad());
        getCommand("crafting").setExecutor(new crafting());
        this.getCommand("showtitle").setExecutor(new showtitleCommand());


        //Elemental
        getServer().getPluginManager().registerEvents(new Stormbringer(), this);

        thunder_clap thunderClapChestplate = new thunder_clap(this);
        getServer().getPluginManager().registerEvents(thunderClapChestplate, this);

        ShadowCloakLeggings shadowCloakLeggings = new ShadowCloakLeggings(this);
        getServer().getPluginManager().registerEvents(shadowCloakLeggings, this);

        Nightfall nightfall = new Nightfall();
        getServer().getPluginManager().registerEvents(nightfall, this);


        //Permissions
        Bukkit.getPluginManager().addPermission(new Permission("femiteboxplugin.fmb.admin.likeluckperms.menu"));
        Bukkit.getPluginManager().addPermission(new Permission("femiteboxplugin.fmb.admin.getitem"));
        Bukkit.getPluginManager().addPermission(new Permission("femiteboxplugin.fmb.admin.zyphorsaxe"));
        Bukkit.getPluginManager().addPermission(new Permission("femiteboxplugin.fmb.showitem"));
        Bukkit.getPluginManager().addPermission(new Permission("femiteboxplugin.admin"));
        Bukkit.getPluginManager().addPermission(new Permission("femiteboxplugin.commands.default"));

        //Messages
        Bukkit.getConsoleSender().sendMessage("FemiteBoxPlugin has been enabled!");
        //Bzjjut,g
    }
}