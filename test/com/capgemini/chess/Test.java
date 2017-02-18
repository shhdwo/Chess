package com.capgemini.chess;

public class Test {

	public static void main(String[] args) {
		
		Game aGame = new Game();
		aGame.initialize();
		aGame.showBoard();
		aGame.move("A7", "A6");
		System.out.println();
		aGame.showBoard();
		aGame.move("B7", "C7");
		System.out.println();
		aGame.showBoard();
		
		System.out.println(Column.values()[2]);

	}

}
