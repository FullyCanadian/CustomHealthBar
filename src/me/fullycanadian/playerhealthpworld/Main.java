package me.fullycanadian.playerhealthpworld;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin {

    private static Main instance;
    private ScoreboardManager scoreboardManager;
    private ConfigManager configManager;



    @Override
    public void onEnable() {
        instance = this;

        // Instantiate managers
        scoreboardManager = new ScoreboardManager();
        configManager = new ConfigManager();


        // Runnable to update player health
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                getScoreboardManager().setScoreboard();
            }
        }, 0, 10);


        // Initializes scoreboard
        getScoreboardManager().registerScoreBoard();
        getScoreboardManager().objRegister();


        Bukkit.getServer().getLogger().info(">>> " + getDescription().getName() + " V " + getDescription().getVersion() + " has been enabled <<<");

        // Creates default config if config doesn't exist
        if (!getConfigManager().configExists()) {
            getConfigManager().createDefaultConfig();
        }


        // Puts worlds into hashset
        getConfigManager().getWorlds();

        saveConfig();




    }

    @Override
    public void onDisable() {
        Bukkit.getServer().getLogger().info(">>> " + getDescription().getName() + " V " + getDescription().getVersion() + " has been disabled <<<");
        saveConfig();
    }


    public static Main getInstance() {
        return instance;
    }

    private ScoreboardManager getScoreboardManager() { return scoreboardManager; }

    private ConfigManager getConfigManager() { return configManager; }

}