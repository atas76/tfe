package org.openfootie.tfe.db;

import java.util.Map;

public class DbScript {
	
	private static Map<String, NationEntity> nations;
	
	public static void load() {
		
		nations.put("Germany", new NationEntity("Germany"));
		nations.put("Brazil", new NationEntity("Brazil"));
		
		// int shirtNumber, String firstName, String lastName, ClubEntity club, NationEntity nation, PlayerAttributesEntity playerAttributes
		// PlayerAttributesEntity(int defending, int shooting, int passing, int crossing, int dribbling, int outfield, int goalkeeping)
		
		addPlayer(new PlayerEntity(1, "Manuel", "Neuer", null, nations.get("Germany"), new PlayerAttributesEntity(2, 1, 3, 1, 1, 2, 4)));
	}
	
	private static void addPlayer(PlayerEntity player) {
		player.getNation().getSquad().getPlayers().add(player);
	}
}
