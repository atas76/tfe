package org.openfootie.tfe.match;

import java.util.Map;
import java.util.TreeMap;

public class Lineup {
	
	private TreeMap<TacticsPosition, Player> players;
	
	public Lineup(TreeMap<TacticsPosition, Player> players) {
		this.players = players;
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
