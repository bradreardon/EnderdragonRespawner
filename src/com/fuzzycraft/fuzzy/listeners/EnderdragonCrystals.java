package com.fuzzycraft.fuzzy.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import com.fuzzycraft.fuzzy.EnderdragonRespawner;

public class EnderdragonCrystals implements Listener {
	
	public EnderdragonRespawner plugin;
	private World world;
	private List<Location> list = new ArrayList<Location>();
	
	/**
	 * Insert which world and location to spawn Enderdragon and which message to produce.
	 * @param plugin
	 * @param world
	 * @param location
	 * @param msg
	 */
	public EnderdragonCrystals(EnderdragonRespawner plugin, World world) {
		this.plugin = plugin;
		this.world = world;
	}
	
	/**
	 * Checks for death of Enderdragon crystal in specified world.
	 * @param event
	 */
	@EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
	public void onEntityDamage(EntityDamageEvent event) {
		Entity entity = event.getEntity();
		
		if(entity instanceof EnderCrystal) {
			list.add(entity.getLocation());
			System.out.println("true");
		}
	}
	
	public List<Location> getCrystalLocations() {
		return this.list;
	}
	
	/**
	 * Return current world.
	 * @return
	 */
	public World world() {
		return this.world;
	}
}