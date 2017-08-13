package me.fullycanadian.playerhealthpworld;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import static me.fullycanadian.playerhealthpworld.ConfigManager.healthEnabledWorlds;

    class ScoreboardManager {
    private Scoreboard board;

    void objRegister() {
        Objective obj = board.registerNewObjective("Health", "health");
        obj.setDisplaySlot(DisplaySlot.BELOW_NAME);
        obj.setDisplayName(ChatColor.RED + "❤");
    }


    void registerScoreBoard() {
        org.bukkit.scoreboard.ScoreboardManager manager = Bukkit.getScoreboardManager();
        board = manager.getNewScoreboard();
    }

    void setScoreboard(Player p) {
            if (healthEnabledWorlds.contains(p.getWorld().getName())) {
                p.setScoreboard(board);
            } else {
                p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
            }
        }
    }

