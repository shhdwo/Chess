package com.capgemini.chess.figures;

import java.util.Map;

import com.capgemini.chess.*;
import com.capgemini.chess.moves.MoveHistory;
import com.capgemini.chess.moves.PossibleMoves;
import com.capgemini.exception.*;

public class Rook extends ChessPiece {
	
	String name = "Rook";

	public Rook(PlayerColor aColor) {
		super(aColor);
	}
	
	@Override
	public boolean isMovePossible(Field from, Field to, Map<Field, ChessPiece> board, Map<String, Field> stringToField, MoveHistory history) {
		if (PossibleMoves.rankOrFile(from, to, board, stringToField)) return true;
		else throw new IllegalMoveException("Rooks can't move like that!\n");
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public String getFullName() {
		return name + " of " + getColor();
	}
}
