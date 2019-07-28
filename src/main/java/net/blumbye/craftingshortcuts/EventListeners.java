package net.blumbye.craftingshortcuts;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;

public class EventListeners implements Listener {

    ArrayList<NamespacedKey> recipes;
    public EventListeners(ArrayList<NamespacedKey> recipes) {
        this.recipes = recipes;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        p.discoverRecipes(recipes);
    }
}
