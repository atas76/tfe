package org.openfootie.tfe.match;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.openfootie.tfe.match.LinePosition.D;
import static org.openfootie.tfe.match.LinePosition.F;
import static org.openfootie.tfe.match.LinePosition.GK;
import static org.openfootie.tfe.match.LinePosition.M;
import static org.openfootie.tfe.match.Position.C;
import static org.openfootie.tfe.match.Position.CL;
import static org.openfootie.tfe.match.Position.CR;
import static org.openfootie.tfe.match.Position.L;
import static org.openfootie.tfe.match.Position.LC;
import static org.openfootie.tfe.match.Position.R;
import static org.openfootie.tfe.match.Position.RC;

import java.util.List;
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
		
		setUpTactics();
	}
	
	private static void setUpCoaches() {
		homeTeam.setCoach(new Coach("Joachim Löw", new Tactics(4,4,2)));
		awayTeam.setCoach(new Coach("Tite", new Tactics(4,5,1)));
	}
	
	/**
	 * Setup tactics according to coaches' preferences. Must be called after coaches are setup.
	 */
	private static void setUpTactics() {	
		homeTeam.selectTactics();
		awayTeam.selectTactics();
	}
	
	@Test
	public void testPlayersPositions() {
		
		setUpCoaches();
		setUpTactics();
		
		Lineup homeTeamLineup = homeTeam.getTactics().generateLineup();
		Lineup awayTeamLineup = awayTeam.getTactics().generateLineup();
		
		for (LinePosition linePosition: LinePosition.values()) {
			assertPlayerPositions(linePosition, homeTeamLineup.getPlayersByTacticsLine(linePosition));
			assertPlayerPositions(linePosition, awayTeamLineup.getPlayersByTacticsLine(linePosition));
		}
	}
	
	private static void assertPlayerPositions(LinePosition linePosition, List<Player> players) {
		for (Player player: players) {
			assertEquals(linePosition.toString(), player.getLinePosition().toString());
		}
	}
	
	@Test
	public void testTacticsPositions() {
		
		setUpCoaches();
		setUpTactics();
	
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
	public void testRandomDefaultInitialization() { // Side-effect: prints line-ups
		
		// Since initialization takes part in the constructor and the test is random, we just print-out the team selections
		
		System.out.println(homeTeam + " " + homeTeam.getTactics());
		System.out.println();
		System.out.println(homeTeam.getTactics().generateLineup());
		
		System.out.println(awayTeam + " " + awayTeam.getTactics());
		System.out.println();
		System.out.println(awayTeam.getTactics().generateLineup());
	}
}
