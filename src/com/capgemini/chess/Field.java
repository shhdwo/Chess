package com.capgemini.chess;

public class Field {
	
	private Column aColumn = null;
	private int aRow = 0;
	private boolean enPassantFlag = false;

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
	
	public boolean getEnPassantFlag() {
		return enPassantFlag;
	}
	
	public void setEnPassantFlag(boolean enPassantflag) {
		this.enPassantFlag = enPassantflag;
	}
}
