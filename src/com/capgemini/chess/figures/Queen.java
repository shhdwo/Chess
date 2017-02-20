package com.capgemini.chess.figures;

import java.util.Map;

import com.capgemini.chess.*;
import com.capgemini.chess.moves.MoveHistory;

public class Queen extends ChessPiece {
	
	String name = "Queen";

	public Queen(PlayerColor aColor) {
		super(aColor);
	}
	
	@Override
	public boolean isMovePossible(Field from, Field to, Map<Field, ChessPiece> board, Map<String, Field> stringToField, MoveHistory history) {
		return true;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public String getFullName() {
		return name + " of " + getColor();
	}
}
