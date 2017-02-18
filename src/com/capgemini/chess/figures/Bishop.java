package com.capgemini.chess.figures;

import com.capgemini.chess.*;

public class Bishop extends ChessPiece {
	
	String name = "Bishop";

	public Bishop(PlayerColor aColor) {
		super(aColor);
	}
	
	@Override
	public boolean isMovePossible(Field from, Field to) {
		return true;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
}
