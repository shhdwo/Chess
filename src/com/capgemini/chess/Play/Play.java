package com.capgemini.chess.Play;

import com.capgemini.chess.Chess;
import com.capgemini.chess.Game;
import java.util.Scanner;

public class Play {

	public static void main(String[] args) {
		
		Chess simulation = new Game();
		Scanner in = new Scanner(System.in);
		
		simulation.initialize();
		simulation.showBoard();
		
		//game loop	
		try {
			gameLoop(simulation, in);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace(System.out);
		}
		finally {
			in.close();
			System.out.println("Rozgrywka zakonczona");
		}

	}
	
	private static void gameLoop(Chess simulation, Scanner in) {
		do {
			System.out.println("Z jakiego pola przeniesc figure?");
			String from = in.nextLine();
			System.out.println("Na jakie pole?");
			String to = in.nextLine();
			System.out.println("\n");
			simulation.move(from, to);
			System.out.println("\nHistoria ruchow:");
			simulation.showHistory();
			System.out.println("\n\n\n");
			simulation.showBoard();
		} while (!simulation.isFinished()); //TODO never finishes (checkmate to be implemented)
	}

}
