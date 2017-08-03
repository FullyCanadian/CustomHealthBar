package me.fullycanadian.playerhealthpworld;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.util.HashSet;

public class ConfigManager {

    private FileConfiguration config;

    public static HashSet<String> healthEnabledWorlds = new HashSet<>();

    public void createDefaultConfig() {
        Main.getInstance().getConfig().options().copyDefaults(true);
        this.registerWorlds();
    }

    public boolean configExists() {
        if (!new File(Main.getInstance().getDataFolder(), "config.yml").exists()) {
            return false;
        } else { return true; }
    }


    public void getWorlds() {
        config = Main.getInstance().getConfig();
        for (String key : config.getConfigurationSection("worlds").getKeys(false)) {
            if (config.getBoolean("worlds." + key)) {
                healthEnabledWorlds.add(key);
            }
        }

        }


        public void registerWorlds() {
        config = Main.getInstance().getConfig();
        for (World world : Bukkit.getServer().getWorlds()) {
            config.addDefault("worlds." + world.getName(), false);
            }
        }


}
