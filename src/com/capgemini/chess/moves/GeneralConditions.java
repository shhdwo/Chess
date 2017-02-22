package com.capgemini.chess.moves;

import com.capgemini.chess.figures.*;
import com.capgemini.chess.*;
import java.util.Map;
import com.capgemini.exception.*;

public class GeneralConditions {
	
	public static boolean areMet(Field from, Field to, Map<Field, ChessPiece> board, PlayerColor turn) {
		if (!fromFieldExists(from, board) || !toFieldExists(to, board)) {
			throw new FieldDoesntExistException("That field does not exist!\n");
		}
		else if (!isActualPlayerPiece(from, board, turn)) {
			throw new OppositePlayerTurnException("It's opposite player turn!\n");
		}
		else if (isDestinationOccupiedByFriend(from, to, board)) {
			throw new OccupiedByFriendException("Moving to location occupied by friend is forbidden!\n");
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
	
	private static boolean isActualPlayerPiece(Field from, Map<Field, ChessPiece> board, PlayerColor turn) {
		ChessPiece piece = board.get(from);
		if (piece == null) throw new NoPieceToMoveException("There is no Piece to move!\n");
		else {
			PlayerColor pieceColor = piece.getColor();
			if (pieceColor == turn) return true;
			else return false;
		}
	}

}
