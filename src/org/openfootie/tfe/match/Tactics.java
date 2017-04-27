package org.openfootie.tfe.match;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Tactics {
	
	private int def;
	private int mid;
	private int att;
	
	private String name;
	
	// TODO: Maybe use a map for these (?). For the time being we are using a "position line" enum only for presentational purposes
	private Player goalkeeper;
	private TacticsLine defenders;
	private TacticsLine midfielders;
	private TacticsLine attackers;
	
	public final static Tactics [] TACTICS = {
			new Tactics(4,4,2), new Tactics(4,3,3), new Tactics(5,3,2), new Tactics(4,5,1)
	};
	
	public Lineup generateLineup() {
		
		TreeMap<TacticsPosition, Player> tacticsPositions = new TreeMap<>();
		
		tacticsPositions.put(new TacticsPosition(LinePosition.GK, null), this.goalkeeper);
		flattenTacticsLine(LinePosition.D, this.defenders, tacticsPositions);
		flattenTacticsLine(LinePosition.M, this.midfielders, tacticsPositions);
		flattenTacticsLine(LinePosition.F, this.attackers, tacticsPositions);
		
		return new Lineup(tacticsPositions);
	}

	private void flattenTacticsLine(LinePosition linePosition, TacticsLine tacticsLine, TreeMap<TacticsPosition, Player> tacticsPositions) {
		for (Map.Entry<Position, Player> player: tacticsLine.getPlayers().entrySet()) {
			tacticsPositions.put(new TacticsPosition(linePosition, player.getKey()), player.getValue());
		}
	}
	
	public int getDefendersNum() {
		return this.def;
	}
	
	public int getMidfieldersNum() {
		return this.mid;
	}
	
	public int getAttackersNum() {
		return this.att;
	}
	
	private void setPlayers(List<Player> players, TacticsLine tacticsLine) {
		tacticsLine.setPlayers(players);
	}
	
	public void setGoalkeeper(Player goalkeeper) {
		this.goalkeeper = goalkeeper;
	}
	
	public void setDefenders(List<Player> defenders) {
		setPlayers(defenders, this.defenders);
	}
	
	public void setMidfielders(List<Player> midfielders) {
		setPlayers(midfielders, this.midfielders);
	}
	
	public void setAttackers(List<Player> attackers) {
		setPlayers(attackers, this.attackers);
	}
	
	public Tactics(int def, int mid, int att) {
		
		this.def = def;
		this.mid = mid;
		this.att = att;
		
		// form name by default
		this.name = this.def + "-" + this.mid + "-" + this.att;
		
		// form default tactics lines based on tactics description
		this.defenders = new TacticsLine(this.def);
		this.midfielders = new TacticsLine(this.mid);
		this.attackers = new TacticsLine(this.att);
	}
}
