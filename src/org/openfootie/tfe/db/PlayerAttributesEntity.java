package org.openfootie.tfe.db;

public class PlayerAttributesEntity implements Entity {
	
	private int defending;
	private int shooting;
	private int passing;
	private int crossing;
	private int dribbling;
	private int outfield;
	private int goalkeeping;
	
	public PlayerAttributesEntity(int defending, int shooting, int passing, int crossing, int dribbling, int outfield, int goalkeeping) {
		super();
		this.defending = defending;
		this.shooting = shooting;
		this.passing = passing;
		this.crossing = crossing;
		this.dribbling = dribbling;
		this.outfield = outfield;
		this.goalkeeping = goalkeeping;
	}
	
	public int getDefending() {
		return defending;
	}
	public void setDefending(int defending) {
		this.defending = defending;
	}
	public int getShooting() {
		return shooting;
	}
	public void setShooting(int shooting) {
		this.shooting = shooting;
	}
	public int getPassing() {
		return passing;
	}
	public void setPassing(int passing) {
		this.passing = passing;
	}
	public int getCrossing() {
		return crossing;
	}
	public void setCrossing(int crossing) {
		this.crossing = crossing;
	}
	public int getDribbling() {
		return dribbling;
	}
	public void setDribbling(int dribbling) {
		this.dribbling = dribbling;
	}
	public int getOutfield() {
		return outfield;
	}
	public void setOutfield(int outfield) {
		this.outfield = outfield;
	}
	public int getGoalkeeping() {
		return goalkeeping;
	}
	public void setGoalkeeping(int goalkeeping) {
		this.goalkeeping = goalkeeping;
	}
}
