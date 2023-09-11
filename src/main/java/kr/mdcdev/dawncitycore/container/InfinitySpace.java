package kr.mdcdev.dawncitycore.container;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;

import kr.mdcdev.dawncitycore.Reference;

public class InfinitySpace implements Area {
    private static final InfinitySpace INFINITY_SPACE = new InfinitySpace("INFINITY_SPACE", Reference.DEFAULT_WORLD);

    private final String name;
    private final World world;

    public InfinitySpace(String name, World world) {
        this.name = name;
        this.world = world;
    }

    public static InfinitySpace getInstance() {
        return INFINITY_SPACE;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public World getWorld() {
        return world;
    }

    @Override
    public boolean contains(Location loc) {
        return world.equals(loc.getWorld());
    }

    @Override
    public <T extends Entity> boolean contains(T entity) {
        return world.equals(entity.getWorld());
    }
    
}
