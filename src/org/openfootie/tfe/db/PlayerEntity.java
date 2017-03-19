package org.openfootie.tfe.db;

public class PlayerEntity implements Entity {
	
	private int shirtNumber;
	private String firstName;
	private String lastName;
	private ClubEntity club;
	private NationEntity nation;
	private PlayerAttributesEntity playerAttributes;
	
	public PlayerEntity(int shirtNumber, String firstName, String lastName, ClubEntity club, NationEntity nation,
			PlayerAttributesEntity playerAttributes) {
		super();
		this.shirtNumber = shirtNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.club = club;
		this.nation = nation;
		this.playerAttributes = playerAttributes;
	}
	
	public int getShirtNumber() {
		return shirtNumber;
	}
	public void setShirtNumber(int shirtNumber) {
		this.shirtNumber = shirtNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public ClubEntity getClub() {
		return club;
	}
	public void setClub(ClubEntity club) {
		this.club = club;
	}
	public NationEntity getNation() {
		return nation;
	}
	public void setNation(NationEntity nation) {
		this.nation = nation;
	}
	public PlayerAttributesEntity getPlayerAttributes() {
		return playerAttributes;
	}
	public void setPlayerAttributes(PlayerAttributesEntity playerAttributes) {
		this.playerAttributes = playerAttributes;
	}
	
}
