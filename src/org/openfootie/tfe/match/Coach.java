package org.openfootie.tfe.match;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openfootie.tfe.db.LinePosition;

public class Coach {
	
	private static Random rnd = new Random();
	
	/**
	 * 
	 * Select tactics based on coach-specific criteria and not on the given team
	 * 
	 * Currently, just a dummy implementation selecting a random tactic from the predefined ones
	 * 
	 * @return a random tactic. Future sophisticated versions will take into account coach "preferences"
	 */
	private Tactics selectTactics() {
		return Tactics.TACTICS[rnd.nextInt(Tactics.TACTICS.length)];
	}
	
	public Tactics selectFormation(Squad squad) {
		return selectLineup(squad, selectTactics());
	}
	
	private List<Player> selectRandom(List<Player> players, int num) {
		
		Collections.shuffle(players);
		
		return players.subList(0, num - 1);
	}
	
	/**
	 * 
	 * Our coach just selects random players at this stage
	 * 
	 * @param squad squad to pick players from
	 * @param tactics the tactics to put the players to (should affect the lineup)
	 * @return the modified tactics
	 */
	private Tactics selectLineup(Squad squad, Tactics tactics) {
		
		Map<LinePosition, List<Player>> playersByPosition = squad.mapPlayersByPositions();
		
		tactics.setGoalkeeper(selectRandom(playersByPosition.get(LinePosition.GK), 1).get(0));
		tactics.setDefenders(selectRandom(playersByPosition.get(LinePosition.D), tactics.getDefendersNum()));
		tactics.setMidfielders(selectRandom(playersByPosition.get(LinePosition.M), tactics.getMidfieldersNum()));
		tactics.setAttackers(selectRandom(playersByPosition.get(LinePosition.F), tactics.getAttackersNum()));
		
		return tactics;
	}
}
