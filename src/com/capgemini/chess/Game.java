package com.capgemini.chess;

import com.capgemini.chess.figures.*;
import com.capgemini.chess.moves.*;

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
		if (GeneralConditions.areMet(from, to)) {
			
		}
	}
	
	//writes out current state of board
	public void showBoard() {
		for (int aRow = 8; aRow >= 1; aRow--) {
			for (Column aColumn : Column.values()) {
				String position = aColumn.toString() + aRow;
				ChessPiece occupant = aBoard.getBoard().get(position);
				String color = "";
				String name = "";
				if (occupant != null) {
					name = occupant.getName();
					if (occupant.getColor() == PlayerColor.WHITE) {
						color = " of WHITE";
					}
					else if (occupant.getColor() == PlayerColor.BLACK) {
						color = " of BLACK";
					}
				}
				System.out.printf("%3s %6s %6s", position, name, color);
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

}
