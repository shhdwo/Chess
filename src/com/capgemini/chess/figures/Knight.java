package com.capgemini.chess.figures;

public class Knight extends ChessPiece {
	
	String name = "Knight";

	public Knight(PlayerColor aColor) {
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
