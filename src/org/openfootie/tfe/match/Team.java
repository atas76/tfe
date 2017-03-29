package org.openfootie.tfe.match;

import java.util.ArrayList;
import java.util.List;

import org.openfootie.tfe.db.NationEntity;
import org.openfootie.tfe.db.PlayerEntity;
import org.openfootie.tfe.domain.Squad;

public class Team {
	
	private String name;
	private Squad<Player> squad;
	
	/**
	 * Loads the team details from a nation entity.
	 * 
	 * The team details required for pre-match are the name of the team, and the squad of players
	 * 
	 * @param nation the nation entity from which the details will be loaded
	 */
	// TODO: Provide a generic constructor based on a team entity 
	public Team(NationEntity nation) {
		
		this.name = nation.getName();
		
		List<Player> nationPlayers = new ArrayList<>();
		
		for (PlayerEntity playerEntity: nation.getSquad().getPlayers()) {
			nationPlayers.add(Player.load(playerEntity));
		}
		
		this.squad.setPlayers(nationPlayers);
	}
}
