package com.capgemini.chess;

import java.util.Map;
import java.util.HashMap;
import com.capgemini.chess.figures.*;
import com.capgemini.chess.moves.GeneralConditions;
import com.capgemini.chess.moves.*;
import com.capgemini.exception.*;

public class Board {
	
	private Map<Field, ChessPiece> board = new HashMap<>(96);
	private Map<Field, ChessPiece> initSetup = new HashMap<>(96);
	private Map<String, Field> stringToField = new HashMap<>(96);
	private Field kingOfWhiteLocation = null;
	private Field kingOfBlackLocation = null;
	private MoveHistory history = new MoveHistory();
	private PlayerColor actualPlayerTurn = PlayerColor.WHITE;
	
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
				if (piece instanceof King) setKingLocation(aField, piece);
			}
		}
	}
	
	public boolean movePiece(String from, String to) { 
		try {
			Field fromField = getFieldFromString(from);
			Field toField = getFieldFromString(to);
			if (GeneralConditions.areMet(fromField, toField, board, actualPlayerTurn)) {
				ChessPiece piece = board.get(fromField);
				ChessPiece destinationPiece = board.get(toField);
				if (piece.isMovePossible(fromField, toField, board, stringToField, history)) {
					return performMove(fromField, toField, piece, destinationPiece);
				}
			}
			return false;
		}
		catch (IllegalStateException e) {
			System.out.println(e);
			return false;
		}
	}

	private boolean performMove(Field fromField, Field toField, ChessPiece piece, ChessPiece destinationPiece) {
		board.put(toField, piece);
		board.put(fromField, null);
		if (piece instanceof King) setKingLocation(toField, piece);
		Field enPassantField = null;
		ChessPiece enPassantPiece = null;
		if (toField.getEnPassantFlag()) {
			enPassantField = history.getHistory().get(history.getHistory().size()-1).getTo();
			enPassantPiece = history.getHistory().get(history.getHistory().size()-1).getPiece();
			board.put(enPassantField, null);
			toField.setEnPassantFlag(false);
		}
		if (Check.isPlayerChecked(board, stringToField, history, getKingLocation(piece.getColor()))) {
			moveReverse(fromField, toField, destinationPiece, enPassantField, enPassantPiece);
			throw new KingCheckException("This move would leave your king in danger!\n");
		}
		else {
			return finalizeMove(fromField, toField, piece, destinationPiece, enPassantPiece);
		}
	}

	private boolean finalizeMove(Field fromField, Field toField, ChessPiece piece, ChessPiece destinationPiece,
			ChessPiece enPassantPiece) {
		if (piece instanceof King) setKingLocation(toField, piece);
		flipActualPlayerTurn();
		addMoveToHistory(fromField, toField, piece, destinationPiece, enPassantPiece);
		return true;
	}
	
	private void flipActualPlayerTurn() {
		if (actualPlayerTurn == PlayerColor.WHITE) actualPlayerTurn = PlayerColor.BLACK;
		else if (actualPlayerTurn == PlayerColor.BLACK) actualPlayerTurn = PlayerColor.WHITE;
	}
	
	private void moveReverse(Field fromField, Field toField, ChessPiece destinationPiece, Field enPassantField, ChessPiece enPassantPiece) {
		ChessPiece piece = board.get(toField);
		board.put(fromField, piece);
		board.put(toField, destinationPiece);
		if (piece instanceof King) setKingLocation(fromField, piece);
		if (enPassantField != null) board.put(enPassantField, enPassantPiece);
	}
	
	private void addMoveToHistory(Field fromField, Field toField, ChessPiece piece, ChessPiece destinationPiece, ChessPiece enPassantPiece) {
		Move aMove = null;
		if (enPassantPiece != null) aMove = new Move(fromField, toField, piece, enPassantPiece);
		else aMove = new Move(fromField, toField, piece, destinationPiece);
		history.addMove(aMove);
	}
	
	private void setKingLocation(Field aField, ChessPiece piece) {
		PlayerColor colorOfKing = piece.getColor();
		if (colorOfKing == PlayerColor.WHITE) {
			kingOfWhiteLocation = aField;
		}
		else if (colorOfKing == PlayerColor.BLACK) {
			kingOfBlackLocation = aField;
		}
	}
	
	private Field getKingLocation(PlayerColor color) {
		if (color == PlayerColor.WHITE) return kingOfWhiteLocation;
		else if (color == PlayerColor.BLACK) return kingOfBlackLocation;
		else throw new IllegalStateException();
	}
	
	public Field getFieldFromString(String positionString) {
		return stringToField.get(positionString);
	}
	
	public Map<Field, ChessPiece> getBoard() {
		return board;
	}
	
	public Map<Field, ChessPiece> getInitSetup() {
		return initSetup;
	}
	
	public Map<String, Field> getStringToFieldMap() {
		return stringToField;
	}
	
	public MoveHistory getMoveHistory() {
		return history;
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
