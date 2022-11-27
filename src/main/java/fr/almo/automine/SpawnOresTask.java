package fr.almo.automine;

import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.scheduler.BukkitRunnable;

public class SpawnOresTask extends BukkitRunnable {

    AutoMine plugin;
    public SpawnOresTask(AutoMine plugin) {
        this.plugin = plugin;
    }


    int timer = 900; //15 minutes

    @Override
    public void run() {

        //Get the configuration..
        FileConfiguration config = plugin.getConfig();

        //Get the world of mine 1.
        String worldName = config.getString("mine1.world");
        World world = Bukkit.getWorld(worldName);

        //Get the location of the mine1.
        int x1 = config.getInt("mine1.x1");
        int y1 = config.getInt("mine1.y1");
        int z1 = config.getInt("mine1.z1");

        //Setup location for mine1.
        Location mine1 = new Location(world, x1, y1, z1);

        //Spawn the diamond ore at the location, send message to everyone.
        mine1.getBlock().setType(Material.DIAMOND_ORE);
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&f[&e&l!&r&f]&r&7 Un &bdiamant &r&7vient d'apparaître en&f " + x1 + ", " + y1 + ", " + z1 + " &7!"));

        //Send messages to everyone when the mine will regenerate in 10||5 minutes.
        TimerMessages start =  new TimerMessages(plugin);
        start.runTaskTimer(plugin, 0, 20);
    }
}
