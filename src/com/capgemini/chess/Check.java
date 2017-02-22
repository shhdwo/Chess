package com.capgemini.chess;

import java.util.Map;

import com.capgemini.chess.figures.*;
import com.capgemini.chess.moves.*;

public class Check {
	
	public static boolean isPlayerChecked(Map<Field, ChessPiece> board, Map<String, Field> stringToField, MoveHistory history, Field kingLocation) {
		
		ChessPiece king = board.get(kingLocation);
		PlayerColor kingColor = king.getColor();
		for (Field f : board.keySet()) {
			if(isKillingTheKing(board, stringToField, history, kingLocation, kingColor, f)) return true;
		}
		return false;
	}

	public static boolean isKillingTheKing(Map<Field, ChessPiece> board, Map<String, Field> stringToField, MoveHistory history, Field kingLocation, PlayerColor kingColor, Field f) {
		try {
			ChessPiece piece = board.get(f);
			if (piece != null && piece.getColor() != kingColor 
					&& piece.isMovePossible(f, kingLocation, board, stringToField, history)) return true;
			else return false;
			}
		catch (IllegalStateException e) {
			return false;
		}
	}
}
