package com.capgemini.chess;

import java.util.Map;
import java.util.HashMap;
import com.capgemini.chess.figures.*;
import com.capgemini.chess.moves.GeneralConditions;

public class Board {
	
	private Map<Field, ChessPiece> board = new HashMap<>(96);
	private Map<Field, ChessPiece> initSetup = new HashMap<>(96);
	private Map<String, Field> stringToField = new HashMap<>(96);
	
	public Board() {
		
	}
	
	public void initializeEmptyBoard() {
		for (int aRow = 8; aRow >= 1; aRow--) {
			for (Column aColumn : Column.values()) {
				Field aField = new Field(aColumn, aRow);
				String positionString = aColumn.toString() + aRow;
				stringToField.put(positionString, aField);
				board.put(aField, null);
			}
		}
	}
	
	public void fillUpBoard(Map<Field, ChessPiece> initSetup) {
		for (Field aField : initSetup.keySet()) {
			if (board.containsKey(aField)) {
				ChessPiece piece = initSetup.get(aField);
				board.put(aField, piece);
			}
		}
	}
	
	public void movePiece(String from, String to) {
		Field fromField = getField(from);
		Field toField = getField(to);
		if (GeneralConditions.areMet(fromField, toField, board)) {
			ChessPiece piece = board.get(fromField);
			if (piece.isMovePossible(fromField, toField)) {
				board.put(toField, piece);
				board.put(fromField, null);
			}
		}
	}
	
	public Field getField(String positionString) {
		return stringToField.get(positionString);
	}
	
	public Map<Field, ChessPiece> getBoard() {
		return board;
	}
	
	public Map<Field, ChessPiece> getInitSetup() {
		return initSetup;
	}
	
	public void makeInitSetup() {
		//WHITE
		initSetup.put(stringToField.get("A1"), new Rook(PlayerColor.WHITE));
		initSetup.put(stringToField.get("B1"), new Knight(PlayerColor.WHITE));
		initSetup.put(stringToField.get("C1"), new Bishop(PlayerColor.WHITE));
		initSetup.put(stringToField.get("D1"), new Queen(PlayerColor.WHITE));
		initSetup.put(stringToField.get("E1"), new King(PlayerColor.WHITE));
		initSetup.put(stringToField.get("F1"), new Bishop(PlayerColor.WHITE));
		initSetup.put(stringToField.get("G1"), new Knight(PlayerColor.WHITE));
		initSetup.put(stringToField.get("H1"), new Rook(PlayerColor.WHITE));
		initSetup.put(stringToField.get("A2"), new Pawn(PlayerColor.WHITE));
		initSetup.put(stringToField.get("B2"), new Pawn(PlayerColor.WHITE));
		initSetup.put(stringToField.get("C2"), new Pawn(PlayerColor.WHITE));
		initSetup.put(stringToField.get("D2"), new Pawn(PlayerColor.WHITE));
		initSetup.put(stringToField.get("E2"), new Pawn(PlayerColor.WHITE));
		initSetup.put(stringToField.get("F2"), new Pawn(PlayerColor.WHITE));
		initSetup.put(stringToField.get("G2"), new Pawn(PlayerColor.WHITE));
		initSetup.put(stringToField.get("H2"), new Pawn(PlayerColor.WHITE));
		//BLACK
		initSetup.put(stringToField.get("A8"), new Rook(PlayerColor.BLACK));
		initSetup.put(stringToField.get("B8"), new Knight(PlayerColor.BLACK));
		initSetup.put(stringToField.get("C8"), new Bishop(PlayerColor.BLACK));
		initSetup.put(stringToField.get("D8"), new Queen(PlayerColor.BLACK));
		initSetup.put(stringToField.get("E8"), new King(PlayerColor.BLACK));
		initSetup.put(stringToField.get("F8"), new Bishop(PlayerColor.BLACK));
		initSetup.put(stringToField.get("G8"), new Knight(PlayerColor.BLACK));
		initSetup.put(stringToField.get("H8"), new Rook(PlayerColor.BLACK));
		initSetup.put(stringToField.get("A7"), new Pawn(PlayerColor.BLACK));
		initSetup.put(stringToField.get("B7"), new Pawn(PlayerColor.BLACK));
		initSetup.put(stringToField.get("C7"), new Pawn(PlayerColor.BLACK));
		initSetup.put(stringToField.get("D7"), new Pawn(PlayerColor.BLACK));
		initSetup.put(stringToField.get("E7"), new Pawn(PlayerColor.BLACK));
		initSetup.put(stringToField.get("F7"), new Pawn(PlayerColor.BLACK));
		initSetup.put(stringToField.get("G7"), new Pawn(PlayerColor.BLACK));
		initSetup.put(stringToField.get("H7"), new Pawn(PlayerColor.BLACK));
	}
	
}
