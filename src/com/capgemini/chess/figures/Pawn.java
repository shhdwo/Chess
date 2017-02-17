package com.capgemini.chess.figures;

public class Pawn extends ChessPiece {
	
	String name = "Pawn";

	public Pawn(PlayerColor aColor) {
		super(aColor);
	}
	
	public boolean isMovePossible() {
		return true;
	}
	
	@Override
	public String getName() {
		return name;
	}
}
