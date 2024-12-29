package com.spectrasonic.VichoBlockCheck;

import com.spectrasonic.VichoBlockCheck.Listener.BlockBreakListener;
import com.spectrasonic.VichoBlockCheck.Util.MessageUtils;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Getter
    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        registerEvents();
        MessageUtils.sendStartupMessage(this);
    }

    @Override
    public void onDisable() {
        MessageUtils.sendShutdownMessage(this);
    }

    public void registerEvents(){
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);

    }
}