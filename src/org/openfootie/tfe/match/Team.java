package org.openfootie.tfe.match;

import java.util.ArrayList;
import java.util.List;

import org.openfootie.tfe.db.NationEntity;
import org.openfootie.tfe.db.PlayerEntity;

public class Team {
	
	private String name;
	private Squad<Player> squad;
	
	private Coach coach = new Coach(); // Default implementation of a generic coach
	
	private Tactics tactics;
	
	/**
	 * Loads the team details from a nation entity.
	 * 
	 * The team details required for pre-match are the name of the team, and the squad of players
	 * 
	 * Also in current implementation we include the lineup and tactics selection wrapped in a formation object
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
	
		// Selected players are also loaded into selected tactics (and ideally tactics selection also depends on the players) 
		this.tactics = this.coach.selectFormation(this.squad);
	}
}
