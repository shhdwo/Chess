package com.capgemini.chess.figures;

import com.capgemini.chess.*;
import com.capgemini.chess.moves.*;
import java.util.Map;

public abstract class ChessPiece {
	
	private PlayerColor aColor = null;
	private String name = "Piece";
	
	public ChessPiece(PlayerColor aColor) {
		this.aColor = aColor;
	}
	
	public boolean isMovePossible(Field from, Field to, Map<Field, ChessPiece> board, Map<String, Field> stringToField, MoveHistory history) {
		return false;
	}
	
	public PlayerColor getColor() {
		return aColor;
	}
	
	public String getName() {
		return name;
	}
	
	public String getFullName() {
		return name;
	}

}
