package org.openfootie.tfe.match;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.openfootie.tfe.match.LinePosition.*;
import static org.openfootie.tfe.match.Position.*;

import java.util.Set;

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
		
		homeTeam.selectTactics();
		awayTeam.selectTactics();
	}
	
	@Test
	public void testTacticsPositions() {
		
		homeTeam.setCoach(new Coach("Joachim Löw", new Tactics(4,4,2)));
		awayTeam.setCoach(new Coach("Tite", new Tactics(4,5,1)));
		
		// Update the default tactics from test setup as a coach is assigned
		homeTeam.selectTactics();
		awayTeam.selectTactics();
	
		Lineup homeTeamLineup = homeTeam.getTactics().generateLineup();
		Lineup awayTeamLineup = awayTeam.getTactics().generateLineup();
		
		Set<TacticsPosition> homeTeamPositions = homeTeamLineup.getPositions();
		Set<TacticsPosition> awayTeamPositions = awayTeamLineup.getPositions();
		
		assertEquals(11, homeTeamLineup.getPositions().size());
		assertEquals(11, awayTeamLineup.getPositions().size());
		
		assertTrue(homeTeamPositions.contains(new TacticsPosition(GK, null)));
		
		assertTrue(homeTeamPositions.contains(new TacticsPosition(D, R)));
		assertTrue(homeTeamPositions.contains(new TacticsPosition(D, CR)));
		assertTrue(homeTeamPositions.contains(new TacticsPosition(D, CL)));
		assertTrue(homeTeamPositions.contains(new TacticsPosition(D, L)));
		
		assertTrue(homeTeamPositions.contains(new TacticsPosition(M, R)));
		assertTrue(homeTeamPositions.contains(new TacticsPosition(M, CR)));
		assertTrue(homeTeamPositions.contains(new TacticsPosition(M, CL)));
		assertTrue(homeTeamPositions.contains(new TacticsPosition(M, L)));
		
		assertTrue(homeTeamPositions.contains(new TacticsPosition(F, CR)));
		assertTrue(homeTeamPositions.contains(new TacticsPosition(F, CL)));
		
		assertTrue(awayTeamPositions.contains(new TacticsPosition(GK, null)));
		
		assertTrue(awayTeamPositions.contains(new TacticsPosition(D, R)));
		assertTrue(awayTeamPositions.contains(new TacticsPosition(D, CR)));
		assertTrue(awayTeamPositions.contains(new TacticsPosition(D, CL)));
		assertTrue(awayTeamPositions.contains(new TacticsPosition(D, L)));
		
		assertTrue(awayTeamPositions.contains(new TacticsPosition(M, R)));
		assertTrue(awayTeamPositions.contains(new TacticsPosition(M, RC)));
		assertTrue(awayTeamPositions.contains(new TacticsPosition(M, C)));
		assertTrue(awayTeamPositions.contains(new TacticsPosition(M, LC)));
		assertTrue(awayTeamPositions.contains(new TacticsPosition(M, L)));
		
		assertTrue(awayTeamPositions.contains(new TacticsPosition(F, C)));
	}
	
	@Test
	public void testRandomDefaultInitialization() {
		
		// Since initialization takes part in the constructor and the test is random, we just print-out the team selections
		
		// TODO: test: the players are placed in the correct tactics line according to their position description
		
		System.out.println(homeTeam + " " + homeTeam.getTactics());
		System.out.println();
		System.out.println(homeTeam.getTactics().generateLineup());
		
		System.out.println(awayTeam + " " + awayTeam.getTactics());
		System.out.println();
		System.out.println(awayTeam.getTactics().generateLineup());
	}
}
