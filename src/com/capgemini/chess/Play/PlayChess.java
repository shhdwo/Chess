package com.capgemini.chess.Play;

import com.capgemini.chess.Chess;
import com.capgemini.chess.Game;
import java.util.Scanner;

public class PlayChess {

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
		String from = "";
		String to = "";
		do {
			System.out.println("Z jakiego pola przeniesc figure?");
			from = in.nextLine();
			if (from.equals("exit")) break;
			System.out.println("Na jakie pole?");
			to = in.nextLine();
			System.out.println("\n");
			simulation.move(from, to);
			System.out.println("\nHistoria ruchow:");
			simulation.showHistory();
			System.out.println("\n\n\n");
			simulation.showBoard();
		} while (true);
	}

}
