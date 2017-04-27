package org.openfootie.tfe.match;

import static org.openfootie.tfe.match.Position.C;
import static org.openfootie.tfe.match.Position.CL;
import static org.openfootie.tfe.match.Position.CR;
import static org.openfootie.tfe.match.Position.L;
import static org.openfootie.tfe.match.Position.LC;
import static org.openfootie.tfe.match.Position.R;
import static org.openfootie.tfe.match.Position.RC;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class TacticsLine {
	
	private List<Position> positions = new ArrayList<>();
	private TreeMap<Position, Player> players = new TreeMap<>();
	
	public TacticsLine(int cardinality) {
		
		switch (cardinality) {
		case 1:
			positions.add(C);
			break;
		case 2:
			positions.add(CL);
			positions.add(CR);
			break;
		case 3:
			positions.add(LC);
			positions.add(C);
			positions.add(RC);
			break;
		case 4:
			positions.add(L);
			positions.add(CL);
			positions.add(CR);
			positions.add(R);
			break;
		case 5:
			positions.add(L);
			positions.add(LC);
			positions.add(C);
			positions.add(RC);
			positions.add(R);
			break;
		}
	}
	
	public void setPlayers(List<Player> players) {
		for (int i = 0; i < this.positions.size(); i++) {
			this.players.put(this.positions.get(i), players.get(i));
		}
	}
	
	public TreeMap<Position, Player> getPlayers() {
		return this.players;
	}
}
