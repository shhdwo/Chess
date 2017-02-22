package com.capgemini.chess.figures;

import java.util.Map;

import com.capgemini.chess.*;
import com.capgemini.chess.moves.MoveHistory;
import com.capgemini.chess.moves.PossibleMoves;
import com.capgemini.exception.*;

public class Pawn extends ChessPiece {
	
	String name = "Pawn";

	public Pawn(PlayerColor aColor) {
		super(aColor);
	}
	
	@Override
	public boolean isMovePossible(Field from, Field to, Map<Field, ChessPiece> board, Map<String, Field> stringToField, MoveHistory history) {
		if (PossibleMoves.forwardOnceWithoutCapturing(from, to, board)) return true;
		else if (PossibleMoves.forwardTwiceWithoutCapturing(from, to, board, stringToField)) return true;
		else if (PossibleMoves.forwardDiagonallyCapturing(from, to, board)) return true;
		else if (PossibleMoves.enPassant(from, to, board, history)) return true;
		else throw new IllegalMoveException("Pawns can't move like that!\n");
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public String getFullName() {
		return name + " of " + getColor();
	}
}
