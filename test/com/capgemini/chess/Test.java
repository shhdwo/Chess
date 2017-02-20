package com.capgemini.chess;

public class Test {

	public static void main(String[] args) {
		
		Game simulation = new Game();
		simulation.initialize();
		simulation.showBoard();
		
		//simulate moves:		
		simulation.move("B1", "B3");
		simulation.showBoard();
		
		simulation.move("B1", "C3");
		simulation.showBoard();
		
		simulation.move("C3", "D5");
		simulation.showBoard();
		
		simulation.move("D5", "E7");
		simulation.showBoard();
		
		simulation.move("G1", "F3");
		simulation.showBoard();
		
		simulation.move("F3", "E1");
		simulation.showBoard();
		
		simulation.move("D7", "D5");
		simulation.showBoard();
		
		simulation.move("C3", "B5");
		simulation.showBoard();
		
		simulation.move("G8", "G6");
		simulation.showBoard();
		
		simulation.move("G8", "F6");
		simulation.showBoard();
		
		simulation.move("B5", "C7");
		simulation.showBoard();
		
		simulation.move("F6", "D5");
		simulation.showBoard();
		
		simulation.move("E8", "D7");
		simulation.showBoard();
		
		simulation.move("A2", "A4");
		simulation.showBoard();
		
		simulation.move("A2", "A4");
		simulation.showBoard();
		
		simulation.move("A7", "A6");
		simulation.showBoard();
		
		simulation.move("A1", "A3");
		simulation.showBoard();
		
		simulation.move("A8", "A7");
		simulation.showBoard();
		
		simulation.move("C7", "A6");
		simulation.showBoard();
		
		simulation.move("A7", "A6");
		simulation.showBoard();
		
		simulation.move("A3", "G3");
		simulation.showBoard();
		
		simulation.showHistory();

	}

}
