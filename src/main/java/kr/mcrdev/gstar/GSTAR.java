package kr.mcrdev.gstar;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public final class GSTAR extends JavaPlugin {
    public static Set<Player> EXCEPT = new HashSet<>();
    public static String TITLE_MESSAGE = "";
    public static boolean WAITING = false;

    @Override
    public void onEnable() {
        // Listener
        Bukkit.getPluginManager().registerEvents(new GListener(), this);

        // Command
        getCommand("system").setExecutor(new GCommand());

        // Thread
        Bukkit.getScheduler().runTaskTimer(this, new GThread30(), 600, 600);
        Bukkit.getScheduler().runTaskTimer(this, new GThread1(), 20, 20);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
