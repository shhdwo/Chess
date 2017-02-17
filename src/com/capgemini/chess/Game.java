package com.capgemini.chess;

import com.capgemini.chess.figures.PlayerColor;

public class Game implements Chess {
	
	private Board aBoard = new Board();

	//initializes board with figures(pieces)
	public void initialize() {
		aBoard.initializeEmptyBoard();
		aBoard.makeInitSetup();
		aBoard.fillUpBoard(aBoard.getInitSetup());
	}
	
	//perform a move
	public void move() {
		
	}
	
	//writes out current state of board
	public void showBoard() {
		for (Field f : aBoard.getBoard()) {
			String occupant = "";
			String color = "";
			if (f.getOccupant() != null) {
				occupant = f.getOccupant().getName();
				if (f.getOccupant().getColor() == PlayerColor.WHITE) {
					color = " of WHITE";
				}
				else if (f.getOccupant().getColor() == PlayerColor.BLACK) {
					color = " of BLACK";
				}
			}
			System.out.println(f.getPosition() + " " + occupant + color);
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
