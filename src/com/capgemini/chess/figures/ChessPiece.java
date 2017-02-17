package com.capgemini.chess.figures;

public abstract class ChessPiece {
	
	private PlayerColor aColor = null;
	private String name = "Piece";
	
	public ChessPiece(PlayerColor aColor) {
		this.aColor = aColor;
	}
	
	public PlayerColor getColor() {
		return aColor;
	}
	
	public String getName() {
		return name;
	}

}
