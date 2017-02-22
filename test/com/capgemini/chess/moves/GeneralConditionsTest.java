package com.capgemini.chess.moves;

import java.util.Map;

import org.junit.Test;

import com.capgemini.chess.Board;
import com.capgemini.chess.Field;
import com.capgemini.chess.figures.ChessPiece;
import com.capgemini.chess.figures.PlayerColor;
import com.capgemini.exception.*;

public class GeneralConditionsTest {
	
	@Test(expected = FieldDoesntExistException.class)
	public void shouldThrowExceptionWhenTryingToMoveToOutsideBoard() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		aBoard.makeInitSetup();
		aBoard.fillUpBoard(aBoard.getInitSetup());
		Field from = aBoard.getFieldFromString("A2");
		Field to = aBoard.getFieldFromString("A9");
		Map<Field, ChessPiece> board = aBoard.getBoard();
		PlayerColor turn = PlayerColor.WHITE;
		//when
		GeneralConditions.areMet(from, to, board, turn);
		//then
	}
	
	@Test(expected = FieldDoesntExistException.class)
	public void shouldThrowExceptionWhenTryingToMoveFromOutsideBoard() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		aBoard.makeInitSetup();
		aBoard.fillUpBoard(aBoard.getInitSetup());
		Field from = aBoard.getFieldFromString("A9");
		Field to = aBoard.getFieldFromString("A2");
		Map<Field, ChessPiece> board = aBoard.getBoard();
		PlayerColor turn = PlayerColor.WHITE;
		//when
		GeneralConditions.areMet(from, to, board, turn);
		//then
	}
	
	@Test(expected = OccupiedByFriendException.class)
	public void shouldThrowExceptionWhenTryingToMoveToFieldOccupiedByFriend() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		aBoard.makeInitSetup();
		aBoard.fillUpBoard(aBoard.getInitSetup());
		Field from = aBoard.getFieldFromString("A1");
		Field to = aBoard.getFieldFromString("A2");
		Map<Field, ChessPiece> board = aBoard.getBoard();
		PlayerColor turn = PlayerColor.WHITE;
		//when
		GeneralConditions.areMet(from, to, board, turn);
		//then
	}
	
	@Test(expected = OppositePlayerTurnException.class)
	public void shouldThrowExceptioneWhenTryingToMoveWhileOpponentTurn() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		aBoard.makeInitSetup();
		aBoard.fillUpBoard(aBoard.getInitSetup());
		Field from = aBoard.getFieldFromString("A7");
		Field to = aBoard.getFieldFromString("A6");
		Map<Field, ChessPiece> board = aBoard.getBoard();
		PlayerColor turn = PlayerColor.WHITE;
		//when
		GeneralConditions.areMet(from, to, board, turn);
		//then
	}
}
