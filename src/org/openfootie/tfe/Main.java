package org.openfootie.tfe;

import org.openfootie.tfe.db.DbScript;
import org.openfootie.tfe.db.NationEntity;
import org.openfootie.tfe.match.Team;

public class Main {
	
	public static void main(String[] args) {

		DbScript.load();
		
		NationEntity homeNation = DbScript.getNations().get(0);
		NationEntity awayNation = DbScript.getNations().get(1);
		
		Team homeTeam = new Team(homeNation);
		Team awayTeam = new Team(awayNation);
		
		// TODO: integrate in the constructor (or an initialization method) 
		homeTeam.selectTactics();
		awayTeam.selectTactics();
		
		// TODO: Line up selection functionality implemented. Time to write some tests
	}
}
