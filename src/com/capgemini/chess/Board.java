package com.capgemini.chess;

import java.util.Map;
import java.util.HashMap;
import com.capgemini.chess.figures.*;

public class Board {
	
	private Map<String, ChessPiece> board = new HashMap<>();
	private Map<String, ChessPiece> initSetup = new HashMap<>();
	
	public Board() {
		
	}
	
	public void initializeEmptyBoard() {
		for (int aRow = 8; aRow >= 1; aRow--) {
			for (Column aColumn : Column.values()) {
				String position = aColumn.toString() + aRow;
				board.put(position, null);
			}
		}
	}
	
	public void fillUpBoard(Map<String, ChessPiece> initSetup) {
		for (String position : initSetup.keySet()) {
			if (initSetup.containsKey(position)) {
				ChessPiece piece = initSetup.get(position);
				board.put(position, piece);
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
	
	public Map<String, ChessPiece> getBoard() {
		return board;
	}
	
	public Map<String, ChessPiece> getInitSetup() {
		return initSetup;
	}
	
}
