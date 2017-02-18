package com.capgemini.chess;

import com.capgemini.chess.figures.*;

public class Game implements Chess {
	
	private Board aBoard = new Board();

	//initializes board with figures(pieces)
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
				Field aField = aBoard.getField(positionString);
				ChessPiece piece = aBoard.getBoard().get(aField);
				System.out.printf("%3s %6s %6s", positionString, checkName(piece), checkColor(piece));
			}
			System.out.println();
		}
	}
	
	//checks if game end conditions are fulfilled
	public boolean isFinished() {
		return false;
	}
	
	//checks if game is in state of check
	public boolean isCheck() {
		return false;
	}
	
	private String checkColor(ChessPiece piece) {
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
	
	private String checkName(ChessPiece piece) {
		String name = "";
		if (piece != null) {
			name = piece.getName();
		}
		return name;
	}

}
