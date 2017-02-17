package com.capgemini.chess;

import com.capgemini.chess.figures.*;

public class Field {
	
	private Column aColumn = null;
	private int aRow = 0;
	private ChessPiece occupant = null;
	
	public Field(Column aColumn, int aRow) {
		this.aColumn = aColumn;
		this.aRow = aRow;
	}
	
	public Column getColumn() {
		return aColumn;
	}
	
	public int getRow() {
		return aRow;
	}
	
	public String getPosition() {
		return aColumn.toString() + aRow;
	}
	
	public ChessPiece getOccupant() {
		return occupant;
	}
	
	public void setOccupant(ChessPiece occupant) {
		this.occupant = occupant;
	}

}
