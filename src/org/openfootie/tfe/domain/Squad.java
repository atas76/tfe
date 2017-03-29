package org.openfootie.tfe.domain;

import java.util.ArrayList;
import java.util.List;

public class Squad<T> {
	
	private List<T> players = new ArrayList<>();
	
	public void setPlayers(List<T> players) {
		this.players = players;
	}
}
