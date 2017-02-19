package com.capgemini.chess.moves;

import java.util.Map;

import com.capgemini.chess.*;
import com.capgemini.chess.figures.ChessPiece;

public class PossibleMoves {
	
	public static boolean castling(Field from, Field to, Map<Field, ChessPiece> board) {
		return true;
	}
	
	public static boolean diagonally(Field from, Field to, Map<Field, ChessPiece> board) {
		return true;
	}
	
	public static boolean enPassant(Field from, Field to, Map<Field, ChessPiece> board, String previousMove) { //TODO jakis model historii
		return true;
	}
	
	public static boolean forwardDiagonallyCapturing(Field from, Field to) {
		return true;
	}
	
	public static boolean forwardOnceWithoutCapturing(Field from, Field to) {
		return true;
	}
	
	public static boolean forwardTwiceWithoutCapturing(Field from, Field to, Map<Field, ChessPiece> board) {
		return true;
	}
	
	public static boolean lShape(Field from, Field to) {
		int fromColumn = from.getColumn().getId();
		int fromRow = from.getRow();
		int toColumn = to.getColumn().getId();
		int toRow = to.getRow();
		if (fromColumn + 2 == toColumn && fromRow + 1 == toRow ||
			fromColumn - 2 == toColumn && fromRow - 1 == toRow ||
			fromColumn + 1 == toColumn && fromRow + 2 == toRow ||
			fromColumn - 1 == toColumn && fromRow - 2 == toRow ||
			fromColumn + 2 == toColumn && fromRow - 1 == toRow ||
			fromColumn - 2 == toColumn && fromRow + 1 == toRow ||
			fromColumn + 1 == toColumn && fromRow - 2 == toRow ||
			fromColumn - 1 == toColumn && fromRow + 2 == toRow)
			return true;
		else return false;
	}
	
	public static boolean oneSquareAnyDirection(Field from, Field to) {
		return true;
	}
	
	public static boolean rankOrFile(Field from, Field to, Map<Field, ChessPiece> board) {
		return true;
	}

}
