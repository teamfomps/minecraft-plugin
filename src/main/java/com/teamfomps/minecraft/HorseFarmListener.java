package com.teamfomps.minecraft;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Slime;

import java.util.logging.Logger;

public class HorseFarmListener implements Listener
{
    protected Logger logger;

    public HorseFarmListener(Logger logger)
    {
        this.logger = logger;
    }

    @EventHandler
    public void preventMonsterSpawn(CreatureSpawnEvent event)
    {
        boolean cancelled = false;
        double x = event.getLocation().getX();
        double z = event.getLocation().getZ();
        LivingEntity entity = event.getEntity();

        // Ignore creatures that aren't monsters
        if (! (entity instanceof Monster || entity instanceof Slime)) {
            return;
        }

        // Ignore creatures spawned by a plugin
        if (event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.CUSTOM) {
            return;
        }

        // Main Farm
        if (x <= -357 && x >= -453 && z <= 53 && z >= -47) {
            cancelled = true;
        }

        // Field Behind Farm
        if (x >= -437 && x <= -345 && z >= -171 && z <= -47) {
            cancelled = true;
        }

        if (cancelled) {
            event.setCancelled(true);
        }
    }
}
