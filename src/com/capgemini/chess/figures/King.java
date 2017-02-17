package com.capgemini.chess.figures;

public class King extends ChessPiece {
	
	String name = "King";
	
	public King(PlayerColor aColor) {
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
