package com.capgemini.chess.moves;

import com.capgemini.chess.figures.*;
import com.capgemini.chess.*;
import java.util.Map;

public class GeneralConditions {
	
	public static boolean areMet(Field from, Field to, Map<Field, ChessPiece> board) {
		if (!fromFieldExists(from, board) || !toFieldExists(to, board)) {
			throw new IllegalStateException("That field does not exist!\n");
		}
		else if (!isActualTurnPlayer()) {
			throw new IllegalStateException("It's opposite player turn!\n");
		}
		else if (isDestinationOccupiedByFriend(from, to, board)) {
			throw new IllegalStateException("Moving to location occupied by friend is forbidden!\n");
		}
		else return true;
	}
	
	private static boolean isDestinationOccupiedByFriend(Field from, Field to, Map<Field, ChessPiece> board) {
		PlayerColor fromColor = board.get(from).getColor();
		PlayerColor toColor = null;
		ChessPiece destinationPiece = board.get(to);
		if (destinationPiece != null) toColor = destinationPiece.getColor();
		if (fromColor == toColor) return true;
		else return false;
	}
	
	private static boolean fromFieldExists(Field from, Map<Field, ChessPiece> board) {
		if (board.containsKey(from)) return true;
		else return false;
	}
	
	private static boolean toFieldExists(Field to, Map<Field, ChessPiece> board) {
		if (board.containsKey(to)) return true;
		else return false;
	}
	
	private static boolean isActualTurnPlayer() {
		return true; //TODO actual player turn
	}

}
