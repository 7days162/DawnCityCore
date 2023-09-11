package kr.mdcdev.dawncitycore.container;

import java.security.InvalidParameterException;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;

public class Area2D implements Area {
    protected final World world;
    protected final String name;
    protected final int x1, x2, z1, z2;

    public Area2D(String name, World world, int x1, int x2, int z1, int z2) {
        this.name = name;
        this.world = world;

        this.x1 = Math.min(x1, x2);
        this.x2 = Math.max(x1, x2);
        this.z1 = Math.min(z1, z2);
        this.z2 = Math.max(z1, z2);
    }

    public Area2D(String name, Location loc1, Location loc2) {
        this(name, loc1.getWorld(), loc1.getBlockX(), loc2.getBlockX(), loc1.getBlockZ(), loc2.getBlockZ());

        if(loc1.getWorld() != loc2.getWorld()) {
            throw new InvalidParameterException("World of loc1 is not same as world of loc2 in area " + name);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean contains(Location loc) {
        return (x1 <= loc.getBlockX() && loc.getBlockX() <= x2) && (z1 <= loc.getBlockZ() && loc.getBlockZ() <= z2); 
    }

    @Override
    public <T extends Entity> boolean contains(T entity) {
        return contains(entity.getLocation());
    }

    @Override
    public World getWorld() {
        return world;
    }
    
}
