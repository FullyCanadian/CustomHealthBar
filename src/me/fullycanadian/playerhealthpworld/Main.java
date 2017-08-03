package me.fullycanadian.playerhealthpworld;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

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


        // Registers events
        getServer().getPluginManager().registerEvents(new Events(), this);

        // Initializes scoreboard
        getScoreboardManager().registerScoreBoard();
        getScoreboardManager().objRegister();


        // Creates default config if config doesn't exist
        if (!getConfigManager().configExists()) {
            getConfigManager().createDefaultConfig();
        }


        // Puts worlds into hashset
        getConfigManager().getWorlds();

        saveConfig();

        Bukkit.getServer().getLogger().info(">>> " + getDescription().getName() + " V " + getDescription().getVersion() + " has been enabled <<<");


    }

    @Override
    public void onDisable() {
        Bukkit.getServer().getLogger().info(">>> " + getDescription().getName() + " V " + getDescription().getVersion() + " has been disabled <<<");
        saveConfig();
    }


    public static Main getInstance() {
        return instance;
    }

    public ScoreboardManager getScoreboardManager() { return scoreboardManager; }

    public ConfigManager getConfigManager() { return configManager; }

}
