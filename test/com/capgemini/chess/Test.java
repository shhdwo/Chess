package com.capgemini.chess;

public class Test {

	public static void main(String[] args) {
		
		Game aGame = new Game();
		aGame.initialize();
		aGame.showBoard();
		
		//simulate moves:		
		aGame.move("B1", "B3");
		aGame.showBoard();
		
		aGame.move("B1", "C3");
		aGame.showBoard();
		
		aGame.move("C3", "D5");
		aGame.showBoard();
		
		aGame.move("D5", "E7");
		aGame.showBoard();
		
		aGame.move("G1", "F3");
		aGame.showBoard();
		
		aGame.move("F3", "E1");
		aGame.showBoard();
		
		aGame.showHistory();

	}

}
