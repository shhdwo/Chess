package com.capgemini.chess.figures;

import com.capgemini.chess.*;

public abstract class ChessPiece {
	
	private PlayerColor aColor = null;
	private String name = "Piece";
	
	public ChessPiece(PlayerColor aColor) {
		this.aColor = aColor;
	}
	
	public boolean isMovePossible(Field from, Field to) {
		return false;
	}
	
	public PlayerColor getColor() {
		return aColor;
	}
	
	public String getName() {
		return name;
	}

}
