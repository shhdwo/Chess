package com.capgemini.chess.moves;

import com.capgemini.chess.*;
import com.capgemini.chess.figures.*;

public class Move {
	
	private static int nextId = 1;
	private int id = 0;
	private Field from = null;
	private Field to = null;
	private ChessPiece piece = null;
	private ChessPiece removedPiece = null;
	
	public Move(Field from, Field to, ChessPiece piece, ChessPiece removedPiece) {
		this.from = from;
		this.to = to;
		this.piece = piece;
		this.removedPiece = removedPiece;
		this.id = nextId;
		nextId++;
	}
	
	public int getId() {
		return id;
	}
	
	public Field getFrom() {
		return from;
	}
	
	public Field getTo() {
		return to;
	}
	
	public ChessPiece getPiece() {
		return piece;
	}
	
	public ChessPiece getRemovedPiece() {
		return removedPiece;
	}
	
	@Override
	public String toString() {
		String pieceName = piece.getFullName();
		String removedPieceName = "";
		String aString = "";
		if (removedPiece != null) removedPieceName = removedPiece.getFullName();
		aString = String.format("| Id: %4s | From: %3s | To: %3s | Piece: %15s | Removed Piece: %15s |",
				id, from.getPosition(), to.getPosition(), pieceName, removedPieceName);
		return aString;
	}
}
