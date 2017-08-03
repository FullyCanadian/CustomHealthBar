package me.fullycanadian.playerhealthpworld;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Main.getInstance().getScoreboardManager().setScoreboard(e.getPlayer());
    }

    @EventHandler
    public void onWorldSwitch(PlayerChangedWorldEvent e) {
        Main.getInstance().getScoreboardManager().setScoreboard(e.getPlayer());
    }

}
