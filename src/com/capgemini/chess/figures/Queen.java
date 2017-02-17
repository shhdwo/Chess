package com.capgemini.chess.figures;

public class Queen extends ChessPiece {
	
	String name = "Queen";

	public Queen(PlayerColor aColor) {
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
