package com.capgemini.chess.figures;

public class Rook extends ChessPiece {
	
	String name = "Rook";

	public Rook(PlayerColor aColor) {
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
