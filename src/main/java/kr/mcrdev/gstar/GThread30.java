package kr.mcrdev.gstar;

import org.bukkit.Bukkit;

public class GThread30 implements Runnable {
    @Override
    public void run() {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "save-all");
        System.out.println("SERVER SAVED");
    }
}
