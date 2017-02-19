package com.capgemini.chess.figures;

import com.capgemini.chess.*;

public class King extends ChessPiece {
	
	String name = "King";
	
	public King(PlayerColor aColor) {
		super(aColor);
	}
	
	@Override
	public boolean isMovePossible(Field from, Field to) {
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
