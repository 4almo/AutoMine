package fr.almo.automine;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public final class AutoMine extends JavaPlugin {
    private static AutoMine instance;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();

        BukkitTask spawnOresTask = new SpawnOresTask(this).runTaskTimer(this, 0, (20*60)*15);

        Bukkit.getServer().getPluginManager().registerEvents(new MineBreakListener(), this);

    }

        public static AutoMine getInstance() {
            return instance;
        }

}
