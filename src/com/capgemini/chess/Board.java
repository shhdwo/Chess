package com.capgemini.chess;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import com.capgemini.chess.figures.*;

public class Board {
	
	private List<Field> board = new ArrayList<Field>();
	private Map<String, ChessPiece> initSetup = new HashMap<>();
	
	public Board() {
		
	}
	
	public void initializeEmptyBoard() {
		for (Column aColumn : Column.values()) {
			for (int aRow = 1; aRow <= 8; aRow++) {
				addField(new Field(aColumn, aRow));
			}
		}
	}
	
	public void fillUpBoard(Map<String, ChessPiece> initSetup) {
		for (Field f : board) {
			String position = f.getPosition();
			if (initSetup.containsKey(position)) {
				ChessPiece piece = initSetup.get(position);
				f.setOccupant(piece);
			}
		}
	}
	
	public void makeInitSetup() {
		//WHITE
		initSetup.put("A1", new Rook(PlayerColor.WHITE));
		initSetup.put("B1", new Knight(PlayerColor.WHITE));
		initSetup.put("C1", new Bishop(PlayerColor.WHITE));
		initSetup.put("D1", new Queen(PlayerColor.WHITE));
		initSetup.put("E1", new King(PlayerColor.WHITE));
		initSetup.put("F1", new Bishop(PlayerColor.WHITE));
		initSetup.put("G1", new Knight(PlayerColor.WHITE));
		initSetup.put("H1", new Rook(PlayerColor.WHITE));
		initSetup.put("A2", new Pawn(PlayerColor.WHITE));
		initSetup.put("B2", new Pawn(PlayerColor.WHITE));
		initSetup.put("C2", new Pawn(PlayerColor.WHITE));
		initSetup.put("D2", new Pawn(PlayerColor.WHITE));
		initSetup.put("E2", new Pawn(PlayerColor.WHITE));
		initSetup.put("F2", new Pawn(PlayerColor.WHITE));
		initSetup.put("G2", new Pawn(PlayerColor.WHITE));
		initSetup.put("H2", new Pawn(PlayerColor.WHITE));
		//BLACK
		initSetup.put("A8", new Rook(PlayerColor.BLACK));
		initSetup.put("B8", new Knight(PlayerColor.BLACK));
		initSetup.put("C8", new Bishop(PlayerColor.BLACK));
		initSetup.put("D8", new King(PlayerColor.BLACK));
		initSetup.put("E8", new Queen(PlayerColor.BLACK));
		initSetup.put("F8", new Bishop(PlayerColor.BLACK));
		initSetup.put("G8", new Knight(PlayerColor.BLACK));
		initSetup.put("H8", new Rook(PlayerColor.BLACK));
		initSetup.put("A7", new Pawn(PlayerColor.BLACK));
		initSetup.put("B7", new Pawn(PlayerColor.BLACK));
		initSetup.put("C7", new Pawn(PlayerColor.BLACK));
		initSetup.put("D7", new Pawn(PlayerColor.BLACK));
		initSetup.put("E7", new Pawn(PlayerColor.BLACK));
		initSetup.put("F7", new Pawn(PlayerColor.BLACK));
		initSetup.put("G7", new Pawn(PlayerColor.BLACK));
		initSetup.put("H7", new Pawn(PlayerColor.BLACK));
	}
	
	public void addField(Field aField) {
		board.add(aField);
	}
	
	public List<Field> getBoard() {
		return board;
	}
	
	public Map<String, ChessPiece> getInitSetup() {
		return initSetup;
	}
	
}
