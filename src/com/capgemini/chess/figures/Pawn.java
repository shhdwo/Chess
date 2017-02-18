package com.capgemini.chess.figures;

import com.capgemini.chess.*;

public class Pawn extends ChessPiece {
	
	String name = "Pawn";

	public Pawn(PlayerColor aColor) {
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
