package org.openfootie.tfe.match;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openfootie.tfe.db.DbScript;
import org.openfootie.tfe.db.NationEntity;

public class TeamTest {
	
	private static NationEntity homeNation;
	private static NationEntity awayNation;
	
	private static Team homeTeam;
	private static Team awayTeam;
	
	@BeforeClass
	public static void setUp() {
	
		DbScript.load();
		
		homeNation = DbScript.getNations().get("Germany");
		awayNation = DbScript.getNations().get("Brazil");
		
		homeTeam = new Team(homeNation);
		awayTeam = new Team(awayNation);
	}
	
	@Test
	public void testRandomDefaultInitialization() {
		
		// Since initialization takes part in the constructor and the test is random, we just print-out the team selections
		
		// TODO: Add the tactics name to the output for better visualization
		// TODO: test: the tactics positions are correct according to the tactics selected
		// TODO: test: the players are placed in the correct tactics line according to their position description
		
		System.out.println(homeTeam);
		System.out.println();
		System.out.println(homeTeam.getTactics().generateLineup());
		
		System.out.println(awayTeam);
		System.out.println();
		System.out.println(awayTeam.getTactics().generateLineup());
	}
}
