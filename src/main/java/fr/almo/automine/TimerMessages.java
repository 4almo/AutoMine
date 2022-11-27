package fr.almo.automine;

import org.bukkit.*;
import org.bukkit.scheduler.BukkitRunnable;

public class TimerMessages extends BukkitRunnable {

    private final AutoMine plugin;
    public TimerMessages (AutoMine plugin) {
        this.plugin = plugin;
    }

    int timer = 900;

    @Override
    public void run() {

        if(timer == 600 || timer == 300){ //10 minutes et 5 minutes
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&f[&e&l!&r&f]&r&7 La mine de diamant va se régénérer dans&e&l " + timer / 60 + " &r&7minutes !"));

        }

        if(timer == 0){
            cancel();
        }


        timer --;
    }
}
