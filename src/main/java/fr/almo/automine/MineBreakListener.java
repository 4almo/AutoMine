package fr.almo.automine;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.scheduler.BukkitTask;

public class MineBreakListener implements Listener {

    AutoMine plugin;
    public MineBreakListener() {
        this.plugin = plugin;
    }


    @EventHandler
    public void onMineBreak(BlockBreakEvent e){

        FileConfiguration config = plugin.getConfig();

        String worldName = config.getString("mine1.world");
        World world = Bukkit.getWorld(worldName);

        int x = config.getInt("mine1.x");
        int y = config.getInt("mine1.y");
        int z = config.getInt("mine1.z");
        float yaw = (float) config.getDouble("mine.yaw");
        float pitch = (float) config.getDouble("mine.pitch");

        Location mine1 = new Location(world, x, y, z, yaw, pitch);

        if(e.getBlock().getLocation() == mine1){
            if(e.getBlock().getType() == Material.DIAMOND_ORE){
                BukkitTask spawnOresTask = new SpawnOresTask(plugin).runTaskTimer(plugin, 0, 20*10);
                Bukkit.broadcastMessage("respawn du diamant dans 10 secondes");
            }
        }

    }

}
