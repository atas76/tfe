package org.openfootie.tfe.match;

import org.openfootie.tfe.db.LinePosition;
import org.openfootie.tfe.db.PlayerAttributesEntity;
import org.openfootie.tfe.db.PlayerEntity;

public class Player {
	
	private int shirtNumber;
	private String firstName;
	private String lastName;
	
	private int defending;
	private int shooting;
	private int passing;
	private int crossing;
	private int dribbling;
	private int outfield;
	private int goalkeeping;
	
	private LinePosition linePosition;
	
	public LinePosition getLinePosition() {
		return this.linePosition;
	}
	
	private Player(int shirtNumber, String firstName, String lastName, LinePosition linePosition) {
		this.shirtNumber = shirtNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.linePosition = linePosition;
	}
	
	private Player setAttributes(PlayerAttributesEntity attributes) {
		
		this.defending = attributes.getDefending();
		this.shooting = attributes.getShooting();
		this.passing = attributes.getPassing();
		this.crossing = attributes.getCrossing();
		this.dribbling = attributes.getDribbling();
		this.outfield = attributes.getOutfield();
		this.goalkeeping = attributes.getGoalkeeping();
		
		return this;
	}
	
	@Override
	public String toString() {
		return this.shirtNumber + " " + this.firstName + " " + this.lastName;
	}
	
	public static Player load(PlayerEntity entity) {
		return new Player(entity.getShirtNumber(), entity.getFirstName(), entity.getLastName(), entity.getLinePosition())
				.setAttributes(entity.getPlayerAttributes());
	}
}
