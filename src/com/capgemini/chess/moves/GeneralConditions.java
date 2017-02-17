package com.capgemini.chess.moves;

public class GeneralConditions {
	
	public static boolean areMet(String from, String to) {
		if (!isDestinationOccupiedByFriend(to)) return true;
		else return false;
	}
	
	private static boolean isDestinationOccupiedByFriend(String to) {
		return false;
	}

}
