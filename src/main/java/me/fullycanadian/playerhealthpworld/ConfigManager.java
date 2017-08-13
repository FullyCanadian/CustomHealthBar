package me.fullycanadian.playerhealthpworld;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.util.HashSet;

 class ConfigManager {

    private FileConfiguration config = Main.getInstance().getConfig();

    static HashSet<String> healthEnabledWorlds = new HashSet<>();

    void createDefaultConfig() {
        config.options().copyDefaults(true);
        registerWorlds();

    }

    boolean configExists() {
        return new File(Main.getInstance().getDataFolder(), "config.yml").exists();
    }


     void getWorlds() {
        for (String key : config.getConfigurationSection("worlds").getKeys(false)) {
            if (config.getBoolean("worlds." + key)) {
                healthEnabledWorlds.add(key);
            }
        }

        }


        private void registerWorlds() {
        config = Main.getInstance().getConfig();
        for (World world : Bukkit.getServer().getWorlds()) {
            config.addDefault("worlds." + world.getName(), false);
            }
        }


}
