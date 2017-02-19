package com.capgemini.chess;

import com.capgemini.chess.events.Check;
import com.capgemini.chess.events.Checkmate;
import com.capgemini.chess.figures.*;

public class Game implements Chess {
	
	private Board aBoard = new Board();

	//initializes board with pieces
	public void initialize() {
		aBoard.initializeEmptyBoard();
		aBoard.makeInitSetup();
		aBoard.fillUpBoard(aBoard.getInitSetup());
	}
	
	//perform a move
	public void move(String from, String to) {
		aBoard.movePiece(from, to);
	}
	
	//writes out current state of board
	public void showBoard() {
		for (int aRow = 8; aRow >= 1; aRow--) {
			for (Column aColumn : Column.values()) {
				String positionString = aColumn.toString() + aRow;
				Field aField = aBoard.getFieldFromString(positionString);
				ChessPiece piece = aBoard.getBoard().get(aField);
				System.out.printf("%3s %6s %9s", positionString, seeName(piece), seeColor(piece));
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//checks if game end conditions are fulfilled
	public boolean isFinished() {
		if (Checkmate.isCheckmate(aBoard.getBoard(), PlayerColor.WHITE)) return true;
		else if (Checkmate.isCheckmate(aBoard.getBoard(), PlayerColor.BLACK)) return true;
		else return false;
	}
	
	//checks if game is in state of check
	public boolean isCheck() {
		if (Check.isPlayerChecked(aBoard.getBoard(), PlayerColor.WHITE)) return true;
		else if (Check.isPlayerChecked(aBoard.getBoard(), PlayerColor.BLACK)) return true;
		else return false;
	}
	
	private String seeColor(ChessPiece piece) {
		String color = "";
		if (piece != null) {
			if (piece.getColor() == PlayerColor.WHITE) {
				color = " of WHITE";
			}
			else if (piece.getColor() == PlayerColor.BLACK) {
				color = " of BLACK";
			}
			return color;
		}
		else return color = "";
	}
	
	private String seeName(ChessPiece piece) {
		String name = "";
		if (piece != null) {
			name = piece.getName();
		}
		return name;
	}


}
