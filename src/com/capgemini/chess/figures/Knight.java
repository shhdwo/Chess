package com.capgemini.chess.figures;

import com.capgemini.chess.*;

public class Knight extends ChessPiece {
	
	String name = "Knight";

	public Knight(PlayerColor aColor) {
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
