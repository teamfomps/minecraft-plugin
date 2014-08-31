package com.teamfomps.minecraft;

import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.Material;
import org.bukkit.material.PoweredRail;

import java.util.logging.Logger;

public class MinecartEjectionListener implements Listener
{
    protected Logger logger;

    public MinecartEjectionListener(Logger logger)
    {
        this.logger = logger;
    }

    @EventHandler
    public void ejectPassengerFromMinecartWhenPassingOverActivationRail(VehicleMoveEvent event)
    {
        // Unless the entity is a normal Minecart, we don't care.
        if (event.getVehicle().getType() != EntityType.MINECART) {
            return;
        }

        // Unless there's a passenger, we don't care.
        if (event.getVehicle().getPassenger() == null) {
            return;
        }

        // Unless we're passing over an Activator Rail, we don't care.
        if (event.getTo().getBlock().getType() != Material.ACTIVATOR_RAIL) {
            return;
        }

        // Unless the activator rail has Redstone current, we don't care.
        if ((event.getTo().getBlock().getData() & 0x8) != 0x8) {
            return;
        }

        // Eject the passenger from the cart.
        event.getVehicle().eject();
    }
}

