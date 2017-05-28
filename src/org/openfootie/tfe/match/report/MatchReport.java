package org.openfootie.tfe.match.report;

import static org.openfootie.tfe.match.MatchState.KICK_OFF;

import java.util.ArrayList;
import java.util.List;

import org.openfootie.tfe.match.Match;
import org.openfootie.tfe.match.MatchState;
import org.openfootie.tfe.match.Player;
import org.openfootie.tfe.match.Team;

public class MatchReport {
	
	private Match match;
	
	private static abstract class ReportEntry {}
	
	private static class SetPieceEntry extends ReportEntry {
		
		private MatchState state;
		private Team team;
		
		public SetPieceEntry(MatchState state, Team team) {
			super();
			this.state = state;
			this.team = team;
		}
		
		@Override
		public String toString() {
			return this.state.toString() + ": " + this.team.toString();
		}
	}
	
	private static class PossessionEntry extends ReportEntry {
		
		private Team team;
		private Player player;
		
		public PossessionEntry(Team team, Player player) {
			this.team = team;
			this.player = player;
		}
		
		@Override
		public String toString() {
			return "Ball possession: " +  this.player.toString() + " (" + this.team.toString() + ")";
		}
	}
	
	private List<ReportEntry> entries = new ArrayList<ReportEntry>();
	
	public MatchReport(Match match) {
		this.match = match;
	}
	
	public void kickOff() {
		entries.add(new SetPieceEntry(KICK_OFF, this.match.getTeamPossession()));
	}
	
	public void playerPossession() {
		entries.add(new PossessionEntry(this.match.getTeamPossession(), this.match.getPlayerPossession()));
	}
	
	@Override
	public String toString() {
		
		StringBuilder reportBuilder = new StringBuilder();
		
		for (ReportEntry entry: this.entries) {
			reportBuilder.append(entry);
			reportBuilder.append("\n");
		}
		
		return reportBuilder.toString();
	}
}
