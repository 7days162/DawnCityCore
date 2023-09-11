package kr.mdcdev.dawncitycore.container;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;

import kr.mdcdev.dawncitycore.Reference;

public class NullSpace implements Area {
    private static final NullSpace NULL_SPACE = new NullSpace("NULL_SPACE", Reference.DEFAULT_WORLD);

    private final String name;
    private final World world;

    public NullSpace(String name, World world) {
        this.name = name;
        this.world = world;
    }

    public static NullSpace getInstance() {
        return NULL_SPACE;
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
        return false;
    }

    @Override
    public <T extends Entity> boolean contains(T entity) {
        return false;
    }
    
}
