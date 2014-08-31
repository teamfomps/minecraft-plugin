package com.teamfomps.minecraft;

import org.bukkit.plugin.java.JavaPlugin;

import com.teamfomps.minecraft.MonsterListener;
import com.teamfomps.minecraft.HorseFarmListener;
import com.teamfomps.minecraft.MinecartEjectionListener;

public class TeamFomps extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        getServer()
          .getPluginManager()
          .registerEvents(new MonsterListener(getLogger()), this);
        getServer()
          .getPluginManager()
          .registerEvents(new HorseFarmListener(getLogger()), this);
        getServer()
          .getPluginManager()
          .registerEvents(new MinecartEjectionListener(getLogger()), this);
    }
}
