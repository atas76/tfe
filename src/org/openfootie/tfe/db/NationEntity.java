package org.openfootie.tfe.db;

public class NationEntity implements Entity, TeamEntity {
	
	private String name;
	private SquadEntity squad = new SquadEntity();

	public NationEntity(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public SquadEntity getSquad() {
		return this.squad;
	}
}
