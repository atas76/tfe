package org.openfootie.tfe.match;

import java.util.List;
import java.util.Random;

public class MatchUtil {
	
	private static Random rnd = new Random();
	
	public static Player getRandomPlayer(List<Player> players) {	
		return players.get(rnd.nextInt(players.size()));
	}
}
