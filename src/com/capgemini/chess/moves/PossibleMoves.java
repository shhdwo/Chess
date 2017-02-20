package com.capgemini.chess.moves;

import java.util.Map;

import com.capgemini.chess.*;
import com.capgemini.chess.figures.ChessPiece;

public class PossibleMoves {
	
	public static boolean castling(Field from, Field to, Map<Field, ChessPiece> board) {
		return true; //TODO castling
	}
	
	public static boolean diagonally(Field from, Field to, Map<Field, ChessPiece> board) {
		return true;
	}
	
	public static boolean enPassant(Field from, Field to, Map<Field, ChessPiece> board, MoveHistory history) { //TODO jakis model historii
		return true; //TODO enPassant
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
		int fromColumn = from.getColumn().getId();
		int fromRow = from.getRow();
		int toColumn = to.getColumn().getId();
		int toRow = to.getRow();
		int columnGap = fromColumn - toColumn;
		int rowGap = fromRow - toRow;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (columnGap == i && rowGap == j) return true;
			}
		}
		return false;
	}
	
	public static boolean rankOrFile(Field from, Field to, Map<Field, ChessPiece> board, Map<String, Field> stringToField) {
		int fromColumn = from.getColumn().getId();
		int fromRow = from.getRow();
		int toColumn = to.getColumn().getId();
		int toRow = to.getRow();	
		String aString = "";
		Field aField = null;
		ChessPiece piece = null;
		if (fromColumn == toColumn) { //rank
			if (fromRow < toRow) {
				for (int i = fromRow + 1; i < toRow; i++) {
					aString = from.getColumn().toString() + i;
					aField = stringToField.get(aString);
					piece = board.get(aField);
					if (piece != null) return false;
				}
				return true;
			}
			else if (fromRow > toRow) {
				for (int i = fromRow - 1; i > toRow; i--) {
					aString = from.getColumn().toString() + i;
					aField = stringToField.get(aString);
					piece = board.get(aField);
					if (piece != null) return false;
				}	
				return true;
			}
		} 
		else if(fromRow == toRow) { //file
			if (fromColumn < toColumn) {
				for (int i = fromColumn + 1; i < toColumn; i++) {
					aString = Column.values()[i-1].toString() + fromRow;
					aField = stringToField.get(aString);
					piece = board.get(aField);
					if (piece != null) return false;
				}
				return true;
			}
			else if (fromColumn > toColumn) {
				for (int i = fromColumn -1; i > toColumn; i--) {
					aString = Column.values()[i-1].toString() + fromRow;
					aField= stringToField.get(aString);
					piece = board.get(aField);
					if (piece != null) return false;
				}
				return true;
			}
		}
		return false;
	}

}
