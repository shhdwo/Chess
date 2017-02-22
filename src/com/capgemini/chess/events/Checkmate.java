package com.capgemini.chess.events;

import com.capgemini.chess.Board;

public class Checkmate {

	public static boolean isCheckmate(Board aBoard) {
		return false; 
//		Map<Field, ChessPiece> board = aBoard.getBoard();
//		for (Field from : board.keySet()) {
//			if (isPossible(aBoard, from)) return false;
//		}
//		return true;
	}
	
//	private static boolean isPossible(Board aBoard, Field from) {
//		
//		Map<Field, ChessPiece> board = aBoard.getBoard();
//		PlayerColor actualPlayerTurn = aBoard.getActualPlayerTurn();
//		ChessPiece piece = board.get(from);
//		if (piece != null && piece.getColor() == actualPlayerTurn) {
//			for (Field to : board.keySet()) {
//				try {
//					simulateMove(aBoard, from, to);
//				}
//				catch (IllegalStateException e) {
//					return false;
//				}
//			}
//		}		
//		return true;
//	}
//	
//	private static boolean simulateMove(Board aBoard, Field from, Field to) {
//		Map<Field, ChessPiece> board = aBoard.getBoard();
//		Map<String, Field> stringToField = aBoard.getStringToFieldMap();
//		MoveHistory history = aBoard.getMoveHistory();
//		ChessPiece piece = board.get(from);
//		if(piece.isMovePossible(from, to, board, stringToField, history)) {
//			int historySizeBefore = aBoard.getMoveHistory().getHistory().size();
//			aBoard.movePiece(from.getPosition(), to.getPosition());
//			int historySizeAfter = aBoard.getMoveHistory().getHistory().size();
//			if (historySizeBefore == historySizeAfter) return false;
//			else {
//				//TODO cofanie symulowanego ruchu
//				return true;
//			}
//		}
//		else return false;
//	}

}
