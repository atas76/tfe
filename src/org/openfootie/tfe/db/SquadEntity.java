package org.openfootie.tfe.db;

import java.util.ArrayList;
import java.util.List;

public class SquadEntity implements Entity {

	private List<PlayerEntity> players = new ArrayList<>();

	public List<PlayerEntity> getPlayers() {
		return players;
	}
	public void setPlayers(List<PlayerEntity> players) {
		this.players = players;
	}
}
