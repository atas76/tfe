package org.openfootie.tfe.match;

import static org.openfootie.tfe.match.MatchState.KICK_OFF;

import java.util.Random;

import org.openfootie.tfe.match.report.MatchReport;

public class Match {
	
	private Team homeTeam;
	private Team awayTeam;
	
	private MatchState matchState;
	private Team teamPossession;
	private Player playerPossession;
	
	private Team firstHalfKickOffTeam;
	
	private static Random rnd = new Random();
	
	private MatchReport report;
	
	public Match(Team homeTeam, Team awayTeam) {
		
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.matchState = KICK_OFF;
		
		this.report = new MatchReport(this);
	}
	
	public MatchReport getReport() {
		return this.report;
	}
	
	public Team getTeamPossession() {
		return this.teamPossession;
	}
	
	public Player getPlayerPossession() {
		return this.playerPossession;
	}
	
	private void tossCoin() {
		
		Team coinTossWinner;
		
		if (rnd.nextBoolean()) {
			coinTossWinner = this.homeTeam;
		} else {
			coinTossWinner = this.awayTeam;
		}
		
		this.teamPossession = coinTossWinner;
		this.firstHalfKickOffTeam = coinTossWinner;
		
		this.report.kickOff();
	}
	
	private void setupKickOff() {
		if (teamPossession == null) {
			tossCoin();
		}
	}
	
	public void play() {
		
		switch(matchState) {
		case KICK_OFF:
			
			setupKickOff();
			this.playerPossession = this.teamPossession.getKickOffPlayer();
			
			this.report.playerPossession();
			
			break;
		}
		
	}
}
