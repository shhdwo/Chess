package com.capgemini.chess;

public class Test {

	public static void main(String[] args) {
		
		Game simulation = new Game();
		simulation.initialize();
		simulation.showBoard();
		
		//simulate moves:		
		simulation.move("B2", "B3");
		simulation.showBoard();
		
		simulation.move("C7", "C5");
		simulation.showBoard();
		
		simulation.move("B3", "B4");
		simulation.showBoard();
		
		simulation.move("C5", "C4");
		simulation.showBoard();
		
		simulation.move("D2", "D4");
		simulation.showBoard();
		
		simulation.move("C4", "D3");
		simulation.showBoard();
		
		
		simulation.showHistory();

	}

}
