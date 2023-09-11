package kr.mdcdev.dawncitycore.container;

import org.bukkit.Location;
import org.bukkit.World;

public class Area3D extends Area2D implements Area {
    protected final int y1, y2;

    public Area3D(String name, World world, int x1, int x2, int y1, int y2, int z1, int z2) {
        super(name, world, x1, x2, z1, z2);

        this.y1 = Math.min(y1, y2);
        this.y2 = Math.max(y1, y2);
    }

    public Area3D(String name, Location loc1, Location loc2) {
        this(name, loc1.getWorld(), loc1.getBlockX(), loc2.getBlockX(), loc1.getBlockY(), loc2.getBlockY(), loc1.getBlockZ(), loc2.getBlockZ());
    }
}
