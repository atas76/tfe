package org.openfootie.tfe;

import org.openfootie.tfe.db.DbScript;
import org.openfootie.tfe.db.NationEntity;
import org.openfootie.tfe.match.Lineup;
import org.openfootie.tfe.match.Match;
import org.openfootie.tfe.match.Team;

public class Main {
	
	public static void main(String[] args) {

		DbScript.load();
		
		NationEntity homeNation = DbScript.getNations().get("Germany");
		NationEntity awayNation = DbScript.getNations().get("Brazil");
		
		Team homeTeam = new Team(homeNation);
		Team awayTeam = new Team(awayNation);
		
		// TODO: integrate in a 'match initialization' method
		homeTeam.selectTactics();
		awayTeam.selectTactics();
		
		Match match = new Match(homeTeam, awayTeam);
		
		match.play();
		
		// Print team line-ups
		System.out.println(homeTeam + " " + homeTeam.getTactics());
		System.out.println();
		System.out.println(homeTeam.getTactics().generateLineup());
		
		System.out.println(awayTeam + " " + awayTeam.getTactics());
		System.out.println();
		System.out.println(awayTeam.getTactics().generateLineup());
		
		// Print match report
		System.out.println(match.getReport());
	}
}
