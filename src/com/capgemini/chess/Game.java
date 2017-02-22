package com.capgemini.chess;

import com.capgemini.chess.events.Checkmate;
import com.capgemini.chess.figures.*;
import com.capgemini.chess.moves.*;
import java.util.List;

public class Game implements Chess {
	
	private Board aBoard = new Board();

	//initializes board with pieces
	public void initialize() {
		aBoard.initializeEmptyBoard();
		aBoard.makeInitSetup();
		aBoard.fillUpBoard(aBoard.getInitSetup());
	}
	
	//perform a move
	public void move(String from, String to) {
		aBoard.movePiece(from, to);
	}
	
	//writes out current state of board
	public void showBoard() {
		for (int aRow = 8; aRow >= 1; aRow--) {
			for (Column aColumn : Column.values()) {
				String positionString = aColumn.toString() + aRow;
				Field aField = aBoard.getFieldFromString(positionString);
				ChessPiece piece = aBoard.getBoard().get(aField);
				System.out.printf("%3s %15s", positionString, seeName(piece));
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//writes out move history
	public void showHistory() {
		List<Move> history = aBoard.getMoveHistory().getHistory();
		for (Move aMove : history) {
			System.out.println(aMove.toString());
		}
	}
	
	//checks if game end conditions are fulfilled
	public boolean isFinished() {
		if (Checkmate.isCheckmate(aBoard)) return true;
		else return false;
	}
	
	private String seeName(ChessPiece piece) {
		String name = "";
		if (piece != null) {
			name = piece.getFullName();
		}
		return name;
	}

}
