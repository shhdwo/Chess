package com.capgemini.chess;

public interface Chess {
	
	//initializes board with pieces
	void initialize();
	
	//perform a move
	void move(String from, String to);
	
	//writes out to console current state of board
	void showBoard();
	
	//writes out move history
	public void showHistory();
	
}
