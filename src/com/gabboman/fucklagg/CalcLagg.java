package com.gabboman.fucklagg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;

public class CalcLagg implements CommandExecutor {
	public final int count = 15;

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		Bukkit.getConsoleSender().sendMessage("Executing lagg killer by gabboman, designed for 4b4t");
		List<World> mundos = Bukkit.getWorlds();
		for (World a : mundos) {
			Bukkit.getConsoleSender().sendMessage("Calculating on world: " + a.getName());
			List<Entity> entities = a.getEntities();
			List<Entity> ordenadas = new ArrayList<Entity>();
			ordenadas.add(entities.get(0));
			entities.remove(0);
			while (entities.size() > 0) {
				Entity min = entities.get(0);
				for (Entity m : entities) {
					if (ordenadas.get(ordenadas.size() - 1).getLocation().distance(m.getLocation()) < ordenadas
							.get(ordenadas.size() - 1).getLocation().distance(min.getLocation())) {
						min = m;
					}
				}
				int minPos = entities.lastIndexOf(min);
				ordenadas.add(min);
				entities.remove(minPos);

			}
			entities = ordenadas;
			Map<Entity, Double> distances = new HashMap<Entity, Double>();
			for (int i = count; i < entities.size(); i++) {
				Double sum = 0.;
				for (int j = i + 1 - count; j < i - 1; j++) {
					sum = sum + entities.get(i).getLocation().distance(entities.get(j).getLocation());
				}
				sum = sum / count;
				distances.put(entities.get(i), sum);

			}
			Entity max = entities.get(count);
			for (Entity k : distances.keySet()) {
				if (distances.get(k) > distances.get(max)) {
					max = k;
				}
			}
			Bukkit.getConsoleSender().sendMessage("Possible lagg generator: " + max.getLocation().toString());
		}
		return true;
	}

	public class CompareEntityDistance implements Comparator<Entity> {

		public int compare(Entity arg0, Entity arg1) {

			return (int) arg0.getLocation().distance(arg1.getLocation());
		}

	}

}
