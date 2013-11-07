package com.teamfomps.minecraft;

import org.bukkit.plugin.java.JavaPlugin;

import com.teamfomps.minecraft.MonsterListener;

public class TeamFomps extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(new MonsterListener(getLogger()), this);
    }
}
