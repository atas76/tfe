package org.openfootie.tfe.match;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Lineup {
	
	private TreeMap<TacticsPosition, Player> players;
	
	public Lineup(TreeMap<TacticsPosition, Player> players) {
		this.players = players;
	}
	
	public Set<TacticsPosition> getPositions() {
		return players.keySet();
	}
	
	@Override
	public String toString() {
		
		StringBuilder strBuilder = new StringBuilder();
		
		for (Map.Entry<TacticsPosition, Player> player: this.players.entrySet()) {
			strBuilder.append(player.getValue().toString() + " - " + player.getKey().toString() + "\n");
		}
		
		return strBuilder.toString();
	}
}
