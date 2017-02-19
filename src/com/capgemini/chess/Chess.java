package com.capgemini.chess;

public interface Chess {
	
	//initializes board with pieces
	void initialize();
	
	//perform a move
	void move(String from, String to);
	
	//writes out to console current state of board
	void showBoard();
	
	//checks if game end conditions are fulfilled
	boolean isFinished();
	
	//checks if game is in state of check
	boolean isCheck();
	
}
