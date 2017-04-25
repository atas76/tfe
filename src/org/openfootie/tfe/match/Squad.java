package org.openfootie.tfe.match;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openfootie.tfe.db.LinePosition;

public class Squad {
	
	private List<Player> players = new ArrayList<>();
	
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	public Map<LinePosition, List<Player>> mapPlayersByPositions() {
		
		Map<LinePosition, List<Player>> positionPlayerMap = new TreeMap<>();
		
		for (Player player: players) {
			positionPlayerMap.putIfAbsent(player.getLinePosition(), new ArrayList<Player>());
			positionPlayerMap.get(player.getLinePosition()).add(player);
		}
		
		return positionPlayerMap;
	}
}
