package com.capgemini.chess.figures;

import com.capgemini.chess.*;
import com.capgemini.chess.moves.Moves;

public class Knight extends ChessPiece {
	
	String name = "Knight";

	public Knight(PlayerColor aColor) {
		super(aColor);
	}
	
	@Override
	public boolean isMovePossible(Field from, Field to) {
		if (Moves.lShape(from, to)) return true;
		else throw new IllegalStateException("Knights can't move like that!\n");
	}
	
	@Override
	public String getName() {
		return name;
	}
}
