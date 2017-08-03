package me.fullycanadian.playerhealthpworld;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import static me.fullycanadian.playerhealthpworld.ConfigManager.healthEnabledWorlds;

public class ScoreboardManager {
    private Objective objective;

    private org.bukkit.scoreboard.ScoreboardManager manager;

    private Scoreboard board;

    public void objRegister() {
        objective = board.registerNewObjective("Health", "health");
        objective.setDisplaySlot(DisplaySlot.BELOW_NAME);
        objective.setDisplayName(ChatColor.RED + "❤");
    }


    public void registerScoreBoard() {
        manager = Bukkit.getScoreboardManager();
        board = manager.getNewScoreboard();
    }

    public void setScoreboard(Player p) {
            if (healthEnabledWorlds.contains(p.getWorld().getName())) {
                p.setScoreboard(board);
            } else {
                p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
            }
        }
    }

