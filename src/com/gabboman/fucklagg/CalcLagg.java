package com.gabboman.fucklagg;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;

public class CalcLagg implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		Bukkit.getConsoleSender().sendMessage("Executing lagg killer by gabboman");
		List<World> mundos=Bukkit.getWorlds();
		for (World a : mundos){
			Bukkit.getConsoleSender().sendMessage("Calculating on world: "+a.getName());
			List<Entity> entities=a.getEntities();
			Collections.sort(entities, new CompareEntityDistance());
			for (int i=5;i<entities.size();i++){
				
			}
		}
		return false;
	}
	
	public class CompareEntityDistance implements Comparator<Entity>{

		public int compare(Entity arg0, Entity arg1) {
			
			return (int) arg0.getLocation().distance(arg1.getLocation());
		}
		
	}

}
