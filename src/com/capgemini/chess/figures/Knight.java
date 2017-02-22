package com.capgemini.chess.figures;

import java.util.Map;

import com.capgemini.chess.*;
import com.capgemini.chess.moves.MoveHistory;
import com.capgemini.chess.moves.PossibleMoves;
import com.capgemini.exception.*;

public class Knight extends ChessPiece {
	
	String name = "Knight";

	public Knight(PlayerColor aColor) {
		super(aColor);
	}
	
	@Override
	public boolean isMovePossible(Field from, Field to, Map<Field, ChessPiece> board, Map<String, Field> stringToField, MoveHistory history) {
		if (PossibleMoves.lShape(from, to)) return true;
		else throw new IllegalMoveException("Knights can't move like that!\n");
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public String getFullName() {
		return name + " of " + getColor();
	}
}
