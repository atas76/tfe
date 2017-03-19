package org.openfootie.tfe.db;

public class NationEntity implements Entity, TeamEntity {
	
	private String name;

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
}
