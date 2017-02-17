package com.capgemini.chess.figures;

public class Bishop extends ChessPiece {
	
	String name = "Bishop";

	public Bishop(PlayerColor aColor) {
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
