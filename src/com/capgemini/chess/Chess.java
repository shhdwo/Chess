package com.capgemini.chess;

public interface Chess {
	
	//initializes board with figures(pieces)
	void initialize();
	
	//perform a move
	void move();
	
	//writes out current state of board
	void showBoard();
	
	//checks if game end conditions are fulfilled
	boolean isFinished();
	
	//checks if game is in state of check
	boolean isCheck();
	
}
