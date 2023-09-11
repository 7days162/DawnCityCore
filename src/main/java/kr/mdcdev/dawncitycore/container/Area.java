package kr.mdcdev.dawncitycore.container;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;

public interface Area {
    String getName();
    World getWorld();

    boolean contains(Location loc);

    <T extends Entity> boolean contains(T entity);
}
