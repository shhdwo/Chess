package com.capgemini.chess.moves;

import java.util.Map;

import com.capgemini.chess.*;
import com.capgemini.chess.figures.ChessPiece;
import com.capgemini.chess.figures.PlayerColor;

public class PossibleMoves {
	
	public static boolean castling(Field from, Field to, Map<Field, ChessPiece> board, Map<String, Field> stringToField) {
		return false; //TODO castling
	}
	
	public static boolean diagonally(Field from, Field to, Map<Field, ChessPiece> board, Map<String, Field> stringToField) {
		int fromColumn = from.getColumn().getId();
		int fromRow = from.getRow();
		int toColumn = to.getColumn().getId();
		int toRow = to.getRow();	
		int columnGap = toColumn - fromColumn;
		int rowGap = toRow - fromRow;
		String aString = "";
		Field aField = null;
		ChessPiece piece = null;
		if (columnGap == rowGap) { //bottom-left and top-right directions
			if (columnGap > 0) { //top-right
				for (int i = 1; i < columnGap; i++) {
					aString = Column.values()[fromColumn + i - 1].toString() + (fromRow + i);
					aField = stringToField.get(aString);
					piece = board.get(aField);
					if (piece != null) return false;
				}
				return true;
			}
			else if (columnGap < 0) { //bottom-left
				for (int i = 1; i < columnGap*(-1); i++) {
					aString = Column.values()[fromColumn - i - 1].toString() + (fromRow - i);
					aField = stringToField.get(aString);
					piece = board.get(aField);
					if (piece != null) return false;
				}
				return true;
			}
		}
		else if (columnGap == rowGap*(-1)) { //top-left and bottom-right directions
			if (columnGap > 0) { //bottom-right
				for (int i = 1; i < columnGap; i++) {
					aString = Column.values()[fromColumn + i - 1].toString() + (fromRow - i);
					aField = stringToField.get(aString);
					piece = board.get(aField);
					if (piece != null) return false;
				}
				return true;
			}
			else if (columnGap < 0) { //top-left
				for (int i = 1; i < columnGap*(-1); i++) {
					aString = Column.values()[fromColumn - i - 1].toString() + (fromRow + i);
					aField = stringToField.get(aString);
					piece = board.get(aField);
					if (piece != null) return false;
				}
				return true;
			}
		}
		return false;
	}
	
	public static boolean enPassant(Field from, Field to, Map<Field, ChessPiece> board, MoveHistory history) {
		int historySize = history.getHistory().size();
		if (historySize > 0) {
			Move previousMove = history.getHistory().get(historySize - 1);
			ChessPiece historyPiece = previousMove.getPiece(); 
			ChessPiece piece = board.get(from);
			int fromColumn = from.getColumn().getId();
			int fromRow = from.getRow();
			int toColumn = to.getColumn().getId();
			int toRow = to.getRow();
			PlayerColor fromColor = piece.getColor();
			if (historyPiece.getName() == "Pawn" && piece.getName() == "Pawn" 
					&& previousMove.getTo().getColumn() == to.getColumn() 
					&& previousMove.getTo().getRow() == from.getRow()
					&& (toColumn == fromColumn + 1 || toColumn == fromColumn - 1)) {
				if (fromColor == PlayerColor.WHITE && toRow == fromRow + 1 
						&& previousMove.getFrom().getRow() == fromRow + 2) return true;
				else if (fromColor == PlayerColor.BLACK && toRow == fromRow - 1 
						&& previousMove.getFrom().getRow() == fromRow - 2) return true;
			}
		}
		return false; //TODO nie usuwa przeciwnego pionka
	}
	
	public static boolean forwardDiagonallyCapturing(Field from, Field to, Map<Field, ChessPiece> board) {
		int fromColumn = from.getColumn().getId();
		int fromRow = from.getRow();
		int toColumn = to.getColumn().getId();
		int toRow = to.getRow();	
		ChessPiece piece = board.get(from);
		ChessPiece destinationPiece = board.get(to);
		PlayerColor fromColor = piece.getColor();
		PlayerColor toColor = null;
		if (destinationPiece != null) {
			toColor = destinationPiece.getColor();
			if (toColor != fromColor && (toColumn == fromColumn + 1 || toColumn == fromColumn - 1)) {
				if (fromColor == PlayerColor.WHITE && toRow == fromRow + 1) return true;
				else if (fromColor == PlayerColor.BLACK && toRow == fromRow - 1) return true;
			}	
		}
		return false;
	}
	
	public static boolean forwardOnceWithoutCapturing(Field from, Field to, Map<Field, ChessPiece> board) {
		int fromColumn = from.getColumn().getId();
		int fromRow = from.getRow();
		int toColumn = to.getColumn().getId();
		int toRow = to.getRow();	
		ChessPiece piece = board.get(from);
		ChessPiece destinationPiece = board.get(to);
		if (destinationPiece == null && toColumn == fromColumn) {
			if (piece.getColor() == PlayerColor.WHITE && toRow == fromRow +1) return true;
			else if (piece.getColor() == PlayerColor.BLACK && toRow == fromRow - 1) return true;
		}
		return false;
	}
	
	public static boolean forwardTwiceWithoutCapturing(Field from, Field to, Map<Field, ChessPiece> board) {
		int fromColumn = from.getColumn().getId();
		int fromRow = from.getRow();
		int toColumn = to.getColumn().getId();
		int toRow = to.getRow();
		ChessPiece piece = board.get(from);
		ChessPiece destinationPiece = board.get(to);
		if (destinationPiece == null && toColumn == fromColumn) {
			if (piece.getColor() == PlayerColor.WHITE && fromRow == 2 && toRow == 4) return true;
			else if (piece.getColor() == PlayerColor.BLACK && fromRow == 7 && toRow == 5) return true;
		}
		return false;
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
		int columnGap = toColumn - fromColumn;
		int rowGap = toRow - fromRow;
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
