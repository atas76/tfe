package org.openfootie.tfe.db;

public class ClubEntity implements Entity, TeamEntity {
	
	private SquadEntity squad;
	
	public SquadEntity getSquad() {
		return this.squad;
	}
}
