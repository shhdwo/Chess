package com.capgemini.chess.figures;

import com.capgemini.chess.*;

public class Queen extends ChessPiece {
	
	String name = "Queen";

	public Queen(PlayerColor aColor) {
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
