package kr.mcrdev.gstar;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class GListener implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if(GSTAR.WAITING && !e.getPlayer().isOp() && !GSTAR.EXCEPT.contains(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
}
