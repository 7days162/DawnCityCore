package kr.mcrdev.gstar;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class GThread1 implements Runnable {
    @Override
    public void run() {
        for(Player player : Bukkit.getOnlinePlayers()) {
            if(GSTAR.WAITING && !player.isOp() && !GSTAR.EXCEPT.contains(player)) {
                player.sendTitle("", GSTAR.TITLE_MESSAGE, 0, 25, 0);
            }
        }
    }
}
