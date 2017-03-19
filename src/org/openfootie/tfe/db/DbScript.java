package org.openfootie.tfe.db;

import java.util.Set;

public class DbScript {
	
	private static Set<NationEntity> nations;
	private static Set<PlayerEntity> players;
	
	public static void load() {
		
		nations.add(new NationEntity("Germany"));
		nations.add(new NationEntity("Brazil"));
		
	}
}
