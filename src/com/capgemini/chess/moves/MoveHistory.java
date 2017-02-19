package com.capgemini.chess.moves;

import java.util.List;
import java.util.ArrayList;

public class MoveHistory {

	private List<Move> moveHistory = new ArrayList<Move>(); 

	public void addMove(Move aMove) {
		moveHistory.add(aMove);
	}
	
	public List<Move> getHistory() {
		return moveHistory;
	}
	
}
