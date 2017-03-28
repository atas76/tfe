package org.openfootie.tfe.db;

import java.util.Map;

public class DbScript {
	
	private static Map<String, NationEntity> nations;
	
	public static void load() {
		
		nations.put("Germany", new NationEntity("Germany"));
		nations.put("Brazil", new NationEntity("Brazil"));
		
		// int shirtNumber, String firstName, String lastName, ClubEntity club, NationEntity nation, PlayerAttributesEntity playerAttributes
		
		addPlayer(new PlayerEntity(1, "Manuel", "Neuer", null, nations.get("Germany"), new PlayerAttributesEntity(2, 1, 3, 1, 1, 2, 4), LinePosition.GK));
		addPlayer(new PlayerEntity(12, "Ron-Robert", "Zieler", null, nations.get("Germany"), new PlayerAttributesEntity(2, 1, 3, 1, 1, 2, 4), LinePosition.GK));
		addPlayer(new PlayerEntity(22, "Roman", "Weidenfeller", null, nations.get("Germany"), new PlayerAttributesEntity(2, 1, 3, 1, 1, 2, 3), LinePosition.GK));
		
		addPlayer(new PlayerEntity(17, "Jérôme", "Boateng", null, nations.get("Germany"), new PlayerAttributesEntity(3, 2, 3, 3, 3, 5, 1), LinePosition.D));
		addPlayer(new PlayerEntity(5, "Mats", "Hummels", null, nations.get("Germany"), new PlayerAttributesEntity(4, 2, 3, 2, 3, 5, 1), LinePosition.D));
		addPlayer(new PlayerEntity(4, "Benedikt", "Höwedes", null, nations.get("Germany"), new PlayerAttributesEntity(4, 3, 3, 2, 1, 5, 1), LinePosition.D));
		addPlayer(new PlayerEntity(14, "Holger", "Badstuber", null, nations.get("Germany"), new PlayerAttributesEntity(4, 2, 3, 3, 1, 4, 1), LinePosition.D));
		addPlayer(new PlayerEntity(2, "Shkodran", "Mustafi", null, nations.get("Germany"), new PlayerAttributesEntity(3, 1, 1, 1, 1, 5, 1), LinePosition.D));
		addPlayer(new PlayerEntity(15, "Sebastian", "Rudy", null, nations.get("Germany"), new PlayerAttributesEntity(4, 3, 4, 2, 3, 4, 1), LinePosition.D));
		addPlayer(new PlayerEntity(3, "Jonas", "Hector", null, nations.get("Germany"), new PlayerAttributesEntity(3, 3, 3, 3, 3, 4, 1), LinePosition.D));
		
		addPlayer(new PlayerEntity(7, "Bastian", "Schweinsteiger", null, nations.get("Germany"), new PlayerAttributesEntity(3, 3, 4, 3, 3, 5, 1), LinePosition.M));
		addPlayer(new PlayerEntity(8, "Mesut", "Özil", null, nations.get("Germany"), new PlayerAttributesEntity(2, 3, 5, 4, 4, 5, 1), LinePosition.M));
		addPlayer(new PlayerEntity(13, "Thomas", "Müller", null, nations.get("Germany"), new PlayerAttributesEntity(2, 3, 3, 3, 3, 5, 1), LinePosition.M));
		addPlayer(new PlayerEntity(18, "Toni", "Kroos", null, nations.get("Germany"), new PlayerAttributesEntity(3, 4, 4, 4, 3,	5, 1), LinePosition.M));
		addPlayer(new PlayerEntity(6, "Sami", "Khedira", null, nations.get("Germany"), new PlayerAttributesEntity(3, 3, 3, 3, 3, 5, 1), LinePosition.M));
		addPlayer(new PlayerEntity(9, "André", "Schürrle", null, nations.get("Germany"), new PlayerAttributesEntity(2, 3, 3, 3, 3, 5, 1), LinePosition.M));
		addPlayer(new PlayerEntity(11, "Marco", "Reus", null, nations.get("Germany"), new PlayerAttributesEntity(2, 4, 3, 3, 3, 5, 1), LinePosition.M));
		addPlayer(new PlayerEntity(21, "İlkay", "Gündoğan", null, nations.get("Germany"), new PlayerAttributesEntity(3, 3, 4, 3, 3, 5, 1), LinePosition.M));
		addPlayer(new PlayerEntity(20, "Cristoph", "Kramer", null, nations.get("Germany"), new PlayerAttributesEntity(3, 2, 2, 3, 2, 4, 1), LinePosition.M));
		addPlayer(new PlayerEntity(16, "Karim", "Bellarabi", null, nations.get("Germany"), new PlayerAttributesEntity(1, 1, 3, 3, 3, 4, 1), LinePosition.M));
		
		addPlayer(new PlayerEntity(19, "Mario", "Götze", null, nations.get("Germany"), new PlayerAttributesEntity(2, 2, 4, 3, 4, 5, 1), LinePosition.F));
		addPlayer(new PlayerEntity(23, "Max", "Kruse", null, nations.get("Germany"), new PlayerAttributesEntity(2, 3, 3, 2, 3, 4, 1), LinePosition.F));
		addPlayer(new PlayerEntity(10, "Lukas", "Podolski", null, nations.get("Germany"), new PlayerAttributesEntity(2, 4, 3, 3, 3, 4, 1), LinePosition.F));
		
		// PlayerAttributesEntity(int defending:[5,], int shooting[4], int passing[6], int crossing[2], int dribbling[1], int outfield, int goalkeeping)
		addPlayer(new PlayerEntity(1, "", "Jefferson", null, nations.get("Brazil"), new PlayerAttributesEntity(2, 1, 3, 1, 1, 2, 4), LinePosition.GK));
		addPlayer(new PlayerEntity(12, "Diego", "Alves", null, nations.get("Brazil"), new PlayerAttributesEntity(2, 1, 3, 1, 1, 2, 4), LinePosition.GK));
		addPlayer(new PlayerEntity(23, "Marcelo", "Grohe", null, nations.get("Brazil"), new PlayerAttributesEntity(2, 1, 3, 1, 1, 2, 4), LinePosition.GK));
		
		addPlayer(new PlayerEntity(14, "Thiago", "Silva", null, nations.get("Brazil"), new PlayerAttributesEntity(4, 3, 3, 1, 3, 5, 1), LinePosition.D));
		addPlayer(new PlayerEntity(25, "", "Marcelo", null, nations.get("Brazil"), new PlayerAttributesEntity(3, 3, 4, 4, 4, 5, 1), LinePosition.D));
		addPlayer(new PlayerEntity(2, "Daniel", "Alves", null, nations.get("Brazil"), new PlayerAttributesEntity(3, 3, 3, 3, 3, 4, 1), LinePosition.D));
		addPlayer(new PlayerEntity(3, "", "Miranda", null, nations.get("Brazil"), new PlayerAttributesEntity(4, 2, 3, 3, 2, 5, 1), LinePosition.D));
		addPlayer(new PlayerEntity(4, "David", "Luiz", null, nations.get("Brazil"), new PlayerAttributesEntity(4, 3, 3, 2, 3, 5, 1), LinePosition.D));
		addPlayer(new PlayerEntity(45, "", "Danilo", null, nations.get("Brazil"), new PlayerAttributesEntity(3, 3, 3, 3, 3, 5, 1), LinePosition.D));
		addPlayer(new PlayerEntity(6, "Filipe", "Luis", null, nations.get("Brazil"), new PlayerAttributesEntity(3, 3, 3, 3, 3, 5, 1), LinePosition.D));
		addPlayer(new PlayerEntity(13, "", "Gil", null, nations.get("Brazil"), new PlayerAttributesEntity(4, 2, 3, 2, 2, 4, 1), LinePosition.D));
		addPlayer(new PlayerEntity(16, "", "Fabinho", null, nations.get("Brazil"), new PlayerAttributesEntity(3, 2, 3, 3, 3, 4, 1), LinePosition.D));
		addPlayer(new PlayerEntity(35, "Gabriel", "Paulista", null, nations.get("Brazil"), new PlayerAttributesEntity(3, 3, 3, 3, 3, 5, 1), LinePosition.D));
		
		addPlayer(new PlayerEntity(17, "", "Oscar", null, nations.get("Brazil"), new PlayerAttributesEntity(2, 3, 4, 3, 3, 5, 1), LinePosition.M));
		addPlayer(new PlayerEntity(18, "Luiz", "Gustavo", null, nations.get("Brazil"), new PlayerAttributesEntity(5, 2, 3, 3, 2, 5, 1), LinePosition.M));
		addPlayer(new PlayerEntity(19, "", "Willian", null, nations.get("Brazil"), new PlayerAttributesEntity(2, 3, 4, 3, 4, 5, 1), LinePosition.M));
		addPlayer(new PlayerEntity(8, "", "Elias", null, nations.get("Brazil"), new PlayerAttributesEntity(3, 3, 3, 3, 3, 4, 1), LinePosition.M));
		addPlayer(new PlayerEntity(5, "", "Fernandinho", null, nations.get("Brazil"), new PlayerAttributesEntity(3, 3, 3, 3, 4, 5, 1), LinePosition.M));
		addPlayer(new PlayerEntity(21, "Philippe", "Coutinho", null, nations.get("Brazil"), new PlayerAttributesEntity(1, 3, 4, 3, 4, 5, 1), LinePosition.M));
		addPlayer(new PlayerEntity(7, "Douglas", "Costa", null, nations.get("Brazil"), new PlayerAttributesEntity(1, 3, 3, 3, 4, 5, 1), LinePosition.M));
		addPlayer(new PlayerEntity(22, "", "Souza", null, nations.get("Brazil"), new PlayerAttributesEntity(3, 2, 3, 3, 3, 4, 1), LinePosition.M));
		
		addPlayer(new PlayerEntity(20, "", "Robinho", null, nations.get("Brazil"), new PlayerAttributesEntity(2, 3, 4, 3, 5, 4, 1), LinePosition.F));
		addPlayer(new PlayerEntity(10, "", "Neymar", null, nations.get("Brazil"), new PlayerAttributesEntity(1, 3, 3, 3, 5, 6, 1), LinePosition.F));
		addPlayer(new PlayerEntity(9, "Luiz", "Adriano", null, nations.get("Brazil"), new PlayerAttributesEntity(2, 2, 3, 2, 3, 4, 1), LinePosition.F));
		addPlayer(new PlayerEntity(11, "Roberto", "Firmino", null, nations.get("Brazil"), new PlayerAttributesEntity(2, 3, 2, 3, 2, 5, 1), LinePosition.F));
	}
	
	private static void addPlayer(PlayerEntity player) {
		player.getNation().getSquad().getPlayers().add(player);
	}
}
