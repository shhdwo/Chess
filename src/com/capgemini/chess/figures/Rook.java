package com.capgemini.chess.figures;

import com.capgemini.chess.*;

public class Rook extends ChessPiece {
	
	String name = "Rook";

	public Rook(PlayerColor aColor) {
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
