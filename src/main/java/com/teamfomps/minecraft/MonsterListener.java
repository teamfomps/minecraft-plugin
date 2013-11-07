package com.teamfomps.minecraft;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.entity.Monster;

import org.bukkit.util.Vector;
import org.bukkit.util.BlockVector;

import org.bukkit.Location;

import java.util.logging.Logger;

public class MonsterListener implements Listener
{
    protected Logger logger;

    public MonsterListener(Logger logger)
    {
        this.logger = logger;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void preventHighAltitudeMonsterSpawns(CreatureSpawnEvent event)
    {
        // A y-value of 120 is just about cloud level.
        if (event.getLocation().getY() < 120) {
            return;
        }

        // Ignore creatures that aren't monsters
        if (! (event.getEntity() instanceof Monster)) {
            return;
        }

        // Ignore monsters spawned by a plugin.
        if (event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.CUSTOM) {
            return;
        }

        // OK, prevent the monster from spawning.
        event.setCancelled(true);
    }

    @EventHandler
    public void preventCreaturesFromSpawningNearMyPyramid(CreatureSpawnEvent event)
    {
        double x = event.getLocation().getX();
        double z = event.getLocation().getZ();

        if (x > -115 || x < -193) {
            return;
        }

        if (z < 210 || z > 288) {
            return;
        }

        // Ignore creatures spawned by a plugin
        if (event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.CUSTOM) {
            return;
        }

        event.setCancelled(true);
    }
}
