package org.openfootie.tfe.match;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Lineup {
	
	private TreeMap<TacticsPosition, Player> playerPositions;
	
	public Lineup(TreeMap<TacticsPosition, Player> players) {
		this.playerPositions = players;
	}
	
	public Set<TacticsPosition> getPositions() {
		return playerPositions.keySet();
	}
	
	public List<Player> getPlayersByTacticsLine(LinePosition linePosition) {
		
		List<Player> tacticsLinePlayers = new ArrayList<>();
		
		for (Map.Entry<TacticsPosition, Player> playerPosition: this.playerPositions.entrySet()) {
			
			if (playerPosition.getKey().getLinePosition().equals(linePosition)) {
				tacticsLinePlayers.add(playerPosition.getValue());
			}
		}
		
		return tacticsLinePlayers;
	}
	
	@Override
	public String toString() {
		
		StringBuilder strBuilder = new StringBuilder();
		
		for (Map.Entry<TacticsPosition, Player> player: this.playerPositions.entrySet()) {
			strBuilder.append(player.getValue().toString() + " - " + player.getKey().toString() + "\n");
		}
		
		return strBuilder.toString();
	}
}
