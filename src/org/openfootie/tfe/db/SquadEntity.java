package org.openfootie.tfe.db;

import java.util.List;

public class SquadEntity implements Entity {

	private TeamEntity team;
	private List<PlayerEntity> players;
	
	public SquadEntity(TeamEntity team, List<PlayerEntity> players) {
		super();
		this.team = team;
		this.players = players;
	}

	public TeamEntity getTeam() {
		return team;
	}
	public void setTeam(TeamEntity team) {
		this.team = team;
	}
	public List<PlayerEntity> getPlayers() {
		return players;
	}
	public void setPlayers(List<PlayerEntity> players) {
		this.players = players;
	}
}
